package com.mvc.mapper;

import java.util.List;

import com.mvc.vo.Food;
import com.mvc.vo.FoodPageBean;
import com.mvc.vo.Member;

public interface BoardMapper {
	public int foodCount(FoodPageBean bean);
	public List<Food> searchAll(FoodPageBean bean);
	public Food search(int code);
	public List<Food> searchBest();
	public List<Food> searchBestIndex();
	public List<Food> searchByName(String word);
	public List<Food> searchByMaker(String word);
	public List<Food> searchByMaterial(String word);
	
	
	public String findMember(String id, String pass);
	public int memberCount();
	public void add(Member m);
	public void delete(Member m);
	public Member search(String id);
	public boolean search(String id, String pass);
	public List<Food> myeats(String id);
	
	public void addAllergy(String a, String id);
	
	public String[] allergiesInId(String id);
	public String allergiesInFood(String code);
	public void eats(String id, String code);
	public void pick(String mid, int fid);
    public List<Food> mypick(String mid);
}
