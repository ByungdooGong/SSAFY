package safefood.dao;

import java.util.List;

import safefood.vo.Member;

public interface MemberDao {
	public int memberCount();
	public void add(Member m);
	public void delete(Member m);
	public Member search(String id);
	public boolean search(String id, String pass);
	public void eats(String mid, String fid);
	public List<String> myeats(String mid);
}
