package com.example.jarvis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String db="reg";
    public static final String tn="user";
    public static final String id="id";
    public static final String name="name";
    public static final String email="mail";
    public static final String ph="phone";
    public static final String pass="code";


    public Database(@Nullable Context context) {
        super(context, db, null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tn+" ("+id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+name+" TEXT,"+email+" TEXT,"+ph+" INTEGER,"+pass+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tn);


    }

    public boolean insertdata(String Name,String mail,String phoneno,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(name,Name);
        contentValues.put(email,mail);
        contentValues.put(ph,phoneno);
        contentValues.put(pass,password);
        long result =db.insert(tn,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+tn,null);
        return res;
    }


    public boolean checkuser(String mail,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+tn+" where "+email+"='"+mail+"' and "+pass+"='"+password+"'",null);
        int count=cur.getCount();
        if(count > 0){
            return true;
        } else {
            return false;
        }



    }


}