<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Библиотека</title>
</head>
<body>
<h1>Книги</h1>
<div
        id="userinfo">
</div>

<c:if test="${not empty books}">
    <table border="1">
        <tr>
            <td>Название</td>
            <td>Автор</td>
            <td>Описание</td>

        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.description}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>