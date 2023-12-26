<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>ログイン結果</title>
  <meta charset="UTF-8">
</head>
<body>
<c:choose>
  <c:when test="${loginUser != null}">
    <p>ログインが完了しました。</p>
    <p>こんにちは! <c:out value="${loginUser.name}"/>さん</p>
  </c:when>
  <c:otherwise>
    <p>ログインに失敗しました。</p>
    <p>もう一度ログインをやり直してください。</p>
    <a href="./Login">ログイン</a>
  </c:otherwise>
</c:choose>
</body>
</html>