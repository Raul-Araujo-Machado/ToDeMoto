package com.example.todemoto.cadastro_motociclista.presenter;

import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.interactor.CadastroMotociclistaInteractor;
import com.example.todemoto.cadastro_motociclista.router.CadastroMotociclistaRouter;
import com.example.todemoto.cadastro_motociclista.view.CadastroMotociclista;

public class CadastroMotociclistaPresenter implements CadastroClienteContracts.Presenter {

    private final CadastroMotociclistaContracts.View view;
    private final CadastroMotociclistaContracts.Router router;
    private final CadastroMotociclistaContracts.Interactor interactor;


    public CadastroMotociclistaPresenter(CadastroMotociclistaContracts.View view) {
        this.view = view;
        this.router = new CadastroMotociclistaRouter(view);
        this.interactor = new CadastroMotociclistaInteractor(this);
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
