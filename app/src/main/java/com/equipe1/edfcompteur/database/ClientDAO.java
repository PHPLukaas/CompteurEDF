package com.equipe1.edfcompteur.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.equipe1.edfcompteur.modele.Client;

import java.util.List;
@Dao
public interface ClientDAO {


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Client client);

        @Update(onConflict = OnConflictStrategy.IGNORE)
        void update(Client client);

        @Delete
        void delete(Client client);

        @Query("DELETE FROM client")
        void deleleAll();

        @Query("SELECT * FROM client ORDER BY client.idClient ASC")
        LiveData<List<Client>> getAlphabetizedClients();
    }


