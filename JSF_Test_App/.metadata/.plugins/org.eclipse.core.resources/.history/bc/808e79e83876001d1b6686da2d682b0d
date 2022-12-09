package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.CarsDAO;
import dao.LoginDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;
	
	public String getPwd() {
		return pwd;
	}
	
	public String getMsg(){
		return msg;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//validate login
	
	public String validateUsernamePassword() {
		Cars _cars = new Cars();
		boolean valid = LoginDAO.validate(user, pwd);
		
		if(valid) {
			HttpSession session = (HttpSession) SessionUtils.getSession();
			session.setAttribute("username", user);
			return "carsListPage";
		}else {
			FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
									"Incorrect Username and Password",
									"Please enter correct username and Password"));
			return "login";
		}
	}
	
	//logout event invalidate session
	public String logout() {
			HttpSession session = (HttpSession) SessionUtils.getSession();
			session.invalidate();
			return "login";
	}
	
	//Form page navigation
	public String formPage() {
			HttpSession session = (HttpSession) SessionUtils.getSession();
			return "carForm";
	}
	
	//carsList page navigation
	public String carListPage() {
			HttpSession session = (HttpSession) SessionUtils.getSession();
			return "carsListPage";
	}
	
	public String registerPage() {
		return "registerPage";
	}
	
	public String LoginPage() {
		return "login";
	}

}
