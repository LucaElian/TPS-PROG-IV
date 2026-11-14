package com.example.tp6.activity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tp6.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

        etFechaNacimiento.setOnClickListener(view -> mostrarCalendario());
        etNombre.setOnFocusChangeListener((view, tieneFoco) -> {
            if (!tieneFoco) validarNombreApellido(etNombre);
        });
        etApellido.setOnFocusChangeListener((view, tieneFoco) -> {
            if (!tieneFoco) validarNombreApellido(etApellido);
        });
        etTelefono.setOnFocusChangeListener((view, tieneFoco) -> {
            if (!tieneFoco) validarTelefono();
        });
        btnContinuar.setOnClickListener(view -> {
            if (!validarDatosPersonales()) return;
            // Integrar aqui el paso a Mas datos cuando esa actividad este creada.
        });

        String[] tiposTelefono = {
                "Casa",
                "Trabajo",
                "Móvil"
        };

        ArrayAdapter<String> adapterTipoTelefono =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        tiposTelefono
                );

        adapterTipoTelefono.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spTipoTelefono.setAdapter(adapterTipoTelefono);

    }

    private SimpleDateFormat formatoFecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
        formato.setLenient(false);
        return formato;
    }

    private void mostrarCalendario() {
        Calendar seleccion = Calendar.getInstance();
        String texto = etFechaNacimiento.getText().toString();
        if (!texto.isEmpty()) {
            try {
                Date fecha = formatoFecha().parse(texto);
                if (fecha != null) seleccion.setTime(fecha);
            } catch (ParseException ignored) {
                // Si no hay una fecha valida, abrir el calendario en el dia actual.
            }
        }

        DatePickerDialog calendario = new DatePickerDialog(this, R.style.Theme_TP6_Calendario,
                (view, anio, mes, dia) -> {
                    Calendar fecha = Calendar.getInstance();
                    fecha.set(anio, mes, dia);
                    etFechaNacimiento.setText(formatoFecha().format(fecha.getTime()));
                    etFechaNacimiento.setError(null);
                }, seleccion.get(Calendar.YEAR), seleccion.get(Calendar.MONTH),
                seleccion.get(Calendar.DAY_OF_MONTH));
        calendario.getDatePicker().setMaxDate(System.currentTimeMillis());
        calendario.show();
        configurarBotonCalendario(calendario.getButton(DatePickerDialog.BUTTON_POSITIVE),
                R.string.calendario_aceptar);
        configurarBotonCalendario(calendario.getButton(DatePickerDialog.BUTTON_NEGATIVE),
                R.string.calendario_cancelar);
    }

    private void configurarBotonCalendario(Button boton, int texto) {
        boton.setText(texto);
        boton.setTextColor(android.graphics.Color.BLACK);
        boton.setBackgroundTintList(null);
        boton.setBackgroundResource(R.drawable.calendario_boton);
        int espacio = Math.round(8 * getResources().getDisplayMetrics().density);
        boton.setPadding(espacio * 2, espacio, espacio * 2, espacio);
        if (boton.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams parametros =
                    (android.view.ViewGroup.MarginLayoutParams) boton.getLayoutParams();
            parametros.setMarginStart(espacio);
            boton.setLayoutParams(parametros);
        }
    }

    private boolean validarNombreApellido(EditText campo) {
        String texto = campo.getText().toString().trim();
        if (texto.isEmpty()) {
            campo.setError(getString(R.string.error_campo_obligatorio));
            return false;
        }
        if (!texto.matches("[\\p{L}\\p{M}]+(?:[ '’\\-][\\p{L}\\p{M}]+)*")) {
            campo.setError(getString(R.string.error_nombre_apellido));
            return false;
        }
        campo.setError(null);
        return true;
    }

    private boolean validarTelefono() {
        String texto = etTelefono.getText().toString().trim();
        if (texto.isEmpty()) {
            etTelefono.setError(getString(R.string.error_campo_obligatorio));
            return false;
        }
        if (!texto.matches("[0-9]+(?:-[0-9]+)*")) {
            etTelefono.setError(getString(R.string.error_telefono));
            return false;
        }
        etTelefono.setError(null);
        return true;
    }

    public boolean validarDatosPersonales() {
        boolean nombreValido = validarNombreApellido(etNombre);
        boolean apellidoValido = validarNombreApellido(etApellido);
        boolean telefonoValido = validarTelefono();
        boolean fechaValida = !etFechaNacimiento.getText().toString().isEmpty();
        etFechaNacimiento.setError(fechaValida ? null
                : getString(R.string.error_fecha_obligatoria));

        if (!nombreValido) etNombre.requestFocus();
        else if (!apellidoValido) etApellido.requestFocus();
        else if (!telefonoValido) etTelefono.requestFocus();
        else if (!fechaValida) etFechaNacimiento.getParent().requestChildFocus(
                etFechaNacimiento, etFechaNacimiento);

        return nombreValido && apellidoValido && telefonoValido && fechaValida;
    }
}
