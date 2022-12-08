package com.equipe1.edfcompteur.database.compteur;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe1.edfcompteur.database.EDFDatabase;
import androidx.room.Room;
import com.equipe1.edfcompteur.database.compteur.CompteurDAO;

import com.equipe1.edfcompteur.modele.Compteur;

import java.util.List;

public class CompteurRepository {


    private CompteurDAO mCompteurDao;

    private LiveData<List<Compteur>> mAllCompteur;

    public CompteurRepository(Application application) {
        EDFDatabase db = EDFDatabase.getDatabase(application);
        mCompteurDao = db.compteurDAO();

    }


    public LiveData<List<Compteur>> getAllCompteur() {
        mAllCompteur= mCompteurDao.getAlphabetizedClients();
        return mAllCompteur;
    }

    public void insert(Compteur compteur) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mCompteurDao.insert(compteur);
        });
    }
    public void update(Compteur compteur) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mCompteurDao.update(compteur);
        });
    }
    public void delete(Compteur compteur) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mCompteurDao.delete(compteur);
        });
    }
}
