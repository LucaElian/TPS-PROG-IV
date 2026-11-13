package com.example.tp6.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tp6.R;

public class AgregarContactoActivity extends BaseActivity {
    private EditText etNombre;
    private EditText etApellido;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDireccion;
    private EditText etFechaNacimiento;
    private Spinner spTipoTelefono;
    private Spinner spTipoEmail;
    private Button btnContinuar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_agregar_contacto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etTelefono = findViewById(R.id.etTelefono);
        spTipoTelefono = findViewById(R.id.spTipoTelefono);
        etEmail = findViewById(R.id.etEmail);
        spTipoEmail = findViewById(R.id.spTipoEmail);
        etDireccion = findViewById(R.id.etDireccion);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        btnContinuar = findViewById(R.id.btnContinuar);

    }

}
