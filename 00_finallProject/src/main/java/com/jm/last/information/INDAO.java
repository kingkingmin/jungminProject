package com.jm.last.information;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.jm.last.member;
import com.jm.last.siteOption;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class INDAO {

	private int allMsgCnt2;

	@Autowired
	private SqlSession ss;

	@Autowired
	private siteOption so;

	public void countAllMsg() {
		System.out.println("넌 뭐니" + so.getSnsMsgPerPage());

		allMsgCnt2 = ss.getMapper(InformBoardmapper.class).getAllInforCount();

		System.out.println(allMsgCnt2);
	}

	public void addinforBoard(inforboardValue i, HttpServletRequest req) throws IOException {
		
		

		String path = req.getSession().getServletContext().getRealPath("resources/img");
		
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
			
			String token = mr.getParameter("token");
			System.out.println("token 값: "+token);

			String st = (String) req.getSession().getAttribute("successToken");
			
			System.out.println("st 값: "+token);
			
			
			if (st != null && token.equals(st)) {

				//req.setAttribute("r", " 쓰기 실패(새로고침)");
				System.out.println("새로고침으로 쓰기를 실패 했습니다.");
				return;
			}
			
			
			String a1 = mr.getParameter("f_writter");
			
			
			String a2 = mr.getParameter("f_category");
			String[] f_category = a2.split(",");

			String a3 = mr.getParameter("f_sort");
			String[] f_sort = a3.split(",");

			
			String a4 = mr.getParameter("f_title");
			String a5 = mr.getParameter("f_story");
			String a6 = mr.getParameter("f_mapinfo1");
			String a7 = mr.getParameter("f_mapinfo2");
			String a8 = mr.getParameter("f_mapinfo3");
			String a9 = mr.getParameter("f_mapinfoName");

			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			System.out.println(a4);
			System.out.println(a5);
			System.out.println(a6);
			System.out.println(a7);
			System.out.println(a8);
			System.out.println(a9);

			String f_photo = mr.getFilesystemName("f_photo");

			if (f_photo == null) {
				f_photo = "asd";
			}
			f_photo = URLEncoder.encode(f_photo, "utf-8");
			f_photo = f_photo.replace("+", " ");

			i.setF_writter(a1);
			
			i.setF_categoryK(f_category[0]);
			i.setF_categoryJ(f_category[1]);
			
			i.setF_sortK(f_sort[0]);
			i.setF_sortJ(f_sort[1]);
			
			i.setF_title(a4);
			i.setF_story(a5);
			i.setF_mapinfo1(a6);
			i.setF_mapinfo2(a7);
			i.setF_mapinfo3(a8);
			i.setF_mapinfoName(a9);
			i.setF_photo(f_photo);

			if (ss.getMapper(InformBoardmapper.class).addinformBoardgo(i) == 1) {
				req.setAttribute("r", "글을 등록 하셨습니다.<br> 作成が完了しました。 ");
				req.getSession().setAttribute("successToken", token);
				allMsgCnt2++;
			} else {
				req.setAttribute("r", "글 등록을 실패했습니다. <br> 作成に失敗しました。 ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록실패(DB 서버문제)");
			String f_photo = mr.getFilesystemName("f_photo");
			File f = new File(path + "/" + f_photo);
			f.delete();
		}

	}

	public void callinforBoard(int page, HttpServletRequest req) {
		// TODO Auto-generated method stub

		// List<inforboardValue> mm =
		// ss.getMapper(InformBoardmapper.class).callinforBoardgo();
		req.setAttribute("curPage", page);

		//String search = req.getParameter("contentsearch");
		//String f_category = req.getParameter("f_category");
		
		String search = (String) req.getSession().getAttribute("search");
		String f_category = (String) req.getSession().getAttribute("f_category");

		System.out.println("search : " + search);
		System.out.println("f_category : " + f_category);
		System.out.println("allMsgCnt2 : " + allMsgCnt2);

		String f_writter = "";
		String f_story = "";
		String f_title = "";

		int msgCnt = 0;

		/*
		 * if (f_category.equals(null)) { System.out.println("전체 검색 분리로 들어오니?");
		 * 
		 * }
		 */
		if (f_category == null) {

			msgCnt = allMsgCnt2;
			search= null;
			
		} else {

			if (f_category.equals("title")) {

				f_title = search;
				f_writter = "";
				f_story = "";

				System.out.println("제목 분리로 들어오니?");
				NeedForSearchvalues sSel2 = new NeedForSearchvalues(f_writter, f_story, f_title, 0, 0);
				msgCnt = ss.getMapper(InformBoardmapper.class).getSearchInforBoardCnt(sSel2);
				System.out.println("제목 분리로 끝?");
			} else if (f_category.equals("content")) {
				f_story = search;
				f_writter = "";
				f_title = "";
				System.out.println("스토리 분리로 들어오니?");
				NeedForSearchvalues sSel2 = new NeedForSearchvalues(f_writter, f_story, f_title, 0, 0);
				msgCnt = ss.getMapper(InformBoardmapper.class).getSearchInforBoardCnt(sSel2);
			} else if (f_category.equals("writter")) {
				f_writter = search;
				f_story = "";
				f_title = "";

				System.out.println("작성자 분리로 들어오니?");
				NeedForSearchvalues sSel2 = new NeedForSearchvalues(f_writter, f_story, f_title, 0, 0);
				msgCnt = ss.getMapper(InformBoardmapper.class).getSearchInforBoardCnt(sSel2);
			}
		}

		req.setAttribute("curPage", page);
		System.out.println("page : " + page);

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
		//////////////////////////////////////////////////////////////////////////////////////// 20210813

		NeedForSearchvalues sSel = new NeedForSearchvalues(f_writter, f_story, f_title, start, end);
		List<inforboardValue> snsMsgs = ss.getMapper(InformBoardmapper.class).getInforBoardBySearch(sSel);
		
		//////////////////////////////////////////////////////////////////////////////////////// 20210817

//		for (inforboardValue snsMsg : snsMsgs) {
//			//	System.out.println(s.getC_no());
//			//	System.out.println(s.getC_color());
//			//	System.out.println(s.getC_comment());
//			
//				// 글 하나 하나에 해당하는 댓글
//			List<InforReply> replys =	ss.getMapper(InformBoardmapper.class).getReply(snsMsg);
//			snsMsg.setReply(replys);
//			 
//			//System.out.println(snsMsg.getC_comment());
////			if (replys != null) {
////				for (InforReply sr : replys) {
////					System.out.println(sr.getSir_c_comment());
////				}
////			}
//			 
//			}
		
		req.setAttribute("inforboardfirst", snsMsgs);

	}

	public void callinforBoardverK2(int page, HttpServletRequest req) {
		// TODO Auto-generated method stub

		req.setAttribute("curPage", page);
		System.out.println("page : " + page);
		System.out.println("allMsgCnt : " + allMsgCnt2);

		//String f_category = req.getParameter("f_category");
		//String f_sort = req.getParameter("f_sort");
		
		String f_category = (String) req.getSession().getAttribute("f_category");
		String f_sort = (String) req.getSession().getAttribute("f_sort");
		

		int msgCnt = 0;

		if (f_category == null && f_sort == null) { // 전체조회 (검색어 없으면)
			msgCnt = allMsgCnt2;
			f_category = "";
			f_sort = "";
		} else if (f_category != null && f_sort != null) {

			NeedForSearchvaluesVerK2 sSel2 = new NeedForSearchvaluesVerK2(f_category, f_sort, 0, 0);
			msgCnt = ss.getMapper(InformBoardmapper.class).getSearchMsgCntVerK2(sSel2);

		} else if (f_category == null && f_sort != null) { // 검색어가 있으면 검색인거.
			f_category = "";

			NeedForSearchvaluesVerK2 sSel2 = new NeedForSearchvaluesVerK2(f_category, f_sort, 0, 0);
			msgCnt = ss.getMapper(InformBoardmapper.class).getSearchMsgCntVerK2(sSel2);

		} else if (f_category != null && f_sort == null) { // 검색어가 있으면 검색인거.
			f_sort = "";

			NeedForSearchvaluesVerK2 sSel2 = new NeedForSearchvaluesVerK2(f_category, f_sort, 0, 0);
			msgCnt = ss.getMapper(InformBoardmapper.class).getSearchMsgCntVerK2(sSel2);

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

		NeedForSearchvaluesVerK2 sSel = new NeedForSearchvaluesVerK2(f_category, f_sort, start, end);
		List<inforboardValue> snsMsgs = ss.getMapper(InformBoardmapper.class).getSearchInforBoardVerK2(sSel);

		// 댓글 들 가져오기

		req.setAttribute("inforboardfirst", snsMsgs);

	}
	public void callinforBoardverJ2(int page, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		req.setAttribute("curPage", page);
		System.out.println("page : " + page);
		System.out.println("allMsgCnt : " + allMsgCnt2);
		
		//String f_category = req.getParameter("f_category");
		//String f_sort = req.getParameter("f_sort");
		
		String f_category = (String) req.getSession().getAttribute("f_category");
		String f_sort = (String) req.getSession().getAttribute("f_sort");
		
		
		int msgCnt = 0;
		
		if (f_category == null && f_sort == null) { // 전체조회 (검색어 없으면)
			msgCnt = allMsgCnt2;
			f_category = "";
			f_sort = "";
		} else if (f_category != null && f_sort != null) {
			
			NeedForSearchvaluesVerJ2 sSel2 = new NeedForSearchvaluesVerJ2(f_category, f_sort, 0, 0);
			msgCnt = ss.getMapper(InformBoardmapper.class).getSearchMsgCntVerJ2(sSel2);
			
		} else if (f_category == null && f_sort != null) { // 검색어가 있으면 검색인거.
			f_category = "";
			
			NeedForSearchvaluesVerJ2 sSel2 = new NeedForSearchvaluesVerJ2(f_category, f_sort, 0, 0);
			msgCnt = ss.getMapper(InformBoardmapper.class).getSearchMsgCntVerJ2(sSel2);
			
		} else if (f_category != null && f_sort == null) { // 검색어가 있으면 검색인거.
			f_sort = "";
			
			NeedForSearchvaluesVerJ2 sSel2 = new NeedForSearchvaluesVerJ2(f_category, f_sort, 0, 0);
			msgCnt = ss.getMapper(InformBoardmapper.class).getSearchMsgCntVerJ2(sSel2);
			
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
		
		NeedForSearchvaluesVerJ2 sSel = new NeedForSearchvaluesVerJ2(f_category, f_sort, start, end);
		List<inforboardValue> snsMsgs = ss.getMapper(InformBoardmapper.class).getSearchInforBoardVerJ2(sSel);
		
		// 댓글 들 가져오기
		
		req.setAttribute("inforboardfirst", snsMsgs);
		
	}

	public void callinforBoardBoard(inforboardValue i, HttpServletRequest req, ModelMap model) {
		// TODO Auto-generated method stub
		
		inforboardValue inforMore = ss.getMapper(InformBoardmapper.class).getInforBoardMore(i);
		
		List<InforReply> replys =	ss.getMapper(InformBoardmapper.class).getReply(i);

		
		String a1=inforMore.getF_mapinfo1();
		String a2=inforMore.getF_mapinfo2();
		String a3=inforMore.getF_mapinfo3();
		String a4=inforMore.getF_mapinfoName();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		 model.addAttribute("value1", a1);
		 model.addAttribute("value2", a2);
		 model.addAttribute("value3", a3);
		 model.addAttribute("value4", a4);
		
		req.setAttribute("inforboard", inforMore);
		req.setAttribute("replys", replys);
		
	}

	
	public void delectInforgo(inforboardValue i, HttpServletRequest req) {


		if (ss.getMapper(InformBoardmapper.class).delectInfordo(i) == 1) {
			req.setAttribute("r", "삭제를 완료 했습니다.! <br> 削除が完了しました。");
			allMsgCnt2--;
		} else {
			req.setAttribute("r", "삭제를 실패했습니다. <br> 削除に失敗しました。");
		}
		
}

	public void UpdateInforBoard(inforboardValue i, HttpServletRequest req) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "수정실패(파일용량초과)");
			return;
		}

		// 현재 로그인 된 회원 정보(수정되기 전)
		//Member lm = (Member) req.getSession().getAttribute("loginMember");

		// 기존 사진 파일명
		//String oldFile = mr.getFilesystemName("f_photo2"); // %2A.png
		String oldFile = mr.getParameter("f_photo2"); // %2A.png

		// 새 파일명
		String newFile = mr.getFilesystemName("f_photo"); // ㅎ.png
		
		try {
			
			int a10 = Integer.parseInt(mr.getParameter("f_no"));
			String a1 = mr.getParameter("f_writter");
			
			
			String a2 = mr.getParameter("f_category");
			String[] f_category = a2.split(",");

			
			String a3 = mr.getParameter("f_sort");
			String[] f_sort = a3.split(",");

			
			String a4 = mr.getParameter("f_title");
			
			String a5 = mr.getParameter("f_story");
			String a6 = mr.getParameter("f_mapinfo1");
			String a7 = mr.getParameter("f_mapinfo2");
			String a8 = mr.getParameter("f_mapinfo3");
			String a9 = mr.getParameter("f_mapinfoName");
			String a11 = mr.getParameter("token");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
			Date datego = sdf.parse(a11);

			if (newFile == null) { // 사진은 수정 안하는
				newFile = oldFile;
			} else { // 사진 수정
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
			
			i.setF_no(a10);
			i.setF_writter(a1);
			
			i.setF_categoryK(f_category[0]);
			i.setF_categoryJ(f_category[1]);
			
			i.setF_sortK(f_sort[0]);
			i.setF_sortJ(f_sort[1]);
			
			
			i.setF_title(a4);
			i.setF_story(a5);
			i.setF_mapinfo1(a6);
			i.setF_mapinfo2(a7);
			i.setF_mapinfo3(a8);
			i.setF_mapinfoName(a9);
			i.setF_photo(newFile);
			i.setF_date(datego);
			
			

			// DB수정
			if (ss.getMapper(InformBoardmapper.class).updateInforgo(i) == 1) {
				//req.setAttribute("r", "수정성공");
				System.out.println("수정 성공");

				// 사이트에 반영
				
				// 프사 바꾸는 상황 : 옛날 프사 지우기
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			} else {
				//req.setAttribute("r", "수정실패");
				System.out.println("수정 실패");
				
				// 프사 바꾸는 상황 : 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			//req.setAttribute("r", "수정실패");
			System.out.println("수정 실패");

			// 프사 바꾸는 상황 : 새 프사 지우기
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}
		
	}
	
	
	public void writeReply(InforReply sr, HttpServletRequest req) {
		// TODO Auto-generated method stub
		member m = (member) req.getSession().getAttribute("loginMember");
		sr.setSir_c_writer(m.getC_id());

		
		String token = req.getParameter("token");
		System.out.println("token 값: "+token);

		String st = (String) req.getSession().getAttribute("successToken");
		
		System.out.println("st 값: "+token);
		
		
		if (st != null && token.equals(st)) {

			//req.setAttribute("r", " 쓰기 실패(새로고침)");
			System.out.println("새로 고침으로 글쓰기가 실패했습니다.");
			return;
		}
		
		
		if (ss.getMapper(InformBoardmapper.class).writeReply(sr) == 1) {
			req.getSession().setAttribute("successToken", token);

			//req.setAttribute("r", "댓글 쓰기 성공");
			System.out.println("댓글쓰기 완료");
		} else {
			//req.setAttribute("r", "댓글 쓰기 실패");
			System.out.println("댓글쓰기 실패");

		}

	}

	public void delectReply(InforReply sr, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		int sir_no=Integer.parseInt(req.getParameter("sir_no"));
		System.out.println("sir_no : " + sir_no);
		
		
		
		InformBoardmapper mm = ss.getMapper(InformBoardmapper.class);

		 if(mm.delectReply(sr) == 1) {
			 
				//req.setAttribute("r", "삭제 성공");		
				System.out.println("댓글 삭제 성공");
		 }else {
				//req.setAttribute("r", " 삭제 실패");		
				System.out.println("댓글 삭제 실패");

		}

		
	}
	/////////////////////////////////////////////////////////////////////////////////20210817
	
	public void searchInfor(HttpServletRequest req) {
		
		String search = req.getParameter("contentsearch");
		String f_category = req.getParameter("f_category");


		System.out.println(search);
		req.getSession().setAttribute("search", search);
		req.getSession().setAttribute("f_category", f_category);

	}

	public void searchInforVer2(HttpServletRequest req) {
		String f_category = req.getParameter("f_category");
		String f_sort = req.getParameter("f_sort");

		req.getSession().setAttribute("f_category", f_category);
		req.getSession().setAttribute("f_sort", f_sort);

	}

	public void searchInforClear(HttpServletRequest req) {

		req.getSession().setAttribute("search", null);
		req.getSession().setAttribute("f_category", null);
	}

	public void searchInforVer2Clear(HttpServletRequest req) {

		req.getSession().setAttribute("f_category", null);
		req.getSession().setAttribute("f_sort", null);
	}
	/////////////////////////////////////////////////////////////////////////////////20210817 ???///

}
