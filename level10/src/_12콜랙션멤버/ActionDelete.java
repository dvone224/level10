package _12콜랙션멤버;

public class ActionDelete implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if(!dao.isDataExsit()) {
			System.out.println("데이터가 없습니다");
			return;
		}
		System.out.println("==== [ 삭제 ] ==== ");
		
		
		String id = dao.getIdEqualIdAndPw();
		if(id == null) {
			return;
		}
		
		System.out.printf("%s 삭제 완료\n",dao.getMemberMap().remove(id));
	}

}