
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toni
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        ObtenerDatos od = new ObtenerDatos();
        
        String nif = od.LeerNIF();
        String nomAp = od.LeerNombreApell();
        String user = od.usuario(nomAp);
        
        System.out.println("NIF: " + nif);
        System.out.println("Nombre: " + nomAp);
        System.out.println("Usuario: " + user);
        
        System.out.println("\nIntroduzca su clave: ");
        String key = scan.nextLine();
        
        String datos = "user="+user+"&dni="+nif+"&password="+key;
          System.out.println(datos);      
        String hash = od.hashSha1(datos);       
        System.out.println(hash);
        
        String codificado = od.base64(hash);
        System.out.println(codificado);

    }

}
