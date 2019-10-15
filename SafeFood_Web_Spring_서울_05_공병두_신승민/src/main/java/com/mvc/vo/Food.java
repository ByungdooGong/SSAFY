package com.mvc.vo;

import java.util.ArrayList;

/** ?‹?’ˆ ? •ë³? */
public class Food {
	/**?‹?’ˆ?„ êµ¬ë³„?•˜?Š” ì½”ë“œ */
	protected int code;
	/**?‹?’ˆ ?´ë¦?*/
	protected String name;
	/**?¼?šŒ ? œê³? ?Ÿ‰*/
	protected double supportpereat;
	/**?¼?šŒ ? œê³µë˜?Š” ì¹¼ë¡œê¸?*/
	protected double calory;
	/**?¼?šŒ ? œê³µë˜?Š” ?ƒ„?ˆ˜?™”ë¬?*/
	protected double carbo;
	/**?¼?šŒ ? œê³µë˜?Š” ?‹¨ë°±ì§ˆ*/
	protected double protein;
	/**?¼?šŒ ? œê³µë˜?Š” ì§?ë°?*/
	protected double fat;
	/**?¼?šŒ ? œê³µë˜?Š” ?‹¹ë¥?*/
	protected double sugar;
	/**?¼?šŒ ? œê³µë˜?Š” ?‚˜?Š¸ë¥?*/
	protected double natrium;
	/**?¼?šŒ ? œê³µë˜?Š” ì½œë ˆ?Š¤?…Œë¡?*/
	protected double chole;
	/**?¼?šŒ ? œê³µë˜?Š” ?¬?™”ì§?ë°©ì‚°*/
	protected double fattyacid;
	/**?¼?šŒ ? œê³µë˜?Š” ?Š¸? Œ?Š¤ì§?ë°?*/
	protected double transfat;
	/**? œì¡°ì‚¬*/
	protected String maker;
	/**?›ë£?*/
	protected String material;
	/**?´ë¯¸ì? ê²½ë¡œ*/
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
