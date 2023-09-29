package Registro;


public class Usuario {

    String login;
    String password;
    String nombre;
    String dui;
    String correo;
    String numTelefono;

    public Usuario(String login, String password, String nombre, String dui, String correo, String numeroTelefono) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria.");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre completo es obligatorio.");
        }
        if (dui == null || dui.isEmpty()) {
            throw new IllegalArgumentException("El número de DUI es obligatorio.");
        }
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico es obligatorio.");
        }
        if (numeroTelefono == null || numeroTelefono.isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono es obligatorio.");
        }

        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.dui = dui;
        this.correo = correo;
        this.numTelefono = numeroTelefono;
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDui() {
        return dui;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
}


