package com.equipe1.edfcompteur.database.client;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe1.edfcompteur.database.EDFDatabase;
import com.equipe1.edfcompteur.modele.Client;

import java.util.List;

public class ClientRepository {

    private ClientDAO mClientDao;
    private LiveData<List<Client>> mAllClients;

    public ClientRepository(Application application) {
        EDFDatabase db = EDFDatabase.getDatabase(application);
        mClientDao = db.clientDao();
    }
    public LiveData<List<Client>> getAllClients() {
        mAllClients = mClientDao.getAlphabetizedClients();
        return mAllClients;
    }

    public void insert(Client client) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insert(client);
        });
    }
    public void update(Client client) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.update(client);
        });
    }
    public void delete(Client client) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.delete(client);
        });
    }

}
