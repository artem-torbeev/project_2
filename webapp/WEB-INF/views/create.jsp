<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/list/create">

    <p><i>Имя: <label>
        <input type="text" name="name">
    </label></i></p>
    <p><i>Фамилия: <label>
        <input type="text" name="lastname">
    </label></i></p>
    <p><i>Email: <label>
        <input type="text" name="email">
    </label></i></p>
    <p><i>Пароль: <label>
        <input type="password" name="password">
    </label></i></p>

    <p><input type="submit" value="Create"/><br></p>
</form>

</body>
</html>
