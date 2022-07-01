package com.example.todemoto.cadastro_cliente.router;

import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;

public class CadastroClienteRouter implements CadastroClienteContracts.Router {
    private CadastroClienteContracts.View view;

    public CadastroClienteRouter(CadastroClienteContracts.View view) {
        this.view = view;
    }

    @Override
    public void goToPrincipalActivity(Cliente cliente) {

    }
}
