package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import dto.MemberDTO;
import dto.TeamDTO;

public class MembersQuery extends MappingSqlQuery<MemberDTO> {

	private static String sql = "select member_id, member.name as memberName,"
			+ "team.team_id,team.name as teamName from member, team "
			+ "where member.team_id = team.team_id and team.team_id = ?";

	public MembersQuery(DataSource dataSource) {
		super(dataSource, sql);
		super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
		compile(); // 써야 실행됨
	}

	@Override
	protected MemberDTO mapRow(ResultSet row, int count) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setId(row.getInt("member_id"));
		member.setName(row.getString("memberName"));

		TeamDTO team = new TeamDTO();
		team.setId(row.getInt("team_id"));
		team.setName(row.getString("teamName"));
		member.setTeam(team);
		return member;
	}

}
