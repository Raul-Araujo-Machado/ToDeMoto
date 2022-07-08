package com.example.todemoto.edicao_cliente;

import android.content.Context;

import com.example.todemoto.cadastro_cliente.entity.Cliente;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;

public interface EdicaoClienteContracts {

    interface View {
        void onSavedError(String message);
        void onSavedSucess(String message);
        Context getContext();
        void finish();

    }

    interface Presenter {

        void atualizaDados(Cliente c, String n);
        void goToPerfilCliente();
        void onAtualizadados(String message);
        void onErrorAtualiza(String message);

    }

    interface Interactor {

        void atualizandodados(Cliente c, String n);
    }

    interface Router {
        void goToPerfilCliente();
    }
}
