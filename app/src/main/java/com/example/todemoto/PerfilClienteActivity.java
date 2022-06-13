package com.example.todemoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PerfilClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cliente);
    }
    public void chamarEditarCliente(View view){
        Intent intent = new Intent(this, EdicaoClienteActivity.class);
        startActivity(intent);
    }
}