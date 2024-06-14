import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListaAdyacencia {
    private NodoLs[] listaAdyacencia;
    public static final Scanner sc = new Scanner(System.in);

    public ListaAdyacencia() {
    }

    public static NodoLs[] inicializarListaAdyacencia(int cantidadVertices) {
        NodoLs[] listaAdyacencia = new NodoLs[cantidadVertices];
        boolean bandera;
        int evaluarEnlaces;
        int verticeConexion;
        int opcion;

        for (int i = 0; i < cantidadVertices; i++) {
            listaAdyacencia[i] = new NodoLs();
        }

        for (int i = 0; i < cantidadVertices; i++) {
            bandera = true;
            NodoLs cabecera = listaAdyacencia[i];
            System.out.println("El nodo " + i + " tiene al menos una arista con algún otro nodo " +
                    "\n En el caso de que 'SI' escriba 1 " +
                    "En el caso de que 'NO' escriba 0");
            evaluarEnlaces = Integer.parseInt(sc.nextLine());
            if (evaluarEnlaces != 1) {
                continue;
            }
            while (bandera) {
                System.out.println("Escriba el vértice con el que tiene conexión el vértice: " + i +
                        "\n Las conexiones pueden ir desde { 0 ... " + (cantidadVertices - 1) + "}");
                verticeConexion = Integer.parseInt(sc.nextLine());

                if (verticeConexion >= cantidadVertices) {
                    System.out.println(
                            "El vértice estipulado es una cantidad mayor al número de vértices que tiene el grafo");
                    System.exit(1);
                } else if (verticeConexion == i) {
                    System.out.println("No se aceptan bucles o lazos");
                    System.exit(1);
                }
                System.out.println("Dado que existe conexion entre los grafos " +
                        "\n Escriba 1 ");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion == 1) {
                    cabecera.setINFO(i + "-" + verticeConexion + "-" + opcion);
                    NodoLs nuevoNodo = new NodoLs();
                    cabecera.setLIGA(nuevoNodo);
                    cabecera = nuevoNodo;
                } else {
                    cabecera.setINFO(String.valueOf(verticeConexion));
                    NodoLs nuevoNodo = new NodoLs();
                    cabecera.setLIGA(nuevoNodo);
                    cabecera = nuevoNodo;
                }

                System.out.println("¿Existe otro vértice con el que tenga conexión?" +
                        "\n En el caso de que 'SI' escriba 1 " +
                        "\n En el caso de que 'NO' escriba 0");
                int opcionConexion = Integer.parseInt(sc.nextLine());
                if (opcionConexion != 1) {
                    bandera = false;
                }
            }
        }
        return listaAdyacencia;
    }

    public void imprimirListaAdyacencia(NodoLs[] listaAdyacencia) {

        for (int i = 0; i < listaAdyacencia.length; i++) {
            NodoLs actual = listaAdyacencia[i];
            if (actual != null && actual.getINFO() != null) {
                String[] datosListaAdyacencia = actual.getINFO().split("-");
                if (datosListaAdyacencia.length == 3) {
                    System.out.print("Nodo " + datosListaAdyacencia[0] + ": ");
                } else {
                    continue;
                }

            }
            while (actual != null && actual.getINFO() != null) {
                String[] datosListaAdyacencia = actual.getINFO().split("-");
                System.out.print(datosListaAdyacencia[1] + "- Peso: " + datosListaAdyacencia[2] + " -> ");
                actual = actual.getLIGA();
            }
            System.out.println();
        }
    }

    public static Map<Integer, List<Integer>> convertirMatrizALista(int[][] matriz) {
        Map<Integer, List<Integer>> listaAdyacencia = new HashMap<>();

        for (int i = 0; i < matriz.length; i++) {
            listaAdyacencia.put(i, new ArrayList<>());
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    listaAdyacencia.get(i).add(j);
                }
            }
        }

        return listaAdyacencia;
    }

    public static NodoLs[] generarListaAydacenciaMatriz(int[][] matrizAdyacencia) {
        int cantidadVertices = matrizAdyacencia.length;
        NodoLs[] listaAdyacencia = new NodoLs[cantidadVertices];
        for (int i = 0; i < cantidadVertices; i++) {
            listaAdyacencia[i] = new NodoLs();
        }
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            NodoLs cabecera = listaAdyacencia[i];
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                if (matrizAdyacencia[i][j] != 0) {
                    cabecera.setINFO(i + "-" + j);
                    NodoLs nuevoNodo = new NodoLs();
                    cabecera.setLIGA(nuevoNodo);
                    cabecera = nuevoNodo;
                }

            }
        }
        return listaAdyacencia;
    }

    public void imprimirListaAdyacencia2(NodoLs[] listaAdyacencia) {

        for (int i = 0; i < listaAdyacencia.length; i++) {
            NodoLs actual = listaAdyacencia[i];
            if (actual != null && actual.getINFO() != null) {
                String[] datosListaAdyacencia = actual.getINFO().split("-");
                if (datosListaAdyacencia.length == 2) {
                    System.out.print("Nodo " + datosListaAdyacencia[0] + "->");
                } else {
                    continue;
                }
            }
            while (actual != null && actual.getINFO() != null) {
                String[] datosListaAdyacencia = actual.getINFO().split("-");
                System.out.print(datosListaAdyacencia[1] + " -> ");
                actual = actual.getLIGA();
            }
            System.out.print(", ");
        }
    }
}
