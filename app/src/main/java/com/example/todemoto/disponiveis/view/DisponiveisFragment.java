package com.example.todemoto.disponiveis.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.todemoto.R;
import com.example.todemoto.cadastro_motociclista.entity.Motociclista;
import com.example.todemoto.disponiveis.DisponiveisContracts;
import com.example.todemoto.disponiveis.presenter.DisponiveisPresenter;
import com.example.todemoto.perfil_motociclista.entity.CardMotociclista;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisponiveisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisponiveisFragment extends Fragment implements DisponiveisContracts.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView listaDisponiveis;
    private DisponiveisContracts.Presenter presenter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DisponiveisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisponiveisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisponiveisFragment newInstance(String param1, String param2) {
        DisponiveisFragment fragment = new DisponiveisFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_disponiveis, container, false);
        listaDisponiveis = view.findViewById(R.id.listaDisponiveis);

        presenter = new DisponiveisPresenter(this);

        presenter.buscaDisponiveisCard();

        return view;

    }

    @Override
    public void printaFeedBack(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void listandoDisponieveisCard(List<CardMotociclista> cm) {
        Adapter adapter = new Adapter((ArrayList<CardMotociclista>) cm);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listaDisponiveis.setLayoutManager(layoutManager); //aplicando o linear layout a lista de disponiveis
        listaDisponiveis.setHasFixedSize(true); //mantem a lista com tamanho fixo
        listaDisponiveis.setAdapter(adapter);//monta a visualização personalizada para cada item
    }

    public Context getAplicationContext() {
        return getContext();

    }
}