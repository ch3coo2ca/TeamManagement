package view;

import dao.MemberDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class UpdateMemberView extends AbsView {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void show() {
		final String memberId = "이동할 팀원의 번호 ";
		String id = getKeyInputString(memberId);
		final String teamId = "새로운 팀의 번호  ";
		String team_id = getKeyInputString(teamId);

		if (!Utils.isEmpty(id, memberId) || !Utils.isEmpty(team_id, teamId)) {
			return;
		} else {
			TeamDTO team = new TeamDTO();
			team.setId(Integer.valueOf(team_id));

			MemberDTO member = new MemberDTO();
			member.setId(Integer.valueOf(id));
			member.setTeam(team);
			memberDAO.updateMember(member);
		}
	}
}
