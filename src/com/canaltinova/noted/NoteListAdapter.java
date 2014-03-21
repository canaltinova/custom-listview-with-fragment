package com.canaltinova.noted;

import java.util.List;

import com.canaltinova.noted.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteListAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private List<Note> noteList;
	
	public NoteListAdapter(Activity activity,List<Note> notes){
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		noteList = notes;
				
	}

	@Override
	public int getCount() {
		 return noteList.size();
	}

	@Override
	public Object getItem(int position) {
		return noteList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		
		if(convertView == null)
			  vi = inflater.inflate(R.layout.raw_layout, null); // create layout from raw_layout
		
		
		Note note = noteList.get(position);//getting note with position
				
		TextView tvTitle = (TextView) vi.findViewById(R.id.rowTitle); // row title

		tvTitle.setTextColor(vi.getResources().getColor(note.getColorsCode()));
		tvTitle.setText(note.getTitle());
		
		TextView tvDate = (TextView) vi.findViewById(R.id.rowDate); // row date
		tvDate.setText(note.getDate());

		
		LinearLayout coloredLayout = (LinearLayout) vi.findViewById(R.id.layoutColor);
		coloredLayout.setBackgroundResource(note.getColorsCode());
		
		 
		
		//TODO: oluþturacaðým bir listview item ý için layout a yukarýdaki örnek gibi database den veriler çekicem.
	      return vi;
	}
}
