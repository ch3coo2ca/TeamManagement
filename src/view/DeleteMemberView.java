package view;

import dao.MemberDAO;
import dto.MemberDTO;

public class DeleteMemberView extends AbsView {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void show() {
		final String memberName = "삭제할 팀원 번호 ";
		String id = getKeyInputString(memberName);

		if (!Utils.isEmpty(id, memberName)) {
			return;
		} else if (Utils.isLength(id, memberName, 128)) {
			MemberDTO dto = new MemberDTO(); 
			dto.setId(Integer.valueOf(id)); 
			memberDAO.deleteMember(dto);
		}
	}

}
