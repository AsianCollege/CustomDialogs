package com.asmt.listngrid;
import com.asmt.listngrid.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnListView = (Button)findViewById(R.id.btnListView);
		Button btnCustomDialog = (Button)findViewById(R.id.btnCustomDialog);
		Button btnAlertDialog = (Button)findViewById(R.id.btnAlertDialog);
		Button btnCustomToast = (Button)findViewById(R.id.btnCustomToast);
		
		btnListView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub	
				Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
				startActivity(intent);
			}
		});
		Button btnGridView = (Button)findViewById(R.id.btnGridView);
		btnGridView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,GridViewActivity.class);
				startActivity(intent);
			}
		});		
		btnAlertDialog.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog();
			}
			
		});
		btnCustomDialog.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showCustomDialog();
			}
			
		});
		btnCustomToast.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showCustomToast("This is custom Toast");
			}
		});
	}
	
	public void showDialog(){
		AlertDialog.Builder dial= new AlertDialog.Builder(this);
		dial.setTitle("My Dialog");
		dial.setMessage("My Message");
		dial.setIcon(R.drawable.ic_launcher);
		dial.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
				startActivity(intent);
			}
		});
		dial.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		dial.show();
	}
	public void showCustomDialog(){
		dialog = new Dialog(this);
		dialog.setContentView(R.layout.custom_dialog);	
		dialog.setTitle("Custom Dialog");
		
		// set the custom dialog components - text, image and button
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("This is Custom Dialog Message");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.ic_launcher);
		Button btnOk = (Button)dialog.findViewById(R.id.dialogButtonOK);
		btnOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				dialog.dismiss();
			}
		});
		dialog.show();
	}
	
	public void showCustomToast(String msg){
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.custom_toast,
		                               (ViewGroup) findViewById(R.id.toast_layout_root));
		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText("This is a custom toast");
		Toast custom = new Toast(this);
		custom.setGravity(Gravity.CENTER_VERTICAL, 0, 200);
		custom.setView(layout);
		custom.show();
		
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
	
}
