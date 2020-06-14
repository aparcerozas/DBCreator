package bdcreator;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ObjectDBFunctions {
    
    public ObjectDBFunctions() {};
    
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    public static void conexion(String nombreBD) {
        emf = Persistence.createEntityManagerFactory
        ("/home/oracle/objectdb-2.7.5_01/db/" + nombreBD + ".odb");
        em = emf.createEntityManager();
    }
    
    public static void desconexion() {
        em.close();
        emf.close();
    }
    
    public static void insertarCampo(String nombre, String valor) {
        em.getTransaction().begin();
        Field p = new Field(nombre, valor);
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public static void mostrarCampos() {
        TypedQuery<Field> query =
            em.createQuery("SELECT f FROM Field f", Field.class);
        List<Field> results = query.getResultList();
        for (Field p : results) {
            System.out.println(p);
        }
    }
    
    public static void consultarCampoPorNombre() {
        String nombre = JOptionPane.showInputDialog
            ("Inserte el nombre del campo que desea consultar:");
        TypedQuery<Field> query =em.createQuery
            ("SELECT f FROM Field f WHERE nombre = '" + nombre + "'", Field.class);
        List<Field> results = query.getResultList();
        for (Field p : results) {
            System.out.println(p);
        }
    }
    
    public static void consultarCampoPorValor() {
        String valor = JOptionPane.showInputDialog
            ("Inserte el valor del campo que desea consultar:");
        TypedQuery<Field> query =em.createQuery
            ("SELECT f FROM Field f WHERE valor = '" + valor + "'", Field.class);
        List<Field> results = query.getResultList();
        for (Field p : results) {
            System.out.println(p);
        }
    }
    
    public static void eliminarCampoPorNombre() {
        String nombre = JOptionPane.showInputDialog
            ("Inserte el nombre del campo que desea eliminar:");
        TypedQuery<Field> query =
            em.createQuery("SELECT f FROM Field f", Field.class);
        List<Field> results = query.getResultList();
        for (Field p : results) {
            if (p.getNombre() == nombre) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        }
    }
    
    public static void eliminarCampoPorValor() {
        String valor = JOptionPane.showInputDialog
            ("Inserte el valor del campo que desea eliminar:");
        TypedQuery<Field> query =
            em.createQuery("SELECT f FROM Field f", Field.class);
        List<Field> results = query.getResultList();
        for (Field p : results) {
            if (p.getValor() == valor) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        }
    }
}
