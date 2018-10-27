package ar.edu.utn.frsf.dam.isi.laboratorio02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import ar.edu.utn.frsf.dam.isi.laboratorio02.dao.PedidoRepository;
import ar.edu.utn.frsf.dam.isi.laboratorio02.modelo.Pedido;

public class MyReceiver extends BroadcastReceiver {
    public static final String evento = "ESTADO_ACEPTADO";
    int codProd;
    PedidoRepository repo = new PedidoRepository();
    Pedido pedi;

    @Override
    public void onReceive(Context context, Intent intent) {

        if ((intent.getAction()).equals("ESTADO_ACEPTADO")) {
            //Del repositorio traigo pedido con el "idPedido" que trae el intent
            pedi = repo.buscarPorId(intent.getExtras().getInt("idPedido"));

            Log.d("MSJ", "Recibido" + intent.getAction());
            Toast.makeText(context, "Pedido para"+ pedi.getMailContacto()+"ha cambiado de " +
                    "estado a ACEPTADO", Toast.LENGTH_SHORT).show();

        }
    }
}

