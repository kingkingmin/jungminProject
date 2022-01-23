<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/join.css">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<table id="logintable">


<tr>
<td>
<h2 id="logintop">Login</h2>
<br>
</td>

</tr>

<tr>

<td>


<form action="member.login" method="post">

ID <br> <input name="c_id">
Password <br> <input name="c_pw" type='password'>

<br><br>
<hr>
<button class="buttonloginbottom2"> ログイン </button>
<br><br>
<button class="buttonloginbottom" type="button" onclick="joinGo()" > 会員加入 </button>

<button class="buttonloginbottom" type="button" onclick="findGo()" > 暗証番号探し </button>

</form>

</td>

</tr>

</table>





</body>
</html>