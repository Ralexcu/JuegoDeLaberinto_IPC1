package Anteproyecto;

public class jugador {
    int fila;
    int columna;
    int oro;
    int movimientos;
    int movimientosTotales;
    int oroTotal;
    int wins;
    int laberintosCreados;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public int getMovimientosTotales() {
        return movimientosTotales;
    }

    public void setMovimientosTotales(int movimientosTotales) {
        this.movimientosTotales = movimientosTotales;
    }

    public int getOroTotal() {
        return oroTotal;
    }

    public void setOroTotal(int oroTotal) {
        this.oroTotal = oroTotal;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLaberintosCreados(){
        return laberintosCreados;
    }
    public void setLaberintosCreados(int laberintosCreados){
        this.laberintosCreados = laberintosCreados;
    }
}
