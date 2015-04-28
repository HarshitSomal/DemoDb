package com.example.databasedemo;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Build;

public class Update extends Activity implements OnItemSelectedListener {
	Spinner spin;
	MyDataBase database;
	ArrayList<String> names;
	String nameToDelete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		 
	//==== fetxch the controls=================
		spin = (Spinner)findViewById(R.id.spinner1);
		
	//	========= Itialize =================
		database =  new MyDataBase(this);
		
		
		// ============ HAndle The Events=-==========
		spin.setOnItemSelectedListener(this);
	}

	
	

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) 
	{
		Toast.makeText(this, position + "" , Toast.LENGTH_LONG).show();
		Toast.makeText(this, arg0.getItemAtPosition(position)+ "" , Toast.LENGTH_LONG).show();
		nameToDelete = arg0.getItemAtPosition(position).toString();
		
	}




	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
		names = database.getAllREcord();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,names);
		spin.setAdapter(adapter);
	}
	
	
	
	
	
	
	
	
	public void delete(View v)
	{
		
		int row = database.deleteRecord(nameToDelete);
		
		if(row == 0 )
		{
			Toast.makeText(this, "Sorry Unable to delete ", Toast.LENGTH_LONG).show();
			
		}
		if(row == 1)
		{
			
			Toast.makeText(this, nameToDelete + " is deleted from database" , Toast.LENGTH_LONG).show();
		}
	}
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update, menu);
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
