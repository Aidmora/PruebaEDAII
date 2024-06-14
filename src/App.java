import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Ingrese una de las siguientes opciones:" + "\n"
                + "1. Ejercicio 1: Genere una matriz de adyacencia , que le pida al usuario su tamaño (nxn)... " + "\n"
                + "2. Ejercicio 2 : A partir de una lista de adyacencia ingresada por el usuario que contenga nxn elementos "
                + "\n"
                + "3. Ejercicio 3 : A partir de una lista de adyacencia ingresada por el usuario que contenga nxn elementos "
                + "\n"
                + "4. Diseñe un grafo que tenga aleatoriamente n nodos y permita m aristas entre nodos");
        int opcion = Integer.parseInt(sc1.nextLine());
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el tamaño del grafo: ");
                int cantidadVertices2 = Integer.parseInt(sc1.nextLine());
                ListaAdyacencia la2 = new ListaAdyacencia();
                MatrizAdyacencia ma2 = new MatrizAdyacencia();
                int[][] matrizAdyacencia2 = ma2.ingresarDatosMatriz(cantidadVertices2);
                // Generar el grafo
                // Matriz con 0 y 1 aleatorios
                ma2.imprimirMatriz(matrizAdyacencia2);
                // Pregunta (a)
                System.out.println("PREGUNTA A) - LOS NODOS QUE TIENE BUCLES SON LOS SIGUIENTES: ");
                ma2.nodosBucles(matrizAdyacencia2);
                // Pregunta (b)
                System.out.println(" PREGUNTA B) - LOS NODOS QUE NO ESTAN CONECTADOS A OTROS SON: ");
                ma2.nodoNoConectadoOtro(matrizAdyacencia2);
                // Pregunta (c)
                System.out.println("PREGUNTA C) - EL CAMINO MAS LARGO ES: ");
                ma2.conexioLarga(matrizAdyacencia2);
                // Pregunta (D)
                System.out.println();
                System.out.println("PREGUNTA D) - EL GRAFO ES SIMPLE O MULTIGRAFO");
                ma2.verificacionMultigrafo(matrizAdyacencia2);
                // Dibujar el grafo
                System.out.println("DIBUJO DEL GRAFO");
                NodoLs[] listaAdyacencia2 = la2.generarListaAydacenciaMatriz(matrizAdyacencia2);
                la2.imprimirListaAdyacencia2(listaAdyacencia2);
                break;
            case 2:
                System.out.println("Ingrese la cantidad de vértices:");
                int cantidadVertices = Integer.parseInt(sc1.nextLine());
                ListaAdyacencia la = new ListaAdyacencia();
                NodoLs[] listaAdyacencia = la.inicializarListaAdyacencia(cantidadVertices);
                System.out.println("LA LISTA DE ADYACENCIA ES LA SIGUIENTE:" + "\n");
                la.imprimirListaAdyacencia(listaAdyacencia);
                // Matriz de Adyacencia
                MatrizAdyacencia ma = new MatrizAdyacencia();
                int matrizAdyacencia[][] = ma.generarMatrizAdyacencia(listaAdyacencia, cantidadVertices);
                System.out.println("LA MATRIZ DE ADYACENCIA ES: ");
                ma.imprimirMatriz(matrizAdyacencia);
                // Matriz de adyacencia complementaria
                System.out.println("LA MATRIZ DE ADYACENCIA COMPLEMENTARIA:");
                int matrizAdyacenciaComplementaria[][] = ma.generarMatrizComplementaria(matrizAdyacencia);
                ma.imprimirMatriz(matrizAdyacenciaComplementaria);
                // Dibujo del Grafo
                NodoLs[] listaAdyacencia4 = la.generarListaAydacenciaMatriz(matrizAdyacenciaComplementaria);
                la.imprimirListaAdyacencia2(listaAdyacencia4);

                break;
            case 3:
                // ingreso de datos
                ListaAdyacencia la4 = new ListaAdyacencia();
                System.out.println("Ingrese 15 numeros aleatorios entre el 0-9");
                int[] arrayNumerosAleatorios = new int[15];
                for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
                    System.out.println("Ingrese el " + i + "numero ");
                    int valorArray = Integer.parseInt(sc1.nextLine());
                    if (valorArray > 9 || valorArray < 0) {
                        System.out.println("Valor no válido");
                        System.exit(0);
                    } else {
                        arrayNumerosAleatorios[i] = valorArray;
                    }
                }
                MatrizAdyacencia ma3 = new MatrizAdyacencia();
                // Dibujar grafo
                int[][] matrizAdyacencia4 = ma3.generarGrafoEjercicio3(arrayNumerosAleatorios);
                NodoLs[] listaAdyacencia5 = la4.generarListaAydacenciaMatriz(matrizAdyacencia4);
                la4.imprimirListaAdyacencia2(listaAdyacencia5);

                break;
            case 4:
                // Ingreso de datos
                System.out.println("Ingrese el numero de nodos del grafo");
                int numeroNodos = Integer.parseInt(sc1.nextLine());
                System.out.println("Ingrese el numero de aristas del grafo");
                int aristas = Integer.parseInt(sc1.nextLine());
                MatrizAdyacencia ma5 = new MatrizAdyacencia();
                ma5.numeroNodosAristasAleatorias(numeroNodos, aristas);

            default:
                break;
        }

    }

}
