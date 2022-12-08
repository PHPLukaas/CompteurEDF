package com.equipe1.edfcompteur.controller;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.database.client.ClientRepository;
import com.equipe1.edfcompteur.modele.Client;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mImageReleveCompteur = findViewById(R.id.btnFacture);

        // TEST
        Client testClient = new Client(1, "test", "test", "test", "test", "test");
        ClientRepository repoTest = new ClientRepository(getApplication());
        repoTest.insert(testClient);

        Client testClient1 = new Client(2, "Lukas", "LOL", "test", "test", "test");
        ClientRepository repoTest1 = new ClientRepository(getApplication());
        repoTest1.insert(testClient1);
        // FIN TEST
        mImageReleveCompteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReleveCompteur = new Intent(MainActivity.this, ClientsListActivity.class);
                startActivity(ReleveCompteur);
            }
        });

    }
}