package com.example.jhon.abogadosapp.models;

import android.provider.BaseColumns;

/**
 * Created by jhon on 12/10/16.
 */

public class AbogadoContract {
    public static abstract class LawyerEntry implements BaseColumns {
        public static final String TABLE_NAME ="abogado";
        public static final String ID = "id";
        public static final String NAME = "nombre";
        public static final String CARGO = "cargo";
        public static final String DESCRIPCION = "descripcion";
    }
}

