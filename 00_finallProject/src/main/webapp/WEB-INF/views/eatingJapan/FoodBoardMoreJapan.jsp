<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>





<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">

var star = 'xx';

$(function () {
	
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  console.log($(this).attr("value"));
			
		  
		 star = $(this).attr("value")
		
		
		 
		});
	
	  
	 $('#starbutton').click(function () {
	    	
	    	var star2= star;
		
	    let snsComment = document.getElementById("snsComment").value; 
	    let token = document.getElementById("token").value; 
	    let sir_c_no = document.getElementById("sir_c_no").value; 
	    let f_no = document.getElementById("f_no").value; 
						
	   				if (star2 == 'xx') {
	   					alert("星をクリックしてください。" );
    		        	return false;
	   				}
					
	    				if (snsComment == "") {
	    		        	alert("コメントを入力してください。" );
	    		        	return false;
	    		        	
	    				}  
							
	    	 location.href = "food.write.reply?sir_c_star="+star2+'&sir_c_no='+sir_c_no+'&sir_c_comment='+snsComment+ '&token='+token + '&f_no=' +f_no;

						  
	   				
	    
	});
	

	
	
	
});


</script>


</head>
<body>

<div id="google_translate_element" style="display:none;"></div>
<!-- "새 번역 링크 UI" -->
<h3 style="text-align: center;"> 他言語への翻訳  </h3>		

<div class="translation-links" style="text-align: center;">
	<a href="javascript:void(0)" class="english" data-lang="en">English</a>
	
	<br>
	
	<a href="javascript:void(0)" class="japanese" data-lang="ja">日本語</a>
	
	
</div>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	/* 구글 번역 초기화 */
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'ko',autoDisplay: true}, 'google_translate_element');}
</script>
<script type="text/javascript">
	/* 새 UI 선택 클릭 이벤트가 발생하면
       감춤 처리한 구글 번역 콤보리스트에
       선택한 언어를 적용해 변경 이벤트를 발생시키는 코드  */
	document.querySelector('.translation-links').addEventListener('click',function(event) {
		let el = event.target;
		if(el != null){
			while(el.nodeName == 'FONT'){el = el.parentElement;}//data-lang 속성이 있는 태그 찾기
			const tolang = el.dataset.lang; // 변경할 언어 코드 얻기
			const gtcombo = document.querySelector('.goog-te-combo');
			if (gtcombo == null) {
				alert("Error: Could not find Google translate Combolist.");
				return false;
			}
			gtcombo.value = tolang; // 변경할 언어 적용
			gtcombo.dispatchEvent(new Event('change')); // 변경 이벤트 트리거
		}
		return false;
	});
</script>




	<table id="foodboardtable">

		<tr>

			<td colspan="2"><img class="foodmoreimg" src="resources/img2/${FoodBoard.f_photo1}"
				width="380" height="380" ></td>
			<td colspan="2"><img class="foodmoreimg" src="resources/img2/${FoodBoard.f_photo2}"
				width="380" height="380"></td>
			<td colspan="2"><img class="foodmoreimg" src="resources/img2/${FoodBoard.f_photo3}"
				width="380" height="380"></td>

		</tr>



		<tr>

			<td colspan="3">
				<h1>${FoodBoard.f_name}</h1>
			</td>

		</tr>

		<tr>
			<td colspan="3">${FoodBoard.f_address} <br> <br>
			</td>

		</tr>
		<tr>
			<td colspan="3">${FoodBoard.f_price}
				<hr>
			</td>

		</tr>



		<tr>
			<td colspan="4" class="foodInfor">${FoodBoard.f_infor}
				<hr>
			</td>

		</tr>

		<tr>

			<td colspan="3">
				<h2>施設およびサービス</h2>
			</td>
		</tr>

		<tr>
			<td colspan="1">${Foodser[0]}</td>
			<td colspan="1">${Foodser[1]}</td>
			<td colspan="1">${Foodser[2]}</td>


		</tr>
		<tr>

			<td colspan="1">${Foodser[3]}</td>
			<td colspan="1">${Foodser[4]}</td>
			<td colspan="1">${Foodser[5]}</td>

		</tr>

		<td colspan="3">
			<hr>
			<h2>連絡先</h2>
		</td>

		<tr>
			<td colspan="3">${FoodBoard.f_phone}
				<hr>
			</td>

		</tr>
		<tr>
			<td colspan="4" id="map" style="width: 70%; height: 250px;">
			<hr> <br>
			</td>

		</tr>
		
		<td colspan="3">
			<hr>
			<h2>平均評点</h2>
		</td>
		
		<tr>
			<td colspan="4" >&nbsp; 
			
			<%-- 	<c:choose>
 			   <c:when test="${avg == 0}">
				   평점이 아직 없습니다.
   			 	</c:when>

    			<c:otherwise>
				${avg}    
				</c:otherwise>

				</c:choose> --%>
			
			${avg} &nbsp; <br> &nbsp; レビュー個数 : ${size } 個
			
			<hr> 
			
			</td>

		</tr>


		<tr>
			<td colspan="2">
				<button type="button" onclick="gobackfood()" class="button5">前のページへ戻る</button>

			</td>

		</tr>


		<tr>
			<td colspan="4" id="smReplyArea">
				<hr> <c:forEach var="repl" items="${replys}">
					<c:choose>
						<c:when test="${repl.sir_c_writer == sessionScope.loginMember.c_id }">
							<span ondblclick="snsReplyDelete('${repl.sir_no}');"
								class="InforReplyIDMe" style="cursor: pointer;">${repl.sir_c_writer }
								さん </span>	
								/<fmt:formatDate value="${repl.sir_date }" type="both"
								dateStyle="short" timeStyle="short" />
							<br>

							<c:choose>
								<c:when test="${repl.sir_c_star ==5}">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>


								<c:when test="${repl.sir_c_star ==4.5 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==4 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==3.5 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==3 }">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">


								</c:when>
								<c:when test="${repl.sir_c_star ==2.5 }">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==2 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==1.5 }">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==1 }">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star == 0.5 }">
									<img src="resources/img2/starhalf.png" width="35" height="35">


								</c:when>


								<c:otherwise>
         						星を入れませんでした。
    							</c:otherwise>


							</c:choose>
						
						<br> <br>
						${repl.sir_c_comment }<br>
					<br>


							<form action="foodReplyDelect.go">
								<input name="sir_no" value="${repl.sir_no}" type="hidden">
								<input name="f_no" value="${FoodBoard.f_no }" type="hidden">

								<button class="FDButton">削除</button>
							</form>

						</c:when>
						<c:otherwise>
							<span class="InforReplyID">${repl.sir_c_writer} さん </span>
								/<fmt:formatDate value="${repl.sir_date }" type="both"
								dateStyle="short" timeStyle="short" />
								<br>
								
							<c:choose>

								<c:when test="${repl.sir_c_star ==5}">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>


								<c:when test="${repl.sir_c_star ==4.5 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==4 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==3.5 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==3 }">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">


								</c:when>
								<c:when test="${repl.sir_c_star ==2.5 }">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==2 }">
									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==1.5 }">

									<img src="resources/img2/star.png" width="35" height="35">
									<img src="resources/img2/starhalf.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star ==1 }">
									<img src="resources/img2/star.png" width="35" height="35">

								</c:when>
								<c:when test="${repl.sir_c_star == 0.5 }">
									<img src="resources/img2/starhalf.png" width="35" height="35">


								</c:when>


								<c:otherwise>
         						星を入れませんでした。
    						</c:otherwise>


							</c:choose>

					<br><br>
						${repl.sir_c_comment }
					<br>


						</c:otherwise>
					</c:choose>
					
					<hr >
					
				</c:forEach>
			</td>

		</tr>

		<tr>

			<c:if test="${sessionScope.loginMember.c_id != null}">
				<td colspan="3" id="i4">
					<form action="">
						<input id="token" name="token" value="${token }" type="hidden">
						<input id="sir_c_no" name="sir_c_no" value="${FoodBoard.f_no }" type="hidden"> 
						<input id="f_no" name="f_no" value="${FoodBoard.f_no }" type="hidden">



						<div class="starRev" >
							<span id="" class="starR1 on" value="0.5">별1_왼쪽</span> 
							<span class="starR2" value="1">별1_오른쪽</span>
							<span class="starR1" nvalue="1.5">별2_왼쪽</span> 
							<span class="starR2" value="2">별2_오른쪽</span>
							<span class="starR1" value="2.5">별3_왼쪽</span> 
							<span class="starR2" value="3">별3_오른쪽</span> 
							<span class="starR1" value="3.5">별4_왼쪽</span> 
							<span class="starR2" value="4">별4_오른쪽</span>
							<span class="starR1" value="4.5">별5_왼쪽</span> 
							<span class="starR2" value="5">별5_오른쪽</span>
						</div>

						&nbsp;

						<textarea id="snsComment" name="sir_c_comment" style="width: 500px; height: 90px;" placeholder="レビューを入力してください。" onfocus="this.placeholder=''" onblur="this.placeholder='レビューを入力してください。'"></textarea>
						<br>
						<button type="button" class="button" id="starbutton">レビューを書く</button>
						<br>
						<br>
					</form>
				</td>


			</c:if>

		</tr>




	</table>



	<!-- <div id="map" style="width:70%;height:250px;"></div>
 -->
	<!-- <div id="clickLatlng"></div>
 -->







	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=edc6d0f3632099a1468db9e97b3e90cf&libraries=services"></script>
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