package Registropeliculas;

public class Peliculas {
    public class Pelicula {
        // Atributos
        private String nombre;
        private String genero;
        private String clasificacion;

        // Constructor
        public Pelicula(String nombre, String genero, String clasificacion) {
            this.nombre = nombre;
            this.genero = genero;
            this.clasificacion = clasificacion;
        }

        public String getNombre(){return nombre; }
        public String getGenero(){return genero;}
        public String getClasificacion(){return clasificacion;}

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public void setClasificacion(String clasificacion) {
            this.clasificacion = clasificacion;
        }

    }
}