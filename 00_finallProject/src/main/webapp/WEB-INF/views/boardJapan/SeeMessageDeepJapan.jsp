<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>

<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {

		
		//$('button').click(function() {
		$("#i2").val(function() {

			let inputVal = $("#i2").val();

			$.ajax({
				// type 설정
				type : 'GET',
				// 서버로 보낼 주소 입력 
				url : "/last/menu.get.json.block",
				// 사용자가 입력한 값 서버로
				data : {
					"c_user" : inputVal
				},
				dataType : 'json',
				// 성공했을때
				success : function(data) {
					$("#mainTbl2").empty();
					successcall(data);
				}
			});
		});
	});

	function successcall(data) {
		data = data["name"];
		//alert(data[0]["c_blocker"]);
		
		$.each(data, function(i) {
				//console.log(data[i]);
			let hh = data[i].c_blocker;
			console.log(hh);

			if (hh === $("#i1").val()) {
				
				$('#i4').css('visibility', 'hidden');
				$('#mainTbl2').append(" ブロックされました 返事はできません。  ");

				$("#i2").val()="";			
				
			} else {
				$('#i4').css('visibility', 'visible');

			}


		});

	}
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



		<form action="writemail.go">
		
			<table  class="tableforsearch">
				<tr>
					<td colspan="1">送り手 : ${k.c_sender }</td>
					<td colspan="1">送った時間 : <fmt:formatDate value="${k.c_date }" type="both" dateStyle="short" timeStyle="short"/></td>
					<td colspan="1"> <input id="i1" value="${k.c_sender }" type="hidden"> </td>
					<td colspan="1"> <input id="i2" value="${sessionScope.loginMember.c_id}" type="hidden"> </td>
				</tr>
				
				<tr>
				
					<td class="message_inside" colspan="4" >
					<hr>
					
					${k.c_comment}
					
					
					</td>
				</tr> 

				<tr>
					<td colspan="4" >
					<br> <hr class="one">	
					<input name="token" value="${token }" type="hidden">
					<input name="c_id"  value="${k.c_sender }" type="hidden">
					</td>
				
				</tr>
				
				<tr>
				
				<td id="mainTbl2" colspan="4">
				
				</td>
				</tr>
			</table>
			<br><br>
		<button id="i4" class="button2">メール返事する。</button>	&nbsp;&nbsp;  		
		<button type="button" onclick="delectmessage(${k.c_no})" class="button3">削除する。</button>&nbsp; &nbsp; 
		<button type="button" onclick="gobackmessage()" class="button6">前のページへ戻る</button>
		
			
		</form>


</body>
</html>