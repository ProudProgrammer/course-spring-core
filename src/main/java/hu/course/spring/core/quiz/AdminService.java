package hu.course.spring.core.quiz;

public class AdminService implements Service {

	public AdminService() {
		System.out.println("AdminService created");
	}
	
	@Override
	public String greeting() {
		return "Admin";
	}

	
}
