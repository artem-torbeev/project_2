<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Регистрация</h1>

<form method="post" action="login">
    <input type="text" name="username" placeholder="username"/>
    <input type="password" name="password" placeholder="password"/>
    <input type="submit" value="Submit">
</form>
<%--<form:form method="POST" action='<spring:url value="/login.jsp/>'>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><form:label path="username">Name</form:label></td>--%>
<%--            <td><form:input path="username"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="password">Id</form:label></td>--%>
<%--            <td><form:input path="password"/></td>--%>
<%--        </tr>--%>

<%--            <td><input type="submit" value="Submit"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>
</body>
</html>
