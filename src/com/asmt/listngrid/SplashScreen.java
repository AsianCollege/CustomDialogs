package com.asmt.listngrid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class SplashScreen extends Activity {

	TextView count;
	ProgressDialog progress;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splashscreen);
		count = (TextView)findViewById(R.id.txtCountDown);	
		
		
		new CountDownTimer(4000, 40) {

		     public void onTick(long millisUntilFinished) {
		    	 count.setText(""+ (100-((int)millisUntilFinished/40)));
		    	 progress.setProgress(100-((int)millisUntilFinished/40));
		     }

		     public void onFinish() {
		    	 count.setText("");
		    	 progress.dismiss();
		     }
		  }.start();
		  
		  showProgress();
		
		Thread timerThread = new Thread(){
			public void run(){
				try {
					sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//count.setText("OK");
				Message msgObj = handler.obtainMessage();
				Bundle b = new Bundle();
				b.putString("status", "OK");
				msgObj.setData(b);
				handler.sendMessage(msgObj);
				
				
			}		
			public final Handler handler = new Handler(){
				public void handleMessage(Message ms){
					String aResponse = ms.getData().getString("status");	
					count.setText(aResponse);
					//progress.dismiss(); 
					Intent intent = new Intent(SplashScreen.this,MainActivity.class);
					startActivity(intent);
					SplashScreen.this.finish();
				}
			};
			};
			timerThread.start();
		
	}
	
	public void showProgress(){
		progress = new ProgressDialog(this);
		progress.setTitle("Progress Dialog");
		progress.setMessage("Loading");
		progress.setCancelable(false);
		progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progress.show();
	}

}
