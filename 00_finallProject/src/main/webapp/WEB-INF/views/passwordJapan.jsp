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
					<h1>暗証番号探し</h1>
				</td>

			</tr>
			
			<tr>
			<td colspan="5">
				<br>
			</td>
			</tr>
			
			<tr>

				<td colspan="1" > <b>ID</b> </td>
				<td colspan="4"><input name="c_id" required="required" style="width:150px;height:35px;">
				</td>

			</tr>
			
			<tr>
			<td colspan="5">
				<hr class="one">
			</td>
			</tr>

			<tr>
				<td colspan="1"><b>暗証番号質問</b></td>
				<td colspan="4"><select name="c_pwq" required="required" style="width:150px;height:35px;">
						<option value="">質問選択</option>
						<option value="좋아하는 음식">好きな食べ物</option>
						<option value="사랑하는 사람">愛しい人</option>
						<option value="나의 첫 여행장소">私の初めての旅先</option>
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
					onchange="noSpaceForm(this);" style="width:150px;height:35px;"></td>

			</tr>
			
			<tr>
			<td colspan="5">
			<br>	<hr >
			</td>
			</tr>

			<tr>

				<td colspan="3">
					<button class="button">捜し</button>

				</td>

			</tr>

		</table>

	</form>



</body>
</html>