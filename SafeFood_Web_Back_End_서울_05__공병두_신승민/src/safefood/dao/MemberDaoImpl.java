package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import safefood.vo.Member;

public class MemberDaoImpl implements MemberDao {
	DataSource ds;

	public MemberDaoImpl() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void eats(String mid, String fid) {
		Connection con;
		try {
			con = ds.getConnection();
			String q = "select mid, fid from eats where mid= '" + mid +"' and fid= '"+fid+"' ";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			if(!rs.next()) {
				q = "insert into eats values (null, ?, ?)";
				PreparedStatement pstat = con.prepareStatement(q);
				
				pstat.setString(1, mid);
				pstat.setString(2, fid);
				
				pstat.executeUpdate();
				pstat.close();
			}
			stat.close();
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	@Override
	public int memberCount() {
		Connection con;
		try {
			String q = "select count(*) from member";
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

	@Override
	public void add(Member m) {
		Connection con;
		//member에 넣기
		try {
			con = ds.getConnection();
			String q = "insert into member values (?, ?, ?, ?)";
			PreparedStatement pstat = con.prepareStatement(q);
			
			pstat.setString(1, m.getId());
			pstat.setString(2, m.getPassword());
			pstat.setString(3, m.getName());
			pstat.setString(4, m.getPhone());
			
			pstat.executeUpdate();
			pstat.close();
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//allergies에 넣기
		try {
			con = ds.getConnection();
			String q = "insert into allergy values (null, ?, ?)";
			PreparedStatement pstat = con.prepareStatement(q);
			
			for(int i=0; i<m.getAllergies().length; i++) {
				pstat.setString(1, m.getAllergies()[i]);
				pstat.setString(2, m.getId());
				
				pstat.executeUpdate();
			}
			pstat.close();
			con.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void delete(Member m) {
//		if (search(m.getId()) != null) {
//			members.remove(m);
//		}
	}

	@Override
	public boolean search(String id, String pass) {
		Connection con;
		try {
			String q = "select id, pass from member where id = '" + id + "' and pass = '" + pass + "'";
			con = ds.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {}
		return false;
	}

	@Override
	public Member search(String id) {
		Connection con;
		try {
			String q = "select * from member where id='" + id + "'";
			con = ds.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			rs.next();
			Member m = new Member();
			m.setId(rs.getString(1));
			m.setPassword(rs.getString(2));
			m.setName(rs.getString(3));
			m.setPhone(rs.getString(4));
			
			q = "select allergies from allergy where mid='" + id + "'";
			String q2 = "select count(*) from allergy where mid='" + id + "'";
			
			rs = stat.executeQuery(q2);
			rs.next();
			int size = Integer.parseInt(rs.getString(1));
			System.out.println(size);
			String[] allergies = new String[size];
			rs = stat.executeQuery(q);
			int idx = 0;
			while(rs.next()) {
				allergies[idx] = rs.getString(1);
				System.out.println(allergies[idx]);
				idx++;
			}
			m.setAllergies(allergies);
			stat.close();
			con.close();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<String> myeats(String mid) {
		Connection con;
		List<String> myeats = new LinkedList<>();
		try {
			String q = "select fid from eats where mid='" + mid + "'";
			System.out.println(q);
			con = ds.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			while(rs.next()) {
				String fid = rs.getString(1);
				System.out.println(fid);
				myeats.add(fid);
			}
			return myeats;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
