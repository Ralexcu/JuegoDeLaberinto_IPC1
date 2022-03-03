package Anteproyecto;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int op;
        int salir=1;
        Scanner leer = new Scanner(System.in);
        texto dialogos = new texto();
        juego play = new juego();
        do{
            dialogos.linea();
            System.out.print("Bienvenido al juego del laberinto");
            dialogos.linea();
            System.out.println("\nPor favor elige las opciones");
            System.out.println("1. jugar\n2. Crear mapa\n3. Reportes\n4. Visualizar mapa\n5. Salir");
            dialogos.linea2();
            op = leer.nextInt();
            switch (op) {
                case 1:
                    play.jugar();
                    break;
                case 2:
                    play.crearLaberintos();
                    break;
                case 3:
                    play.reportesGenerales();
                    break;
                case 4:
                    play.mostrarLaberintos();
                    break;
                case 5:
                    salir = 0;
                    dialogos.salida();
                    break;
            }
        }while(salir!=0);
    }
}
