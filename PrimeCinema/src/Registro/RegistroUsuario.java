package Registro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class RegistroUsuario {

    private static final String Name_JSON_FILE = "name.json";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Cargar la lista de usuarios desde el archivo JSON si existe, o si no crea uno a la hora de que el primer usuario se registre
        List<Usuario> usuariosRegistrados = cargarUsuariosDesdeJSON();

        // Datos de registro
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                              Ingrese su nombre de usuario:                                 ");
        String login = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                                  Ingrese su contraseña:                                    ");
        String password = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                                Ingrese su nombre completo:                                 ");
        String nombreCompleto = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                                 Ingrese su número de DUI:                                  ");
        String dui = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                               Ingrese su correo electrónico:                               ");
        String correoElectronico = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");
        System.out.println("                              Ingrese su número de teléfono:                                ");
        String numeroTelefono = scanner.nextLine();
        System.out.println("____________________________________________________________________________________________");

        // Nuevo usuario
        Usuario usuario = new Usuario(login, password, nombreCompleto, dui, correoElectronico, numeroTelefono);

        // Para ver si ya están registrados
        boolean loginDisponible = true;
        boolean duiDisponible = true;
        for (Usuario usuarioRegistrado : usuariosRegistrados) {
            if (usuarioRegistrado.getLogin().equals(login)) {
                loginDisponible = false;
                break;
            }
            if (usuarioRegistrado.getDui().equals(dui)) {
                duiDisponible = false;
                break;
            }
        }

        // El DUI tiene que tener el formato "000000000-0"
        boolean duiValido = dui.matches("[0-9\\-]{10}");
        int digitos = dui.length();

        // Se valida el número de teléfono
        boolean telefonoValido = numeroTelefono.matches("[0-9-]+");
        int digitosTelefono = numeroTelefono.length();

        // Valida registro
        if (loginDisponible && duiDisponible && duiValido && digitos == 11 && telefonoValido && digitosTelefono == 9) {
            // Lista de registro
            usuariosRegistrados.add(usuario);
            System.out.println("____________________________________________________________________________________________");
            System.out.println("                              Lista de usuarios registrados:                                ");
            System.out.println("____________________________________________________________________________________________");

            // Imprime la lista de usuarios registrados
            for (Usuario usuario1 : usuariosRegistrados) {
                System.out.println("____________________________________________________________________________________________");
                System.out.println();
                System.out.println("                               Usuario: " + usuario1.getLogin());
                System.out.println("                               Contraseña: " + usuario1.getPassword());
                System.out.println("                               Nombre completo: " + usuario1.getNombre());
                System.out.println("                               DUI: " + usuario1.getDui());
                System.out.println("                               Correo electrónico: " + usuario1.getCorreo());
                System.out.println("                               Número de teléfono: " + usuario1.getNumTelefono());
                System.out.println();
                System.out.println("____________________________________________________________________________________________");
            }

            // Guardar la lista de usuarios actualizada en el archivo JSON
            guardarUsuariosEnJSON(usuariosRegistrados);

            System.out.println("____________________________________________________________________________________________");
            System.out.println("                                     Registrado.                                            ");
            System.out.println("____________________________________________________________________________________________");

        } else {
            if (!loginDisponible) {
                System.out.println("____________________________________________________________________________________________");
                System.out.println("                            El nombre de usuario ya está en uso.                            ");
                System.out.println("____________________________________________________________________________________________");
            } else if (!duiValido) {
                System.out.println("____________________________________________________________________________________________");
                System.out.println("     El número de DUI ingresado es incorrecto, debe estar en formato (000000000-0).     ");
                System.out.println("____________________________________________________________________________________________");
            } else if (digitosTelefono != 9) {
                System.out.println("____________________________________________________________________________________________");
                System.out.println("             El número de teléfono debe tener 8 dígitos y un guión (0000-0000).             ");
                System.out.println("____________________________________________________________________________________________");
            }
        }
    }

    private static List<Usuario> cargarUsuariosDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Usuario> usuariosRegistrados = new ArrayList<>();

        try {
            usuariosRegistrados = objectMapper.readValue(new File(Name_JSON_FILE),
                    new TypeReference<List<Usuario>>() {});
        } catch (IOException e) {
            // Si ocurre un error al cargar el archivo JSON (puede ser la primera ejecución), simplemente retorna una lista vacía.
        }

        return usuariosRegistrados;
    }

    private static void guardarUsuariosEnJSON(List<Usuario> usuariosRegistrados) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(Name_JSON_FILE), usuariosRegistrados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
