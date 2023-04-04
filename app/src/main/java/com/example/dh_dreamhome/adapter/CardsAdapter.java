package com.example.dh_dreamhome.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.model.Produtos;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {

    //private Produtos produto;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cardLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_adapter, parent, false);
        return new MyViewHolder(cardLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //String sPrecoXQuantidade = produto.getPdtPreco().toString() + "€ x " + produto.getPdtQuantidade() + " Und";
        //String sTotal = produto.getPdtTotal().toString() + "€";

        //holder.tvDescricao.setText(produto.getPdtDescricao());
       // holder.tvLoja.setText(produto.getPdtLoja());
        //holder.tvPrecoXquantidade.setText(sPrecoXQuantidade);
        //holder.tvTotal.setText(sTotal);

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDescricao, tvLoja,
                tvPrecoXquantidade, tvTotal;

        private ImageView ivProduto, ivPrioridade1, ivPrioridade2,
                ivPrioridade3, ivPrioridade4, ivPrioridade5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //TextView
            tvDescricao = itemView.findViewById(R.id.card_textView_descricao);
            tvLoja = itemView.findViewById(R.id.card_textView_loja);
            tvPrecoXquantidade = itemView.findViewById(R.id.card_textView_precoXquatidade);
            tvTotal = itemView.findViewById(R.id.card_textView_total);
            //ImageView
            ivProduto = itemView.findViewById(R.id.card_imageView_produtoImage);
            ivPrioridade1 = itemView.findViewById(R.id.card_imageView_prioridade1);
            ivPrioridade2 = itemView.findViewById(R.id.card_imageView_prioridade2);
            ivPrioridade3 = itemView.findViewById(R.id.card_imageView_prioridade3);
            ivPrioridade4 = itemView.findViewById(R.id.card_imageView_prioridade4);
            ivPrioridade5 = itemView.findViewById(R.id.card_imageView_prioridade5);

        }
    }

}
