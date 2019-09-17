package safefood.service;

import java.util.ArrayList;
import java.util.List;

import safefood.dao.FoodDao;
import safefood.dao.FoodDaoImpl;
import safefood.vo.Food;
import safefood.vo.FoodPageBean;

public class FoodServiceImpl implements FoodService {
	private FoodDao dao;
	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	public FoodServiceImpl() {
		dao = new FoodDaoImpl();
	};

	@Override
	public List<Food> searchAll(FoodPageBean bean) {
		return dao.searchAll(bean);
	}

	@Override
	public Food search(int code) {
		Food food = dao.search(code);
		// code에 맞는 식품 정보를 검색하고, 검색된 식품의 원재료에 알레르기 성분이 있는지 확인하여 Food 정보에 입력한다.
		return food;
	}

	@Override
	public List<Food> searchBest() {
		return dao.searchBest();
	}

	@Override
	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}

}
