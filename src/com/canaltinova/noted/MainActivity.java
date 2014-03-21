package com.canaltinova.noted;

import java.util.List;

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	}
	
	public void listeCek(){
		final ListView customListView = (ListView) findViewById(R.id.noteList);
		
		DBHelper dbHelper = new DBHelper(getApplicationContext());
		
		SharedPreferences settings = getSharedPreferences("SQL", 0);
		boolean firstTime = settings.getBoolean("firstTime", true);
		
		if (firstTime) {
	         dbHelper.insertNote(new Note("Welcome to noted!", "Welcome to noted and enjoy yourself!","23.02.1995",0));
	         dbHelper.insertNote(new Note("Baþlýk", "Ýçerik!","23.09.1995",1));
	         dbHelper.insertNote(new Note("Welcome to noted!", "Welcome to noted and enjoy yourself!","23.02.1995",3));
	         dbHelper.insertNote(new Note("Baþlýk", "Ýçerik!","23.09.1995",4));
	         dbHelper.insertNote(new Note("Welcome to noted!", "Welcome to noted and enjoy yourself!","23.02.1995",0));
	         dbHelper.insertNote(new Note("Baþlýk", "Ýçerik!","23.09.1995",3));
	         dbHelper.insertNote(new Note("Welcome to noted!", "Welcome to noted and enjoy yourself!","23.02.1995",4));
	         dbHelper.insertNote(new Note("Baþlýk", "Ýçerik!","23.09.1995",2));
	         dbHelper.insertNote(new Note("Çok uzun bir baþlýk yazýldýðýnda ne oluyor onu çok merak ettim gerçekten", "Neden olmuyorsun akadaþým?!","23.08.1995",2));
	         SharedPreferences.Editor editor = settings.edit();
	         editor.putBoolean("firstTime", false);
	         editor.commit();
	      }
		List<Note> notes = dbHelper.getAllNotes();
	      NoteListAdapter noteListAdapter = new NoteListAdapter(MainActivity.this, notes);
	      customListView.setAdapter(noteListAdapter);
	      
	      customListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//TODO: add toast.
			}
		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	@SuppressLint("ValidFragment")
	public class PlaceholderFragment extends Fragment {

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
			listeCek();
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
