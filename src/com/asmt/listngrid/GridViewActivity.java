package com.asmt.listngrid;

import com.asmt.listngrid.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends Activity {

	private String[] title;
	private int[] imageResources;
	private String[] desc;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		GridView gv = (GridView)findViewById(R.id.gridView);
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
                R.layout.grid_data,title,imageResources,desc);
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(new OnItemClickListener() {

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
