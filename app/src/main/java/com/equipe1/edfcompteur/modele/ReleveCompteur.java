package com.equipe1.edfcompteur.modele;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.util.Date;

@Entity(tableName = "releve_compteur",
        foreignKeys = {@ForeignKey(entity = Compteur.class,
        parentColumns = "idCompteur",
        childColumns = "idCompteurClient",
        onDelete = ForeignKey.CASCADE)})

public class ReleveCompteur {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idReleve")
    private int idReleveCompteur;

    @ColumnInfo(name = "releve")
    private double releveCompteur;
    @ColumnInfo(name = "dateReleve")
    private Date dateReleveCompeteur;
    @ColumnInfo(name = "situationReleve")
    private int situationReleve;
    @ColumnInfo(name = "idCompteurClient")
    private long idCompteurClient;

    public ReleveCompteur(){}

    public ReleveCompteur(int id, double releve, Date dateReleve, int situation, long idCompteurClient){

        this.idReleveCompteur = id;
        this.releveCompteur = releve;
        this.dateReleveCompeteur = dateReleve;
        this.situationReleve = situation;
        this.idCompteurClient = idCompteurClient;

    }

    public int getIdReleveCompteur(){
        return idReleveCompteur;
    }

    public void setIdReleveCompteur(int idReleveCompteur) {
        this.idReleveCompteur = idReleveCompteur;
    }

    public double getReleveCompteur(){
        return releveCompteur;
    }

    public void setReleveCompteur(double releveCompteur) {
        this.releveCompteur = releveCompteur;
    }

    public Date getDateReleveCompeteur() {
        return dateReleveCompeteur;
    }

    public void setDateReleveCompeteur(Date dateReleveCompeteur) {
        this.dateReleveCompeteur = dateReleveCompeteur;
    }

    public int getSituationReleve() {
        return situationReleve;
    }

    public void setSituationReleve(int situationReleve) {
        this.situationReleve = situationReleve;
    }
}
