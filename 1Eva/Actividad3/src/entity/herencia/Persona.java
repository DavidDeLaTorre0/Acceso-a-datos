package entity.herencia;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.Date;

public class Persona {
    private String dni;
    private LocalDate fechaNacimiento;
    private String estado;
    private String nombre;

    public Persona() {
        super();
    }

    public Persona(String dni, LocalDate fechaNacimiento, String estado, String nombre) {
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void cumpleanios(){

        int fecha = Calendar.getInstance().get(Calendar.YEAR);
        int anio = fecha - this.fechaNacimiento.getYear();
        System.out.println("Anio de nacimiento: " + anio);

    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", estado='" + estado + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

