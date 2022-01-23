function joinGo() {
	
		 location.href = 'member.join.go';
}
function findGo() {
	
		 location.href = 'findpassword.go';
}
function gobackfriend() {
	
		 location.href = 'findfriend.go';
}
function gobackinfor() {
	
		 location.href = 'LivingInformation.go';
}
function gobackfood() {
	
		 location.href = 'showfoodboard.go';
}
function gobackmessage() {
	
		 location.href = 'seemail.go';
}


function noSpaceForm(obj) { // 공백사용못하게
    var str_space = /\s/;  // 공백체크
    if(str_space.exec(obj.value)) { //공백 체크
        alert("해당 항목에는 공백을 사용할수 없습니다.\n공백은 자동적으로 제거 됩니다.");
        obj.focus();
        obj.value = obj.value.replace(' ',''); // 공백제거
        return false;
    }
 // onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
}

function can() {
	
	var i1 = document.getElementById('pw_1');
	var i2 = document.getElementById('pw_2');
	
if(i1.value != i2.value){ 
	alert('비밀번호 불일치입니다, 다시 확인해주세요')
	return false;
	}else{
		return true;
	}


}
function can2() {
	
	var i1 = document.getElementById('pw_1');
	var i2 = document.getElementById('pw_2');
	
if(i1.value != i2.value){ 
	alert('暗証番号不一致です、もう一度確認してください ')
	return false;
	}else{
		return true;
	}


}

function logout(){
	let ok = confirm('로그아웃 하시겠습니까? \n ログアウトしますか。');
	if(ok){
		location.href='member.logout';
	}
	
}
function checkdelect(pp){
	let ok = confirm('정말 지울거에요?\n 本当に消しますか。 ');
	
	if(ok){
		location.href='delectInfor.go?f_no='+pp;
	}
	
}




function delectmessage(pp){
	let ok = confirm('메세지를 삭제 하시겠습니까? \n メッセージを削除しますか。');
	
	if(ok){
		location.href='delectmessage.go?c_no='+pp;
	}
	
}

function memberInfoGo(){
	location.href='member.info.go';
}

function byebye(){
	if(confirm('정말 탈퇴? \n 本当に脱退しますか。')){
		location.href='member.bye'
	}
	
}

function snsPageChange(page){
		location.href= "sns.page.change?p="+page;
	
}
function snsPageChange2(page){
		location.href= "sns.page.change2?p="+page;
	
}
function snsForMailPageChange(page){
		location.href= "snsForMail.page.change?p="+page;
	
}
function inforPageChange(page){
		location.href= "inForboard.page.change?p="+page;
	
}
function inforPageChangeK2(page){
		location.href= "inForboardK.page.change2?p="+page;
	
}
		
function inforPageChangeJ2(page){
		location.href= "inForboardJ.page.change2?p="+page;
	
}

function foodPageChange(page){
		location.href= "foodboard.page.change?p="+page;
	
}

///////////////////////////////////////////////////20210810

function categoryChange(e) {
	var good_a = ["팔기, 売ります ", "사기, 買います"];
	var good_b = ["아르바이트,アルバイト", "정직원,正社員"];
	var good_c = ["한국어 배우기,韓国語を学ぶ", "일본어 배우기,日本語を学ぶ", "기타 언어 배우기,その他の言語学習"];
	var good_d = ["게스트 하우스, ゲストハウス ", "아파트 원룸, アパート、ワンルーム	", "고시원,コシウォン"];
	var target = document.getElementById("good");

	if(e.value == "사고팔기,売り買い") var d = good_a;
	else if(e.value == "일하기,働く") var d = good_b;
	else if(e.value == "배우기,学ぶ") var d = good_c;
	else if(e.value == "살기,住む") var d = good_d;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}	
}

function categorySearchJ(e) {
	var good_a = ["売ります ", "買います"];
	var good_b = ["アルバイト", "正社員"];
	var good_c = ["韓国語を学ぶ", "日本語を学ぶ", "その他の言語学習"];
	var good_d = ["ゲストハウス ", "アパート、ワンルーム", "コシウォン"];
	var target = document.getElementById("good");

	if(e.value == "売り買い") var d = good_a;
	else if(e.value == "働く") var d = good_b;
	else if(e.value == "学ぶ") var d = good_c;
	else if(e.value == "住む") var d = good_d;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}	
}


function categorySearchK(e) {
	var good_a = ["팔기", "사기"];
	var good_b = ["아르바이트", "정직원"];
	var good_c = ["한국어 배우기", "일본어 배우기", "기타 언어 배우기"];
	var good_d = ["게스트 하우스", "아파트 원룸", "고시원"];
	var target = document.getElementById("good");

	if(e.value == "사고팔기") var d = good_a;
	else if(e.value == "일하기") var d = good_b;
	else if(e.value == "배우기") var d = good_c;
	else if(e.value == "살기") var d = good_d;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}	
}
////////////////////////////////////////////////////////////20210812


function isNotType(input, type) {
	type = '.' + type;
	return input.value.indexOf(type) == -1;
}
function check() {
	let i1 = document.myForm.i1;
	if (i1.value == '' || (isNotType(i1, "jpg") && isNotType(i1, "gif"))) {
		alert('형식 오류,形式エラー');
		return false;
	}
	return true;
}
//////////////////////////////////////////////////////////////////////////////////


function checkinforwrite() {
			
			var check = document.ex_form.f_category.value;

			
			
			if (check == "") {
				
				alert("카테고리를 꼭 선택해주세요 \n カテゴリーを必ず選択してください。");
				document.ex_form.f_category.focus();
				return false;
				
			}
			
			
		}