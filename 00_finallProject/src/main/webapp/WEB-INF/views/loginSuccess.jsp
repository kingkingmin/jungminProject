<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="loginTbl" >
		<tr >
			<!-- id="loginTd" -->
			<td colspan="2"  style="text-align: center;"> <b>ID : </b>&nbsp;${sessionScope.loginMember.c_id } 
			<br>
			<b>  	${sessionScope.loginMember.c_name }&nbsp;  </b> 님<br> <br> 환영합니다
				<br>
				</td>
		</tr>
		<tr>
			<td colspan="1" >
				<button onclick="memberInfoGo()" class="button2">회원정보&nbsp;</button>
			</td>
			<td colspan="1" >
				&nbsp;<button onclick="logout()" class="button6">로그아웃</button>
			</td>
		</tr>
	</table>
	<br><br>
	
</body>
</html>