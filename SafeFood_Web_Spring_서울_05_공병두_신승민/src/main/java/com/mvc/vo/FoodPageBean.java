package com.mvc.vo;

import java.io.Serializable;
/** ?‹?’ˆ ?‚´?—­ ?˜?´ì§? ? •ë³´ë?? ?‘œ?•˜?Š” ?´?˜?Š¤ */
public class FoodPageBean implements Serializable {
	/**?ƒ?’ˆ?„ ì¡°íšŒ ì¡°ê±´ */
	private String 	key;
	/**?ƒ?’ˆ?„ ì¡°íšŒ?•  ?‹¨?–´*/
	private String 	word;
	/**?›¹ ?˜?´ì§? ë§í¬*/
	private String 	pagelink;
	/**ì¡°íšŒ?•  ?˜?´ì§? ë²ˆí˜¸*/
	private int 	pageNo;
	/**?•œ ?˜?´ì§??— ?‘œ?‹œ?•  ?°?´?? ?ˆ˜*/
	private int 	interval = 5;
	/**?•œ ?˜?´ì§??— ?‘œ?‹œ?•  ?‹œ?‘ ë²ˆí˜¸*/
	private int 	start=1;
	/**?•œ ?˜?´ì§??— ?‘œ?‹œ?•  ? ë²ˆí˜¸ */
	private int 	end=interval;
	public FoodPageBean(){
		setKey("all");
		setWord("");
		setPagelink("1");
		setPageNo(1);
	}
	public FoodPageBean(String key, String word, String pagelink, int pageNo) {
		setKey(key);
		setWord(word);
		setPagelink(pagelink);
		setPageNo(pageNo);
	}
	public FoodPageBean(String key, String word, String pagelink, String pageNo) {
		setKey(key);
		setWord(word);
		setPagelink(pagelink);
		setPageNo(pageNo);
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		if(key==null) this.key="all";
		else this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		if(word==null) this.word = "";
		else this.word = word;
	}
	public String getPagelink() {
		return pagelink;
	}
	public void setPagelink(String pagelink) {
		this.pagelink = pagelink;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo>0)this.pageNo = pageNo;
		else this.pageNo=1;
	}
	public void setPageNo(String pageNo) {
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}
	public String getKey(String k){
		if(k!=null && key.equals(k)) return "selected='selected'";
		else return "";
	}
	
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getStart() {
		if(pageNo>1){
			return start =  (pageNo -1) * interval + 1;
		}else{
			return   1;
		}
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
			return start+interval - 1;
	}
	public void setEnd(int end) {
		this.end =end;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [key=").append(key).append(", word=")
				.append(word).append(", pagelink=").append(pagelink)
				.append(", pageNo=").append(pageNo).append(", interval=")
				.append(interval).append(", start=").append(start)
				.append(", end=").append(end).append("]");
		return builder.toString();
	}
	
}











