package bdcreator;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Field implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;

    private String nombre;
    private String valor;

    public Field() {
    }

    Field(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
         return nombre;
    }

    public String getValor() {
         return valor;
    }

    @Override
    public String toString() {
        return String.format("Nombre: " + this.nombre +
                ", Valor: " + this.valor);
    }
}
