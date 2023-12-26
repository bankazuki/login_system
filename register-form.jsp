<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>新規登録</title>
</head>
<body>
<p>ユーザー名とパスワードを入力してください</p>
<form action="./Register" method="post">
  <div>
    <label>ユーザー名</label>
    <input type="text" name="userName">
  </div>
  <div>
    <label>パスワード</label>
    <input type="text" name="userPassword">
  </div>
  <div>
    <label>社員番号</label>
    <input type="text" name="employeeNumber">
  </div>
  <div>
    <input type="submit" value="登録">
  </div>
</form>
<div>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p><%= message %></p>
        <% } %>
    </div>
</body>
</html>