package com.equipe1.edfcompteur.database.relevecompteur;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe1.edfcompteur.database.EDFDatabase;
import com.equipe1.edfcompteur.modele.ReleveCompteur;

import java.util.List;

public class ReleveCompteurRepository {

    private ReleveCompteurDAO mReleveCompteurDAO ;

    private LiveData<List<ReleveCompteur>> mAllReleveCompteur;

    public ReleveCompteurRepository(Application application) {
        EDFDatabase db = EDFDatabase.getDatabase(application);
        mReleveCompteurDAO = (ReleveCompteurDAO) db.releveCompteurDAO();

    }

    public LiveData<List<ReleveCompteur>> getAllCompteur() {
        mAllReleveCompteur= mReleveCompteurDAO.getAlphabetizedClients();
        return mAllReleveCompteur;
    }

    public void insert(ReleveCompteur releveCompteur) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mReleveCompteurDAO.insert(releveCompteur);
        });
    }
    public void update(ReleveCompteur releveCompteur) {
        EDFDatabase.databaseWriteExecutor.execute(() -> {
            mReleveCompteurDAO.update(releveCompteur);
        });
    }

        public void delete(ReleveCompteur releveCompteur) {
            EDFDatabase.databaseWriteExecutor.execute(() -> {
                mReleveCompteurDAO.delete(releveCompteur);
            });
        }


}
