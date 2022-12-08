package com.equipe1.edfcompteur.database.relevecompteur;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.equipe1.edfcompteur.modele.ReleveCompteur;

import java.util.List;

public interface ReleveCompteurDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ReleveCompteur releveCompteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(ReleveCompteur releveCompteur);

    @Delete
    void delete(ReleveCompteur releveCompteur);

    @Query("DELETE FROM releve_compteur")
    void deleleAll();

    @Query("SELECT idReleve , releve , situationReleve , dateReleve FROM RELEVE_COMPTEUR   ")
    LiveData<List<ReleveCompteur>> getAlphabetizedClients();


}
