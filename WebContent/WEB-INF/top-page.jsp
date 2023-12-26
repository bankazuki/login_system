<%@ page pageEncoding="UTF-8" %>
<html>
<head>
  <title>ログイン</title>
  <meta charset="UTF-8">
</head>
<body style="  height: 100vh; margin: 0; display: flex; align-items: center; justify-content: center;">
<form action="./Login" method="post">
  <div>
    <label>ユーザー名</label>
    <input type="text" name="userName">
  </div>
  <div>
    <label>パスワード</label>
    <input type="text" name="userPassword">
  </div>
  <div>
    <input type="submit" value="ログイン">
  </div>
</form>
<input type="button" onclick="location.href='./Register'" value="新規登録">
</body>
</html>