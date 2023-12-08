package com.example.urbanmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class IncorporacionActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button btn;
    SliderAdapter sliderAdapter;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_incorporacion);

        viewPager = findViewById(R.id.slider);
        btn = findViewById(R.id.e_btn);

        viewPager.addOnPageChangeListener(changeListener);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IncorporacionActivity.this, RegistrarActivity.class));
                finish();
            }
        });
    }
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

        }

        @Override
        public void onPageSelected(int position) {

            if (position == 0){
                btn.setVisibility(View.INVISIBLE);
            }else if (position == 1){
                btn.setVisibility(View.INVISIBLE);
            }else {
                animation = AnimationUtils.loadAnimation(IncorporacionActivity.this,R.anim.s_anim);
                btn.setAnimation(animation);
                btn.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}