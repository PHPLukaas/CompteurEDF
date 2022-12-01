package com.equipe1.edfcompteur.controller;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.view.client.ClientViewModel;

public class ClientAddActivity extends AppCompatActivity {

    private String actionMode;
    private ClientViewModel mClientViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_add);

        // On récupère si on modifie ou on créer un client
        Intent intent = getIntent();
        actionMode = (String) intent.getExtras().get("action");


        // Si on modifie un client, on récupère les données du client
        if (actionMode.equals("update")) {



        }



    }
}