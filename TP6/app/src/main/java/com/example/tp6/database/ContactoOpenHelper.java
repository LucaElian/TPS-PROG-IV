package com.example.tp6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tp6.entidad.Contacto;
import com.example.tp6.entidad.TipoContacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacto.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLA_CONTACTOS = "contactos";

    public static final String COL_ID = "id_contacto";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APELLIDO = "apellido";
    public static final String COL_TELEFONO = "telefono";
    public static final String COL_TIPO_TELEFONO = "tipo_telefono";
    public static final String COL_MAIL = "mail";
    public static final String COL_TIPO_MAIL = "tipo_mail";
    public static final String COL_DIRECCION = "direccion";
    public static final String COL_FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String COL_NIVEL_ESTUDIOS = "nivel_estudios";

    public static final String COL_INTERES_DEPORTE = "interes_deporte";
    public static final String COL_INTERES_MUSICA = "interes_musica";
    public static final String COL_INTERES_ARTE = "interes_arte";
    public static final String COL_INTERES_TECNOLOGIA = "interes_tecnologia";

    public static final String COL_RECIBIR_INFORMACION = "recibir_informacion";

    public static final String CREAR_TABLA_CONTACTOS =
            "CREATE TABLE IF NOT EXISTS " + TABLA_CONTACTOS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOMBRE + " TEXT NOT NULL, " +
                COL_APELLIDO + " TEXT NOT NULL, " +
                COL_TELEFONO + " TEXT NOT NULL, " +
                COL_TIPO_TELEFONO + " TEXT NOT NULL, " +
                COL_MAIL + " TEXT NOT NULL, " +
                COL_TIPO_MAIL + " TEXT NOT NULL, " +
                COL_DIRECCION + " TEXT NOT NULL, " +
                COL_FECHA_NACIMIENTO + " TEXT NOT NULL, " +
                COL_NIVEL_ESTUDIOS + " TEXT NOT NULL, " +
                COL_INTERES_DEPORTE + " INTEGER NOT NULL DEFAULT 0, " +
                COL_INTERES_MUSICA + " INTEGER NOT NULL DEFAULT 0, " +
                COL_INTERES_ARTE + " INTEGER NOT NULL DEFAULT 0, " +
                COL_INTERES_TECNOLOGIA + " INTEGER NOT NULL DEFAULT 0, " +
                COL_RECIBIR_INFORMACION + " INTEGER NOT NULL DEFAULT 1" +
            ");";

    public static final String ELIMINAR_TABLA_CONTACTOS =
            "DROP TABLE IF EXISTS " + TABLA_CONTACTOS + ";";

    public ContactoOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ELIMINAR_TABLA_CONTACTOS);
        onCreate(db);
    }

    public long insertarContacto(Contacto contacto) {

        ContentValues values = new ContentValues();

        values.put(COL_NOMBRE, contacto.getNombre());
        values.put(COL_APELLIDO, contacto.getApellido());
        values.put(COL_TELEFONO, contacto.getTelefono());
        values.put(COL_TIPO_TELEFONO, contacto.getTipoTelefono().name());
        values.put(COL_MAIL, contacto.getMail());
        values.put(COL_TIPO_MAIL, contacto.getTipoMail().name());
        values.put(COL_DIRECCION, contacto.getDireccion());
        values.put(COL_FECHA_NACIMIENTO, contacto.getFechaNacimiento());
        values.put(COL_NIVEL_ESTUDIOS, contacto.getNivelEstudios());

        values.put(COL_INTERES_DEPORTE, contacto.isDeporte() ? 1 : 0);
        values.put(COL_INTERES_MUSICA, contacto.isMusica() ? 1 : 0);
        values.put(COL_INTERES_ARTE, contacto.isArte() ? 1 : 0);
        values.put(COL_INTERES_TECNOLOGIA, contacto.isTecnologia() ? 1 : 0);
        values.put(COL_RECIBIR_INFORMACION, contacto.isRecibirInfo() ? 1 : 0);

        return getWritableDatabase().insert(TABLA_CONTACTOS, null, values);
    }

    public List<Contacto> getListadoContactos() {

        ArrayList<Contacto> contactos = new ArrayList<>();

        Cursor cursor = getReadableDatabase().query(
            TABLA_CONTACTOS,
            null,
            null,
            null,
            null,
            null,
            null
        );

        if (cursor.moveToFirst()) {
            do {
                Contacto contacto = new Contacto();

                contacto.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)));
                contacto.setNombre(cursor.getString(cursor.getColumnIndexOrThrow(COL_NOMBRE)));
                contacto.setApellido(cursor.getString(cursor.getColumnIndexOrThrow(COL_APELLIDO)));

                contacto.setTelefono(cursor.getString(cursor.getColumnIndexOrThrow(COL_TELEFONO)));
                contacto.setTipoTelefono(TipoContacto.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(COL_TIPO_TELEFONO))));

                contacto.setMail(cursor.getString(cursor.getColumnIndexOrThrow(COL_MAIL)));
                contacto.setTipoMail(TipoContacto.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(COL_TIPO_MAIL))));

                contacto.setDireccion(cursor.getString(cursor.getColumnIndexOrThrow(COL_DIRECCION)));
                contacto.setFechaNacimiento(cursor.getString(cursor.getColumnIndexOrThrow(COL_FECHA_NACIMIENTO)));
                contacto.setNivelEstudios(cursor.getString(cursor.getColumnIndexOrThrow(COL_NIVEL_ESTUDIOS)));

                contacto.setDeporte(cursor.getInt(cursor.getColumnIndexOrThrow(COL_INTERES_DEPORTE)) == 1);
                contacto.setMusica(cursor.getInt(cursor.getColumnIndexOrThrow(COL_INTERES_MUSICA)) == 1);
                contacto.setArte(cursor.getInt(cursor.getColumnIndexOrThrow(COL_INTERES_ARTE)) == 1);
                contacto.setTecnologia(cursor.getInt(cursor.getColumnIndexOrThrow(COL_INTERES_TECNOLOGIA)) == 1);
                contacto.setRecibirInfo(cursor.getInt(cursor.getColumnIndexOrThrow(COL_RECIBIR_INFORMACION)) == 1);

                contactos.add(contacto);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return contactos;
    }
}