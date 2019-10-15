package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mvc.mapper.BoardMapper;
import com.mvc.vo.Member;

public class MemberDaoImpl implements MemberDao {
	BoardMapper mapper;

	@Override
	public void eats(String mid, String fid) {
		mapper.eats(mid, fid);
	}


	@Override
	public int memberCount() {
		return mapper.memberCount();
	}

	@Override
	public void add(Member m) {
		mapper.add(m);
	}

	@Override
	public void delete(Member m) {
		mapper.delete(m);
	}

	@Override
	public boolean search(String id, String pass) {
		return mapper.search(id, pass);
	}

	@Override
	public Member search(String id) {
		return mapper.search(id);
	}


	@Override
	public List<String> myeats(String mid) {
//		return mapper.myeats(mid);
		return null;
	}

}
