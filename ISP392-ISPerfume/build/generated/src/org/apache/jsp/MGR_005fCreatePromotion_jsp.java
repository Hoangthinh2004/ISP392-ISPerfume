package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MGR_005fCreatePromotion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                                <a href=\"MGR_ProductManagement.jsp\" class=\"dropdown-item active\">Product Management</a>\n");
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
      out.write("                    <form class=\"d-none d-md-flex ms-4\">\n");
      out.write("                        <input class=\"form-control border-0\" type=\"search\" placeholder=\"Search\">\n");
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
      out.write("                    <div class=\"row vh-100 bg-light rounded justify-content-center mx-0\">\n");
      out.write("                        <div class=\"col-sm-12 col-xl-6\">\n");
      out.write("                            <div class=\"bg-light rounded h-100 p-4\">\n");
      out.write("                                <h6 class=\"mb-4\">Create Form</h6>\n");
      out.write("                                <form>\n");
      out.write("                                    <div class=\"row mb-3\">\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Input</label>\n");
      out.write("                                        <div class=\"col-sm-10\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row mb-3\">\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Input</label>\n");
      out.write("                                        <div class=\"col-sm-10\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row mb-3\">\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Input</label>\n");
      out.write("                                        <div class=\"col-sm-10\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row mb-3\">\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Input</label>\n");
      out.write("                                        <div class=\"col-sm-10\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!--                                    <fieldset class=\"row mb-3\">\n");
      out.write("                                                                            <legend class=\"col-form-label col-sm-2 pt-0\">Radios</legend>\n");
      out.write("                                                                            <div class=\"col-sm-10\">\n");
      out.write("                                                                                <div class=\"form-check\">\n");
      out.write("                                                                                    <input class=\"form-check-input\" type=\"radio\" name=\"gridRadios\"\n");
      out.write("                                                                                           id=\"gridRadios1\" value=\"option1\" checked>\n");
      out.write("                                                                                    <label class=\"form-check-label\" for=\"gridRadios1\">\n");
      out.write("                                                                                        First radio\n");
      out.write("                                                                                    </label>\n");
      out.write("                                                                                </div>\n");
      out.write("                                                                                <div class=\"form-check\">\n");
      out.write("                                                                                    <input class=\"form-check-input\" type=\"radio\" name=\"gridRadios\"\n");
      out.write("                                                                                           id=\"gridRadios2\" value=\"option2\">\n");
      out.write("                                                                                    <label class=\"form-check-label\" for=\"gridRadios2\">\n");
      out.write("                                                                                        Second radio\n");
      out.write("                                                                                    </label>\n");
      out.write("                                                                                </div>\n");
      out.write("                                                                            </div>\n");
      out.write("                                                                        </fieldset>-->\n");
      out.write("                                    <!--                                    <div class=\"row mb-3\">\n");
      out.write("                                                                            <legend class=\"col-form-label col-sm-2 pt-0\">Checkbox</legend>\n");
      out.write("                                                                            <div class=\"col-sm-10\">\n");
      out.write("                                                                                <div class=\"form-check\">\n");
      out.write("                                                                                    <input class=\"form-check-input\" type=\"checkbox\" id=\"gridCheck1\">\n");
      out.write("                                                                                    <label class=\"form-check-label\" for=\"gridCheck1\">\n");
      out.write("                                                                                        Check me out\n");
      out.write("                                                                                    </label>\n");
      out.write("                                                                                </div>\n");
      out.write("                                                                            </div>\n");
      out.write("                                                                        </div>-->\n");
      out.write("                                    <div class=\"row mb-3\">\n");
      out.write("                                        <label  class=\"col-sm-2 col-form-label\">Input</label>\n");
      out.write("                                        <div class=\"col-sm-10\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <select class=\"form-select mb-3\" aria-label=\"Default select example\">\n");
      out.write("                                        <option selected>Open this select menu</option>\n");
      out.write("                                        <option value=\"1\">One</option>\n");
      out.write("                                        <option value=\"2\">Two</option>\n");
      out.write("                                        <option value=\"3\">Three</option>\n");
      out.write("                                    </select>\n");
      out.write("                                    <div class=\"mb-3\">\n");
      out.write("                                        <label for=\"formFile\" class=\"form-label\">Default file input example</label>\n");
      out.write("                                        <input class=\"form-control\" type=\"file\" id=\"formFile\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary\">CREATE</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Blank End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Footer Start -->\n");
      out.write("                <div class=\"container-fluid pt-4 px-4\">\n");
      out.write("                    <div class=\"bg-light rounded-top p-4\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-12 col-sm-6 text-center text-sm-start\">\n");
      out.write("                                &copy; <a href=\"#\">Your Site Name</a>, All Right Reserved. \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-12 col-sm-6 text-center text-sm-end\">\n");
      out.write("                                <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from \"https://htmlcodex.com/credit-removal\". Thank you for your support. ***/-->\n");
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
}