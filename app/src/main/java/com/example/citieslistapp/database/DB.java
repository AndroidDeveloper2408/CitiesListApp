package com.example.citieslistapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Серёга on 07.07.2017.
 */

public class DB {

    private static final String DB_NAME = "countries";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE_COUNTRIES = "countries";
    private static final String DB_TABLE_CITIES = "cities";
    public static final String COLUMN_ID = "_id";

    //Table Countries
    public static final String COLUMN_COUNTRY = "country";

    //Table Cities
    public static final String COLUMN_COUNTRY_ID = "country_id";
    public static final String COLUMN_CITY = "city";

    private static final String DB_CREATE_COUNTRIES =
            "create table " + DB_TABLE_COUNTRIES + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_COUNTRY + " text" +
                    ");";

    private static final String DB_CREATE_CITIES =
            "create table " + DB_TABLE_CITIES + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_COUNTRY_ID + " integer, " +
                    COLUMN_CITY + " text" +
                    ");";

    private final Context mCtx;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    public void close() {
        if (mDBHelper!=null) mDBHelper.close();
    }

    public Cursor getAllDataCountries() {
        return mDB.query(DB_TABLE_COUNTRIES, null, null, null, null, null, null);
    }

    public Cursor getAllDataCities() {
        return mDB.query(DB_TABLE_CITIES, null, null, null, null, null, null);
    }

    public long addRecToCountries(String country) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_COUNTRY, country);
        long dBAnewRowId = mDB.insert(DB_TABLE_COUNTRIES, null, cv);
        return dBAnewRowId;
    }

    public long addRecToCities(int country_id, String city) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_COUNTRY_ID, country_id);
        cv.put(COLUMN_CITY, city);
        long dBAnewRowId = mDB.insert(DB_TABLE_CITIES, null, cv);
        return dBAnewRowId;
    }

    public String getCountryName(long id) {
        String country = "";
        Cursor c = mDB.query(DB_TABLE_COUNTRIES, null, COLUMN_ID + " = " + id, null, null, null, null);
        if (c.getCount() == 0)
            country = "Error to get the record";
        else {
            while (c.moveToNext()) {
                country = c.getString(c.getColumnIndex(COLUMN_COUNTRY));

            }
        }
        return country;
    }

    // класс по созданию и управлению БД
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        // создаем и заполняем БД
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE_COUNTRIES);
            db.execSQL(DB_CREATE_CITIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

}
