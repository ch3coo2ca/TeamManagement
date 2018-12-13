package view;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class InsertMemberView extends AbsView {
	private TeamDAO teamDAO;
	private MemberDAO memberDAO;

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void show() {
		final String memberName = "팀원 이름 ";
		String name = getKeyInputString(memberName);

		if (!Utils.isEmpty(name, memberName)) {
			return;// show();
		} else if (Utils.isLength(name, memberName, 128)) {
			MemberDTO member = new MemberDTO();
			member.setName(name);
			showTeamField(member);
		}
	}

	public void showTeamField(MemberDTO member) {
		final String teamId = "팀 ID : ";
		String id = getKeyInputString(teamId);

		if (!Utils.isEmpty(id, teamId)) {
			return;
		} else if (Utils.isNumeric(id, teamId)) {
			TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));

			if (team == null) {
				msg(":::[" + id + "]의 팀은 존재하지 않습니다.");
				showTeamField(member);
				memberDAO.insertMember(member);
				msg(":::팀[" + team.getName() + "]에 선수 [" + member.getName() + "]를 추가");
			}
		}
	}
}
