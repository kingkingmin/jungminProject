package com.jm.last.food;

import java.util.List;

public interface Foodmapper {

 public	int addinformfood(FoodInforValue f);

public int getAllfoodCount();

public int getSearchFoodCnt(NeedForFoodSearchValue sSel2);

public List<FoodInforValue> getSearchInforBoardVer2(NeedForFoodSearchValue sSel);

public FoodInforValue getfoodmore(FoodInforValue f);

public int foodwriteReply(FoodReply sr);

public List<FoodReply> foodgetReply(FoodInforValue f);

public int fooddelectReply(FoodReply sr);



}
