package safefood.service;

import java.util.List;

import safefood.vo.Food;
import safefood.vo.FoodPageBean;

public interface FoodService {
	public List<Food> searchAll(FoodPageBean bean);
	public Food search(int code);
	public List<Food> searchBest();
	public List<Food> searchBestIndex();
}
