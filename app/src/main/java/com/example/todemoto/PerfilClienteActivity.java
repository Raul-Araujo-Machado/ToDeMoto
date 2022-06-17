package com.example.todemoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class PerfilClienteActivity extends AppCompatActivity {

    private Button sairCliente;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);

        mAuth = FirebaseAuth.getInstance();
        sairCliente = findViewById(R.id.sairCliente);
        sairCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(PerfilClienteActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void chamarEditarCliente(View view){
        Intent intent = new Intent(this, EdicaoClienteActivity.class);
        startActivity(intent);
    }
}