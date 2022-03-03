package Anteproyecto;

public class Laberinto {
   //Parametros
   String nombre;
   int casillasOro;
   int columnas;
   int filas;
   char[][] matriz;
   int vecesJugado;
   int vecesWin;
   int vecesLose;

   //constructor
   public Laberinto(String nombre, int casillasOro, char[][] matriz, int filas, int columnas, int vecesJugado, int vecesWin,int vecesLose) {
      this.nombre = nombre;
      this.casillasOro = casillasOro;
      this.matriz = matriz;
      this.filas = filas;
      this.columnas = columnas;
      this.vecesJugado = vecesJugado;
      this.vecesWin = vecesWin;
      this.vecesLose = vecesLose;
   }
   //getters
   public String getNombre() {
      return nombre;
   }

   public int getCasillasOro() {
      return casillasOro;
   }

   public char[][] getMatriz() {
      return matriz;
   }

   public int getColumnas(){return columnas;}

   public int getFilas(){return filas;}

   public int getVecesJugado(){return vecesJugado;}

   public int getVecesWin(){return vecesWin;}

   public int getVecesLose(){return vecesLose;}

   //setters

   public void setVecesJugado(int vecesJugado) {
      this.vecesJugado = vecesJugado;
   }

   public void setVecesWin(int vecesWin) {
      this.vecesWin = vecesWin;
   }

   public void setVecesLose(int vecesLose) {
      this.vecesLose = vecesLose;
   }
}
