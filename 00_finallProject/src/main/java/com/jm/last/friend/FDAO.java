package com.jm.last.friend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.last.Basicmapper;
import com.jm.last.SNSSelector;
import com.jm.last.member;

@Service
public class FDAO {

	@Autowired
	private SqlSession ss;

	public void findfriend(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		List<member> friends =ss.getMapper(Friendmapper.class).getfriendmember();
		
		req.setAttribute("friends", friends);
		
		//mymapper mm = ss.getMapper(mymapper.class);
		//List<Member> menus = mm.getmenu();
	}

	public void findfriendmore(member m,HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		member friends2 = ss.getMapper(Friendmapper.class).getfriendmembermore(m);
		
		req.setAttribute("friends", friends2);
		
	}

	public void findfriendname(member m, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		String c_name=req.getParameter("c_name");
		System.out.println("c_name"+c_name);
	
		

		
		
		List<member> friends3 = ss.getMapper(Friendmapper.class).getfriendmembername(m);
		
		
		
		req.setAttribute("friends", friends3);
	}

	public void findbyinfo(member m, HttpServletRequest req) {
		System.out.println(" 표시");

			List<member> friends4 = ss.getMapper(Friendmapper.class).getfriendinfo(m);
			req.setAttribute("friends", friends4);
	}

	public void findbygender(member m, HttpServletRequest req) {
		// TODO Auto-generated method stub
		//String gender=req.getParameter("c_gender");
		String gender=m.getC_genderK();
		System.out.println("gender"+gender);
		
		
		List<member> friends5 = ss.getMapper(Friendmapper.class).getfriendgender(m);
		req.setAttribute("friends", friends5);
	}

	public void findbycountry(member m, HttpServletRequest req) {
		System.out.println("나라 안에 표시");
		List<member> friends6 = ss.getMapper(Friendmapper.class).getfriendcountry(m);
		req.setAttribute("friends", friends6);
	}

	public void writeemailgo(sendmessage s, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		String token = req.getParameter("token");
		System.out.println(token);

		String st = (String) req.getSession().getAttribute("sucessToken");

		if (st != null && token.equals(st)) {

			req.setAttribute("r", "댓글 쓰기 실패(새로고침)");
			System.out.println("새로 고침 댓글 쓰기 실패");
			return;
		}

		
		//String getter=req.getParameter("c_getter");
		//String sender=req.getParameter("c_sender");
		
		
		

		if (ss.getMapper(Friendmapper.class).sendMsg(s) == 1) {
			
			req.setAttribute("r", "메일을 성공적으로 보냈습니다. <br> メールを成功的に送りました。");
			req.getSession().setAttribute("sucessToken", token);

		} else {

			req.setAttribute("r", "메일 보내는 것을 실패했습니다. <br> メール送るのに失敗しました。  ");
		}
		
		
	}

	public void seeemailgo(sendmessage s, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		///////////////////////////////////////////////////////////
		System.out.println("작동하니?");
		
		member m = (member) req.getSession().getAttribute("loginMember");
		
		System.out.println("id 값 뭐냐"+m.getC_id());
		String id=m.getC_id();
			
		s.setC_getter(id);
		System.out.println(s.getC_getter());
		
		
		List<sendmessage> r =ss.getMapper(Friendmapper.class).getmessage(s);
		
		req.setAttribute("message", r);
		System.out.println("작동하니2?");

	}

	public void delectmessage(sendmessage s, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		Friendmapper ss2 = ss.getMapper(Friendmapper.class);
		
		

		 if(ss2.delectmessage(s)==1) {
			 
				req.setAttribute("r", "메세지를 삭제 했습니다. <br> メッセージを削除しました。  ");		
		 }else {
				req.setAttribute("r", "메세지 삭제를 실패했습니다. <br> メッセージの削除に失敗しました。");		

		}
	}

	public void checkmessageCanDO(sendmessage s, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		sendmessage send = ss.getMapper(Friendmapper.class).GetTheMessageForCheck(s);
		
		req.setAttribute("k", send);
		
	}

	
	
	
	
}
