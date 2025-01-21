package _12콜랙션멤버;

public class ActionUpdate implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if(!dao.isDataExsit()) {
			System.out.println("데이터가 없습니다");
			return;
		}
		System.out.println("==== [ 수정 ] ==== ");
		
		String id = dao.getIdEqualIdAndPw();
		if(id == null) {
			return;
		}
		Utils util = Utils.getInstance();
		String name = util.getStrValue("새로운 이름 >> ");
		if(dao.getMemberMap().get(id).getName().equals(name)) {
			System.out.println("사용하던 이름으로는 바꿀 수 없습니다");
			return;
		}
		dao.getMemberMap().get(id).setName(name);
		System.out.println(dao.getMemberMap().get(id) + " 수정 완료");
	}

}
