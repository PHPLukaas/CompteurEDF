package com.equipe1.edfcompteur.controller;

import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.database.EDFDatabase;
import com.equipe1.edfcompteur.modele.Client;
import com.equipe1.edfcompteur.view.client.ClientListAdapter;
import com.equipe1.edfcompteur.view.client.ClientViewHolder;
import com.equipe1.edfcompteur.view.client.ClientViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClientsListActivity extends AppCompatActivity {

    private ClientViewModel mClientViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ClientListAdapter clientListAdapter = new ClientListAdapter(new ClientListAdapter.ClientDiff());
        recyclerView.setAdapter(clientListAdapter);

        mClientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);
        ClientViewModel clientViewModel = new ClientViewModel(getApplication());
        clientViewModel.getAllClients().observe(this, clientListAdapter::submitList);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ClientsListActivity.this, ClientAddActivity.class);
            intent.putExtra("action", "create");
            NewClientActivityResultLauncher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> NewClientActivityResultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {

                            if (result.getResultCode() == RESULT_OK) {
                                assert result.getData() != null;

                                Client client = new Client(
                                        0,
                                        result.getData().getStringExtra(ClientAddActivity.EXTRA_REPLY_NOM),
                                        result.getData().getStringExtra(ClientAddActivity.EXTRA_REPLY_PRENOM),
                                        result.getData().getStringExtra(ClientAddActivity.EXTRA_REPLY_ADRESSE),
                                        result.getData().getStringExtra(ClientAddActivity.EXTRA_REPLY_CODEPOSTAL),
                                        result.getData().getStringExtra(ClientAddActivity.EXTRA_REPLY_VILLE)
                                );

                                EDFDatabase.databaseWriteExecutor.execute(() -> mClientViewModel.insert(client));
                                clientInsere();

                            } else {
                                clientNonInsere();
                            }
                        }

                        // onActivityResult de la modification d'un client

                    });

    private void clientInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Résultat :")
                .setMessage("Client inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {

                })
                .create()
                .show();
    }

    private void clientNonInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Problème :")
                .setMessage("Client non inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {

                })
                .create()
                .show();
    }


}