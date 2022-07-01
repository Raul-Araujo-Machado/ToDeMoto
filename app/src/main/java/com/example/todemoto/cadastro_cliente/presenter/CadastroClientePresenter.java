package com.example.todemoto.cadastro_cliente.presenter;

import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_cliente.interactor.CadastroClienteInteractor;
import com.example.todemoto.cadastro_cliente.router.CadastroClienteRouter;
import com.example.todemoto.cadastro_cliente.view.CadastroCliente;

public class CadastroClientePresenter implements CadastroClienteContracts.Presenter {

    private CadastroClienteContracts.Interactor interactor;
    private CadastroClienteContracts.Router router;
    private CadastroClienteContracts.View view;

    public CadastroClientePresenter(CadastroClienteContracts.View view) {
        this.view = view;
        this.interactor = new CadastroClienteInteractor(this);
        this.router = new CadastroClienteRouter(view);
    }

    @Override
    public void salvarCliente(Cliente cliente) {

    }

    @Override
    public void onClienteSaved(Cliente cliente) {

    }

    @Override
    public void onClienteAuthSaved(Cliente cliente) {

    }

    @Override
    public void onSavedErrorAuth(String message) {

    }

    @Override
    public void onSavedErrorRT(String message) {

    }
}
