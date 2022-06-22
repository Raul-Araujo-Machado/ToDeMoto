package com.example.todemoto.cadastro_motociclista.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todemoto.LoginActivity;
import com.example.todemoto.PerfilMotociclistaActivity;
import com.example.todemoto.R;
import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.presenter.CadastroMotociclistaPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroMotociclista extends AppCompatActivity implements CadastroMotociclistaContracts.View {

    private EditText emailRegistroMotociclista;
    private EditText nomeRegistroMotociclista;
    private EditText senhaRegistroMotociclista;
    private EditText senhaRegistroConfMotociclista;
    private CheckBox checkBoxRegistroMotociclista;
    private EditText descricaoRegistroMotociclista;
    private EditText telefoneRegistroMotociclista;
    private Button botaoRegistroMotociclista;
    private TextView botaoRegistroLogarMotociclista;
    private FirebaseAuth mAuth;
    private CadastroMotociclistaContracts.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_motociclista);
        presenter = new CadastroMotociclistaPresenter(this);
        mAuth = FirebaseAuth.getInstance();
        emailRegistroMotociclista = findViewById(R.id.emailRegistroMotociclista);
        nomeRegistroMotociclista = findViewById(R.id.nomeRegistroMotociclista);
        senhaRegistroMotociclista = findViewById(R.id.senhaRegistroMotociclista);
        senhaRegistroConfMotociclista = findViewById(R.id.senhaRegistroConfMotociclista);
        checkBoxRegistroMotociclista = findViewById(R.id.checkBoxRegistroMotociclista);
        descricaoRegistroMotociclista = findViewById(R.id.descricaoRegistroMotociclista);
        telefoneRegistroMotociclista = findViewById(R.id.telefoneRegistroMotociclista);
        botaoRegistroMotociclista = findViewById(R.id.botaoRegistroMotociclista);
        botaoRegistroLogarMotociclista = findViewById(R.id.botaoRegistroLogarMotociclista);

        botaoRegistroMotociclista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailRegistroMotociclista.getText().toString();
                String nome = nomeRegistroMotociclista.getText().toString();
                String descricao = descricaoRegistroMotociclista.getText().toString();
                String telefone = telefoneRegistroMotociclista.getText().toString();
                String senha = senhaRegistroMotociclista.getText().toString();
                String confsenha = senhaRegistroConfMotociclista.getText().toString();

                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(nome) && !TextUtils.isEmpty(descricao) && !TextUtils.isEmpty(telefone) && !TextUtils.isEmpty(senha) && !TextUtils.isEmpty(confsenha)){
                    if(senha.equals(confsenha)){
                        presenter.salvarMotociclista(new Motociclista());

                    }else{
                        Toast.makeText(CadastroMotociclista.this, "Senhas diferentes!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CadastroMotociclista.this, "Todos os campos devem estar preenchidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxRegistroMotociclista.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //caso o checkbox esteja marcado, eu mostro a senha
                    senhaRegistroMotociclista.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    senhaRegistroConfMotociclista.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {//caso o checkbox não esteja marcado, eu não mostro a senha
                    senhaRegistroMotociclista.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    senhaRegistroConfMotociclista.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });


    }

    public void chamarPerfilMotociclista(){
        Intent intent = new Intent(CadastroMotociclista.this, PerfilMotociclistaActivity.class);
        startActivity(intent);
        finish();
    }
    public void chamarLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSavedError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}