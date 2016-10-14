package com.example.jhon.abogadosapp.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhon.abogadosapp.models.Abogado;
import com.example.jhon.abogadosapp.models.AbogadoContract;

/**
 * Created by jhon on 12/10/16.
 */

public class AbogadoDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "abogado.db";

    public AbogadoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + AbogadoContract.LawyerEntry.TABLE_NAME + " ("
                + AbogadoContract.LawyerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AbogadoContract.LawyerEntry.ID + " TEXT NOT NULL,"
                + AbogadoContract.LawyerEntry.NAME + " TEXT NOT NULL,"
                + AbogadoContract.LawyerEntry.CARGO + " TEXT NOT NULL,"
                + AbogadoContract.LawyerEntry.DESCRIPCION + " TEXT NOT NULL,"
                + "UNIQUE (" + AbogadoContract.LawyerEntry.ID + "))");
        ContentValues contentValues = new ContentValues();
        contentValues.put(AbogadoContract.LawyerEntry.ID,"100611023957");
        contentValues.put(AbogadoContract.LawyerEntry.NAME,"Carlos Puyol");
        contentValues.put(AbogadoContract.LawyerEntry.CARGO,"Abogado Judicial");
        contentValues.put(AbogadoContract.LawyerEntry.DESCRIPCION,"Abogado con experencia en casos de familia");

        db.insert(AbogadoContract.LawyerEntry.TABLE_NAME,null,contentValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long guardarAbogado(Abogado abogado){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(
                AbogadoContract.LawyerEntry.TABLE_NAME,
                null,
                abogado.toContentValues());
    }
}
