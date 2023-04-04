package com.example.dh_dreamhome.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.model.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import java.util.Objects;

public class A_Cadastro extends AppCompatActivity {

    //Elementos interface
    private EditText editNome, editEmail, editSenha;
    private Button btCadastrar;
    //Objetos
    private Usuarios usuario;
    //Extern
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        FirebaseApp.initializeApp(A_Cadastro.this);

        editNome = findViewById(R.id.cadastro_edit_nome);
        editEmail = findViewById(R.id.cadastro_edit_email);
        editSenha = findViewById(R.id.cadastro_edit_senha);
        btCadastrar = findViewById(R.id.cadastro_button_cadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoNome = editNome.getText().toString();
                String textoEmail = editEmail.getText().toString();
                String textoSenha = editSenha.getText().toString();

                if( !textoNome.isEmpty() ){
                    if ( !textoEmail.isEmpty() ){
                        if ( !textoSenha.isEmpty() ){

                            usuario = new Usuarios();
                            usuario.setNome( textoNome );
                            usuario.setEmail( textoEmail );
                            usuario.setSenha( textoSenha );

                            cadastrarUsuario();

                        }else{
                            Toast.makeText(A_Cadastro.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(A_Cadastro.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(A_Cadastro.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void cadastrarUsuario(){

        FirebaseApp.initializeApp(this);
        firebaseAuth  = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful() ){

                    Toast.makeText(A_Cadastro.this, "Usuário cadastrado com SUCESSO.", Toast.LENGTH_SHORT).show();
                    finish();

                }else{

                    String excessao = "";
                    try {
                        throw Objects.requireNonNull(task.getException());
                    }catch ( FirebaseAuthWeakPasswordException e){
                        excessao = "Digite uma senha mais forte!";
                    }catch ( FirebaseAuthInvalidCredentialsException e){
                        excessao = "Por favor, digite um e-mail válido!";
                    }catch ( FirebaseAuthUserCollisionException e){
                        excessao = "Este e-mail já está sendo utilizado!";
                    }catch ( Exception e){
                        excessao = "Erro ao cadastrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(A_Cadastro.this, excessao, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}