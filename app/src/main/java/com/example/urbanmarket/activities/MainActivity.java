package com.example.urbanmarket.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.urbanmarket.R;
import com.example.urbanmarket.fragments.InicioFragment;

public class MainActivity extends AppCompatActivity {

    Fragment InicioFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicioFragment = new InicioFragment();
        loadFragment(InicioFragment);
    }

    private void loadFragment(Fragment inicioFragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,InicioFragment);
        transaction.commit();

    }
}