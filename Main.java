import java.util.Random;
import java.util.Stack;

// Clase personalizada que implementa una pila usando un arreglo
class PilaArreglo {
    private int[] pila;
    private int tope;  // Índice del último elemento

    // Constructor
    public PilaArreglo(int capacidad) {
        pila = new int[capacidad];
        tope = -1; // pila vacía
    }

    // Apilar (push)
    public void apilar(int valor) {
        if (estaLlena()) {
            System.out.println("La pila está llena. No se puede apilar " + valor);
        } else {
            pila[++tope] = valor;
        }
    }

    // Desapilar (pop)
    public int desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return -1;
        } else {
            return pila[tope--];
        }
    }

    // Verificar si está llena
    public boolean estaLlena() {
        return tope == pila.length - 1;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return tope == -1;
    }

    // Mostrar tamaño actual de la pila
    public int tamanoActual() {
        return tope + 1;
    }

    // Mostrar cuántos datos se pueden agregar todavía
    public int espacioDisponible() {
        return pila.length - (tope + 1);
    }

    // Mostrar elementos de la pila
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.print("Pila: ");
            for (int i = 0; i <= tope; i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        }
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRIMERA PARTE: PILA CON ARREGLO ===");
        Random random = new Random();

        // Crear una pila de tamaño 9
        PilaArreglo pila = new PilaArreglo(9);

        // Apilar 5 valores aleatorios
        for (int i = 0; i < 5; i++) {
            int valor = random.nextInt(100); // aleatorio entre 0 y 99
            pila.apilar(valor);
        }

        // Mostrar pila y tamaño actual
        pila.mostrarPila();
        System.out.println("Tamaño actual: " + pila.tamanoActual());

        // Borrar un dato
        int borrado = pila.desapilar();
        System.out.println("Se borró: " + borrado);

        // Mostrar de nuevo el tamaño
        System.out.println("Tamaño actual después de borrar: " + pila.tamanoActual());

        // Mostrar espacio disponible
        System.out.println("Espacio disponible para apilar: " + pila.espacioDisponible());

        System.out.println("\n=== SEGUNDA PARTE: USO DE STACK ===");
        Stack<Integer> pila1 = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();

        // Agregar 7 datos a la primera pila
        for (int i = 1; i <= 7; i++) {
            pila1.push(i);
        }

        System.out.println("Pila 1: " + pila1);

        // Pasar datos a la segunda pila en orden inverso
        while (!pila1.isEmpty()) {
            pila2.push(pila1.pop());
        }

        System.out.println("Pila 2 (inversa): " + pila2);
    }
}
