package safefood.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import safefood.util.FoodSaxParser;
import safefood.vo.Food;
import safefood.vo.FoodPageBean;

public class FoodDaoImpl implements FoodDao {
	private List<Food> foods;
	DataSource ds;

	public FoodDaoImpl() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	/**
	 * 식품 영양학 정보와 식품 정보를 xml 파일에서 읽어온다.
	 */
	@Override
	public void loadData() {
		FoodSaxParser fsp = new FoodSaxParser();
		foods = fsp.getFoods();
		// FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. web에서 구현할 내용. web에서 페이징 처리시
	 * 필요
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 개수
	 */
	@Override
	public int foodCount(FoodPageBean bean) {
		Connection con;
		try {
			String q = "select count(*) from food";
			con = ds.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를 검색해서 반환.
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	@Override
	public List<Food> searchAll(FoodPageBean bean) {
		List<Food> finds = new LinkedList<Food>();
		if (bean != null) {
			String key = bean.getKey();
			String word = bean.getWord();
			if (!key.equals("all") && word != null && !word.trim().equals("")) {
				finds = new LinkedList<Food>();
				if (key.equals("name")) {
					Connection con;
					String q = "select * from food where fname like '%" + word + "%'";
					try {
						con = ds.getConnection();
						Statement stat = con.createStatement();
						ResultSet rs = stat.executeQuery(q);
						while (rs.next()) {
							Food f = new Food();
							f.setCode(rs.getInt(1));
							f.setName(rs.getString(2));
							f.setSupportpereat(Double.parseDouble(rs.getString(3)));
							f.setCalory(Double.parseDouble(rs.getString(4)));
							f.setCarbo(Double.parseDouble(rs.getString(5)));
							f.setProtein(Double.parseDouble(rs.getString(6)));
							f.setFat(Double.parseDouble(rs.getString(7)));
							f.setSugar(Double.parseDouble(rs.getString(8)));
							f.setNatrium(Double.parseDouble(rs.getString(9)));
							f.setChole(Double.parseDouble(rs.getString(10)));
							f.setFattyacid(Double.parseDouble(rs.getString(11)));
							f.setTransfat(Double.parseDouble(rs.getString(12)));
							f.setMaker(rs.getString(13));
							f.setMaterial(rs.getString(14));
							f.setImg(rs.getString(15));
							f.setAllergy(rs.getString(16));
							finds.add(f);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 제조사 검색 구현
				else if (key.equals("maker")) {
					Connection con;
					try {
						String q = "select * from food where maker like '%" + word + "%'";
						con = ds.getConnection();
						Statement stat = con.createStatement();
						ResultSet rs = stat.executeQuery(q);
						while (rs.next()) {
							Food f = new Food();
							f.setCode(rs.getInt(1));
							f.setName(rs.getString(2));
							f.setSupportpereat(Double.parseDouble(rs.getString(3)));
							f.setCalory(Double.parseDouble(rs.getString(4)));
							f.setCarbo(Double.parseDouble(rs.getString(5)));
							f.setProtein(Double.parseDouble(rs.getString(6)));
							f.setFat(Double.parseDouble(rs.getString(7)));
							f.setSugar(Double.parseDouble(rs.getString(8)));
							f.setNatrium(Double.parseDouble(rs.getString(9)));
							f.setChole(Double.parseDouble(rs.getString(10)));
							f.setFattyacid(Double.parseDouble(rs.getString(11)));
							f.setTransfat(Double.parseDouble(rs.getString(12)));
							f.setMaker(rs.getString(13));
							f.setMaterial(rs.getString(14));
							f.setImg(rs.getString(15));
							f.setAllergy(rs.getString(16));
							finds.add(f);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 원재료 검색 구현
				else if (key.equals("material")) {
					Connection con;
					try {
						String q = "select * from food where material like '%" + word + "%'";
						con = ds.getConnection();
						Statement stat = con.createStatement();
						ResultSet rs = stat.executeQuery(q);
						while (rs.next()) {
							Food f = new Food();
							f.setCode(rs.getInt(1));
							f.setName(rs.getString(2));
							f.setSupportpereat(Double.parseDouble(rs.getString(3)));
							f.setCalory(Double.parseDouble(rs.getString(4)));
							f.setCarbo(Double.parseDouble(rs.getString(5)));
							f.setProtein(Double.parseDouble(rs.getString(6)));
							f.setFat(Double.parseDouble(rs.getString(7)));
							f.setSugar(Double.parseDouble(rs.getString(8)));
							f.setNatrium(Double.parseDouble(rs.getString(9)));
							f.setChole(Double.parseDouble(rs.getString(10)));
							f.setFattyacid(Double.parseDouble(rs.getString(11)));
							f.setTransfat(Double.parseDouble(rs.getString(12)));
							f.setMaker(rs.getString(13));
							f.setMaterial(rs.getString(14));
							f.setImg(rs.getString(15));
							f.setAllergy(rs.getString(16));
							finds.add(f);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}//원재료 검색 end
			}// if key.equals("all") || word == null || word.trim().equals("")
			else {
				Connection con;
				try {
					String q = "select * from food";
					con = ds.getConnection();
					Statement stat = con.createStatement();
					ResultSet rs = stat.executeQuery(q);
					while (rs.next()) {
						Food f = new Food();
						f.setCode(rs.getInt(1));
						f.setName(rs.getString(2));
						f.setSupportpereat(Double.parseDouble(rs.getString(3)));
						f.setCalory(Double.parseDouble(rs.getString(4)));
						f.setCarbo(Double.parseDouble(rs.getString(5)));
						f.setProtein(Double.parseDouble(rs.getString(6)));
						f.setFat(Double.parseDouble(rs.getString(7)));
						f.setSugar(Double.parseDouble(rs.getString(8)));
						f.setNatrium(Double.parseDouble(rs.getString(9)));
						f.setChole(Double.parseDouble(rs.getString(10)));
						f.setFattyacid(Double.parseDouble(rs.getString(11)));
						f.setTransfat(Double.parseDouble(rs.getString(12)));
						f.setMaker(rs.getString(13));
						f.setMaterial(rs.getString(14));
						f.setImg(rs.getString(15));
						f.setAllergy(rs.getString(16));
						finds.add(f);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return finds;
	}

	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
	 * 
	 * @param code 검색할 식품 코드
	 * @return 식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	@Override
	public Food search(int code) {
		Connection con;
		try {
			String q = "select * from food where fid=" + code;
			con = ds.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			rs.next();
			Food f = new Food();
			f.setCode(rs.getInt(1));
			f.setName(rs.getString(2));
			f.setSupportpereat(Double.parseDouble(rs.getString(3)));
			f.setCalory(Double.parseDouble(rs.getString(4)));
			f.setCarbo(Double.parseDouble(rs.getString(5)));
			f.setProtein(Double.parseDouble(rs.getString(6)));
			f.setFat(Double.parseDouble(rs.getString(7)));
			f.setSugar(Double.parseDouble(rs.getString(8)));
			f.setNatrium(Double.parseDouble(rs.getString(9)));
			f.setChole(Double.parseDouble(rs.getString(10)));
			f.setFattyacid(Double.parseDouble(rs.getString(11)));
			f.setTransfat(Double.parseDouble(rs.getString(12)));
			f.setMaker(rs.getString(13));
			f.setMaterial(rs.getString(14));
			f.setImg(rs.getString(15));
			f.setAllergy(rs.getString(16));
			return f;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 가장 많이 검색한 Food 정보 리턴하기 web에서 구현할 내용.
	 * 
	 * @return
	 */
	@Override
	public List<Food> searchBest() {
		return null;
	}

	@Override
	public List<Food> searchBestIndex() {
		return null;
	}

}
