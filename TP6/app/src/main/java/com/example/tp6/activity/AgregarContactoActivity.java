package com.example.tp6.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tp6.R;
import com.example.tp6.entidad.TipoContacto;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class AgregarContactoActivity extends BaseActivity {

    private static final String REGEX_NOMBRE_APELLIDO =
            "[\\p{L}\\p{M}]+(?:[ '’\\-][\\p{L}\\p{M}]+)*";

    private static final String REGEX_TELEFONO =
            "[0-9]+(?:-[0-9]+)*";

    private static final String FORMATO_FECHA =
            "%02d/%02d/%04d";

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

        ArrayAdapter<TipoContacto> adapterTipoContacto =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        TipoContacto.values()
                );

        adapterTipoContacto.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spTipoTelefono.setAdapter(adapterTipoContacto);
        spTipoEmail.setAdapter(adapterTipoContacto);

        etFechaNacimiento.setOnClickListener(view -> mostrarCalendario());

        etNombre.setOnFocusChangeListener((view, tieneFoco) -> {
            if (!tieneFoco) validarCampo(
                    etNombre,
                    REGEX_NOMBRE_APELLIDO,
                    R.string.error_nombre_apellido
            );
        });

        etApellido.setOnFocusChangeListener((view, tieneFoco) -> {
            if (!tieneFoco) validarCampo(
                    etApellido,
                    REGEX_NOMBRE_APELLIDO,
                    R.string.error_nombre_apellido
            );
        });

        etTelefono.setOnFocusChangeListener((view, tieneFoco) -> {
            if (!tieneFoco) validarCampo(
                    etTelefono,
                    REGEX_TELEFONO,
                    R.string.error_telefono
            );
        });

        // validaciones q faltan...


        btnContinuar.setOnClickListener(view -> {
            if (!validarDatosPersonales()) return;

            // Integrar aqui el paso a Mas datos cuando esa actividad este creada.
        });
    }

    private void mostrarCalendario() {

        Calendar fechaMinima = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        fechaMinima.clear();
        fechaMinima.set(1900, Calendar.JANUARY, 1);

        CalendarConstraints restricciones =
                new CalendarConstraints.Builder()
                        .setStart(fechaMinima.getTimeInMillis())
                        .setEnd(MaterialDatePicker.todayInUtcMilliseconds())
                        .setValidator(DateValidatorPointBackward.now())
                        .build();

        MaterialDatePicker<Long> calendario =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText(R.string.fecha_nacimiento)
                        .setPositiveButtonText(R.string.calendario_aceptar)
                        .setNegativeButtonText(R.string.calendario_cancelar)
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .setCalendarConstraints(restricciones)
                        .setTheme(R.style.ThemeOverlay_TP6_Calendario)
                        .build();

        calendario.addOnPositiveButtonClickListener(seleccion -> {

            Calendar fecha = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

            fecha.setTimeInMillis(seleccion);

            String fechaTexto = String.format(
                    Locale.ROOT,
                    FORMATO_FECHA,
                    fecha.get(Calendar.DAY_OF_MONTH),
                    fecha.get(Calendar.MONTH) + 1,
                    fecha.get(Calendar.YEAR)
            );

            etFechaNacimiento.setText(fechaTexto);
            etFechaNacimiento.setError(null);

        });

        calendario.show(getSupportFragmentManager(), "FECHA_NACIMIENTO");
    }

    private boolean validarCampo(EditText campo, String expresion, int mensajeError) {

        String texto = campo.getText().toString().trim();

        if (texto.isEmpty()) {
            campo.setError(getString(R.string.error_campo_obligatorio));
            return false;
        }

        if (!texto.matches(expresion)) {
            campo.setError(getString(mensajeError));
            return false;
        }

        campo.setError(null);
        return true;
    }

    public boolean validarDatosPersonales() {

        boolean nombreValido = validarCampo(
                etNombre,
                REGEX_NOMBRE_APELLIDO,
                R.string.error_nombre_apellido
        );

        boolean apellidoValido = validarCampo(
                etApellido,
                REGEX_NOMBRE_APELLIDO,
                R.string.error_nombre_apellido
        );

        boolean telefonoValido = validarCampo(
                etTelefono,
                REGEX_TELEFONO,
                R.string.error_telefono
        );

        boolean fechaValida = !etFechaNacimiento.getText().toString().isEmpty();

        etFechaNacimiento.setError(
                fechaValida
                        ? null
                        : getString(R.string.error_fecha_obligatoria)
        );

        if (!nombreValido) etNombre.requestFocus();

        else if (!apellidoValido) etApellido.requestFocus();

        else if (!telefonoValido) etTelefono.requestFocus();

        else if (!fechaValida) etFechaNacimiento.getParent().requestChildFocus(
                etFechaNacimiento, etFechaNacimiento);

        return nombreValido
                && apellidoValido
                && telefonoValido
                && fechaValida;
    }
}