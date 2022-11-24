package com.equipe1.edfcompteur.controller;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe1.edfcompteur.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mImageViewIdentification = findViewById(R.id.id_client_card);
        mImageViewIdentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Identification = new Intent(MainActivity.this, ClientsListActivity.class);
                startActivity(Identification);
            }
        });

    }
}