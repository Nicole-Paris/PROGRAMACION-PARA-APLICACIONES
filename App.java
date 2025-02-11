import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa el número de candidatos: ");
        int numCandidatos = scanner.nextInt();
        int[] votos = new int[numCandidatos + 1]; // Arreglo de tamaño dinámico según candidatos
        int[] candidatos = new int[numCandidatos + 1]; // Almacenar los números de los candidatos
        int totalVotos = 0;
        int maxVotos = 0;

        System.out.println("Ingresa los votos (número del candidato). Ingresa 0 para finalizar:");
        while (true) {
            int voto = scanner.nextInt();
            if (voto == 0) {
                break;
            }
            if (voto >= 1 && voto <= numCandidatos) {
                if (votos[voto] == 0) {
                    candidatos[voto] = voto; // Registrar el candidato
                }
                votos[voto]++;
                totalVotos++;
                if (votos[voto] > maxVotos) {
                    maxVotos = votos[voto];
                }
            } else {
                System.out.println("Número de candidato inválido, intenta de nuevo.");
            }
        }

        System.out.println("\nResultados:");
        for (int i = 1; i <= numCandidatos; i++) {
            if (votos[i] > 0) {
                double porcentaje = (votos[i] * 100.0) / totalVotos;
                System.out.printf("Candidato %d: %d votos (%.2f%%)\n", candidatos[i], votos[i], porcentaje);
            }
        }

        System.out.println("\nGanador(es):");
        for (int i = 1; i <= numCandidatos; i++) {
            if (votos[i] == maxVotos) {
                System.out.printf("Candidato %d con %d votos\n", candidatos[i], votos[i]);
            }
        }

        scanner.close();
    }
}
