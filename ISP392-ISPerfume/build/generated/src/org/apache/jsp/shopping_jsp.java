package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shopping_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_value_type_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.release();
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
      out.write("        <link href=\"css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"css/bootstrap.min2.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            .text-container {\r\n");
      out.write("                max-height: 50px; \r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("                transition: max-height 0.5s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .text-container.expanded {\r\n");
      out.write("                max-height: 500px; \r\n");
      out.write("            }\r\n");
      out.write("            #toggle-btn {\r\n");
      out.write("                transition: transform 0.3s ease; \r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #toggle-btn.expanded {\r\n");
      out.write("                transform: rotate(180deg);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Topbar Start -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row bg-secondary py-1 px-xl-5\">\r\n");
      out.write("                <div class=\"col-lg-6 d-none d-lg-block\">\r\n");
      out.write("                    <div class=\"d-inline-flex align-items-center h-100\">\r\n");
      out.write("                        <a class=\"text-body mr-3\" href=\"MGR_Dashboard.jsp\">MANAGER</a>\r\n");
      out.write("                        <a class=\"text-body mr-3\" href=\"\">Contact</a>\r\n");
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
      out.write("                                <a class=\"dropdown-item btn\" type=\"button\" href=\"signup.jsp\">Sign up</a>\r\n");
      out.write("                                <a class=\"dropdown-item btn\" type=\"button\" href=\"MainController?action=Signout\">Sign out</a>                                \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>                                            \r\n");
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
      out.write("                                        <button name=\"action\" value=\"SeacrhProduct\" type=\"submit\" class=\"btn btn-block\" style=\"padding: 0\"><i class=\"fa fa-search\"></i></button>\r\n");
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
      out.write("        <!-- Navbar Start -->\r\n");
      out.write("        <div class=\"container-fluid bg-dark mb-30\">\r\n");
      out.write("            <div class=\"row px-xl-5\">\r\n");
      out.write("                <div class=\"col-lg-3 d-none d-lg-block\">\r\n");
      out.write("                    <a class=\"btn d-flex align-items-center justify-content-between bg-primary w-100\" data-toggle=\"collapse\" href=\"#navbar-vertical\" style=\"height: 65px; padding: 0 30px;\">\r\n");
      out.write("                        <h6 class=\"text-dark m-0\"><i class=\"fa fa-bars mr-2\"></i>Categories</h6>\r\n");
      out.write("                        <i class=\"fa fa-angle-down text-dark\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <nav class=\"collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light\" id=\"navbar-vertical\" style=\"width: calc(100% - 30px); z-index: 999;\">\r\n");
      out.write("                        <div class=\"navbar-nav w-100\">\r\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("                                \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-9\">\r\n");
      out.write("                    <nav class=\"navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0\">\r\n");
      out.write("                        <a href=\"\" class=\"text-decoration-none d-block d-lg-none\">\r\n");
      out.write("                            <span class=\"h1 text-uppercase text-dark bg-light px-2\">Multi</span>\r\n");
      out.write("                            <span class=\"h1 text-uppercase text-light bg-primary px-2 ml-n1\">Shop</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\r\n");
      out.write("                            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <div class=\"collapse navbar-collapse justify-content-between\" id=\"navbarCollapse\">\r\n");
      out.write("                            <div class=\"navbar-nav mr-auto py-0\">\r\n");
      out.write("                                <a href=\"home.jsp\" class=\"nav-item nav-link \">Home</a>\r\n");
      out.write("                                <a href=\"shopping.jsp\" class=\"nav-item nav-link active\">Shop</a>\r\n");
      out.write("                                <a href=\"productDetail.jsp\" class=\"nav-item nav-link\">Shop Detail</a>\r\n");
      out.write("                                <div class=\"nav-item dropdown\">\r\n");
      out.write("                                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Pages <i class=\"fa fa-angle-down mt-1\"></i></a>\r\n");
      out.write("                                    <div class=\"dropdown-menu bg-primary rounded-0 border-0 m-0\">\r\n");
      out.write("                                        <a href=\"cart.jsp\" class=\"dropdown-item\">Shopping Cart</a>\r\n");
      out.write("                                        <a href=\"checkout.jsp\" class=\"dropdown-item\">Checkout</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <a href=\"blog.jsp\" class=\"nav-item nav-link\">Blog</a>\r\n");
      out.write("                                <a href=\"orderStatus.jsp\" class=\"nav-item nav-link\">Order Status</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"navbar-nav ml-auto py-0 d-none d-lg-block\">                            \r\n");
      out.write("                                <a href=\"cart.jsp\" class=\"btn px-0 ml-3\">\r\n");
      out.write("                                    <i class=\"fas fa-shopping-cart text-primary\"></i>\r\n");
      out.write("                                    <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">0</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Breadcrumb Start -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row px-xl-5\">\r\n");
      out.write("                <div class=\"col-12\">\r\n");
      out.write("                    <nav class=\"breadcrumb bg-light mb-30\">\r\n");
      out.write("                        <a class=\"breadcrumb-item text-dark\" href=\"MainController?action=HomeController\">Home</a>\r\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Breadcrumb End -->\r\n");
      out.write("\r\n");
      out.write("        <!--Banner Start-->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row px-xl-5 mb-5\">\r\n");
      out.write("                <div class=\"col-lg-12 bg-transparent\">\r\n");
      out.write("                    <div class=\"justify-content-center align-content-center d-flex\">\r\n");
      out.write("                        <img src=\"https://file.hstatic.net/1000340570/article/gucci-banner_c59f167049a347b18b67abacf37d71b8.jpg\" style=\"width: auto; height: 490px;\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-12 bg-transparent\">\r\n");
      out.write("                    <div class=\"description-box bg-transparent p-4\">\r\n");
      out.write("                        <div class=\"description-header d-flex justify-content-center align-items-center\">\r\n");
      out.write("                            <img id=\"toggle-btn\" class=\"icon-down-black\" src=\"//theme.hstatic.net/1000340570/1000964732/14/icon-down-black.svg?v=6179\" style=\"cursor: pointer;\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"description-content\" class=\"mt-2 text-container bg-transparent\">\r\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, \r\n");
      out.write("                                consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("                                consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("                                consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("                                consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("                                consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("                                consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vel iLorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n");
      out.write("                                Vestibulum tincidunt est vel ipsum consectetur, sit amet vehicula magna gravida. Phasellus aliquet nisi non nisl accumsan, a posuere erat venenatis. Cras in orci est. Ut vulputate semper magna, eget tempus eros dapibus non.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--Banner End-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Shop Start -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row px-xl-5\">\r\n");
      out.write("                <!-- Shop Sidebar Start -->\r\n");
      out.write("                <div class=\"col-lg-3 col-md-4\">\r\n");
      out.write("                    <!-- Filter By Brand Start -->\r\n");
      out.write("                    <h5 class=\"section-title position-relative text-uppercase mb-3\"><span class=\"bg-secondary pr-3\">Filter By Brand</span></h5>\r\n");
      out.write("                    <div class=\"bg-light p-4 mb-30\"><!--category-productsr-->\r\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!--/category-products-->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Filter By Size Start -->\r\n");
      out.write("                    <h5 class=\"section-title position-relative text-uppercase mb-3\"><span class=\"bg-secondary pr-3\">Filter by size</span></h5>\r\n");
      out.write("                    <div class=\"bg-light p-4 mb-30\">\r\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- Filter By Size End -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Shop Sidebar End -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Shop Product Start -->\r\n");
      out.write("                <div class=\"col-lg-9 col-md-8\">\r\n");
      out.write("                    <div class=\"row pb-3\">\r\n");
      out.write("                        <div class=\"col-12 pb-1\">\r\n");
      out.write("                            <div class=\"d-flex align-items-center justify-content-between mb-4\">\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <button class=\"btn btn-sm btn-light\"><i class=\"fa fa-th-large\"></i></button>\r\n");
      out.write("                                    <button class=\"btn btn-sm btn-light ml-2\"><i class=\"fa fa-bars\"></i></button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"ml-2\">\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">Sorting</button>\r\n");
      out.write("                                        <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                            <a class=\"dropdown-item\" href=\"MainController?action=DescendingSortByPrice\">Descending Price</a>\r\n");
      out.write("                                            <a class=\"dropdown-item\" href=\"MainController?action=AscendingSortByPrice\">Ascending price</a>\r\n");
      out.write("                                            <a class=\"dropdown-item\" href=\"MainController?action=SortByPurchasing\">Best Seller</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"btn-group ml-2\">\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">Showing</button>\r\n");
      out.write("                                        <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                            <a class=\"dropdown-item\" href=\"#\">10</a>\r\n");
      out.write("                                            <a class=\"dropdown-item\" href=\"#\">20</a>\r\n");
      out.write("                                            <a class=\"dropdown-item\" href=\"#\">30</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Shop Product End -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Shop End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer Start -->\r\n");
      out.write("        <div class=\"container-fluid bg-dark text-secondary mt-5 pt-5\">\r\n");
      out.write("            <div class=\"row px-xl-5 pt-5\">\r\n");
      out.write("                <div class=\"col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5\">\r\n");
      out.write("                    <h5 class=\"text-secondary text-uppercase mb-4\">Get In Touch</h5>\r\n");
      out.write("                    <p class=\"mb-4\">No dolore ipsum accusam no lorem. Invidunt sed clita kasd clita et et dolor sed dolor. Rebum tempor no vero est magna amet no</p>\r\n");
      out.write("                    <p class=\"mb-2\"><i class=\"fa fa-map-marker-alt text-primary mr-3\"></i>123 Street, New York, USA</p>\r\n");
      out.write("                    <p class=\"mb-2\"><i class=\"fa fa-envelope text-primary mr-3\"></i>info@example.com</p>\r\n");
      out.write("                    <p class=\"mb-0\"><i class=\"fa fa-phone-alt text-primary mr-3\"></i>+012 345 67890</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-8 col-md-12\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-4 mb-5\">\r\n");
      out.write("                            <h5 class=\"text-secondary text-uppercase mb-4\">Quick Shop</h5>\r\n");
      out.write("                            <div class=\"d-flex flex-column justify-content-start\">\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Home</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Our Shop</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Shop Detail</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Shopping Cart</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Checkout</a>\r\n");
      out.write("                                <a class=\"text-secondary\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Contact Us</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-4 mb-5\">\r\n");
      out.write("                            <h5 class=\"text-secondary text-uppercase mb-4\">My Account</h5>\r\n");
      out.write("                            <div class=\"d-flex flex-column justify-content-start\">\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Home</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Our Shop</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Shop Detail</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Shopping Cart</a>\r\n");
      out.write("                                <a class=\"text-secondary mb-2\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Checkout</a>\r\n");
      out.write("                                <a class=\"text-secondary\" href=\"#\"><i class=\"fa fa-angle-right mr-2\"></i>Contact Us</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-4 mb-5\">\r\n");
      out.write("                            <h5 class=\"text-secondary text-uppercase mb-4\">Newsletter</h5>\r\n");
      out.write("                            <p>Duo stet tempor ipsum sit amet magna ipsum tempor est</p>\r\n");
      out.write("                            <form action=\"\">\r\n");
      out.write("                                <div class=\"input-group\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Your Email Address\">\r\n");
      out.write("                                    <div class=\"input-group-append\">\r\n");
      out.write("                                        <button class=\"btn btn-primary\">Sign Up</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <h6 class=\"text-secondary text-uppercase mt-4 mb-3\">Follow Us</h6>\r\n");
      out.write("                            <div class=\"d-flex\">\r\n");
      out.write("                                <a class=\"btn btn-primary btn-square mr-2\" href=\"#\"><i class=\"fab fa-twitter\"></i></a>\r\n");
      out.write("                                <a class=\"btn btn-primary btn-square mr-2\" href=\"#\"><i class=\"fab fa-facebook-f\"></i></a>\r\n");
      out.write("                                <a class=\"btn btn-primary btn-square mr-2\" href=\"#\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n");
      out.write("                                <a class=\"btn btn-primary btn-square\" href=\"#\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row border-top mx-xl-5 py-4\" style=\"border-color: rgba(256, 256, 256, .1) !important;\">\r\n");
      out.write("                <div class=\"col-md-6 px-xl-0\">\r\n");
      out.write("                    <p class=\"mb-md-0 text-center text-md-left text-secondary\">\r\n");
      out.write("                        &copy; <a class=\"text-primary\" href=\"#\">Domain</a>. All Rights Reserved. Designed\r\n");
      out.write("                        by\r\n");
      out.write("                        <a class=\"text-primary\" href=\"https://htmlcodex.com\">HTML Codex</a>\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 px-xl-0 text-center text-md-right\">\r\n");
      out.write("                    <img class=\"img-fluid\" src=\"img/payments.png\" alt=\"\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Back to Top -->\r\n");
      out.write("        <a href=\"#\" class=\"btn btn-primary back-to-top\"><i class=\"fa fa-angle-double-up\"></i></a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- JavaScript Libraries -->\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("        <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Contact Javascript File -->\r\n");
      out.write("        <script src=\"mail/jqBootstrapValidation.min.js\"></script>\r\n");
      out.write("        <script src=\"mail/contact.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Javascript -->\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            const toggleBtn = document.getElementById(\"toggle-btn\");\r\n");
      out.write("            const descriptionContent = document.getElementById(\"description-content\");\r\n");
      out.write("\r\n");
      out.write("            toggleBtn.addEventListener(\"click\", function () {\r\n");
      out.write("                if (descriptionContent.classList.contains(\"expanded\")) {\r\n");
      out.write("                    descriptionContent.classList.remove(\"expanded\");\r\n");
      out.write("                    toggleBtn.classList.remove(\"expanded\");\r\n");
      out.write("                } else {\r\n");
      out.write("                    descriptionContent.classList.add(\"expanded\");\r\n");
      out.write("                    toggleBtn.classList.add(\"expanded\");\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("Category");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LIST_CATEGORY}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                <a href=\"MainController?action=Category&Category=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Category.categoryID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"nav-item nav-link\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Category.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("category");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LIST_CATEGORY}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${category.categoryID == requestScope.LIST_PRODUCT[0].categoryID}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <span class=\"breadcrumb-item active\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${category.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("brand");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LIST_BRAND}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            <div class=\"custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3\">\r\n");
          out.write("                                <a href=\"MainController?action=FilterByBrand&brandID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.brandID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setVar("size");
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LIST_SIZE}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            <div class=\"custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3\">\r\n");
          out.write("                                <a href=\"MainController?action=FilterBySize&sizeID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${size.sizeID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${size.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent(null);
    _jspx_th_c_forEach_4.setVar("Product");
    _jspx_th_c_forEach_4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.LIST_PRODUCT}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6 pb-1\">\r\n");
          out.write("                                <div class=\"product-item bg-light mb-4\">\r\n");
          out.write("                                    <div class=\"product-img position-relative overflow-hidden\">\r\n");
          out.write("                                        <img class=\"img-fluid w-100\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\r\n");
          out.write("                                        <div class=\"product-action\">\r\n");
          out.write("                                            <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"fa fa-shopping-cart\"></i></a>\r\n");
          out.write("                                            <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"far fa-heart\"></i></a>\r\n");
          out.write("                                            <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"fa fa-sync-alt\"></i></a>\r\n");
          out.write("                                            <a class=\"btn btn-outline-dark btn-square\" href=\"MainController?action=NavigateProductDetail&productID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&sizeID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.sizeID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"fa fa-search\"></i></a>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                    <div class=\"text-center py-4\">\r\n");
          out.write("                                        <h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.brandName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\r\n");
          out.write("                                        <a class=\"h6 text-decoration-none text-truncate\" href=\"\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.sizeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("                                        <div class=\"d-flex align-items-center justify-content-center mt-2\">\r\n");
          out.write("                                            <h5>");
          if (_jspx_meth_fmt_formatNumber_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_4, _jspx_page_context, _jspx_push_body_count_c_forEach_4))
            return true;
          out.write(" VND</h5> \r\n");
          out.write("                                        </div>\r\n");
          out.write("                                        <div class=\"d-flex align-items-center justify-content-center mb-1\">\r\n");
          out.write("                                            <small class=\"fa fa-star text-primary mr-1\"></small>\r\n");
          out.write("                                            <small class=\"fa fa-star text-primary mr-1\"></small>\r\n");
          out.write("                                            <small class=\"fa fa-star text-primary mr-1\"></small>\r\n");
          out.write("                                            <small class=\"fa fa-star text-primary mr-1\"></small>\r\n");
          out.write("                                            <small class=\"fa fa-star text-primary mr-1\"></small>\r\n");
          out.write("                                            <small>(99)</small>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                </div>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_4);
    _jspx_th_fmt_formatNumber_0.setType("number");
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Product.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }
}
