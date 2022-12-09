package dao;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

//import org.omnifaces.util.Utils;

import beans.Cars;
import util.CarsUtils;
import util.DataConnect;

@ManagedBean(name="carsDao")
@RequestScoped
public class CarsDAO implements Serializable{
	
	private int cid;
	private String brand;
	private String model;
	private String cyear;
	private String cdescription;
	private String color;
	private Map<String,String> colorList;
	private double gasPower;
	private double price;
	private byte[] pic;
	private UploadedFile file;
	private static final long serialVersionUID = 1L;
	private static List<Cars> listCars;
	
	public int getCid() {
		return this.cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getBrand() {
		return this.brand == null ? "" : this.brand.toString();
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return this.model == null ? "" : this.model.toString();
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getCyear() {
		return this.cyear == null ? "" : this.cyear.toString();
	}
	
	public void setCyear(String cyear) {
		this.cyear = cyear;
	}
	
	public String getCdescription() {
		return this.cdescription == null ? "" : this.cdescription.toString();
	}
	
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	
	public String getColor() {
		return this.color == null ? "" : this.color.toString();
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Map<String,String> getColorList() {
		this.colorList = new HashMap<>();
        colorList.put("Red", "Red");
        colorList.put("Blue", "Blue");
        colorList.put("Yellow", "Yellow");
        colorList.put("Green", "Green");
        colorList.put("Pick", "Pick");
        colorList.put("Orange", "Orange");
        colorList.put("Brown", "Brown");
        colorList.put("White", "White");
        colorList.put("Black", "Black");
		return this.colorList;
	}
	
	public void setColorList(Map<String,String> colorList) {
		this.colorList = colorList;
	}
	
	
	public double getGasPower() {
		return this.gasPower;
	}
	
	public void setGasPower(double gasPower) {
		this.gasPower = gasPower;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public byte[] getPic() {
		return this.pic;
	}
	
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public UploadedFile getFile() {
		return this.file;
	}

	public List<Cars> getListCars() {
		return listCars;
	}
	
	public void setListCars(List<Cars> listCars) {
		this.listCars = listCars;
	}

}