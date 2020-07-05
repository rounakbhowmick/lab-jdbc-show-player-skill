package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.SkillDAO;
import model.Skill;

public class Main {
	public static void main(String[] args)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter skill Id");
//		long skillId = Long.parseLong(br.readLine());
//		System.out.println("Enter skill name");
//		String skillName = br.readLine();
//		Skill skill = new Skill(skillId, skillName);
		SkillDAO skilldao = new SkillDAO();
//		skilldao.insertdetails(skill);
		List<Skill> list = skilldao.listAllSkills();
		for (Skill a : list) {
			System.out.println(a.getSkillId() + "\t" + a.getSkillName());
		}
	}
}
