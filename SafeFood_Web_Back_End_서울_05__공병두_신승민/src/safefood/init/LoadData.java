package safefood.init;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import safefood.util.FoodSaxParser;
import safefood.vo.Food;

@WebServlet("/LoadData")
public class LoadData extends HttpServlet {
	private List<Food> foods;
	DataSource ds;
	Connection con;
	
	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodSaxParser fsp = new FoodSaxParser();
		foods = fsp.getFoods(); 
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
            for (Food f : foods) {
                try {
                    String q = "insert into food values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    con = ds.getConnection();
                    PreparedStatement pstat = con.prepareStatement(q);
                    
                    pstat.setInt(1, f.getCode());
                    pstat.setString(2, f.getName());
                    pstat.setString(3, ""+f.getSupportpereat());
                    pstat.setString(4, ""+f.getCalory());
                    pstat.setString(5, ""+f.getCarbo());
                    pstat.setString(6, ""+f.getProtein());
                    pstat.setString(7, ""+f.getFat());
                    pstat.setString(8, ""+f.getSugar());
                    pstat.setString(9, ""+f.getNatrium());
                    pstat.setString(10, ""+f.getChole());
                    pstat.setString(11, ""+f.getFattyacid());
                    pstat.setString(12, ""+f.getTransfat());
                    pstat.setString(13, f.getMaker());
                    pstat.setString(14, f.getMaterial());
                    pstat.setString(15, f.getImg());
                    pstat.setString(16, f.getAllergy());
                    
                    pstat.executeUpdate();
                    
                    pstat.close();
                    con.close();
                } catch (Exception e) {
                }
                
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
		
		
		
	}

}
