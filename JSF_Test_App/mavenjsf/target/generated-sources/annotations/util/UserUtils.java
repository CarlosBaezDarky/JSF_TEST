package util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import beans.Cars;
import beans.Login;
import dao.CarsDAO;
import dao.UserDAO;

public class UserUtils {

	private Connection con = null;
	private PreparedStatement ps = null;
	private msgUtil msg = new msgUtil();
	private Login log = new Login();
	
	//Method for insert/Create new record in table User
	public String createUser(UserDAO model){
		
		UserDAO obj = new UserDAO();
		String sql_Insert =
				"Insert into Users (uname,password) values (?,?)";
	
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(sql_Insert);
			ps.setString(1, model.getUsername());
			ps.setString(2, model.getPwd());
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				System.out.println("Success insert");
				msg.showInfo("Success", "User successfully created");
			}
			
		}catch(Exception err)
		{
			System.out.println("createUser() error insert -->" + err.getMessage());
			err.printStackTrace();
			msg.showError("Error", "CreateUser() error insert");
		}finally {
			DataConnect.close(con);
		}
		
		return log.LoginPage();
	}
	
	
}
