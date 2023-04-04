package com.example.dh_dreamhome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dh_dreamhome.R;
import com.example.dh_dreamhome.config.ConfigFirebase;
import com.example.dh_dreamhome.model.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class A_Login extends AppCompatActivity {

    //Elementos interface
    private EditText editEmail, editSenha;
    private Button btEntrar, btCadastrar;
    //Objetos
    private Usuarios usuario;
    //Extern
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.login_edit_email);
        editSenha = findViewById(R.id.login_edit_senha);
        btEntrar = findViewById(R.id.login_button_entrar);
        btCadastrar = findViewById(R.id.login_button_cadastrar);

        FirebaseApp.initializeApp(getApplicationContext());

        btEntrar.setOnClickListener(view -> {

            String txtEmail = editEmail.getText().toString();
            String txtSenha = editSenha.getText().toString();

            if (!txtEmail.isEmpty()) {
                if (!txtSenha.isEmpty()) {

                    usuario = new Usuarios();
                    usuario.setEmail(txtEmail);
                    usuario.setSenha(txtSenha);
                    validarLogin();

                } else {
                    Toast.makeText(this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Preencha o e-mail!", Toast.LENGTH_SHORT).show();
            }

        });

        btCadastrar.setOnClickListener(view -> {
            startActivity(new Intent(A_Login.this, A_Cadastro.class));
        } );

    }

    public void validarLogin() {

        firebaseAuth = ConfigFirebase.getFirebaseAutenticacao();
        firebaseAuth.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    abrirTelaPrincipal();

                } else {

                    String excessao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excessao = "Usuário não cadastrado.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excessao = "E-mail e/ou senha inválidos.";
                    } catch (Exception e) {
                        excessao = "Erro ao fazer login: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(A_Login.this, excessao, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //abre tela inicial
    public void abrirTelaPrincipal(){

        startActivity(new Intent(A_Login.this, A_MainActivity.class));

    }

    //verifica usuario logado
    public void usuarioLogado(){

        firebaseAuth = ConfigFirebase.getFirebaseAutenticacao();
        if ( firebaseAuth.getCurrentUser() != null ){

            abrirTelaPrincipal();

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        usuarioLogado();

    }

    @Override
    public void onBackPressed() {

    }
}
