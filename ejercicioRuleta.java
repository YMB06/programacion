package Arrays;
import java.util.Scanner;

public class ejercicioRuleta {
    public static Scanner sc = new Scanner(System.in); 
    // creamos los arrays que vamos a usar en nuestro codigo
    static String[] personas = {"juan", "jose", "fran", "maria", "pepe"};
    static int[] premio = {1000, 10};
    static int[] contador = new int[5];
    static int[] premiosConseguidos = new int[5];
    static int[] contadorOrdenado = new int[5];
    static String[] personasOrdenado = new String[5];

    public static void main(String[] args) {
        ejercicioRuleta.generarTiradas();
        ejercicioRuleta.calculoIntermedio();
        ejercicioRuleta.imprimirResultado();
    }
    public static void generarTiradas(){
        // generamos las tiradas que seran entre los 5 nombres que tenemos en nuestro array
        for (int i = 1; i < 11; i++) {
            int tiradas = (int) (Math.random() *5);
            // mostramos cada tirada que sacamos
            System.out.println("Tirada " + i + " --> " + personas[tiradas]);
            contador[tiradas]++;
            premiosConseguidos[tiradas] += premio[0]; for (int j = 0; j < personas.length; j++) {
                // j != tiradas da el premio de 1000 a la persona seleccionada en la tirada
                if (j != tiradas) { 
                    // da el premio de 10 a todos los que no son seleccionados en esa tirada
                    premiosConseguidos[j] += premio[1]; 
                } 
                }
            System.out.println("Continuar: "); 
            sc.nextLine();
        }
    }
    public static void calculoIntermedio(){
        int max = 0;
        int min = 0;
        // recoge cada tirada para ver que persona tendra menos o mas
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > max) {
                max = contador[i];
            }
            if (contador[i] < min) {
                min = contador[i];
            }
        }
        // nos dice quien ha ganado mas o menos
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] == max) {
                System.out.println("Ha ganado mas veces: " + personas[i]);
            }
            if (contador[i] == min) {
                System.out.println("Ha ganado menos o nada:  " + personas[i]);
            }
        }
    }
    public static void imprimirResultado(){
        // mostramos cuantas veces ha salido cada persona
        for (int i = 0; i < contador.length; i++) {
            System.out.println(personas[i]+ " ha salido " +contador[i]+ " vecesy ha conseguido " + premiosConseguidos[i] + " euros");
        }
    }
}
// personas = ["juan", "jose", "fran", "maria", "pepe"]
// deseamos saber cual ha sido la persona seleccionada más veces y la que ha salido menos veces despues de generar 10 tiradas al azar, 
// que emprima cada tirada permitiendo una pusa entre cada una hasta que no se le de al intro
// premio[1000, 10] el que gana 1000 y si pierde son 10



