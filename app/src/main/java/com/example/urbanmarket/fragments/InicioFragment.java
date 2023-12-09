package com.example.urbanmarket.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.example.urbanmarket.R;
import com.example.urbanmarket.adapters.ImageSliderAdapter;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    public InicioFragment() {
        // Constructor vacío requerido.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento.
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Configurar el ViewPager2
        ViewPager2 viewPager = root.findViewById(R.id.view_pager);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);

        // Adaptador personalizado para el ViewPager2
        ImageSliderAdapter imageSliderAdapter = new ImageSliderAdapter(imageList);
        viewPager.setAdapter(imageSliderAdapter);

        return root;
    }
}
