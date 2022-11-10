package modele;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "client")
public class Client {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="idClient" )
    private int identifiantClient ;

    @ColumnInfo(name ="nomClient")
    private String nomClient ;
    @ColumnInfo(name = "prenomClient")

    private String prenomClient ;
    @ColumnInfo(name = "adresseClient")

    private String adresseClient ;
    @ColumnInfo(name = "codePostalClient")
    private String codePostalClient ;
    @ColumnInfo(name = "villeClient")
    private String villeClient ;


    public int getIdentifiantClient() {
        return identifiantClient;
    }

    public void setIdentifiantClient(int identifiantClient) {
        this.identifiantClient = identifiantClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getCodePostalClient() {
        return codePostalClient;
    }

    public void setCodePostalClient(String codePostalClient) {
        this.codePostalClient = codePostalClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public Client() {

    }

    public Client(int identifiantClient, String nomClient, String prenomClient, String adresseClient, String codePostalClient, String villeClient) {
        this.identifiantClient = identifiantClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresseClient = adresseClient;
        this.codePostalClient = codePostalClient;
        this.villeClient = villeClient;
    }

}
