package com.jm.last;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	private MDAO dao;

	private boolean isFirstReq;

	public HomeController() {

		isFirstReq = true;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {

		if (isFirstReq) {
			dao.countAllMsg();
			// dao.korea(req);
			dao.korea(req);
			isFirstReq = false;
		}
		

		
		req.setAttribute("contentPage", "home.jsp");
		req.setAttribute("loginPage", "login.jsp");

		return "index";
	}

	////////////////////////////////////////////////////////////
	@RequestMapping(value = "/menu.get.json.name", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody members getmenujsonname(member m) {

		members mm = dao.getMenuJSONByName();

		return mm;
	}
	//.......................20210908 밑에 하나
	@RequestMapping(value = "/menu.get.json.email", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody members getmenujsonemail(member m) {
		
		members mm = dao.getMenuJSONByEmail();
		
		return mm;
	}
	///..........................................

	////////////////////////////////////// 20210818
	@RequestMapping(value = "/menu.get.json.block", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody BlockMemberS getmenujsonblock(BlockMember b) {

		BlockMemberS mm = dao.getMenuJSONByBlock(b);

		return mm;
	}
	//////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String paging(HttpServletRequest req) {
		dao.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		dao.getMsgs(p, req);
		com.jm.last.friend.TokenMaker.makeToken(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/friend.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/friendJapan.jsp");
		}
		
		return "index";
	}

	@RequestMapping(value = "/sns.page.change2", method = RequestMethod.GET)
	public String paging2(HttpServletRequest req) {
		dao.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		dao.getMsgs(p, req);
		com.jm.last.friend.TokenMaker.makeToken(req);
		
	
		
		req.setAttribute("contentPage", "board/friend2.jsp");
		
		
		return "index";
	}

	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String search(HttpServletRequest req) {
		dao.searchMsg(req);
		dao.getMsgs(1, req);
		com.jm.last.friend.TokenMaker.makeToken(req);
		dao.loginCheck(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/friend.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/friendJapan.jsp");
		}
		
		
		
		return "index";
	}

	///////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/home.go", method = RequestMethod.GET)
	public String homego(HttpServletRequest req) {

		dao.loginCheck(req);
		
		req.getSession().setAttribute("getter", null);

		
		req.setAttribute("contentPage", "home.jsp");

		return "index";
	}

	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String joinmember(member m, HttpServletRequest req) {

		dao.loginCheck(req);

		req.setAttribute("contentPage", "email.jsp");

		return "index";
	}

	@RequestMapping(value = "/member.join.do", method = RequestMethod.POST)
	public String joinmemberdo(BlockMember b, member m, HttpServletRequest req) throws IOException {

		dao.joinmember(b, m, req);
		
		dao.makeBlockList(b, req);

		dao.loginCheck(req);

		req.setAttribute("contentPage", "home.jsp");

		return "index";
	}

	@RequestMapping(value = "/findpassword.go", method = RequestMethod.GET)
	public String findpassword(member m, HttpServletRequest req) {

		dao.loginCheck(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "password.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "passwordJapan.jsp");
		}
		

		return "index";
	}

	@RequestMapping(value = "member.login", method = RequestMethod.POST)
	public String login(member m, HttpServletRequest req, HttpServletResponse res) {

		dao.login(m, req, res);
		dao.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String logout(member m, HttpServletRequest req, HttpServletResponse res) {

		dao.logout(req, res);
		dao.loginCheck(req);

		req.setAttribute("contentPage", "home.jsp");

		return "index";
	}

	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String logout(member m, HttpServletRequest req) {

		
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		dao.divideAddrK(req);
		dao.divideAddrJ(req);

		if (dao.loginCheck(req)) {

			
			
			if (korea !=null) {
				
				req.setAttribute("contentPage", "info.jsp");
				
			}else if (japan != null) {
				
				req.setAttribute("contentPage", "infoJapan.jsp");
			}
			
			
			
		} else {
			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";
	}

	@RequestMapping(value = "member.bye", method = RequestMethod.GET)
	public String memberBye(HttpServletRequest req, HttpServletResponse res) {
		if (dao.loginCheck(req)) {
			dao.bye(req);
			dao.logout(req, res);
			dao.loginCheck(req);
			req.setAttribute("contentPage", "home.jsp");
		} else {

			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "member.update", method = RequestMethod.POST)
	public String memberupdate(member m, HttpServletRequest req, HttpServletResponse res) {

		if (dao.loginCheck(req)) {
			dao.updatego(m, req);
			req.setAttribute("contentPage", "home.jsp");

		} else {
			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";

	}

	@RequestMapping(value = "blockUser.go", method = RequestMethod.GET)
	public String blockUser(BlockMember b, BlockMember2 b2, HttpServletRequest req, HttpServletResponse res) {

		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		
		if (dao.loginCheck(req)) {

			dao.UpdateblockUser(b, b2, req);
			dao.getMsgs(1, req);
			
			if (korea !=null) {
				req.setAttribute("contentPage", "board/friend.jsp");
				
			}else if (japan != null) {
				req.setAttribute("contentPage", "boardJapan/friendJapan.jsp");
			}
			

			

		} else {

			req.setAttribute("contentPage", "home.jsp");
		}

		return "index";

	}

	@RequestMapping(value = "DelectblockUser.go", method = RequestMethod.GET)
	public String DelectblockUser(BlockMember b, BlockMember2 b2, HttpServletRequest req, HttpServletResponse res) {

		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		
		if (dao.loginCheck(req)) {

			dao.DelectblockUser(b, b2, req);
			dao.getMsgs(1, req);
			
			
			if (korea !=null) {
				req.setAttribute("contentPage", "board/friend.jsp");
	
			}else if (japan != null) {
				
				req.setAttribute("contentPage", "boardJapan/friendJapan.jsp");
			}
			

		} else {

			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";

	}
	@RequestMapping(value = "japanchange.go", method = RequestMethod.GET)
	public String japanchange(BlockMember b, BlockMember2 b2, HttpServletRequest req, HttpServletResponse res) {
		
		dao.koreaclear(req);
		dao.japan(req);
		
		if (dao.loginCheck(req)) {
			
			req.setAttribute("contentPage", "home.jsp");
			
		} else {
			
			req.setAttribute("contentPage", "home.jsp");
			
		}
		
		return "index";
		
	}
	@RequestMapping(value = "koreachange.go", method = RequestMethod.GET)
	public String koreachange(BlockMember b, BlockMember2 b2, HttpServletRequest req, HttpServletResponse res) {
	dao.japanclear(req);
	dao.korea(req);
		
		if (dao.loginCheck(req)) {
			
			req.setAttribute("contentPage", "home.jsp");
			
		} else {
			
			req.setAttribute("contentPage", "home.jsp");
			
		}
		
		return "index";
		
	}

}
