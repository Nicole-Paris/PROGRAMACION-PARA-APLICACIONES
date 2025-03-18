import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        
        Scanner archivo = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo: ");
        String nombreArchivo = archivo.nextLine();

        File file = new File(nombreArchivo);

        try {
            int caracteres = 0;
            int palabras = 0;
            int lineas = 0;

            ArrayList<Character> letras = new ArrayList<>();

            Scanner lectorTexto = new Scanner(file);

            while (lectorTexto.hasNextLine()) {
                String data = lectorTexto.nextLine();

                for (int i = 0; i < data.length(); i++) {
                    char caracter = data.charAt(i);
                    letras.add(caracter);
                }
                lineas++;
            }

            for (int i = 0; i < letras.size(); i++) {
                caracteres++;

                if (letras.get(i) == ' ' || letras.get(i) == '\n') {
                    palabras++;
                }
                System.out.println(letras.get(i));
            }

            palabras++;


            System.out.println("El archivo tiene: ");
            System.out.println("Caracteres: " + caracteres);
            System.out.println("Palabras: " + palabras);
            System.out.println("Lineas: " + lineas);

            lectorTexto.close();
            archivo.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
    