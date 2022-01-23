package com.jm.last.food;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.jm.last.member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class FoodDAO {

	private int allMsgCnt3;
	
	@Autowired
	private SqlSession ss;

	@Autowired
	private siteOption2 so;

	public void SetInforFood(FoodInforValue f, HttpServletRequest req) {
		// TODO Auto-generated method stub


		String path = req.getSession().getServletContext().getRealPath("resources/img2");
		
		MultipartRequest mr = null;
	
		
		try {
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			System.out.println(path);
		} catch (IOException e) {
			e.printStackTrace();
			req.setAttribute("r", "등록실패(파일 용량 초과)");
			return;
		}
		// 여기까지 파일 업로드 성공
		// 여기서부터 작업(실패하는 경우의 수 때문에)
		try {
			
		
			
			
			String a1 = mr.getParameter("f_name");
			String a11 = mr.getParameter("f_kind");
			String a2 = mr.getParameter("f_address");
			String a3 = mr.getParameter("f_price");
			String a4 = mr.getParameter("f_infor");
			String a5 = mr.getParameter("f_service");
			String a6 = mr.getParameter("f_phone");
			String a7 = mr.getParameter("f_mapinfo1");
			String a8 = mr.getParameter("f_mapinfo2");
			String a9 = mr.getParameter("f_mapinfo3");
			String a10 = mr.getParameter("f_mapinfoName");

			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			System.out.println(a4);
			System.out.println(a5);
			System.out.println(a6);
			System.out.println(a7);
			System.out.println(a8);
			System.out.println(a9);
			System.out.println(a10);

			String f_photo1 = mr.getFilesystemName("f_photo1");
			String f_photo2 = mr.getFilesystemName("f_photo2");
			String f_photo3 = mr.getFilesystemName("f_photo3");

			if (f_photo1 == null) {
				f_photo1 = "사진을 넣지 않았습니다.";
			}
			if (f_photo2 == null) {
				f_photo2 = "사진을 넣지 않았습니다.";
			}
			if (f_photo3 == null) {
				f_photo3 = "사진을 넣지 않았습니다.";
			}
			
			
			f_photo1 = URLEncoder.encode(f_photo1, "utf-8");
			f_photo1 = f_photo1.replace("+", " ");
			f_photo2 = URLEncoder.encode(f_photo2, "utf-8");
			f_photo2 = f_photo2.replace("+", " ");
			f_photo3 = URLEncoder.encode(f_photo3, "utf-8");
			f_photo3 = f_photo3.replace("+", " ");

			f.setF_name(a1);
			f.setF_address(a2);
			f.setF_price(a3);
			f.setF_infor(a4);
			f.setF_service(a5);
			f.setF_phone(a6);
			f.setF_mapinfo1(a7);
			f.setF_mapinfo2(a8);
			f.setF_mapinfo3(a9);
			f.setF_mapinfoName(a10);
			f.setF_photo1(f_photo1);
			f.setF_photo2(f_photo2);
			f.setF_photo3(f_photo3);
			f.setF_kind(a11);
			
			if (ss.getMapper(Foodmapper.class).addinformfood(f) == 1) {
				req.setAttribute("r", "등록 성공!");
				allMsgCnt3++;
			} else {
				req.setAttribute("r", "등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록실패(DB 서버문제)");
			String f_photo1 = mr.getFilesystemName("f_photo1");
			File f1 = new File(path + "/" + f_photo1);
			f1.delete();
			
			String f_photo2 = mr.getFilesystemName("f_photo2");
			File f2 = new File(path + "/" + f_photo2);
			f2.delete();
			
			String f_photo3 = mr.getFilesystemName("f_photo3");
			File f3 = new File(path + "/" + f_photo3);
			f3.delete();
		}
		
		
	}

	public void ShowFood(int page, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		req.setAttribute("curPage", page);
		System.out.println("page : " + page);
		System.out.println("allMsgCnt : " + allMsgCnt3);

		//String f_category = req.getParameter("f_category");
		//String f_sort = req.getParameter("f_sort");
		
		String f_name = (String) req.getSession().getAttribute("f_name");
		String f_kind = (String) req.getSession().getAttribute("f_kind");


		int msgCnt = 0;

		if (f_kind == null && f_name == null) { // 전체조회 (검색어 없으면)
			msgCnt = allMsgCnt3;
			f_kind = "";
			f_name = "";
		} else if (f_kind == null && f_name != null) { // 검색어가 있으면 검색인거.
			f_kind = "";

			NeedForFoodSearchValue sSel2 = new NeedForFoodSearchValue(f_name, f_kind, 0, 0);
			msgCnt = ss.getMapper(Foodmapper.class).getSearchFoodCnt(sSel2);

		} else if (f_kind != null && f_name == null) { // 검색어가 있으면 검색인거.
			f_name = "";

			NeedForFoodSearchValue sSel2 = new NeedForFoodSearchValue(f_name, f_kind, 0, 0);
			msgCnt = ss.getMapper(Foodmapper.class).getSearchFoodCnt(sSel2);

		}

		// allMsgCnt -> msgCnt
		int allPageCount = (int) Math.ceil((double) msgCnt / so.getSnsMsgPerPage2());
		req.setAttribute("allPageCount", allPageCount);
		// 14 / 10 한걸 올림시킨거 = 2
		int start = (page - 1) * so.getSnsMsgPerPage2() + 1;
		// 2페이지면 11 시작
		System.out.println("start : " + start);

		int end = (page == allPageCount) ? msgCnt : start + so.getSnsMsgPerPage2() - 1;
		// 2 == 2 ? 2
		// 1 == 2 ? 아니고 : 1 + 9 = 10
		System.out.println("end : " + end);

		NeedForFoodSearchValue sSel = new NeedForFoodSearchValue(f_name, f_kind, start, end);
		List<FoodInforValue> snsMsgs = ss.getMapper(Foodmapper.class).getSearchInforBoardVer2(sSel);

		// 댓글 들 가져오기

		req.setAttribute("FoodBoard", snsMsgs);
		
		
		
	}
	
	public void countAllMsg() {
		System.out.println("넌 뭐니" + so.getSnsMsgPerPage2());

		allMsgCnt3 = ss.getMapper(Foodmapper.class).getAllfoodCount();
		
		
		System.out.println(allMsgCnt3);
	}
	
	
	public void searchfood(HttpServletRequest req) {
		String f_kind = req.getParameter("f_kind");
		String f_name = req.getParameter("f_name");

		System.out.println(f_kind);
		System.out.println(f_name);
		req.getSession().setAttribute("f_kind", f_kind);
		req.getSession().setAttribute("f_name", f_name);

	}

public void searchfoodClear(HttpServletRequest req) {

		req.getSession().setAttribute("f_name", null);
		req.getSession().setAttribute("f_kind", null);
	}

public void ShowFoodMore(FoodInforValue f, HttpServletRequest req , ModelMap model) {
	// TODO Auto-generated method stub
	
	
	FoodInforValue ff =ss.getMapper(Foodmapper.class).getfoodmore(f);
	List<FoodReply> replys = ss.getMapper(Foodmapper.class).foodgetReply(f);
	
	double star2= 0;
	
	double size=replys.size();
				
    System.out.println("size : " +size);
				
	for (int i = 0; i < replys.size(); i++) {
			
	double star	= replys.get(i).getSir_c_star();

		star2 = star2 +  star ;
	
	}
	
	double avg = (star2/size);
	
	if (Double.isNaN(avg)) {
		
		req.setAttribute("avg", "등록된 평점이 없어요.  \n 登録された評点がありません。");
		
	}else {
		String avg2 =String.format("%.1f", avg);
		
		req.setAttribute("avg", avg2 +" / 5.0");

	}
	
	System.out.println("avg : " + avg);
	
	String service = ff.getF_service();
	String[] Foodser2 = service.split("!");

	String a1=ff.getF_mapinfo1();
	String a2=ff.getF_mapinfo2();
	String a3=ff.getF_mapinfo3();
	String a4=ff.getF_mapinfoName();
	
	System.out.println(a1);
	System.out.println(a2);
	System.out.println(a3);
	System.out.println(a4);
	
	 model.addAttribute("value1", a1);
	 model.addAttribute("value2", a2);
	 model.addAttribute("value3", a3);
	 model.addAttribute("value4", a4);
	
	
	req.setAttribute("Foodser", Foodser2);
	req.setAttribute("FoodBoard", ff);
	req.setAttribute("replys", replys);
	
	int size2 = (int) Math.round(size);
	req.setAttribute("size", size2);
	
	
}



public void writeReply(FoodInforValue f,FoodReply sr, HttpServletRequest req) {
	// TODO Auto-generated method stub
	member m = (member) req.getSession().getAttribute("loginMember");
	
	int f_no = Integer.parseInt(req.getParameter("f_no"));
	
	f.setF_no(f_no);
	
	List<FoodReply> Foodreplys = ss.getMapper(Foodmapper.class).foodgetReply(f);
	

	
	for (int i = 0; i < Foodreplys.size(); i++) {
		
		String writterMember = Foodreplys.get(i).getSir_c_writer();
		System.out.println(writterMember);
		
		String LoginWritter=m.getC_id();
		System.out.println(LoginWritter);
		
		
		if (LoginWritter.equals(writterMember)) {
			
			req.setAttribute("r","이미 리뷰를 등록하셨습니다 <br> すでにレビューを登録しました。" );
			return;
			
		}
		
	}
	
	
	String token = req.getParameter("token");
	System.out.println("token 값: "+token);

	String st = (String) req.getSession().getAttribute("successToken");
	
	System.out.println("st 값: "+token);
	
	
	if (st != null && token.equals(st)) {

		//req.setAttribute("r", " 쓰기 실패(새로고침)");
		System.out.println("새로 고침 쓰기 실패");
		return;
	}
	
	sr.setSir_c_writer(m.getC_id());
	
	   double star =Double.parseDouble(req.getParameter("sir_c_star"));
	   	
	   System.out.println("star : " +star);
	   
	   sr.setSir_c_star(star);
	
	if (ss.getMapper(Foodmapper.class).foodwriteReply(sr) == 1) {
		req.getSession().setAttribute("successToken", token);

		req.setAttribute("r", "댓글 쓰기를 완료 했습니다. <br> コメント書き終わりました。  ");
	} else {
		req.setAttribute("r", "댓글 쓰기 실패");

	}
	
	
		
	   
	
	

	
	
}


public void delectReply(FoodReply sr, HttpServletRequest req) {
	// TODO Auto-generated method stub
	
	int sir_no=Integer.parseInt(req.getParameter("sir_no"));
	System.out.println("sir_no : " + sir_no);
	
	
	
	Foodmapper mm = ss.getMapper(Foodmapper.class);

	 if(mm.fooddelectReply(sr) == 1) {
		 
			req.setAttribute("r", "댓글을 삭제 했습니다. <br> コメントを削除しました。 ");		
	 }else {
			req.setAttribute("r", " 삭제 실패");		

	}

	
}

	
}
