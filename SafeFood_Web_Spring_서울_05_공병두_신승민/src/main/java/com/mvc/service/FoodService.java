package com.mvc.service;

import java.util.List;

import com.mvc.vo.Food;
import com.mvc.vo.FoodPageBean;
import com.mvc.vo.Member;

public interface FoodService {
	public List<Food> searchAll(FoodPageBean bean);
	public Food search(int code);
	public List<Food> searchBest();
	public List<Food> searchBestIndex();
	public List<Food> searchByName(String word);
	public List<Food> searchByKey(String key, String word);
	
	public boolean findMember(String id, String pass);
	public void add(Member m);
	
	public String[] allergiesInId(String id);
	public String allergiesInFood(String code);
	public void eats(String id, String code);
	
	public List<Food> myeats(String id);
	public void pick(String mid, int fid);
    public List<Food> mypick(String mid);
}
