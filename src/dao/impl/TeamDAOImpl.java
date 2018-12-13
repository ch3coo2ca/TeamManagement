package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.TeamDAO;
import dto.TeamDTO;

public class TeamDAOImpl extends SimpleJdbcTemplate implements TeamDAO {

	public TeamDAOImpl(DataSource dataSource) {
		super(dataSource);
	}

	protected class TeamRowMapper implements RowMapper<TeamDTO> {

		// arg1 : 실행된 결과를 몇번 반복할지
		//
		@Override
		public TeamDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
			TeamDTO team = new TeamDTO();
			// 멤버필드 값 매칭
			team.setId(arg0.getInt("team_id"));
			team.setName(arg0.getString("name"));

			return team;
		}
	}

	@Override
	public TeamDTO getTeam(Integer id) throws DataAccessException {
		String sql = "select * from team where team_id=?";
		TeamRowMapper rowMapper = new TeamRowMapper();

		// Object [] values = new Object[] {id};
		// 배열값 하나일땐 매개변수에 id라고 직접 적어줘도 됨
		TeamDTO team = super.queryForObject(sql, rowMapper, id); // 객체를 받을때
		return team;
	}

	@Override
	public List getTeamList() throws DataAccessException {
		String sql = "select * from team";
		TeamRowMapper rowMapper = new TeamRowMapper();
		List<TeamDTO> teamList = super.query(sql, rowMapper); // 리스트를 받을때
		return teamList;
	}

}