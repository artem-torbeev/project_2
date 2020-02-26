<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
</head>

<body>
<c:if test="${param.error != null}">
    <p style='color:red'>
        Invalid username and password.
    </p>
</c:if>
<div>
    <form method="POST" action="login">
        <h2>Вход в систему</h2>
        <div>
            <input name="username" type="text" placeholder="Username" />
            <input password="password" type="password" placeholder="Password" autofocus="true"/>
            <button type="submit">Log In</button>

        </div>
    </form>
</div>
<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>

</body>
</html>

