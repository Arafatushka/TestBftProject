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
<div id="userinfo">
    <s:authorize access="isAuthenticated()">Привет,
        <s:authentication property="principal.username" />!
        <br/>
        <a href="j_spring_security_logout">Выход</a>
    </s:authorize>
</div>
<s:authorize access="isAnonymous()">
    <form id="login" name="loginForm" action="j_spring_security_check" method="POST">
        <label>Логин: </label>&nbsp;
        <input type="text" name="j_username">
        <label>Пароль: </label>&nbsp;
        <input type="password" name="j_password">
        <input type="submit" name="submit" value="Войти">
    </form>
</s:authorize>

<c:if test="${not empty books}">
    <table border="1">
        <tr>
            <td>Название</td>
            <td>Автор</td>
            <td>Описание</td>
            <s:authorize access="hasRole('ROLE_USER')">
                <td></td>
                <td></td>
            </s:authorize>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.description}</td>
                <s:authorize access="hasRole('ROLE_USER')">
                    <td><a href="update/${book.id}">Изменить</a></td>
                    <td><a href="delete/${book.id}">Удалить</a></td>
                </s:authorize>
            </tr>
        </c:forEach>
    </table>
</c:if>
<s:authorize access="hasRole('ROLE_USER')">
    <a href="update/0">Добавить книгу</a>
</s:authorize>
</body>
</html>