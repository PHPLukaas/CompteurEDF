package com.equipe1.edfcompteur.view.client;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.equipe1.edfcompteur.controller.ClientAddActivity;
import com.equipe1.edfcompteur.modele.Client;

import java.util.Objects;

public class ClientListAdapter extends ListAdapter<Client, ClientViewHolder> {

    public ClientListAdapter(@NonNull DiffUtil.ItemCallback<Client> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ClientViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {

        Client current = getItem(position);
        holder.bind(current.getIdentifiantClient(), current.getNomClient(), current.getPrenomClient());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProfilClient = new Intent(v.getContext(), ClientAddActivity.class);
                ProfilClient.putExtra("idClient", current.getIdentifiantClient());
                ProfilClient.putExtra("nomClient", current.getNomClient());
                ProfilClient.putExtra("prenomClient", current.getPrenomClient());
                ProfilClient.putExtra("adresseClient", current.getAdresseClient());
                ProfilClient.putExtra("codePostalClient", current.getCodePostalClient());
                ProfilClient.putExtra("villeClient", current.getVilleClient());
                ProfilClient.putExtra("action", "update");
                v.getContext().startActivity(ProfilClient);
            }
        });
    }


    public static class ClientDiff extends DiffUtil.ItemCallback<Client> {

        @Override
        public boolean areItemsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return Objects.equals(oldItem.getIdentifiantClient(), newItem.getIdentifiantClient());
        }
    }
}
