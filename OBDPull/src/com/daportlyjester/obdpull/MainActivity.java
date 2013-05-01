package com.daportlyjester.obdpull;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.support.v7.widget.*;

public class MainActivity extends Activity {
	
	protected Dialog splashDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		showSplashScreen();
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected void removeSplashScreen() {
		if(splashDialog != null) {
			splashDialog.dismiss();
			splashDialog = null;
		}
	}
	
	protected void showSplashScreen(){
		
		splashDialog = new Dialog(this,R.style.SplashScreen);
		splashDialog.setContentView(R.layout.splash_screen);
		splashDialog.setCancelable(false);
		splashDialog.show();
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				removeSplashScreen();
				
			}
		},3000);
	}
	
	private class StateSaver {
		public boolean showSplash = false;
	}

}
