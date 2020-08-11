import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Student;
import controller.StudentJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Beans.xml");
		
		StudentJDBCTemplate studentJDBCTemplate=
				(StudentJDBCTemplate) applicationContext.getBean("studentJDBCTemplate");
		
		System.out.println("Record Creation");
		studentJDBCTemplate.create("zara", 11);
		studentJDBCTemplate.create("Shanaya", 10);
		studentJDBCTemplate.create("Ajay", 12);
		
		System.out.println("listing multiple records");
		List<Student> students= studentJDBCTemplate.listStudents();
		
		for(Student record:students) {
			System.out.println("ID: "+ record.getId());
			System.out.println("Age: "+record.getAge());
			System.out.println("Name: "+ record.getName());
			System.out.println("/n");
		}
		
	}

}
