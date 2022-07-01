package com.example.todemoto.cadastro_motociclista.interactor;

import com.example.todemoto.cadastro_cliente.CadastroClienteContracts;
import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.presenter.CadastroMotociclistaPresenter;

public class CadastroMotociclistaInteractor implements CadastroMotociclistaContracts.Interactor {
    private final CadastroClienteContracts.Presenter presenter;


    public CadastroMotociclistaInteractor(CadastroClienteContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void salvaMotociclistaAuth(Motociclista motociclista) {

    }

    @Override
    public void salvaMotociclistaRT(Motociclista motociclista) {

    }
}
