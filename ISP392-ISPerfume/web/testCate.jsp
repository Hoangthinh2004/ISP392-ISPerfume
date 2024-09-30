<%-- 
    Document   : testCate
    Created on : Sep 28, 2024, 2:28:02 PM
    Author     : ThinhHoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="MainController">
            <input type="submit" name="action" value="Search"/>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>CategoryName</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="Category" items="${requestScope.LIST_CATEGORY}">
                    <form action="MainController">
                        <tr>
                            <td>
                                <input type="text" name="action" value="${Category.name}"/>
                            </td>
                        </tr>
                    </form>           
                </c:forEach>               
            </tbody>
        </table>

        
    </body>
</html>
