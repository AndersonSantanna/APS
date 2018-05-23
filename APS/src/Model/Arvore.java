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
    private float xp = 0;
    private String nome;
    private int idArvore;
    
    public Arvore (TextField nomeArvore){
        this.nome = nomeArvore.getText();
        if(this.nome.isEmpty()){
            throw new NullPointerException();
        }
    }

    public int getIdArvore() {
        return idArvore;
    }

    public void setIdArvore(int idArvore) {
        this.idArvore = idArvore;
    }
    
    public float regar(){
        return xp += 0.05;
        
    }
    public float poldar(){
        return xp += 0.03;
        
    }
    public float eliminarPragas(){
        return xp += 0.04;
        
    }
    public float adubar(){
        return xp += 0.07;
        
    }

    public float getXp() {
        return xp;
    }

    public void setXp(float xp) {
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
