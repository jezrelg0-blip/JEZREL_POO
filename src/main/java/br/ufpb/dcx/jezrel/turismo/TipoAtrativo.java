package br.ufpb.dcx.jezrel.turismo;

public enum TipoAtrativo {
    FORMACAO_ROCHOSA("Formação rochosa"), CACHOEIRA("Cachoeira"), PRAIA("Praia"),
    FLORESTA_BOSQUE("Floresta/Bosque"), IGREJA("Igreja"), MUSEU("Museu");

    private final String descricao;

    TipoAtrativo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
