package com.equipe1.edfcompteur.modele;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "compteur",
foreignKeys = {@ForeignKey(entity = Client.class,
        parentColumns = "idClient",
        childColumns = "idClientCompteur",
        onDelete = ForeignKey.CASCADE)
})
public class Compteur {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "idCompteur")
    @NonNull
    private int idCompteur;

    @ColumnInfo (name = "idClientCompteur")
    private long idClientCompteur;

    public Compteur() {
    }

    public Compteur(int idCompteur, long idClientCompteur) {
        this.idCompteur = idCompteur;
        this.idClientCompteur = idClientCompteur;
    }

    public int getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    public long getIdClientCompteur() {
        return idClientCompteur;
    }

    public void setIdClientCompteur(long idClientCompteur) {
        this.idClientCompteur = idClientCompteur;
    }
}
