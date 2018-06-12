/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.metodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filtro;

/**
 *
 * @author UCA
 */
public class FiltroDao implements metodos<Filtro>{
    
    private static final String SQL_INSET = "INSERT INTO filtros_aceite (codFiltro,marca,stock,existencia VALUES (?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE filtros_aceite SET marca=?, stock=?,existencia=? WHERE codFiltro=?";
    private static final String SQL_DELETE = "DELETE FROM filtro_aceite WHERE codFiltro=?";
    private static final String SQL_READ = "SELECT FROM filtro_aceite WHERE codFiltro=?";
    private static final String SQL_READALL = "SELECT FROM filtro_aceite";
    private static final Conexion con=Conexion.conectar();
    
    
    @Override
    public boolean create(Filtro g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
       preparedStatement ps;
       try{
           ps=con.getCnx().prepareStatement(SQL_DELETE);
           ps.setString(1, key.toString());
           
           if (ps.executeUpdate() >0){
               return true ;
        
           }
           
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
           con.cerrarConexion();
       }
       return false;
    }

    @Override
    public boolean update(Filtro c) {
       preparedStatement ps;
       try{
           System.out.println(c.getCodigo());
           ps=con.getCnx().prepareStatement(SQL_UPDATE);
           ps.setString(1, c.getMarca());
           ps.setInt(2, c.getStock());
           
           
           if (ps.executeUpdate() >0){
               return true ;
        
           }
           
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
           con.cerrarConexion();
       }
       return false;
    }

    @Override
    public Filtro read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Filtro> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
