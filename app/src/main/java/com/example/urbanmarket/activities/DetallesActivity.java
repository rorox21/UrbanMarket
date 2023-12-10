package com.example.urbanmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.urbanmarket.R;
import com.example.urbanmarket.models.NewProductsModel;
import com.example.urbanmarket.models.PopularProductsModel;
import com.example.urbanmarket.models.ShowAllModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetallesActivity extends AppCompatActivity implements OnMapReadyCallback {

    ImageView detailedImg;
    TextView name, price;
    MapView mapView;

    NewProductsModel newProductsModel = null;
    PopularProductsModel popularProductsModel = null;
    ShowAllModel showAllModel = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        final Object obj = getIntent().getSerializableExtra("detailed");

        if (obj instanceof NewProductsModel) {
            newProductsModel = (NewProductsModel) obj;
        } else if (obj instanceof PopularProductsModel) {
            popularProductsModel = (PopularProductsModel) obj;
        } else if (obj instanceof ShowAllModel) {
            showAllModel = (ShowAllModel) obj;
        }

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        detailedImg = findViewById(R.id.detailed_img);
        name = findViewById(R.id.detailed_name);
        price = findViewById(R.id.detailed_price);

        cargarInformacionProducto();
    }

    private void cargarInformacionProducto() {
        if (newProductsModel != null) {
            Glide.with(getApplicationContext()).load(newProductsModel.getImg_url()).into(detailedImg);
            name.setText(newProductsModel.getName());
            price.setText(String.valueOf(newProductsModel.getPrice()));
        }

        if (popularProductsModel != null) {
            Glide.with(getApplicationContext()).load(popularProductsModel.getImg_url()).into(detailedImg);
            name.setText(popularProductsModel.getName());
            price.setText(String.valueOf(popularProductsModel.getPrice()));
        }

        if (showAllModel != null) {
            Glide.with(getApplicationContext()).load(showAllModel.getImg_url()).into(detailedImg);
            name.setText(showAllModel.getName());
            price.setText(String.valueOf(showAllModel.getPrice()));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng ubicacionTienda = new LatLng(-36.601058478112215, -72.1063224565085);

        googleMap.addMarker(new MarkerOptions().position(ubicacionTienda).title("Ubicación tienda"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionTienda, 10f));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
