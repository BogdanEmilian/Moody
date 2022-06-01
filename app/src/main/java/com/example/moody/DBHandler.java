package com.example.moody;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "MoodyDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "ValuesTable";
    private static final String ID_COL = "id";
    private static final String HAPPINESS_COL = "Happiness";
    private static final String REST_COL = "Rest";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HAPPINESS_COL + " REAL,"
                + REST_COL + " REAL)";

        db.execSQL(query);
    }

    public void insertData(float happiness, float rest) {

        SQLiteDatabase db = this.getWritableDatabase();     //establishes connection
        ContentValues values = new ContentValues();         //variable to hold the query with the specific values

        //Adding the values inside the query along with the column name where the values belong to.
        values.put(HAPPINESS_COL, happiness);
        values.put(REST_COL, rest);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Data> getLastWeek(){
        ArrayList<Data> array = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorData = db.rawQuery("select * from (select * from ValuesTable order by id DESC limit 7) order by id ASC;", null);

        if(cursorData.moveToFirst()){
            do{
                array.add(new Data(cursorData.getFloat(1), cursorData.getFloat(2)));
            }while (cursorData.moveToNext());
        }

        cursorData.close();
        System.out.println(array);
        return array;
    }

    //Automatically called on initialisation
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Searching for already existing table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}