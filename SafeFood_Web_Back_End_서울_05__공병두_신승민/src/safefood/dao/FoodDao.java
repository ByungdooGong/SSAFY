package safefood.dao;

import java.util.List;

import safefood.vo.Food;
import safefood.vo.FoodPageBean;

public interface FoodDao {
	public void loadData();
	public int foodCount(FoodPageBean bean);
	public List<Food> searchAll(FoodPageBean bean);
	public Food search(int code);
	public List<Food> searchBest();
	public List<Food> searchBestIndex();
}
