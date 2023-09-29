package arreglo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegistroSala {

    public static void main(String[] args) {

        List<Sala> salas = new ArrayList<>();

        // Crear 10 instancias de Sala y agregarlas a la lista de salas
        salas.add(new Sala(1, "plaza mundo"));
        salas.add(new Sala(2, "plaza mundo"));
        salas.add(new Sala(3, "plaza mundo"));
        salas.add(new Sala(4, "plaza mundo"));
        salas.add(new Sala(5, "plaza mundo"));
        salas.add(new Sala(6, "plaza mundo"));
        salas.add(new Sala(7, "plaza mundo"));
        salas.add(new Sala(8, "plaza mundo"));
        salas.add(new Sala(9, "plaza mundo"));
        salas.add(new Sala(10, "plaza mundo"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Registrar una sala");
            System.out.println("2. Visualizar salas y butacas");
            System.out.println("3. Ocupar una silla");
            System.out.println("4. Desocupar todas las sillas de una sala");
            System.out.println("5. Buscar salas por sucursal");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarSala(scanner, salas);
                    break;
                case 2:
                    mostrarSalas(salas);
                    break;
                case 3:
                    ocuparSilla(scanner, salas);
                    break;
                case 4:
                    desocuparSillas(scanner, salas);
                    break;
                case 5:
                    buscarPorSucursal(scanner, salas);
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void registrarSala(Scanner scanner, List<Sala> salas) {
        System.out.print("Ingrese el número de sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la sucursal: ");
        String sucursal = scanner.nextLine();

        Sala nuevaSala = new Sala(numeroSala, sucursal);
        salas.add(nuevaSala);
        System.out.println("Sala registrada con éxito.");
    }

    private static void mostrarSalas(List<Sala> salas) {
        System.out.println("Salas disponibles:");
        for (Sala s : salas) {
            System.out.println("Sala " + s.getNumeroSala() + " - Sucursal: " + s.getSucursal());
            System.out.println("Estado de las butacas:");
            String[][] butacas = s.getButacas();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(butacas[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void ocuparSilla(Scanner scanner, List<Sala> salas) {
        System.out.print("Ingrese el número de sala en la que desea ocupar una silla: ");
        int numSalaOcupar = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        boolean sillaOcupada = false;
        for (Sala s : salas) {
            if (s.getNumeroSala() == numSalaOcupar) {
                System.out.print("Ingrese la fila de la silla a ocupar (0-7): ");
                int fila = scanner.nextInt();
                System.out.print("Ingrese la columna de la silla a ocupar (0-4): ");
                int columna = scanner.nextInt();
                if (s.ocuparButaca(fila, columna)) {
                    System.out.println("Silla ocupada con éxito.");
                    sillaOcupada = true;
                } else {
                    System.out.println("La silla ya está ocupada o no es válida.");
                }
            }
        }
        if (!sillaOcupada) {
            System.out.println("No se encontró la sala especificada.");
        }
    }

    private static void desocuparSillas(Scanner scanner, List<Sala> salas) {
        System.out.print("Ingrese el número de sala en la que desea desocupar todas las sillas: ");
        int numSalaDesocupar = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        boolean salaEncontrada = false;
        for (Sala s : salas) {
            if (s.getNumeroSala() == numSalaDesocupar) {
                s.desocuparButacas();
                System.out.println("Todas las sillas de la sala han sido desocupadas.");
                salaEncontrada = true;
            }
        }
        if (!salaEncontrada) {
            System.out.println("No se encontró la sala especificada.");
        }
    }

    private static void buscarPorSucursal(Scanner scanner, List<Sala> salas) {
        System.out.print("Ingrese el nombre de la sucursal a buscar: ");
        String nombreSucursal = scanner.nextLine();
        boolean sucursalEncontrada = false;
        for (Sala s : salas) {
            if (s.getSucursal().equalsIgnoreCase(nombreSucursal)) {
                System.out.println("Sala " + s.getNumeroSala());
                sucursalEncontrada = true;
            }
        }
        if (!sucursalEncontrada) {
            System.out.println("No se encontraron salas en la sucursal especificada.");
        }
    }
}

