package view;

import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class SelectMemberView extends AbsViewTemplate {

	private MemberDAO memberDAO;
	private DeleteMemberView deleteMemberView;
	private UpdateMemberView updateMemberView;

	public void setUpdateMemberView(UpdateMemberView updateMemberView) {
		this.updateMemberView = updateMemberView;
	}

	public void setDeleteMemberView(DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void showHeader() {
		System.out.println("****************************");
		System.out.println(">>>팀원관리");
		System.out.println("============================");

	}

	public Integer getTeamId() {
		String teamId = getKeyInputString("팀 ID");
		if (Utils.isNumeric(teamId, "팀 ID")) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}

	public void show() {
		Integer teamId = getTeamId();
		List<MemberDTO> memberList = memberDAO.getMembers(teamId);
		if (memberList.isEmpty()) {
			msg("선수가 아무도 없습니다.");
			return;
		}
		showMemberList(memberList);
		msg("Enter키를 누르세요");
		getEnter();
		super.show();

	}

	public void showMemberList(List<MemberDTO> memberList) {
		System.out.println(memberList.get(0).getTeam().getName() + "팀의 선수 명단");
		System.out.println("ID\t\t이름");
		System.out.println("****************************");
		for (MemberDTO member : memberList) {
			System.out.println(member.getId() + "\t\t" + member.getName());
		}
	}

	@Override
	public void showMenu() {
		showHeader();
		System.out.println("1.팀원 트레이드 ");
		System.out.println("2.팀원 방출");
		System.out.println("3.메뉴 복귀");
		System.out.println("****************************");
		System.out.println("번호 입력(Enter)");
	}

	@Override
	public int getMinMenuNumber() {
		return 1;
	}

	@Override
	public int getMaxMenuNumber() {
		return 3;
	}

	@Override
	public void execute(int number) {

		switch (number) {
		case 1:
			updateMemberView.show();
			break;

		case 2:
			deleteMemberView.show();
			break;
		case 3:
			break;

		default:
			break;
		}
	}

}
