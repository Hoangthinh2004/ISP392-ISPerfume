package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MGR_005fCreateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>DASHMIN - Bootstrap Admin Template</title>\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("        <meta content=\"\" name=\"keywords\">\r\n");
      out.write("        <meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Favicon -->\r\n");
      out.write("        <link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Web Fonts -->\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Icon Font Stylesheet -->\r\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Libraries Stylesheet -->\r\n");
      out.write("        <link href=\"dashmin/lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"dashmin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("        <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("        <link href=\"dashmin/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Stylesheet -->\r\n");
      out.write("        <link href=\"dashmin/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container-fluid position-relative bg-white d-flex p-0\">\r\n");
      out.write("            <!-- Spinner Start -->\r\n");
      out.write("            <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\r\n");
      out.write("                <div class=\"spinner-border text-primary\" style=\"width: 3rem; height: 3rem;\" role=\"status\">\r\n");
      out.write("                    <span class=\"sr-only\">Loading...</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Spinner End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Sidebar Start -->\r\n");
      out.write("            <div class=\"sidebar pe-4 pb-3\">\r\n");
      out.write("                <nav class=\"navbar bg-light navbar-light\">\r\n");
      out.write("                    <a href=\"MGR_Dashboard.jsp\" class=\"navbar-brand mx-4 mb-3\">\r\n");
      out.write("                        <h3 class=\"text-primary\"><i class=\"fa fa-hashtag me-2\"></i>DASHMIN</h3>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"d-flex align-items-center ms-4 mb-4\">\r\n");
      out.write("                        <div class=\"position-relative\">\r\n");
      out.write("                            <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                            <div class=\"bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"ms-3\">\r\n");
      out.write("                            <h6 class=\"mb-0\">Jhon Doe</h6>\r\n");
      out.write("                            <span>Admin</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"navbar-nav w-100\">\r\n");
      out.write("                        <a href=\"MGR_Dashboard.jsp\" class=\"nav-item nav-link\"><i class=\"fa fa-tachometer-alt me-2\"></i>Dashboard</a>\r\n");
      out.write("                        <div class=\"nav-item dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle active\" data-bs-toggle=\"dropdown\"><i class=\"fa fa-laptop me-2\"></i>Management</a>\r\n");
      out.write("                            <div class=\"dropdown-menu bg-transparent border-0\">\r\n");
      out.write("                                <a href=\"MGR_ProductManagement.jsp\" class=\"dropdown-item active\">Product Management</a>\r\n");
      out.write("                                <a href=\"MGR_BrandManagement.jsp\" class=\"dropdown-item\">Brand Management</a>\r\n");
      out.write("                                <a href=\"MGR_PromotionManagement.jsp\" class=\"dropdown-item\">Promotion Management</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <a href=\"widget.html\" class=\"nav-item nav-link\"><i class=\"fa fa-th me-2\"></i>Widgets</a>\r\n");
      out.write("                        <a href=\"form.html\" class=\"nav-item nav-link\"><i class=\"fa fa-keyboard me-2\"></i>Forms</a>\r\n");
      out.write("                        <a href=\"table.html\" class=\"nav-item nav-link\"><i class=\"fa fa-table me-2\"></i>Tables</a>\r\n");
      out.write("                        <a href=\"chart.html\" class=\"nav-item nav-link\"><i class=\"fa fa-chart-bar me-2\"></i>Charts</a>\r\n");
      out.write("                        <div class=\"nav-item dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"far fa-file-alt me-2\"></i>Pages</a>\r\n");
      out.write("                            <div class=\"dropdown-menu bg-transparent border-0\">\r\n");
      out.write("                                <a href=\"signin.html\" class=\"dropdown-item\">Sign In</a>\r\n");
      out.write("                                <a href=\"signup.html\" class=\"dropdown-item\">Sign Up</a>\r\n");
      out.write("                                <a href=\"404.html\" class=\"dropdown-item\">404 Error</a>\r\n");
      out.write("                                <a href=\"blank.html\" class=\"dropdown-item\">Blank Page</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Sidebar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Content Start -->\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <!-- Navbar Start -->\r\n");
      out.write("                <nav class=\"navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0\">\r\n");
      out.write("                    <a href=\"MGR_Dashboard.jsp\" class=\"navbar-brand d-flex d-lg-none me-4\">\r\n");
      out.write("                        <h2 class=\"text-primary mb-0\"><i class=\"fa fa-hashtag\"></i></h2>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a href=\"#\" class=\"sidebar-toggler flex-shrink-0\">\r\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <form class=\"d-none d-md-flex ms-4\">\r\n");
      out.write("                        <input class=\"form-control border-0\" type=\"search\" placeholder=\"Search\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <div class=\"navbar-nav align-items-center ms-auto\">\r\n");
      out.write("                        <div class=\"nav-item dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                                <i class=\"fa fa-envelope me-lg-2\"></i>\r\n");
      out.write("                                <span class=\"d-none d-lg-inline-flex\">Message</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("                                    <div class=\"d-flex align-items-center\">\r\n");
      out.write("                                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                                        <div class=\"ms-2\">\r\n");
      out.write("                                            <h6 class=\"fw-normal mb-0\">Jhon send you a message</h6>\r\n");
      out.write("                                            <small>15 minutes ago</small>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <hr class=\"dropdown-divider\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("                                    <div class=\"d-flex align-items-center\">\r\n");
      out.write("                                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                                        <div class=\"ms-2\">\r\n");
      out.write("                                            <h6 class=\"fw-normal mb-0\">Jhon send you a message</h6>\r\n");
      out.write("                                            <small>15 minutes ago</small>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <hr class=\"dropdown-divider\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("                                    <div class=\"d-flex align-items-center\">\r\n");
      out.write("                                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                                        <div class=\"ms-2\">\r\n");
      out.write("                                            <h6 class=\"fw-normal mb-0\">Jhon send you a message</h6>\r\n");
      out.write("                                            <small>15 minutes ago</small>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <hr class=\"dropdown-divider\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item text-center\">See all message</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"nav-item dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                                <i class=\"fa fa-bell me-lg-2\"></i>\r\n");
      out.write("                                <span class=\"d-none d-lg-inline-flex\">Notificatin</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("                                    <h6 class=\"fw-normal mb-0\">Profile updated</h6>\r\n");
      out.write("                                    <small>15 minutes ago</small>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <hr class=\"dropdown-divider\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("                                    <h6 class=\"fw-normal mb-0\">New user added</h6>\r\n");
      out.write("                                    <small>15 minutes ago</small>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <hr class=\"dropdown-divider\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("                                    <h6 class=\"fw-normal mb-0\">Password changed</h6>\r\n");
      out.write("                                    <small>15 minutes ago</small>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <hr class=\"dropdown-divider\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item text-center\">See all notifications</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"nav-item dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                                <img class=\"rounded-circle me-lg-2\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                                <span class=\"d-none d-lg-inline-flex\">John Doe</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">My Profile</a>\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">Settings</a>\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">Log Out</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <!-- Navbar End -->\r\n");
      out.write("                <!-- Blank Start -->\r\n");
      out.write("                <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                    <div class=\"row vh-100 bg-light rounded justify-content-center mx-0\">\r\n");
      out.write("                        <div class=\"col-sm-12 col-xl-6\">\r\n");
      out.write("                            <div class=\"bg-light rounded h-100 p-4\">\r\n");
      out.write("                                <h6 class=\"mb-4\">Create Form</h6>\r\n");
      out.write("                                <form action=\"CreateProductManager\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                    <div class=\"row mb-3\">\r\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Name</label>\r\n");
      out.write("                                        <div class=\"col-sm-10\">\r\n");
      out.write("                                            <input type=\"text\" name=\"productName\" required=\"\" class=\"form-control\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row mb-3\">\r\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Decription</label>\r\n");
      out.write("                                        <div class=\"col-sm-10\">\r\n");
      out.write("                                            <input type=\"text\" name=\"description\" class=\"form-control\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row mb-3\">\r\n");
      out.write("                                        <label for=\"brandImage\"  class=\"col-sm-2 col-form-label\">Image</label>\r\n");
      out.write("                                        <div class=\"col-sm-10\">\r\n");
      out.write("                                            <input type=\"file\" name=\"brandImage\" class=\"form-control\" required=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    Brand <select name=\"brandID\" class=\"form-select mb-3\" aria-label=\"Default select example\" required=\"\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                    <button type=\"submit\"class=\"btn btn-primary\">CREATE</button>\r\n");
      out.write("                                    <input type=\"hidden\" name=\"search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.SEARCH}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Blank End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- Footer Start -->\r\n");
      out.write("                <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                    <div class=\"bg-light rounded-top p-4\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-12 col-sm-6 text-center text-sm-start\">\r\n");
      out.write("                                &copy; <a href=\"#\">Your Site Name</a>, All Right Reserved. \r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-12 col-sm-6 text-center text-sm-end\">\r\n");
      out.write("                                <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from \"https://htmlcodex.com/credit-removal\". Thank you for your support. ***/-->\r\n");
      out.write("                                Designed By <a href=\"https://htmlcodex.com\">HTML Codex</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Footer End -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Content End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Back to Top -->\r\n");
      out.write("            <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- JavaScript Libraries -->\r\n");
      out.write("        <!-- JavaScript Libraries -->\r\n");
      out.write("        <!-- JavaScript Libraries -->\r\n");
      out.write("        <!-- JavaScript Libraries -->\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/chart/chart.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/easing/easing.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/tempusdominus/js/moment.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/tempusdominus/js/moment-timezone.min.js\"></script>\r\n");
      out.write("        <script src=\"dashmin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Javascript -->\r\n");
      out.write("        <script src=\"dashmin/js/main.js\"></script>\r\n");
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
    _jspx_th_c_forEach_0.setVar("brand");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LIST_BRAND_MANAGER}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.brandID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("                                        ");
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
}
