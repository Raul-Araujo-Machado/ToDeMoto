package com.example.todemoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.todemoto.Model.Motociclista;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilMotociclistaActivity extends AppCompatActivity {

    private Button sairPerfilMotociclista;
    private TextView nomeMotociclistaPerfil;
    private TextView emailMotociclistaPerfil;
    private TextView telefoneMotociclistaPerfil;
    private TextView descricaoMotociclistaPerfil;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_motociclista);

        nomeMotociclistaPerfil = findViewById(R.id.nomeMotociclistaPerfil);
        emailMotociclistaPerfil = findViewById(R.id.emailMotociclistaPerfil);
        telefoneMotociclistaPerfil = findViewById(R.id.telefoneMotociclistaPerfil);
        descricaoMotociclistaPerfil = findViewById(R.id.descricaoMotociclistaPerfil);

        carregaInformações();

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

    private void carregaInformações(){
        String user = mAuth.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios/Motociclista/" + user);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Motociclista m = (Motociclista) snapshot.getValue(Motociclista.class);
                System.out.println("teste"+m.getNome());
                nomeMotociclistaPerfil.setText(m.getNome());
                emailMotociclistaPerfil.setText(m.getEmail());
                telefoneMotociclistaPerfil.setText(m.getTelefone());
                descricaoMotociclistaPerfil.setText(m.getDescricao());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}