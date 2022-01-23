package com.jm.last;

import java.util.List;

import com.jm.last.friend.sendmessage;

public interface Basicmapper {

   public int regmenugo(member m);

public member getMemberById(member m);

public int bye(member m);

public int updategogo(member m);

public List<member> getMenuByName();
////////////////////////////////////////////////
public int getAllMsgCount();

public int getSearchMsgCnt(SNSSelector sSel2);

public List<member> getMsg(SNSSelector p);
///////////////////////////////////////// 20210810 /////
public int getSearchMsgCntForMail(SNSSelectorForMail sSel2);

public List<sendmessage> getMsgForMail(SNSSelectorForMail sSel);


///////////////////////////////////////////20210818 밑으로///////////

public int plusUserForBlock(BlockMember b);

public BlockMember getblockmember(BlockMember b);

public int UpdateUserForBlock(BlockMember2 b);
///////////////////////////////////////////20210819 밑으로///////////

public BlockMember getMenuByBlock(BlockMember b);

///////////////////////////////////////////20210908 밑으로///////////

public List<member> getMenuByEmail();
}
