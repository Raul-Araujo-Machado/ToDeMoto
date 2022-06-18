package com.example.todemoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarCadastroCliente(View view){
        Intent intent = new Intent(this, CadastroCliente.class);
        startActivity(intent);

    }

    public void chamarCadastroMotociclista(View view){
        Intent intent = new Intent(this, CadastroMotociclista.class);
        startActivity(intent);

    }
    public void chamarLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}