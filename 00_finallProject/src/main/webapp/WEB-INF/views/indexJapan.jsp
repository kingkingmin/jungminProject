<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <script type="text/javascript" src="resources/js/js.js"></script>

<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/join.css">
<link rel="stylesheet" href="resources/css/friend.css">
<link rel="stylesheet" href="resources/css/infor.css">
<link rel="stylesheet" href="resources/css/food.css">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table  id ="topbar" colspan="7" style="text-align:center">

<tr>

	<td> <a href="home.go">Home</a>  </td>
	
	
	
	<td>
	 
	 <c:if test="${sessionScope.loginMember.c_id !=null }">
<!-- && sessionScope.loginMember.c_id !=friends.c_id  -->
				<form action="seemail.go">
				<button id="buttontopmail">Mail</button>
				</form>
					</c:if>
	 
	 </td>
	
	
	
	<td> <a href="showfoodboard.go">おいしい店お勧め</a> </td>
	<td> <a href="findfriend.go">友達探し</a>  </td>
	<td> <a href="LivingInformation.go">生活情報掲示板</a>  </td>
	<td> 
	
	 <c:if test="${sessionScope.loginMember.c_id == 'q' }">
				<form action="foodcontro.go">
				<button>飲食管理ページ</button>
				</form>
					</c:if>
	
	
	</td>

</tr>


</table>

<br>
<span ID="pagenow">${r} </span>
<br>

<table id ="indexbottom">

<tr>

<td>

<table  id ="loginArea" colspan="2" style="text-align:center">

		<tr>
			<td><jsp:include page="${loginPage }"></jsp:include></td>
		</tr>

	</table>


</td>

<td>

<table  id="siteContentArea" colspan="5" style="text-align:center">

		<tr>
			<td><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>

	</table>

</td>


</tr>

</table>




	


</body>
</html>