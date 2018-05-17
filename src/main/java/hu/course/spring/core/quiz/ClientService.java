package hu.course.spring.core.quiz;

public class ClientService implements Service {

	private AuthBean authBean;

	public ClientService(AuthBean authBean) {
		this.authBean = authBean;
		System.out.println("ClientService created");
	}

	@Override
	public String greeting() {
		return "Client greeting";
	}

	public AuthBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

}
