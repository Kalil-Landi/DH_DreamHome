package com.example.dh_dreamhome.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.adapter.CardsAdapter;
import com.example.dh_dreamhome.model.Produtos;

import java.util.ArrayList;
import java.util.List;

public class A_ListaProdutos extends AppCompatActivity {
    //Elementos interface
    Button btFiltro, btOrdenar;
    private RecyclerView rvCards;

    //Objetos
    Produtos produto;
    List<Produtos> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alista_produtos);

        //botões
        btFiltro = findViewById(R.id.listaP_button_filtro);
        btOrdenar = findViewById(R.id.listaP_button_ordem);
        //recyclerView Cards
        rvCards = findViewById(R.id.listaP_recyclerview_cards);

        //Objetos
        produto = new Produtos();
        listaProdutos = new ArrayList<>();

        //configura recyclerView e adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(A_ListaProdutos.this);
        rvCards.setLayoutManager(layoutManager);
        CardsAdapter cardsAdapter = new CardsAdapter();
        rvCards.setAdapter(cardsAdapter);

        //Configura tamanho e define left drawable dos botões filtro e ordenar
        Drawable dFiltro = getResources().getDrawable(R.drawable.filter);
        Drawable dOrdenar = getResources().getDrawable(R.drawable.ordenar);
        dFiltro.setBounds(0,0,50,50);
        dOrdenar.setBounds(0,0,50,50);
        btFiltro.setCompoundDrawables(dFiltro,null,null,null);
        btOrdenar.setCompoundDrawables(dOrdenar,null,null,null);
    }
}