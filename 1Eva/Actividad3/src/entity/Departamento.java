package entity;

import java.util.ArrayList;

public class Departamento {

    private ArrayList<Empleado> empleados= new ArrayList<Empleado>();
    private Empresa empresa;
    private String id;
    private String localizacion;
    private String nombre;


    public Departamento() {
        super();
    }

    public Departamento(ArrayList<Empleado> empleados, Empresa empresa, String id, String localizacion, String nombre) {
       this.empleados = empleados;
        this.empresa = empresa;
        this.id = id;
        this.localizacion = localizacion;
        this.nombre = nombre;
    }

    public void altaEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }
    public void bajaEmpleado(){
        this.empleados.remove(empleados.size()-1);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
