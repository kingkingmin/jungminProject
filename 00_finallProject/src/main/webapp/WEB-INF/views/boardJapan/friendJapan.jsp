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
		<div align="center" id="snsL"
			onclick="snsPageChange(${curPage - 1 });">
			<div class="paging">◀</div>
		</div>
	</c:if>
	<c:if test="${curPage != allPageCount }">
		<div align="center" id="snsR"
			onclick="snsPageChange(${curPage + 1 });">
			<div class="paging">▶</div>
		</div>
	</c:if>


	<table  class="tableforsearch">
	
	<tr>
		<td >
			<form action="findname.go">
			
					名前 : <input name="search" style="width:150px;height:30px; border-style: inset;">
			&nbsp;
				<button class="button">検索</button>
			</form>
		</td>	
	
	</tr>
	
	
	</table>
	
	<span ID="pagenow">Page Now : ${curPage } </span>
	
	<table  class="tableforsearch">
	
	<tr>
		<td > <hr>
			<form action="findbyinfo.go">
			
				 性別  : <select name="c_gender" style="width:100px;height:35px;">
						<option value="">性別 </option>
						<option value="남">男</option>
						<option value="여">女</option>
				</select>
					
					<br> <br> 
					 
				 母国 : <select name="c_country" style="width:100px;height:35px;">
						<option value="">国</option>
						<option value="한국">韓国</option>
						<option value="일본">日本</option>
						<option value="기타">etc</option>
				</select>  
				<br><br>
			
				<button class="button">検索</button>&nbsp;&nbsp;
				<button class="button4" type="button" onclick="gobackfriend()">全体</button>
				
			</form>
		</td>	
	
	</tr>
	
	</table>
	
	<br>
	

	<c:forEach var="m" items="${friends}">
	
		<a  href="findfriendmore.go?c_id=${m.c_id}"> 
			<hr> <br> 
			<table class="friendtable" >
				
				
				
				<tr>
					<td rowspan="3"  class="friendimg">
					
					<img alt=""
						src="resources/img/${m.c_photo }" width="160" height="160"><br> <hr> </td>
				</tr>

				<tr>
					<td rowspan="1" id="name" colspan="1"> ${m.c_name }  </td>
					<td rowspan="1" colspan="1">性別 :   ${m.c_genderJ }   </td>
					<td rowspan="1" colspan="1">国:   ${m.c_countryJ }   </td>
					
				</tr>
			
				<tr>
					<td class="story" colspan="3" rowspan="1"> ${m.c_comment}
							
					</td>
				</tr>
			</table>
			
		</a>
		
 	</c:forEach>

	
	
		<br>
		
		<span ID="pagenow3">Page Now : ${curPage } </span>
		
		<table  class= "numberchangetable">
		
		
		<tr>
		
		
<%-- 	<c:forEach var="a" begin="1" end="${allPageCount}" step="1">
		
		<td>
			<div align="center" id="pagechangego2" onclick="snsPageChange(${a});">
			<div class="paging">${a } </div>
			</div>

		</td>
	</c:forEach> --%>
		
		<!-- ㄴㅁㅇㅁㄴㅇㅇㅁㄴㅇㄴㅁㅇㅁㄴ -->
		
		<c:forEach var="a" begin="1" end="${allPageCount}" step="1">
			<c:if test="${ a < 7  and curPage < 7}">
		<td>
			<div align="center" id="pagechangego2" onclick="snsPageChange(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 5 }">
		<td>
		<div align="center" id="inforR"  onclick="snsPageChange(${7});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a > 5 }">
		<td>
		<div align="center" id="infor"  onclick="snsPageChange(${allPageCount});">
			<div class="paging">End</div>
			</div>
		</td>
		</c:if>
		
		
			</c:if>
			<!--                   7부터는 밑으로                                          -->
			
			<c:if test="${ curPage > 6  and a  <  13 and a > 6}">
		<c:if test="${ a < 8 }">
		<td>
		<div align="center" id="infor"  onclick="snsPageChange(${1});">
			<div class="paging">First</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a < 8 }">
		<td>
		<div align="center" id="inforL"  onclick="snsPageChange(${6});">
			<div class="paging">◀</div>
			</div>
		</td>
		</c:if>


		<td>
			<div align="center" id="pagechangego2" onclick="snsPageChange(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 11 }">
		<td>
		<div align="center" id="inforR"  onclick="snsPageChange(${13});">
			<div class="paging">▶</div>
			</div>
		</td>
		</c:if>
		
			</c:if>
			
			<!--                   13부터는 밑으로                                          -->
			
		<c:if test="${ curPage > 12  and a  <  19 and a > 12}">
		<c:if test="${ a < 14 }">
		<td>
		<div align="center" id="infor"  onclick="snsPageChange(${1});">
			<div class="paging">First</div>
			</div>
		</td>
		</c:if>
		
		<c:if test="${ a < 14 }">
		<td>
		<div align="center" id="inforL"  onclick="snsPageChange(${12});">
			<div class="paging">◀</div>
			</div>
		</td>
		</c:if>


		<td>
			<div align="center" id="pagechangego2" onclick="snsPageChange(${a});">
			<div class="paging">${a } </div>
			</div>
		</td>
		
		<c:if test="${ a > 17 }">
		<td>
		<div align="center" id="inforR"  onclick="snsPageChange(${18});">
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