package com.example.todemoto.disponiveis;

import android.content.Context;

import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;

import java.util.List;

public interface DisponiveisContracts {

    interface View{

        void printaFeedBack(String message);
        void listandoDisponieveisCard(List<CardMotociclista> cm);
        Context getAplicationContext();
    }
    interface Presenter{
        void buscaDisponiveisCard();
        void onBuscaDisponiveisCard(List<CardMotociclista> cm);
        void messageFeedBack(String message);
        void goToFavoritos();
    }
    interface Interactor{
        void buscandoDisponiveisCard();
    }
    interface Router{
        void goToFavoritos();
    }
}
