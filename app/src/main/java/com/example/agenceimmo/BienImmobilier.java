package com.example.agenceimmo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class BienImmobilier {
    private String rue;
    private String ville;
    private String codePostal;
    private Vendeur vendeur;
    private List<Piece> pieces;

    public BienImmobilier(String rue, String ville, String codePostal, Vendeur vendeur) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.vendeur = vendeur;
        this.pieces = new ArrayList<>();
    }

    public double surfaceHabitable(){
        double totalSurface = 0;
        for (Piece piece : pieces) {
            if (piece.getTypePiece().isSurfaceHabitable()) {
                totalSurface += piece.surface();
            }
        }
        return totalSurface;
    }

    public double surfaceNonHabitable(){
        double totalSurface = 0;
        for (Piece piece : pieces) {
            if (!piece.getTypePiece().isSurfaceHabitable()) {
                totalSurface += piece.surface();
            }
        }
        return totalSurface;
    }

    public void ajouterPiece(Piece piece){
        pieces.add(piece);
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

     @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        return "\nLocalisation : " + rue +" " + codePostal + " " + ville + 
        "\n \n Description du bien : \n" +
        pieces.toString()  +  
        "\n\nPour une surface habitable de : " + 
        numberFormat.format(surfaceHabitable())+ 
        " m2 et une surface non habitable de : " + 
        numberFormat.format(surfaceNonHabitable())+" m2.";
    }

}
