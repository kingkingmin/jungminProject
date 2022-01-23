<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="300" height="300" align= "center">
<center>
<span style="color: green; font-weight: bold;">입력한 이메일로 받은 인증번호를 입력하세요. (인증번호가 맞아야 다음 단계로 넘어가실 수 있습니다.)
<br> Eメール認証（電子メールの認証を受けると、次の段階に移ることができます。）

</span> <br> <br>    
        <br> <br>
        
        
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                    <form action="join_injeung.do${dice}" method="post">                 
                    <center>
                        <br>
                        <div>
                            인증번호 입력(認証番号入力)  <br>  <br>  <input type="number" name="email_injeung" placeholder="  Insert the number" style="width:210px;height:50px; font-size:17px;">
                               <input name="" value="${dice}" type="hidden">     
 							<input name="key" value="${tomail}" type="hidden">  
                                
                        </div>                                        
 
                        <br> <br>
                        <button id="checkE2" type="submit" name="submit">인증번호 전송 <br> 認証番号を送信 </button>
 
                        </div>
                    </td>
                </tr>
                    </center>
            </table>
        </form>
</center>

</body>
</html>