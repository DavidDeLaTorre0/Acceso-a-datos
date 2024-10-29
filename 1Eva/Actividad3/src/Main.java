import dao.ConexionO;
import entity.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {



        //Crear tabla empresa
        crearObjetoEmpresa();

        //Crear tabla departamentos
        //Crear tabla empresa
        //insertar empleados
        //insertar empresa
        //insertar departamentos


    }

    private static Connection con;


    public static void crearObjetoEmpresa() throws SQLException {

        con = ConexionO.conectar();
        Statement st = con.createStatement();
        String head = "CREATE OR REPLACE TYPE EMPRESA AS OBJECT(" +
                "CIF VARCHAR2(25)," +
                "NOMBRE VARCHAR2(25)," +
                "MEMBER PROCEDURE SET_CIF(CIF VARCHAR2)," +
                "MEMBER FUNCTION GET_CIF RETURN VARCHAR2" +
                ")";
        st.executeUpdate(head);
        System.out.println("Tabla de empresas creada");

        String body = "CREATE OR REPLACE TYPE BODY EMPRESA AS " +
                "MEMBER PROCEDURE SET_CALLE(CIF VARCHAR2) IS" +
                "BEGIN" +
                "SELF.CIF:=CIF" +
                "END" +
                "MEMBER FUNCTION GET_CALLE() IS" +
                "BEGIN" +
                "RETURN SELF.CIF" +
                "END";
        st.executeUpdate(body);


        st.close();
        con.close();


    }
    public static void crearObjetoEmpleado() throws SQLException {

        con = ConexionO.conectar();
        Statement st = con.createStatement();
        String head = "CREATE OR REPLACE TYPE EMPLEADO UNDER PERSONA(" +
                "CARGO VARCHAR2(25)," +
                "DEPARTAMENTO VARCHAR2(25)," +
                "MEMBER PROCEDURE SET_CIF(CIF VARCHAR2)," +
                "MEMBER FUNCTION GET_CIF RETURN VARCHAR2" +
                ")";
        st.executeUpdate(head);
        System.out.println("Tabla de empresas creada");

        String body = "CREATE OR REPLACE TYPE BODY EMPLEADO AS " +
                "MEMBER PROCEDURE SET_CALLE(CIF VARCHAR2) IS" +
                "BEGIN" +
                "SELF.CIF:=CIF" +
                "END" +
                "MEMBER FUNCTION GET_CALLE() IS" +
                "BEGIN" +
                "RETURN SELF.CIF" +
                "END";
        st.executeUpdate(body);


        st.close();
        con.close();


    }

    public static void saveEmpresa(Empresa empresa) throws SQLException {

        con = ConexionO.conectar();
        String sql = "INSERT INTO Empresa(cif,nombre) VALUES (?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, empresa.getCif());
            stmt.setString(2, empresa.getNombre());
            stmt.executeUpdate();
        }


    }

    public static void rEmpresa() throws SQLException {

        con = ConexionO.conectar();
        String sql = "INSERT INTO Empresa(cif,nombre) VALUES (?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.executeUpdate();
        }


    }


}