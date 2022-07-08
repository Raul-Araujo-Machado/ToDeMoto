package com.example.todemoto.cadastro_cliente.router;

import android.content.Intent;

import com.example.todemoto.PrincipalActivity;
import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;

import java.io.Serializable;

public class CadastroClienteRouter implements CadastroClienteContracts.Router {
    private CadastroClienteContracts.View view;

    public CadastroClienteRouter(CadastroClienteContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPrincipalActivity() {
        Intent intent = new Intent(view.getContext(), PrincipalActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
        System.out.println("teste: consegui ir para a principal activity");
        view.finish();
    }
}
