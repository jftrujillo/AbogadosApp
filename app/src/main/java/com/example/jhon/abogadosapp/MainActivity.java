package com.example.jhon.abogadosapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.jhon.abogadosapp.adapters.ListAbogadosAdapter;
import com.example.jhon.abogadosapp.dataBase.AbogadoDbHelper;
import com.example.jhon.abogadosapp.models.Abogado;
import com.example.jhon.abogadosapp.models.AbogadoContract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AbogadoDbHelper helper;
    Cursor cursor;
    ListView list;
    ListAbogadosAdapter adapter;
    List<Abogado> data;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
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

    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor = helper.getAllLawyer();
        data.clear();
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
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,NewAbogadoActivity.class));
    }
}
