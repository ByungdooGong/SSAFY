package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.FoodDao;
import com.mvc.dao.FoodDaoImpl;
import com.mvc.vo.Food;
import com.mvc.vo.FoodPageBean;
import com.mvc.vo.Member;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDao dao;
	
	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	@Override
	public List<Food> searchAll(FoodPageBean bean) {
		return dao.searchAll(bean);
	}

	@Override
	public Food search(int code) {
		return dao.search(code);
	}

	@Override
	public List<Food> searchBest() {
		return dao.searchBest();
	}

	@Override
	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}

	@Override
	public List<Food> searchByName(String word) {
		return dao.searchByName(word);
	}

	@Override
	public List<Food> searchByKey(String key, String word) {
		return dao.searchByKey(key, word);
	}

	@Override
	public boolean findMember(String id, String pass) {
		return dao.findMember(id, pass);
	}

	@Override
	public void add(Member m) {
		dao.add(m);
	}

	@Override
	public String[] allergiesInId(String id) {
		return dao.allergiesInId(id);
	}

	@Override
	public String allergiesInFood(String code) {
		return dao.allergiesInFood(code);
	}

	@Override
	public void eats(String id, String code) {
		dao.eats(id, code);
	}

	@Override
	public List<Food> myeats(String id) {
		return dao.myeats(id);
	}
	
	@Override
	public void pick(String mid, int fid) {
		dao.pick(mid, fid);
	}

	@Override
	public List<Food> mypick(String mid) {
		return dao.mypick(mid);
	}

}
