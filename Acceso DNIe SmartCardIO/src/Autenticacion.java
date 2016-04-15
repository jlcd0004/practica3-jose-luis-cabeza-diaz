
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Jose Luis
 */
public class Autenticacion {

    /**
     * Esta función efectúa una petición HTTP de tipo GET a autentica.php.
     * 
     * @param datos Datos a enviar al servidor.
     * @return respuesta Respuesta del servidor.
     * @throws MalformedURLException
     * @throws IOException 
     */
    public String peticionGet(String datos) throws MalformedURLException, IOException {
        String respuesta = null;
        URL url = new URL("http://localhost:80/dnie/autentica.php?" + datos);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((rd.readLine()) != null) {
            respuesta = respuesta + rd.readLine();
        }
        rd.close();
        return respuesta;
    }

    /**
     * Esta función determina si la autenticación ha sido exitosa o no basándose
     * en si la respuesta del servidor (ejecuta una petición GET con la función
     * peticionGet(datos)) contiene el fragmento de texto "No se encuentra".
     * 
     * @param datos Datos a enviar al servidor.
     * @return Resultado del análisis.
     * @throws IOException 
     */
    public String result(String datos) throws IOException {
        String res;
        Autenticacion aut = new Autenticacion();
        String respuesta = aut.peticionGet(datos);
        if (respuesta.contains("No se encuentra")) {

            res = "Autenticacion incorrecta.";

        } else {

            res = "Autenticacion correcta.";

        }
        return res;
    }
}
