package com.equipe1.edfcompteur.database;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.equipe1.edfcompteur.database.client.ClientDAO;
import com.equipe1.edfcompteur.database.compteur.CompteurDAO;
import com.equipe1.edfcompteur.modele.Client;
import com.equipe1.edfcompteur.modele.Compteur;
import com.equipe1.edfcompteur.modele.ReleveCompteur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class, Compteur.class, ReleveCompteur.class}, version = 1, exportSchema = false)
public abstract class EDFDatabase extends RoomDatabase {
    public abstract ClientDAO clientDao();
    public abstract CompteurDAO compteurDAO();

    public abstract  ReleveCompteur releveCompteurDAO();

    private static volatile EDFDatabase INSTANCE;
    private static final int NUMBER_OF_TREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_TREADS);

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    }; public static EDFDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EDFDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EDFDatabase.class, "edf_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
