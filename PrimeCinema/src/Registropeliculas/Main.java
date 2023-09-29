package Registropeliculas;

import Registro.Conexiones;
import com.sun.security.jgss.GSSUtil;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

        public static void main (String[]args){

            String[] cartelera ={
                    "La Monja 1 (Terror - D)",
                    "Cacería en Venecia (Acción - C)",
                    "Gran Turismo (Deporte - C)",
                    "After para Siempre (Romance - D)",
                    "Contrareloj (Drama - C)",
                    "Sonido de Libertad (Drama - B)"
            };

            Scanner scanner = new Scanner(System.in);

            int opcion = 0;

            do {
                System.out.println("\u001B[32mCartelera:\u001B[0m");

                for (int i = 0; i < cartelera.length; i++) {
                    System.out.println("\u001B[32m|++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println((i + 1) + "\u001B[33m.|                              " + cartelera[i]+ "                              |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|\u001B[0m");
                }

                System.out.println("\u001B[31m|******************************************************************************************|\u001B[0m");
                System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                System.out.println((cartelera.length + 1) +"\u001B[33m|.                                   Salir                                          |\u001B[0m");
                System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                System.out.println("\u001B[31m|******************************************************************************************|\u001B[0m");

                System.out.println("\u001B[32mEscoja una opcion: \u001B[0m");

                if (!scanner.hasNextInt()) {
                    for (int i = 0; i < 8; i++) {
                        System.out.println();
                    }
                    System.out.println("\u001B[31m|******************************************************************************************|\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                             Solo números son válidos\n\n\n\n                             |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[31m|******************************************************************************************|\u001B[0m");
                    scanner.next();
                    continue;
                }
                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= cartelera.length) {
                    System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[31m|                      ¿Que tipo de funcion desea para la pelicula?                        |\u001B[0m");
                    System.out.println("\u001B[31m|                             1. Funcion Tradicional                                       |\u001B[0m");
                    System.out.println("\u001B[31m|                             2. Funcion 3D                                                |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");


                    int Boletos = scanner.nextInt();

                    if (Boletos == 1) {
                        double PrecioA = 5.00;
                        double PrecioB = 3.90;

                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[31m|                      Ingreses la cantidad de entradas para adulto :                      |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");

                        int CantidadA = scanner.nextInt();

                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[31m|           Ingreses la cantidad de entradas para adulto Mayor de 70 años :                |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");

                        int CantidadB = scanner.nextInt();

                        if (CantidadA >= 00.00 && CantidadB >= 00.00){
                            double totalAdulto = PrecioA * CantidadA;
                            double totalViejitos = PrecioB * CantidadB;
                            double totalBoletos = totalAdulto + totalViejitos;

                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Pelicula seleccionada: " + cartelera[opcion - 1] + "                   |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Opcion Tradicional. Disfrute su funcion!!!                             |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Total a pagar por Adultos:"+totalAdulto+ "                                     |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Total a pagar por Adultos Mayores de 70 años:" +totalViejitos+"                       |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Total a pagar por Boletos:" +totalBoletos+ "                                         |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");


                        }else {
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                   La cantidad ingresada debe ser mayor a 0 wey                           |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        }

                    } else if (Boletos == 2) {
                        double PrecioA = 5.60;
                        double PrecioB = 6.55;

                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[31m|                      Ingreses la cantidad de entradas para adulto :                      |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");

                        int CantidadA = scanner.nextInt();

                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[31m|           Ingreses la cantidad de entradas para adulto Mayor de 70 años :                |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");

                        int CantidadB = scanner.nextInt();

                        if (CantidadA >= 00.00 && CantidadB >= 00.00){
                            double totalAdulto = PrecioA * CantidadA;
                            double totalViejitos = PrecioB * CantidadB;
                            double totalBoletos = totalAdulto + totalViejitos;
                            DecimalFormat df = new DecimalFormat("0.00");
                            String totaltotal = df.format(totalBoletos);

                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Pelicula seleccionada: " + cartelera[opcion - 1] + "                   |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Opcion 3D. Disfrute su funcion!!!                                      |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Total a pagar por Adultos: "+totalAdulto+ "                                   |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Total a pagar por Adultos Mayores de 70 años: "+totalViejitos+"                     |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[32m|                   Total a pagar por Boletos:"+totalBoletos+"                                           |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");

                        }else {
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                   La cantidad ingresada debe ser mayor a 0 wey                           |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                            System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        }

                    } else {
                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|      Opcion no valida. Use opcion 1. (T) o 2. (3D)!!!                                    |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                        System.out.println("\u001B[33m|------------------------------------------------------------------------------------------|\u001B[0m");
                    }

                } else if (opcion == cartelera.length + 1) {
                    System.out.println("\u001B[31m|*********************************************|\u001B[0m");
                    System.out.println("\u001B[33m|                                             |\u001B[0m");
                    System.out.println("\u001B[33m|                                             |\u001B[0m");
                    System.out.println("\u001B[33m|           Saliendo del Programa.            |\u001B[0m");
                    System.out.println("\u001B[33m|                                             |\u001B[0m");
                    System.out.println("\u001B[33m|                                             |\u001B[0m");
                    System.out.println("\u001B[31m|*********************************************|\u001B[0m");
                } else {
                    System.out.println("\u001B[31m|******************************************************************************************|\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|      Opcion no valida. Debe ser un numero del 1 al " + (cartelera.length + 1) +         "|\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[33m|                                                                                          |\u001B[0m");
                    System.out.println("\u001B[31m|******************************************************************************************|\u001B[0m");
                }
            } while (opcion != cartelera.length + 1);

        }
    }


