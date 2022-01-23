package com.jm.last.friend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jm.last.BlockMember;
import com.jm.last.MDAO;
import com.jm.last.member;

@Controller
public class friendController {

	@Autowired
	private FDAO fdao;

	@Autowired
	private MDAO dao;

	@RequestMapping(value = "/findfriend.go", method = RequestMethod.GET)
	public String findfriend(BlockMember b,HttpServletRequest req) {

		dao.searchClear(req);
		dao.searchClearinfo(req);
		
		req.getSession().setAttribute("getter", null);
		TokenMaker.makeToken(req);
		dao.getMsgs(1, req );  
		
		
		//fdao.findfriend(req);

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
	

	@RequestMapping(value = "/findfriendmore.go", method = RequestMethod.GET)
	public String findfriendmore(member m, HttpServletRequest req) {

		fdao.findfriendmore(m, req);

		dao.loginCheck(req);

		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			dao.divideAddrK2(m, req);
			req.setAttribute("contentPage", "board/friendmore.jsp");
			
		}else if (japan != null) {
			dao.divideAddrJ2(m, req);
			
			req.setAttribute("contentPage", "boardJapan/friendmoreJapan.jsp");
		}
		

		return "index";
	}

	@RequestMapping(value = "/findname.go", method = RequestMethod.GET)
	public String findfriendname(member m, HttpServletRequest req) {
		
		
		
		
		dao.searchMsg(req);
		dao.getMsgs(1, req);
		TokenMaker.makeToken(req);
		

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

	@RequestMapping(value = "/findbyinfo.go", method = RequestMethod.GET)
	public String findbyinfo1(member m, HttpServletRequest req) {
		
		
			dao.searchMsginfo(req);
			
			dao.getMsgs(1, req);
			TokenMaker.makeToken(req);
			String korea=(String) req.getSession().getAttribute("korea");
			String japan=(String) req.getSession().getAttribute("japan");
			dao.loginCheck(req);
			
			if (korea !=null) {
				req.setAttribute("contentPage", "board/friend.jsp");
				
			}else if (japan != null) {
				
				req.setAttribute("contentPage", "boardJapan/friendJapan.jsp");
			}




		return "index";
	}
	@RequestMapping(value = "/writemail.go", method = RequestMethod.GET)
	public String writemail(member m, HttpServletRequest req) {
		
		
		String getter=req.getParameter("c_id");
		
		req.getSession().setAttribute("getter", getter);
		req.getSession().setMaxInactiveInterval(180);
		
		
		//req.setAttribute("getter", getter);
		
		TokenMaker.makeToken(req);
		dao.loginCheck(req);
		
		
		
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/friendsendmessage.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/friendsendmessageJapan.jsp");
		}
		
		
		return "index";
	}
	@RequestMapping(value = "/sendmessage.go", method = RequestMethod.GET)
	public String sendmessagego(sendmessage s, HttpServletRequest req) {

		fdao.writeemailgo(s,req);
		
		dao.loginCheck(req);
		TokenMaker.makeToken(req);
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/friendsendmessage.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/friendsendmessageJapan.jsp");
		}
		
		
		return "index";
	}
	@RequestMapping(value = "/seemail.go", method = RequestMethod.GET)
	public String seemailgo(sendmessage s, HttpServletRequest req) {
		
		
		//fdao.seeemailgo(s,req);
		req.getSession().setAttribute("getter", null);

		
		dao.seeemailgo(1,  req);
		
		
		
		dao.loginCheck(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/message2.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/message2Japan.jsp");
		}
		
		
		return "index";
	}
	////////////////////////////////////////////////////////////////////////////////// 20210810
	@RequestMapping(value = "/snsForMail.page.change", method = RequestMethod.GET)
	public String pagingForMail(HttpServletRequest req) {
		dao.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		dao.seeemailgo(p, req);
		TokenMaker.makeToken(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/message2.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/message2Japan.jsp");
		}
		
		
		return "index";
	}
	///////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/delectmessage.go", method = RequestMethod.GET)
	public String delectmessage(sendmessage s, HttpServletRequest req) {
		
		
		fdao.delectmessage(s,req);
		dao.seeemailgo(1, req);

		dao.loginCheck(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/message2.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/message2Japan.jsp");
		}
		
		
		return "index";
	}
	@RequestMapping(value = "/checkmessage.go", method = RequestMethod.GET)
	public String checkmessage(sendmessage s, HttpServletRequest req) {
		
		
		fdao.checkmessageCanDO(s,req);
		
		dao.loginCheck(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "board/SeeMessageDeep.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "boardJapan/SeeMessageDeepJapan.jsp");
		}
		
		
		return "index";
	}

	
	
}
