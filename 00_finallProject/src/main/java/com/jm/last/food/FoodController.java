package com.jm.last.food;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jm.last.MDAO;
import com.jm.last.friend.FDAO;
import com.jm.last.friend.TokenMaker;
import com.jm.last.information.InforReply;
import com.jm.last.information.inforboardValue;

@Controller
public class FoodController {

	@Autowired
	private FDAO fdao;

	@Autowired
	private MDAO dao;

	@Autowired
	private FoodDAO fooddao;

	private boolean isFirstReq;

	public FoodController() {

		isFirstReq =true;
	}
	
	@RequestMapping(value = "/foodcontro.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		// 관리자 page
		dao.loginCheck(req);

		req.setAttribute("contentPage", "eating/foodwriteforcommender.jsp");
		
		
		return "index";
	}
	@RequestMapping(value = "/MakeFoodInfor.do", method = RequestMethod.POST)
	public String MakeFoodInfor(FoodInforValue f ,HttpServletRequest req) {
		
		// 관리자 page
		fooddao.SetInforFood(f,req);
		
		dao.loginCheck(req);
		
		req.setAttribute("contentPage", "home.jsp");
		
		
		return "index";
	}
	/////////////////////////////////////////////////////////////////////////////////// 실행 page 밑으로 20210820
	@RequestMapping(value = "/showfoodboard.go", method = RequestMethod.GET)
	public String showfoodboard(HttpServletRequest req) {
		
		
		if (isFirstReq) {
			fooddao.countAllMsg();
			
			
			isFirstReq = false;
		}
		
		fooddao.searchfoodClear(req);
		fooddao.ShowFood(1,req);
		
		dao.loginCheck(req);
		
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "eating/FoodBoard.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "eatingJapan/FoodBoardJapan.jsp");
		}
		
		
		
		return "index";
	}
	@RequestMapping(value = "/showfoodboardSearch.go", method = RequestMethod.GET)
	public String showfoodboardmore(HttpServletRequest req) {
		
		fooddao.searchfood(req);
		fooddao.ShowFood(1,req);

		dao.loginCheck(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "eating/FoodBoard.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "eatingJapan/FoodBoardJapan.jsp");
		}
		
		
		
		return "index";
	}
	@RequestMapping(value = "/showfoodboardMore.go", method = RequestMethod.GET)
	public String showfoodboardmore(FoodInforValue f ,HttpServletRequest req , ModelMap model) {
		
		fooddao.ShowFoodMore(f,req, model);
		
		dao.loginCheck(req);
		TokenMaker.makeToken(req);

		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "eating/FoodBoardMore.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "eatingJapan/FoodBoardMoreJapan.jsp");
		}
			
		
		
		return "index";
	}
	///////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "food.write.reply", method = RequestMethod.GET)
	public String snsdelect(FoodInforValue f , FoodReply sr  , HttpServletRequest req , ModelMap model) {
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		
		
		
		if (dao.loginCheck(req)) {
			fooddao.writeReply(f,sr, req);
			
			fooddao.ShowFoodMore(f, req, model);

			TokenMaker.makeToken(req);
			
			
			if (korea !=null) {
				req.setAttribute("contentPage", "eating/FoodBoardMore.jsp");
				
			}else if (japan != null) {
				
				req.setAttribute("contentPage", "eatingJapan/FoodBoardMoreJapan.jsp");
			}
			
			
		}else {
			
			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");
			
		}
		
		return "index";
	}
	
	
	@RequestMapping(value = "foodReplyDelect.go", method = RequestMethod.GET)
	public String InforReplyDelectgo(FoodInforValue f ,FoodReply sr  , HttpServletRequest req , ModelMap model) {
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		
		
		if (dao.loginCheck(req)) {
			
			fooddao.delectReply(sr, req);
			
			fooddao.ShowFoodMore(f, req, model);		
			
			TokenMaker.makeToken(req);
			
			if (korea !=null) {
				req.setAttribute("contentPage", "eating/FoodBoardMore.jsp");
				
			}else if (japan != null) {
				
				req.setAttribute("contentPage", "eatingJapan/FoodBoardMoreJapan.jsp");
			}
			
			
			
		}else {
			
			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");
			
		}
		
		return "index";
	}
	
	
	//////////////////////
	@RequestMapping(value = "/foodboard.page.change", method = RequestMethod.GET)
	public String foodpagechange(HttpServletRequest req) {
		
		dao.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		fooddao.ShowFood(p,req);

		com.jm.last.friend.TokenMaker.makeToken(req);
		
		String korea=(String) req.getSession().getAttribute("korea");
		String japan=(String) req.getSession().getAttribute("japan");
		
		if (korea !=null) {
			req.setAttribute("contentPage", "eating/FoodBoard.jsp");
			
		}else if (japan != null) {
			
			req.setAttribute("contentPage", "eatingJapan/FoodBoardJapan.jsp");
		}
		
		
		
		return "index";		
		
	}
}
