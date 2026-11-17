package com.example.tp6.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tp6.R;
import com.google.android.material.materialswitch.MaterialSwitch;

public class MasDatosContactoActivity extends BaseActivity {

    private RadioGroup rgNivelEstudios;
    private CheckBox cbDeporte;
    private CheckBox cbMusica;
    private CheckBox cbArte;
    private CheckBox cbTecnologia;
    private MaterialSwitch swRecibirInfo;
    private Button btnGuardar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_mas_datos_contacto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rgNivelEstudios = findViewById(R.id.rgNivelEstudios);

        cbDeporte = findViewById(R.id.cbDeporte);
        cbMusica = findViewById(R.id.cbMusica);
        cbArte = findViewById(R.id.cbArte);
        cbTecnologia = findViewById(R.id.cbTecnologia);

        swRecibirInfo = findViewById(R.id.swRecibirInfo);

        btnGuardar = findViewById(R.id.btnGuardar);

        swRecibirInfo.setOnCheckedChangeListener((buttonView, estaActivado) -> {
            swRecibirInfo.setText(
                    estaActivado
                            ? R.string.si
                            : R.string.no
            );
        });
    }

    private boolean verificarRb(RadioGroup rg){
        return rg.getCheckedRadioButtonId() != -1;
    }

    private boolean verificarIntereses(CheckBox cb1, CheckBox cb2, CheckBox cb3, CheckBox cb4){
        return cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked();
    }


    private boolean validarDatos(){

        boolean rbValido = verificarRb(rgNivelEstudios);

        if(!rbValido) {
            Toast.makeText(this, R.string.error_nivel_estudios, Toast.LENGTH_SHORT).show();
            return false;
        }

        boolean interesesValidos = verificarIntereses(cbArte, cbDeporte, cbTecnologia, cbMusica);

        if(!interesesValidos){
            Toast.makeText(this, R.string.error_intereses, Toast.LENGTH_SHORT).show();
            return false;
            }

        return true;
    }
}