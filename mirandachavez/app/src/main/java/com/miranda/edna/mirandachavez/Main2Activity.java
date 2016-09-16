package com.miranda.edna.mirandachavez;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {

    EditText editText1;
    ImageView imageView;
    Button btnEliminar;
    Spinner cboDatos;
    Button btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

 /**************************************************************************************
  *   Muestra todas las claves de los registros cargados en la Base de Datos en un Spinner
  *
  *   Abre la base de datos, busca los registros almacenados y copia la clave del mes
  *      en el Spinner
  ************************************************************************************/

        cboDatos = (Spinner) findViewById(R.id.cboDatos);


        AuxSqlite cmd = new AuxSqlite(this, "DBCursos5", null, 1);
        SQLiteDatabase db = cmd.getReadableDatabase();

        if (db != null) {
            Cursor c = db.rawQuery("SELECT mes FROM Cursos5", null);

            if (c.moveToFirst()) {
                String [] mes = new String[(c.getCount())];
                int i = 0;
                do {
                    mes[i] = c.getString(0);
                    i++;
                } while (c.moveToNext());

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mes);
                cboDatos.setAdapter(adapter);
            }
        }
        db.close();

               inicializaComponentes();
    }

/***************************************************************************************************
 *   Inicializa y llama a la funcion de eliminar
 *
 *   La funcion de agregar y actualizar (cambiar) estan funcionando por eso se dejo el codigo
 *      sin embargo se considero que el Usuario no deberia poder insertar, ni cambiar los datos,
 *      unicamente el poder borrarlos
 *
 * ************************************************************************************************/

    private void inicializaComponentes() {
//        btnAgregar = (Button) findViewById(R.id.btnAgregar);
//        txtAgregar = (EditText) findViewById(R.id.txtAgregar);

//        datePicker = (DatePicker) findViewById(R.id.datepicker);

        editText1 = (EditText) findViewById(R.id.editText1);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        cboDatos = (Spinner) findViewById(R.id.cboDatos);


         btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                btnEliminar_onClick();
            }
        });


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                btnRegresar_onClick();
            }
        });
    }


 /*****************************************************************************************************/
/**  El codigo para agregar un registro en la base de datos esta comentarizado porque se agregaron los
 *   registros y sus atributos de forma predefinida, este codigo funciona correctamente
 *
 *   Y se considero que el usuario no deberia poder agregar registros
 *
 *    --- Se abre la base de datos de forma escritura
 *
 *                      AuxSqlite cmd = new AuxSqlite(this, "DBCursos5", null, 1);
 *                      SQLiteDatabase db = cmd.getWritableDatabase();
 *    --- Acepta hasta 100 registros
 *
 *    --- Se copia el contenido de un EditText en el campo de la base de datos
 *
 *    --- Con el comando INSERT se graba la informacion en la base de datos
 ****************************************************************************************************/
  /**
             private void btnAgregar_onClick() {
             AuxSqlite cmd = new AuxSqlite(this, "DBCursos5", null, 1);
             SQLiteDatabase db = cmd.getWritableDatabase();

             if (db != null) {
             int clave = new Random().nextInt(100);

             String mes  = Integer.parseInt(this.txtmes.getText().toString());
             String dia = Integer.parseInt(this.txtdia.getText().toString());
             String fecha = this.txtfecha.getText().toString();
             String fecha1 = this.txtfecha1.getText().toString();
             String fecha2 = this.txtFecha2.getText().toString();
             String fecha3 = this.txtFecha3.getText().toString();
             String nombre = this.txtNombre.getText().toString();
             String descripcion = this.txtdescripcion.getText().toString();
             String duracion = this.txtduracion.getText().toString();
             String horario = this.txthorario.getText().toString();
             String ordinario = this.txtordinario.getText().toString();
             String costo = this.txtcosto.getText().toString();
             String objetivo = this.txtobjetivo.getText().toString();
             String requerimientos = this.txtrequerimientos.getText().toString();
             String temario = this.txttemario.getText().toString();
             String direccion = this.txtdireccion.getText().toString();

             db.execSQL("INSERT INTO Cursos (clave, mes, dia, nombre, descripcion, duracion, horario, ordinario, costo, objetivo, requerimientos, temario, descripcion) " +
             "VALUES (" + clave + ",  '" + mes + "', '" + dia + "', '" + fecha + "', '" + fecha1 + "', '" + fecha2 + "',  '" + fecha3 + "', '" + nombre + "', '" + descripcion + "',  '" + duracion + "', '" + horario + "', '" + ordinario + "',  '" + costo + "' , '" + objetivo + "', '" + requerimientos + "', '" + temario + "', '" + direccion + "')");
             }
             db.close();
             }
   **/


    /************************************************************************************************
     * Funcion para eliminar registros de la base de datos
     *
     *         .Se Abre la base de datos de forma escritura DBCursos5
     *                 AuxSqlite cmd = new AuxSqlite(this, "DBCursos5", null, 1);
     *                 SQLiteDatabase db = cmd.getWritableDatabase();
     *         .Se toma la clave seleccionada del Spinner
     *                 String mes = cboDatos.getSelectedItem().toString();
     *         .Se da delete al registro con la clave seleccionada en el Spinner
     *                 db.execSQL("DELETE FROM Cursos5 WHERE mes = '" + mes + "'");
     *         .Se refresca el Spinner para observar que no existe el registro
     *         .Se cierra la base de datos
     ***********************************************************************************************/

            private void btnEliminar_onClick() {


                AuxSqlite cmd = new AuxSqlite(this, "DBCursos5", null, 1);
                SQLiteDatabase db = cmd.getWritableDatabase();

                if (db != null && cboDatos.getSelectedItem() != null) {

                    String mes = cboDatos.getSelectedItem().toString();

                    db.execSQL("DELETE FROM Cursos5 WHERE mes = '" + mes + "'");
                }

   /******************************************************************************************
    *   se refresca el contenido del Spinner, iniciando en el primer registro
    *            if (c.moveToFirst())
    *   despues al siguiente
    *           (c.moveToNext());
    *   hasta que no existan mas registros
    *           if (db != null)
    ******************************************************************************************/

                cboDatos.setAdapter(null);

                if (db != null) {
                    Cursor c = db.rawQuery("SELECT mes FROM Cursos5", null);

                    if (c.moveToFirst()) {
                        //                  String[] nombres = new String[c.getCount()];
                        String [] mes = new String[(c.getCount())];
                        int i = 0;
                        do {
                            mes[i] = c.getString(0);
                            i++;
                        } while (c.moveToNext());


                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mes);
                        cboDatos.setAdapter(adapter);
                    }
                }
                db.close();

            }

    /****************************************************************************************
     * Cuando se da clic al boton Regresa a la ventana principal MainActivity
     *            .Indica que debe ir en este caso a la actividad principal (MainActivity)
     *                    - Intent intent3 = new Intent (this, MainActivity.class)
     *            .Inicia la actividad -  startActivity(intent3);
     ****************************************************************************************/

            private void btnRegresar_onClick() {
                Intent intent3 = new Intent (this, MainActivity.class);
                startActivity(intent3);
            }
     }
