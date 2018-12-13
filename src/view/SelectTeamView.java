package view;

import java.util.List;

import dao.TeamDAO;
import dto.TeamDTO;

public class SelectTeamView extends AbsView {

	private TeamDAO teamDAO;

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public void show() {
		List<TeamDTO> teamList = teamDAO.getTeamList();
		showTeamList(teamList);
		msg("Enter키를 누르세요");
		getEnter();

	}

	protected void showTeamList(List<TeamDTO> teamList) {
		System.out.println("**********************************");
		System.out.println(">>>팀 리스트");
		System.out.println("**********************************");

		for (TeamDTO team : teamList) {
			System.out.println(team.getId() + "\t\t\t" + team.getName());
		}
	}

}
