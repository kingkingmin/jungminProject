package com.jm.last.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jm.last.MDAO;
import com.jm.last.member;

@Controller
public class MemberController {

	@Inject // 서비스를 호출하기 위해서 의존성을 주입
	JavaMailSender mailSender; // 메일 서비스를 사용하기 위해 의존성을 주입함.
	MemberService memberservice; // 서비스를 호출하기 위해 의존성을 주입

	@Autowired
	private MDAO dao;

	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String String = null;

	// mailSending 코드
	@RequestMapping(value = "/auth.do", method = RequestMethod.POST)
	public String mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email)
			throws IOException {

		Random r = new Random();
		int dice = r.nextInt(4589362) + 49311; // 이메일로 받는 인증코드 부분 (난수)

		String setfrom = "rlawjdals9947@gmail.com";
		String tomail = request.getParameter("e_mail"); // 받는 사람 이메일
		String title = "회원가입 인증 이메일 입니다. 会員登録認証Eメールです。 "; // 제목
		String content =

				System.getProperty("line.separator") + // 한줄씩 줄간격을 두기위해 작성

						System.getProperty("line.separator") +

						"안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다. こんにちは。会員様、弊社のホームページを訪問していただきありがとうございます。  "

						+ System.getProperty("line.separator") +

						System.getProperty("line.separator") +

						" 인증번호는 認証番号は " + dice + " 입니다. となります。"

						+ System.getProperty("line.separator") +

						System.getProperty("line.separator") +

						"받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다. 受け取った認証番号をホームページに入力していただければ次へ進みます。 "; // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

		// ModelAndView mv = new ModelAndView(); //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을
		// 지정한다.
		// ModelAndView mv2 = new ModelAndView(); //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을
		// 지정한다.
		// mv.setViewName("/index"); //뷰의이름
		// mv.setViewName("/email_injeung"); //뷰의이름
		// mv.addObject("dice", dice);
		// mv.addObject("contentPage", "email_injeung");

//	            mv2.setViewName("/index");     //뷰의이름
//	            mv2.addObject("contentPage", mv);

		// System.out.println("mv : "+mv);

		response_email.setContentType("text/html; charset=UTF-8");
		PrintWriter out_email = response_email.getWriter();
		out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요. \\n Eメールが送信されました。 認証番号を入力してください。  ');</script>");
		out_email.flush();

		dao.loginCheck(request);
		request.setAttribute("dice", dice);
		request.setAttribute("tomail", tomail);
		request.setAttribute("contentPage", "email_injeung.jsp");
		return "index";

		// return mv ;

	}

	// 이메일 인증 페이지 맵핑 메소드
	@RequestMapping("/member/email.do")
	public String email() {
		return "member/email";
	}

	// 이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
	// 내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
	// 틀리면 다시 원래 페이지로 돌아오는 메소드
	@RequestMapping(value = "/join_injeung.do{dice}", method = RequestMethod.POST)
	public String join_injeung(HttpServletRequest request, String email_injeung, @PathVariable String dice,
			HttpServletResponse response_equals) throws IOException {

		String key2 = request.getParameter("key");

		System.out.println("key2" + key2);

		System.out.println("마지막 : email_injeung : " + email_injeung);

		System.out.println("마지막 : dice : " + dice);

		// 페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음

//	        ModelAndView mv = new ModelAndView();
//	        
//	        mv.setViewName("/member/join.do");
//	        
//	        mv.addObject("e_mail",email_injeung);

		if (email_injeung.equals(dice)) {

			// 인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함

			// mv.setViewName("join");

			// mv.addObject("e_mail",email_injeung);

			// 만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
			// 한번더 입력할 필요가 없게 한다.

			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다. \\n 認証番号が一致しました。会員登録画面に移動します。 ');</script>");
			out_equals.flush();

			dao.loginCheck(request);
			
			String korea=(String) request.getSession().getAttribute("korea");
			String japan=(String) request.getSession().getAttribute("japan");
			
			if (korea !=null) {
				request.setAttribute("contentPage", "join.jsp");
				
			}else if (japan != null) {
				request.setAttribute("contentPage", "joinJapan.jsp");
				
			}
			
			request.setAttribute("email", key2);
			request.setAttribute("e_mail", email_injeung);

			// return mv;
			return "index";

		} else if (email_injeung != dice) {

			// ModelAndView mv2 = new ModelAndView();

			// mv2.setViewName("index");
			// mv2.setViewName("email_injeung");

			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요. \\n 認証番号が一致しません。 認証番号を再度入力してください。'); history.go(-1);</script>");
			out_equals.flush();

			dao.loginCheck(request);
			request.setAttribute("contentPage", "email_injeung.jsp");
			// return mv2;
			return "index";

		}

		dao.loginCheck(request);
		request.setAttribute("contentPage", "join.jsp");
		request.setAttribute("e_mail", email_injeung);
		return "index";
	}

	//////////////////////////////////////////////////////////////

	@RequestMapping(value = "/findpassword.do", method = RequestMethod.POST)
	public String mailSendingPassword(HttpServletRequest request, member m, String e_mail,
			HttpServletResponse response_email) throws IOException {

		// Random r = new Random();
		// int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)

		dao.findpassword(m, request);
		Object p = request.getAttribute("p");
		String p2 = (String) p;
		System.out.println("p2잘 왓니?" + p2);

		if (p2.equals("pass")) {

			dao.findpassword2(m, request);
			Object pass = request.getAttribute("password");
			String pass2 = (String) pass;
			Object email = request.getAttribute("email");
			String email2 = (String) email;
			System.out.println("pass2잘 왓니?" + pass2);
			System.out.println("email2잘 왓니?" + email2);

			String setfrom = "rlawjdals9947@gmail.com";
			String tomail = email2; // 받는 사람 이메일
			String title = "회원님의 비밀번호 찾기 이메일 입니다. 会員様のパスワードを探すEメールです。"; // 제목
			String content =

					System.getProperty("line.separator") + // 한줄씩 줄간격을 두기위해 작성

							System.getProperty("line.separator") +

							"안녕하세요 회원님의 비밀번호 입니다. こんにちは。会員のパスワードです。 "

							+ System.getProperty("line.separator") +

							System.getProperty("line.separator") +

							" 비밀번호는  暗証番号は " + pass2 + " 입니다. となります。"

							+ System.getProperty("line.separator") +

							System.getProperty("line.separator") +

							"받으신 비밀 번호를 홈페이지에 입력해 주세요. 受け取った暗証番号をホームページに入力してください。 "; // 내용

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
				messageHelper.setTo(tomail); // 받는사람 이메일
				messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용

				mailSender.send(message);
			} catch (Exception e) {
				System.out.println(e);
			}

			// ModelAndView mv = new ModelAndView(); //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을
			// 지정한다.
			// ModelAndView mv2 = new ModelAndView(); //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을
			// 지정한다.
			// mv.setViewName("/index"); //뷰의이름
			// mv.setViewName("/email_injeung"); //뷰의이름
			// mv.addObject("dice", dice);
			// mv.addObject("contentPage", "email_injeung");

//	            mv2.setViewName("/index");     //뷰의이름
//	            mv2.addObject("contentPage", mv);

			// System.out.println("mv : "+mv);

			response_email.setContentType("text/html; charset=UTF-8");
			PrintWriter out_email = response_email.getWriter();
			out_email.println("<script>alert('이메일이 발송되었습니다. 비밀번호를 입력해주세요.\\n Eメールが送信されました。 暗証番号をご入力ください。  ');</script>");
			out_email.flush();

			dao.loginCheck(request);
			// request.setAttribute("dice", dice);
			request.setAttribute("contentPage", "home.jsp");
			return "index";

			// return mv ;

		} else {

			dao.loginCheck(request);
			request.setAttribute("r", "잘못된 아이디 및 질문입니다");
			request.setAttribute("contentPage", "home.jsp");
			return "index";

		}

	}

}
