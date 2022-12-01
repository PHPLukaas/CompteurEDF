package com.equipe1.edfcompteur.controller;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.view.client.ClientViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class ClientAddActivity extends AppCompatActivity {

    public static int EXTRA_REPLY_IDCLIENT = 0;
    public static String EXTRA_REPLY_NOM = "nom";
    public static String EXTRA_REPLY_PRENOM = "prenom";
    public static String EXTRA_REPLY_ADRESSE = "adresse";
    public static String EXTRA_REPLY_CODEPOSTAL = "codepostal";
    public static String EXTRA_REPLY_VILLE = "ville";

    private String actionMode;

    private TextInputEditText idClientView;
    private TextInputEditText nomClientView;
    private TextInputEditText prenomClientView;
    private TextInputEditText adresseClientView;
    private TextInputEditText codePostalClientView;
    private TextInputEditText villeClientView;

    private Button suppClientView;
    private Button saveClientView;

    

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

        // On récupère les éléments de la vue
        idClientView = findViewById(R.id.idClient);
        nomClientView = findViewById(R.id.nom);
        prenomClientView = findViewById(R.id.prenom);
        adresseClientView = findViewById(R.id.adresse);
        codePostalClientView = findViewById(R.id.codePostal);
        villeClientView = findViewById(R.id.ville);
        suppClientView = findViewById(R.id.btnSuppr);
        saveClientView = findViewById(R.id.btnAdd);



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



        }else if (actionMode.equals("create")) {
            // Si on créer un client, on vide les champs
            idClientView.setText("");
            nomClientView.setText("");
            prenomClientView.setText("");
            adresseClientView.setText("");
            codePostalClientView.setText("");
            villeClientView.setText("");

            // On désactive le champ idClient
            idClientView.setEnabled(false);

            // On désactive le bouton supprimer
            suppClientView.setEnabled(false);


        }



    }
}