package modelos;

public class MaisCompradas {

    int idOnibus;

    int compradas;

    public MaisCompradas(int idOnibus, int compradas) {
        this.idOnibus = idOnibus;
        this.compradas = compradas;
    }

    public int getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(int idOnibus) {
        this.idOnibus = idOnibus;
    }

    public int getCompradas() {
        return compradas;
    }

    public void setCompradas(int compradas) {
        this.compradas = compradas;
    }
}
