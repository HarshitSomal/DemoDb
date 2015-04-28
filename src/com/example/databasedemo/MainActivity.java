package com.example.databasedemo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.os.Build;

public class MainActivity extends TabActivity {

	TabHost host;
	TabSpec register;
	TabSpec update;
	TabSpec view;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		host = getTabHost();
		
		
		// CREATE NEW TAB
		
		register = host.newTabSpec("Register");
		Intent i1 = new Intent(MainActivity.this,Register.class);
		register.setContent(i1);
		register.setIndicator("Add User");
		host.addTab(register);		
		
		
		update = host.newTabSpec("Update");
		Intent i2 = new Intent(MainActivity.this,Update.class);
		update.setContent(i2);
		update.setIndicator("Update");
		host.addTab(update);
		
		view = host.newTabSpec("View");
		Intent i3 = new Intent(MainActivity.this,Display.class);
		view.setContent(i3);
		view.setIndicator("View");
		host.addTab(view);
		
		
		
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
	
}
