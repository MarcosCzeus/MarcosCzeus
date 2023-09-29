package Registro;


public class Sucursal {

    private String nombreSucursal;
    private String gerente;
    private String direccion;
    private String numeroTelefono;
    private int CodigoSucursal;


    public Sucursal(String nombreSucursal, String gerente, String direccion, String numeroTelefono) {

        if (nombreSucursal.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sucursal no puede estar vacío.");
        }

        if (gerente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del gerente no puede estar vacío.");
        }

        if (direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }

        if (!numeroTelefono.matches("^\\d{8}-\\d$")) {
            throw new IllegalArgumentException("El número de teléfono debe tener 8 números y un guión.");
        }


        this.nombreSucursal = nombreSucursal;
        this.gerente = gerente;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombreSucursal(String nombreSucursal){return nombreSucursal;}

    public String getDireccion() {
        return direccion;
    }

    public String getGerente() {
        return gerente;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
