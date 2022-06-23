package com.example.todemoto.cadastro_motociclista.presenter;

import com.example.todemoto.cadastro_motociclista.CadastroMotociclistaContracts;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.cadastro_motociclista.interactor.CadastroMotociclistaInteractor;
import com.example.todemoto.cadastro_motociclista.router.CadastroMotociclistaRouter;

public class CadastroMotociclistaPresenter implements CadastroMotociclistaContracts.Presenter {

    CadastroMotociclistaContracts.View view;
    CadastroMotociclistaContracts.Router router;
    CadastroMotociclistaContracts.Interactor interactor;


    public CadastroMotociclistaPresenter(CadastroMotociclistaContracts.View cadastroMotociclista) {
        this.view = cadastroMotociclista;
        this.router = new CadastroMotociclistaRouter(view);
        this.interactor = new CadastroMotociclistaInteractor(this);
    }

    @Override
    public void salvarMotociclista(Motociclista motociclista) {
        interactor.salvaMotociclistaAuth(motociclista);
    }

    @Override
    public void onMotociclistaSaved(Motociclista motociclista) {
        System.out.println("teste: Entrei no presenter");
        router.goToPerfilMotociclista(motociclista);
    }

    @Override
    public void onMotociclistaAuthSaved(Motociclista motociclista) {
        interactor.salvaMotociclistaRT(motociclista);
    }

    @Override
    public void onSavedErrorAuth(String message) {
        view.onSavedError("Erro durante autenticação: "+message);
    }

    @Override
    public void onSavedErrorRT(String message) {
        view.onSavedError("Erro durante o registro no banco: "+message);
    }
}
