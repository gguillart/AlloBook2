package com.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Yohann on 18/02/2015.
 */
public abstract class DataBase {
    protected final static int version = 1;
    protected final static String nom = "com.database.db";
    protected SQLiteDatabase dB = null;
    protected DataBaseHandler handler = null;
    public DataBase(Context context) {
        this.handler = new DataBaseHandler(context, nom, null, version);
    }
    public SQLiteDatabase open() {
        dB = handler.getWritableDatabase();
        return dB;
    }
    public void close() {
        dB.close();
    }
    public SQLiteDatabase getDb() {
        return dB;
    }
}