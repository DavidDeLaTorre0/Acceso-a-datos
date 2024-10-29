import dao.ConexionO;
import entity.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {



        //Crear objeto empresa
        crearObjetoEmpresa();

        //Crear objeto departamentos
        //crearObjetoDep();

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
                "MEMBER FUNCTION GET_CIF RETURN VARCHAR2," +
                "MEMBER PROCEDURE SET_NOMBRE(NOMBRE VARCHAR2)," +
                "MEMBER FUNCTION GET_NOMBRE RETURN VARCHAR2" +
                ")";
        st.executeUpdate(head);
        System.out.println("Tabla de empresas creada");

        //SELF SE UTILIZA CUANDO ESTAS PASANDO UNA VARIABLE DEL MISMO NOMBRE POR PARAMETRO
        String body = "CREATE OR REPLACE TYPE BODY EMPRESA AS " +
                "MEMBER PROCEDURE SET_CIF(CIF VARCHAR2) IS" +
                "BEGIN" +
                "SELF.CIF:=CIF" +
                "END" +
                "MEMBER FUNCTION GET_CIF() IS" +
                "BEGIN" +
                "RETURN SELF.CIF" +
                "END"+
                "MEMBER PROCEDURE SET_CIF(NOMBRE VARCHAR2) IS" +
                "BEGIN" +
                "SELF.NOMBRE:=NOMBRE" +
                "END" +
                "MEMBER FUNCTION GET_NOMBRE() IS" +
                "BEGIN" +
                "RETURN SELF.NOMBRE" +
                "END";
        st.executeUpdate(body);


        st.close();
        con.close();


    }

    public static void crearObjetoDep() throws SQLException {

        con = ConexionO.conectar();
        Statement st = con.createStatement();
        String head = "CREATE OR REPLACE TYPE DEPARTAMENTO AS OBJECT(" +
                "ID VARCHAR2(25)," +
                "LOCALIZACION VARCHAR2(25)," +
                "NOMBRE VARCHAR2(25)," +
                "EMP EMPRESA," +
                "MEMBER PROCEDURE SET_ID(ID VARCHAR2)," +
                "MEMBER FUNCTION GET_ID RETURN VARCHAR2," +
                "MEMBER PROCEDURE SET_LOCALIZACION(LOCALIZACION VARCHAR2)," +
                "MEMBER FUNCTION GET_LOCALIZACION RETURN VARCHAR2," +
                "MEMBER PROCEDURE SET_NOMBRE(NOMBRE VARCHAR2)," +
                "MEMBER FUNCTION GET_NOMBRE RETURN VARCHAR2," +
                "MEMBER PROCEDURE SET_EMPRESA(EMPRESA empresa)," +
                "MEMBER FUNCTION GET_EMPRESA RETURN VARCHAR2" +
                ")";
        st.executeUpdate(head);
        System.out.println("Tabla de DEPARTAMENTO creada");

        String body = "CREATE OR REPLACE TYPE BODY DEPARTAMENTO AS " +
                "MEMBER PROCEDURE SET_ID(ID VARCHAR2) IS" +
                "BEGIN" +
                "SELF.ID:=ID" +
                "END" +
                "MEMBER FUNCTION GET_ID() IS" +
                "BEGIN" +
                "RETURN SELF.ID" +
                "END"+
                "MEMBER PROCEDURE SET_LOCALIZACION(LOCALIZACION VARCHAR2) IS" +
                "BEGIN" +
                "SELF.LOCALIZACION:=LOCALIZACION" +
                "END" +
                "MEMBER FUNCTION GET_LOCALIZACION() IS" +
                "BEGIN" +
                "RETURN SELF.LOCALIZACION" +
                "END"+
                "MEMBER PROCEDURE SET_NOMBRE(NOMBRE VARCHAR2) IS" +
                "BEGIN" +
                "SELF.NOMBRE:=NOMBRE" +
                "END" +
                "MEMBER FUNCTION GET_NOMBRE() IS" +
                "BEGIN" +
                "RETURN SELF.NOMBRE" +
                "END"+
                "MEMBER PROCEDURE SET_EMPRESA(EMP EMPRESA) IS" +
                "BEGIN" +
                "EMP:=EMP" +
                "END" +
                "MEMBER FUNCTION GET_EMPRESA() IS" +
                "BEGIN" +
                "RETURN EMP" +
                "END";
        st.executeUpdate(body);


        st.close();
        con.close();
        System.out.println("Tabla de departamento con procedures");


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
                "END"+
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