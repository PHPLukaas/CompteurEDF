package com.equipe1.edfcompteur.database.compteur;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.equipe1.edfcompteur.modele.Compteur;

import java.util.List;

public interface CompteurDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Compteur compteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Compteur compteur);

    @Delete
    void delete(Compteur compteur);

    @Query("DELETE FROM compteur")
    void deleleAll();

    @Query("SELECT idCompteur , idClientCompteur FROM compteur ORDER BY compteur.idCompteur ASC")
    LiveData<List<Compteur>> getAlphabetizedClients();


}
