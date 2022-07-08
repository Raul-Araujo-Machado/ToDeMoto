package com.example.todemoto.login.router;

import android.content.Intent;

import com.example.todemoto.MainActivity;
import com.example.todemoto.loading.view.Loading;
import com.example.todemoto.cadastro_cliente.view.CadastroCliente;
import com.example.todemoto.login.LoginContracts;

public class LoginRouter implements LoginContracts.Router {
    private final LoginContracts.View view;

    public LoginRouter(LoginContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToLoading() {
        Intent intent = new Intent(view.getContext(), Loading.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para Loading");
        view.finish();
    }

    @Override
    public void goToCadastro() {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para Loading");
        view.finish();
    }
}
