package com.example.todemoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CadastroMotociclista extends AppCompatActivity {

    private EditText emailRegistroMotociclista;
    private EditText nomeRegistroMotociclista;
    private EditText senhaRegistroMotociclista;
    private EditText senhaRegistroConfMotociclista;
    private CheckBox checkBoxRegistroMotociclista;
    private EditText descricaoRegistroMotociclista;
    private EditText telefoneRegistroMotociclista;
    private Button botaoRegistroMotociclista;
    private Button botaoRegistroLogarMotociclista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_motociclista);

        emailRegistroMotociclista = findViewById(R.id.emailRegistroMotociclista);
        

    }

    public void chamarPrincipal(View view){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
    public void chamarLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}