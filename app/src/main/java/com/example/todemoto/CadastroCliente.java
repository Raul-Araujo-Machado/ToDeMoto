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

import com.example.todemoto.Model.Cliente;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroCliente extends AppCompatActivity {

    private EditText emailRegistroCliente;
    private EditText nomeRegistroCliente;
    private EditText senhaRegistroCliente;
    private EditText senhaRegistroConfCliente;
    private Button botaoRegistroCliente;
    private TextView botaoRegistroLogar;
    private CheckBox checkBoxRegistroCliente;

    //instanciando a variavel do firebase responsavel pelas transações
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

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
                        Cliente cliente = new Cliente();
                        cliente.setEmail(emailRegistroCliente.getText().toString());
                        cliente.setNome(nomeRegistroCliente.getText().toString());
                        mAuth.createUserWithEmailAndPassword(cliente.getEmail(),senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    cliente.setId(mAuth.getUid());

                                    cliente.salvarCliente();
                                    chamarPrincipal();
                                }else{
                                    String erro = task.getException().getMessage();
                                    Toast.makeText(CadastroCliente.this, ""+erro, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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
}