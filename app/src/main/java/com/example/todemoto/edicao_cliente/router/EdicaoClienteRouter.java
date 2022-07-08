package com.example.todemoto.edicao_cliente.router;

import android.content.Intent;

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.edicao_cliente.EdicaoClienteContracts;
import com.example.todemoto.perfil_cliente.view.PerfilClienteActivity;

public class EdicaoClienteRouter implements EdicaoClienteContracts.Router {
    private final EdicaoClienteContracts.View view;

    public EdicaoClienteRouter(EdicaoClienteContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPerfilCliente() {
        Intent intent = new Intent(view.getContext(), PerfilClienteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para a perfil cliente pela edicao");
        view.finish();
    }
}
