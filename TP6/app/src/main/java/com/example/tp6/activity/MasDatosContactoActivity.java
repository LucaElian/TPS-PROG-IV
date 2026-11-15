package com.example.tp6.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tp6.R;

public class MasDatosContactoActivity extends BaseActivity {

    private TextView tvTitulo;
    private TextView tvDescripcion;
    private RadioGroup rgNivelEstudios;
    private RadioButton rbPrimarioIncompleto;
    private RadioButton rbPrimarioCompleto;
    private RadioButton rbSecundarioIncompleto;
    private RadioButton rbSecundarioCompleto;
    private RadioButton rbOtros;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_mas_datos_contacto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        rgNivelEstudios = findViewById(R.id.rgNivelEstudios);
        rbPrimarioIncompleto = findViewById(R.id.rbPrimarioIncompleto);
        rbPrimarioCompleto = findViewById(R.id.rbPrimarioCompleto);
        rbSecundarioIncompleto = findViewById(R.id.rbSecundarioIncompleto);
        rbSecundarioCompleto = findViewById(R.id.rbSecundarioCompleto);
        rbOtros = findViewById(R.id.rbOtros);
    }
}
