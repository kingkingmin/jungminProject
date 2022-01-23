<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="findpassword.do" method="post">
		<table id="passtable">
			<tr>
				<td colspan="3">
					<h1>비밀번호 찾기</h1>
				</td>

			</tr>
			
			<tr>
			<td colspan="5">
				<br>
			</td>
			</tr>
			
			<tr>

				<td colspan="1" > <b>아이디</b> </td>
				<td colspan="4"><input name="c_id" required="required" style="width:150px;height:35px;">
				</td>

			</tr>
			
			<tr>
			<td colspan="5">
				<hr class="one">
			</td>
			</tr>

			<tr>
				<td colspan="1"><b>비밀번호 질문</b></td>
				<td colspan="4"><select name="c_pwq" required="required" style="width:150px;height:35px;">
						<option value="">질문 선택</option>
						<option value="좋아하는 음식">좋아하는 음식</option>
						<option value="사랑하는 사람">사랑하는 사람</option>
						<option value="나의 첫 여행장소">나의 첫 여행장소</option>
				</select></td>

			</tr>
			
			<tr>
			<td colspan="5">
				<hr class="one">
			</td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호 대답</b></td>
				<td colspan="4"><input type="text" name="c_pwans" required="required"
					id="test" onkeyup="noSpaceForm(this);"
					onchange="noSpaceForm(this);" style="width:150px;height:35px;"></td>

			</tr>
			
			<tr>
			<td colspan="5">
			<br>	<hr >
			</td>
			</tr>

			<tr>

				<td colspan="3">
					<button class="button">찾기</button>

				</td>

			</tr>

		</table>

	</form>



</body>
</html>