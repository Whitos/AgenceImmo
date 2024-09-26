package com.example.agenceimmo;

public class Appartement extends BienImmobilier{
    private String etage;
    private boolean ascenseur;

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = false;
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage, boolean ascenseur) {
        super(rue, ville, codePostal, vendeur);
        this.etage = etage;
        this.ascenseur = ascenseur;
    }

    public String typeBien(){
        int nombreDePieces = 0;

        for (Piece piece : getPieces()) {
            if (piece.getTypePiece().isSurfaceHabitable()) {
                nombreDePieces++;
            }
        }

        if (nombreDePieces > 7) {
            return "T7+";
        }

        return "T" + nombreDePieces;
    }

    @Override
    public String toString() {
        String resultat ="";
        resultat = "Appartement de type "+ typeBien();
        if(ascenseur){
            resultat += " avec ascenseur ";
        }
        resultat += " situé au " + etage + " ";
        resultat += super.toString();
        return resultat;
    }

}
