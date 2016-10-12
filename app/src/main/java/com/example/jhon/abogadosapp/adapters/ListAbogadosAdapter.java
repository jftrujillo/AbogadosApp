package com.example.jhon.abogadosapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jhon.abogadosapp.R;
import com.example.jhon.abogadosapp.models.Abogado;

import java.util.List;

/**
 * Created by jhon on 12/10/16.
 */

public class ListAbogadosAdapter extends BaseAdapter {
    List<Abogado> data;
    Context context;

    public ListAbogadosAdapter(List<Abogado> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(data.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            v = View.inflate(context, R.layout.template_list_abogado,null);
        }
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView cargo = (TextView) v.findViewById(R.id.cargo);
        nombre.setText(data.get(position).getNombre());
        cargo.setText(data.get(position).getCargo());
        return v;
    }
}
