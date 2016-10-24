package com.example.jhon.abogadosapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.jhon.abogadosapp.db.DaoMaster;
import com.example.jhon.abogadosapp.db.DaoSession;


/**
 * Created by Administrador on 21/07/2016.
 */
public class DBConnection {

    private DaoSession daoSession;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private Context context;

    public DBConnection(Context context) {
        this.context = context;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "abogadosapp-db", null);
        try{

            db = helper.getWritableDatabase();

        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void setDaoMaster(DaoMaster daoMaster) {
        this.daoMaster = daoMaster;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}

