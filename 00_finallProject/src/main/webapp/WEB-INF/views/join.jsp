<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {

		
		
		
		//$('button').click(function() {
		$("#i1").keyup(function() {

			let inputVal = $("#i1").val();

			$.ajax({
				// type 설정
				type : 'GET',
				// 서버로 보낼 주소 입력 
				url : "/last/menu.get.json.name",
				// 사용자가 입력한 값 서버로
				data : {
					"c_id" : inputVal
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
		//alert(data[1]["m_name"]);

		$.each(data, function(i) {
				//console.log(data[i]);
			let hh = data[i].c_id;
			console.log(hh);

			if (hh === $("#i1").val()) {
				$('#mainTbl2').append(" id가 중복입니다. 다른 아이디로 가입해주세요 ");
				
				$('#i2').css('visibility', 'hidden');
				$("#i1").val()="";				
			} else {
				$('#i2').css('visibility', 'visible');

			}

			

		});

	}
	
	
	function chkPW(){

		 var pw = $("#pw_1").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		 if(pw.length < 8 || pw.length > 20){

		  alert("8자리 ~ 20자리 이내로 입력해주세요.");
		  return false;
		 }else if(pw.search(/\s/) != -1){
		  alert("비밀번호는 공백 없이 입력해주세요.");
		  return false;
		 }else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
		  return false;
		 }else {
			console.log("통과"); 
		    return true;
		 }

		}

</script>



<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="joinForm" action="member.join.do" method="post"
		enctype="Multipart/form-data" onsubmit="return  !!(chkPW() & can())  ; ">
		<table id="joinTable">
			<tr>
				<td colspan="5" class="joinTd"> <h1>회원가입</h1> </td>
			</tr>
			<tr>
			<td colspan="5">
			<br>
			</td>
			</tr>
			
			<tr>
				<td colspan="1"> <b> 아이디 </b></td>
				<td colspan="4"><input id="i1" name="c_id" required="required" minlength="6" style="width:190px;height:35px;"></td>

			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
			<td id="mainTbl2" colspan="5">

			</td>
			</tr>
			<tr>
				<td colspan="1"><b>비번 </b></td>
				<td colspan="4"><input id="pw_1" type="password" name="c_pw"
					required="required" minlength="6" style="width:190px;height:35px;"></td>
			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비번확인 </b></td>
				<td colspan="4"><input id="pw_2" type="password" name="c_pw2"
					required="required" minlength="6" style="width:190px;height:35px;"></td>
			</tr>
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>이름 </b></td>
				<td colspan="4"><input name="c_name" required="required" style="width:190px;height:35px;"></td>
			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			<tr>
				<td colspan="1"> <b>사용가능한 언어 </b> &nbsp;</td>

				<td colspan="1"><select name="c_language1" required="required" style="width:120px;height:35px;">
						<option value="">일본어 레벨 선택</option>
						<optgroup label="일본어">
							<option value="네이티브,ネイティブ">일어,네이티브</option>
							<option value="상급,上級">일어,상급</option>
							<option value="중급,中級">일어,중급</option>
							<option value="초급,初級">일어,초급</option>
							<option value="불가,不可">일어,전혀 못함</option>
						</optgroup>
				</select></td>

				<td colspan="1"><select name="c_language2" required="required" style="width:120px;height:35px;">
						<option value="">한국 레벨 선택</option>
						<optgroup label="한국어">
							<option value="네이티브,ネイティブ">한국어,네이티브</option>
							<option value="상급,上級">한국어,상급</option>
							<option value="중급,中級">한국어,중급</option>
							<option value="초급,初級">한국어,초급</option>
							<option value="불가,不可">한국어,전혀 못함</option>
						</optgroup>
				</select></td>

				<td colspan="1"><select name="c_language3" required="required" style="width:120px;height:35px;">

						<option value="">영어 레벨 선택</option>
						<optgroup label="영어">
							<option value="네이티브,ネイティブ">영어,네이티브</option>
							<option value="상급,上級">영어,상급</option>
							<option value="중급,中級">영어,중급</option>
							<option value="초급,初級">영어,초급</option>
							<option value="불가,不可">영어,전혀 못함</option>
						</optgroup>

				</select></td>

				<td colspan="1"><select name="c_language4" required="required" style="width:120px;height:35px;">

						<option value="">중국어 레벨 선택</option>
						<optgroup label="중국어">
							<option value="네이티브,ネイティブ">중국어,네이티브</option>
							<option value="상급,上級">중국어,상급</option>
							<option value="중급,中級">중국어,중급</option>
							<option value="초급,初級">중국어,초급</option>
							<option value="불가,不可">중국어,전혀 못함</option>
						</optgroup>

				</select></td>

			</tr>
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>성별 </b></td>
				<td colspan="4">남<input name="c_gender" type="radio" value="남자,男"
					checked="checked"><br> 여<input name="c_gender"
					type="radio" value="여자,女"></td>
			</tr>
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>모국 </b></td>
				<td colspan="4"><select name="c_country" required="required" style="width:140px;height:35px;">
						<option value="">나라 선택</option>
						<option value="한국,韓国">한국</option>
						<option value="일본,日本">일본</option>
						<option value="기타,etc">기타</option>
				</select></td>
			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호 질문 </b></td>
				<td colspan="4"><select name="c_pwq" required="required" style="width:190px;height:35px;">
						<option value="">질문 선택</option>
						<option value="좋아하는 음식,好きな食べ物">좋아하는 음식</option>
						<option value="사랑하는 사람,愛しい人">사랑하는 사람</option>
						<option value="나의 첫 여행장소,私の初めての旅先">나의 첫 여행장소</option>
				</select></td>

			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호 대답 </b></td>
				<td colspan="4"><input type="text" name="c_pwans" required="required"
					id="test" onkeyup="noSpaceForm(this);"
					onchange="noSpaceForm(this);" style="width:190px;height:35px;"></td>

			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>이메일 </b></td>
				<td colspan="4"><input type="text" name="c_email" readonly="readonly"
					value="${email}"></td>

			</tr>

			<tr>
			<td colspan="5">
			<hr> 
			</td>
			</tr>


			<tr>
				<td colspan="5" ><button id="i2" class="button4" >가입</button></td>
			</tr>
		</table>
	</form>





</body>
</html>