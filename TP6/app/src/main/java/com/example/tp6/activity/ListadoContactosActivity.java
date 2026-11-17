package com.example.tp6.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tp6.R;
import com.example.tp6.entidad.Contacto;

import java.util.List;

public class ListadoContactosActivity extends BaseActivity {

    private ListView lvContactos;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_listado_contactos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lvContactos = findViewById(R.id.lvContactos);

        List<Contacto> contactos = bd.getListadoContactos();

        ArrayAdapter<Contacto> adapterContactos =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        contactos
                );

        lvContactos.setAdapter(adapterContactos);
    }
}