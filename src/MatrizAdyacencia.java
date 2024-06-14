import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrizAdyacencia {
    public static final Scanner sc2 = new Scanner(System.in);

    public MatrizAdyacencia() {
    }

    public static int[][] generarMatrizAdyacencia(NodoLs[] listaAdyacencia, int cantidadVertices) {
        int[][] matrizAdyacencia = new int[cantidadVertices][cantidadVertices];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
        for (int i = 0; i < listaAdyacencia.length; i++) {
            NodoLs actual = listaAdyacencia[i];
            if (actual != null && actual.getINFO() != null) {
                String[] datosListaAdyacencia = actual.getINFO().split("-");
                if (datosListaAdyacencia.length != 3) {
                    continue;
                }
                while (actual != null && actual.getINFO() != null) {
                    String[] datosListaAdyacencia2 = actual.getINFO().split("-");
                    int valorFilaMatriz = Integer.parseInt(datosListaAdyacencia2[0]);
                    int valoColMatriz = Integer.parseInt(datosListaAdyacencia2[1]);
                    int peso = Integer.parseInt(datosListaAdyacencia2[2]);
                    matrizAdyacencia[valorFilaMatriz][valoColMatriz] = peso;
                    actual = actual.getLIGA();
                }
                System.out.println();
            }

        }
        return matrizAdyacencia;
    }

    public static int[][] generarMatrizComplementaria(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != j) {
                    if (matriz[i][j] == 0) {
                        matriz[i][j] = 1;
                    } else if (matriz[i][j] == 1) {
                        matriz[i][j] = 0;
                    }
                }
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Nueva línea al final de cada fila
        }
    }

    public static int[][] ingresarDatosMatriz(int cantidadVertices2) {
        int[][] matriz = new int[cantidadVertices2][cantidadVertices2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 2);
            }

        }
        return matriz;
    }

    public static void nodosBucles(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    if (matriz[i][j] > 0) {
                        System.out.println("El nodo " + i + " tiene bucle ");
                    }
                }
            }
        }

    }

    public static void nodoNoConectadoOtro(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            contador = 0;
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    contador++;
                }
                if (contador == matriz.length) {
                    System.out.println("El nodo que no tiene conexion con ninguno otro es: " + i);
                }
            }
        }
    }

    public static void conexioLarga(int[][] matriz) {
        int contador = 0;
        int valorComparar = 0;
        int nodoActual = 0;
        List<Integer> listaConexiones = new ArrayList<>();
        List<Integer> listaConexiones2 = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            listaConexiones = new ArrayList<>();
            contador = 0;
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > 0) {
                    contador++;
                    listaConexiones.add(j);
                }
            }
            if (contador > valorComparar) {
                listaConexiones2 = new ArrayList<>();
                listaConexiones2 = listaConexiones;
                nodoActual = i;
                valorComparar = contador;

            } else {

            }

        }
        System.out.print("Nodo " + nodoActual + "->");
        for (Integer integer : listaConexiones2) {
            System.out.print(integer + "" + "->");
        }
    }

    public static void verificacionMultigrafo(int[][] matriz) {
        boolean bandera = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != 0 && matriz[j][i] != 0) {
                    bandera = true;
                }
            }
        }
        if (bandera == true) {
            System.out.println("EL GRAFO ES UN MULTIGRAFO");
        }
    }

    public static int[][] generarGrafoEjercicio3(int[] arrayValores) {
        int numeroMayor = 0;
        for (int i = 0; i < arrayValores.length; i++) {
            if (arrayValores[i] > numeroMayor) {
                numeroMayor = arrayValores[i];
            }
        }
        int[][] matrizAdyacencia3 = new int[numeroMayor][numeroMayor];
        for (int i = 0; i < matrizAdyacencia3.length; i++) {
            for (int j = 0; j < matrizAdyacencia3.length; j++) {
                matrizAdyacencia3[i][j] = 0;
            }
        }
        for (int i = 0; i < arrayValores.length - 1; i++) {
            int temp = arrayValores[i];
            if (temp + 1 < matrizAdyacencia3.length) {
                matrizAdyacencia3[temp][temp + 1] = 1;
            }
        }
        return matrizAdyacencia3;
    }

    public static void numeroNodosAristasAleatorias(int numeroNodos, int numeroAristas) {
        int[][] matriz = new int[numeroNodos][numeroNodos];
        ListaAdyacencia la = new ListaAdyacencia();
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) (Math.random() * 2);
                if (matriz[i][j] == 1) {
                    contador++;
                }
                if (contador == numeroAristas) {
                    imprimirMatriz(matriz);
                    System.out.println("EL GRAFO OBTENIDO SERIA EL SIGUIENTE: ");
                    la.imprimirListaAdyacencia2(la.generarListaAydacenciaMatriz(matriz));
                    System.exit(0);
                }
            }
        }

    }
}
