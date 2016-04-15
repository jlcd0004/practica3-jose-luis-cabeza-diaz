
import java.util.Scanner;

/**
 *
 * @author Jose Luis
 */
public class Main {

    /**
     * En la función principal, haciendo uso de las funciones de las clases
     * ObtenerDatos.java y Autenticacion.java, se obtienen los datos del
     * DNIe del usuario y se le pide que introduzca su clave asi como que
     * seleccione el tipo de autenticación deseada.
     * Finalmente se muestra el resultado de la autenticación.
     * 
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        ObtenerDatos od = new ObtenerDatos();
        Autenticacion aut = new Autenticacion();
        String user, nif, nomAp, key, datos, hash, datosEn, user64, nif64, hash64, key64;
        int tipo = 0;

        nif = od.LeerNIF();
        nomAp = od.LeerNombreApell();
        user = od.usuario(nomAp);

        System.out.println("NIF: " + nif);
        System.out.println("Nombre y apellidos: " + nomAp);
        System.out.println("Usuario: " + user);
        
        while (tipo != 3) {
            System.out.print("\nSeleccione tipo de autenticado: "
                    + "\n1-Simple"
                    + "\n2-Hash"
                    + "\n3-Salir"
                    + "\n\nOpcion: ");
            tipo = scan.nextInt();
            scan.nextLine();

            switch (tipo) {
                case 1:
                    System.out.print("\nIntroduzca su clave: ");
                    key = scan.nextLine();

                    user64 = od.base64(user);
                    nif64 = od.base64(nif);
                    key64 = od.base64(key);

                    datosEn = "user=" + user64 + "&dni=" + nif64 + "&password=" + key64;

                    System.out.println("\nDatos para envio= " + datosEn);

                    System.out.println(aut.result(datosEn));
                    break;

                case 2:
                    System.out.print("\nIntroduzca su clave: ");
                    key = scan.nextLine();

                    datos = user + nif + key;
                    System.out.println("\nDatos para hash= " + datos);

                    hash = od.hashSha1(datos);
                    System.out.println("Hash= " + hash);

                    user64 = od.base64(user);
                    nif64 = od.base64(nif);
                    hash64 = od.base64(hash);

                    datosEn = "user=" + user64 + "&dni=" + nif64 + "&hash=" + hash64;

                    System.out.println("Datos para envio= " + datosEn);

                    System.out.println("\nRESULTADO --> " + aut.result(datosEn));
                    break;

            }
        }

        System.out.println("\n¡Adios!");
    }
}
