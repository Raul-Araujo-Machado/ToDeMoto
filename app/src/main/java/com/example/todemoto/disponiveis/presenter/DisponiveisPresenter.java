package com.example.todemoto.disponiveis.presenter;

import com.example.todemoto.disponiveis.DisponiveisContracts;
import com.example.todemoto.disponiveis.interactor.DisponiveisInteractor;
import com.example.todemoto.disponiveis.router.DisponiveisRouter;
import com.example.todemoto.disponiveis.view.DisponiveisFragment;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;

import java.util.List;

public class DisponiveisPresenter implements DisponiveisContracts.Presenter {
    private final DisponiveisContracts.View view;
    private final DisponiveisContracts.Interactor interactor;
    private final DisponiveisContracts.Router router;

    public DisponiveisPresenter(DisponiveisContracts.View view) {
        this.view = view;
        this.interactor = new DisponiveisInteractor(this);
        this.router = new DisponiveisRouter(view);
    }

    @Override
    public void buscaDisponiveisCard() {
        interactor.buscandoDisponiveisCard();
    }

    @Override
    public void onBuscaDisponiveisCard(List<CardMotociclista> cm) {
        view.listandoDisponieveisCard(cm);
    }

    @Override
    public void messageFeedBack(String message) {
        view.printaFeedBack(message);
    }

    @Override
    public void goToFavoritos() {
        router.goToFavoritos();
    }
}
