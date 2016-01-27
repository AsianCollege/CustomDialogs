package com.asmt.listngrid;


import com.asmt.listngrid.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewActivity extends Activity{
	
	private ListView listview;
	private String[] title;
	private String[] desc;
	private int[] imageResources;

	
	@Override
	public void onCreate(Bundle savedInstaneState){
		super.onCreate(savedInstaneState);
		setContentView(R.layout.activity_listview);	
		listview = (ListView)findViewById(R.id.listView);
		title = new String[]{
				"Item 1",
				"Item 2",
				"Item 3",
				"Item 4",
				"Item 5",
				"Item 6",
				"Item 7",
				"Item 8",
				"Item 9",
				"Item 10",
				"Item 11",
				"Item 12"
		};
		imageResources = new int[]{
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher,
				R.drawable.ic_launcher
		};
		
		desc = new String[]{
				"Desc 1",
				"Desc 2",
				"Desc 3",
				"Desc 4",
				"Desc 5",
				"Desc 6",
				"Desc 7",
				"Desc 8",
				"Desc 9",
				"Desc 10",
				"Desc 11",
				"Desc 12"	
		};
		
		
		CustomAdapter adapter = new CustomAdapter(this,
                R.layout.list_data,title,imageResources,desc);		
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adv, View view, int position,
					long arg3) {
				// TODO Auto-generated method stub
				showToast("Item "+position+" is clicked");
			}
		});		
	}
	public void showToast(String msg){
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}  
	
}
