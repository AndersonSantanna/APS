package Model;

import java.util.Objects;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author anderson
 */
public class Pessoa {
    private String nome, sexo,usuario;
    protected short idade;
    private int id;
    private String senha;

    public Pessoa(String nome, String usuario, short idade, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.idade = idade;
        this.senha = senha;
    }
    
    public Pessoa(String nome, String usuario, int id) {
        this.nome = nome;
        this.usuario = usuario;
        this.id = id;
        this.senha = senha;
    }
    
    
    public Pessoa(String nome,String usuario,short id){
        this.usuario = usuario;
        this.nome = nome;
        this.id = id;
    }
    
    public Pessoa(String sexo) {
        this.sexo = sexo;
    }

    public Pessoa(String usuario,String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Pessoa(TextField usuario,PasswordField senha) {
        this.usuario = usuario.getText();
        if(this.usuario.isEmpty()){
            throw new NullPointerException();
        }
        this.senha = senha.getText();
                if(this.senha.isEmpty()){
            throw new NullPointerException();
        }
    }
    
    public Pessoa(TextField nome, TextField usuario, TextField idade,PasswordField senha,String sexo) {
        this.nome = nome.getText();
        if(this.nome.isEmpty()){
            throw new NullPointerException();
        }
        this.usuario = usuario.getText();
        if(this.usuario.isEmpty()){
            throw new NullPointerException();
        }
        this.idade = Short.parseShort(idade.getText());
        if(this.idade == 0){
            throw new NullPointerException();
        }
        this.senha = senha.getText();
        if(this.senha.isEmpty()){
            throw new NullPointerException();
        }
        this.sexo = sexo;
        if(this.senha.isEmpty()){
            throw new NullPointerException();
        }
    }
    //Metodo toString

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", usuario=" + usuario + ", idade=" + idade + ", senha=" + senha ;
    }
    
    
    //Metodos equals e hascode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    //Metodos Getters and Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }
}
