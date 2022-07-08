package com.example.todemoto.perfil_cliente.router;

import android.content.Intent;

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.edicao_cliente.view.EdicaoClienteActivity;
import com.example.todemoto.login.view.LoginActivity;
import com.example.todemoto.perfil_cliente.PerfilClienteContracts;

import java.io.Serializable;

public class PerfilClienteRouter implements PerfilClienteContracts.Router {
    private final PerfilClienteContracts.View view;

    public PerfilClienteRouter(PerfilClienteContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToEditarPerfilCliente(Cliente c) {
        Intent intent = new Intent(view.getContext(), EdicaoClienteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("cliente", (Serializable) c);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para a edicao cliente");

    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir pro login");
        view.finish();
    }
}
