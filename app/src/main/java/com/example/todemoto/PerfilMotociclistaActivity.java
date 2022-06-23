package com.example.todemoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PerfilMotociclistaActivity extends AppCompatActivity {

    private Button sairPerfilMotociclista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_motociclista);
        System.out.println("teste: Entrei no perfil do motociclista");
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        sairPerfilMotociclista = findViewById(R.id.sairPerfilMotociclista);

        sairPerfilMotociclista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(PerfilMotociclistaActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}