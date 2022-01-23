<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {

		
		//$('button').click(function() {
		$("#i1").val(function() {

			let inputVal = $("#i1").val();

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
		
	$(function() {

		
		//$('button').click(function() {
		$("#i6").val(function() {

			let inputVal = $("#i6").val();

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
					$("#mainTbl3").empty();
					successcall2(data);
				}
			});
		});
	});
	$(function() {

		
		//$('button').click(function() {
		$("#i8").val(function() {

			let inputVal = $("#i8").val();

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
					$("#mainTbl4").empty();
					successcall3(data);
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

			if (hh === $("#i2").val()) {
				
				$('#i4').css('visibility', 'hidden');
				$('#mainTbl2').append(" 차단되었기에 쪽지를 보낼수 없습니다. ");

				$("#i1").val()="";			
				
			} else {
				$('#i4').css('visibility', 'visible');

			}


		});

	}
	function successcall2(data) {
		data = data["name"];
		//alert(data[0]["c_blocker"]);
		
		$.each(data, function(i) {
				//console.log(data[i]);
			let hh = data[i].c_blocker;
			console.log(hh);

			if (hh === $("#i7").val()) {
				
				$('#i5').css('visibility', 'hidden');
				$('#mainTbl3').append("  이미 차단 하셨습니다. ");

				$("#i7").val()="";			
				
			} else {
				$('#i5').css('visibility', 'visible');

			}


		});

	}
	function successcall3(data) {
		data = data["name"];
		//alert(data[0]["c_blocker"]);
		
		$.each(data, function(i) {
				//console.log(data[i]);
			let hh = data[i].c_blocker;
			console.log(hh);

			if (hh === $("#i9").val()) {
				
				$('#i10').css('visibility', 'visible');

				$("#i8").val()="";			
				
			} else {
				$('#i10').css('visibility', 'hidden');

			}


		});

	}
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr class="one">
<br>
	<table class="friendtable2" >

				<tr>
					<td rowspan="11" class="friendimg"><img alt=""
						src="resources/img/${friends.c_photo }" width="250" height="250" "></td>
				</tr>

				<tr>
					<td rowspan="1" colspan="8"> <br><b>ID : </b> ${friends.c_id}<br> <hr> </td>

				</tr>
				<tr>
					<td rowspan="1" colspan="8"> <br><b>이름 : </b> ${friends.c_name }<br> <hr> </td>

				</tr>
				
				<tr>
				
					<td rowspan="1" colspan="8"><br><b>나라 : </b> ${friends.c_countryK }<br>  <hr></td>
				</tr>
				<tr>
				
					<td rowspan="1" colspan="8"><br><b>성별  : </b> ${friends.c_genderK } <br> <hr><br></td>
				</tr>
				<tr>
					
					<td rowspan="1" colspan="2"> <b>일본어 : </b> ${lang[0]}</td>
					<td rowspan="1" colspan="2"><b>한국어 :</b> ${lang[1]}</td>
					<td rowspan="1" colspan="2"><b>영어 :</b> ${lang[2]}</td>
					<td rowspan="1" colspan="2"><b>중국어 :</b> ${lang[3]} </td>
					
				</tr>
				
				<tr>
				<td colspan="8" rowspan="1"> <hr> </td>
				</tr>
				
				
				<tr>
					<td id="story2" colspan="8" rowspan="1"> ${friends.c_comment} </td>
					
				</tr>
				
				<tr>
				<td colspan="8" rowspan="1"> <hr> </td>
				</tr>
				
				<tr>
				<td colspan="1">
				<form action="findfriend.go">
				
				<button class="button4">돌아가기</button>
				</form>
				
				</td>
				
				<td colspan="2" >
				
				 <c:if test="${sessionScope.loginMember.c_id !=null && sessionScope.loginMember.c_id !=friends.c_id }">

				<form action="writemail.go">
				<input name="c_id" value="${friends.c_id}" type="hidden">
				
				<button id="i4" class="button">쪽지 보내기</button>&nbsp;&nbsp;
				</form>
					
					</c:if> 
				
				</td>
				<td colspan="2" >
				
				 <c:if test="${sessionScope.loginMember.c_id !=null && sessionScope.loginMember.c_id !=friends.c_id }">

				<form action="blockUser.go">
				<input name="blocker" value="${friends.c_id}" type="hidden">
				
				<button id="i5" class="button3">이 유저 차단하기 </button>
				</form>
					
					</c:if> 
				
				</td>
				
				<td colspan="2">
				 <c:if test="${sessionScope.loginMember.c_id !=null && sessionScope.loginMember.c_id !=friends.c_id }">

				<form action="DelectblockUser.go">
				<input name="blocker" value="${friends.c_id}" type="hidden" >
				
				<button id="i10" class="button2">이 유저 차단해제 하기 </button>
				</form>
					
					</c:if> 
				
				</td>
				</tr>

				<tr>
				<td colspan="8" rowspan="1"> <hr> </td>
				</tr>			
							
							
				<tr>
				
				<td id="mainTbl2" colspan="4"></td>
				<td id="mainTbl3" colspan="4"></td>
				</tr>
				
				<tr>
				
				<td> <input id="i1" name="c_user" value="${sessionScope.loginMember.c_id}" type="hidden"> </td>
					<td> <input id="i2" name="c_id" value="${friends.c_id}" type="hidden"></td>
					<td> <input id="i6" name="c_user" value="${friends.c_id}" type="hidden"></td>
					<td> <input id="i7" name="c_user" value="${sessionScope.loginMember.c_id}" type="hidden"> </td>
					<td> <input id="i8" name="c_user" value="${friends.c_id}" type="hidden"></td>
					<td> <input id="i9" name="c_user" value="${sessionScope.loginMember.c_id}" type="hidden"> </td>
				
				</tr>
				
				
			</table>
<br>
<hr class="one">




</body>
</html>