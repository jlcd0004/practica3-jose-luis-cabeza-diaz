
import java.util.Scanner;
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
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        ObtenerDatos od = new ObtenerDatos();
        Autenticacion aut = new Autenticacion();
        String user, nif, nomAp, key, datos, hash, datosEn, user64, nif64, hash64;

        nif = od.LeerNIF();
        nomAp = od.LeerNombreApell();
        user = od.usuario(nomAp);

        System.out.println("NIF: " + nif);
        System.out.println("Nombre: " + nomAp);
        System.out.println("Usuario: " + user);

        System.out.println("\nIntroduzca su clave: ");
        key = scan.nextLine();

        datos = user + nif + key;
        System.out.println("Datos para hash= " + datos);

        hash = od.hashSha1(datos);
        System.out.println("Hash= " + hash);

        user64 = od.base64(user);
        nif64 = od.base64(nif);
        hash64 = od.base64(hash);

        datosEn = "user=" + user64 + "&dni=" + nif64 + "&hash=" + hash64;

        System.out.println("Datos para envio= " + datosEn);
        
        System.out.println(aut.result(datosEn));
        
        
    }

}
