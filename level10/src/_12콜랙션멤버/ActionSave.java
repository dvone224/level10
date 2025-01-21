package _12콜랙션멤버;

public class ActionSave implements Action {

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		Utils util = Utils.getInstance();
		if(!dao.isDataExsit()) {
			System.out.println("데이터가 없습니다");
			return;
		}
		
		String data = "";
		for (Member member : dao.getTreeSoryBy("id")) {
			data += String.format("%s/%s/%s\n", member.getId(), member.getPw(), member.getName());
		}
		data = data.substring(0, data.length() - 1);
		util.saveFile(data, "member.txt");
	}
}
