package modelos;

public class Passagem {

    int id;
    String nomePassageiro;
    String RG;
    float valor;
    int numeroPoltrona;
    String cidadeOrigem;
    String cidadeDestino;

    int idSecundario;


    public Passagem(int id, String nomePassageiro, String RG, float valor, int numeroPoltrona, String cidadeOrigem, String cidadeDestino, int idSecundario) {
        this.id = id;
        this.nomePassageiro = nomePassageiro;
        this.RG = RG;
        this.valor = valor;
        this.numeroPoltrona = numeroPoltrona;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.idSecundario = idSecundario;
    }

    public int getIdSecundario() {
        return idSecundario;
    }

    public void setIdSecundario(int idSecundario) {
        this.idSecundario = idSecundario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getNumeroPoltrona() {
        return numeroPoltrona;
    }

    public void setNumeroPoltrona(int numeroPoltrona) {
        this.numeroPoltrona = numeroPoltrona;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }
}
