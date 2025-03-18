import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner archivo = new Scanner(System.in);
        System.out.println("Ingrese la cadena a eliminar: ");
        String cadena = archivo.nextLine();

        System.out.println("Ingrese el nombre del archivo: ");
        String nombreArchivo = archivo.nextLine();

        File file = new File(nombreArchivo);

        try {
            Scanner leerTexto = new Scanner(file);
            String reemplazar = "";

            while (leerTexto.hasNextLine()) {
                String data = leerTexto.nextLine();
                reemplazar += data.replaceAll(cadena, "");
            }

            FileWriter escribir = new FileWriter(file, false);
            escribir.write(reemplazar);
            escribir.close();

            leerTexto.close();
            archivo.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
