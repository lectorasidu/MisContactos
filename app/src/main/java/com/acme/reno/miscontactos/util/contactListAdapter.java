package com.acme.reno.miscontactos.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.acme.reno.miscontactos.R;

import java.util.List;

/**
 * Created by Reno on 12/04/2015.
 */
public class contactListAdapter extends ArrayAdapter<Contacto>{
    private Activity ctx;

    public contactListAdapter (Activity context, List<Contacto> contactos){
        super(context, R.layout.listview_item, contactos);
        this.ctx = ctx;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {//paso4 para ver explicaciones de codigo
       if(view==null){
           view=ctx.getLayoutInflater().inflate(R.layout.listview_item,parent,false);
       }
       Contacto actual=this.getItem(position);
       inicializarCamposDeTexto(view,actual);
       return view;
    }

    private void inicializarCamposDeTexto(View view, Contacto actual) {
        TextView textView=(TextView)view.findViewById(R.id.viewNombre);
        textView.setText(actual.getNombre());
        textView=(TextView)view.findViewById(R.id.viewTelefono);
        textView.setText(actual.getNombre());
    }
}
