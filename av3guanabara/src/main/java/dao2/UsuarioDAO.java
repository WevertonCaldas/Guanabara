package dao2;

import modelos.MaisCompradas;
import modelos.Passagem;
import modelos.Onibus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {

    public ArrayList PassagensCompradas(){
        ArrayList<Passagem> passagens = new ArrayList<>();
        String sql = "SELECT * FROM passagem";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            ResultSet res = pst.executeQuery();
            while(res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nomepassageiro");
                String RG = res.getString("rg");
                float valor = res.getFloat("valor");
                int poltrona = res.getInt("numeropoltrona");
                String cidadeOrigem = res.getString("cidadeorigem");
                String cidadeDestino = res.getString("cidadedestino");
                int idSecundario = res.getInt("idsecundario");


                passagens.add(new Passagem(id, nome, RG, valor, poltrona, cidadeOrigem, cidadeDestino, idSecundario));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagens;
    }

    public boolean Passagem(Passagem passagem){

        String sql = "INSERT INTO passagem(nomepassageiro, rg, valor, numeropoltrona, cidadeorigem, cidadedestino, id, idsecundario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?,?);";

        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ArrayList<Onibus> listaOnibus = listarPassagens();

        try {
            pst.setString(1, passagem.getNomePassageiro());
            pst.setString(2, passagem.getRG());
            pst.setFloat(3, passagem.getValor());
            pst.setInt(4, passagem.getNumeroPoltrona());
            pst.setString(5, passagem.getCidadeOrigem());
            pst.setString(6, passagem.getCidadeDestino());
            pst.setInt(7, new Random().nextInt());
            pst.setInt(8, passagem.getIdSecundario());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

/*
            for(int i = 0; i< listaOnibus.size(); i++) {

                boolean verificarOrigem = listaOnibus.get(i).getCidadestrajeto().contains(passagem.getCidadeOrigem());
                boolean verificarDestino = listaOnibus.get(i).getCidadestrajeto().contains(passagem.getCidadeDestino());
                boolean verificarPoltrona = listaOnibus.get(i).getListaPoltronas().contains(passagem.getNumeroPoltrona());

                if (verificarOrigem && verificarDestino && verificarPoltrona) {

                    pst.setString(1, passagem.getNomePassageiro());
                    pst.setString(2, passagem.getRG());
                    pst.setFloat(3, passagem.getValor());
                    pst.setInt(4, passagem.getNumeroPoltrona());
                    pst.setString(5, passagem.getCidadeOrigem());
                    pst.setString(6, passagem.getCidadeDestino());
                    pst.setInt(7, new Random().nextInt());


                    if (pst.executeUpdate() > 0) {
                        retorno = true;
                    }

                }
            }
*/

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    public ArrayList PassagemPorRG(String rg){

        ArrayList<Passagem> passagens = new ArrayList<>();
        String sql = "SELECT * FROM passagem";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            ResultSet res = pst.executeQuery();
            while(res.next()) {

                String RG = res.getString("rg");
                if(rg.equals(RG)){
                    int id = res.getInt("id");
                    String nome = res.getString("nomepassageiro");
                    float valor = res.getFloat("valor");
                    int poltrona = res.getInt("numeropoltrona");
                    String cidadeOrigem = res.getString("cidadeorigem");
                    String cidadeDestino = res.getString("cidadedestino");
                    int idSecundario = res.getInt("idsecundario");
                    passagens.add(new Passagem(id, nome, RG, valor, poltrona, cidadeOrigem, cidadeDestino,idSecundario));

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagens;
    }

//    public ArrayList Maiscompradas(){
//
//        ArrayList<MaisCompradas> passagens = new ArrayList<>();
//        String sql = "SELECT * FROM passagem";
//        PreparedStatement pst = Conexao.getPreparedStatement(sql);
//
//        try {
//            ResultSet res = pst.executeQuery();
//            while(res.next()) {
//                int idSecundario =  res.getInt("idsecundario");
//
//                if(passagens.contains(idSecundario) ){
//                    for(int i = 0; i < passagens.size();){
//                        if(passagens.get(i).getIdOnibus() == idSecundario){
//                            passagens.add(new MaisCompradas(idSecundario, (passagens.get(i).getCompradas() + 1)));
//                            passagens.remove(i);
//
//                        }
//                    }
//                }else{
//                    passagens.add(new MaisCompradas(idSecundario, 1));
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return passagens;
//    }

    public boolean cadastrarOnibus(Onibus onibus) {
        String sql = "INSERT INTO onibus(id, cidadestrajeto, horario, listapoltronas) VALUES (?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, new Random().nextInt());

            StringBuilder ins = new StringBuilder();
            for(String cidades : onibus.getCidadestrajeto()) {
                ins.append(cidades);
                ins.append(", ");
            }
            ins.delete((ins.length() - 2), ins.length());

            System.out.println(ins.toString());

            pst.setString(2, ins.toString());

            pst.setString(3, onibus.getHorario());

            ins.delete((ins.length() - ins.length()), ins.length());
            for(Integer poltronas : onibus.getListaPoltronas()) {
                ins.append(poltronas);
                ins.append(", ");
            }
            ins.delete((ins.length() - 2), ins.length());

            pst.setString(4, ins.toString());



            if(pst.executeUpdate()>0) {
                retorno = true;
            }

        }  catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }


    public ArrayList listarPassagens() {

        String linha;

        ArrayList<Onibus> passagens = new ArrayList<>();
        String sql = "SELECT * FROM onibus";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            ResultSet res = pst.executeQuery();
            while(res.next()) {

                int id = res.getInt("id");

                linha = res.getString("cidadestrajeto");

                ArrayList<String> trajeto = new ArrayList<>();

                trajeto.add(Arrays.toString(linha.split(", ")));

                String horario = res.getString("horario");

                linha = res.getString("listapoltronas");

                ArrayList<Integer> listapoltronas = new ArrayList<>();

                String dados[] = linha.split(", ");
                for(int i = 0; i < dados.length; i++){
                    listapoltronas.add(Integer.valueOf(dados[i]));
                }
                passagens.add(new Onibus(id, trajeto, horario, listapoltronas));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagens;
    }

    public boolean atualizarOnibus(Onibus onibus)
    {
        String sql = "UPDATE onibus SET cidadestrajeto=?,horario=? WHERE id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            StringBuilder ins = new StringBuilder();
            for(String cidades : onibus.getCidadestrajeto()) {
                ins.append(cidades);
                ins.append(", ");
            }
            ins.delete((ins.length() - 2), ins.length());

            System.out.println(ins.toString());

            pst.setString(1, ins.toString());
            pst.setString(2, onibus.getHorario());
            pst.setInt(3, onibus.getId());



            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }



        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }
    public boolean excluirOnibus(String id)
    {
        String sql = "DELETE FROM onibus where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {


            pst.setInt(1, Integer.parseInt(id));
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean atualizarPassagem(Passagem passagem)
    {
        String sql = "UPDATE passagem set nomepassageiro=?,valor=?,rg=?,cidadeorigem=?,cidadedestino=? WHERE id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, passagem.getNomePassageiro());
            pst.setFloat(2, passagem.getValor());
            pst.setString(3, passagem.getRG());
            pst.setString(4, passagem.getCidadeOrigem());
            pst.setString(5, passagem.getCidadeDestino());
            pst.setInt(6, passagem.getId());

            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }



        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }
    public boolean excluirPassagem(int id)
    {
        String sql = "DELETE FROM passagem where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, id);
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }



        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

}
