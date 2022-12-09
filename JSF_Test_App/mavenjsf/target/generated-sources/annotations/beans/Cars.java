package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import dao.CarsDAO;
import util.CarsUtils;
import util.DataConnect;

@ManagedBean(name="carsBean")
@SessionScoped
@FacesValidator("carsValidator")
public class Cars implements Validator {
	
	private List<CarsDAO> cars;
	private CarsDAO singleCars;
	private static CarsUtils carsUtils;
	private static boolean isEdit = false;
	
	public Cars() {
		cars = new ArrayList<CarsDAO>();
		carsUtils = new CarsUtils();
		singleCars = new CarsDAO();
	}
	
	public List<CarsDAO> getCars(){
		return carsUtils.getCarsList();
	}
	
	public CarsDAO getSingleCars() {
		return singleCars;
	}
	
	public void setSingleCars(CarsDAO singleCars) {
		this.singleCars = singleCars;
	}
	
	public boolean getIsEdit() {
		return this.isEdit;
	}
	
	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	public void loadCars() {
		cars.clear();
		try {
			cars = carsUtils.getCarsList();
		}catch (Exception ex) {
			addErrorMessage (ex);
		}
	}
	
	public List<CarsDAO> loadCarsFunction(){
		return carsUtils.getCarsList();
	}
	
	private void addErrorMessage(Exception ex) {
		FacesMessage message = new FacesMessage(ex.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String newCar() {
		return carsUtils.createCars(singleCars, this.isEdit);
	}
	
	public String editCar() {
		Login _login = new Login();
		this.isEdit = true;
	 	CarsDAO singleCars = carsUtils.findCarById(this.singleCars.getCid());
	 	this.singleCars = singleCars;
		return _login.formPage();
	}
	
	public String addCar() {
		Login _login = new Login();
		this.isEdit = false;
	 	this.singleCars = new CarsDAO();
		return _login.formPage();
	}
	
	@Override
	public void validate(FacesContext fc, UIComponent uic, Object obj)
			throws ValidatorException {
		
		String req= " is required field";
		FacesMessage msg;
		Double gasPower = this.singleCars.getGasPower();
		Double price = this.singleCars.getPrice();
		
		if(this.singleCars.getBrand().isBlank() || this.singleCars.getBrand().isEmpty()) {
			 msg = new FacesMessage(
					  "Brand"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}
		
		if(this.singleCars.getModel().isBlank() || this.singleCars.getModel().isEmpty()) {
			 msg = new FacesMessage(
					  "Model"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}
		
		if(this.singleCars.getCyear().isBlank() || this.singleCars.getCyear().isEmpty()) {
			 msg = new FacesMessage(
					  "Date"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}

		if(this.singleCars.getColor().isBlank() || this.singleCars.getColor().isEmpty()) {
			 msg = new FacesMessage(
					  "Color"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}

		if(price < 1 || price.toString().isBlank() || price.toString().isEmpty()) {
			 msg = new FacesMessage(
					  "Price"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}

		if(gasPower.toString().isBlank() || gasPower.toString().isEmpty()) {
			 msg = new FacesMessage(
					  "Gas Power"+req
					);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg);
		}
		
	}
}
