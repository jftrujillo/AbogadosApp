package com.example.jhon.abogadosapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.jhon.abogadosapp.adapters.ListAbogadosAdapter;
import com.example.jhon.abogadosapp.db.Abogado;
import com.example.jhon.abogadosapp.db.AbogadoDao;
import com.example.jhon.abogadosapp.db.DaoSession;
import com.example.jhon.abogadosapp.util.DBConnection;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView list;
    ListAbogadosAdapter adapter;
    List<Abogado> data;
    Button btn;
    DBConnection dbConnection;
    DaoSession daoSession;
    AbogadoDao abogadoDao;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.abogados);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbConnection = new DBConnection(this);
        daoSession = dbConnection.getDaoSession();
        abogadoDao = daoSession.getAbogadoDao();
        crearAbogados();
        data = new ArrayList<>();
        data.addAll(obtenerAbogados());
        list = (ListView) findViewById(R.id.list);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        adapter = new ListAbogadosAdapter(data,this);
        list.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Advertencia");
                    builder.setMessage("Esta saliendo de la app, esta seguro?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                            finish();
                        }
                    });
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,NewAbogadoActivity.class));
    }

    public void crearAbogados(){
        Abogado abogado =  new Abogado();
        abogado.setCargo("Gerente");
        abogado.setNombre("Carlos");
        abogado.setDescripcion("Este man sabe mucho");
        abogadoDao.insert(abogado);

        Abogado abogado1 = new Abogado();
        abogado1.setCargo("Secretario");
        abogado1.setNombre("Juan");
        abogado1.setDescripcion("Este man no sabe tanto");
        abogadoDao.insert(abogado1);

        Abogado abogado2 = new Abogado();
        abogado2.setCargo("Ayudante de gerente");
        abogado2.setNombre("Pedro");
        abogado2.setDescripcion("Este man sabe mas o menos");
        abogadoDao.insert(abogado2);
    }

    public List<Abogado> obtenerAbogados(){
        List<Abogado> data = new ArrayList<>();
        data.addAll(abogadoDao.queryBuilder().list());
        return data;
    }
}
