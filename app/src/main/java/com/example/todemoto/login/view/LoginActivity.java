package com.example.todemoto.login.view;

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

import com.example.todemoto.MainActivity;
import com.example.todemoto.login.LoginContracts;
import com.example.todemoto.login.presenter.LoginPresenter;
import com.example.todemoto.perfil_motociclista.view.PerfilMotociclistaActivity;
import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.R;
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

public class LoginActivity extends AppCompatActivity implements LoginContracts.View {

    private EditText emailLogin;
    private EditText senhaLogin;
    private CheckBox checkBoxLogin;
    private Button botaoLogin;
    private TextView botaoRegistrar;

    private LoginContracts.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        emailLogin = findViewById(R.id.emailLogin);
        senhaLogin = findViewById(R.id.senhaLogin);
        botaoLogin = findViewById(R.id.botaoLogin);
        botaoRegistrar = findViewById(R.id.botaoRegistrar);
        checkBoxLogin = findViewById(R.id.checkBoxLogin);


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
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_ = emailLogin.getText().toString();
                String senha_ = senhaLogin.getText().toString();
                if(!TextUtils.isEmpty(email_) && !TextUtils.isEmpty(senha_)){
                    presenter.fazerLogin(email_, senha_);
                }
            }
        });

        botaoRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToCadastro();
            }
        });

    }

    @Override
    public void onFazerLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void finish() {
        super.finish();
    }
}