<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form name="joinForm" action="member.update" method="post" enctype="multipart/form-data" onsubmit="return check()">
		<table id="joinTable">
			<tr>
				<td colspan="3" class="joinTd"><h1>회원정보</h1>  </td>
			</tr>
			<tr>
				<td colspan="1"> <b>아이디 </b>   </td>
				<td colspan="1"><input name="c_id" value="${sessionScope.loginMember.c_id }" readonly="readonly"> </td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호</b></td>
				<td colspan="1"><input type="password" name="c_pw" value="${sessionScope.loginMember.c_pw }"> <br></td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호 확인</b></td>
				<td colspan="1"><input type="password" name="c_pw2" placeholder="비밀번호 수정시 다시 입력"></td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>이름</b></td>
				<td colspan="1"><input name="c_name" value="${sessionScope.loginMember.c_name }"></td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>성별(바꿀수 없습니다.)</b></td>
				<td colspan="1">${sessionScope.loginMember.c_genderK}
				<input readonly="readonly" name="c_genderK" type="radio" 
					checked="checked" value="${sessionScope.loginMember.c_genderK}">
					<input name="c_genderJ" value="${sessionScope.loginMember.c_genderJ}" type="hidden">
					</td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>국적</b></td>
				<td colspan="1"><input readonly="readonly" name="c_countryK" value="${sessionScope.loginMember.c_countryK}" >
									<input name="c_countryJ" value="${sessionScope.loginMember.c_countryJ}" type="hidden">
				
				</td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>일본어 레벨</b></td>
				<td colspan="1"><input name="" value="${langK[0] }" readonly="readonly"></td>
				
				<td colspan="1"><select name="c_language1">

						<option value="${langK[0] },${langJ[0] }">일본어 레벨 선택</option>
						<optgroup label="일본어">
							
							<option value="네이티브,ネイティブ">일어,네이티브</option>
							<option value="상급,上級">일어,상급</option>
							<option value="중급,中級">일어,중급</option>
							<option value="초급,初級">일어,초급</option>
							<option value="불가,不可">일어,전혀 못함</option>
							
							
						</optgroup>

				</select></td>
				
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>한국어 레벨</b></td>
				<td colspan="1"><input name="" value="${langK[1] }" readonly="readonly"></td>
				
				<td colspan="1"><select name="c_language2">

						<option value="${langK[1] },${langJ[1] }">한국어 레벨 선택</option>
						<optgroup label="한국어">
							
							<option value="네이티브,ネイティブ">한국어,네이티브</option>
							<option value="상급,上級">한국어,상급</option>
							<option value="중급,中級">한국어,중급</option>
							<option value="초급,初級">한국어,초급</option>
							<option value="불가,不可">한국어,전혀 못함</option>
							
						</optgroup>

				</select></td>
				
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>영어 레벨</b></td>
				<td colspan="1"><input name="" value="${langK[2]}" readonly="readonly"></td>
				
				<td colspan="1"><select name="c_language3">

						<option value="${langK[2] },${langJ[2] }">영어 레벨 선택</option>
						<optgroup label="영어">
							
							<option value="네이티브,ネイティブ">영어,네이티브</option>
							<option value="상급,上級">영어,상급</option>
							<option value="중급,中級">영어,중급</option>
							<option value="초급,初級">영어,초급</option>
							<option value="불가,不可">영어,전혀 못함</option>
							
						</optgroup>

				</select></td>
				
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>중국어 레벨</b></td>
				<td colspan="1"><input name="" value="${langK[3] }" readonly="readonly"></td>
				
				<td colspan="1">
				<select name="c_language4" >
						<option value="${langK[3]},${langJ[3]}"  >중국어 레벨 선택</option>
						<optgroup label="중국어">
							
							<option value="네이티브,ネイティブ">중국어,네이티브</option>
							<option value="상급,上級">중국어,상급</option>
							<option value="중급,中級">중국어,중급</option>
							<option value="초급,初級">중국어,초급</option>
							<option value="불가,不可">중국어,전혀 못함</option>
							
						</optgroup>

				</select>
				</td>
				
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호 질문</b></td>
				<td colspan="1"><input name="" value="${sessionScope.loginMember.c_pwqK}" readonly="readonly"></td>
				<td colspan="1">
					
				<select name="c_pwq" >

						<option value="${sessionScope.loginMember.c_pwqK},${sessionScope.loginMember.c_pwqJ}">질문 선택</option>
						<optgroup label="질문">
						<option value="좋아하는 음식,好きな食べ物">좋아하는 음식</option>
						<option value="사랑하는 사람,愛しい人">사랑하는 사람</option>
						<option value="나의 첫 여행장소,私の初めての旅先">나의 첫 여행장소</option>
						</optgroup>

				</select>
				
				</td>
				
			</tr>
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>비밀번호 대답</b></td>
				<td colspan="1"> <input type="text" name="c_pwans" value="${sessionScope.loginMember.c_pwans}" required="required" id="test" onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">  </td>
				
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b>이메일</b></td>
				<td colspan="1"> <input type="text" name="c_email" readonly="readonly" value="${sessionScope.loginMember.c_email}">  </td>
				
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			
			<tr>
				<td colspan="1"><b>사진</b></td>
				<td colspan="2"><img src="resources/img/${sessionScope.loginMember.c_photo }" style="max-width: 100px">
				<input type="file" name="c_photo"></td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="1"><b> 자기소개</b> </td>
				<td colspan="1"> <textarea name="c_comment" style="width:300px;height:200px;"> ${sessionScope.loginMember.c_comment }  </textarea>   </td>
			</tr>
			
			<tr>
			<td colspan="2"> <hr class="one"> </td>
			</tr>
			
			<tr>
				<td colspan="2" class="joinTd">
				<button class="button">수정</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="button4" type="button" onclick="byebye()">탈퇴</button>
				<br><br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>