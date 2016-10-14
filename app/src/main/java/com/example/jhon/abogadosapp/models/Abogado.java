package com.example.jhon.abogadosapp.models;

import android.content.ContentValues;

/**
 * Created by jhon on 12/10/16.
 */

public class Abogado {
    String id;
    String nombre;
    String cargo;
    String descripcion;

    //region Getter and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //endregion

    public ContentValues toContentValues(){

        ContentValues values = new ContentValues();
        values.put(AbogadoContract.LawyerEntry.ID, id);
        values.put(AbogadoContract.LawyerEntry.NAME, nombre);
        values.put(AbogadoContract.LawyerEntry.CARGO, cargo);
        values.put(AbogadoContract.LawyerEntry.DESCRIPCION, descripcion);
        return values;
    }
}
