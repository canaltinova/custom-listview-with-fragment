package com.canaltinova.noted;

import java.io.Serializable;

public class Note implements Serializable{
	
	private static final long serialVersionUID = 1L;
	  private int id;
	  private String title;
	  private String content;
	  private String date;
	  private int color;
	  
	  public Note(){
		  super();
	  }

	  public Note(String title, String content, String date,int color){//TODO: add color
		  super();
		  this.title = title;
		  this.content = content;
		  this.date = date;
		  this.color = color;
	  }
	  
	  public String getTitle(){
		  return title;
	  }
	  
	  public void setTitle(String title)
	  {
		  this.title = title;		  
	  }
	  
	  public String getContent(){
		  return content;
	  }
	  public void setContent(String content){
		  this.content = content;
	  }
	  
	  public String getDate(){
		  /*StringBuilder newDate = new StringBuilder();
		  int dotFirst = date.indexOf(".");
		  int dotSecond = date.indexOf(".", dotFirst+1);
		  
		  newDate.append(date.substring(0,dotFirst));
		  newDate.append("\n");
		  newDate.append(getMonth(Integer.parseInt(date.substring(dotFirst+1,dotSecond))));//TODO: burada ay alma olayý tam olarak çalýþmýyor bakmak lazým
		  newDate.append("\n");
		  newDate.append(date.substring(dotSecond+1));
		  
		  //return newDate.toString();*/
		  return date;
	  }
	  public void setDate(String date){
		  this.date = date;
	  }
	  
	  public int getId(){
		  return id;
	  }
	  public void setId(int id){
		  this.id = id;
		  
	  }
	  public void setColor(int color){
		  this.color = color;
				 
	  }
	  
	  public int getColorsCode(){
		  switch (color) {
		case 0:
			return R.color.list_blue;
		case 1:
			return R.color.list_red;
		case 2:
			return R.color.list_green;
		case 3:
			return R.color.list_orange;
		case 4:
			return R.color.list_gray;
		default:
			return R.color.list_blue;
		}
	  }
	  public int getColor(){
		  return color;
	  }

	  public int getMonth(int month){
		  /*switch (month) {
		case 01:
			return R.string.january;
		case 02:
			return R.string.february;
		case 03:
			return R.string.march;
		case 04:
			return R.string.april;
		case 05:
			return R.string.may;
		case 06:
			return R.string.june;
		case 07:
			return R.string.july;
		case 8:
			return R.string.august;
		case 9:
			return R.string.september;
		case 10:
			return R.string.october;
		case 11:
			return R.string.november;
		case 12:
			return R.string.december;
		default:
			return 0;*/
		  return 0;
		}

}
