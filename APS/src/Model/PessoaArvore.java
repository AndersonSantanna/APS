/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author gustavo
 */
public class PessoaArvore {

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Arvore getArvore() {
        return arvore;
    }

    public void setArvore(Arvore arvore) {
        this.arvore = arvore;
    }
    
    private Pessoa pessoa;
    private Arvore arvore;
    
    
    public PessoaArvore(Pessoa pessoa,Arvore arvore){
        this.pessoa = pessoa;
        this.arvore = arvore;
    }
    
}
