package _12콜랙션멤버;

import java.util.TreeSet;

public class AcitonPrint implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		if(!dao.isDataExsit()) {
			System.out.println("데이터가 없습니다");
			return;
		}
		TreeSet<Member> printSet = new TreeSet<Member>(new MemberComp(MemberComp.SortBy.NAME));
		for(Member member : dao.getMemberMap().values()) {
			printSet.add(member);
		}
		for(Member member : printSet) {
			System.out.println(member);
		}
	}

}
