package com.example.databasedemo;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class Register extends Activity {
	
	Button update;
	TextView username,pwd,repwd,contact,email,address;
	MyDataBase database;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		//====== Fetch controls================
		
		update = (Button)findViewById(R.id.update);
		username = (TextView)findViewById(R.id.username);
		pwd = (TextView)findViewById(R.id.pwd);
		repwd = (TextView)findViewById(R.id.repwd);
		contact = (TextView)findViewById(R.id.cntct);
		email = (TextView)findViewById(R.id.email);
		address = (TextView)findViewById(R.id.add);
		
		// ============= Intilize the variables =================
		database = new MyDataBase(this);
		database.getWritableDatabase();
		
	}

	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
		update.setEnabled(false);
		
	}

	public void register(View v)
	{
		User u = new User();
		u.setName(username.getText().toString());
		u.setPwd(pwd.getText().toString());
		u.setRepwd(repwd.getText().toString());
		u.setCntct(contact.getText().toString());
		u.setEmail(email.getText().toString());
		u.setAddress(address.getText().toString());
		
		
		
		
		if(u.getPwd().equals(u.getRepwd()))
		{
			database.insertRecord(u);
		}
		else
		{
			Toast.makeText(this, "Pwd and Re pwd Missmatch", Toast.LENGTH_LONG).show();
			
		}
		username.setText("");
		pwd.setText("");
		repwd.setText("");
		email.setText("");
		contact.setText("");
		address.setText("");
		
	}
	
	
	public void update(View v)
	{
		User u = new User();
		
		u.setPwd(pwd.getText().toString());
		u.setRepwd(repwd.getText().toString());
		u.setCntct(contact.getText().toString());
		u.setEmail(email.getText().toString());
		u.setAddress(address.getText().toString());
		
		database.updateRecord(u);
		
		username.setText("");
		pwd.setText("");
	    email.setText("");
		contact.setText("");
		address.setText("");
	}
	
	
	public void reset(View v)
	{
		username.setText("");
		pwd.setText("");
		repwd.setText("");
		email.setText("");
		contact.setText("");
		address.setText("");
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
