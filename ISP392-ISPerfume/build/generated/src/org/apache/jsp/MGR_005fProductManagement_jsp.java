package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import isp392.product.ProductDTO;

public final class MGR_005fProductManagement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>DASHMIN - Bootstrap Admin Template</title>\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n");
      out.write("        <meta content=\"\" name=\"keywords\">\n");
      out.write("        <meta content=\"\" name=\"description\">\n");
      out.write("\n");
      out.write("        <!-- Favicon -->\n");
      out.write("        <link href=\"img/favicon.ico\" rel=\"icon\">\n");
      out.write("\n");
      out.write("        <!-- Google Web Fonts -->\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Icon Font Stylesheet -->\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Libraries Stylesheet -->\n");
      out.write("        <link href=\"dashmin/lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"dashmin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <!-- Customized Bootstrap Stylesheet -->\n");
      out.write("        <link href=\"dashmin/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Template Stylesheet -->\n");
      out.write("        <link href=\"dashmin/css/style.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid position-relative bg-white d-flex p-0\">\n");
      out.write("            <!-- Spinner Start -->\n");
      out.write("            <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\n");
      out.write("                <div class=\"spinner-border text-primary\" style=\"width: 3rem; height: 3rem;\" role=\"status\">\n");
      out.write("                    <span class=\"sr-only\">Loading...</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Spinner End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Sidebar Start -->\n");
      out.write("            <div class=\"sidebar pe-4 pb-3\">\n");
      out.write("                <nav class=\"navbar bg-light navbar-light\">\n");
      out.write("                    <a href=\"MGR_Dashboard.jsp\" class=\"navbar-brand mx-4 mb-3\">\n");
      out.write("                        <h3 class=\"text-primary\"><i class=\"fa fa-hashtag me-2\"></i>DASHMIN</h3>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"d-flex align-items-center ms-4 mb-4\">\n");
      out.write("                        <div class=\"position-relative\">\n");
      out.write("                            <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\n");
      out.write("                            <div class=\"bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"ms-3\">\n");
      out.write("                            <h6 class=\"mb-0\">Jhon Doe</h6>\n");
      out.write("                            <span>Admin</span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"navbar-nav w-100\">\n");
      out.write("                        <a href=\"MGR_Dashboard.jsp\" class=\"nav-item nav-link\"><i class=\"fa fa-tachometer-alt me-2\"></i>Dashboard</a>\n");
      out.write("                        <div class=\"nav-item dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle active\" data-bs-toggle=\"dropdown\"><i class=\"fa fa-laptop me-2\"></i>Management</a>\n");
      out.write("                            <div class=\"dropdown-menu bg-transparent border-0\">\n");
      out.write("                                <a href=\"MainController?action=Manage_Product_Page\" class=\"dropdown-item active\">Product Management</a>\n");
      out.write("                                <a href=\"MGR_BrandManagement.jsp\" class=\"dropdown-item\">Brand Management</a>\n");
      out.write("                                <a href=\"MGR_PromotionManagement.jsp\" class=\"dropdown-item\">Promotion Management</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"widget.html\" class=\"nav-item nav-link\"><i class=\"fa fa-th me-2\"></i>Widgets</a>\n");
      out.write("                        <a href=\"form.html\" class=\"nav-item nav-link\"><i class=\"fa fa-keyboard me-2\"></i>Forms</a>\n");
      out.write("                        <a href=\"table.html\" class=\"nav-item nav-link\"><i class=\"fa fa-table me-2\"></i>Tables</a>\n");
      out.write("                        <a href=\"chart.html\" class=\"nav-item nav-link\"><i class=\"fa fa-chart-bar me-2\"></i>Charts</a>\n");
      out.write("                        <div class=\"nav-item dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"far fa-file-alt me-2\"></i>Pages</a>\n");
      out.write("                            <div class=\"dropdown-menu bg-transparent border-0\">\n");
      out.write("                                <a href=\"signin.html\" class=\"dropdown-item\">Sign In</a>\n");
      out.write("                                <a href=\"signup.html\" class=\"dropdown-item\">Sign Up</a>\n");
      out.write("                                <a href=\"404.html\" class=\"dropdown-item\">404 Error</a>\n");
      out.write("                                <a href=\"blank.html\" class=\"dropdown-item\">Blank Page</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("            <!-- Sidebar End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Content Start -->\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <!-- Navbar Start -->\n");
      out.write("                <nav class=\"navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0\">\n");
      out.write("                    <a href=\"MGR_Dashboard.jsp\" class=\"navbar-brand d-flex d-lg-none me-4\">\n");
      out.write("                        <h2 class=\"text-primary mb-0\"><i class=\"fa fa-hashtag\"></i></h2>\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"#\" class=\"sidebar-toggler flex-shrink-0\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <form class=\"d-none d-md-flex ms-4\" action=\"MainController\" method=\"get\">\n");
      out.write("                        <input class=\"form-control border-0\" type=\"search\" placeholder=\"Search\" name=\"search\">\n");
      out.write("\n");
      out.write("                        <button class=\"btn btn-primary\" type=\"submit\" name=\"action\" value=\"Search product\" style=\"margin-left: 10px;\">\n");
      out.write("                            <svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" fill=\"none\" viewBox=\"0 0 24 24\">\n");
      out.write("                            <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-width=\"2\" d=\"m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z\"/>\n");
      out.write("                            </svg>\n");
      out.write("                        </button>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"navbar-nav align-items-center ms-auto\">\n");
      out.write("                        <div class=\"nav-item dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\n");
      out.write("                                <i class=\"fa fa-envelope me-lg-2\"></i>\n");
      out.write("                                <span class=\"d-none d-lg-inline-flex\">Message</span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                    <div class=\"d-flex align-items-center\">\n");
      out.write("                                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\n");
      out.write("                                        <div class=\"ms-2\">\n");
      out.write("                                            <h6 class=\"fw-normal mb-0\">Jhon send you a message</h6>\n");
      out.write("                                            <small>15 minutes ago</small>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <hr class=\"dropdown-divider\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                    <div class=\"d-flex align-items-center\">\n");
      out.write("                                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\n");
      out.write("                                        <div class=\"ms-2\">\n");
      out.write("                                            <h6 class=\"fw-normal mb-0\">Jhon send you a message</h6>\n");
      out.write("                                            <small>15 minutes ago</small>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <hr class=\"dropdown-divider\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                    <div class=\"d-flex align-items-center\">\n");
      out.write("                                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\n");
      out.write("                                        <div class=\"ms-2\">\n");
      out.write("                                            <h6 class=\"fw-normal mb-0\">Jhon send you a message</h6>\n");
      out.write("                                            <small>15 minutes ago</small>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <hr class=\"dropdown-divider\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item text-center\">See all message</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"nav-item dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\n");
      out.write("                                <i class=\"fa fa-bell me-lg-2\"></i>\n");
      out.write("                                <span class=\"d-none d-lg-inline-flex\">Notificatin</span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                    <h6 class=\"fw-normal mb-0\">Profile updated</h6>\n");
      out.write("                                    <small>15 minutes ago</small>\n");
      out.write("                                </a>\n");
      out.write("                                <hr class=\"dropdown-divider\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                    <h6 class=\"fw-normal mb-0\">New user added</h6>\n");
      out.write("                                    <small>15 minutes ago</small>\n");
      out.write("                                </a>\n");
      out.write("                                <hr class=\"dropdown-divider\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                    <h6 class=\"fw-normal mb-0\">Password changed</h6>\n");
      out.write("                                    <small>15 minutes ago</small>\n");
      out.write("                                </a>\n");
      out.write("                                <hr class=\"dropdown-divider\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item text-center\">See all notifications</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"nav-item dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\n");
      out.write("                                <img class=\"rounded-circle me-lg-2\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\n");
      out.write("                                <span class=\"d-none d-lg-inline-flex\">John Doe</span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">My Profile</a>\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">Settings</a>\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">Log Out</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("                <!-- Navbar End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Blank Start -->\n");
      out.write("                <div class=\"container-fluid pt-4 px-4\">\n");
      out.write("                    <div class=\"row vh-100 bg-light rounded justify-content-center mx-0\" style=\"height: auto !important\">\n");
      out.write("                        <!--                        <div class=\"col-md-6 text-center\">-->\n");
      out.write("                        <!-- Recent Sales Start -->\n");
      out.write("                        <div class=\"container-fluid pt-4 px-4\">\n");
      out.write("                            <div class=\"bg-light text-center rounded p-4\">\n");
      out.write("                                <div class=\"d-flex align-items-center justify-content-between mb-4\">   \n");
      out.write("                                    <h6 class=\"mb-0\">Product Management</h6>\n");
      out.write("                                    <a href=\"MGR_CreateProduct.jsp\" class=\"btn btn-primary\">Create product</a>\n");
      out.write("                                    <!--                                    <button class=\"btn btn-primary\">\n");
      out.write("                                                                            <svg class=\"w-6 h-6 text-gray-800 dark:text-white\" aria-hidden=\"true\" xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" fill=\"none\" viewBox=\"0 0 24 24\">\n");
      out.write("                                                                            <path stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M5 12h14m-7 7V5\"/>\n");
      out.write("                                                                            </svg>\n");
      out.write("                                                                        </button>-->\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Recent Sales End -->\n");
      out.write("                        <!--</div>-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Blank End -->\n");
      out.write("                <!--                Footer Start -->\n");
      out.write("                <div class=\"container-fluid pt-4 px-4\">\n");
      out.write("                    <div class=\"bg-light rounded-top p-4\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-12 col-sm-6 text-center text-sm-start\">\n");
      out.write("                                &copy; <a href=\"#\">Your Site Name</a>, All Right Reserved. \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-12 col-sm-6 text-center text-sm-end\">\n");
      out.write("                                Designed By <a href=\"https://htmlcodex.com\">HTML Codex</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Footer End -->\n");
      out.write("            </div>\n");
      out.write("            <!-- Content End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Back to Top -->\n");
      out.write("            <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- JavaScript Libraries -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/chart/chart.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/easing/easing.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/waypoints/waypoints.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/owlcarousel/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/tempusdominus/js/moment.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/tempusdominus/js/moment-timezone.min.js\"></script>\n");
      out.write("        <script src=\"dashmin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Template Javascript -->\n");
      out.write("        <script src=\"dashmin/js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            window.onload = function () {\n");
      out.write("                const searchInput = document.querySelector('input[name=\"search\"]');\n");
      out.write("                const form = searchInput.form;\n");
      out.write("                if (!sessionStorage.getItem('isSubmitted')) {\n");
      out.write("                    const hiddenAction = document.createElement('input');\n");
      out.write("                    hiddenAction.type = 'hidden';\n");
      out.write("                    hiddenAction.name = 'action';\n");
      out.write("                    hiddenAction.value = 'Search product';\n");
      out.write("                    form.appendChild(hiddenAction);\n");
      out.write("                    form.submit();\n");
      out.write("                    sessionStorage.setItem('isSubmitted', 'true');\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.SHOW_ALL_PRODUCT_MANAGER!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                                        <table class=\"table text-start align-middle table-bordered table-hover mb-0\">\n");
        out.write("                                            <thead>\n");
        out.write("                                                <tr class=\"text-dark\">\n");
        out.write("                                                    <th scope=\"col\">Brand</th>\n");
        out.write("                                                    <th scope=\"col\">Name</th>\n");
        out.write("                                                    <th scope=\"col\">Release year</th>\n");
        out.write("                                                    <th scope=\"col\">Descrption</th>\n");
        out.write("                                                    <th scope=\"col\">Country</th>\n");
        out.write("                                                    <th scope=\"col\">Fragrance Families</th>\n");
        out.write("                                                    <th scope=\"col\">Image</th>\n");
        out.write("\n");
        out.write("                                                </tr>\n");
        out.write("                                            </thead>\n");
        out.write("                                            <tbody>\n");
        out.write("                                                ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                            </tbody>\n");
        out.write("                                        </table>\n");
        out.write("                                    ");
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

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setVar("pro");
    _jspx_th_c_forEach_0.setVarStatus("counter");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.SHOW_ALL_PRODUCT_MANAGER}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    <tr>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <form action=\"UpdateProductManager\" method=\"post\" enctype=\"multipart/form-data\">\n");
          out.write("                                                                <select name=\"brandID\" class=\"form-select mb-3\">\n");
          out.write("                                                                    ");
          if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                                </select>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <input type=\"text\" name=\"productName\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\">\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.releaseDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <input type=\"text\" name=\"description\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\">\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <input type=\"text\" name=\"country\"  value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.country}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\">\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <input type=\"text\" name=\"fragranceFamilies\"  value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.fragranceFamilies}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\">\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"width: 100px; height: 100px; margin-right: 10px;\">\n");
          out.write("                                                            <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"existingImage\">\n");
          out.write("                                                            <label for=\"image\"  class=\"col-sm-2 col-form-label\">Image</label>\n");
          out.write("                                                            <div class=\"col-sm-10\">\n");
          out.write("                                                                <input type=\"file\" name=\"image\" class=\"form-control\">\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <select name=\"status\" class=\"form-select mb-3\" aria-label=\"Default select example\">\n");
          out.write("                                                                <option value=\"1\" ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.status == 1 ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(">Available</option>\n");
          out.write("                                                                <option value=\"0\" ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.status == 0 ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(">Unavailable</option>\n");
          out.write("                                                            </select>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <input type=\"hidden\" name=\"status\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >\n");
          out.write("                                                            <input type=\"hidden\" name=\"releaseDate\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.releaseDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >\n");
          out.write("                                                            <input type=\"hidden\" name=\"productID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                            <input type=\"hidden\" name=\"search\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.SEARCH}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                            <input type=\"submit\" name=\"action\" value=\"Update\" class=\"btn btn-sm btn-primary\">\n");
          out.write("                                                            <!-- <button type=\"submit\" name=\"action\" value=\"Delete Product\" class=\"btn btn-sm btn-primary\">Delete</button>-->\n");
          out.write("                                                        </td>\n");
          out.write("                                                        </form>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <form action=\"MainController\" method=\"get\">\n");
          out.write("                                                                <button type=\"submit\" name=\"action\" value=\"ProductDetailPage\" class=\"btn btn-sm btn-primary\">Detail</button>\n");
          out.write("                                                                <input type=\"hidden\" name=\"productID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pro.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                            </form>\n");
          out.write("                                                        </td>\n");
          out.write("                                                    </tr>\n");
          out.write("                                                ");
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
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_1.setVar("brand");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.BRAND_LIST_MANAGER}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.brandID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\n");
          out.write("                                                                                ");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\n");
          out.write("                                                                                >\n");
          out.write("                                                                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                                                        </option>\n");
          out.write("                                                                    ");
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

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.brandID == pro.brandID}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                                                    SELECTED\n");
        out.write("                                                                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
