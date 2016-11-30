package serviciospublicos.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiciosPublicosApi {

    private static final String SEP = System.getProperty("line.separator");

    public static void main(String[] args) {
        //traerIndicador();
        traerIndicadorTipoFecha("utm", "28-11-2016");
    }

    public static String traerIndicadorString() {
        String ruta = "http://www.mindicador.cl/api";
        JSONArray arr = new JSONArray();
        try {
            URL url = new URL(ruta);
            URLConnection urlc = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
                arr = new JSONArray(line);
            }
        } catch (IOException | JSONException ex) {
            System.out.println("Error al obtener los datos del WebService." + SEP + ex);
        }
        return arr.toString();
    }

    public static JSONArray traerIndicadorJson() {
        String ruta = "http://www.mindicador.cl/api";
        JSONArray arr = new JSONArray();
        try {
            URL url = new URL(ruta);
            URLConnection urlc = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
                arr = new JSONArray(line);
            }
        } catch (IOException | JSONException ex) {
            System.out.println("Error al obtener los datos del WebService." + SEP + ex);
        }
        return arr;
    }

    public static JSONArray traerIndicadorTipo(String tipo) {
        String ruta = "http://www.mindicador.cl/api/" + tipo;
        JSONArray arr = new JSONArray();
        try {
            URL url = new URL(ruta);
            URLConnection urlc = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            //arr = new JSONArray(builder.toString());
            JSONObject json = new JSONObject(builder.toString());
            JSONArray arreglo = json.getJSONArray("serie");
            return arreglo;
        } catch (IOException | JSONException ex) {
            System.out.println("Error al obtener los datos del WebService." + SEP + ex);
        }
        return new JSONArray();
    }

    public static void traerIndicadorTipoFecha(String tipo, String fecha) {
        String ruta = "http://www.mindicador.cl/api/" + tipo + "/" + fecha;
        JSONArray arr = new JSONArray();
        try {
            URL url = new URL(ruta);
            URLConnection urlc = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            //arr = new JSONArray(builder.toString());
            JSONObject json = new JSONObject(builder.toString());
            JSONArray arreglo = json.getJSONArray("serie");
            System.out.println("Arreglo: " + arreglo);
        } catch (IOException | JSONException ex) {
            System.out.println("Error al obtener los datos del WebService." + SEP + ex);
        }
    }
}
