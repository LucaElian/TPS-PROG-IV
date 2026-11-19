package com.example.tp6.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tp6.R;
import com.example.tp6.entidad.Contacto;
import com.example.tp6.entidad.TipoContacto;
import com.google.android.material.materialswitch.MaterialSwitch;

public class MasDatosContactoActivity extends BaseActivity {

    private RadioGroup rgNivelEstudios;
    private CheckBox cbDeporte;
    private CheckBox cbMusica;
    private CheckBox cbArte;
    private CheckBox cbTecnologia;
    private MaterialSwitch swRecibirInfo;

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

        Button btnGuardar = findViewById(R.id.btnGuardar);

        swRecibirInfo.setOnCheckedChangeListener((buttonView, estaActivado) -> {
            buttonView.setText(
                    estaActivado
                            ? R.string.si
                            : R.string.no
            );
        });

        btnGuardar.setOnClickListener(view -> {
            if (!validarDatos()) return;

            guardarContacto();
        });
    }

    private void guardarContacto() {

        Intent intentOrigen = getIntent();

        String nombre = intentOrigen.getStringExtra("nombre");
        String apellido = intentOrigen.getStringExtra("apellido");

        String telefono = intentOrigen.getStringExtra("telefono");
        TipoContacto tipoTelefono = TipoContacto.valueOf(intentOrigen.getStringExtra("tipoTelefono"));

        String mail = intentOrigen.getStringExtra("mail");
        TipoContacto tipoMail = TipoContacto.valueOf(intentOrigen.getStringExtra("tipoMail"));

        String direccion = intentOrigen.getStringExtra("direccion");
        String fechaNacimiento = intentOrigen.getStringExtra("fechaNacimiento");

        int idRbSeleccionado = rgNivelEstudios.getCheckedRadioButtonId();
        RadioButton rbSeleccionado = findViewById(idRbSeleccionado);
        String nivelEstudios = rbSeleccionado.getText().toString();

        boolean deporte = cbDeporte.isChecked();
        boolean musica = cbMusica.isChecked();
        boolean arte = cbArte.isChecked();
        boolean tecnologia = cbTecnologia.isChecked();

        boolean recibirInfo = swRecibirInfo.isChecked();

        Contacto contacto = new Contacto(
                nombre,
                apellido,
                telefono,
                tipoTelefono,
                mail,
                tipoMail,
                direccion,
                fechaNacimiento,
                nivelEstudios,
                deporte,
                musica,
                arte,
                tecnologia,
                recibirInfo
        );

        long id = bd.insertarContacto(contacto);

        if (id != -1) {

            Toast.makeText(
                    this,
                    R.string.contacto_guardado,
                    Toast.LENGTH_SHORT
            ).show();

            Intent intentListado = new Intent(this, ListadoContactosActivity.class);

            startActivity(intentListado);
            finish();

        } else {

            Toast.makeText(
                    this,
                    R.string.error_guardar_contacto,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    private boolean validarDatos() {

        if (rgNivelEstudios.getCheckedRadioButtonId() == -1) {

            Toast.makeText(
                    this,
                    R.string.error_nivel_estudios,
                    Toast.LENGTH_SHORT
            ).show();

            return false;
        }

        boolean tieneInteres =
                cbDeporte.isChecked()
                        || cbMusica.isChecked()
                        || cbArte.isChecked()
                        || cbTecnologia.isChecked();

        if (!tieneInteres) {

            Toast.makeText(
                    this,
                    R.string.error_intereses,
                    Toast.LENGTH_SHORT
            ).show();

            return false;
        }

        return true;
    }
}