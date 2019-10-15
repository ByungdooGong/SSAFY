package com.mvc.vo;

import java.util.ArrayList;

/** ?��?�� ?���? */
public class Food {
	/**?��?��?�� 구별?��?�� 코드 */
	protected int code;
	/**?��?�� ?���?*/
	protected String name;
	/**?��?�� ?���? ?��*/
	protected double supportpereat;
	/**?��?�� ?��공되?�� 칼로�?*/
	protected double calory;
	/**?��?�� ?��공되?�� ?��?��?���?*/
	protected double carbo;
	/**?��?�� ?��공되?�� ?��백질*/
	protected double protein;
	/**?��?�� ?��공되?�� �?�?*/
	protected double fat;
	/**?��?�� ?��공되?�� ?���?*/
	protected double sugar;
	/**?��?�� ?��공되?�� ?��?���?*/
	protected double natrium;
	/**?��?�� ?��공되?�� 콜레?��?���?*/
	protected double chole;
	/**?��?�� ?��공되?�� ?��?���?방산*/
	protected double fattyacid;
	/**?��?�� ?��공되?�� ?��?��?���?�?*/
	protected double transfat;
	/**?��조사*/
	protected String maker;
	/**?���?*/
	protected String material;
	/**?��미�? 경로*/
	protected String img;
	protected String allergy;
	public Food() {
	}
	public Food(int code) {
		super();
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSupportpereat() {
		return supportpereat;
	}
	public void setSupportpereat(double supportpereat) {
		this.supportpereat = supportpereat;
	}
	public double getCalory() {
		return calory;
	}
	public void setCalory(double calory) {
		this.calory = calory;
	}
	public double getCarbo() {
		return carbo;
	}
	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getChole() {
		return chole;
	}
	public void setChole(double chole) {
		this.chole = chole;
	}
	public double getFattyacid() {
		return fattyacid;
	}
	public void setFattyacid(double fattyacid) {
		this.fattyacid = fattyacid;
	}
	public double getTransfat() {
		return transfat;
	}
	public void setTransfat(double transfat) {
		this.transfat = transfat;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	@Override
	public String toString() {
		return "Food [code=" + code + ", name=" + name + ", supportpereat=" + supportpereat + ", calory=" + calory
				+ ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat + ", sugar=" + sugar + ", natrium="
				+ natrium + ", chole=" + chole + ", fattyacid=" + fattyacid + ", transfat=" + transfat + ", maker="
				+ maker + ", material=" + material + ", img=" + img + "]";
	}
	
}
