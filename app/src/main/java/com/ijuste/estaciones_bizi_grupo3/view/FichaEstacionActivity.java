package com.ijuste.estaciones_bizi_grupo3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        EstacionesADO miestaciones= new EstacionesADO(this);
        lista= miestaciones.getAll();
        Intent intento= new Intent();
        posicion=intento.getIntExtra("posicion",0);



    }

    @Override
    public void onClick(View view) {
        if (view == nombrebotones[0]) {
            // Atras
            posicion--;
        }
        else if (view == nombrebotones[1]) {
            // Adelante
            posicion++;
        }
        if(posicion==nombretextview.length){
            nombrebotones[1].setEnabled(false);
        }else if(posicion==0){
            nombrebotones[0].setEnabled(false);
        }else{
            nombrebotones[0].setEnabled(true);
            nombrebotones[1].setEnabled(true);
        }

            nombretextview[0].setText(String.valueOf(lista.get(posicion).getId()));
            nombretextview[1].setText(String.valueOf(lista.get(posicion).getAbout()));
            nombretextview[2].setText(String.valueOf(lista.get(posicion).getTitle()));
            nombretextview[3].setText(String.valueOf(lista.get(posicion).getEstado()));
            nombretextview[4].setText(String.valueOf(lista.get(posicion).getEstadoEstacion()));
            nombretextview[5].setText(String.valueOf(lista.get(posicion).getAddress()));
            nombretextview[6].setText(String.valueOf(lista.get(posicion).getTipoEquipamiento()));
            nombretextview[7].setText(String.valueOf(lista.get(posicion).getBicisDisponibles()));
            nombretextview[8].setText(String.valueOf(lista.get(posicion).getAnclajesDisponibles()));
            nombretextview[9].setText(String.valueOf(lista.get(posicion).getLastUpdated()));
            nombretextview[10].setText(String.valueOf(lista.get(posicion).getDescription()));
            nombretextview[11].setText(String.valueOf(lista.get(posicion).getDescripcion()));
            nombretextview[12].setText(String.valueOf(lista.get(posicion).getIcon()));
            nombretextview[13].setText(String.valueOf(lista.get(posicion).getGeometry().getType()));
            nombretextview[14].setText(String.valueOf(lista.get(posicion).getGeometry().getCoordinates()));


    }
    private void iniciarComponentes(int[]idview, TextView[]nombreview, int[]idimagen, ImageView[]imagenes){

        for(int i=0;i< idview.length;i++){
            nombreview[i]=findViewById(idview[i]);
        }
        for(int x=0;x<imagenes.length;x++){
            imagenes[x]=findViewById(idimagen[x]);
        }
    }
}