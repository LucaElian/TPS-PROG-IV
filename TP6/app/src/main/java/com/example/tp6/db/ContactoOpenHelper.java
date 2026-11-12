package com.example.tp6.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class ContactoOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TP6.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLA_CONTACTOS = "contactos";

    public static final String COL_ID = "id_contacto";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APELLIDO = "apellido";
    public static final String COL_TELEFONO = "telefono";
    public static final String COL_TIPO_TELEFONO = "tipo_telefono";
    public static final String COL_EMAIL = "email";
    public static final String COL_TIPO_EMAIL = "tipo_email";
    public static final String COL_DIRECCION = "direccion";
    public static final String COL_FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String COL_NIVEL_ESTUDIOS = "nivel_estudios";

    public static final String COL_INTERES_DEPORTE = "interes_deporte";
    public static final String COL_INTERES_MUSICA = "interes_musica";
    public static final String COL_INTERES_ARTE = "interes_arte";
    public static final String COL_INTERES_TECNOLOGIA = "interes_tecnologia";

    public static final String COL_RECIBIR_INFORMACION = "recibir_informacion";

    public static final String CREAR_TABLA_CONTACTOS = "CREATE TABLE " + TABLA_CONTACTOS + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NOMBRE + " TEXT NOT NULL, " +
            COL_APELLIDO + " TEXT NOT NULL, " +
            COL_TELEFONO + " TEXT, " +
            COL_TIPO_TELEFONO + " TEXT, " +
            COL_EMAIL + " TEXT, " +
            COL_TIPO_EMAIL + " TEXT, " +
            COL_DIRECCION + " TEXT, " +
            COL_FECHA_NACIMIENTO + " TEXT, " +
            COL_NIVEL_ESTUDIOS + " TEXT, " +
            COL_INTERES_DEPORTE + " INTEGER DEFAULT 0, " +
            COL_INTERES_MUSICA + " INTEGER DEFAULT 0, " +
            COL_INTERES_ARTE + " INTEGER DEFAULT 0, " +
            COL_INTERES_TECNOLOGIA + " INTEGER DEFAULT 0, " +
            COL_RECIBIR_INFORMACION + " INTEGER DEFAULT 1);";

    public static final String ELIMINAR_TABLA_CONTACTOS = "DROP TABLE IF EXISTS " + TABLA_CONTACTOS + ";";

    public ContactoOpenHelper(@Nullable Context context) {
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
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOMBRE, contacto.nombre);
        values.put(COL_NOMBRE, contacto.getNombre());
        values.put(COL_APELLIDO, contacto.getApellido());
        values.put(COL_TELEFONO, contacto.getTelefono());
        values.put(COL_TIPO_TELEFONO, contacto.getTipoTelefono());
        values.put(COL_EMAIL, contacto.getEmail());
        values.put(COL_TIPO_EMAIL, contacto.getTipoEmail());
        values.put(COL_DIRECCION, contacto.getDireccion());
        values.put(COL_FECHA_NACIMIENTO, contacto.getFechaNacimiento());
        values.put(COL_NIVEL_ESTUDIOS, contacto.getNivelEstudios());

        values.put(COL_INTERES_DEPORTE, contacto.getInteresDeporte() ? 1 : 0);
        values.put(COL_INTERES_MUSICA, contacto.getInteresMusica() ? 1 : 0);
        values.put(COL_INTERES_ARTE, contacto.getInteresArte() ? 1 : 0);
        values.put(COL_INTERES_TECNOLOGIA, contacto.getInteresTecnologia() ? 1 : 0);
        values.put(COL_RECIBIR_INFORMACION, contacto.getRecibirInformacion() ? 1 : 0);
        long id = db.insert(TABLA_CONTACTOS, null, values);
        db.close();
        return id;
    }
}

