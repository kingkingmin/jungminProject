package com.jm.last.information;

import java.util.List;

public interface InformBoardmapper {

 public int addinformBoardgo(inforboardValue i);

 public	List<inforboardValue> callinforBoardgo();

/////////////////////////////////////////////////////////////////////////////
  public int getAllInforCount();
  
public int getSearchInforBoardCnt(NeedForSearchvalues sSel2);

public List<inforboardValue> getInforBoardBySearch(NeedForSearchvalues sSel);

public int getSearchMsgCntVerK2(NeedForSearchvaluesVerK2 sSel2);

public List<inforboardValue> getSearchInforBoardVerK2(NeedForSearchvaluesVerK2 sSel);
/////////////////////////////
public int getSearchMsgCntVerJ2(NeedForSearchvaluesVerJ2 sSel2);

public List<inforboardValue> getSearchInforBoardVerJ2(NeedForSearchvaluesVerJ2 sSel);
////////////////////////////////////////////////////////////////////////////////////

public inforboardValue getInforBoardMore(inforboardValue i);

public int delectInfordo(inforboardValue i);

public int updateInforgo(inforboardValue i);

//////////////////////////////////////////////////////////////////////////////////////// 20210817 밑으로

public int writeReply(InforReply sr);

public List<InforReply> getReply(inforboardValue snsMsg);

public int delectReply(InforReply sr);

}
