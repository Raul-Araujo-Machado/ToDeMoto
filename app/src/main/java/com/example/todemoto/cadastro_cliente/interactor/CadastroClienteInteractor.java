package com.example.todemoto.cadastro_cliente.interactor;

import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_cliente.presenter.CadastroClientePresenter;

public class CadastroClienteInteractor implements CadastroClienteContracts.Interactor {
    private CadastroClienteContracts.Presenter presenter;

    public CadastroClienteInteractor(CadastroClienteContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void salvaClienteAuth(Cliente cliente) {

    }

    @Override
    public void salvaClienteRT(Cliente cliente) {

    }
}
