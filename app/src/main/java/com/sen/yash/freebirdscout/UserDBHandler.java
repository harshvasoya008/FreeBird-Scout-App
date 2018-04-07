package com.sen.yash.freebirdscout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Harsh Vasoya on 12-05-2016.
 */

public class UserDBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "user.db";
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_1 = "email";
    public static final String COLUMN_2 = "password";
    public static final String COLUMN_3 = "name";
    private static boolean isDB_notEmpty = true;
    Context c;


    public UserDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
        c = context;
        //Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_1 + " TEXT PRIMARY KEY,"+
                COLUMN_2 + " TEXT,"+
                COLUMN_3 + " TEXT "+");";
        db.execSQL(query);
        isDB_notEmpty = true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrades the version of database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //add a new row to database
    public void addData(String emailid, String password, String name) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_1 ,emailid);
        values.put(COLUMN_2, password);
        values.put(COLUMN_3, name);
        
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //delete a row from database
    public void deleteData(String emailid){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_1 + "=\"" + emailid + "\";");
    }

    public void updateData(String oldemail,String newemail,String password,String name){
        deleteData(oldemail);
        addData(newemail, password, name);
    }

    public void clearDatabase(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_1 + " TEXT PRIMARY KEY,"+
                COLUMN_2 + " TEXT,"+
                COLUMN_3 + " TEXT "+");";
        db.execSQL(query);

        db.close();
    }

    public boolean checkEntry(String emailid){

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;       //means select all from table_name

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_1)).equals(emailid)){
                c.close();
                db.close();
                return true;
            }
            c.moveToNext();
        }
        c.close();
        db.close();
        return false;
    }
    
    //print database as a String
    public String databaseToString(){
        if (isDB_notEmpty) {
            String dbString = "";
            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();

            while (!c.isAfterLast()) {
                if (c.getString(1) != null)         //column heading = "data"
                {
                    dbString = c.getString(c.getColumnIndex(COLUMN_1)) + ": ";
                    dbString += c.getString(c.getColumnIndex(COLUMN_2)) + ", ";
                    dbString += c.getString(c.getColumnIndex(COLUMN_3));                    
                    dbString += "\n";
                }
                c.moveToNext();
            }
            c.close();
            db.close();
            return dbString;
        }
        else
            return "Database Empty";
    }

}

