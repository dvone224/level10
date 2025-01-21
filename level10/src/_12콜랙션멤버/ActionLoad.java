package _12콜랙션멤버;

public class ActionLoad implements Action{

	@Override
	public void excute() {
		Utils util = Utils.getInstance();
		MemberDAO dao = MemberDAO.getInstance();
		
		String data = util.loadFile("member.txt");
		if(data == null) {
			System.out.println("비어있는 파일입니다");
			return;
		}
		String[] temp = data.split("\n");
		for(String t : temp) {
			String[] info = t.split("/");
			dao.addAMember(info[0], info[1], info[2]);
		}
		System.out.println("데이터 로드 완료");
	}

}