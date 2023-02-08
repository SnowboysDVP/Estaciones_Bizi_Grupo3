package com.ijuste.estaciones_bizi_grupo3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.bbdd.EstacionesADO;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;

import java.util.List;

public class FichaEstacionActivity extends AppCompatActivity implements View.OnClickListener {

    private int [] textviews={R.id.txtId,R.id.txtAboot,R.id.txtTitle,R.id.txtEstado,R.id.txtEstadoEstacion,R.id.txtAdress,
            R.id.txtTipoEquipamiento,R.id.txtBicisDisp,R.id.txtAnclajesDisp,R.id.txtUltimaActualizacion,
            R.id.txtDescription,R.id.txtDescripcion,R.id.txtIcon,R.id.txtType,R.id.txtCoordinates};
    private TextView[]nombretextview= new TextView[textviews.length];
    private int[]botones={R.id.imgAtras,R.id.imgDelante};
    private ImageView[]nombrebotones=new ImageView[botones.length];
    private int posicion;
    private List<EstacionBici> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_estacion);

        iniciarComponentes(textviews,nombretextview,botones,nombrebotones);

        Intent intento= getIntent();
        posicion=intento.getIntExtra("posicion",0);
        lista = (List<EstacionBici>) intento.getSerializableExtra("array");

        mostrarDatos();

        nombrebotones[0].setOnClickListener(this::onClick);
        nombrebotones[1].setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View view) {

        if (view == nombrebotones[0]) {
            if(posicion==0){
                aviso();
            }else{
                posicion--;
            }
            // Atras

        }else if (view == nombrebotones[1]) {
            if(posicion==lista.size()-1){
                aviso();
            }else {
                // Adelante
                posicion++;
            }
        }

            mostrarDatos();
    }

    private void iniciarComponentes(int[]idview, TextView[]nombreview, int[]idimagen, ImageView[]imagenes){

        for(int i=0;i< idview.length;i++){
            nombreview[i]=findViewById(idview[i]);
        }
        for(int x=0;x<imagenes.length;x++){
            imagenes[x]=findViewById(idimagen[x]);
        }
    }

    private void mostrarDatos(){
        nombretextview[0].setText(String.valueOf(lista.get(posicion).getId()));
        nombretextview[1].setText(lista.get(posicion).getAbout());
        nombretextview[2].setText(lista.get(posicion).getTitle());
        nombretextview[3].setText(lista.get(posicion).getEstado());
        nombretextview[4].setText(lista.get(posicion).getEstadoEstacion());
        nombretextview[5].setText(lista.get(posicion).getAddress());
        nombretextview[6].setText(lista.get(posicion).getTipoEquipamiento());
        nombretextview[7].setText(String.valueOf(lista.get(posicion).getBicisDisponibles()));
        nombretextview[8].setText(String.valueOf(lista.get(posicion).getAnclajesDisponibles()));
        nombretextview[9].setText(lista.get(posicion).getLastUpdated());
        nombretextview[10].setText(lista.get(posicion).getDescription());
        nombretextview[11].setText(lista.get(posicion).getDescripcion());
        nombretextview[12].setText(lista.get(posicion).getIcon());
        nombretextview[13].setText(lista.get(posicion).getGeometry().getType());
        nombretextview[14].setText(lista.get(posicion).getGeometry().getCoordinates()[0]+" "+
                                    lista.get(posicion).getGeometry().getCoordinates()[1]);
    }
    private void aviso(){
        Toast.makeText(this, "No hay mas registros", Toast.LENGTH_LONG).show();
    }
}