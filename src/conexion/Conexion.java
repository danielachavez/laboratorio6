/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UCA
 */
public class Conexion {

    public static Conexion conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String user;
    private String pass;
    private String drive;
    private String url;
    
    private Connection cnx;
    
    public static Conexion instance;
    
    
    public synchronized static Conexion conectar(){
     if(instance == null)
     {
         return new Conexion();
     }
        return instance;
    }
    private String driver;
    
    private Conexion(){
        cargarCredenciales();
        
        try{
            Class.forName(this.driver);
            cnx=(Connection) DriverManager.getConnection(this.url,this.user,this.pass);
        }catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }

    private void cargarCredenciales() {
        
    user="root";
    pass="";
    driver="com.mysql://localhost/filtros";
    }
    public Connection getCnx(){
    return cnx;
    }
    
    public void cerrarConexion(){
        instance=null;
    }
}
