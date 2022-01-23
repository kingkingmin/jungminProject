<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="ex_form" action="inforwrite.go" method="post" enctype="Multipart/form-data">
		<table id="inforWritetable" border="1">
			<tr>
			
				<td colspan="5">  
				
				<div id="clickLatlng"></div>
		<div id="map" style="width: 100%; height: 350px;"></div>
		<input name="f_mapinfo1" value=""  > <!--  type="hidden" --> 
		<input name="f_mapinfo2" value="" > 
		<input name="f_mapinfo3" value=""  > 
		<input id="input" name="f_mapinfoName" value="영등포"><br>
				
				</td>
				
				</tr>	

		
		</table>

	</form>
					<button type="button" onclick="input()">장소 검색 하기 </button>

		<p>
			<em>지도를 클릭해주세요!</em>
		</p>
		
		
		



	<div class="map_wrap">
		<div id="map"style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
		<div class="hAddr">
			<span class="title">지도중심기준 행정동 주소정보</span> <span id="centerAddr"></span>
		</div>
	</div>



	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=edc6d0f3632099a1468db9e97b3e90cf&libraries=services"></script>
	<script>
		// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.54816986519656, 126.91218602127428), // 지도의 중심좌표 //20210812
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다

		var markerPosition  = new kakao.maps.LatLng(37.54816986519656, 126.91218602127428);   //20210812

		var marker = new kakao.maps.Marker({
		    position: markerPosition
		})
		marker.setMap(map);


		var ps = new kakao.maps.services.Places();
		////////////////////////////////////////////////////////////  20210811/////////////////////////////////////////
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
    infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다

// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
searchAddrFromCoords(map.getCenter(), displayCenterInfo);

// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
            
            var content = '<div class="bAddr">' +
                            '<span class="title">새로운 마크 주소정보</span>' + 
                            detailAddr + 
                        '</div>';

            // 마커를 클릭한 위치에 표시합니다 
            marker.setPosition(mouseEvent.latLng);
            marker.setMap(map);
            
            var pleasego3 = detailAddr;
            document.ex_form.f_mapinfo3.value = pleasego3;
            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
            infowindow.setContent(content);
            infowindow.open(map, marker);
        }   
    });
});

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
 
// 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다

//////////////////////////////////////////////////////////////////// 20210811  ///////////////////////////////
		
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

			// 클릭한 위도, 경도 정보를 가져옵니다 
			var latlng = mouseEvent.latLng;

			// 마커 위치를 클릭한 위치로 옮깁니다
			marker.setPosition(latlng);

			var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
			message += '경도는 ' + latlng.getLng() + ' 입니다';

			var pleasego1 = latlng.getLat();
			var pleasego2 = latlng.getLng();

			//var resultDiv = document.getElementById('clickLatlng');
			//resultDiv.innerHTML = message;

			document.ex_form.f_mapinfo1.value = pleasego1;
			document.ex_form.f_mapinfo2.value = pleasego2;

		});

		//////////////////////
				//ps.keywordSearch('합정', placesSearchCB);


		function input() {
			var input = document.getElementById("input").value;
			ps.keywordSearch(input, placesSearchCB);
		}
		
		
		
		// 키워드로 장소를 검색합니다

		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				var bounds = new kakao.maps.LatLngBounds();

				for (var i = 0; i < data.length; i++) {
					displayMarker(data[i]);
					bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
				}

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
				map.setBounds(bounds);
				displayMarker(bounds);
			}
		}

		function displayMarker(place) {
			// 마커를 생성하고 지도에 표시합니다
			  /*  var marker = new kakao.maps.Marker({
			      map: map,
			      position: new kakao.maps.LatLng(33.450701, 126.570667); 
			  });  */
			  var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 
			  
			var marker = new kakao.maps.Marker({
				// 지도 중심좌표에 마커를 생성합니다 
				  position: markerPosition

				//position : map.getCenter()
			});
			marker.setMap(map); 

			// 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

				// 클릭한 위도, 경도 정보를 가져옵니다 
				var latlng = mouseEvent.latLng;

				// 마커 위치를 클릭한 위치로 옮깁니다
				marker.setPosition(latlng);

				var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
				message += '경도는 ' + latlng.getLng() + ' 입니다';

				var pleasego1 = latlng.getLat();
				var pleasego2 = latlng.getLng();

				//var resultDiv = document.getElementById('clickLatlng');
				//resultDiv.innerHTML = message;

				document.ex_form.f_mapinfo1.value = pleasego1;
				document.ex_form.f_mapinfo2.value = pleasego2;

			});

		}
		
		
		
		
	</script>
</body>
</html>