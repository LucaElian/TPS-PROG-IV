package com.example.tp6.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tp6.R;
import com.example.tp6.entidad.Contacto;

import java.util.List;
import java.util.Locale;

public class ContactoAdapter extends ArrayAdapter<Contacto> {

    private static final int[] AVATAR_BG_LIGHT = {
            Color.parseColor("#E6F9CC"),
            Color.parseColor("#D8F5EC"),
            Color.parseColor("#DBF2FE"),
            Color.parseColor("#E2EAFF"),
            Color.parseColor("#DCF7E8")
    };

    private static final int[] AVATAR_TEXT_LIGHT = {
            Color.parseColor("#2B4D00"),
            Color.parseColor("#0A5243"),
            Color.parseColor("#0B4B6B"),
            Color.parseColor("#1D397A"),
            Color.parseColor("#0E5436")
    };

    private static final int[] AVATAR_BG_DARK = {
            Color.parseColor("#24330A"),
            Color.parseColor("#0D332B"),
            Color.parseColor("#0D2F45"),
            Color.parseColor("#1A274A"),
            Color.parseColor("#103324")
    };

    private static final int[] AVATAR_TEXT_DARK = {
            Color.parseColor("#C6FF00"),
            Color.parseColor("#5EEAD4"),
            Color.parseColor("#7DD3FC"),
            Color.parseColor("#A5B4FC"),
            Color.parseColor("#6EE7B7")
    };

    public ContactoAdapter(@NonNull Context context, @NonNull List<Contacto> contactos) {
        super(context, 0, contactos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_contacto, parent, false);
        }

        Contacto contacto = getItem(position);
        if (contacto == null) {
            return view;
        }

        TextView tvAvatar = view.findViewById(R.id.tvAvatarIniciales);
        TextView tvNombre = view.findViewById(R.id.tvNombreCompleto);
        TextView tvEmail = view.findViewById(R.id.tvEmailContacto);
        TextView tvBadge = view.findViewById(R.id.tvTipoBadge);

        aplicarEstiloAvatar(getContext(), tvAvatar, contacto);
        tvNombre.setText(contacto.getNombre() + " " + contacto.getApellido());
        tvEmail.setText(contacto.getMail());
        tvBadge.setText(contacto.getTipoTelefono().toString());

        return view;
    }

    public static void aplicarEstiloAvatar(Context context, TextView tvAvatar, Contacto contacto) {
        String inicialNombre = obtenerInicial(contacto.getNombre());
        String inicialApellido = obtenerInicial(contacto.getApellido());
        tvAvatar.setText((inicialNombre + inicialApellido).toUpperCase(Locale.ROOT));

        int clave = contacto.getId() > 0
                ? contacto.getId() - 1
                : Math.abs((contacto.getNombre() + contacto.getApellido()).hashCode());
        int idx = Math.abs(clave) % AVATAR_BG_LIGHT.length;

        boolean esModoOscuro = (context.getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;

        int bgColor = esModoOscuro ? AVATAR_BG_DARK[idx] : AVATAR_BG_LIGHT[idx];
        int textColor = esModoOscuro ? AVATAR_TEXT_DARK[idx] : AVATAR_TEXT_LIGHT[idx];

        GradientDrawable circle = new GradientDrawable();
        circle.setShape(GradientDrawable.OVAL);
        circle.setColor(bgColor);

        tvAvatar.setBackground(circle);
        tvAvatar.setTextColor(textColor);
    }

    private static String obtenerInicial(String valor) {
        if (valor == null) return "";
        String limpio = valor.trim();
        return limpio.isEmpty() ? "" : limpio.substring(0, 1);
    }
}