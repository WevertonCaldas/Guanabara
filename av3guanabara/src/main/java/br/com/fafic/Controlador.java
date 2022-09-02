package br.com.fafic;
import dao2.*;
import com.google.gson.Gson;
import modelos.Passagem;
import modelos.Onibus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class Controlador {

    @RequestMapping("/")
    public String iniciar(){
        return "------Expresso Guanabara------";
    }

    @GetMapping("/ListarOnibus")
    public ArrayList onibus(){
        UsuarioDAO banco = new UsuarioDAO();
        return banco.listarPassagens();
    }

//    @GetMapping("/PassagensMaisCompradas")
//    public ArrayList maiscompradas(){
//        UsuarioDAO banco = new UsuarioDAO();
//        return banco.Maiscompradas();
//    }

    @GetMapping("/ListarPassagens")
    public ArrayList Passagens(){
        UsuarioDAO banco = new UsuarioDAO();
        return banco.PassagensCompradas();
    }

    @GetMapping("/ListarPassagensPorRG/{rg}")
    public ArrayList PassagemPorRG(@PathVariable("rg") String rg){
        UsuarioDAO banco = new UsuarioDAO();
        System.out.println(banco.PassagemPorRG(rg));
        return banco.PassagemPorRG(rg);
    }

    @PostMapping(value = "/CadastrarOnibus", consumes = "application/json", produces = "application/json")
    public String cadastrarOnibus(@RequestBody Onibus onibus){
        UsuarioDAO banco = new UsuarioDAO();
        boolean cadastro = banco.cadastrarOnibus(onibus);
        if(cadastro){
            return "Onibus cadastrado com sucesso!!";
        }else{
            return "Não foi possivel concluir o cadastro!";
        }
    }


    @PostMapping(value = "/ComprarPassagem", consumes = "application/json", produces = "application/json")
    public String comprarPassagem(@RequestBody Passagem passagem){

        UsuarioDAO banco = new UsuarioDAO();
        boolean cadastro = banco.Passagem(passagem);

        if(cadastro){
            return "Passagem comprada com sucesso!!";
        }else{
            return "Nao foi possivel concluir a compra!";
        }
    }

    @PostMapping(value = "/AtualizarOnibus", consumes = "application/json", produces = "application/json")
    public String atualizarOnibus(@RequestBody Onibus onibus){
        UsuarioDAO banco = new UsuarioDAO();
        boolean atualizada = banco.atualizarOnibus(onibus);
       if(atualizada){
            return "Onibus atualizado com sucesso!!";
       }else{
            return "Nao foi possivel concluir a atualizacao!";
       }
    }

    @GetMapping("/ExcluirOnibus/{id}")
    public String excluirOnibus(@PathVariable("id") String id){

        UsuarioDAO banco = new UsuarioDAO();
        boolean deletado = banco.excluirOnibus(id);
        if(deletado){
            return "Onibus excluido com sucesso!!";
        }else{
            return "Nao foi possivel concluir a excluicao!";
        }
    }

    @PostMapping(value = "/AtualizarPassagem", consumes = "application/json", produces = "application/json")
    public String atualizarPassagem(@RequestBody Passagem passagem){
        UsuarioDAO banco = new UsuarioDAO();
        boolean atualizada = banco.atualizarPassagem(passagem);
        if(atualizada){
            return "Passagem atualizada com sucesso";
        }else{
            return "Não foi possivel concluir a atualização";
        }
    }

    @GetMapping("/ExcluirPassagem/{id}")
    public String excluirPassagem(@PathVariable("id") String id){
        UsuarioDAO banco = new UsuarioDAO();
        boolean deletado = banco.excluirPassagem(Integer.parseInt(id));
        if(deletado){
            return "Passagem excluida com sucesso";
        }else{
            return "Não foi possivel concluir a excluição";
        }
    }


}
