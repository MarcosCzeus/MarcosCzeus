package arreglo;

public class Sala {
    private int numeroSala;
    private String sucursal;
    private String[][] butacas;

    public Sala(int numeroSala, String sucursal) {
        this.numeroSala = numeroSala;
        this.sucursal = sucursal;
        this.butacas = new String[8][5]; // Matriz de 8 filas por 5 columnas para las butacas
        // Inicializar todas las butacas como "O" (desocupadas)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                butacas[i][j] = "O";
            }
        }
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public String getSucursal() {
        return sucursal;
    }

    public String[][] getButacas() {
        return butacas;
    }

    public boolean ocuparButaca(int fila, int columna) {
        if (fila >= 0 && fila < 8 && columna >= 0 && columna < 5) {
            if (butacas[fila][columna].equals("O")) {
                butacas[fila][columna] = "X";
                return true;
            }
        }
        return false;
    }

    public void desocuparButacas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                butacas[i][j] = "O";
            }
        }
    }
}