package com.spring.web.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.web.beans.Answers;
import com.spring.web.beans.QuestionForms;
import com.spring.web.beans.Quiz;
import com.spring.web.beans.Quiz1;
import com.spring.web.beans.Registration;

@Repository
@Qualifier("UserService")
//@Service("")
public class UserServiceImpl implements UserService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		System.out.print(jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}

	//inserting users data
	public int save(Registration register) {

		System.out.println(register.getEmail() + " deekshith " + register.getName());
		String sql = "insert into users(name,email,organization,password,username) " + "values('" + register.getName()
				+ "','" + register.getEmail() + "','" + register.getOrganization() + "','" + register.getPassword()
				+ "','" + register.getUsername() + "')";

		int k = jdbcTemplate.update(sql);

		return k;

	}

	//retrieving users data
	public List<Registration> getUsers() {
		String q = "select * from users";

		return jdbcTemplate.query(q, new RowMapper<Registration>() {
			public Registration mapRow(ResultSet rs, int row) throws SQLException {
				Registration emp1 = new Registration();

				emp1.setName(rs.getString(1));
				emp1.setEmail(rs.getString(2));
				emp1.setOrganization(rs.getString(3));
				emp1.setPassword(rs.getString(4));
				emp1.setUsername(rs.getString(5));
				return emp1;

			}
		});
	}
	
	//retrieving user data based on username

	public Registration find(String username,String password) {
		   
	    String q="SELECT * FROM users where username = ? and password=? ";
	    Registration person = (Registration) jdbcTemplate.queryForObject(q,new Object[] { username ,password}, new BeanPropertyRowMapper(Registration.class));

	    return person;
	}

	//inserting quiz data to db and into views at a time
	public void save(Quiz1 q1) {

		// System.out.println(user.getId()+" vardhini "+user.getName());
		String sql = "insert into quiz(quiz_name, description,questions,user_id, inactive,subject) " + "values('"
				+ q1.getQuizName() + "','" + q1.getQuizDesc() + "'," + q1.getQuestionforms().length + ","
				+ q1.getUserId() + ",'" + q1.isIsActive() + "','" + q1.getQuizSubject() + "')";
		jdbcTemplate.update(sql);

		QuestionForms[] qf = q1.getQuestionforms();

		System.out.println(q1.getQuestionforms().length);
		String qname = q1.getQuizName();
		int qflen = q1.getQuestionforms().length;

		for (int i = 0; i < qflen; i++) {
			String sql1 = "insert into vw_quiz_questions " + "values('" + qf[i].getQuestion() + "','"
					+ qf[i].getAnswertype() + "','" + qname + "')";
			jdbcTemplate.update(sql1);

			String que = qf[i].getQuestion();
			Answers[] ans = qf[i].getAnswers();
			int anslen = ans.length;
			for (int j = 0; j < anslen; j++) {
				String sql2 = "insert into vw_answer_question_quiz " + "values('" + qname + "','" + que + "','"
						+ ans[j].getAnsText() + "','" + ans[j].isIscorrect() + "')";
				jdbcTemplate.update(sql2);
			}

		}

	}

//	public List<Quiz1> getQuiz() {
//		String q = "select * from quiz";
//
//		return jdbcTemplate.query(q, new RowMapper<Quiz1>() {
//			public Quiz1 mapRow(ResultSet rs, int row) throws SQLException {
//				Quiz1 q1 = new Quiz1();
//
//				q1.setQuizName(rs.getString(1));
//				q1.setQuizDesc(rs.getString(2));
//				q1.setQuizSubject(rs.getString(3));
//				// q1.setQuestionforms(rs.);
//				// q1.setIsActive(false);
//				return q1;
//
//			}
//		});
//	}

//public  List<Quiz> getQuiz() {
//	String q="select * from users";
//	
//    return jdbcTemplate.query(q,new RowMapper<User>() {
//    	public User mapRow(ResultSet rs,int row) throws SQLException{
//    		User emp = new User();
//    		emp.setId(rs.getInt(1));
//    		emp.setName(rs.getString(2));
//    		emp.setEmail(rs.getString(3));
//    		return emp;
//
//}
//    });
//}

//public User find(int personId) {
//	
//	String q="SELECT * FROM users where id = ? ";
//    User person = (User) jdbcTemplate.queryForObject(q,new Object[] { personId }, new BeanPropertyRowMapper(User.class));
//
//    return person;
//}

}