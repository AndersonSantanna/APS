    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.scene.control.TextField;

/**
 *
 * @author ander
 */
public class Arvore {
    private short nivel = 1;
    private double xp = 0;
    private String nome;
    private int idArvore;
    private int qtdPodar;
    private int qtdRegar;
    private int qtdAdubar;
    private int qtdDedetizar;

    public int getQtdPodar() {
        return qtdPodar;
    }

    public void setQtdPodar(int qtdPodar) {
        this.qtdPodar = qtdPodar;
    }

    public int getQtdRegar() {
        return qtdRegar;
    }

    public void setQtdRegar(int qtdRegar) {
        this.qtdRegar = qtdRegar;
    }

    public int getQtdAdubar() {
        return qtdAdubar;
    }

    public void setQtdAdubar(int qtdAdubar) {
        this.qtdAdubar = qtdAdubar;
    }

    public int getQtdDedetizar() {
        return qtdDedetizar;
    }

    public void setQtdDedetizar(int qtdDedetizar) {
        this.qtdDedetizar = qtdDedetizar;
    }
    
    public Arvore (TextField nomeArvore){
        this.nome = nomeArvore.getText();
        if(this.nome.isEmpty()){
            throw new NullPointerException();
        }
    }
    
    public Arvore(String nome,short nivel,double xp,int idArvore,int qtdAdubar,int qtdRegar,int qtdDedetizar,int qtdPodar){
        this.nome = nome;
        this.nivel = nivel;
        this.xp = xp;
        this.idArvore = idArvore;
        this.qtdAdubar = qtdAdubar;
        this.qtdRegar = qtdRegar;
        this.qtdDedetizar = qtdDedetizar;
        this.qtdPodar = qtdPodar;
    }

    public int getIdArvore() {
        return idArvore;
    }

    public void setIdArvore(int idArvore) {
        this.idArvore = idArvore;
    }
    
    public double regar(){
        return xp += 0.05;
        
    }
    public double podar(){
        return xp += 0.03;
    }
    public double eliminarPragas(){
        return xp += 0.04;
        
    }
    public double adubar(){
        return xp += 0.07;
        
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
