package com.example.todemoto.cadastro_cliente.view;

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

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.R;
import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_cliente.presenter.CadastroClientePresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroCliente extends AppCompatActivity implements CadastroClienteContracts.View {

    private EditText emailRegistroCliente;
    private EditText nomeRegistroCliente;
    private EditText senhaRegistroCliente;
    private EditText senhaRegistroConfCliente;
    private Button botaoRegistroCliente;
    private TextView botaoRegistroLogar;
    private CheckBox checkBoxRegistroCliente;
    private CadastroClienteContracts.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        presenter = new CadastroClientePresenter(this);
        //Associando as variaveis locais com as views da tela
        emailRegistroCliente = findViewById(R.id.emailRegistroCliente);
        nomeRegistroCliente = findViewById(R.id.nomeRegistroCliente);
        senhaRegistroCliente = findViewById(R.id.senhaRegistroCliente);
        senhaRegistroConfCliente = findViewById(R.id.senhaRegistroConfCliente);
        botaoRegistroCliente = findViewById(R.id.botaoRegistroMotociclista);
        botaoRegistroLogar = findViewById(R.id.botaoRegistroLogarMotociclista);
        checkBoxRegistroCliente = findViewById(R.id.checkBoxRegistroCliente);

        //criando um evento para quando o usuario decidir ver a senha
        checkBoxRegistroCliente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //caso o checkbox esteja marcado, eu mostro a senha
                    senhaRegistroCliente.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    senhaRegistroConfCliente.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {//caso o checkbox não esteja marcado, eu não mostro a senha
                    senhaRegistroCliente.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    senhaRegistroConfCliente.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        //-------------

        //criando um evento para a ação de registrar
        botaoRegistroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resgatando o texto digitado pelo usuario
                String senha = senhaRegistroCliente.getText().toString();
                String confsenha = senhaRegistroConfCliente.getText().toString();
                String email = emailRegistroCliente.getText().toString();
                String nome = nomeRegistroCliente.getText().toString();

                //verificando se o usuario não deixou nada em branco
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(nome) && !TextUtils.isEmpty(senha) && !TextUtils.isEmpty(confsenha)){
                    //verificando se o usuario digitou senhas iguais. Caso sim, posso inserir os dados no banco
                    if (senha.equals(confsenha)){
                        //evento para inserir no banco. No firebase ficaria assim:
                        System.out.println("teste para view: "+nome +email + senha);
                        presenter.salvarCliente(new Cliente(nome, email, senha));

                    }else{
                        //caso tenha colocado senhas diferentes
                        Toast.makeText(CadastroCliente.this, "As senhas estão diferentes!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    //caso tenha deixado algum campo em branco
                    Toast.makeText(CadastroCliente.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void chamarPrincipal(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSavedError(String message) {
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