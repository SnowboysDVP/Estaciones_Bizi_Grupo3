package com.ijuste.estaciones_bizi_grupo3.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.databinding.ActivityMapaBinding;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapaBinding binding;
    private Float latitud;
    private Float longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent=getIntent();
        latitud=intent.getFloatExtra("latitud",0);
        longitud=intent.getFloatExtra("longitud",0);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera


        LatLng zaragoza = new LatLng(longitud, latitud);

        mMap.getUiSettings().setZoomControlsEnabled(true);


        MarkerOptions marker = new MarkerOptions();
        marker.title("Estación");
        marker.snippet("Ubicación de la estación seleccionada");
        marker.position(zaragoza);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(zaragoza));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(18));
        mMap.addMarker(marker);
    }
}