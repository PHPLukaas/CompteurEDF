package com.equipe1.edfcompteur.view.client;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.equipe1.edfcompteur.modele.Client;

import java.util.Objects;

public class ClientListAdapter extends ListAdapter<Client, ClientViewHolder> {

    protected ClientListAdapter(@NonNull DiffUtil.ItemCallback<Client> diffCallback) {
        super(diffCallback);
    }

    protected ClientListAdapter(@NonNull AsyncDifferConfig<Client> config) {
        super(config);
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
                /** Intent UpdateClient = new Intent(v.getContext(), UpdateClient.class);
                UpdateClient.putExtra("idClient", current.getIdentifiantClient());
                UpdateClient.putExtra("nomClient", current.getNomClient());
                UpdateClient.putExtra("prenomClient", current.getPrenomClient());
                v.getContext().startActivity(UpdateClient); **/
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
