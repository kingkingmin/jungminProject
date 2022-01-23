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
		<div align="center" id="snsL2"
			onclick="snsForMailPageChange(${curPage - 1 });">
			<div class="paging">◀</div>
		</div>
	</c:if>
	<c:if test="${curPage != allPageCount }">
		<div align="center" id="snsR2"
			onclick="snsForMailPageChange(${curPage + 1 });">
			<div class="paging">▶</div>
		</div>
	</c:if>
	
	<span ID="pagenow">Page Now : ${curPage } </span>	
	<br>
	<h1>클릭해서 확인하세요</h1>
	<br><br>
	
	<table id="tableUpBar" style="text-align: left;"  >
				<tr >
					<td colspan="1" >보낸사람</td>
					<td colspan="1">보낸시간 </td>
				</tr>
	
	</table>	
	
	
	 <c:forEach var="k" items="${message}">
		<a href="checkmessage.go?c_no=${k.c_no}">
			<table class="tableforsearch" >
				
			
				<tr>
					<td colspan="1" class="messageTitle">${k.c_sender }</td>
					<td colspan="1"><fmt:formatDate value="${k.c_date }" type="both" dateStyle="short" timeStyle="short"/>
					
					</td>
				</tr>
				
				

				<tr>
					<td colspan="2">	
					<input name="token" value="${token }" type="hidden">
					<input name="c_id"  value="${k.c_sender }" type="hidden">
					 <hr> 
					</td>
					
				</tr>

			</table>
			
 	</a>
 	</c:forEach>  
 	
 	<br> <hr class="one">
		<table  class= "numberchangetable">
		
		<tr>
		
	<c:forEach var="a" begin="1" end="${allPageCount}" step="1">
		
		<td>
			<div align="center" id="pagechangego3" onclick="snsForMailPageChange(${a});">
			<div class="paging">${a } </div>
			</div>

		</td>
	</c:forEach>
		
		</tr>
		
		</table>

</body>
</html>