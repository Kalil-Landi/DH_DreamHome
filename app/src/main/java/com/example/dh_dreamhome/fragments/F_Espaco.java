package com.example.dh_dreamhome.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.adapter.MyAdapter;
import com.example.dh_dreamhome.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class F_Espaco extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    private RecyclerView rv_espaco;
    private RecyclerView.Adapter adapter_espaco;
    private RecyclerView.LayoutManager lay_mng_espaco;
    private List<String> mData;

    private Button btEspaco;
    public String strButton;


    public F_Espaco() {

    }

    public static F_Espaco newInstance(String param1, String param2) {
        F_Espaco fragment = new F_Espaco();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @SuppressLint({"SuspiciousIndentation", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_f, container, false);

        btEspaco = (Button) rootView.findViewById(R.id.produto_button_espaco);
        rv_espaco = rootView.findViewById(R.id.espaco_fragment_recyclerView);
        rv_espaco.setHasFixedSize(true);
        //rv_espaco.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)); TODO
        lay_mng_espaco = new LinearLayoutManager(getContext());
        rv_espaco.setLayoutManager(lay_mng_espaco);

        mData = new ArrayList<>();
            mData.add("Sala");
            mData.add("Sala de Jantar");
            mData.add("Cozinha");
            mData.add("Dispensa");
            mData.add("Quarto Casal");
            mData.add("Quarto");
            mData.add("Jardim");
            mData.add("Lavanderia");
            mData.add("Banheiro");
            mData.add("Hall de Entrada");
            mData.add("Arrumo");

            adapter_espaco = new MyAdapter(mData);
            rv_espaco.setAdapter(adapter_espaco);

        rv_espaco.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext(),
                rv_espaco,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        strButton = mData.get(position).toString();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

            return rootView;
    }

}