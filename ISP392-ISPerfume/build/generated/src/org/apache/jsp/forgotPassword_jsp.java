package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forgotPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>MultiShop - Online Shop Website Template</title>\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("        <meta content=\"Free HTML Templates\" name=\"keywords\">\r\n");
      out.write("        <meta content=\"Free HTML Templates\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Favicon -->\r\n");
      out.write("        <link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Web Fonts -->\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap\" rel=\"stylesheet\">  \r\n");
      out.write("\r\n");
      out.write("        <!-- Font Awesome -->\r\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Libraries Stylesheet -->\r\n");
      out.write("        <link href=\"lib/animate/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Topbar Start -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row bg-secondary py-1 px-xl-5\">\r\n");
      out.write("                <div class=\"col-lg-6 d-none d-lg-block\">\r\n");
      out.write("                    <div class=\"d-inline-flex align-items-center h-100\">\r\n");
      out.write("                        <a class=\"text-body mr-3\" href=\"MGR_Dashboard.jsp\">MANAGER</a>\r\n");
      out.write("                        <a class=\"text-body mr-3\" href=\"AD_AccountManagement.jsp\">ADMIN</a>\r\n");
      out.write("                        <a class=\"text-body mr-3\" href=\"\">Help</a>\r\n");
      out.write("                        <a class=\"text-body mr-3\" href=\"\">FAQs</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-6 text-center text-lg-right\">\r\n");
      out.write("                    <div class=\"d-inline-flex align-items-center\">\r\n");
      out.write("                        <div class=\"btn-group\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">My Account</button>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                <a class=\"dropdown-item btn\" type=\"button\" href=\"signin.jsp\">Sign in</a>\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">Sign up</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"btn-group mx-2\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">USD</button>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">EUR</button>\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">GBP</button>\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">CAD</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"btn-group\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">EN</button>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">FR</button>\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">AR</button>\r\n");
      out.write("                                <button class=\"dropdown-item\" type=\"button\">RU</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"d-inline-flex align-items-center d-block d-lg-none\">\r\n");
      out.write("                        <a href=\"\" class=\"btn px-0 ml-2\">\r\n");
      out.write("                            <i class=\"fas fa-heart text-dark\"></i>\r\n");
      out.write("                            <span class=\"badge text-dark border border-dark rounded-circle\" style=\"padding-bottom: 2px;\">0</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"\" class=\"btn px-0 ml-2\">\r\n");
      out.write("                            <i class=\"fas fa-shopping-cart text-dark\"></i>\r\n");
      out.write("                            <span class=\"badge text-dark border border-dark rounded-circle\" style=\"padding-bottom: 2px;\">0</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex\">\r\n");
      out.write("                <div class=\"col-lg-4\">\r\n");
      out.write("                    <a href=\"home.jsp\" class=\"text-decoration-none\">\r\n");
      out.write("                        <span class=\"h1 text-uppercase text-primary bg-dark px-2\">IS</span>\r\n");
      out.write("                        <span class=\"h1 text-uppercase text-dark bg-primary px-2 ml-n1\">Perfume</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-6 text-left\">\r\n");
      out.write("                    <form action=\"\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <form action=\"MainController\" method=\"POST\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search for products\" name=\"search\">\r\n");
      out.write("                                <div class=\"input-group-append\">\r\n");
      out.write("                                    <span class=\"input-group-text bg-transparent text-primary\" style=\"padding-bottom: 5px \">                                 \r\n");
      out.write("                                        <button name=\"action\" value=\"Seacrh\" type=\"submit\" class=\"btn btn-block\" style=\"padding: 0\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-4 col-6 text-right\">\r\n");
      out.write("                    <p class=\"m-0\">Customer Service</p>\r\n");
      out.write("                    <h5 class=\"m-0\">+012 345 6789</h5>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Topbar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Navbar Start -->\r\n");
      out.write("        <form action=\"MainController\">\r\n");
      out.write("            <div class=\"container-fluid bg-dark mb-30\">\r\n");
      out.write("                <div class=\"row px-xl-5\">\r\n");
      out.write("                    <div class=\"col-lg-3 d-none d-lg-block\">\r\n");
      out.write("                        <a class=\"btn d-flex align-items-center justify-content-between bg-primary w-100\" data-toggle=\"collapse\" href=\"#navbar-vertical\" style=\"height: 65px; padding: 0 30px;\">\r\n");
      out.write("                            <h6 class=\"text-dark m-0\"><i class=\"fa fa-bars mr-2\"></i>Category</h6>\r\n");
      out.write("                            <i class=\"fa fa-angle-down text-dark\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <nav class=\"collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light\" id=\"navbar-vertical\" style=\"width: calc(100% - 30px); z-index: 999;\">\r\n");
      out.write("                            <div class=\"navbar-nav w-100\">\r\n");
      out.write("                                <c:forEach var=\"Category\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LIST_CATEGORY}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                    <a href=\"MainController?action=Category&Category=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Category.categoryID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"nav-item nav-link\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Category.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("                                </c:forEach>\r\n");
      out.write("                                <!--                            <div class=\"nav-item dropdown dropright\"> \r\n");
      out.write("                                                                <a href=\"MainController?action=ViewAllBrand\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Brand <i class=\"fa fa-angle-right float-right mt-1\"></i></a>\r\n");
      out.write("                                                                <div class=\"dropdown-menu position-absolute rounded-0 border-0 m-0\">\r\n");
      out.write("                                                                    <a type=\"submit\" name=\"action\" value=\"NavigateBrand\" class=\"dropdown-item\">name</a>\r\n");
      out.write("                                                                </div>\r\n");
      out.write("                                                            </div>-->\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-9\">\r\n");
      out.write("                        <nav class=\"navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0\">\r\n");
      out.write("                            <a href=\"\" class=\"text-decoration-none d-block d-lg-none\">\r\n");
      out.write("                                <span class=\"h1 text-uppercase text-dark bg-light px-2\">Multi</span>\r\n");
      out.write("                                <span class=\"h1 text-uppercase text-light bg-primary px-2 ml-n1\">Shop</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\r\n");
      out.write("                                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <div class=\"collapse navbar-collapse justify-content-between\" id=\"navbarCollapse\">\r\n");
      out.write("                                <div class=\"navbar-nav mr-auto py-0\">\r\n");
      out.write("                                    <a href=\"home.jsp\" class=\"nav-item nav-link\">Home</a>\r\n");
      out.write("                                    <a href=\"shopping.jsp\" class=\"nav-item nav-link\">Shop</a>\r\n");
      out.write("                                    <a href=\"productDetail.jsp\" class=\"nav-item nav-link\">Shop Detail</a>\r\n");
      out.write("                                    <div class=\"nav-item dropdown\">\r\n");
      out.write("                                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Pages <i class=\"fa fa-angle-down mt-1\"></i></a>\r\n");
      out.write("                                        <div class=\"dropdown-menu bg-primary rounded-0 border-0 m-0\">\r\n");
      out.write("                                            <a href=\"cart.jsp\" class=\"dropdown-item\">Shopping Cart</a>\r\n");
      out.write("                                            <a href=\"checkout.jsp\" class=\"dropdown-item\">Checkout</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <a href=\"blog.jsp\" class=\"nav-item nav-link\">Blog</a>\r\n");
      out.write("                                    <a href=\"orderStatus.jsp\" class=\"nav-item nav-link\">Order Status</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"navbar-nav ml-auto py-0 d-none d-lg-block\">                            \r\n");
      out.write("                                    <a href=\"cart.jsp\" class=\"btn px-0 ml-3\">\r\n");
      out.write("                                        <i class=\"fas fa-shopping-cart text-primary\"></i>\r\n");
      out.write("                                        <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">0</span>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        <!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--Sigin in form Start-->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <h2 class=\"section-title position-relative text-uppercase mx-xl-5 mb-4\"><span class=\"bg-secondary pr-3\">Sign\r\n");
      out.write("                    In</span></h2>\r\n");
      out.write("            <div class=\"row px-xl-5\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-lg-12 mb-5\">\r\n");
      out.write("                    <div class=\"row h-100 align-items-center justify-content-center\">\r\n");
      out.write("                        <div class=\"col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4\">\r\n");
      out.write("                            <div class=\"bg-light rounded p-4 p-sm-5 my-4 mx-3\" style=\"padding-bottom: 15px !important; width: 455px;\">\r\n");
      out.write("                                <div class=\"d-flex align-items-center justify-content-between mb-3\">\r\n");
      out.write("                                    <h3 class=\"text-primary\"></i>Forgot Password</h3>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-floating mb-3\">\r\n");
      out.write("                                    <label for=\"floatingInput\">Email</label>\r\n");
      out.write("                                    <input type=\"email\" class=\"form-control\" id=\"floatingInput\"\r\n");
      out.write("                                           placeholder=\"Enter your email\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary py-3 w-100 mb-4\">Send email</button>\r\n");
      out.write("                                <p class=\"text-left mb-0\">Don't have an Account? <a href=\"signup.jsp\">Sign Up</a></p>\r\n");
      out.write("                                <p class=\"text-left mb-0\">Do you already have an Account? <a href=\"signup.jsp\">Sign In</a></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--Sigin in form End-->\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
