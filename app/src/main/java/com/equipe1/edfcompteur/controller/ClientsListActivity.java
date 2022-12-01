package com.equipe1.edfcompteur.controller;

import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.view.client.ClientListAdapter;
import com.equipe1.edfcompteur.view.client.ClientViewHolder;
import com.equipe1.edfcompteur.view.client.ClientViewModel;

public class ClientsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ClientListAdapter clientListAdapter = new ClientListAdapter(new ClientListAdapter.ClientDiff());
        recyclerView.setAdapter(clientListAdapter);

        ClientViewModel clientViewModel = new ClientViewModel(getApplication());
        clientViewModel.getAllClients().observe(this, clientListAdapter::submitList);


    }
}