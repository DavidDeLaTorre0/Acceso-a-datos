package entity;

public class Empresa {

    private String cif;
    private String nombre;

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
