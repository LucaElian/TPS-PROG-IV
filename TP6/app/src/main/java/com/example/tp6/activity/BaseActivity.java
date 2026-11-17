package com.example.tp6.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp6.R;
import com.example.tp6.database.ContactoOpenHelper;

public abstract class BaseActivity extends AppCompatActivity {

    protected ContactoOpenHelper bd;

    protected abstract int getLayoutResource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(getLayoutResource());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {

                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

                    view.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        bd = new ContactoOpenHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_agregar_contacto) {

            if (!(this instanceof AgregarContactoActivity)) {
                Intent intent =
                        new Intent(this, AgregarContactoActivity.class);

                startActivity(intent);
            }

            return true;
        }

        if (id == R.id.menu_listado_contactos) {

            if (!(this instanceof ListadoContactosActivity)) {
                Intent intent =
                        new Intent(this, ListadoContactosActivity.class);

                startActivity(intent);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        if (bd != null) {
            bd.close();
        }

        super.onDestroy();
    }
}