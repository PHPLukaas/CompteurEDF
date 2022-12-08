package com.equipe1.edfcompteur.view.client;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.equipe1.edfcompteur.R;
import com.equipe1.edfcompteur.controller.ClientAddActivity;
import com.google.android.material.button.MaterialButton;

public class ClientViewHolder extends RecyclerView.ViewHolder {

    private final TextView clientItemViewId;
    private final TextView clientItemViewNom;
    private final TextView clientItemViewPrenom;

    public ClientViewHolder(@NonNull View itemView) {
        super(itemView);

        this.clientItemViewId = itemView.findViewById(R.id.id_client_card);
        this.clientItemViewNom = itemView.findViewById(R.id.hint_nom_client_card);
        this.clientItemViewPrenom = itemView.findViewById(R.id.hint_prenom_client_card);
    }

    public void bind(int textIdClient, String textNomClient, String textPrenomClient) {
        clientItemViewId.setText("Client n°" + Integer.toString(textIdClient));
        clientItemViewNom.setText(textNomClient);
        clientItemViewPrenom.setText(textPrenomClient);
    }

    public static ClientViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardclient, parent, false);
        return new ClientViewHolder(view);
    }
}
