package com.canaltinova.noted;

import java.io.Serializable;

import android.R;

public class Note implements Serializable{
	
	//This is a simple note class.
	private static final long serialVersionUID = 1L;
	  private int id;
	  private String title;
	  private String content;
	  private String date;
	  private int color;
	  
	  public Note(){
		  super();
	  }

	  //note initialize method.
	  public Note(String title, String content, String date,int color){
		  super();
		  this.title = title;
		  this.content = content;
		  this.date = date;
		  this.color = color;
	  }
	  
	  //sets and gets note's id, title, contenti date and color
	  
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
	  
	  //sometime we need the code real code of color. This is for it.
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

}
