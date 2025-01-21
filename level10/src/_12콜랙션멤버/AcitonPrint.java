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
		for(Member member : dao.getTreeSoryBy("name")) {
			System.out.println(member);
		}
	}

}
