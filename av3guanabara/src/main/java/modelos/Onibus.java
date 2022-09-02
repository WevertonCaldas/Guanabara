package modelos;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Onibus {

    int id;
    ArrayList<String> cidadestrajeto;
    String horario;
    ArrayList<Integer> listaPoltronas;

    public Onibus(int id, ArrayList<String> cidadestrajeto, String horario, ArrayList<Integer> listaPoltronas) {
        this.id = id;
        this.cidadestrajeto = cidadestrajeto;
        this.horario = horario;
        this.listaPoltronas = listaPoltronas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getCidadestrajeto() {
        return cidadestrajeto;
    }

    public void setCidadestrajeto(ArrayList<String> cidadestrajeto) {
        this.cidadestrajeto = cidadestrajeto;
    }

    public ArrayList<Integer> getListaPoltronas() {
        return listaPoltronas;
    }

    public void setListaPoltronas(ArrayList<Integer> listaPASSAGENS) {
        this.listaPoltronas = listaPoltronas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
