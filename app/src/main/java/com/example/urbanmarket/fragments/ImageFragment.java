package com.example.urbanmarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.urbanmarket.R;

public class ImageFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    public ImageFragment() {
        // Constructor vacío requerido
    }

    public static ImageFragment newInstance(int position) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.image_view);

        // Puedes establecer la imagen según la posición del fragmento o de otra manera
        int position = requireArguments().getInt(ARG_POSITION);
        switch (position) {
            case 0:
                imageView.setImageResource(R.drawable.banner1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.banner2);
                break;
            case 2:
                imageView.setImageResource(R.drawable.banner3);
                break;
        }
    }
}
