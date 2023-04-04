package com.example.dh_dreamhome.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.adapter.MyAdapter;
import com.example.dh_dreamhome.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class F_Pessoa extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    private RecyclerView rv_pessoa;
    private RecyclerView.Adapter adapter_espaco;
    private RecyclerView.LayoutManager lay_mng_espaco;
    private List<String> mData;

    public String strButton;


    public F_Pessoa() {

    }

    public static F_Pessoa newInstance(String param1, String param2) {
        F_Pessoa fragment = new F_Pessoa();
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

    @SuppressLint("SuspiciousIndentation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_f, container, false);

        rv_pessoa = rootView.findViewById(R.id.espaco_fragment_recyclerView);
        rv_pessoa.setHasFixedSize(true);
        //rv_espaco.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)); TODO
        lay_mng_espaco = new LinearLayoutManager(getContext());
        rv_pessoa.setLayoutManager(lay_mng_espaco);

        mData = new ArrayList<>();
            mData.add("Comum");
            mData.add("Casal");
            mData.add("André");

            adapter_espaco = new MyAdapter(mData);
        rv_pessoa.setAdapter(adapter_espaco);

        rv_pessoa.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext(),
                rv_pessoa,
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