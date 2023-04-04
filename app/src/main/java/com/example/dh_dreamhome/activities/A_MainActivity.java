package com.example.dh_dreamhome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dh_dreamhome.R;
import com.ramotion.circlemenu.CircleMenuView;

public class A_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CircleMenuView menu = (CircleMenuView) findViewById(R.id.circle_menu);

        menu.setEventListener(new CircleMenuView.EventListener() {
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.i("CMV_INFO", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.i("CMV_INFO", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.i("CMV_INFO", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.i("CMV_INFO", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.i("CMV_INFO", "onButtonClickAnimationStart| index: " + index);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(index == 0) {
                            startActivity(new Intent(A_MainActivity.this, A_Produto.class));
                        }
                        if(index == 1) {
                            startActivity(new Intent(A_MainActivity.this, A_ListaProdutos.class));
                        }
                        if(index == 2) {
                            startActivity(new Intent(A_MainActivity.this, A_SlideProjeto.class));
                        }
                    }
                }, 650);
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.i("CMV_INFO", "onButtonClickAnimationEnd| index: " + index);

            }
        });
    }
}