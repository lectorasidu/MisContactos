package com.acme.reno.miscontactos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.acme.reno.miscontactos.util.Contacto;
import com.acme.reno.miscontactos.util.TextChangedListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private EditText txtNombre, txtTelefono, txtEmail, txtDireccion;
    private List<Contacto> contactos = new ArrayList<Contacto>();
    private ListView contactsListView;
    private Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentesUI();
        inicializarTabs();
    }

    private void inicializarTabs() {
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");
        tabHost.addTab(spec);
    }

    private void inicializarComponentesUI() {
        txtNombre=(EditText)findViewById(R.id.cmpNombre);
        txtTelefono=(EditText)findViewById(R.id.cmpTelefono);
        txtEmail=(EditText)findViewById(R.id.cmpEmail);
        txtDireccion=(EditText)findViewById(R.id.cmpDireccion);
        contactsListView=(ListView)findViewById(R.id.listView);
        txtNombre.addTextChangedListener(new TextChangedListener(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnAgregar = (Button) findViewById(R.id.btnAgregar);
                btnAgregar.setEnabled(!s.toString().trim().isEmpty());
            }
        });

    }

    public void onClick(View view) {
        agregarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString());
        String msg = String.format("%s ha sido agregado a la lista",txtNombre.getText());
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        btnAgregar.setEnabled(false);
        inicializarListView();
        limpiarCampos();

    }

    private void inicializarListView() {
    }

    private void agregarContacto(String s, String s1) {
        contactos.add(new Contacto(s,s1,"",""));
    }

    private void limpiarCampos() {
        txtTelefono.getText().clear();
        txtNombre.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        txtNombre.requestFocus();
    }
}
