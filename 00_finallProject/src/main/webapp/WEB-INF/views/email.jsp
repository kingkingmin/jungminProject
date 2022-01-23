<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		
		
		//$('button').click(function() {
		$("#checkE1").keyup(function() {

			let inputVal = $("#checkE1").val();

			$.ajax({
				// type 설정
				type : 'GET',
				// 서버로 보낼 주소 입력 
				
				url : "/last/menu.get.json.email",
				// 사용자가 입력한 값 서버로
				data : {
					"c_email" : inputVal
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
		//alert(data[1]["m_name"]);

		$.each(data, function(i) {
				//console.log(data[i]);
			let hh = data[i].c_email;
			console.log(hh);

			if (hh === $("#checkE1").val()) {
				$('#mainTbl2').append("이미 가입된 email입니다. 다른 email을 입력해주세요.  <br>  既に登録済みのemailです。 他のemailを入力してください。 ");
				
				$('#checkE2').css('visibility', 'hidden');
				$("#checkE1").val()="";				
			} else {	
				$('#checkE2').css('visibility', 'visible');

			}

			/* if($("#i1").val() != ""){
				
			
			$('#mainTbl2').append("<tr><td id='tds"+i+"'></td></tr>");
			$('#tds' + i).text(data[i]["m_name"]);
			} */

		});

	}
	
	
	

</script>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table  width="600" height="300" align= "center">
<center>
<span style="color: green; font-weight: bold;">이메일 인증 (이메일을 인증 받아야 다음 단계로 넘어갈 수 있습니다.)</span> 
<br> Eメール認証（電子メールの認証を受けると、次の段階に移ることができます。）

<br> <br>    
        <br> <br>
        
        
 
        
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                    <form action="auth.do" method="post">
                    
                    <center>
                        <br>
                        <div>
                          <h2>E-Mail  </h2>   <input id="checkE1" type="email" name="e_mail"
                                placeholder="Insert your email, ex) xxx@xxx.com " style="width:300px;height:50px; font-size:17px;">
                        </div>                                 
                        
                                       
 
                        <br> <br>
                        <button id="checkE2" type="submit" name="submit">이메일 인증받기  <br>  (電子メールの認証を受ける。)</button>
 
                        </div>
                    </td>
                </tr>
                
                <tr>
                 <td id="mainTbl2" ></td>
                </tr>
                
                
				</center>
					
					
					
					
            </table>
        </form>
 </center>

</body>
</html>