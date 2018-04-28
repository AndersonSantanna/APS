package Model;

/**
 *
 * @author anderson
 */
public class Sexo {
    protected int idade;
    protected String sexo;

    public Sexo(int idade, String sexo) {
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return getSexo();
    }
    
}
