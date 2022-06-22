package com.example.todemoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText emailLogin;
    private EditText senhaLogin;
    private CheckBox checkBoxLogin;
    private Button botaoLogin;
    private TextView botaoRegistrar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        emailLogin = findViewById(R.id.emailLogin);
        senhaLogin = findViewById(R.id.senhaLogin);
        botaoLogin = findViewById(R.id.botaoLogin);
        botaoRegistrar = findViewById(R.id.botaoRegistrar);
        checkBoxLogin = findViewById(R.id.checkBoxLogin);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_ = emailLogin.getText().toString();
                String senha_ = senhaLogin.getText().toString();
                if(!TextUtils.isEmpty(email_) || !TextUtils.isEmpty(senha_)){
                    mAuth.signInWithEmailAndPassword(email_, senha_).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();
                                String user = current.getUid();
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("Usuarios/Motociclista/"+user);
                                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        Motociclista m = (Motociclista) snapshot.getValue(Motociclista.class);
                                       int res = (int) snapshot.getChildrenCount();
                                       if (res > 0){
                                           chamarPerfilMotociclista(m);
                                       }else{
                                           chamarPrincipalCliente();
                                       }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }else{
                                String erro = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, ""+erro, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        checkBoxLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    senhaLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    senhaLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    public void chamarPrincipalCliente(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        finish();
    }
    public void chamarPerfilMotociclista(Motociclista m){
        Intent intent = new Intent(this, PerfilMotociclistaActivity.class);
        startActivity(intent);
        finish();
    }
    public void chamarCadastro(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}