package com.jm.last.friend;

import java.util.List;

import com.jm.last.member;

public interface Friendmapper {

	public List<member> getfriendmember();

	public member getfriendmembermore(member m);

	public List<member> getfriendmembername(member m);

	public List<member> getfriendinfo(member m);

	public List<member> getfriendgender(member m);

	public List<member> getfriendcountry(member m);

	public int sendMsg(sendmessage s);

	public List<sendmessage> getmessage(sendmessage s);

	public int delectmessage(sendmessage s);

	public sendmessage GetTheMessageForCheck(sendmessage s);

}
