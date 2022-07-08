package com.example.todemoto.edicao_cliente.presenter;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.edicao_cliente.EdicaoClienteContracts;
import com.example.todemoto.edicao_cliente.interactor.EdicaoClienteInteractor;
import com.example.todemoto.edicao_cliente.router.EdicaoClienteRouter;
import com.example.todemoto.edicao_cliente.view.EdicaoClienteActivity;

public class EdicaoClientePresenter implements EdicaoClienteContracts.Presenter {
    private final EdicaoClienteContracts.View view;
    private final EdicaoClienteContracts.Interactor interactor;
    private final EdicaoClienteContracts.Router router;

    public EdicaoClientePresenter(EdicaoClienteContracts.View view) {
        this.view = view;
        this.interactor = new EdicaoClienteInteractor(this);
        this.router = new EdicaoClienteRouter(view);
    }


    @Override
    public void atualizaDados(Cliente c, String n) {
        interactor.atualizandodados(c,n);

    }

    @Override
    public void goToPerfilCliente() {
        router.goToPerfilCliente();
    }

    @Override
    public void onAtualizadados(String message) {
        view.onSavedSucess(message);
    }

    @Override
    public void onErrorAtualiza(String message) {
        view.onSavedError(message);
    }
}
