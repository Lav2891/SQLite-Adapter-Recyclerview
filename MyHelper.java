package com.example.ashwin.sqlitearraylist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ashwin on 11/9/2017.
 */

public class MyHelper {

    Helper help;
    Pojo po;
    ArrayList<Pojo> al = new ArrayList<Pojo>();

    public MyHelper(Context context) {
        help = new Helper(context);
        po = new Pojo();

    }

    public long insertdata(String name, long phno, int age, String email){
        SQLiteDatabase db = help.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(help.NAME, name);
        cv.put(help.PHNO, phno);
        cv.put(help.AGE, age);
        cv.put(help.EMAIL, email);
        long id =db.insert(help.TABLENAME, null, cv);
        return id;
    }


    public ArrayList<Pojo> getdata(){
        SQLiteDatabase db = help.getWritableDatabase();
        String[] columns = {help.UID, help.NAME, help.PHNO, help.AGE, help.EMAIL};
        Cursor cursor =db.query(help.TABLENAME, columns,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(help.UID));
            String name =cursor.getString(cursor.getColumnIndex(help.NAME));
            long phno =cursor.getLong(cursor.getColumnIndex(help.PHNO));
            int age =cursor.getInt(cursor.getColumnIndex(help.AGE));
            String email =cursor.getString(cursor.getColumnIndex(help.EMAIL));
            Pojo po=new Pojo();
            po.setName(name);
            po.setPhno(phno);
            po.setAge(age);
            po.setEmail(email);
            po.setCid(cid);
            Log.i("Display",name);
            Log.i("Display", String.valueOf(phno));
            Log.i("Display", String.valueOf(age));
            Log.i("Display",email);
            Log.i("Display", String.valueOf(cid));
            al.add(po);

        }
        return al;
    }
}

class Helper extends SQLiteOpenHelper{

    public static final String DBNAME = "DB";
    public static final int DBVersion = 1;
    public static final String TABLENAME = "DBTAB";
    public static final String UID = "id";
    public static final String NAME = "name";
    public static final String PHNO = "phno";
    public static final String AGE = "age";
    public static final String EMAIL = "email";
    private static final String CREATETABLE = "CREATE TABLE "+TABLENAME+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+ PHNO+" VARCHAR(225) ,"+ EMAIL+" VARCHAR(225) ,"+ AGE+" VARCHAR(225));";
    private static final String DROPTABLE ="DROP TABLE IF EXISTS "+TABLENAME;
    private Context context;

    public Helper(Context context) {
        super(context, DBNAME, null, DBVersion);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATETABLE);
        } catch (Exception e) {
            Message.message(context,""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context,"OnUpgrade");
            db.execSQL(DROPTABLE);
            onCreate(db);
        }catch (Exception e) {
            Message.message(context,""+e);
        }
    }

}

class Message{
    public static void message(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
