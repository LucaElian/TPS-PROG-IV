package com.example.tp6.activity;

import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import com.example.tp6.R;
import com.example.tp6.database.ContactoOpenHelper;

public abstract class BaseActivity extends AppCompatActivity {

    protected ContactoOpenHelper bd;

    protected abstract int getLayoutResource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(
                this,
                SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        );
        setContentView(getLayoutResource());
        WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView())
                .setAppearanceLightStatusBars(false);

        View mainView = findViewById(R.id.main);
        int padLeft = mainView.getPaddingLeft();
        int padTop = mainView.getPaddingTop();
        int padRight = mainView.getPaddingRight();
        int padBottom = mainView.getPaddingBottom();

        ViewCompat.setOnApplyWindowInsetsListener(mainView, (view, insets) -> {

                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

                    view.setPadding(
                            padLeft + systemBars.left,
                            padTop + systemBars.top,
                            padRight + systemBars.right,
                            padBottom + systemBars.bottom
                    );

                    return insets;
                }
        );

        bd = new ContactoOpenHelper(this);
    }

    protected void iniciarAuroraAnimada(View vista) {
        if (vista == null || !ValueAnimator.areAnimatorsEnabled()) return;

        Drawable fondo = vista.getBackground();
        if (fondo instanceof AnimationDrawable) {
            AnimationDrawable anim = (AnimationDrawable) fondo;
            anim.setEnterFadeDuration(2400);
            anim.setExitFadeDuration(2400);
            vista.post(anim::start);
        }
    }

    protected void animarEntradaStaggered(ViewGroup contenedor) {
        if (contenedor == null || !ValueAnimator.areAnimatorsEnabled()) return;

        float desplazamiento = 18f * getResources().getDisplayMetrics().density;
        FastOutSlowInInterpolator interpolator = new FastOutSlowInInterpolator();

        for (int i = 0; i < contenedor.getChildCount(); i++) {
            View hijo = contenedor.getChildAt(i);
            hijo.setAlpha(0f);
            hijo.setTranslationY(desplazamiento);
            hijo.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(260)
                    .setStartDelay(i * 45L)
                    .setInterpolator(interpolator)
                    .start();
        }
    }

    protected void navegarConTransicion(Intent intent) {
        if (ValueAnimator.areAnimatorsEnabled()) {
            Bundle opciones = ActivityOptions.makeCustomAnimation(
                    this,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
            ).toBundle();
            startActivity(intent, opciones);
        } else {
            startActivity(intent);
        }
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

                navegarConTransicion(intent);
            }

            return true;
        }

        if (id == R.id.menu_listado_contactos) {

            if (!(this instanceof ListadoContactosActivity)) {
                Intent intent =
                        new Intent(this, ListadoContactosActivity.class);

                navegarConTransicion(intent);
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