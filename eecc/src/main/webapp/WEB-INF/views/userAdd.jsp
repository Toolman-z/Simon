<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>注册</title>
</head>
<body>
<form action="/eecc/user/addUser" method="post">
  <div class="reg_div">
    <p>注册</p>
    <ul class="reg_ul">
      <li>
          <span>用户名：</span>
          <input id="username" type="text" name="username" value="" placeholder="4-8位用户名" class="reg_user">
          <span class="tip user_hint"></span>
      </li>
      <li>
          <span>密码：</span>
          <input id="password" type="password" name="password" value="" placeholder="6-16位密码" class="reg_password">
          <span class="tip password_hint"></span>
      </li>
      <li>
          <span>确认密码：</span>
          <input id="password2" type="password" name="password2" value="" placeholder="确认密码" class="reg_confirm">
          <span class="tip confirm_hint"></span>
      </li>
      <li>
          <span>邮箱：</span>
          <input id="email" type="text" name="email" value="" placeholder="邮箱" class="reg_email">
          <span class="tip email_hint"></span>
      </li>
      <li>
          <span>手机号码：</span>
          <input id="phone" type="email" name="phone" value="" placeholder="手机号" class="reg_mobile">
          <span class="tip mobile_hint"></span>
      </li>
      <li>
        <button type="button" name="button" class="red_button">注册</button>
      </li>
    </ul>
  </div>
  </form>
  <script type="text/javascript" src="WEB-INF/JS/jquery-3.0.0.js"></script>
  <script type="text/javascript" src="WEB-INF/Js/script.js"></script>
  <div style="text-align:center;">
</div>
</body>
</html>