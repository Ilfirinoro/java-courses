<%@ page language="java" pageEncoding="UTF-8" session="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>
            Users
        </title>
    </head>
    <body>
        <a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Create user</a>
        <table border="1">
            <tr>
                <td>Login/Email</td>
                <td>Actions</td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr valign="top">
                    <td>${user.login}/${user.email}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/views/user/edit?id=${user.id}">Edit</a>
                        <a href="${pageContext.servletContext.contextPath}/views/user/delete?id=${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>