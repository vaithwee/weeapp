package com.example.vaith.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/4.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper
{
    public static final String CREATE_BOOK = "create table book ("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text)";


    public static final String CREATE_CATEGORY = "create table category ("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";

    private Context mContext;

    public MyDatabaseHelper(Context ctx, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(ctx,name,factory,version);
        mContext = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
//        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists book");
        db.execSQL("drop table if exists category");
        onCreate(db);
    }
}
