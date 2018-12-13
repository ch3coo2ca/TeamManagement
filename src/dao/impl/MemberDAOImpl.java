package dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberDAOImpl extends SimpleJdbcTemplate implements MemberDAO {

	private InsertMember insertMember;
	private MembersQuery membersQuery;
	private DeleteMember deleteMember;
	private UpdateMember updateMember;

	public MemberDAOImpl(DataSource dataSource) {
		super(dataSource);
		insertMember = new InsertMember(dataSource);
		membersQuery = new MembersQuery(dataSource);
		deleteMember = new DeleteMember(dataSource);
		updateMember = new UpdateMember(dataSource);
	}

	@Override
	public void insertMember(MemberDTO member) throws DataAccessException {
		Object values[] = new Object[] { member.getName(), member.getTeam().getId() };
		insertMember.update(values);
	}

	@Override
	public void updateMember(MemberDTO member) throws DataAccessException {
		Object values[] = new Object[] { member.getTeam().getId(), member.getId() };

		System.out.println(member.getId() + "/" + member.getTeam().getId());
		updateMember.update(values);
	}

	@Override
	public void deleteMember(MemberDTO member) throws DataAccessException {
		deleteMember.update(member.getId());
	}

	@Override
	public MemberDTO getMember(Integer id) throws DataAccessException {
		return null;
	}

	@Override
	public List getMembers(Integer id) throws DataAccessException {
		return membersQuery.execute(id);
	}
}
