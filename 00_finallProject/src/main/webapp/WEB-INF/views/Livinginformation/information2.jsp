<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >


	
	<c:if test="${sessionScope.loginMember.c_id !=null }">
		<form action="informationWrite.go">
			<br><br>
			<button class="WriteInforButton">
				<h3>글 작성하러 가기</h3>
			</button>
			<br>
		</form>
	</c:if>

	<c:if test="${curPage != 1 }">
		<div align="center" id="snsL3" onclick="inforPageChangeK2(${curPage - 1 });">
			<div class="paging">◀</div>
		</div>
	</c:if>
	<c:if test="${curPage != allPageCount }">
		<div align="center" id="snsR3"
			onclick="inforPageChangeK2(${curPage + 1 });">
			<div class="paging">▶</div>
		</div>
	</c:if>





	<table  class="tableforsearch">

		<tr>
			<td >
			<br>
				<form action="findinforbysearch.go" >
			
					<input type="text" name="contentsearch" style="width:190px;height:35px; border-style: inset;">
					
						<select name="f_category" style="width:70px;height:37px;" >
									<option value= null>선택</option>
									<option value="title">제목</option>
									<option value="content">내용</option>
									<option value="writter">작성자</option>
							</select>


					<button class="button">검색</button>
					<button type="button" onclick="gobackinfor()" class="button4">전체</button>
				</form>
							<br> 
							<span ID="pagenow">Page Now : ${curPage } </span>
							<hr class="one">	
				
			</td>

		</tr>
		

	</table>
	

	<table  class="tableforsearch">

		<tr>
			<td>
				<form action="findbyinfoVerK2.go">
					<table class="tableforsearch">

						<tr>

							<td colspan="2">카테고리</td>
							<td colspan="2">
							<select name="f_category" onchange="categorySearchK(this)" style="width:180px;height:35px;">
									<option>선택</option>
									<option value="사고팔기">사고팔기</option>
									<option value="일하기">일하기</option>
									<option value="배우기">배우기</option>
									<option value="살기">살기</option>
							</select>
							</td>

						</tr>

						<tr>

							<td colspan="2">종류</td>
							<td colspan="2"><select name="f_sort" id="good" style="width:180px;height:35px;">
									<option>선택</option>
							</select></td>
						</tr>
					</table>	
					<br>
					<button class="button">검색</button>
					<br><br>
				</form>
			</td>

		</tr>

	</table>
	

<table id="inforoutside">

<tr>

<td>


	<c:forEach var="m" items="${inforboardfirst}">
					
			
			<br>
		<a href="findinforBoardMore.go?f_no=${m.f_no}">

			<table class="infortable2" >

				<tr>

					<td colspan="4" id="titleinfor"> <br>  ${m.f_title } </td>
				</tr>

				<tr>
					<td colspan="2"> ${m.f_categoryK} / [${m.f_sortK}]</td>
					<td colspan="2" class="inforleft">${m.f_mapinfo3 }</td>

				</tr>
				<tr>
					<td colspan="2">작성일: <fmt:formatDate value="${m.f_date}" type="both" dateStyle="short" timeStyle="short"/></td>
					<td colspan="2" class="name">작성자: ${m.f_writter}</td>

				</tr>
				
				
			</table>
			
		</a>
		
	</c:forEach>
			
</td>
</tr>
</table>
	
			<br>
			<span ID="pagenow2">Page Now : ${curPage } </span>
		<table class= "numberchangetable">
		
		<tr>
		
		<%-- <td>
		<c:if test="${ allPageCount > 6 }">
		<div align="center" id="inforL"  onclick="inforPageChange(${6});">
			<div class="paging">◀</div>
		</div>
	</c:if>
		
		</td> --%>
		
		
	<c:forEach var="a" begin="1" end="${allPageCount}" step="1">
			<c:if test="${ a < 7  and curPage < 7}">
		<td>
			<div align="center" id="pagechangego" onclick="inforPageChangeK2(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 5 }">
		<td>
		<div align="center" id="inforR"  onclick="inforPageChangeK2(${7});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a > 5 }">
		<td>
		<div align="center" id="infor"  onclick="inforPageChangeK2(${allPageCount});">
			<div class="paging">End</div>
			</div>
		</td>
		</c:if>
		
		
			</c:if>
			<!--                   7부터는 밑으로                                          -->
			
			<c:if test="${ curPage > 6  and a  <  13 and a > 6}">
		<c:if test="${ a < 8 }">
		<td>
		<div align="center" id="infor"  onclick="inforPageChangeK2(${1});">
			<div class="paging">First</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a < 8 }">
		<td>
		<div align="center" id="inforL"  onclick="inforPageChangeK2(${6});">
			<div class="paging">◀</div>
			</div>
		</td>
		</c:if>


		<td>
			<div align="center" id="pagechangego" onclick="inforPageChangeK2(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 11 }">
		<td>
		<div align="center" id="inforR"  onclick="inforPageChangeK2(${13});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
			</c:if>
			
			<!--                   13부터는 밑으로                                          -->
			
		<c:if test="${ curPage > 12  and a  <  19 and a > 12}">
		<c:if test="${ a < 14 }">
		<td>
		<div align="center" id="infor"  onclick="inforPageChangeK2(${1});">
			<div class="paging">First</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a < 14 }">
		<td>
		<div align="center" id="inforL"  onclick="inforPageChangeK2(${12});">
			<div class="paging">◀</div>
			</div>
		</td>
		</c:if>


		<td>
			<div align="center" id="pagechangego" onclick="inforPageChangeK2(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 17 }">
		<td>
		<div align="center" id="inforR"  onclick="inforPageChangeK2(${18});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
			</c:if>	
		
		
		
		
			
			
	</c:forEach>
		
		
		</tr>
		
		</table>

	<br> <br>
	
</body>
</html>