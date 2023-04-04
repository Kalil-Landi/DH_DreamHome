package com.example.dh_dreamhome.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.fragments.F_Espaco;
import com.example.dh_dreamhome.fragments.F_Pessoa;
import com.example.dh_dreamhome.fragments.F_Prioridade;
import com.example.dh_dreamhome.model.Produtos;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.concurrent.atomic.AtomicReference;

public class A_Produto extends AppCompatActivity {
    //Elementos interface
    EditText editDescricao, editCodigo, editLoja, editPreco, editQuantidade;
    TextView textTotal;
    Button btMais, btMenos, btEspaco, btPessoa, btPrioridade, btSalvar;
    ImageView ivJaComprado;
    CheckBox cbJaComprado;
    F_Espaco f_espaco;
    F_Pessoa f_pessoa;
    F_Prioridade f_prioridade;
    FrameLayout frameLayout;
    View view_block;
    ConstraintLayout clRoot;


    private String button_clicado;

    @SuppressLint({"UseCompatLoadingForDrawables", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        //rootLayout
        clRoot = findViewById(R.id.produto_root_layout);
        //editText
        editDescricao = findViewById(R.id.produto_edit_descricao);
        editCodigo = findViewById(R.id.produto_edit_codigo);
        editLoja = findViewById(R.id.produto_edit_loja);
        editPreco = findViewById(R.id.produto_edit_preco);
        editQuantidade = findViewById(R.id.produto_edit_quantidade);
        //textView
        textTotal = findViewById(R.id.produto_textView_total);
        //button
        btMais = findViewById(R.id.produto_button_mais);
        btMenos = findViewById(R.id.produto_button_menos);
        btEspaco = findViewById(R.id.produto_button_espaco);
        btPessoa = findViewById(R.id.produto_button_pessoas);
        btPrioridade = findViewById(R.id.produto_button_prioridade);
        btSalvar = findViewById(R.id.produto_button_salvar);
        //imageView
        ivJaComprado = findViewById(R.id.produto_imageView_jaComprado);
        //checkBox
        cbJaComprado = findViewById(R.id.produto_checkBox_jaComprado);
        //frameLayout
        frameLayout = findViewById(R.id.produto_frameLayout);
        //view
        view_block = findViewById(R.id.produto_view_block);
        //fragments
        f_espaco = new F_Espaco();
        f_pessoa = new F_Pessoa();
        f_prioridade = new F_Prioridade();
        //variaveis
        button_clicado = "";

        //set valores padrão para campos
        editQuantidade.setText("1");
        editPreco.setText("0.00");

        //quebra linha automatico | sem tecla enter
        editDescricao.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        editDescricao.setRawInputType(InputType.TYPE_CLASS_TEXT);

        //esconde teclado clicando no layout raiz
        clRoot.setOnClickListener(view -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editDescricao.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(editCodigo.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(editLoja.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(editPreco.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(editQuantidade.getWindowToken(), 0);
            editDescricao.clearFocus();
            editCodigo.clearFocus();
            editLoja.clearFocus();
            editPreco.clearFocus();
            editQuantidade.clearFocus();
        });

        //troca de icone ao clicar no checkBox
        cbJaComprado.setOnClickListener(view -> {
            if( cbJaComprado.isChecked() ) {
                ivJaComprado.setImageDrawable(getResources().getDrawable(R.drawable.open_box));
            } else {
                ivJaComprado.setImageDrawable(getResources().getDrawable(R.drawable.box));
            }
        });

        //observa mudança de PREÇO
        TextWatcher twPreco = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (editPreco.isFocused()){
                    if (!editPreco.getText().toString().isEmpty()){
                        if (!editPreco.getText().toString().equals("0")){
                            Double valorTotal = 0.00;
                            if(!editQuantidade.getText().toString().isEmpty()){
                                valorTotal = Double.parseDouble(editPreco.getText().toString()) * Integer.parseInt(editQuantidade.getText().toString());
                            } else {
                                editQuantidade.setText("1");
                                valorTotal = Double.valueOf(editPreco.getText().toString());
                            }
                            textTotal.setText("Total: " + valorTotal + " €");
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        editPreco.addTextChangedListener(twPreco);

        //observa mudança de QUANTIDADE
        TextWatcher twQuantidade = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (editQuantidade.isFocused()){
                    if (!editQuantidade.getText().toString().isEmpty()){
                        if (!editQuantidade.getText().toString().equals("0")){
                            double valorTotal = 0.00;
                            if(!editPreco.getText().toString().isEmpty()){
                                valorTotal = Double.parseDouble(editPreco.getText().toString()) * Integer.parseInt(editQuantidade.getText().toString());
                            } else {
                                editPreco.setText("0.00");
                                valorTotal = Double.parseDouble(editPreco.getText().toString());
                            }
                            textTotal.setText("Total: " + valorTotal + " €");
                        }
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        editQuantidade.addTextChangedListener(twQuantidade);

        //view que bloqueia layout fora do fragment
        view_block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               frameLayout.setVisibility(View.GONE);
               view_block.setVisibility(View.GONE);
                if (button_clicado.equals("espaco")){
                   btEspaco.setText(f_espaco.strButton);
               }
                if (button_clicado.equals("pessoa")){
                    btPessoa.setText(f_pessoa.strButton);
                }
                if (button_clicado.equals("prioridade")){
                    btPrioridade.setText(f_prioridade.strButton);
                }
            }
        });

        //configura button MAIS qtd
        btMais.setOnClickListener(view -> {
            int qtd = Integer.parseInt(editQuantidade.getText().toString());
            editQuantidade.setText(String.valueOf(qtd+1));
            if (!editQuantidade.getText().toString().isEmpty()){
                if (!editQuantidade.getText().toString().equals("0")){
                    double valorTotal = 0.00;
                    if(!editPreco.getText().toString().isEmpty()){
                        valorTotal = Double.parseDouble(editPreco.getText().toString()) * Integer.parseInt(editQuantidade.getText().toString());
                    } else {
                        editPreco.setText("0.00");
                        valorTotal = Double.parseDouble(editPreco.getText().toString());
                    }
                    textTotal.setText("Total: " + valorTotal + " €");
                }
            }
        });

        //configura button MENOS qtd
        btMenos.setOnClickListener(view -> {
            int qtd = Integer.parseInt(editQuantidade.getText().toString());
            editQuantidade.setText(String.valueOf(qtd-1));
            if (!editQuantidade.getText().toString().isEmpty()){
                if (!editQuantidade.getText().toString().equals("0")){
                    double valorTotal = 0.00;
                    if(!editPreco.getText().toString().isEmpty()){
                        valorTotal = Double.parseDouble(editPreco.getText().toString()) * Integer.parseInt(editQuantidade.getText().toString());
                    } else {
                        editPreco.setText("0.00");
                        valorTotal = Double.parseDouble(editPreco.getText().toString());
                    }
                    textTotal.setText("Total: " + valorTotal + " €");
                }
            }
        });

        //configura clique button ESPACO
        btEspaco.setOnClickListener(view -> {
            button_clicado = "espaco";
            FragmentTransaction transaction_espaco = getSupportFragmentManager().beginTransaction();
            transaction_espaco.replace(R.id.produto_frameLayout, f_espaco);
            transaction_espaco.commit();
            view_block.setVisibility(View.VISIBLE);
            view_block.bringToFront();
            frameLayout.setVisibility(View.VISIBLE);
            frameLayout.bringToFront();
        });

        //configura clique button PESSOA
        btPessoa.setOnClickListener(view -> {
            button_clicado = "pessoa";
            FragmentTransaction transaction_espaco = getSupportFragmentManager().beginTransaction();
            transaction_espaco.replace(R.id.produto_frameLayout, f_pessoa);
            transaction_espaco.commit();
            view_block.setVisibility(View.VISIBLE);
            view_block.bringToFront();
            frameLayout.setVisibility(View.VISIBLE);
            frameLayout.bringToFront();
        });

        //configura clique button PRIORIDADE
        btPrioridade.setOnClickListener(view -> {
            button_clicado = "prioridade";
            FragmentTransaction transaction_espaco = getSupportFragmentManager().beginTransaction();
            transaction_espaco.replace(R.id.produto_frameLayout, f_prioridade);
            transaction_espaco.commit();
            view_block.setVisibility(View.VISIBLE);
            view_block.bringToFront();
            frameLayout.setVisibility(View.VISIBLE);
            frameLayout.bringToFront();
        });

        //configura clique button SALVAR
        btSalvar.setOnClickListener(view -> {

            FirebaseApp.initializeApp(this);
            DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
            DatabaseReference produto_ref = referencia.child("DH_StartUp").child("Usuario")
                    .child("Projeto").child("Espaco").child("Produtos");
            Produtos produto = new Produtos();
            produto.setPdtProjeto(1); //TODO
            produto.setPdtDescricao(editDescricao.getText().toString());
            produto.setPdtCodigo(editCodigo.getText().toString());
            produto.setPdtLoja(editLoja.getText().toString());
            produto.setPdtPreco(Double.valueOf(editPreco.getText().toString()));
            produto.setPdtQuantidade(Integer.parseInt(editQuantidade.getText().toString()));
            //produto.setPdtTotal(Double.valueOf(textTotal.getText().toString()));
            produto.setPdtEspaco(btEspaco.getText().toString());
            produto.setPdtPessoa(btPessoa.getText().toString());
            produto.setPdtPrioridade(btPrioridade.getText().toString());
            produto.setPdtJaComprou(cbJaComprado.isChecked());

            produto_ref.push().setValue(produto);
            Toast.makeText(this, "PRODUTO CADASTRADO", Toast.LENGTH_LONG).show();
            onBackPressed();

        });
    }

}
