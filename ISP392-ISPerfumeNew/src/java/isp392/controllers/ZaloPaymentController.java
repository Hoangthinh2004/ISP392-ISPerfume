/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.cart.Cart;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import vn.zalopay.crypto.HMACUtil;

/**
 *
 * @author duyhc
 */
@WebServlet(name = "ZaloPaymentController", urlPatterns = {"/ZaloPaymentController"})
public class ZaloPaymentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final Map<String, String> CONFIG = new HashMap<String, String>() {
        {
            put("app_id", "2554");
            put("key1", "sdngKKJmqEMzvh5QQcdD2A9XBSKUNaYn");
            put("key2", "trMrHtvjo6myautxDUiAcYsVtaeQ8nhf");
            put("endpoint", "https://sb-openapi.zalopay.vn/v2/create");
        }
    };

    public static String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String paymentMethod = String.valueOf(1);
            String[] productDetailIDs = request.getParameterValues("productDetailIDs");
            int price = Integer.parseInt(request.getParameter("price"));
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            int promotionID = Integer.parseInt(request.getParameter("promotionID"));

            if (paymentMethod.equals("1")) {
                Random rand = new Random();
                int random_id = rand.nextInt(1000000);
                final Map embed_data = new HashMap() {
                    {
                        StringBuilder productDetailIDParams = new StringBuilder();
                        for (String id : productDetailIDs) {
                            if (productDetailIDParams.length() > 0) {
                                productDetailIDParams.append("&");
                            }
                            productDetailIDParams.append("productDetailIDs=").append(id);
                        }
                        put("redirecturl", "https://1b3e-118-69-69-189.ngrok-free.app/ISP392-ISPerfumeNew/chooseController?price=" + price + "&customerID=" + customerID + "&promotionID=" + promotionID + "&" + productDetailIDParams.toString());
                    }
                };
                final Map<String, Object>[] item = new Map[]{
                    new HashMap<String, Object>() {
                        {
                        }
                    }
                };
                Map<String, Object> order = new HashMap<String, Object>() {
                    {
                        put("app_id", CONFIG.get("app_id"));
                        put("app_trans_id", getCurrentTimeString("yyMMdd") + "_" + random_id);// thời gian và id của order
                        put("app_time", System.currentTimeMillis());
                        put("app_user", "user123");// userID
                        put("amount", price);// số tiền
                        put("description", "ISPerfume - Payment for the order #" + random_id);
                        put("bank_code", "");
                        put("redirect_url", "https://1b3e-118-69-69-189.ngrok-free.app/ISP392-ISPerfumeNew/NavigateZaloPayment");
                        put("callback_url", "https://1b3e-118-69-69-189.ngrok-free.app/ISP392-ISPerfumeNew/ZaloPayCallBackController");
                        put("item", new JSONArray(item).toString());
                        put("embed_data", new JSONObject(embed_data).toString());
                    }
                };
                // app_id +”|”+ app_trans_id +”|”+ appuser +”|”+ amount +"|" + app_time +”|”+ embed_data +"|" +item
                String data = order.get("app_id") + "|" + order.get("app_trans_id") + "|" + order.get("app_user") + "|" + order.get("amount")
                        + "|" + order.get("app_time") + "|" + order.get("embed_data") + "|" + order.get("item");
                String mac = HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, CONFIG.get("key1"), data);
                order.put("mac", mac);

                CloseableHttpClient client = HttpClients.createDefault();
                HttpPost post = new HttpPost(CONFIG.get("endpoint"));

                List<NameValuePair> params = new ArrayList<>();
                for (Map.Entry<String, Object> e : order.entrySet()) {
                    params.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
                }
                // Content-Type: application/x-www-form-urlencoded
                post.setEntity(new UrlEncodedFormEntity(params));

                CloseableHttpResponse res = client.execute(post);
                BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
                StringBuilder resultJsonStr = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    resultJsonStr.append(line);
                }
                JSONObject result = new JSONObject(resultJsonStr.toString());
                if (result.has("order_url")) {
                    String orderUrl = result.getString("order_url");
                    response.sendRedirect(orderUrl);
                } else {
                    System.out.println("Không tìm thấy order_url trong phản hồi từ API.");
                    response.getWriter().write(result.toString());
                }
            } else {
                request.getRequestDispatcher(".jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
