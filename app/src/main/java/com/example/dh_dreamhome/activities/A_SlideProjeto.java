package com.example.dh_dreamhome.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dh_dreamhome.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

public class A_SlideProjeto extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide((Slide) new SimpleSlide.Builder()
                .title("Criando um projeto")
                .description("Vamos começar dando um nome ou projeto")
                .image(R.drawable.area)
                .background(R.color.DH_Fundo)
                .build()
        );
        addSlide((Slide) new SimpleSlide.Builder()
                .title("Criando um projeto")
                .description("Vamos começar dando um nome ou projeto")
                .image(R.drawable.area)
                .background(R.color.DH_Fundo)
                .build()
        );

    }
}