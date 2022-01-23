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
<body>




	<c:if test="${curPage != 1 }">
		<div align="center" id="snsL3" onclick="foodPageChange(${curPage - 1 });">
			<div class="paging">◀</div>
		</div>
	</c:if>
	<c:if test="${curPage != allPageCount }">
		<div align="center" id="snsR3"
			onclick="foodPageChange(${curPage + 1 });">
			<div class="paging">▶</div>
		</div>
	</c:if>



<!-- border="1" -->

	<table  class="tableforsearch">
	
	<tr>
		<td >
			<form action="showfoodboardSearch.go">
			
					<!-- 이름 검색: <input name="c_name"> -->
					<input name="f_name" placeholder="韓国語でレストランの名前を検索してください。" style="width:290px;height:35px; border-style: inset;">
			&nbsp;&nbsp;
				<button class="button">検索	</button>&nbsp;
				<button type="button" onclick="gobackfood()" class="button4">全体</button>
			</form>
		</td>	
	
	</tr>
	
	
	</table>
	
	<span ID="pagenow">Page Now : ${curPage } </span>	
	
	<hr>
	<table  class="tableforsearch">
	
	
	<tr>
						<td colspan="1"> <a href="showfoodboardSearch.go?f_kind=돼지고기">#豚肉</a> </td>
					 	<td colspan="1"> <a href="showfoodboardSearch.go?f_kind=소고기">#牛肉</a> </td>
					 	<td colspan="1"> <a href="showfoodboardSearch.go?f_kind=밀가루,국수">#麺、冷麺</a> </td>
					 	<td colspan="1"> <a href="showfoodboardSearch.go?f_kind=탕,국밥">#クッパ</a> </td>
					 	<td colspan="1"> <a href="showfoodboardSearch.go?f_kind=게장">#ケジャン</a> </td>
					 	<td colspan="1"> <a href="showfoodboardSearch.go?f_kind=기타">#etc</a>  </td>
	
	
	</tr>
	
	
	</table>
<br> <hr>

	<table>
		<tr>
	<c:forEach var="m" items="${FoodBoard}"  begin="0" end="1" step="1">
		<td>
		<a href="showfoodboardMore.go?f_no=${m.f_no}">
				

			<table class="foodtable">

				<tr>

					<td colspan="3"><img src="resources/img2/${m.f_photo2}"
						width="500" height="250" style="object-fit: cover;"></td>

				</tr>
				<tr>

					<td colspan="3">
						<h2>${m.f_name}</h2>
					</td>
				</tr>


				<tr>

					<td colspan="3">
						<hr> ${m.f_address}
					</td>

				</tr>
				<tr>
					<td colspan="3">${m.f_kind}</td>

				</tr>


			</table> 
			
		</a>
		</td>
	</c:forEach>
		</tr>
		
			<tr>
	<c:forEach var="m" items="${FoodBoard}"  begin="2" end="3" step="1">
		<td>
		<a href="showfoodboardMore.go?f_no=${m.f_no}">
				

			<table class="foodtable">

				<tr>

					<td colspan="3"><img src="resources/img2/${m.f_photo2}"
						width="500" height="250" style="object-fit: cover;"></td>

				</tr>
				<tr>

					<td colspan="3">
						<h2>${m.f_name}</h2>
					</td>
				</tr>


				<tr>

					<td colspan="3">
						<hr> ${m.f_address}
					</td>

				</tr>
				<tr>
					<td colspan="3">${m.f_kind}</td>

				</tr>


			</table> 
			
		</a>
		</td>
	</c:forEach>
		</tr>
		
			<tr>
	<c:forEach var="m" items="${FoodBoard}"  begin="4" end="5" step="1">
		<td>
		<a href="showfoodboardMore.go?f_no=${m.f_no}">
				

			<table class="foodtable">

				<tr>

					<td colspan="3"><img src="resources/img2/${m.f_photo2}"
						width="500" height="250" style="object-fit: cover;"></td>

				</tr>
				<tr>

					<td colspan="3">
						<h2>${m.f_name}</h2>
					</td>
				</tr>


				<tr>

					<td colspan="3">
						<hr> ${m.f_address}
					</td>

				</tr>
				<tr>
					<td colspan="3">${m.f_kind}</td>

				</tr>


			</table> 
			
		</a>
		</td>
	</c:forEach>
		</tr>
		
	</table>
	
	<br> <br>
			
	<span ID="pagenow2">Page Now : ${curPage } </span>
		<table  class= "numberchangetable">
		
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
			<div align="center" id="pagechangego" onclick="foodPageChange(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 6 }">
		<td>
		<div align="center" id="inforR"  onclick="foodPageChange(${7});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a > 5 }">
		<td>
		<div align="center" id="infor"  onclick="foodPageChange(${allPageCount});">
			<div class="paging">End</div>
			</div>
		</td>
		</c:if>
		
		
			</c:if>
			<!--                   7부터는 밑으로                                          -->
			
			<c:if test="${ curPage > 6  and a  <  13 and a > 6}">
		<c:if test="${ a < 8 }">
		<td>
		<div align="center" id="infor"  onclick="foodPageChange(${1});">
			<div class="paging">First</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a < 8 }">
		<td>
		<div align="center" id="inforL"  onclick="foodPageChange(${6});">
			<div class="paging">◀</div>
			</div>
		</td>
		</c:if>


		<td>
			<div align="center" id="pagechangego" onclick="foodPageChange(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 12 }">
		<td>
		<div align="center" id="inforR"  onclick="foodPageChange(${13});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
			</c:if>
			
			<!--                   13부터는 밑으로                                          -->
			
		<c:if test="${ curPage > 12  and a  <  19 and a > 12}">
		<c:if test="${ a < 14 }">
		<td>
		<div align="center" id="infor"  onclick="foodPageChange(${1});">
			<div class="paging">First</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a < 14 }">
		<td>
		<div align="center" id="inforL"  onclick="foodPageChange(${12});">
			<div class="paging">◀</div>
			</div>
		</td>
		</c:if>


		<td>
			<div align="center" id="pagechangego" onclick="foodPageChange(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 18 }">
		<td>
		<div align="center" id="inforR"  onclick="foodPageChange(${18});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
			</c:if>	
		
		
		
		
			
			
	</c:forEach>
		
		
		</tr>
		
		</table>


</body>
</html>