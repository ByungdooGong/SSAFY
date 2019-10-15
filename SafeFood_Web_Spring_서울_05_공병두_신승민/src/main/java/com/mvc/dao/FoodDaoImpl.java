package com.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mapper.BoardMapper;
import com.mvc.vo.Food;
import com.mvc.vo.FoodPageBean;
import com.mvc.vo.Member;

@Repository
public class FoodDaoImpl implements FoodDao {
	@Autowired
	BoardMapper mapper;

	@Override
	public int foodCount(FoodPageBean bean) {
		return mapper.foodCount(bean);
	}

	@Override
	public List<Food> searchAll(FoodPageBean bean) {
		return mapper.searchAll(bean);
	}

	/**
	 * ?��?�� 코드?�� ?��?��?��?�� ?��?��?��보�?? �??��?��?�� 반환.
	 * 
	 * @param code �??��?�� ?��?�� 코드
	 * @return ?��?�� 코드?�� ?��?��?��?�� ?��?�� ?���?, ?��?���? null?�� 리턴?��
	 */
	@Override
	public Food search(int code) {
		return mapper.search(code);
	}

	@Override
	public List<Food> searchBest() {
		return null;
	}

	@Override
	public List<Food> searchBestIndex() {
		return null;
	}

	@Override
	public List<Food> searchByName(String word) {
		return mapper.searchByName("%"+word+"%");
	}

	@Override
	public List<Food> searchByKey(String key, String word) {
		if(key.equals("name")) {
			return mapper.searchByName("%" +word +"%");
		}else if(key.equals("maker")) {
			return mapper.searchByMaker("%" +word +"%");
		}else if(key.equals("material")) {
			return mapper.searchByMaterial("%" +word +"%");
		}else
			return null;
	}

	@Override
	public boolean findMember(String id, String pass) {
		if(mapper.findMember(id, pass)==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void add(Member m) {
		mapper.add(m);
		for(String a:m.getAllergies()) {
			mapper.addAllergy(a, m.getId());
		};
	}

	@Override
	public String[] allergiesInId(String id) {
		return mapper.allergiesInId(id);
	}

	@Override
	public String allergiesInFood(String code) {
		return mapper.allergiesInFood(code);
	}

	@Override
	public void eats(String id, String code) {
		mapper.eats(id, code);
	}

	@Override
	public List<Food> myeats(String id) {
		return mapper.myeats(id);
	}

	@Override
	public void pick(String mid, int fid) {
		mapper.pick(mid, fid);
	}

	@Override
	public List<Food> mypick(String mid) {
		return mapper.mypick(mid);
	}

}
