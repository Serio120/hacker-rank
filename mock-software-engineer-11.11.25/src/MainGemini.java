import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Importamos Scanner para leer la entrada del usuario

/**
 * Esta clase principal contiene el método 'main' para ejecutar el programa.
 */
public class MainGemini {

    public static void main(String[] args) {

        // 1. Creamos un Scanner para leer lo que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        // 2. Pedimos la primera cadena al usuario
        System.out.print("Introduce la primera cadena (str1): ");
        String cadena1 = scanner.nextLine();

        // 3. Pedimos la segunda cadena al usuario
        System.out.print("Introduce la segunda cadena (str2): ");
        String cadena2 = scanner.nextLine();

        // 4. Llamamos a tu método estático de la clase ResultGemini
        List<Integer> indices = ResultGemini.getRemovableIndices(cadena1, cadena2);

        // 5. Imprimimos el resultado (la lista o "array")
        System.out.println("Los índices que se pueden eliminar son: " + indices);

        // 6. Cerramos el scanner (buena práctica)
        scanner.close();
    }
}

/**
 * Tu clase original que contiene la lógica de negocio.
 * (Con la modificación de no añadir -1)
 */
class ResultGemini {

    public static List<Integer> getRemovableIndices(String str1, String str2) {
        // Usamos <> (operador diamante) para un ArrayList vacío
        List<Integer> removableIndices = new ArrayList<>();
        int n = str1.length();

        for(int i = 0; i < n; ++i) {
            int p1 = 0;
            int p2 = 0;

            while(p1 < n) {
                if (p1 == i) {
                    ++p1;
                } else {
                    // Es importante comprobar p2 primero para evitar error de índice
                    if (p2 >= str2.length() || str1.charAt(p1) != str2.charAt(p2)) {
                        break;
                    }

                    ++p1;
                    ++p2;
                }
            }

            if (p2 == str2.length()) {
                removableIndices.add(i);
            }
        }

        // Ya no se añade -1 si la lista está vacía

        return removableIndices;
    }
}

/*
 * Ejemplo de Ejecución
 * Si ejecutas este código, verás lo siguiente en tu consola:
 *
 * Introduce la primera cadena (str1): abacaba
 * Introduce la segunda cadena (str2): aba
 *  Los índices que se pueden eliminar son: [3]
 * Otro ejemplo (el que antes daba -1):

 * Introduce la primera cadena (str1): hello
 *Introduce la segunda cadena (str2): world
 *Los índices que se pueden eliminar son: []
 */
