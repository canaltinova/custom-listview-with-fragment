package com.canaltinova.noted;

import java.util.List;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

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
	
	public void getList(){
		final ListView customListView = (ListView) findViewById(R.id.noteList);
		
		DBHelper dbHelper = new DBHelper(getApplicationContext());
		
		SharedPreferences settings = getSharedPreferences("SQL", 0);
		boolean firstTime = settings.getBoolean("firstTime", true);//looks for a boolen called firstTime. You can understand its name why we get it.
		
		//insets notes if it is first run in that device.
		if (firstTime) {
	         dbHelper.insertNote(new Note("Welcome to noted!", "This is a content!","23/02/2014",0));
	         dbHelper.insertNote(new Note("Title", "Content!","23.09.1995",1));
	         dbHelper.insertNote(new Note("Welcome to noted!", "This is a content!","23/02/2014",3));
	         dbHelper.insertNote(new Note("Title", "Content!","23.09.1995",4));
	         dbHelper.insertNote(new Note("Welcome to noted!", "This is a content!","23/02/2014",0));
	         dbHelper.insertNote(new Note("Title", "Content!","23.09.1995",3));
	         dbHelper.insertNote(new Note("Welcome to noted!", "This is a content!","23/02/2014",4));
	         dbHelper.insertNote(new Note("Baþlýk", "Content!","23/02/2014",2));
	         SharedPreferences.Editor editor = settings.edit();
	         editor.putBoolean("firstTime", false);
	         editor.commit();
	      }
		
 		  List<Note> notes = dbHelper.getAllNotes();//gets all notes and adds to a list for the listview
	      NoteListAdapter noteListAdapter = new NoteListAdapter(MainActivity.this, notes);//creating a new custom list adapter. so you can find it in NoteListAdapter.java
	      customListView.setAdapter(noteListAdapter);//sets custom adapter to the listview
	      
	      customListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),"You just clicked the item with position " + position,Toast.LENGTH_LONG).show();
			}
		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
			
			getList();//calls getlist in this method because of fragments.
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
