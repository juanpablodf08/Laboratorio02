package ar.edu.utn.frsf.dam.isi.laboratorio02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

import static ar.edu.utn.frsf.dam.isi.laboratorio02.R.*;

public class producto_activity extends AppCompatActivity {

    TextView estado;
    Spinner listaEntradas;
    ListView ListViewProductos;
    int botonElegido;
    Button btnAgregarPedido;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_producto_activity);

        final Bundle miBundle = this.getIntent().getExtras();

        estado = (TextView) findViewById(id.idSeleccionar);
        listaEntradas = (Spinner) findViewById(id.idSpinnerProductos);
        ListViewProductos = (ListView) findViewById(id.idListViewLista);
        botonElegido = miBundle.getInt("NUEVO_PEDIDO");
        btnAgregarPedido= findViewById(id.idBotonAgregar);



       // if (botonElegido==1){
         //    idIngCantidad.setEnable(true);
          //   btnAgregarPedido.setEnable(true);
        //};






        //TRAIGO VALOR SELECCIONADO EN SPINNER
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                array.opciones_productos, android.R.layout.simple_spinner_item);

        listaEntradas.setAdapter(adapter);

        listaEntradas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> lista, View view, int pos, long id) {

            if(lista.getItemAtPosition(pos).equals("MENU1"))
            {   ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(producto_activity.this,
                    array.menu_1, android.R.layout.simple_list_item_1);
                ListViewProductos.setAdapter(listaAdapter);

            }
            if(lista.getItemAtPosition(pos).equals("MENU2"))
            {   ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(producto_activity.this,
                    array.menu_2, android.R.layout.simple_list_item_1);
                ListViewProductos.setAdapter(listaAdapter);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
        });



        btnAgregarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miBundle.putInt("cantidad", id.idTextCantidad);
               // miBundle.putInt("idProducto",idProducto); VER COMO PASO ID PRODUCTO
            }
        });


    }

}
