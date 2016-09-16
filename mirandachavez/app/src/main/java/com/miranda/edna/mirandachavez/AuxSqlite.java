package com.miranda.edna.mirandachavez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 15/09/2016.
 */

public class AuxSqlite extends SQLiteOpenHelper {

        public AuxSqlite (Context contexto, String mes, SQLiteDatabase.CursorFactory factory, int version) {
            super(contexto, mes, factory, version);
        }

        @Override
        public void onCreate (SQLiteDatabase db){
            //    db.execSQL("CREATE TABLE Usuarios (clave INTEGER, nombre TEXT)");
            db.execSQL("CREATE TABLE Cursos5 (clave INTEGER, mes TEXT, dia TEXT, fecha TEXT, fecha1 TEXT, fecha2 TEXT, fecha3 TEXT, nombre  TEXT, descripcion TEXT, duracion TEXT, horario TEXT, ordinario TEXT, costo TEXT, objetivo TEXT, requerimientos TEXT, temario TEXT, direccion TEXT)");
            //      db.execSQL("CREATE TABLE Cursos (clave INTEGER, mes INTEGER) ");

        }


        @Override
        public void onUpgrade (SQLiteDatabase db, int versionAnterior, int versionNueva) {
            //Se elimina la version anterior de la tabla
            db.execSQL("DROP TABLE IF EXISTS Cursos5");

            //Se crea la nueva version de la tabla
//        db.execSQL("CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)");
            db.execSQL("CREATE TABLE Cursos5 (clave INTEGER, mes TEXT, dia TEXT, fecha TEXT, fecha1 TEXT, fecha2 TEXT, fecha3 TEXT, nombre  TEXT, descripcion TEXT, duracion TEXT, horario TEXT, ordinario TEXT, costo TEXT, objetivo TEXT, requerimientos TEXT, temario TEXT, direccion TEXT)");
            //       db.execSQL("CREATE TABLE Cursos (clave INTEGER, mes TEXT) "
        }
        /**
         public void ArrayList llenar_lista(){
         java.util.ArrayList<String> lista = new ArrayList<>();
         SQLiteDatabase database = this.getWritableDatabase();
         String q = "SELECT * FROM Cursos4";
         Cursor registros = database.rawQuery(q, null);
         if(registros.moveToFirst())
         do {
         lista.add(registros.getString(0));
         }while (registros.moveToNext());
         return;
         **/

/**
 public ArrayList llenar_lv(){
 ArrayList<String> lista = new ArrayList<>();
 SQLiteDatabase database = this.getWritableDatabase();
 String q = "SELECT * FROM Cursos4";
 Cursor registros = database.rawQuery(q, null);
 if(registros.moveToFirst())
 do {
 lista.add(registros.getString(0));
 }while (registros.moveToNext());
 return lista;
 }
 **/
    }




