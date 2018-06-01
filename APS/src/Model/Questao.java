/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Questao {
    private String questao;
    private ArrayList<Resposta> respostas;
    private int respCerta;
    private int id;
    
    public Questao(){
        
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public int getRespCerta() {
        return respCerta;
    }

    public void setRespCerta(int respCerta) {
        this.respCerta = respCerta;
    }
}
