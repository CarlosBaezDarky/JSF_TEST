package dao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="userDao")
@RequestScoped
public class UserDAO implements Serializable {
	
	private String username;
	private String pwd;
	private static final long serialVersionUID = 1L;
	
	public String getUsername() {
		return this.username == null ? "" : this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd == null ? "" : this.pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
