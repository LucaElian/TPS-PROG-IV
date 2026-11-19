package com.example.tp6.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.tp6.R;
import com.example.tp6.adapter.ContactoAdapter;
import com.example.tp6.entidad.Contacto;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ListadoContactosActivity extends BaseActivity {

    private ContactoAdapter adapterContactos;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_listado_contactos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView lvContactos = findViewById(R.id.lvContactos);
        lvContactos.setEmptyView(findViewById(R.id.emptyStateContactos));

        adapterContactos = new ContactoAdapter(this, new ArrayList<>());
        lvContactos.setAdapter(adapterContactos);

        lvContactos.setOnItemClickListener((parent, view, position, id) -> {
            Contacto contacto = adapterContactos.getItem(position);
            if (contacto == null) return;

            String detalleContacto = obtenerDetalles(contacto);
            mostrarDetalleContacto(contacto, detalleContacto);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Contacto> contactos = bd.getListadoContactos();
        adapterContactos.setNotifyOnChange(false);
        adapterContactos.clear();
        adapterContactos.addAll(contactos);
        adapterContactos.notifyDataSetChanged();
    }

    private void mostrarDetalleContacto(Contacto contacto, String detalleContacto) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_detalle_contacto, null);

        TextView tvAvatarDetalle = sheetView.findViewById(R.id.tvAvatarDetalle);
        TextView tvTituloDetalle = sheetView.findViewById(R.id.tvTituloDetalle);
        TextView tvSubtituloDetalle = sheetView.findViewById(R.id.tvSubtituloDetalle);
        TextView tvDetalleContacto = sheetView.findViewById(R.id.tvDetalleContacto);
        Button btnCerrarDetalle = sheetView.findViewById(R.id.btnCerrarDetalle);

        ContactoAdapter.aplicarEstiloAvatar(this, tvAvatarDetalle, contacto);
        tvTituloDetalle.setText(contacto.getNombre() + " " + contacto.getApellido());
        tvSubtituloDetalle.setText(contacto.getMail());
        tvDetalleContacto.setText(formatearEtiquetasDetalle(detalleContacto));

        btnCerrarDetalle.setOnClickListener(v -> bottomSheetDialog.dismiss());

        bottomSheetDialog.setContentView(sheetView);
        BottomSheetBehavior<?> comportamiento = bottomSheetDialog.getBehavior();
        comportamiento.setSkipCollapsed(true);
        comportamiento.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetDialog.show();
    }

    private CharSequence formatearEtiquetasDetalle(String detalle) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(detalle);
        int colorEtiqueta = ContextCompat.getColor(this, R.color.app_label);
        int inicioLinea = 0;

        while (inicioLinea < detalle.length()) {
            int finLinea = detalle.indexOf('\n', inicioLinea);
            if (finLinea == -1) finLinea = detalle.length();

            int dosPuntos = detalle.indexOf(':', inicioLinea);
            if (dosPuntos != -1 && dosPuntos < finLinea) {
                ssb.setSpan(
                        new StyleSpan(Typeface.BOLD),
                        inicioLinea,
                        dosPuntos + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                ssb.setSpan(
                        new ForegroundColorSpan(colorEtiqueta),
                        inicioLinea,
                        dosPuntos + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );
            }

            inicioLinea = finLinea + 1;
        }

        return ssb;
    }

    private String obtenerIntereses(Contacto contacto) {
        List<String> intereses = new ArrayList<>();

        if (contacto.isDeporte()) intereses.add(getString(R.string.deporte));
        if (contacto.isMusica()) intereses.add(getString(R.string.musica));
        if (contacto.isArte()) intereses.add(getString(R.string.arte));
        if (contacto.isTecnologia()) intereses.add(getString(R.string.tecnologia));

        return intereses.isEmpty() ? getString(R.string.ninguno) : TextUtils.join(", ", intereses);
    }

    private String obtenerDetalles(Contacto contacto) {
        String recibirInfo = contacto.isRecibirInfo() ? getString(R.string.si) : getString(R.string.no);

        return getString(R.string.nombre) + ": " + contacto.getNombre() + "\n" +
                getString(R.string.apellido) + ": " + contacto.getApellido() + "\n" +
                getString(R.string.detalle_telefono) + ": " + contacto.getTelefono() + "\n" +
                getString(R.string.detalle_tipo_telefono) + ": " + contacto.getTipoTelefono() + "\n" +
                getString(R.string.detalle_email) + ": " + contacto.getMail() + "\n" +
                getString(R.string.detalle_tipo_email) + ": " + contacto.getTipoMail() + "\n" +
                getString(R.string.direccion) + ": " + contacto.getDireccion() + "\n" +
                getString(R.string.fecha_nacimiento) + ": " + contacto.getFechaNacimiento() + "\n" +
                getString(R.string.detalle_nivel_estudios) + ": " + contacto.getNivelEstudios() + "\n" +
                getString(R.string.intereses) + ": " + obtenerIntereses(contacto) + "\n" +
                getString(R.string.detalle_recibir_informacion) + ": " + recibirInfo;
    }
}