<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="sendmessage.go">
	
	<table id="sendtable">
	
	<tr>
	<td>
		<b>받는 사람 :</b>   <input name="c_getter" readonly="readonly" value="${sessionScope.getter}"><br>
	</td>
	</tr>
	<tr>
	<td>
		<br> <b>보내는 사람 :</b>  <input name="c_sender" readonly="readonly" value="${sessionScope.loginMember.c_id}">
		<input name="token" value="${token }" type="hidden"><br>
	</td>
	</tr>
	<tr>
	<td>
		<br> <b>내용</b>  <br> <textarea name="c_comment" style="width:400px;height:200px;">  </textarea>
	</td>
	</tr>
<tr>
<td>
	<br>
	<button class="button">쪽지 보내기 </button>
</td>
</tr>	
	</table>
	</form>
	


</body>
</html>