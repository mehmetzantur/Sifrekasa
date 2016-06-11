package com.mehmetzantur.sifrekasa.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;

import com.mehmetzantur.sifrekasa.Poco.User;

import java.sql.SQLException;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SifrekasaDB";

    private static final String TABLE_USER = "User";
    private static final String UserId = "UserId";
    private static final String UserPass = "UserPass";

    SQLiteDatabase dbw = this.getWritableDatabase();
    SQLiteDatabase dbr = this.getReadableDatabase();

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_USER + "(UserId INTEGER PRIMARY KEY, UserPass TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }


    public String SignupUser(String pass){
            try {
                ContentValues value = new ContentValues();
                value.put("UserPass",pass);
                dbw.insert(TABLE_USER, null, value);
                dbw.close();
                return "ok";
            }
            catch(Exception ex){
                return ex.toString();
            }
    }


    public boolean HasAdmin(){
        String sql = "SELECT * FROM " + TABLE_USER ;
        Cursor reader = dbr.rawQuery(sql,null);
        reader.moveToFirst();
        if(reader.getCount() > 0)
            return true;
        else
            return false;
    }

    public String GetAdminPass(){
        String sql = "SELECT * FROM " + TABLE_USER;
        String pass = null;
        Cursor reader = dbr.rawQuery(sql,null);
        reader.moveToFirst();
        if(reader.getCount() > 0){
            pass = reader.getString(1);
        }
        return pass;
    }

    public User GetAdmin(String pass){
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + UserPass + " = '" + pass + "'";
        Cursor reader = dbr.rawQuery(sql,null);
        reader.moveToFirst();
        if(reader.getCount() > 0){
            User user = new User();
            user.setUserId(reader.getInt(0));
            user.setUserPass(reader.getString(1));
            return user;
        }
        else{
            return null;
        }
    }












}
