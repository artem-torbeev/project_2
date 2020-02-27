<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html >
<html  lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<style>
    .center {
        width: 200px; /* ?????? ???????? ? ???????? */
        padding: 10px; /* ???? ?????? ?????? */
        margin: auto; /* ??????????? ?? ?????? */
        background: #fc0; /* ???? ???? */
    }
</style>
<body>
<table align="center">
    <div class="center">
        <h3>Welcome : ${username}</h3>
    </div>

    <div>
        <td><a href="${pageContext.request.contextPath}/">Home</a></td>
    </div>
</table>
</body>
</html>
