package com.example.todemoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();
        if (current == null){
            Intent intent = new Intent(Loading.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            String user = current.getUid();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Usuarios/Motociclista/" + user);
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    //Motociclista m = (Motociclista) snapshot.getValue(Motociclista.class);

                    int res = (int) snapshot.getChildrenCount();
                    System.out.println("teste" + res);
                    if (res > 0) {
                        chamarPerfilMotociclista();
                    }else{
                        chamarPrincipalCliente();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    public void chamarPerfilMotociclista(){
        Intent intent = new Intent(this, PerfilMotociclistaActivity.class);
        startActivity(intent);
        finish();
    }

    public void chamarPrincipalCliente(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        finish();
    }

}