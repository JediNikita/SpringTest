package controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import Model.Student;
import service.StudentMapper;

public class StudentJDBCTemplate {

		private DataSource dataSource;
		private JdbcTemplate jdbcTemplateObject;
		
		public void setDataSource(DataSource dataSource) {
			this.dataSource=dataSource;
			this.jdbcTemplateObject= new JdbcTemplate(dataSource);
		
		}
		
		public void create(String name, int age) {
			String sql= "insert into Student (name, age) values (?,?); ";
			jdbcTemplateObject.update(sql, name, age);
			System.out.println("created record name=" +name +" age= "+age);
			return;
		}
		
		public Student getStudent(int id) {
			String sql="select * from Student where id = ?;";
			Student student= jdbcTemplateObject.queryForObject(sql, new Object[] {1}, new StudentMapper());
			return student;
		}
		
		public List<Student> listStudents() {
		      String SQL = "select * from Student";
		      List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		      return students;
		}
		
		public void delete(Integer id) {
		      String SQL = "delete from Student where id = ?";
		      jdbcTemplateObject.update(SQL, id);
		      System.out.println("Deleted Record with ID = " + id );
		      return;
		}
		
		public void update(Integer id, Integer age){
		      String SQL = "update Student set age = ? where id = ?";
		      jdbcTemplateObject.update(SQL, age, id);
		      System.out.println("Updated Record with ID = " + id );
		      return;
		}
}
