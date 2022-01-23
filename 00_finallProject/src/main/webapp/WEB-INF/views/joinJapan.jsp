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
				$('#mainTbl2').append(" idが重複しています。 他のIDで加入してください。 ");
				
				$('#i2').css('visibility', 'hidden');
				$("#i1").val()="";				
			} else {
				$('#i2').css('visibility', 'visible');

			}

			/* if($("#i1").val() != ""){
				
			
			$('#mainTbl2').append("<tr><td id='tds"+i+"'></td></tr>");
			$('#tds' + i).text(data[i]["m_name"]);
			} */

		});

	}
	
	
	function chkPW(){

		 var pw = $("#pw_1").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		 if(pw.length < 8 || pw.length > 20){

		  alert("8字~20字以内で入力してください。");
		  return false;
		 }else if(pw.search(/\s/) != -1){
		  alert("パスワードは空白なしに入力してください。");
		  return false;
		 }else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("英文、数字、特殊文字を混ぜて入力してください。");
		  return false;
		 }else {
			console.log("通過"); 
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
		enctype="Multipart/form-data" onsubmit="return  !!(chkPW() & can2())  ; ">
		<table id="joinTable">
			<tr>
				<td colspan="5" class="joinTd"> <h1>会員加入</h1> </td>
			</tr>
			<tr>
			<td colspan="5">
			<br>
			</td>
			</tr>
			
			<tr>
				<td colspan="1"> <b> ID </b></td>
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
				<td colspan="1"><b>PassWord </b></td>
				<td colspan="4"><input id="pw_1" type="password" name="c_pw"
					required="required" minlength="6" style="width:190px;height:35px;"></td>
			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>PassWordCheck </b></td>
				<td colspan="4"><input id="pw_2" type="password" name="c_pw2"
					required="required" minlength="6" style="width:190px;height:35px;"></td>
			</tr>
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>名前 </b></td>
				<td colspan="4"><input name="c_name" required="required" style="width:190px;height:35px;"></td>
			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			<tr>
				<td colspan="1"> <b>使用可能な言語 </b> &nbsp;</td>

				<td colspan="1"><select name="c_language1" required="required" style="width:120px;height:35px;">
						<option value="">日本語レベル選択</option>
						<optgroup label="日本語">
							
							<option value="네이티브,ネイティブ ">日本語、ネイティブ</option>
							<option value="상급,上級">日本語,上級</option>
							<option value="중급,中級">日本語,中級</option>
							<option value="초급,初級">日本語,初級</option>
							<option value="불가,不可">日本語,全然できません。</option>
							
							
							
						</optgroup>
				</select></td>

				<td colspan="1"><select name="c_language2" required="required" style="width:120px;height:35px;">
						<option value="">韓国語レベル選択</option>
							<optgroup label="韓国語">
							
							<option value="네이티브,ネイティブ">韓国語 ,ネイティブ</option>
							<option value="상급,上級">韓国語 ,上級</option>
							<option value="중급,中級">韓国語 ,中級</option>
							<option value="초급,初級">韓国語 ,初級</option>
							<option value="불가,不可">韓国語 ,全然できません。</option>
						</optgroup>
							
							
							
				</select></td>

				<td colspan="1"><select name="c_language3" required="required" style="width:120px;height:35px;">

						<option value="">英語レベル選択</option>
						<optgroup label="英語">
							<option value="네이티브,ネイティブ">英語,ネイティブ</option>
							<option value="상급,上級">英語,上級</option>
							<option value="중급,中級">英語,中級</option>
							<option value="초급,初級">英語,初級</option>
							<option value="불가,不可">英語,全然できません。</option>
						</optgroup>

				</select></td>

				<td colspan="1"><select name="c_language4" required="required" style="width:120px;height:35px;">

						<option value="">中国語レベル選択	</option>
						<optgroup label="中国語">
							<option value="네이티브,ネイティブ">中国語,ネイティブ</option>
							<option value="상급,上級">中国語,上級</option>
							<option value="중급,中級">中国語,中級</option>
							<option value="초급,初級">中国語,初級</option>
							<option value="불가,不可">中国語,全然できません</option>
						</optgroup>

				</select></td>

			</tr>
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>性別 </b></td>
				<td colspan="4">男<input name="c_gender" type="radio" value="남자,男"
					checked="checked"><br> 女<input name="c_gender"
					type="radio" value="여자,女"></td>
			</tr>
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>母国 </b></td>
				<td colspan="4"><select name="c_country" required="required" style="width:140px;height:35px;">
						<option value="">国選択</option>
						<option value="한국,韓国">韓国</option>
						<option value="일본,日本">日本</option>
						<option value="기타,etc">etc</option>
				</select></td>
			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>暗証番号を探すための質問設定。 </b></td>
				<td colspan="4"><select name="c_pwq" required="required" style="width:190px;height:35px;">
						<option value="">質問選択</option>
						<option value="좋아하는 음식,好きな食べ物">好きな食べ物</option>
						<option value="사랑하는 사람,愛しい人">愛しい人</option>
						<option value="나의 첫 여행장소,私の初めての旅先">私の初めての旅先</option>
				</select></td>

			</tr>
			
			<tr>
			<td colspan="5">
			<hr class="one"> 
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>暗証番号の返事</b></td>
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
				<td colspan="1"><b>Eメール </b></td>
				<td colspan="4"><input type="text" name="c_email" readonly="readonly"
					value="${email}"></td>

			</tr>

			<tr>
			<td colspan="5">
			<hr> 
			</td>
			</tr>


			<tr>
				<td colspan="5" ><button id="i2" class="button4" >加入</button></td>
			</tr>
		</table>
	</form>





</body>
</html>