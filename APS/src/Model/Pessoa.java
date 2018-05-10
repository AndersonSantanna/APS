
package Model;

import java.util.Objects;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author anderson
 */
public class Pessoa {
    public String nome, sexo,usuario;
    protected short idade;
    private String senha;
    public Arvore arvore = new Arvore();

    public Pessoa(String nome, String usuario, short idade, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.idade = idade;
        this.senha = senha;
    }
    
    
    
    public Pessoa(String sexo) {
        this.sexo = sexo;
    }

    public Pessoa(TextField Nome, TextField Usuario, TextField Idade, PasswordField passaword, Sexo sexo, TextField arvore ) {
        this.nome = Nome.getText();
        this.usuario = Usuario.getText();
        this.idade = Short.parseShort(Idade.getText());
        this.senha = passaword.getText();
        this.sexo = sexo.getSexo();
        this.arvore.setNome(arvore.getText());
    }
    //Metodo toString

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", usuario=" + usuario + ", idade=" + idade + ", senha=" + senha + ", Arvore="+ arvore.getNome() + '}';
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
