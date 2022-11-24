package com.equipe1.edfcompteur.controller;

import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.view.client.ClientViewHolder;

public class ClientsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView mListView = findViewById(R.id.recyclerview);
        ClientViewHolder adapter = new ClientViewHolder(this.getCurrentFocus());
        mListView.setAdapter((ListAdapter) adapter);

        setContentView(R.layout.activity_clients_list);



    }
}