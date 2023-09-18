//this class is responsible for all the database operations , i.e insert, read, update, delete, etc

package com.example.tonyblairsuper.sqlitelessonlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TONY BLAIR SUPER on 3/25/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static  final  String DATABASE_NAME= "Coding.db";
    public static  final  String TABLE_NAME= "code_table";

    public static  final String COL_1 ="ID";
    public static  final String COL_2 ="NAME";
    public static  final String COL_3 ="SURNAME";
    public static  final String COL_4 ="MARKS";

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }
 @Override
    public void onCreate(SQLiteDatabase db)
 {
     db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
 }

    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertData(String name, String surname, String marks)
    {
      SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);

        long result = db.insert(TABLE_NAME,null, contentValues);
        db.close();

        //Check whether data is inserted in database or not

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //fetch data rom the database and display on the texView
     public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM code_table", null);
        return res;
    }

    public boolean updateData(String id, String name, String surname, String marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4,marks);

        int result = db.update(TABLE_NAME, contentValues, "ID=?", new String[]{id});

        if(result>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
   public  Integer deleteData(String id)
   {
       //delete the specified ID
      SQLiteDatabase db = this.getWritableDatabase() ;
       int x = db.delete(TABLE_NAME, "ID=?", new String[]{id});
       return x;
   }

}
