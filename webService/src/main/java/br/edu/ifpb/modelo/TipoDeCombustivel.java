package br.edu.ifpb.modelo;

/**
 * Created by Edilva on 27/03/2018.
 */

public enum TipoDeCombustivel {

    GASOLINA_COMUM("Gasolina Comum"),
    GASOLINA_ADITIVADA("Gasolina Aditivada"),
    GASOLINA_PREMIUM("Gasolina Premium"),
    ETANOL_COMUM("Etanol Comum"),
    ETANOL_ADITIVADO("Etanol Aditivado"),
    DIESEL_COMUM("Diesel Comum"),
    DIESEL_ADITIVADO("Diesel Aditivado"),
    DIESEL_PREMIUM("Diesel Premium"),
    DISEL_S_10("Diesel S-10"),
    GNV("GNV (Gás Natural Veicular)");

    private final String descricao;

    TipoDeCombustivel(String descricao) {
        this.descricao = descricao;
    }
   

    public String getDescricao() {
        return descricao;
    }
}
