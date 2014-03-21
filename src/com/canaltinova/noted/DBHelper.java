package com.canaltinova.noted;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME   = "notedDB"; 

    private static final String TABLE_NOTES = "notes";
	  
	public DBHelper(Context context) {
		    super(context, DATABASE_NAME, null, 1);
		   }

	@Override
	public void onCreate(SQLiteDatabase db) {
		//creates a database for notes
		String sql = "CREATE TABLE " + TABLE_NOTES + "(id INTEGER PRIMARY KEY AUTOINCREMENT ,title TEXT, content TEXT, date TEXT,color INTEGER" + ")";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//simple upgrade method. Just drops table if note table exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
	      onCreate(db);
	}
	  
	public void insertNote(Note note){
		//we are getting a writable database sample.
		SQLiteDatabase db = this.getWritableDatabase();
		
		//adding some values and we are going to insert them to our table.
		ContentValues values  = new ContentValues();
		values.put("title", note.getTitle());
		values.put("content", note.getContent());
		values.put("date",note.getDate());
		values.put("color",note.getColor());
		
		db.insert(TABLE_NOTES, null, values);
		db.close();
	}
	
	public List<Note> getAllNotes(){
		
		 List<Note> notes = new ArrayList<Note>();
		 SQLiteDatabase db = this.getWritableDatabase();
		 
		 String sqlQuery = "SELECT  * FROM " + TABLE_NOTES;//gets every notes
	     Cursor cursor = db.rawQuery(sqlQuery, null);
		 
		 //Cursor cursor = db.query(TABLE_NOTES, new String[] {"id","title","content","date","color"}, null, null, null, null, null);
		 
		 //while cursor have an item...
		 while(cursor.moveToNext()){
			 Note note = new Note();
			 
			 note.setId(cursor.getInt(0));
			 note.setTitle(cursor.getString(1));
			 note.setContent(cursor.getString(2));
			 note.setDate(cursor.getString(3));
			 note.setColor(cursor.getInt(4));
			 
			 notes.add(note);
			 
		 }
		 if(cursor != null)
			 cursor.close();
		 db.close();
		 
		 return notes;
	}
	
	public Note getNote(int position){
		
		Note note = new Note();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NOTES +" WHERE id = " + (position+1), null);
		
		if(cursor.moveToFirst()){
			note.setId(cursor.getInt(0));
			note.setTitle(cursor.getString(1));
			note.setContent(cursor.getString(2));
			note.setDate(cursor.getString(3));
			note.setColor(cursor.getInt(4));
			
			db.close();
			cursor.close();
			return note;
		}
		else{
			db.close();
			return null;
		}
	}
}
