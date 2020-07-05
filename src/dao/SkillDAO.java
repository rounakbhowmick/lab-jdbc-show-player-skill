package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {
	List<Skill> skillList = new ArrayList<Skill>();

	public List<Skill> listAllSkills() throws ClassNotFoundException, SQLException {
		String sql = "select * from SKILLS ORDER BY SKILLNAME ASC";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			long id = rs.getLong(1);
			String name = rs.getString(2);
			Skill skill = new Skill(id, name);
			skillList.add(skill);
		}
		return skillList;
	}

	public void insertdetails(Skill skill) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getConnection()
				.prepareStatement("INSERT INTO SKILLs(ID, SKILLNAME) VALUES (?,?)");
		ps.setLong(1, skill.getSkillId());
		ps.setString(2, skill.getSkillName());
		ps.executeUpdate();
		System.out.println("Successfully Inseted!!!");
	}
}
