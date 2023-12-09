package com.example.urbanmarket.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.example.urbanmarket.R;
import com.example.urbanmarket.adapters.CategoryAdapter;
import com.example.urbanmarket.adapters.ImageSliderAdapter;
import com.example.urbanmarket.models.CategoryModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    RecyclerView catRecyclerview;

    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    FirebaseFirestore db;

    public InicioFragment() {
        // Constructor vacío requerido.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento.
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
        catRecyclerview = root.findViewById(R.id.rec_category);

         db = FirebaseFirestore.getInstance();

        // Configurar el ViewPager2
        ViewPager2 viewPager = root.findViewById(R.id.view_pager);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);

        // Adaptador personalizado para el ViewPager2
        ImageSliderAdapter imageSliderAdapter = new ImageSliderAdapter(imageList);
        viewPager.setAdapter(imageSliderAdapter);

        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryModelList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext(),categoryModelList);
        catRecyclerview.setAdapter(categoryAdapter);

        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                CategoryModel categoryModel = document.toObject(CategoryModel.class);
                                categoryModelList.add(categoryModel);
                                categoryAdapter.notifyDataSetChanged();

                            }
                            }
                        } else {

                    }
                        }



        return root;
    }
}
