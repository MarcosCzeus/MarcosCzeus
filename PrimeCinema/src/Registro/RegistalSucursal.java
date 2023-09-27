package Registro;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegistalSucursal {
    private static List<Sucursal> sucursales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Datos
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                                   Nombre de la sucursal:                                   ");
        String nombreSucursal = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");


        System.out.println("                                    Nombre del gerente:"                                     );
        String gerente = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");


        System.out.println("                                   Dirección de la sucursal:                                ");
        String direccion = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                                Número de teléfono de la sucursal:                          ");
        String numeroTelefono = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");


        //Nueva sucursal
        Sucursal sucursal = new Sucursal(nombreSucursal, gerente, direccion, numeroTelefono);


        sucursales.add(sucursal);
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                           La sucursal se ha registrado correctamente.                      ");
        System.out.println("____________________________________________________________________________________________");


        for (Sucursal sucursal1 : sucursales) {
            System.out.println("                            Nombre de la sucursal: " + nombreSucursal                        );
            System.out.println("                            Gerente: " + gerente                                             );
            System.out.println("                            Dirección: " + direccion                                         );
            System.out.println("                            Número de teléfono: " + numeroTelefono                           );
            System.out.println("____________________________________________________________________________________________");
        }
    }
}
