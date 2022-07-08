package com.example.todemoto.perfil_cliente.presenter;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.perfil_cliente.PerfilClienteContracts;
import com.example.todemoto.perfil_cliente.interactor.PerfilClienteInteractor;
import com.example.todemoto.perfil_cliente.router.PerfilClienteRouter;
import com.example.todemoto.perfil_cliente.view.PerfilClienteActivity;

public class PerfilClientePresenter implements PerfilClienteContracts.Presenter {
    private final PerfilClienteContracts.View view;
    private final PerfilClienteInteractor interactor;
    private final PerfilClienteRouter router;

    public PerfilClientePresenter(PerfilClienteContracts.View view) {
        this.view = view;
        this.interactor = new PerfilClienteInteractor(this);
        this.router = new PerfilClienteRouter(view);
    }

    @Override
    public void carregarInfoCliente() {
        interactor.carregandoInfoCliente();
    }

    @Override
    public void onCarregarInfoCliente(Cliente c) {
        view.carregarTelaCliente(c);
    }

    @Override
    public void goToEditarPerfilCliente(Cliente c) {
        router.goToEditarPerfilCliente(c);
    }

    @Override
    public void logOutCliente() {
        interactor.logOutingCliente();

    }

    @Override
    public void onLogOutCliente() {
        router.goToLogin();
    }

    @Override
    public void chamaEdicaoCliente(Cliente c) {
        view.chamaEdicaoCliente(c);
    }

    @Override
    public void onErroCarregarInfoCliente(String message) {
        view.onCarregarInfoErro(message);
    }
}
