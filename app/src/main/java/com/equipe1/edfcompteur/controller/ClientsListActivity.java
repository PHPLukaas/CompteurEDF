package com.equipe1.edfcompteur.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.view.client.ClientViewHolder;

public class ClientsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);

        ClientViewHolder clientViewHolder = new ClientViewHolder(this.getCurrentFocus());
    }
}