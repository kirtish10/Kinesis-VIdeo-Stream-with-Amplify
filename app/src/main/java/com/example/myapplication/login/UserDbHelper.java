package com.example.myapplication.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "user_db";
    public static final String TABLE_NAME = "user_table";

    public static final String KEY_ID = "id";
    public static final String KEY_UID = "accessToken";
    public static final String KEY_IDT = "idToken";
    public static final String KEY_REFRESH = "refreshToken";


    public UserDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+ TABLE_NAME +"("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_UID + " TEXT, "+ KEY_IDT + " TEXT, "
                + KEY_REFRESH + " TEXT)";
        db.execSQL(create);
    }

    public boolean isUserExist(String mobile){
        String v = String.valueOf(mobile);
        boolean x = false;
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            String select = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(select, null);
            while(cursor.moveToNext()){
                if(cursor.getString(cursor.getColumnIndex("mobile")).equals(v)){
                    x = true;
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }

//    public int updateUser(User user){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues cv = new ContentValues();
//        cv.put(KEY_UID,user.getAccess());
//        cv.put(KEY_IDT,user.getIdt());
//        cv.put(KEY_REFRESH,user.getRefresh());
//
//        //Lets update now
//        return db.update(TABLE_NAME, cv, KEY_MOBILE + "=?",
//                new String[]{String.valueOf(user.getMobile())});
//
//    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_UID,user.getAccess());
        cv.put(KEY_IDT,user.getIdt());
        cv.put(KEY_REFRESH,user.getRefresh());
        db.insert(TABLE_NAME,null,cv);
        db.close();
    }

    public int getCount(){
        String query = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        return c.getCount();
    }

    public void deleteUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}