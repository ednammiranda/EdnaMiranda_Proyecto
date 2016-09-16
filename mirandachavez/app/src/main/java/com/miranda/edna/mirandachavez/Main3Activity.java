package com.miranda.edna.mirandachavez;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    Button btnInscribirse;
    Button btnRegresar1;
    Spinner cboDatos;
    TextView mesconsulta;
    TextView mes;
    TextView dia;
    TextView fecha;
    TextView fecha1;
    TextView fecha2;
    TextView fecha3;
    TextView nombre;
    TextView descripcion;
    TextView duracion;
    TextView horario;
    TextView costo;
    TextView objetivo;
    TextView requerimientos;
    TextView temario;
    TextView direccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

   /****************************************************************************************************************
   *  Se generan strings en donde guarda los datos que se van a obtener de la consulta del curso seleccionado
   *******************************************************************************************************************/
/**
        String[] campos = new String[] {"mes", "dia", "fecha", "fecha1", "fecha2", "fecha3", "nombre", "descripcion", "duracion", "horario", "costo", "objetivo", "requerimientos", "temario", "direccion"};
        String[] args = new String[] {"clave"};
**/

 /****************************************************************************************************************
  *   Se relacionan todos los EditText del xml con el codigo java
  ****************************************************************************************************************/

        mes = (EditText) findViewById(R.id.mes);
        dia = (EditText) findViewById(R.id.dia);
        fecha = (EditText) findViewById(R.id.fecha);
        fecha1 = (EditText) findViewById(R.id.fecha1);
        fecha2 = (EditText) findViewById(R.id.fecha2);
        fecha3 = (EditText) findViewById(R.id.fecha3);
        nombre = (EditText) findViewById(R.id.nombre);
        descripcion = (EditText) findViewById(R.id.descripcion);
        duracion = (EditText) findViewById(R.id.duracion);
        horario = (EditText) findViewById(R.id.horario);
        costo = (EditText) findViewById(R.id.costo);
        objetivo = (EditText) findViewById(R.id.objetivo);
        requerimientos = (EditText) findViewById(R.id.requerimientos);
        temario = (EditText) findViewById(R.id.temario);
        direccion = (EditText) findViewById(R.id.direccion);

 /**************************************************************************************
 *     Recibe de la ventana principal la clave (mes) del  curso a consultar
 ***************************************************************************************/
/**
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle!=null){
            String fecharecep = (String)bundle.get("FECHA");
            mesconsulta.setText(fecharecep);
        }
/*************************************************************************************************
 *   Abre la base de datos
 * ***********************************************************************************************/
        AuxSqlite cmd = new AuxSqlite(this, "DBCursos5", null, 1);
        SQLiteDatabase db = cmd.getReadableDatabase();

   /**************************************************************************************************
    * Codigo para  recorrer y desplegar toda la base de datos, en caso de utilizar un ListView
    *
    * Este codigo esta incompleto
   **********************************************************************************************/

  //     Cursor c = db.query("DBCursos5", campos, "mes=?", args, null, null, null);
  //         if (c.moveToFirst()) {
 //           do {
 //               String mes= c.getString(0);
//               String dia = c.getString(1);
//              .....
//           } while(c.moveToNext());

//         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) lv);
 //        lv.setAdapter(arrayAdapter);
 //


 /**************************************************************************************************************
 *   Codigo para desplegar un curso seleccionado,
  *
  *  Se recibe la clave (mes) del curso elegido de la actividad principal (en la funcion onCreate)
  *
  *   Se ejecuta la instruccion la cual accede a la base de datos y trae el registro
  *      Cursor c = db.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE mes='mesconsulta' ", null);
  *
  *   Mueve los datos del String a los TextView de la actividad
  *
  *   Cierra la base de datos
  ************************************************************************************* */
  /**
        Cursor c = db.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE mes='mesconsulta' ", null);
                String mes= c.getString(0);
                String dia = c.getString(1);
                String fecha= c.getString(2);
                String fecha1 = c.getString(3);
                String fecha2 = c.getString(4);
                String fecha3 = c.getString(5);
                String nombre = c.getString(6);
                String descripcion = c.getString(7);
                String duracion = c.getString(8);
                String horario = c.getString(9);
                String costo = c.getString(10);
                String objetivo = c.getString(11);
                String requerimientos = c.getString(12);
                String temario = c.getString(13);
                String direccion = c.getString(14);

        db.close();
**/
        }


    /*************************************************************************************
     *    Al oprimir el boton REGRESAR despliega la ventana principal
     *************************************************************************************/

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnRegresar1:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;


 /**********************************************************************************************
 *  Al oprimir el boton INSCRIBIRSE va a la pagina de It-OkCenter, al calendario
 ************************************************************************************************/


            case R.id.btnInscribirse:
                Uri uriUrl = Uri.parse("http://www.it-okcenter.com/calendario/");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent1);
                break;

            default:
                break;
        }

    }
}