package com.example.todemoto.cadastro_motociclista.presenter;


import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.interactor.CadastroMotociclistaInteractor;
import com.example.todemoto.cadastro_motociclista.router.CadastroMotociclistaRouter;
import com.example.todemoto.cadastro_motociclista.view.CadastroMotociclista;

public class CadastroMotociclistaPresenter implements CadastroMotociclistaContracts.Presenter {

    private final CadastroMotociclistaContracts.View view;
    private final CadastroMotociclistaContracts.Router router;
    private final CadastroMotociclistaContracts.Interactor interactor;


    public CadastroMotociclistaPresenter(CadastroMotociclistaContracts.View view) {
        this.view = view;
        this.router = new CadastroMotociclistaRouter(view);
        this.interactor = new CadastroMotociclistaInteractor(this);
    }


    @Override
    public void salvarMotociclista(Motociclista motociclista) {
        interactor.salvaMotociclistaAuth(motociclista);
    }

    @Override
    public void onMotociclistaSaved() {
        router.goToPerfilMotociclista();
    }

    @Override
    public void onMotociclistaAuthSaved(Motociclista motociclista) {
        interactor.salvaMotociclistaRT(motociclista);
    }

    @Override
    public void onSavedErrorAuth(String message) {
        view.onSavedErrorAuth(message);
    }

    @Override
    public void onSavedErrorRT(String message) {
        view.onSavedErrorRT(message);
    }

    @Override
    public void goToLogin() {
        router.goToLogin();
    }
}
