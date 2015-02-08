package com.acme.reno.miscontactos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acme.reno.miscontactos.util.TextChangedListener;


public class MainActivity extends ActionBarActivity {

    private EditText txtNombre, txtTelefono, txtEmail, txtDireccion;
    private Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentesUI();
    }

    private void inicializarComponentesUI() {
        txtNombre=(EditText)findViewById(R.id.cmpNombre);
        txtTelefono=(EditText)findViewById(R.id.cmpTelefono);
        txtEmail=(EditText)findViewById(R.id.cmpEmail);
        txtDireccion=(EditText)findViewById(R.id.cmpDireccion);

        txtNombre.addTextChangedListener(new TextChangedListener(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnAgregar = (Button) findViewById(R.id.btnAgregar);
                btnAgregar.setEnabled(!s.toString().trim().isEmpty());
            }
        });

    }

    public void onClick(View view) {
        String msg = String.format("%s ha sido agregado a la lista",txtNombre.getText());
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        btnAgregar.setEnabled(false);
        limpiarCampos();

    }

    private void limpiarCampos() {
        txtTelefono.getText().clear();
        txtNombre.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        txtNombre.requestFocus();
    }
}
