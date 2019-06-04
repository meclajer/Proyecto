package controlador;

import conexionBD.ConexionMyAQL;
import modelo.ProductoFinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class ProductoDAO {

    public boolean incertar(ProductoFinal produto){
        boolean finalizo = false;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("INSERT INTO PRODUCTOFINAL VALUES (?,?,?,?,?,?)");
            mPreparedStatement.setString( 1, produto.getIdProductoFinal());
            mPreparedStatement.setString(2, produto.getCaracteristicaPrincipal());
            mPreparedStatement.setString(3, produto.getNombreProducto());
            mPreparedStatement.setString(4, produto.getTalla());
            mPreparedStatement.setInt(5, produto.getCantidad());
            mPreparedStatement.setDouble(6, produto.getPrecio());
            mPreparedStatement.executeUpdate();
            finalizo = true;
            mPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }

    public boolean cunsultaCompleta(JTable tablaAlumnosConsultas){

        boolean completo = true;

        ResultSet rs = null;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("SELECT * FROM productofinal");
            rs = mPreparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            completo = false;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumnosConsultas.getModel();

        try {
            while (rs.next()){

                modelo.addRow(new String[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)+"",
                        rs.getDouble(6)+""
                });
            }
            tablaAlumnosConsultas.setModel(modelo);
        }catch (Exception ex){
            completo = false;
        }

        return completo;
    }

    public boolean cunsultaCaracteristica(JTable tablaAlumnosConsultas, String valor){

        boolean completo = true;

        ResultSet rs = null;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("SELECT * FROM productofinal WHERE caracteristicaPrincipal = ?");
            mPreparedStatement.setString(1, valor);
            rs = mPreparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            completo = false;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumnosConsultas.getModel();

        while (modelo.getRowCount() > 0)
        {
            modelo.removeRow(0);
        }

        try {
            while (rs.next()){

                modelo.addRow(new String[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)+"",
                        rs.getDouble(6)+""
                });
            }
            tablaAlumnosConsultas.setModel(modelo);
        }catch (Exception ex){
            completo = false;
        }

        return completo;
    }

    public boolean cunsultaCantidad(JTable tablaAlumnosConsultas, int valor){

        boolean completo = true;

        ResultSet rs = null;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("SELECT * FROM productofinal WHERE cantidad >= ?");
            mPreparedStatement.setInt(1, valor);
            rs = mPreparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            completo = false;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumnosConsultas.getModel();

        while (modelo.getRowCount() > 0)
        {
            modelo.removeRow(0);
        }

        try {
            while (rs.next()){

                modelo.addRow(new String[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)+"",
                        rs.getDouble(6)+""
                });
            }
            tablaAlumnosConsultas.setModel(modelo);
        }catch (Exception ex){
            completo = false;
        }

        return completo;
    }

    public boolean cunsultaTalla(JTable tablaAlumnosConsultas, String valor){

        boolean completo = true;

        ResultSet rs = null;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("SELECT * FROM productofinal WHERE talla = ?");
            mPreparedStatement.setString(1, valor);
            rs = mPreparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            completo = false;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaAlumnosConsultas.getModel();

        while (modelo.getRowCount() > 0)
        {
            modelo.removeRow(0);
        }

        try {
            while (rs.next()){

                modelo.addRow(new String[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)+"",
                        rs.getDouble(6)+""
                });
            }
            tablaAlumnosConsultas.setModel(modelo);
        }catch (Exception ex){
            completo = false;
        }

        return completo;
    }

    public boolean actualizacion(ProductoFinal producto){
        boolean finalizo = false;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("UPDATE productofinal SET " +
                    "caracteristicaPrincipal = ?, " +
                    "nombreProducto = ?, " +
                    "talla = ?, " +
                    "cantidad = ?, " +
                    "precio = ? " +
                    "WHERE idProductoFinal = ?");
            mPreparedStatement.setString( 1, producto.getCaracteristicaPrincipal());
            mPreparedStatement.setString(2, producto.getNombreProducto());
            mPreparedStatement.setString(3, producto.getTalla());
            mPreparedStatement.setInt(4, producto.getCantidad());
            mPreparedStatement.setDouble(5, producto.getPrecio());
            mPreparedStatement.setString(6, producto.getIdProductoFinal());
            mPreparedStatement.executeUpdate();
            finalizo = true;
            mPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }

    public boolean eliminar (String id){
        boolean finalizo = false;

        try {
            PreparedStatement mPreparedStatement = ConexionMyAQL.getConnection().prepareStatement("DELETE FROM productofinal WHERE idProductoFinal = ?");
            mPreparedStatement.setString(1, id);
            mPreparedStatement.executeUpdate();
            finalizo = true;
            mPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }

    public void limpiarTabla(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0)
        {
            modelo.removeRow(0);
        }
    }

}
