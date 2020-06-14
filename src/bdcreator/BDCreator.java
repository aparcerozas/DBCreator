package bdcreator;

import javax.swing.JOptionPane;

public class BDCreator {

    public static void main(String[] args) {
        String nombreBD = JOptionPane.showInputDialog("Hola. Bienvenido a BDCreator.\n"
                + "Para comenzar, escoja el nombre de la base de datos "
                + "con la que desea trabajar.\n"
                + "Si la base de datos no existe, se creara una nueva");
        int contador = 0;
        
        ObjectDBFunctions.conexion(nombreBD);
        
        do{
           String respuesta = JOptionPane.showInputDialog("Su base de datos ha sido creada. "
                   + "Ahora escoja que desea hacer a continuacion:\n"
                   + "1. Crear campo\n2. Mostrar todos los campos\n3. Consultar campo\n"
                   + "4. Eliminar campo\n5. Salir");
           
           switch(respuesta) {
               case "1": String nombreF = JOptionPane.showInputDialog
                   ("Inserte el nombre del campo:");
                   String valorF = JOptionPane.showInputDialog
                   ("Inserte el valor del campo:");
                   ObjectDBFunctions.insertarCampo(nombreF, valorF);
                   break;
               case "2": ObjectDBFunctions.mostrarCampos();
                   break;
               case "3": String opcion1 = JOptionPane.showInputDialog
                   ("Desea consultar por nombre o valor?:");
                   switch(opcion1) {
                       case "nombre": ObjectDBFunctions.consultarCampoPorNombre();
                           break;
                       case "valor": ObjectDBFunctions.consultarCampoPorValor();
                           break;
                       default:
                   }
                   break;
               case "4": String opcion2 = JOptionPane.showInputDialog
                   ("Desea eliminar por nombre o valor?:");
                   switch(opcion2) {
                       case "nombre": ObjectDBFunctions.eliminarCampoPorNombre();
                           break;
                       case "valor": ObjectDBFunctions.eliminarCampoPorValor();
                           break;
                       default:
                   }
                   break;
               case "5": contador = 1;
                   break;
               default:
           }
        }while(contador == 0);
        
        ObjectDBFunctions.desconexion();
        
    }
    
}
