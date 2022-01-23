package com.jm.last.information;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jm.last.MDAO;
import com.jm.last.friend.TokenMaker;

@Controller
public class informationController {

	@Autowired
	private MDAO dao;

	@Autowired
	private INDAO indao;

	private boolean isFirstReq;

	public informationController() {
		isFirstReq = true;
	}

	@RequestMapping(value = "/LivingInformation.go", method = RequestMethod.GET)
	public String LivingInformation(HttpServletRequest req) {

		if (isFirstReq) {
			indao.countAllMsg();

			isFirstReq = false;
		}

		indao.searchInforClear(req);
		indao.searchInforVer2Clear(req);

		TokenMaker.makeToken(req);

		indao.callinforBoard(1, req);

		dao.loginCheck(req);

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/information2.jsp");

		} else if (japan != null) {

			req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
		}

		return "index";
	}

	@RequestMapping(value = "/informationWrite.go", method = RequestMethod.GET)
	public String informationWritego(HttpServletRequest req) {

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (dao.loginCheck(req)) {

			TokenMaker.makeToken(req);

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/informationWrite.jsp");

			} else if (japan != null) {

				req.setAttribute("contentPage", "LivinginformationJapan/informationWriteJapan.jsp");
			}

		} else {

			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";
	}

	@RequestMapping(value = "/map.go", method = RequestMethod.GET)
	public String map(HttpServletRequest req) {

		dao.loginCheck(req);

		req.setAttribute("contentPage", "Livinginformation/test4.jsp");

		return "index";
	}

	@RequestMapping(value = "/inforwrite.go", method = RequestMethod.POST)
	public String inforwritego(inforboardValue i, HttpServletRequest req) throws IOException {

		if (dao.loginCheck(req)) {

			indao.addinforBoard(i, req);

			indao.callinforBoard(1, req);

			TokenMaker.makeToken(req);

			String korea = (String) req.getSession().getAttribute("korea");
			String japan = (String) req.getSession().getAttribute("japan");

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/information2.jsp");

			} else if (japan != null) {

				req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
			}

		} else {

			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");
		}

		return "index";
	}

	@RequestMapping(value = "/findinforbysearch.go", method = RequestMethod.GET)
	public String findinforbysearchgo(inforboardValue i, HttpServletRequest req) {

		indao.searchInfor(req);
		indao.callinforBoard(1, req);

		dao.loginCheck(req);

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/information2.jsp");

		} else if (japan != null) {

			req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
		}

		return "index";
	}

	@RequestMapping(value = "/findbyinfoVerK2.go", method = RequestMethod.GET)
	public String findinforbysearchgoK2(inforboardValue i, HttpServletRequest req) {

		indao.searchInforVer2(req);

		indao.callinforBoardverK2(1, req);

		dao.loginCheck(req);

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/information2.jsp");

		} else if (japan != null) {

			req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
		}

		return "index";
	}
	@RequestMapping(value = "/findbyinfoVerJ2.go", method = RequestMethod.GET)
	public String findinforbysearchgo2(inforboardValue i, HttpServletRequest req) {
		
		indao.searchInforVer2(req);
		
		indao.callinforBoardverJ2(1, req);
		
		dao.loginCheck(req);
		
		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");
		
		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/information2.jsp");
			
		} else if (japan != null) {
			
			req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
		}
		
		return "index";
	}

	
	
	
	@RequestMapping(value = "/findinforBoardMore.go", method = RequestMethod.GET)
	public String findinforBoardMorego(inforboardValue i, HttpServletRequest req, ModelMap model) {

		TokenMaker.makeToken(req);

		indao.callinforBoardBoard(i, req, model);

		dao.loginCheck(req);

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/informationMore.jsp");

		} else if (japan != null) {

			req.setAttribute("contentPage", "LivinginformationJapan/informationMoreJapan.jsp");
		}

		return "index";
	}

//	@RequestMapping(value = "/inForboard.page.change", method = RequestMethod.GET)
//	public String pagingForMail(HttpServletRequest req) {
//		dao.loginCheck(req);
//		int p = Integer.parseInt(req.getParameter("p"));
//
//		String f_category = (String) req.getSession().getAttribute("f_category");
//		String search = (String) req.getSession().getAttribute("search");
//		String f_sort = (String) req.getSession().getAttribute("f_sort");
//
//		String korea = (String) req.getSession().getAttribute("korea");
//		String japan = (String) req.getSession().getAttribute("japan");
//
//		if (search != null) {
//
//			indao.callinforBoard(p, req);
//			TokenMaker.makeToken(req);
//
//			if (korea != null) {
//				req.setAttribute("contentPage", "Livinginformation/information.jsp");
//
//			} else if (japan != null) {
//
//				req.setAttribute("contentPage", "LivinginformationJapan/informationJapan.jsp");
//			}
//
//			return "index";
//
//		}
//		if (f_category != null && f_sort != null) {
//
//			indao.callinforBoardver2(p, req);
//			TokenMaker.makeToken(req);
//
//			if (korea != null) {
//				req.setAttribute("contentPage", "Livinginformation/information.jsp");
//
//			} else if (japan != null) {
//
//				req.setAttribute("contentPage", "LivinginformationJapan/informationJapan.jsp");
//			}
//
//			return "index";
//
//		}
//
//		indao.callinforBoard(p, req);
//
//		TokenMaker.makeToken(req);
//
//		if (korea != null) {
//			req.setAttribute("contentPage", "Livinginformation/information.jsp");
//
//		} else if (japan != null) {
//
//			req.setAttribute("contentPage", "LivinginformationJapan/informationJapan.jsp");
//		}
//
//		return "index";
//	}

	
	@RequestMapping(value = "/inForboardK.page.change2", method = RequestMethod.GET)
	public String pagingForMailK2(HttpServletRequest req) {
		dao.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));

		String f_category = (String) req.getSession().getAttribute("f_category");
		String search = (String) req.getSession().getAttribute("search");
		String f_sort = (String) req.getSession().getAttribute("f_sort");

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (search != null) {

			indao.callinforBoard(p, req);
			TokenMaker.makeToken(req);

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/information2.jsp");

			} else if (japan != null) {
				req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");

			}

			return "index";

		}
		if (f_category != null && f_sort != null) {

			indao.callinforBoardverK2(p, req);
			TokenMaker.makeToken(req);

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/information2.jsp");

			} else if (japan != null) {
				req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");

			}

			return "index";

		}

		indao.callinforBoard(p, req);

		TokenMaker.makeToken(req);

		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/information2.jsp");

		} else if (japan != null) {
			req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");

		}

		return "index";
	}
							
	@RequestMapping(value = "/inForboardJ.page.change2", method = RequestMethod.GET)
	public String pagingForMail2(HttpServletRequest req) {
		dao.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		
		String f_category = (String) req.getSession().getAttribute("f_category");
		String search = (String) req.getSession().getAttribute("search");
		String f_sort = (String) req.getSession().getAttribute("f_sort");
		
		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");
		
		if (search != null) {
			
			indao.callinforBoard(p, req);
			TokenMaker.makeToken(req);
			
			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/information2.jsp");
				
			} else if (japan != null) {
				req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
				
			}
			
			return "index";
			
		}
		if (f_category != null && f_sort != null) {
			
			indao.callinforBoardverJ2(p, req);
			TokenMaker.makeToken(req);
			
			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/information2.jsp");
				
			} else if (japan != null) {
				req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
				
			}
			
			return "index";
			
		}
		
		indao.callinforBoard(p, req);
		
		TokenMaker.makeToken(req);
		
		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/information2.jsp");
			
		} else if (japan != null) {
			req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");
			
		}
		
		return "index";
	}

	
	@RequestMapping(value = "/delectInfor.go", method = RequestMethod.GET)
	public String delecteinfor(inforboardValue i, HttpServletRequest req) {

		if (dao.loginCheck(req)) {

			indao.delectInforgo(i, req);

			indao.callinforBoard(1, req);

			String korea = (String) req.getSession().getAttribute("korea");
			String japan = (String) req.getSession().getAttribute("japan");

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/information2.jsp");

			} else if (japan != null) {
				req.setAttribute("contentPage", "LivinginformationJapan/information2Japan.jsp");

			}

		} else {

			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";
	}

	@RequestMapping(value = "/UpdateInfor.go", method = RequestMethod.GET)
	public String UpdateInfor(inforboardValue i, HttpServletRequest req, ModelMap model) {

		indao.callinforBoardBoard(i, req, model);
		TokenMaker.makeToken(req);

		dao.loginCheck(req);

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (korea != null) {
			req.setAttribute("contentPage", "Livinginformation/informationUpdate.jsp");

		} else if (japan != null) {

			req.setAttribute("contentPage", "LivinginformationJapan/informationUpdateJapan.jsp");
		}

		return "index";
	}

	@RequestMapping(value = "/inforUpdate.do", method = RequestMethod.POST)
	public String UpdateInfordo(inforboardValue i, HttpServletRequest req, ModelMap model) {

		if (dao.loginCheck(req)) {

			indao.UpdateInforBoard(i, req);
			indao.callinforBoardBoard(i, req, model);
			TokenMaker.makeToken(req);

			String korea = (String) req.getSession().getAttribute("korea");
			String japan = (String) req.getSession().getAttribute("japan");

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/informationMore.jsp");

			} else if (japan != null) {

				req.setAttribute("contentPage", "LivinginformationJapan/informationMoreJapan.jsp");
			}

		} else {
			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";
	}

	@RequestMapping(value = "sns.write.reply", method = RequestMethod.GET)
	public String snsdelect(inforboardValue i, InforReply sr, HttpServletRequest req, ModelMap model) {

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (dao.loginCheck(req)) {
			indao.writeReply(sr, req);
			indao.callinforBoardBoard(i, req, model);

			TokenMaker.makeToken(req);

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/informationMore.jsp");

			} else if (japan != null) {

				req.setAttribute("contentPage", "LivinginformationJapan/informationMoreJapan.jsp");
			}

		} else {

			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";
	}

	@RequestMapping(value = "InforReplyDelect.go", method = RequestMethod.GET)
	public String InforReplyDelectgo(inforboardValue i, InforReply sr, HttpServletRequest req, ModelMap model) {

		String korea = (String) req.getSession().getAttribute("korea");
		String japan = (String) req.getSession().getAttribute("japan");

		if (dao.loginCheck(req)) {

			indao.delectReply(sr, req);

			indao.callinforBoardBoard(i, req, model);

			TokenMaker.makeToken(req);

			if (korea != null) {
				req.setAttribute("contentPage", "Livinginformation/informationMore.jsp");

			} else if (japan != null) {

				req.setAttribute("contentPage", "LivinginformationJapan/informationMoreJapan.jsp");
			}

		} else {

			req.setAttribute("r", "로그인 후에 작성해주세요");
			req.setAttribute("contentPage", "home.jsp");

		}

		return "index";
	}

}
