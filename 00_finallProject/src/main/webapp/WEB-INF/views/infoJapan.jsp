<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="joinForm" action="member.update" method="post"
		enctype="multipart/form-data" onsubmit="return check()">
		<table id="joinTable">
			<tr>
				<td colspan="3" class="joinTd"><h1>会員情報</h1></td>
			</tr>
			<tr>
				<td colspan="1"><b>ID </b></td>
				<td colspan="1"><input name="c_id"
					value="${sessionScope.loginMember.c_id }" readonly="readonly">
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>パスワード</b></td>
				<td colspan="1"><input type="password" name="c_pw"
					value="${sessionScope.loginMember.c_pw }"> <br></td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>パスワード確認</b></td>
				<td colspan="1"><input type="password" name="c_pw2"
					placeholder="パスワードを修正する際、再度入力してください。" style="width: 310px; height: 21px;"></td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>名前</b></td>
				<td colspan="1"><input name="c_name"
					value="${sessionScope.loginMember.c_name }"></td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>性別（変えられません。）</b></td>
				<td colspan="1">${sessionScope.loginMember.c_genderJ}<input
					readonly="readonly" name="c_genderJ" type="radio" checked="checked" value="${sessionScope.loginMember.c_genderJ}">
										<input name="c_genderK" value="${sessionScope.loginMember.c_genderK}" type="hidden">
					
					</td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>国籍</b></td>
				<td colspan="1"><input readonly="readonly" name="c_countryJ"
					value="${sessionScope.loginMember.c_countryJ}">
				<input name="c_countryK" value="${sessionScope.loginMember.c_countryK}" type="hidden">
					
					</td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>日本語レベル</b></td>
				<td colspan="1"><input name="" value="${langJ[0] }"
					readonly="readonly"></td>

				<td colspan="1"><select name="c_language1">

						<option value="${langK[0] },${langJ[0] }">日本語レベル選択</option>
						<optgroup label="日本語">
							
								<option value="네이티브,ネイティブ ">日本語、ネイティブ</option>
							<option value="상급,上級">日本語,上級</option>
							<option value="중급,中級">日本語,中級</option>
							<option value="초급,初級">日本語,初級</option>
							<option value="불가,不可">日本語,全然できません。</option>
							
							
						</optgroup>

				</select></td>

			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>韓国語 レベル</b></td>
				<td colspan="1"><input name="" value="${langJ[1] }"
					readonly="readonly"></td>

				<td colspan="1"><select name="c_language2">

						<option value="${langK[1] },${langJ[1] }">韓国語 レベル 選択</option>
						<optgroup label="韓国語">
							
							<option value="네이티브,ネイティブ">韓国語 ,ネイティブ</option>
							<option value="상급,上級">韓国語 ,上級</option>
							<option value="중급,中級">韓国語 ,中級</option>
							<option value="초급,初級">韓国語 ,初級</option>
							<option value="불가,不可">韓国語 ,全然できません。</option>
							
							
						</optgroup>

				</select></td>

			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>英語レベル</b></td>
				<td colspan="1"><input name="" value="${langJ[2]}"
					readonly="readonly"></td>

				<td colspan="1"><select name="c_language3">

						<option value="${langK[2] },${langJ[2] }">英語レベル選択</option>
						<optgroup label="英語">
							
							<option value="네이티브,ネイティブ">英語,ネイティブ</option>
							<option value="상급,上級">英語,上級</option>
							<option value="중급,中級">英語,中級</option>
							<option value="초급,初級">英語,初級</option>
							<option value="불가,不可">英語,全然できません。</option>
							
							
						</optgroup>

				</select></td>

			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>中国語レベル</b></td>
				<td colspan="1"><input name="" value="${langJ[3] }"
					readonly="readonly"></td>

				<td colspan="1"><select name="c_language4">
						<option value="${langK[3] },${langJ[3] }">中国語レベル選択</option>
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
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>暗証番号を探すための質問設定。</b></td>
				<td colspan="1"><input name=""
					value="${sessionScope.loginMember.c_pwqJ}" readonly="readonly"></td>
				<td colspan="1"><select name="c_pwq">

						<option value="${sessionScope.loginMember.c_pwqJ},${sessionScope.loginMember.c_pwqK}">質問選択</option>
						<optgroup label="質問">
							<option value="좋아하는 음식,好きな食べ物">好きな食べ物</option>
							<option value="사랑하는 사람,愛しい人">愛しい人</option>
							<option value="나의 첫 여행장소,私の初めての旅先">私の初めての旅先</option>
						</optgroup>

				</select></td>

			</tr>
			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>暗証番号の返事</b></td>
				<td colspan="1"><input type="text" name="c_pwans"
					value="${sessionScope.loginMember.c_pwans}" required="required"
					id="test" onkeyup="noSpaceForm(this);"
					onchange="noSpaceForm(this);"></td>

			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b>Eメール</b></td>
				<td colspan="1"><input type="text" name="c_email"
					readonly="readonly" value="${sessionScope.loginMember.c_email}">
				</td>

			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>


			<tr>
				<td colspan="1"><b>写真</b></td>
				<td colspan="2"><img
					src="resources/img/${sessionScope.loginMember.c_photo }"
					style="max-width: 100px"> <input type="file" name="c_photo"></td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="1"><b> 自己紹介</b></td>
				<td colspan="1"><textarea name="c_comment"
						style="width: 300px; height: 200px;"> ${sessionScope.loginMember.c_comment }  </textarea>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<hr class="one">
				</td>
			</tr>

			<tr>
				<td colspan="2" class="joinTd">
					<button class="button">修整</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="button4" type="button" onclick="byebye()">脱退</button>
					<br>
				<br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>