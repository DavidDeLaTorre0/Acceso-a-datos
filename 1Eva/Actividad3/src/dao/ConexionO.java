package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionO {
    private static Connection jdbc = null;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/mydatabase";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USER = "myuser";
    private static final String PASS = "userpassword";

    private ConexionO() throws SQLException{
        if(jdbc == null || jdbc.isClosed()){
            try{
                 Class.forName(DRIVER);
                 jdbc = DriverManager.getConnection(URL, USER, PASS);

            }catch(ClassNotFoundException e){
                throw new SQLException(e.getMessage());
            }
        }
    }

    public static Connection conectar() throws SQLException{

        new ConexionO();
        return jdbc;
    }

    public static void desconectar() throws SQLException{
        if(jdbc!=null && jdbc.isClosed()){
            jdbc.close();
        }
    }

    /*

    public boolean insertar(String sql) throws SQLException {

        connection = Conexion.conectar();
        Statement statement = connection.createStatement();

        // Ejecutamos la sentencia
        boolean rowInserted = statement.executeUpdate(sql) > 0;

        statement.close();
        Conexion.desconectar();
        return rowInserted;
    }


    public ResultSet seleccionRegistros(String consultaSQL) {
        Statement sentencia = null;
        ResultSet filas = null;

        try {
            connection = Conexion.conectar();
            sentencia = connection.createStatement();
            filas = sentencia.executeQuery(consultaSQL);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return filas;

    }
    */


}
