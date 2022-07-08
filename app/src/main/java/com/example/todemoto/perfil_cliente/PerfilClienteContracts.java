package com.example.todemoto.perfil_cliente;

import android.content.Context;

import com.example.todemoto.cadastro_cliente.entity.Cliente;

public interface PerfilClienteContracts {
    interface View {
        void onCarregarInfoErro(String message);
        Context getContext();
        void carregarTelaCliente(Cliente c);
        void chamaEdicaoCliente(Cliente c);
        void finish();

    }
    interface Presenter {
        void carregarInfoCliente();
        void onCarregarInfoCliente(Cliente c);
        void goToEditarPerfilCliente(Cliente c);
        void logOutCliente();
        void onLogOutCliente();
        void chamaEdicaoCliente(Cliente c);

        void onErroCarregarInfoCliente(String message);
    }

    interface Interactor {
        void carregandoInfoCliente();
        void logOutingCliente();
    }

    interface Router {
        void goToEditarPerfilCliente(Cliente c);
        void goToLogin();
    }

}
