package com.jm.last;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.last.friend.Friendmapper;
import com.jm.last.friend.sendmessage;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MDAO {

	private int allMsgCnt;

	@Autowired
	private SqlSession ss;

	@Autowired
	private siteOption so;

	public void joinmember(BlockMember b,member m, HttpServletRequest req) throws IOException {
		// TODO Auto-generated method stub

		Basicmapper mm = ss.getMapper(Basicmapper.class);

		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);

		// utf-8. request.setCharaterEncoding();
		MultipartRequest mr = new com.oreilly.servlet.MultipartRequest(req, path, 31457280, "utf-8",
				new DefaultFileRenamePolicy());

		String a1 = mr.getParameter("c_id");
		String a2 = mr.getParameter("c_pw");
		String a4 = mr.getParameter("c_name");
		String a5 = mr.getParameter("c_gender");
		
		String[] gender = a5.split(",");
		
		
		String a6 = mr.getParameter("c_country");
		
		String[] country = a6.split(",");
		
		
		String a7 = mr.getParameter("c_language1");
		String[] c_language1 = a7.split(",");

		String a8 = mr.getParameter("c_language2");
		String[] c_language2 = a8.split(",");

		String a9 = mr.getParameter("c_language3");
		String[] c_language3 = a9.split(",");
		
		String a10 = mr.getParameter("c_language4");
		String[] c_language4 = a10.split(",");
		
		
		String a11 = mr.getParameter("c_pwq");
		String[] c_pwq = a11.split(",");
		System.out.println("c_pwq1 : " +c_pwq[0]);
		System.out.println("c_pwq2 : " +c_pwq[1]);
		
		
		String a12 = mr.getParameter("c_pwans");
		String a13 = mr.getParameter("c_email");

		
		String langK = c_language1[0] + "!" + c_language2[0] + "!" + c_language3[0] + "!" + c_language4[0];
		String langJ = c_language1[1] + "!" + c_language2[1] + "!" + c_language3[1] + "!" + c_language4[1];
		

		m.setC_id(a1);
		m.setC_pw(a2);
		m.setC_name(a4);
		
		m.setC_genderK(gender[0]);
		m.setC_genderJ(gender[1]);
		
		
		m.setC_countryK(country[0]);
		m.setC_countryJ(country[1]);
		
		
		m.setC_languageJ(langJ);
		m.setC_languageK(langK);
		
		
		
		m.setC_photo("0");
		m.setC_comment("회원정보에서 자기소개를 작성해주세요 \n  会員情報から自己紹介を作成してください。");
		
		
		m.setC_pwqK(c_pwq[0]);
		m.setC_pwqJ(c_pwq[1]);
		
		
		m.setC_pwans(a12);
		m.setC_email(a13);
		/////////////////////////////////////////////////////20210818
		
System.out.println("id의 값은 : "+a1);


req.getSession().setAttribute("loginIDForBlock", a1);
req.getSession().setMaxInactiveInterval(1800);

		
//		b.setC_user(a1);
//		
//		b.setC_blocker("x!y");
//		
//		ss.getMapper(Basicmapper.class).plusUserForBlock(b);
		////////////////////////////////////////////////////////
		
		if (mm.regmenugo(m) == 1) {
			req.setAttribute("r", "회원가입을 완료 하셨습니다 . <br> 会員加入が完了しました。");
			allMsgCnt++;
			System.out.println("회원 가입 성공 ");

		} else {
		//	req.setAttribute("r", " 등록 실패");

		}

	}

	public void login(member m, HttpServletRequest req, HttpServletResponse res) {
		// 사용자가 입력한 아이디란, 비번란의 값이 필요
		System.out.println(m.getC_id()); // aaaaa
		System.out.println(m.getC_pw());
		// 저거 DB 비교

		Basicmapper mm = ss.getMapper(Basicmapper.class);
		member dbM = mm.getMemberById(m);

		// Member dbM = ss.getMapper(Member.class).getMemberById(m); // 결과 : Member

		if (dbM != null) {
			if (dbM.getC_pw().equals(m.getC_pw())) {
				req.setAttribute("r", "로그인 하셨습니다 <br> ログインしました。 ");
				// dbM : 로그인 된 사람 전체 정보
				// 사이트에서 어딜 가든 저 정보가 살아 있어야.
				
				req.getSession().setAttribute("loginMember", dbM);
				req.getSession().setMaxInactiveInterval(1800);

//				if (req.getParameter("autologin") != null) {
//
//					Cookie c = new Cookie("autoLoginID", dbM.getC_id());
//					c.setMaxAge(86400); // 24시간 살리기. 1*60*60*24 = 86400
//					res.addCookie(c);
//				}

			} else {
				req.setAttribute("r", "PW 오류 입니다. <br> パスワードエラーです。");
			}
		} else {
			// 셀렉트를 했는데 없으면? 그런 ID 없는거
			req.setAttribute("r", "미가입 ID 입니다. <br> 未加入のidです。");

		}
	}

	public boolean loginCheck(HttpServletRequest req) {

		member m = (member) req.getSession().getAttribute("loginMember");
		
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
	
		
		if (m != null) {

			
			if (korea !=null) {
				req.setAttribute("loginPage", "loginSuccess.jsp");
				
			}else if (japan != null) {
				
				req.setAttribute("loginPage", "loginSuccessJapan.jsp");
			}
			
			
			return true;
		} else {
			
			
			if (korea !=null) {
				req.setAttribute("loginPage", "login.jsp");
				
			}else if (japan != null) {
				
				req.setAttribute("loginPage", "loginJapan.jsp");
			}
			
			
			return false;
		}

	}
	

	
	
	
	
	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginMember", null);

		Cookie[] cookies = req.getCookies();

		if (cookies != null) {

			for (Cookie c : cookies) {
				if (c.getName().equals("auteLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}

		}

	}

	public void divideAddrK(HttpServletRequest req) {

		member m = (member) req.getSession().getAttribute("loginMember");

		String addr = m.getC_languageK();
		String[] lang2 = addr.split("!");
		req.setAttribute("langK", lang2);

	}
	public void divideAddrJ(HttpServletRequest req) {
		
		member m = (member) req.getSession().getAttribute("loginMember");
		
		String addr = m.getC_languageJ();
		String[] lang2 = addr.split("!");
		req.setAttribute("langJ", lang2);
		
	}

	public void divideAddrJ2(member m, HttpServletRequest req) {

		// member m = (member) req.getSession().getAttribute("loginMember");

		member m2 = ss.getMapper(Friendmapper.class).getfriendmembermore(m);

		String addr = m2.getC_languageJ();
		String[] lang2 = addr.split("!");
		req.setAttribute("lang", lang2);

	}
	public void divideAddrK2(member m, HttpServletRequest req) {
		
		// member m = (member) req.getSession().getAttribute("loginMember");
		
		member m2 = ss.getMapper(Friendmapper.class).getfriendmembermore(m);
		
		String addr = m2.getC_languageK();
		String[] lang2 = addr.split("!");
		req.setAttribute("lang", lang2);
		
	}
	
	

	public void bye(HttpServletRequest req) {
		member m = (member) req.getSession().getAttribute("loginMember");
		if (ss.getMapper(Basicmapper.class).bye(m) == 1) {
			System.out.println("탈퇴 성공");
			allMsgCnt--;
		} else {
			System.out.println("탈퇴 실패");
		}
	}

	public void updatego(member m, HttpServletRequest req) {
		// TODO Auto-generated method stub
		// 사진 파일은 최대 10MB
		// 수정시도 : 파일을 10MB넘게 -> 무조건 실패
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "수정실패(파일용량초과)");
			return;
		}

		// 현재 로그인 된 회원 정보(수정되기 전)
		member lm = (member) req.getSession().getAttribute("loginMember");

		// 기존 사진 파일명
		String oldFile = lm.getC_photo(); // %2A.png

		// 새 파일명
		String newFile = mr.getFilesystemName("c_photo"); // ㅎ.png
		try {
			String dm_id = mr.getParameter("c_id");
			String dm_pw = mr.getParameter("c_pw");
			String dm_name = mr.getParameter("c_name");
			
			String dm_genderK = mr.getParameter("c_genderK");
			String dm_genderJ = mr.getParameter("c_genderJ");
			

			
			String dm_countryK = mr.getParameter("c_countryK");
			String dm_countryJ = mr.getParameter("c_countryJ");

			
			
			String dm_lang1 = mr.getParameter("c_language1");
			String[] dm_lang11 = dm_lang1.split(",");

			String dm_lang2 = mr.getParameter("c_language2");
			String[] dm_lang22 = dm_lang2.split(",");

			String dm_lang3 = mr.getParameter("c_language3");
			String[] dm_lang33 = dm_lang3.split(",");

			String dm_lang4 = mr.getParameter("c_language4");
			String[] dm_lang44 = dm_lang4.split(",");
			
			
			String dm_comment = mr.getParameter("c_comment");

			String dm_pwq = mr.getParameter("c_pwq");
			System.out.println("dm_pwq : " + dm_pwq);
			String[] dm_pwq1 = dm_pwq.split(",");
			System.out.println("dm_pwq0 : " + dm_pwq1[0]);
			System.out.println("dm_pwq1 : " + dm_pwq1[1]);

			
			String dm_pwans = mr.getParameter("c_pwans");
			String dm_email = mr.getParameter("c_email");

			if (newFile == null) { // 사진은 수정 안하는
				newFile = oldFile;
			} else { // 사진 수정
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}

			m.setC_id(dm_id);
			m.setC_pw(dm_pw);
			System.out.println(m.getC_pw());
			m.setC_name(dm_name);
			
			m.setC_genderK(dm_genderK);
			m.setC_genderJ(dm_genderJ);
			
			
			m.setC_countryK(dm_countryK);
			m.setC_countryJ(dm_countryJ);
			
			m.setC_languageK(dm_lang11[0] + "!" + dm_lang22[0] + "!" + dm_lang33[0] + "!" + dm_lang44[0]);
			m.setC_languageJ(dm_lang11[1] + "!" + dm_lang22[1] + "!" + dm_lang33[1] + "!" + dm_lang44[1]);
			
			m.setC_comment(dm_comment);
			m.setC_photo(newFile);

			m.setC_pwqK(dm_pwq1[0]);
			m.setC_pwqJ(dm_pwq1[1]);
			
			
			m.setC_pwans(dm_pwans);
			m.setC_email(dm_email);

			// DB수정
			if (ss.getMapper(Basicmapper.class).updategogo(m) == 1) {
				req.setAttribute("r", "수정성공 <br> 修正成功 ");

				// 사이트에 반영
				req.getSession().setAttribute("loginMember", m);
				loginCheck(req);

				// 프사 바꾸는 상황 : 옛날 프사 지우기
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			} else {
				req.setAttribute("r", "수정실패 <br> 修正失敗  ");

				// 프사 바꾸는 상황 : 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8"); // 파일 한글 처리를 위한
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정실패 <br> 修正失敗");

			// 프사 바꾸는 상황 : 새 프사 지우기
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}

	}

	public void findpassword(member m, HttpServletRequest request) {
		// TODO Auto-generated method stub

		Basicmapper mm = ss.getMapper(Basicmapper.class);
		member dbM = mm.getMemberById(m);

		String pwq = dbM.getC_pwqK();
		String pwans = dbM.getC_pwans();

		String fpwq = request.getParameter("c_pwq");
		String fpwans = request.getParameter("c_pwans");

		if (pwq.equals(fpwq)) {

			if (pwans.equals(fpwans)) {

				request.setAttribute("p", "pass");
			} else {

				request.setAttribute("p", "wrong");
			}

		} else {
			request.setAttribute("p", "wrong");

		}

	}

	public void findpassword2(member m, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Basicmapper mm = ss.getMapper(Basicmapper.class);
		member dbM = mm.getMemberById(m);

		String password = dbM.getC_pw();
		String email = dbM.getC_email();

		request.setAttribute("password", password);
		request.setAttribute("email", email);

	}

	public members getMenuJSONByName() {

		List<member> menus = ss.getMapper(Basicmapper.class).getMenuByName();
		members m2 = new members(menus);

		return m2;

	}
	/////////............20210908
	public members getMenuJSONByEmail() {
		
		List<member> menus = ss.getMapper(Basicmapper.class).getMenuByEmail();
		members m3 = new members(menus);
		
		return m3;
		
	}
	//////////.......................///////
	
	////////////////////////20210818
	public BlockMemberS getMenuJSONByBlock(BlockMember b) {
		// TODO Auto-generated method stub
		BlockMember bb = ss.getMapper(Basicmapper.class).getMenuByBlock(b);
		
		
		String addr = bb.getC_blocker();
		String[] blockmemberValue = addr.split("!");
		
		ArrayList<BlockMember> bb2 = new ArrayList<BlockMember>();

		BlockMember d= null;
		for (int i = 0; i < blockmemberValue.length; i++) {
			d = new BlockMember();
			
			String pp=blockmemberValue[i];
			System.out.println("차단당한 사람들 "+pp);
			d.setC_blocker(pp);
			bb2.add(d);
		}
		
		
		BlockMemberS m2 = new BlockMemberS(bb2);
		
		System.out.println(m2);
		
		
		
		
		//BlockMember b2 = ss.getMapper(Basicmapper.class).getblockmember(b);

		

		return m2;
	}
	///////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////	
	public void countAllMsg() {
		System.out.println("넌 뭐니" + so.getSnsMsgPerPage());

		allMsgCnt = ss.getMapper(Basicmapper.class).getAllMsgCount();
		
		
		System.out.println(allMsgCnt);
	}

	public void getMsgs(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);
		System.out.println("page : " + page);
		System.out.println("allMsgCnt : " + allMsgCnt);

		String search = (String) req.getSession().getAttribute("search"); // 검색어로 쓸꺼
		String c_gender = (String) req.getSession().getAttribute("c_gender"); // 검색어로 쓸꺼
		String c_country = (String) req.getSession().getAttribute("c_country"); // 검색어로 쓸꺼
		
		

		int msgCnt = 0;
		if (search == null && c_gender == null && c_country == null) { // 전체조회 (검색어 없으면)
			msgCnt = allMsgCnt;
			search = "";
			c_gender = "";
			c_country = "";
		} else if (search == null && c_gender != null && c_country != null) {
			search = "";

			SNSSelector sSel2 = new SNSSelector(search, c_gender, c_country, 0, 0);
			msgCnt = ss.getMapper(Basicmapper.class).getSearchMsgCnt(sSel2);

		} else if (search == null && c_gender == null && c_country != null) { // 검색어가 있으면 검색인거.
			search = "";
			c_gender = "";

			SNSSelector sSel2 = new SNSSelector(search, c_gender, c_country, 0, 0);
			msgCnt = ss.getMapper(Basicmapper.class).getSearchMsgCnt(sSel2);

		} else if (search == null && c_gender != null && c_country == null) { // 검색어가 있으면 검색인거.
			search = "";
			c_country = "";

			SNSSelector sSel2 = new SNSSelector(search, c_gender, c_country, 0, 0);
			msgCnt = ss.getMapper(Basicmapper.class).getSearchMsgCnt(sSel2);

		} else if (search != null && c_gender == null && c_country == null) { // 검색어가 있으면 검색인거.
			c_gender = "";
			c_country = "";

			SNSSelector sSel2 = new SNSSelector(search, c_gender, c_country, 0, 0);
			msgCnt = ss.getMapper(Basicmapper.class).getSearchMsgCnt(sSel2);
		}

		// allMsgCnt -> msgCnt
		int allPageCount = (int) Math.ceil((double) msgCnt / so.getSnsMsgPerPage());
		req.setAttribute("allPageCount", allPageCount);
		// 14 / 10 한걸 올림시킨거 = 2
		int start = (page - 1) * so.getSnsMsgPerPage() + 1;
		// 2페이지면 11 시작
		System.out.println("start : " + start);

		int end = (page == allPageCount) ? msgCnt : start + so.getSnsMsgPerPage() - 1;
		// 2 == 2 ? 2
		// 1 == 2 ? 아니고 : 1 + 9 = 10
		System.out.println("end : " + end);

		SNSSelector sSel = new SNSSelector(search, c_gender, c_country, start, end);
		List<member> snsMsgs = ss.getMapper(Basicmapper.class).getMsg(sSel);

		// 댓글 들 가져오기

		req.setAttribute("friends", snsMsgs);

	}

	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");

		System.out.println(search);
		req.getSession().setAttribute("search", search);

	}

	public void searchMsginfo(HttpServletRequest req) {
		String c_gender = req.getParameter("c_gender");
		String c_country = req.getParameter("c_country");

		req.getSession().setAttribute("c_gender", c_gender);
		req.getSession().setAttribute("c_country", c_country);

	}

	public void searchClear(HttpServletRequest req) {

		req.getSession().setAttribute("search", null);
	}

	public void searchClearinfo(HttpServletRequest req) {

		req.getSession().setAttribute("c_gender", null);
		req.getSession().setAttribute("c_country", null);
	}
//////////////////////////////////////////////////////////////////////// 20210810//////////////

	public void seeemailgo(int page,  HttpServletRequest req) {
		// TODO Auto-generated method stub
		req.setAttribute("curPage", page);
		System.out.println("page : " + page);

		member m = (member) req.getSession().getAttribute("loginMember");

		System.out.println("id 값 뭐냐" + m.getC_id());
		String id = m.getC_id();

		// s.setC_getter(id);
		// System.out.println(s.getC_getter());

		// List<sendmessage> r =ss.getMapper(Friendmapper.class).getmessage(s);

		int msgCnt = 0;

		SNSSelectorForMail sSel2 = new SNSSelectorForMail(id, 0, 0);
		msgCnt = ss.getMapper(Basicmapper.class).getSearchMsgCntForMail(sSel2);

		// allMsgCnt -> msgCnt
		int allPageCount = (int) Math.ceil((double) msgCnt / so.getSnsMsgPerPage());
		req.setAttribute("allPageCount", allPageCount);
		// 14 / 10 한걸 올림시킨거 = 2
		int start = (page - 1) * so.getSnsMsgPerPage() + 1;
		// 2페이지면 11 시작
		System.out.println("start : " + start);

		int end = (page == allPageCount) ? msgCnt : start + so.getSnsMsgPerPage() - 1;
		// 2 == 2 ? 2
		// 1 == 2 ? 아니고 : 1 + 9 = 10
		System.out.println("end : " + end);

		SNSSelectorForMail sSel = new SNSSelectorForMail(id, start, end);
		List<sendmessage> snsMsgs = ss.getMapper(Basicmapper.class).getMsgForMail(sSel);

		req.setAttribute("message", snsMsgs);

	}

	

	///////////////////////////////////////////////////////////////////////////////////////

	public void CreateblockUser(BlockMember b, HttpServletRequest req) {
		
		member lm = (member) req.getSession().getAttribute("loginMember");
		String id =lm.getC_id();
		
		
		
		System.out.println("id의 값은 : "+id);
		
		b.setC_user(id);
		
		b.setC_blocker("x!y");
		
		ss.getMapper(Basicmapper.class).plusUserForBlock(b);
		
		
	}
	public void UpdateblockUser(BlockMember b,BlockMember2 b3,  HttpServletRequest req) {
		
//		String blocker2 =req.getParameter("c_blocker");
//		b.setC_user(blocker2);

		member m = (member) req.getSession().getAttribute("loginMember");

		String user = m.getC_id();
		System.out.println("user" + user);
		
		//b3.setC_user(user);
		
		String blocker =req.getParameter("blocker");

		
		b.setC_user(blocker);

		
		BlockMember b2 = ss.getMapper(Basicmapper.class).getblockmember(b);

		String addr = b2.getC_blocker();
		String[] blockmember = addr.split("!");

		
		System.out.println("blocker : "+blocker);
		String blockmemberss = "";
		
		for (int i = 0; i < blockmember.length; i++) {
			
			System.out.println(blockmember[i]);
			
			blockmemberss = blockmemberss+ blockmember[i]+"!";
			
		}
		
		String blockersfin =blockmemberss + user;
		
		System.out.println(blockersfin);
		
		b3.setC_blocker(blockersfin);
		b3.setC_user(blocker);
//		
		ss.getMapper(Basicmapper.class).UpdateUserForBlock(b3);
		
		
	}

	public void DelectblockUser(BlockMember b, BlockMember2 b3, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		member m = (member) req.getSession().getAttribute("loginMember");

		String user = m.getC_id();
		System.out.println("user" + user);
		
		//b3.setC_user(user);
		
		String blocker =req.getParameter("blocker");

		System.out.println("blocker : "+blocker);
		
		b.setC_user(blocker);

		
		BlockMember b2 = ss.getMapper(Basicmapper.class).getblockmember(b);

		String addr = b2.getC_blocker();
		String[] blockmember = addr.split("!");

		
		String blockmemberss = "";
		
		for (int i = 0; i < blockmember.length; i++) {
			
			System.out.println(blockmember[i]);
			
			if (blockmember[i].equals(user)) {
				
					continue;
			}
			
			
			blockmemberss = blockmemberss+ blockmember[i]+"!";
			System.out.println("확인용 : "+blockmemberss);
		}
		
		String blockersfin =blockmemberss ;
		
		System.out.println(blockersfin);
		
		b3.setC_blocker(blockersfin);
		b3.setC_user(blocker);
//		
		ss.getMapper(Basicmapper.class).UpdateUserForBlock(b3);
		
	}

////////////////////////////////////////////////////언어 바꾸기	
	public void korea(HttpServletRequest req) {

		req.getSession().setAttribute("korea", "korea");
	}
	public void japan(HttpServletRequest req) {

		req.getSession().setAttribute("japan", "japan");
	}
	public void koreaclear(HttpServletRequest req) {
		
		req.getSession().setAttribute("korea", null);
	}
	public void japanclear(HttpServletRequest req) {
		
		req.getSession().setAttribute("japan", null);
	}
	
	///////////////////////////////////////////////////////20210829

	public void makeBlockList(BlockMember b ,HttpServletRequest req) {
		
		String ID =(String) req.getSession().getAttribute("loginIDForBlock");
		
		b.setC_user(ID);
		
		b.setC_blocker("x!y");
		
		ss.getMapper(Basicmapper.class).plusUserForBlock(b);
		
		req.getSession().setAttribute("loginIDForBlock", null);

		
	}

///////////////////////////////////////////////////////////////////////
	
	
}
