package vista;

import controlador.ProductoDAO;
import modelo.ProductoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventas {

    JTable tablaAlumnosConsultas;
    ProductoDAO mProductoDAO = new ProductoDAO();
    int selecionado, disponible, vendidos;
    String cadena_idProducto;

    public JPanel ventaUnica(){
        JPanel venta = new JPanel(null);

        venta.setSize(1100, 800);
        venta.setBounds(0, 0, 1100, 800);
        venta.setBackground(new Color(0x214E7F));

        //Componentes
        JLabel titulo = new JLabel("Filtrar por:");
        JLabel tipoProducto = new JLabel("Elija una opcion");
        JButton xTipo = new JButton("Producto");
        JButton xCantidad = new JButton("Cantidad");
        JButton xTalla = new JButton("Talla");
        JButton filtrar = new JButton("Filtrar");
        JComboBox<String> productoSeleccionado = new JComboBox<String>();
        Font letraTitulo = new Font("ARIAL", Font.BOLD, 50);
        Font letraContenido = new Font("ARIAL", Font.BOLD, 20);
        Color letrasClaras = new Color(250,250,250);
        Color fondo = new Color(0x71CEFA);
        //Parte 2 ======================================================================================================
        JLabel seleccionado = new JLabel("Articulo seleccionado.-");
        JLabel articulo = new JLabel("Seleccione un articulo");//Texto Cambiante================================
        JLabel caracPrincipal = new JLabel("Caracteristica Principal: ");
        JLabel talla = new JLabel("Talla: ");
        JLabel cantidad = new JLabel("Cantidad Disponible: ");
        JComboBox<Integer> disponibles = new JComboBox<Integer>();
        JLabel precio = new JLabel("Precio por unidad: ");
        JButton vender = new JButton("Vender");

        JButton restablecer = new JButton("Restablecer");


        //configuracion
        titulo.setFont(letraTitulo);
        titulo.setForeground(letrasClaras);
        titulo.setBackground(fondo);
        xTipo.setFont(letraContenido);
        xTipo.setForeground(letrasClaras);
        xTipo.setBackground(fondo);
        xCantidad.setFont(letraContenido);
        xCantidad.setForeground(letrasClaras);
        xCantidad.setBackground(fondo);
        xTalla.setFont(letraContenido);
        xTalla.setForeground(letrasClaras);
        xTalla.setBackground(fondo);
        tipoProducto.setFont(letraTitulo);
        tipoProducto.setForeground(letrasClaras);
        tipoProducto.setBackground(fondo);
        productoSeleccionado.setFont(letraContenido);
        productoSeleccionado.setForeground(letrasClaras);
        productoSeleccionado.setBackground(fondo);
        productoSeleccionado.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        productoSeleccionado.setForeground(new Color(0x387AB1));
        productoSeleccionado.addItem("Seleccione una opcion");
        filtrar.setForeground(letrasClaras);
        filtrar.setFont(letraContenido);
        filtrar.setBackground(fondo);
        //Parte 2 ======================================================================================================
        seleccionado.setFont(new Font("ARIAL", Font.BOLD, 40));
        seleccionado.setForeground(letrasClaras);
        seleccionado.setBackground(fondo);
        articulo.setFont(letraContenido);
        articulo.setForeground(letrasClaras);
        articulo.setBackground(fondo);
        caracPrincipal.setFont(letraContenido);
        caracPrincipal.setForeground(letrasClaras);
        caracPrincipal.setBackground(fondo);
        talla.setFont(letraContenido);
        talla.setForeground(letrasClaras);
        talla.setBackground(fondo);
        cantidad.setFont(letraContenido);
        cantidad.setForeground(letrasClaras);
        cantidad.setBackground(fondo);
        disponibles.setFont(letraContenido);
        disponibles.setForeground(letrasClaras);
        disponibles.setBackground(fondo);
        precio.setFont(letraContenido);
        precio.setForeground(letrasClaras);
        precio.setBackground(fondo);
        vender.setFont(letraContenido);
        vender.setForeground(letrasClaras);
        vender.setBackground(fondo);
        restablecer.setFont(letraContenido);
        restablecer.setForeground(letrasClaras);
        restablecer.setBackground(fondo);

        //Ubicacion
        titulo.setBounds(30, 30, 300, 50);
        xTipo.setBounds(40, 100, 130, 30);
        xCantidad.setBounds(220, 100, 130, 30);
        xTalla.setBounds(400, 100, 130, 30);
        tipoProducto.setBounds(30, 150, 400, 60);
        productoSeleccionado.setBounds(30, 220, 530, 30);
        filtrar.setBounds(30, 260, 530, 30);
        //Parte 2 ======================================================================================================
        seleccionado.setBounds(610, 30+50, 500, 70);
        articulo.setBounds(610, 110+50, 440, 30);
        caracPrincipal.setBounds(610, 200, 500, 30);
        talla.setBounds(610, 250, 300, 30);
        cantidad.setBounds(610, 290, 220, 30);
        disponibles.setBounds(610, 330, 100, 30);
        precio.setBounds(610, 370, 300, 30);
        vender.setBounds(610, 410, 440, 30);
        restablecer.setBounds(610, 460, 440, 30);


        //Agregar
        venta.add(titulo);
        venta.add(xTipo);
        venta.add(xCantidad);
        venta.add(xTalla);
        venta.add(tipoProducto);
        venta.add(productoSeleccionado);
        venta.add(filtrar);
        //Parte 2 ======================================================================================================
        venta.add(seleccionado);
        venta.add(articulo);
        venta.add(caracPrincipal);
        venta.add(talla);
        venta.add(cantidad);
        venta.add(disponibles);
        venta.add(precio);
        venta.add(vender);
        venta.add(restablecer);

        //Tabla ==============================================================================================================================================================
        JPanel tabla = new JPanel();
        tabla.setVisible(true);
        tabla.setLayout(null);
        tabla.setSize(600, 400);
        tabla.setBounds(30, 310, 530, 400);
        tablaAlumnosConsultas = new JTable();
        tablaAlumnosConsultas.setBounds(0, 0, 530, 800);
        tablaAlumnosConsultas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                }, new String []{"ID Producto", "Tipo", "Nombre", "Talla", "Cantidad", "Precio"}
        ));
        tablaAlumnosConsultas.setGridColor(new Color(0x214E7F));
        //tablaAlumnosConsultas.setBackground(new Color(0x214E7F));
        tablaAlumnosConsultas.setSelectionBackground(new Color(0x3888D9));
        tabla.setBackground(new Color(0x214E7F));
        JScrollPane scrolltable = new JScrollPane();
        scrolltable.setViewportView(tablaAlumnosConsultas);
        scrolltable.setSize(530, 400);
        tabla.add(scrolltable);

        venta.add(tabla);

        //Acciones
        xTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Camisa");
                productoSeleccionado.addItem("Moño");
                productoSeleccionado.addItem("Vestido");
            }
        });
        xCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("2 o más");
                productoSeleccionado.addItem("4 o más");
                productoSeleccionado.addItem("6 o más");
            }
        });
        xTalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Infantil");
                productoSeleccionado.addItem("Chica");
                productoSeleccionado.addItem("mediana");
                productoSeleccionado.addItem("Grande");
                productoSeleccionado.addItem("Extra Grande");
            }
        });
        filtrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                switch (selecionado){
                    case 1: mProductoDAO.cunsultaCaracteristica(tablaAlumnosConsultas, productoSeleccionado.getSelectedItem().toString());
                        break;
                    case 2: mProductoDAO.cunsultaCantidad(tablaAlumnosConsultas, Integer.parseInt(productoSeleccionado.getSelectedItem().toString().substring(0,1)));
                        break;
                    case 3: mProductoDAO.cunsultaTalla(tablaAlumnosConsultas, productoSeleccionado.getSelectedItem().toString());

                }


            }
        });
        tablaAlumnosConsultas.addMouseListener(new MouseListener() {//PENDIENTE=============================== PENDIENTE
            @Override
            public void mouseClicked(MouseEvent e) {

                articulo.setText("Seleccione un articulo");
                caracPrincipal.setText(caracPrincipal.getText().substring(0,26));
                talla.setText(talla.getText().substring(0,7));
                disponibles.removeAllItems();
                precio.setText(precio.getText().substring(0, 19));
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Seleccione una opcion");

                cadena_idProducto = tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 0).toString();
                articulo.setText(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 2).toString());
                caracPrincipal.setText(caracPrincipal.getText() + tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 1).toString());
                talla.setText(talla.getText() + tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 3).toString());
                disponible = Integer.parseInt(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 4).toString());
                for (int i = 1; i <= disponible; i++){
                    disponibles.addItem(i);
                }
                precio.setText(precio.getText() + tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 5).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//Pendiente
        restablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                articulo.setText("Seleccione un articulo");
                caracPrincipal.setText(caracPrincipal.getText().substring(0,26));
                talla.setText(talla.getText().substring(0,7));
                disponibles.removeAllItems();
                precio.setText(precio.getText().substring(0, 19));
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Seleccione una opcion");
                mProductoDAO.limpiarTabla(tablaAlumnosConsultas);
                mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);
            }
        });
        vender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendidos = Integer.parseInt(disponibles.getSelectedItem().toString());
                if (vendidos < disponible){
                    ProductoFinal mProductoFinal = new ProductoFinal(
                            cadena_idProducto,
                            caracPrincipal.getText().substring(26, caracPrincipal.getText().length()),
                            articulo.getText(),
                            talla.getText().substring(7, talla.getText().length()),
                            (disponible-vendidos),
                            Double.parseDouble(precio.getText().substring(19, precio.getText().length()))
                    );
                    mProductoDAO.actualizacion(mProductoFinal);
                    mProductoDAO.limpiarTabla(tablaAlumnosConsultas);
                    mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);
                }else {
                    mProductoDAO.eliminar(cadena_idProducto);
                    mProductoDAO.limpiarTabla(tablaAlumnosConsultas);
                    mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);
                }
                articulo.setText("Seleccione un articulo");
                caracPrincipal.setText(caracPrincipal.getText().substring(0,26));
                talla.setText(talla.getText().substring(0,7));
                disponibles.removeAllItems();
                precio.setText(precio.getText().substring(0, 19));
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Seleccione una opcion");
            }
        });

        mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);

        return venta;
    }


}
