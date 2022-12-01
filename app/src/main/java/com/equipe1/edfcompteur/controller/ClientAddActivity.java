package com.equipe1.edfcompteur.controller;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.view.client.ClientViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class ClientAddActivity extends AppCompatActivity {

    private String actionMode;

    private TextInputEditText idClientView;
    private final TextInputEditText nomClientView;
    private final TextInputEditText prenomClientView;
    private final TextInputEditText adresseClientView;
    private final TextInputEditText codePostalClientView;
    private final TextInputEditText villeClientView;

    private ClientViewModel mClientViewModel;

    public ClientAddActivity(TextInputEditText idClientView, TextInputEditText nomClientView, TextInputEditText prenomClientView, TextInputEditText adresseClientView, TextInputEditText codePostalClientView, TextInputEditText villeClientView, ClientViewModel mClientViewModel) {
        this.idClientView = idClientView;
        this.nomClientView = nomClientView;
        this.prenomClientView = prenomClientView;
        this.adresseClientView = adresseClientView;
        this.codePostalClientView = codePostalClientView;
        this.villeClientView = villeClientView;
        this.mClientViewModel = mClientViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_add);

        // On récupère si on modifie ou on créer un client
        Intent intent = getIntent();
        actionMode = (String) intent.getExtras().get("action");


        // Si on modifie un client, on récupère les données du client
        if (actionMode.equals("update")) {

            // On récupère les données du client
            int idClient = (int) intent.getExtras().get("idClient");
            String nomClient = (String) intent.getExtras().get("nomClient");
            String prenomClient = (String) intent.getExtras().get("prenomClient");
            String adresseClient = (String) intent.getExtras().get("adresseClient");
            String codePostalClient = (String) intent.getExtras().get("codePostalClient");
            String villeClient = (String) intent.getExtras().get("villeClient");

            // On affiche les données du client
            idClientView.setText(String.valueOf(idClient));
            nomClientView.setText(nomClient);
            prenomClientView.setText(prenomClient);
            adresseClientView.setText(adresseClient);
            codePostalClientView.setText(codePostalClient);
            villeClientView.setText(villeClient);


        }



    }
}