package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import dao.UserDAO;
import util.UserUtils;

@ManagedBean(name="userBean")
@FacesValidator("userValidator")
public class User implements Validator {
	
	private UserDAO model;
	private UserUtils _util;

	public User() {
		model = new UserDAO();
		_util = new UserUtils();
	}
	
	public UserDAO getModel() {
		return this.model;
	}
	
	public void setModel(UserDAO model) {
		this.model = model;
	}
	
	public String newUser() {
		return _util.createUser(this.model);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String req= " is required field";
		FacesMessage msg;

		if(this.model.getUsername().isBlank() || this.model.getUsername().isEmpty()) {
			 msg = new FacesMessage(
					  "Username"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}
		
		if(this.model.getPwd().isBlank() || this.model.getPwd().isEmpty()) {
			 msg = new FacesMessage(
					  "Password"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}
	}
	
}
