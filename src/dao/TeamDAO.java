package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import dto.TeamDTO;

public interface TeamDAO {
	TeamDTO getTeam(Integer id) throws DataAccessException;

	List getTeamList() throws DataAccessException;

}
