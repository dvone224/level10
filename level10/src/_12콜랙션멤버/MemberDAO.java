package _12콜랙션멤버;

import java.util.HashMap;
import java.util.TreeSet;

import _12콜랙션멤버.MemberComp.SortBy;

/**
 * 
 */
public class MemberDAO {

	private HashMap<String, Member> memberMap;
	
	private MemberDAO() {
		memberMap = new HashMap<String, Member>();
	}
	private static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	
	public boolean isDataExsit() {
		return memberMap.size() != 0;
	}
	
	public void addAMember(String id, String pw, String name) {
		insertAMember(new Member(id, pw, name));
		
	}
	private void insertAMember(Member member) {
		memberMap.put(member.getId(), member);
	}

	
	public void printAllMember() {
		for(Member m : memberMap.values())
			System.out.println(m);
	}
	
	public HashMap<String, Member> getMemberMap() {
		return memberMap;
	}

	public String getIdEqualIdAndPw() {
		Utils util = Utils.getInstance();
		String id = util.getStrValue("ID>> ");
		if(!memberMap.containsKey(id)) {
			System.out.println("일치하는 아이디가 없습니다");
			return null;
		}
		String pw = util.getStrValue("PW>> ");
		if(!memberMap.get(id).getPw().equals(pw)) {
			System.out.println("패스워드가 일치하지 않습니다");
			return null;
		}
		return id;
	}
	
	public TreeSet<Member> getTreeSoryBy(String sort){
		SortBy sortBy = null;
		if(sort.equals("id")) {
			sortBy = MemberComp.SortBy.ID;
		}else if(sort.equals("name")) {
			sortBy = MemberComp.SortBy.NAME;
		}
		TreeSet<Member> treeSet = new TreeSet<Member>(new MemberComp(sortBy));
		for (Member member : memberMap.values()) {
			treeSet.add(member);
		}
		return null;
	}
	
	public void removeById() {
		
	}
	
	
	
}
