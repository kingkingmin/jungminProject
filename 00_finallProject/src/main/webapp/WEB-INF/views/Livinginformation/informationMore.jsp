<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        
    
<!DOCTYPE html>
<html>

<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {

		
		//$('button').click(function() {
		$("#i1").val(function() {

			let inputVal = $("#i1").val();

			$.ajax({
				// type 설정
				type : 'GET',
				// 서버로 보낼 주소 입력 
				url : "/last/menu.get.json.block",
				// 사용자가 입력한 값 서버로
				data : {
					"c_user" : inputVal
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
		//alert(data[0]["c_blocker"]);
		
		$.each(data, function(i) {
				//console.log(data[i]);
			let hh = data[i].c_blocker;
			console.log(hh);

			if (hh === $("#i2").val()) {
				
				$('#i4').css('visibility', 'hidden');
				$('#mainTbl2').append(" 차단당하셨습니다 댓글은 불가능합니다  ");

				$("#i1").val()="";			
				
			} else {
				$('#i4').css('visibility', 'visible');

			}


		});

	}
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >



			<table id="inforWritetable2">

				<tr>
				
					<td colspan="6" >  <h3> ${inforboard.f_title }</h3>   </td>
					
				</tr>
				
				<tr>
				<td colspan="6">
				<br> 
				</td>
				</tr>
				
				<tr>
					<td colspan="2" ><b>  ${inforboard.f_categoryK} / [${inforboard.f_sortK}] </b></td>
					<td colspan="4" > <b>${inforboard.f_mapinfo3 }</b></td>

				</tr>
				
				<tr>
				<td colspan="6">
				 <hr> 
				</td>
				</tr>
				
				
				<tr>
					<td colspan="3" ><b>작성일 : </b><fmt:formatDate value="${inforboard.f_date}" type="both" dateStyle="short" timeStyle="short"/></td>
					<td colspan="3" ><b>작성자 : </b> ${inforboard.f_writter}</td>

				</tr>
				
				<tr>
				<td colspan="6">
				 <hr> 
				</td>
				</tr>
				
				
				<tr>
				
				<td colspan="6" >${inforboard.f_story}  </textarea>    </td>
				
				</tr>
			
				<tr>
				<td colspan="6">
				 <br><br> 
				</td>
				</tr>
				
				<tr>
				<td colspan="6" id="map" style="width:70%;height:250px;">   </td>
				
				</tr>
				
				<tr>
				<td colspan="6">
				 <br><br> 
				</td>
				</tr>
				
				
				<tr>
				<td colspan="6" >
				<c:if test="${inforboard.f_photo eq 'asd'}">
					등록된 사진이 없습니다
				</c:if>
				<c:if test="${inforboard.f_photo ne 'asd'}">
				<img src="resources/img/${inforboard.f_photo}" style="max-width: 230px">
				</c:if>
				<br> <hr><br>
				
				</td>
				
			</tr>
			
			<tr>
			<td colspan="2">
				<button type="button" onclick="gobackinfor()" class="button4">뒤로 가기</button>
			</td>
			<td colspan="2">
			
			 <c:if test="${sessionScope.loginMember.c_id == inforboard.f_writter }">

				<%-- <form action="delectInfor.go" onsubmit="return checkdelect(); ">
				<input name="f_no" value="${inforboard.f_no }" type="hidden">
				</form> --%>
				<button type="button" onclick="checkdelect(${inforboard.f_no })" class="button">글 삭제</button>
					
					</c:if> 
			
			</td>
				
			
			<td colspan="2">
			
			 <c:if test="${sessionScope.loginMember.c_id == inforboard.f_writter }">

				<form action="UpdateInfor.go">
				<input name="f_no" value="${inforboard.f_no }" type="hidden">
				
				<button class=buttonInforUpdate>글 수정</button>
				</form>
					
					</c:if> 
			
			</td>
			</tr>
			
			<tr>
				<td colspan="6">
				 <br> <hr> 
				</td>
				</tr>
			
			
			<tr>
					<td colspan="6" id="smReplyArea">
						 <c:forEach var="repl" items="${replys}">
						<c:choose>
							<c:when test="${repl.sir_c_writer == sessionScope.loginMember.c_id }">
								<span ondblclick="snsReplyDelete('${repl.sir_no}');" class="InforReplyIDMe" style=" cursor:pointer;" >${repl.sir_c_writer } 님  </span>	
								/<fmt:formatDate value="${repl.sir_date }" type="both" dateStyle="short" timeStyle="short"/>
								<br><br>
								
								<form action="InforReplyDelect.go">
								<input name="sir_no" value="${repl.sir_no}" type="hidden">
								 <input name="f_no" value="${inforboard.f_no }" type="hidden"> 
								
									<button class="button4">삭제</button>
								</form>
								
							</c:when>
							<c:otherwise>
								<span class="InforReplyID" >${repl.sir_c_writer} 님 </span>
								/<fmt:formatDate value="${repl.sir_date }" type="both" dateStyle="short" timeStyle="short"/>
							</c:otherwise>
						</c:choose>
						<br>
						${repl.sir_c_comment }<br><br> <hr style="dashed blue;">
					
					</c:forEach>
					</td>
			
			</tr>
			
			<tr>
			
			<c:if test="${sessionScope.loginMember.c_id != null}">
					<td colspan="6" id="i4">
					<form action="sns.write.reply"
						onsubmit="return snsWriteReplyCheck(this)">
						<input name="token" value="${token }" type="hidden"> 
						<input name="sir_c_no" value="${inforboard.f_no }" type="hidden"> 
 						<input name="f_no" value="${inforboard.f_no }" type="hidden"> 
 						
						<textarea id="snsCom" name="sir_c_comment" style="width: 500px; height: 90px;" placeholder="글을 입력해 주세요." onfocus="this.placeholder=''" onblur="this.placeholder='글을 입력해 주세요.'"></textarea>
						&nbsp;
						<button class="button">댓글 쓰기</button>

					</form>
				</td>
	

			</c:if> 
				
			</tr>
			
			<tr>
				<td id="mainTbl2" colspan="4"></td>
				
				<td colspan="1"> <input id="i1" value="${sessionScope.loginMember.c_id }" type="hidden">  </td>
					<td colspan="1"> <input id="i2" value="${inforboard.f_writter}" type="hidden">  </td>
				</tr>
			
			
			</table>



<!-- <div id="map" style="width:70%;height:250px;"></div>
 -->
<!-- <div id="clickLatlng"></div>
 -->






	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=edc6d0f3632099a1468db9e97b3e90cf&libraries=services"></script>
<script>

/* alert(${value1});
alert(${value2});
alert("${value3}");
alert("${value4}"); */

var result1 = ${value1};
var result2 = ${value2};
var result3 = "${value4}";

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(result1, result2), // 지도의 중심좌표
        level: 2 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다


ps.keywordSearch(result3, placesSearchCB);  



//키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
 if (status === kakao.maps.services.Status.OK) {

     // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
     // LatLngBounds 객체에 좌표를 추가합니다
     var bounds = new kakao.maps.LatLngBounds();

     for (var i=0; i<data.length; i++) {
         displayMarker(data[i]);    
         bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
     }       

     // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
     map.setBounds(bounds);
 } 
}



function displayMarker(place) {

	  var markerPosition  = new kakao.maps.LatLng(result1 , result2 ); 
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	  position: markerPosition
	});
	  
	marker.setMap(map);
    map.setBounds(map);

	}
/////////////////////////////////////////////////////////20210811


		// 주소-좌표 변환 객체를 생성합니다
/* 		var geocoder = new kakao.maps.services.Geocoder();
    infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
 */
	//var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다

// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다

// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
searchAddrFromCoords(map.getCenter(), displayCenterInfo);

// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
//kakao.maps.event.addListener(map, markerPosition, function(mouseEvent) {
    searchDetailAddrFromCoords(markerPosition, function(result, status) {
       // if (status === kakao.maps.services.Status.OK) {
            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
            
            var content = '<div class="bAddr">' +
                            '<span class="title">법정동 주소정보</span>' + 
                            detailAddr + 
                        '</div>';

            // 마커를 클릭한 위치에 표시합니다 
            /* marker.setPosition(mouseEvent.latLng);
            marker.setMap(map); */

            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
            infowindow.setContent(content);
            infowindow.open(map, position);
        //}   
   });
//});

// 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', function() {
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
});

function searchAddrFromCoords(coords, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
}

function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}

// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
function displayCenterInfo(result, status) {
    if (status === kakao.maps.services.Status.OK) {
        var infoDiv = document.getElementById('centerAddr');

        for(var i = 0; i < result.length; i++) {
            // 행정동의 region_type 값은 'H' 이므로
            if (result[i].region_type === 'H') {
                infoDiv.innerHTML = result[i].address_name;
                break;
            }
        }
    }    
}
/////////////////////////////////////////////////////////////////////////////////



</script>
</body>
</html>