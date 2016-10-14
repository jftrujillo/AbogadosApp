package com.example.jhon.abogadosapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.jhon.abogadosapp.adapters.ListAbogadosAdapter;
import com.example.jhon.abogadosapp.dataBase.AbogadoDbHelper;
import com.example.jhon.abogadosapp.models.Abogado;
import com.example.jhon.abogadosapp.models.AbogadoContract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AbogadoDbHelper helper;
    Cursor cursor;
    ListView list;
    ListAbogadosAdapter adapter;
    List<Abogado> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);

        helper = new AbogadoDbHelper(this);
        cursor = helper.getAllLawyer();
        data = new ArrayList<>();
        while(cursor.moveToNext()){
            //region Consulta de abogados en base de datos
            Abogado abogado = new Abogado();
            String nombre = cursor.getString(
                    cursor.getColumnIndex(
                            AbogadoContract.LawyerEntry.NAME));
            abogado.setNombre(nombre);
            String cargo = cursor.getString(
                    cursor.getColumnIndex(AbogadoContract.LawyerEntry.CARGO)
            );
            abogado.setCargo(cargo);

            String id = cursor.getString(
                    cursor.getColumnIndex(AbogadoContract.LawyerEntry.ID)
            );
            abogado.setId(id);

            String descripcion = cursor.getString(
                    cursor.getColumnIndex(AbogadoContract.LawyerEntry.DESCRIPCION)
            );
            abogado.setDescripcion(descripcion);
            data.add(abogado);
            //endregion
        }
        adapter = new ListAbogadosAdapter(data,this);
        list.setAdapter(adapter);
    }
}
