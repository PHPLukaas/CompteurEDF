package com.equipe1.edfcompteur.view;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.equipe1.edfcompteur.modele.Client;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private ClientRepository mClient;
    private final LiveData<List<Client>> mAllClients;

    public ViewModel(@NonNull Application application) {
        super(application);
        this.mClient = new ClientRepository(application);
        this.mAllClients = mClient.getAllClients();
    }

    public LiveData<List<Client>> getAllClients() {
        return mAllClients;
    }

    public void insert(Client client) {
        mClient.insert(client);
    }

    public void delete(Client client) {
        mClient.delete(client);
    }

    public void update(Client client) {
        mClient.update(client);
    }



}
