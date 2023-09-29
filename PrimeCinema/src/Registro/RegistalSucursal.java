package Registro;


import com.sun.security.jgss.GSSUtil;

import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RegistalSucursal {
    private static List<Sucursal> sucursales = new ArrayList<>();
    private final String SQL_INSERT =
            "INSERT INTO sucursal(nombreSucursal,gerente,direccion,numeroTelefono, CodigoSucursal"
                    +"nombreSucursal,gerente,direccion,numeroTelefono,  ) "+"VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE sucursal SET nombreSucursal=?,gerente=?,"+ "direccion=?,numeroTelefono=?"+
            "WHERE CodigoSucursal=?";
    private final String SQL_DELETE = "DELETE FROM sucursal WHERE CodigoSucursal=?";

    private static final String SQL_SELECT =
            "SELECT nombreSucursal,gerente FROM sucursal ORDER BY CodigoSucursal";
    private final String SQL_SELECT_IDOCUPACION =
            "SELECT CodigoSucursal FROM sucursal where sucursal =?";


    public static void main(String[] args) {
        Connection conn =  null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
                conn = Conexiones.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getObject(2));
                }

            conn =Conexiones.getConnection();
            System.out.println(conn );
        } catch (SQLException e){
            System.out.println(e);
        e.printStackTrace();
        }finally {
            Conexiones.close(rs); Conexiones.close(stmt);
            Conexiones.close(conn);
        }

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
