package com.example.databasedemo;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SlidingDrawer;

public class MyDataBase extends SQLiteOpenHelper 
{
	
	
	MyDataBase(Context cntxt)
	{
		
		super(cntxt, "Register", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// Create Table if want to insert row for admin do here
		
		String sql = "create table userData ( userId Integer , userName Text , password Text , email Text , contact Text , address Text)";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// Drop the table and create new Table
		onCreate(db);
		
	}
	
	public void insertRecord(User u)
	{
		
		// Insert data in table
		try{
		SQLiteDatabase db =  getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put("userName", u.getName());
		cv.put("password",u.getPwd());
		cv.put("email",u.getEmail());
		cv.put("contact", u.getCntct());
		cv.put("address", u.getAddress());
		
		
		
		db.insert("userData", null,cv);
		System.out.println("data Inserted");
		
		}
		catch(Exception ex)
		{
			
			System.out.println();
		}
	}
	public void updateRecord(User u)
	{
		
		// update data in table
		
		
		 SQLiteDatabase db =  getWritableDatabase();
			
			ContentValues up = new ContentValues();
			up.put("userName", u.getName());
			up.put("password",u.getPwd());
			up.put("email",u.getEmail());
			up.put("contact", u.getCntct());
			up.put("address", u.getAddress());
			
			
			
			db.update("userData",up,null,null);
		
	}
	public int deleteRecord(String name)
	{
		
		// delete data from table
		SQLiteDatabase db = getWritableDatabase();
		String whereclause = "userName = ?";
		String args[] = {name};
		int row = db.delete("userData", whereclause, args);
		return row;
		
	}
	public String getRecord()
	{
		
		// Fetch Single record from Database
		
		SQLiteDatabase db = getReadableDatabase();
		String [] cols = {"userName","pwd","repwd","email","contact"};
		Cursor cursor = db.query("userData",cols, null, null, null,null,null);
		StringBuffer buffer=new StringBuffer();
		
		     while(cursor.moveToNext())
		  
		    {
		    	String username=cursor.getString(0);
		    	String pwd=cursor.getString(1);
		    	String repwd=cursor.getString(2);
		    	String email=cursor.getString(3);
		    	int contact=cursor.getInt(4);
		    }
		     // return contact
		     return buffer.toString();
		    	    
		}
		public ArrayList<String> getAllREcord()
	{
		
		//  Fetch All record from Database
		ArrayList<String> names = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		String [] colname = {"userName"};
		
		Cursor cursor = db.query("userData", colname,null ,null, null, null, null);
		while(cursor.moveToNext())
		{
			names.add(cursor.getString(0));
			
		}
		return names;
		
	}
		
		
		
		public ArrayList<String[]> getAllRecordForList()
		{
			
			//  Fetch All record from Database
			ArrayList<String[]> recordforlist = new ArrayList<String[]>();
			SQLiteDatabase db =  getReadableDatabase();
			String tableName = "userData";
			String colName[] = {"userName","email","address"};
			
			Cursor cr = db.query(tableName, colName, null, null, null, null, null);
			
			
			while(cr.moveToNext())
			{
				String [] record = new String[3];
				record [0] = cr.getString(0);
				record [1] = cr.getString(1);
				
				record [2] = cr.getString(2);
				recordforlist.add(record);
				
			}
			return recordforlist;
		}
		

}
