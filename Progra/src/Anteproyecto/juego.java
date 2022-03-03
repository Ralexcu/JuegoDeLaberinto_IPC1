package Anteproyecto;
import java.util.Scanner;
public class juego {
    Scanner leer = new Scanner(System.in);
    Scanner leerS = new Scanner(System.in);
    int opcionLaberinto;
    int laberintosCreados = 1;
    int seleccionmapas;
    String nombreLaberinto;
    jugador player = new jugador();
    Laberinto[] listadoLaberintos = new Laberinto[6];
    Laberinto laberintodefault;
    // Constructor juego, en este inicializamos el laberinto por defecto
    public juego() {
        player.setLaberintosCreados(0);
        char[][] matrizDefault = {{'#','O','#','#','#','#','#','O','O','#','#','#','#','#','#','#','#','#','#','#','#','#','#','O','O','#','O','#','#','#'}
        ,{'#','O','#','O','O','O','#','O','#','O','O','O','O','O','O','O','O','O','O','O','O','O','O','#','O','#','O','O','O','S'}
        ,{'#','G','O','O','#','O','#','O','O','#','O','#','#','#','#','#','#','O','#','#','#','O','O','O','O','#','O','#','#','#'}
        ,{'#','O','#','#','#','O','#','O','#','O','O','#','O','O','O','O','#','O','O','O','#','O','#','#','#','#','O','#','O','#'}
        ,{'#','O','#','O','O','O','#','O','O','#','O','#','#','#','#','O','#','#','#','O','#','O','O','O','O','#','O','O','O','#'}
        ,{'#','O','#','#','#','O','#','#','#','#','O','#','O','O','O','O','#','O','#','O','#','#','#','O','#','O','#','#','O','#'}
        ,{'#','O','#','O','O','O','O','O','O','O','O','O','O','#','O','O','#','O','#','O','O','O','O','O','#','O','#','O','O','#'}
        ,{'#','O','#','#','#','#','#','#','#','#','#','O','#','O','#','#','#','O','#','O','#','#','#','#','#','O','O','O','#','#'}
        ,{'#','O','O','O','O','O','O','#','O','O','O','O','#','O','O','G','O','O','O','O','O','O','G','O','O','O','#','O','O','#'}
        ,{'#','#','#','#','#','#','#','#','#','#','#','#','#','G','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
        laberintodefault = new Laberinto("Default", 2, matrizDefault,10,30,0,0,0);
        listadoLaberintos[0] = laberintodefault;
    }
//opciones del juego
    //jugar
    public void jugar() {
        int op2, aleatoriocolumnas,aleatoriofilas;
        boolean espacioAleatorio=false;
        //Repite el menu de seleccion de laberintos
        do{
            player.setOro(0);
            player.setMovimientos(0);
            System.out.println("Seleccione el laberinto en el que desea jugar");
            mostrarMapas();
            opcionLaberinto = leer.nextInt();
            listadoLaberintos[opcionLaberinto].setVecesJugado(listadoLaberintos[opcionLaberinto].getVecesJugado()+1);
            //Genera la casilla aleatoria para que aparezca el jugador
            do{
                aleatoriocolumnas = (int) (Math.random() * (listadoLaberintos[opcionLaberinto].getColumnas()-1));
                aleatoriofilas = (int) (Math.random() * (listadoLaberintos[opcionLaberinto].getFilas()-1));
                if (listadoLaberintos[opcionLaberinto].getMatriz()[aleatoriofilas][aleatoriocolumnas] == 'O'){
                    espacioAleatorio=true;
                    player.setFila(aleatoriofilas);
                    player.setColumna(aleatoriocolumnas);
                }
            }while(!espacioAleatorio);
            //Dibuja el laberinto seleccionado
            mostrarMapaSeleccionado(opcionLaberinto);
           //Mueve al jugador
            moverJugador(opcionLaberinto);
            System.out.println("Deseas volver a la seleccion de laberintos??\n1. Si  2.No");
            op2 = leer.nextInt();
        } while(op2 != 2);
    }
    // Mostrar laberintos
    public void mostrarLaberintos() {
        System.out.println("Tus laberintos creados son:");
        mostrarMapas();
        System.out.println("Selecciona el mapa que deseas ver:");
        seleccionmapas = leer.nextInt();
        for(int i=0;i<listadoLaberintos[seleccionmapas].getFilas();i++){
            for(int j=0;j<listadoLaberintos[seleccionmapas].getColumnas();j++){
                System.out.print(listadoLaberintos[seleccionmapas].getMatriz()[i][j]);
            }
            System.out.println();
        }
        presionatecla();
    }
    // Crear Laberintos
    public void crearLaberintos() {
        System.out.println("Bienvenido a la creacion de mapas\nRecuerda que solo puedes crear 5 mapas");
        System.out.println("Recuerda que los mapas se van agregando segun los vayas creando");
        System.out.println("Por el momento los mapas que tienes son:");
        mostrarMapas();
        System.out.println("Ingrese el nombre del nuevo laberinto");
        nombreLaberinto = leerS.nextLine();
        System.out.println("Ingrese el oro requerido");
        int casillasOro = leer.nextInt();
        System.out.println("Ingresa las filas del laberinto (Alto)(Maximo 30x30):");
        int filas = leer.nextInt();
        System.out.println("Ingresa las columnas del laberinto (Largo)(Maximo 30x30):");
        int columnas = leer.nextInt();
        //llenamos la matriz char con los datos seleccionados
        char[][] matrizAux = llenarmatriz(filas,columnas);
        //Creamos el laberinto auxiliar
        Laberinto laberintoaux = new Laberinto(nombreLaberinto, casillasOro,matrizAux,filas,columnas,0,0,0);
        //Igualamos el laberinto auxiliar al espacio correspondiente
        listadoLaberintos[laberintosCreados] = laberintoaux;
        laberintosCreados++;
        System.out.println("Laberinto No." + (laberintosCreados - 1) + " Creado con Exito");
        player.setLaberintosCreados(player.getLaberintosCreados()+1);
        presionatecla();
    }
    // Reportes
    public void reportesGenerales(){
        System.out.println("Partidas Ganadas: "+player.getWins());
        System.out.println("Oro total: "+player.getOroTotal());
        System.out.println("Movimientos totales: "+player.getMovimientosTotales());
        int masJugado = listadoLaberintos[0].getVecesJugado();
        int masWins =  listadoLaberintos[0].getVecesWin();
        int masLoses = listadoLaberintos[0].getVecesLose();
        for (int i=0; i < player.getLaberintosCreados(); i++){
            if (listadoLaberintos[i].getVecesJugado()>masJugado){
                masJugado = listadoLaberintos[i].getVecesJugado();
            }
        }
        //Mapa en el que mas se ha perdido
        //Mapa en el que mas se ha ganado
        System.out.println("Total de mapas creados: "+listadoLaberintos.length);
    }
    // Funciones

    //Funciones de texto
    //Con esta funcion imprimimos el texto para la creacion del mapa
    public void reglascreaciondemapa() {
        System.out.println("Recuerda que el mapa se llena linea por linea para hacer el proceso mas sencillo");
        System.out.println("O --- Representa una casilla vacia, en la que te puedes mover sin ningun problema");
        System.out.println("S --- Representa la salida del laberinto");
        System.out.println("G --- Representa una casilla con oro, Recuerda que debes tener mas casillas con oro que las casillas con oro requeridas para cruzar el mapa");
        System.out.println("# --- Representa la pared, por lo cual no puedes ubicarte en esta casilla");
    }
    //Texto para los comandos
    public void comandos(){
        System.out.println("Elige tu proximo movimiento:\n1.Mover N (Te mueves hacia arriba)\n2.Mover S (Te mueves una casilla hacia abajo)");
        System.out.println("3.Mover E (Te mueves hacia la derecha)\n4.Mover O (Te mueves hacia la izquierda)\n5. Recoger G (Recoges el oro)");
        System.out.println("6.Salir (Recuerda que para poder salir necesitas haber recogido el oro necesario)\nPROCURA QUE TU COMANDO SEA VALIDO!!!");
    }

    //Funciones de mapa
    //Con esta funcion mostramos la vista previa de los mapas
    public void mostrarMapas() {
        for (int i = 0; i < laberintosCreados; i++) {
            System.out.print(i + ". Nombre: " + listadoLaberintos[i].getNombre());
            System.out.print(" Oro requerido para salir: " + listadoLaberintos[i].getCasillasOro());
            System.out.println(" Dimensiones: ["+listadoLaberintos[i].getFilas()+"]["+listadoLaberintos[i].getColumnas()+"]");
        }
    }
        //Con esta funcion dibujamos el mapa seleccionado
        public void mostrarMapaSeleccionado (int i){
            System.out.println(listadoLaberintos[i].getNombre());
            System.out.println("Oro recogido: "+player.getOro()+" Oro necesario para salir:"+listadoLaberintos[i].getCasillasOro());
            for (int f = 0; f < listadoLaberintos[i].getFilas(); f++) {
                for (int j = 0; j < listadoLaberintos[i].getColumnas(); j++) {
                    //Dibuja la casilla del jugador
                    if ((f == player.getFila()) && (j == player.getColumna())) {
                        System.out.print("J");
                    }
                    //dibuja el resto de la matriz
                    else {
                        System.out.print(listadoLaberintos[i].getMatriz()[f][j]);
                    }
                }
                System.out.println();
            }
        }
        //Con esta funcion movemos al jugador
        public void moverJugador(int seleccionlab) {
            String comando;
            int salir=0;
            int comandoerroneo=0;
            do {
                comandos();
                comando = leerS.nextLine();
                switch (comando) {
                    case "Mover O":
                        if (player.getColumna()==0){
                            System.out.println("Estas fuera del margen del laberinto");
                            presionatecla();
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        else {
                            comandoerroneo=0;
                            player.setColumna(player.getColumna()-1);
                            player.setMovimientos(player.getMovimientos()+1);
                            if (listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] == '#'){
                                System.out.println("Estas chocando con una pared");
                                player.setColumna(player.getColumna()+1);
                                player.setMovimientos(player.getMovimientos()-1);
                                presionatecla();
                            }
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        break;
                    case "Mover E":
                        if(player.getColumna() == listadoLaberintos[seleccionlab].getColumnas()-1){
                            System.out.println("Estas fuera del margen del laberinto");
                            presionatecla();
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        else {
                            comandoerroneo=0;
                            player.setColumna(player.getColumna()+1);
                            player.setMovimientos(player.getMovimientos()+1);
                            if (listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] == '#'){
                                System.out.println("Estas chocando con una pared");
                                player.setColumna(player.getColumna()-1);
                                player.setMovimientos(player.getMovimientos()-1);
                                presionatecla();
                            }
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        break;
                    case "Mover S":
                        if (player.getFila() == listadoLaberintos[seleccionlab].getFilas()-1){
                            System.out.println("Estas fuera del margen del laberinto");
                            presionatecla();
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        else{
                            comandoerroneo=0;
                            player.setFila(player.getFila()+1);
                            player.setMovimientos(player.getMovimientos()+1);
                            if (listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] == '#'){
                                System.out.println("Estas chocando con una pared");
                                player.setFila(player.getFila()-1);
                                player.setMovimientos(player.getMovimientos()-1);
                                presionatecla();
                            }
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        break;
                    case "Mover N":
                       if (player.getFila() == 0){
                           System.out.println("Estas fuera del margen del laberinto");
                           presionatecla();
                           mostrarMapaSeleccionado(opcionLaberinto);
                       }
                       else{
                           comandoerroneo=0;
                           player.setFila(player.getFila()-1);
                           player.setMovimientos(player.getMovimientos()+1);
                           if (listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] == '#'){
                               System.out.println("Estas chocando con una pared");
                               player.setFila(player.getFila()+1);
                               player.setMovimientos(player.getMovimientos()-1);
                              presionatecla();
                           }
                           mostrarMapaSeleccionado(opcionLaberinto);
                       }
                        break;
                    case "Recoger G":
                        if (listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] == 'G'){
                            System.out.println("Oro recogido exitosamente");
                            player.setOro(player.getOro()+1);
                            listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] = 'O';
                        }
                        else{
                            System.out.println("En esta casilla no hay oro");
                        }
                        presionatecla();
                        mostrarMapaSeleccionado(opcionLaberinto);
                        break;
                    case "Salir":
                        if(player.getOro() == listadoLaberintos[seleccionlab].getCasillasOro()) {
                            if (listadoLaberintos[seleccionlab].getMatriz()[player.getFila()][player.getColumna()] == 'S') {
                                System.out.println("Felicidades haz ganado");
                                listadoLaberintos[seleccionlab].setVecesWin(listadoLaberintos[seleccionlab].getVecesWin()+1);
                                player.setWins(player.getWins()+1);
                                reportes();
                                salir = 1;
                            } else {
                                System.out.println("Cuentas con el oro necesario para salir, sin embargo no estas en una casilla de salida");
                                mostrarMapaSeleccionado(opcionLaberinto);
                                presionatecla();
                            }
                        }
                        else {
                            System.out.println("No tienes el suficiente oro para salir");
                            presionatecla();
                            mostrarMapaSeleccionado(opcionLaberinto);
                        }
                        break;
                    default:
                        System.out.println("Comando equivocado\nRecuerda que si te equivocas 3 veces seguidas pierdes");
                        comandoerroneo++;
                        if (comandoerroneo==3){
                            salir =1;
                            System.out.println("Haz perdido");
                            listadoLaberintos[opcionLaberinto].setVecesLose(listadoLaberintos[opcionLaberinto].getVecesLose()+1);
                            reportes();
                        }
                        presionatecla();
                        break;
                }
            } while (salir != 1);
            player.setFila(0);
            player.setColumna(0);
            player.setMovimientosTotales(player.getMovimientosTotales()+player.getMovimientos());
            player.setOroTotal(player.getOroTotal()+ player.getOro());
        }
        //Funcion que llena la matriz
        public char[][] llenarmatriz (int filas, int columnas){
        char[][] nuevamatriz = new char[filas][columnas];
        for (int i=0; i<filas; i++){
            reglascreaciondemapa();
            System.out.println("Linea "+(i+1));
            System.out.println("Ingresa la linea completa, recuerda que el maximo de caracteres es: "+columnas);
            String caracter = leerS.nextLine();
            for (int j=0; j<columnas; j++){
                nuevamatriz[i][j]=caracter.charAt(j);
            }
        }
            return nuevamatriz;
        }
        //Funcion de reportes finales del juego
    public void reportes(){
        System.out.println("Oro Recolectado: "+player.getOro());
        System.out.println("Movimientos realizados: "+player.getMovimientos());
    }
    //Funcion de presiona cualquier tecla para continuar
        public void presionatecla(){
        System.out.println("Presiona enter para continuar");
        String op = leerS.nextLine();
        }
    }

