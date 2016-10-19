package com.example.jhon.abogadosapp;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jhon.abogadosapp.dataBase.AbogadoDbHelper;
import com.example.jhon.abogadosapp.models.Abogado;

public class NewAbogadoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre, cedula, cargo, descripcion;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_abogado);
        nombre = (EditText) findViewById(R.id.nombre);
        cedula = (EditText) findViewById(R.id.cedula);
        cargo  = (EditText) findViewById(R.id.cargo);
        descripcion = (EditText) findViewById(R.id.descripcion);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Abogado abogado = new Abogado();
        abogado.setNombre(nombre.getText().toString());
        abogado.setDescripcion(descripcion.getText().toString());
        abogado.setCargo(cargo.getText().toString());
        abogado.setId(cedula.getText().toString());
        AbogadoDbHelper helper = new AbogadoDbHelper(this);
        helper.guardarAbogado(abogado);
        finish();
    }
}
