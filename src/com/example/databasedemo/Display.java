package com.example.databasedemo;

import java.io.File;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class Display extends Activity implements OnItemClickListener  {
	ListView mylist;
	MyDataBase database;
	ArrayList<String[]> names;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		Toast.makeText(this,  "Inside on creATE ", Toast.LENGTH_LONG).show();
		//==== fetch the list=================
				mylist = (ListView)findViewById(R.id.listView1);
				
			//	========= Initialize =================
				
				// ============ HAndle The Events=-==========
				mylist.setOnItemClickListener(this);
			}

	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
		
		
		database =  new MyDataBase(this);
		names = database.getAllRecordForList();
		System.out.println("size is :: "+names.size());
		Toast.makeText(this, names.size() + " ", Toast.LENGTH_LONG).show();
		
		mylist.setAdapter(new myAdapter());
	}



	class myAdapter extends BaseAdapter
	{

		@Override
		public int getCount()
		{
			// TODO Auto-generated method stub
			return names.size();
		}

		@Override
		public Object getItem(int arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0)
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int pos, View view, ViewGroup arg2)
		{
			// TODO Auto-generated method stub
			if(view == null)
			{
				view = getLayoutInflater().inflate(R.layout.items, arg2,false);
				
			}
			
			TextView username = (TextView)view.findViewById(R.id.textView1);
			TextView email = (TextView)view.findViewById(R.id.textView2);
			TextView address = (TextView)view.findViewById(R.id.textView3);

			String arr [] = names.get(pos);
			username.setText(arr[0]);
			email.setText(arr[1]);
			address.setText(arr[2]);
			return view;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, pos+ "" , Toast.LENGTH_LONG).show();
		Toast.makeText(this, arg0.getItemAtPosition(pos)+ "" , Toast.LENGTH_LONG).show();
	}



	


	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
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
