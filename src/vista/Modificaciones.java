package vista;

import controlador.ProductoDAO;
import modelo.ProductoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Modificaciones {

    JTable tablaAlumnosConsultas, tablaAlumnosConsultasDos;
    ProductoDAO mProductoDAO = new ProductoDAO();
    String cadena_idProducto = "";
    int selecionado, disponible, vendidos;

    public JPanel modifiacciones(){
        JPanel modif = new JPanel(null);

        modif.setSize(1100, 800);
        modif.setBounds(0, 0, 1100, 800);
        modif.setBackground(new Color(0x214E7F));

        //Componentes
        JLabel txt_ProductoDisponible = new JLabel("Productos Disponibles.-");
        JLabel txt_Filtrar = new JLabel("Filtrar informacion por:");
        JLabel txt_DatosProducto = new JLabel("Datos del articulo.-");
        JLabel txt_Nombre = new JLabel("Nombre del producto:");
        JLabel txt_Cantidad = new JLabel("Cantidad disponible:");
        JLabel txt_Talla = new JLabel("Talla:");
        JLabel txt_Precio = new JLabel("Precio:");
        JLabel txt_cacPrincipal = new JLabel("Tipo:");

        JComboBox<String> combo_TipoProducto = new JComboBox<String>();
        JComboBox<String> combo_Caracteristica = new JComboBox<String>();
        JComboBox<Integer> combo_Cantidad = new JComboBox<Integer>();

        JTextField campo_NombreProducto = new JTextField();
        JComboBox<String> campo_TallaProducto = new JComboBox<String>();
        JTextField campo_Precio = new JTextField();

        JButton btn_filtrar = new JButton("Filtrar");
        JButton btn_actualizar = new JButton("Actualizar");
        JButton btn_restablecer = new JButton("Restablecer");

        //Configuracion
        Font grande = new Font("ARIAL", Font.BOLD, 40);
        Font mediana = new Font("ARIAL", Font.BOLD, 30);
        Font texto = new Font("ARIAL", Font.BOLD, 20);
        Color fondo = new Color(0x214E7F);
        Color letrasClaras = new Color(250,250,250);
        Color fondoComponentes = new Color(0x71CEFA);

        combo_TipoProducto.addItem("CAMISA");
        combo_TipoProducto.addItem("MOÑO");
        combo_TipoProducto.addItem("VESTIDO");

        //combo_Cantidad;

        modif.setBackground(fondo);
        txt_ProductoDisponible.setFont(grande);
        txt_ProductoDisponible.setForeground(letrasClaras);
        //Tabla ==============================================================================================================================================================
        JPanel tabla = new JPanel();
            tabla.setVisible(true);
            tabla.setLayout(null);
            tabla.setSize(500, 400);
            tabla.setBounds(30, 90, 500, 400);
            tablaAlumnosConsultas = new JTable();
            tablaAlumnosConsultas.setBounds(0, 0, 500, 400);
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
            scrolltable.setSize(500, 400);
            tabla.add(scrolltable);
        modif.add(tabla);
        //Tabla ==============================================================================================================================================================
        txt_Filtrar.setFont(mediana);
        txt_Filtrar.setForeground(letrasClaras);
        combo_TipoProducto.setFont(mediana);
        combo_TipoProducto.setBackground(fondoComponentes);
        combo_TipoProducto.setForeground(letrasClaras);

        combo_Caracteristica.addItem("CAMISA");
        combo_Caracteristica.addItem("MOÑO");
        combo_Caracteristica.addItem("VESTIDO");

        btn_filtrar.setFont(grande);
        btn_filtrar.setBackground(fondoComponentes);
        btn_filtrar.setForeground(letrasClaras);
        txt_DatosProducto.setFont(grande);
        txt_DatosProducto.setForeground(letrasClaras);
        txt_cacPrincipal.setFont(mediana);
        txt_cacPrincipal.setBackground(fondoComponentes);
        txt_cacPrincipal.setForeground(letrasClaras);
        txt_Nombre.setFont(mediana);
        txt_Nombre.setForeground(letrasClaras);
        txt_Cantidad.setFont(mediana);
        txt_Cantidad.setForeground(letrasClaras);
        txt_Talla.setFont(mediana);
        txt_Talla.setForeground(letrasClaras);
        txt_Precio.setFont(mediana);
        txt_Precio.setForeground(letrasClaras);
        btn_actualizar.setFont(grande);
        btn_actualizar.setBackground(fondoComponentes);
        btn_actualizar.setForeground(letrasClaras);
        btn_restablecer.setFont(grande);
        btn_restablecer.setBackground(fondoComponentes);
        btn_restablecer.setForeground(letrasClaras);
        campo_NombreProducto.setFont(texto);
        campo_NombreProducto.setBackground(fondoComponentes);
        campo_NombreProducto.setForeground(letrasClaras);
        combo_Caracteristica.setFont(texto);
        combo_Caracteristica.setBackground(fondoComponentes);
        combo_Caracteristica.setForeground(letrasClaras);
        combo_Cantidad.setFont(texto);
        combo_Cantidad.setBackground(fondoComponentes);
        combo_Cantidad.setForeground(letrasClaras);
        for (int i = 1; i <= 100; i++){
            combo_Cantidad.addItem(i);
        }

        campo_TallaProducto.setFont(texto);
        campo_TallaProducto.setBackground(fondoComponentes);
        campo_TallaProducto.setForeground(letrasClaras);
        campo_TallaProducto.addItem("Infantil".toUpperCase());
        campo_TallaProducto.addItem("Chica".toUpperCase());
        campo_TallaProducto.addItem("mediana".toUpperCase());
        campo_TallaProducto.addItem("Grande".toUpperCase());
        campo_TallaProducto.addItem("Extra Grande".toUpperCase());

        campo_Precio.setFont(texto);
        campo_Precio.setBackground(fondoComponentes);
        campo_Precio.setForeground(letrasClaras);

        //Ubicaciones
        txt_ProductoDisponible.setBounds(30, 30, 500, 50);
        //Tabla
        txt_Filtrar.setBounds(30, 500, 350, 50);
        combo_TipoProducto.setBounds(30, 565, 500, 40);
        btn_filtrar.setBounds(30, 625, 500, 50);
        txt_DatosProducto.setBounds(570, 30, 500, 50);
        txt_Nombre.setBounds(570, 130, 320, 30);
        txt_cacPrincipal.setBounds(570, 192, 80, 30);
        txt_Cantidad.setBounds(570, 190+60, 300, 30);
        txt_Talla.setBounds(570, 260+60, 100, 30);
        txt_Precio.setBounds(570, 320+60, 120, 30);
        btn_actualizar.setBounds(570, 390+60, 500, 50);
        btn_restablecer.setBounds(570, 530, 500, 50);
        campo_NombreProducto.setBounds(890, 130, 180, 30);
        combo_Caracteristica.setBounds(650, 192, 160, 30);
        combo_Cantidad.setBounds(870, 190+60, 200, 30);
        campo_TallaProducto.setBounds(650, 260+60, 160, 30);
        campo_Precio.setBounds(680, 320+60, 130, 30);

        //agregar
        modif.add(txt_ProductoDisponible);
        modif.add(txt_Filtrar);
        modif.add(combo_TipoProducto);
        modif.add(btn_filtrar);
        modif.add(txt_DatosProducto);
        modif.add(txt_Nombre);
        modif.add(txt_cacPrincipal);
        modif.add(txt_Cantidad);
        modif.add(txt_Talla);
        modif.add(txt_Precio);
        modif.add(btn_actualizar);
        modif.add(campo_NombreProducto);
        modif.add(combo_Caracteristica);
        modif.add(combo_Cantidad);
        modif.add(campo_TallaProducto);
        modif.add(campo_Precio);
        modif.add(btn_restablecer);

        //Aciones
        btn_filtrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mProductoDAO.cunsultaCaracteristica(tablaAlumnosConsultas, combo_TipoProducto.getSelectedItem().toString());
            }
        });
        btn_actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                combo_Caracteristica.setBackground(fondoComponentes);
                campo_NombreProducto.setBackground(fondoComponentes);
                campo_TallaProducto.setBackground(fondoComponentes);
                combo_Cantidad.setBackground(fondoComponentes);
                campo_Precio.setBackground(fondoComponentes);

                try {
                    ProductoFinal mProductoFinal = new ProductoFinal(
                            cadena_idProducto.toUpperCase(),
                            combo_Caracteristica.getSelectedItem().toString().toUpperCase(),
                            campo_NombreProducto.getText().toUpperCase(),
                            campo_TallaProducto.getSelectedItem().toString().toUpperCase(),
                            Integer.parseInt(combo_Cantidad.getSelectedItem().toString()),
                            Double.parseDouble(campo_Precio.getText().toString())
                    );

                    if (!(mProductoFinal.getIdProductoFinal().equalsIgnoreCase("")) &&
                            !(mProductoFinal.getCaracteristicaPrincipal().equalsIgnoreCase("")) &&
                            !(mProductoFinal.getNombreProducto().equalsIgnoreCase("")) &&
                            !(mProductoFinal.getTalla().equalsIgnoreCase("")) &&
                            mProductoFinal.getCantidad() > 0 &&
                            mProductoFinal.getPrecio() > 0
                            ){
                        mProductoDAO.actualizacion(mProductoFinal);
                        mProductoDAO.limpiarTabla(tablaAlumnosConsultas);
                        mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);
                    }else {
                        //marcar espacios vacios...

                        if (mProductoFinal.getCaracteristicaPrincipal().equalsIgnoreCase("")){
                            combo_Caracteristica.setBackground(Color.RED);
                        }
                        if (mProductoFinal.getNombreProducto().equalsIgnoreCase("") || campo_NombreProducto.getText().equalsIgnoreCase("")){
                            campo_NombreProducto.setBackground(Color.RED);
                        }
                        if (mProductoFinal.getTalla().equalsIgnoreCase("")){
                            campo_TallaProducto.setBackground(Color.RED);
                        }
                        if (mProductoFinal.getCantidad() <= 0 ){
                            combo_Cantidad.setBackground(Color.RED);

                        }
                        if ((mProductoFinal.getPrecio() <= 0) || (campo_Precio.getText().equalsIgnoreCase(""))){
                            campo_Precio.setBackground(Color.RED);
                        }
                        JOptionPane.showMessageDialog(modif, "Complete todos los espacios por favor.");
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(modif, "Complete todos los espacios por favor.");
                }


            }
        });
        btn_restablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                combo_Caracteristica.setBackground(fondoComponentes);
                campo_NombreProducto.setBackground(fondoComponentes);
                campo_TallaProducto.setBackground(fondoComponentes);
                combo_Cantidad.setBackground(fondoComponentes);
                campo_Precio.setBackground(fondoComponentes);

                campo_NombreProducto.setText("");
                combo_Caracteristica.setSelectedItem("CAMISA");
                combo_Cantidad.setSelectedItem(1);
                campo_TallaProducto.setSelectedIndex(0);
                campo_Precio.setText("");
                combo_TipoProducto.setSelectedIndex(0);
                mProductoDAO.limpiarTabla(tablaAlumnosConsultas);
                mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);
            }
        });
        tablaAlumnosConsultas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    cadena_idProducto = tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 0).toString();
                    combo_Caracteristica.setSelectedItem(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 1).toString());
                    campo_NombreProducto.setText(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 2).toString());
                    campo_TallaProducto.setSelectedItem(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 3).toString());
                    combo_Cantidad.setSelectedItem(Integer.parseInt(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 4).toString()));
                    campo_Precio.setText(tablaAlumnosConsultas.getValueAt(tablaAlumnosConsultas.getSelectedRow(), 5).toString());

                }catch (Exception ex){

                }
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
        });

        mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);

        return modif;
    }

    public JPanel eliminaciones(){
        JPanel pEliminar = new JPanel(null);

        pEliminar.setSize(1100, 800);
        pEliminar.setBounds(0, 0, 1100, 800);
        pEliminar.setBackground(new Color(0x214E7F));

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
        JLabel cantidad = new JLabel("Cantidad Disponible: ");//21
        JLabel precio = new JLabel("Precio por unidad: ");
        JButton vender = new JButton("Eliminar");

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
        cantidad.setBounds(610, 290, 500, 30);
        precio.setBounds(610, 340, 300, 30);
        vender.setBounds(610, 410-30, 440, 30);
        restablecer.setBounds(610, 460-30, 440, 30);


        //Agregar
        pEliminar.add(titulo);
        pEliminar.add(xTipo);
        pEliminar.add(xCantidad);
        pEliminar.add(xTalla);
        pEliminar.add(tipoProducto);
        pEliminar.add(productoSeleccionado);
        pEliminar.add(filtrar);
        //Parte 2 ======================================================================================================
        pEliminar.add(seleccionado);
        pEliminar.add(articulo);
        pEliminar.add(caracPrincipal);
        pEliminar.add(talla);
        pEliminar.add(cantidad);
        pEliminar.add(precio);
        pEliminar.add(vender);
        pEliminar.add(restablecer);

        //Tabla ==============================================================================================================================================================
        JPanel tabla = new JPanel();
        tabla.setVisible(true);
        tabla.setLayout(null);
        tabla.setSize(600, 400);
        tabla.setBounds(30, 310, 530, 400);
        tablaAlumnosConsultasDos = new JTable();
        tablaAlumnosConsultasDos.setBounds(0, 0, 530, 800);
        tablaAlumnosConsultasDos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                }, new String []{"ID Producto", "Tipo", "Nombre", "Talla", "Cantidad", "Precio"}
        ));
        tablaAlumnosConsultasDos.setGridColor(new Color(0x214E7F));
        tablaAlumnosConsultasDos.setSelectionBackground(new Color(0x3888D9));
        tabla.setBackground(new Color(0x214E7F));
        JScrollPane scrolltable = new JScrollPane();
        scrolltable.setViewportView(tablaAlumnosConsultasDos);
        scrolltable.setSize(530, 400);
        tabla.add(scrolltable);

        pEliminar.add(tabla);

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
                    case 1: mProductoDAO.cunsultaCaracteristica(tablaAlumnosConsultasDos, productoSeleccionado.getSelectedItem().toString());
                        break;
                    case 2: mProductoDAO.cunsultaCantidad(tablaAlumnosConsultasDos, Integer.parseInt(productoSeleccionado.getSelectedItem().toString().substring(0,1)));
                        break;
                    case 3: mProductoDAO.cunsultaTalla(tablaAlumnosConsultasDos, productoSeleccionado.getSelectedItem().toString());

                }


            }
        });
        tablaAlumnosConsultasDos.addMouseListener(new MouseListener() {//PENDIENTE=============================== PENDIENTE
            @Override
            public void mouseClicked(MouseEvent e) {

                articulo.setText("Seleccione un articulo");
                caracPrincipal.setText(caracPrincipal.getText().substring(0,26));
                talla.setText(talla.getText().substring(0,7));
                cantidad.setText(cantidad.getText().substring(0, 20));
                precio.setText(precio.getText().substring(0, 19));
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Seleccione una opcion");

                cadena_idProducto = tablaAlumnosConsultasDos.getValueAt(tablaAlumnosConsultasDos.getSelectedRow(), 0).toString();
                articulo.setText(tablaAlumnosConsultasDos.getValueAt(tablaAlumnosConsultasDos.getSelectedRow(), 2).toString());
                caracPrincipal.setText(caracPrincipal.getText() + tablaAlumnosConsultasDos.getValueAt(tablaAlumnosConsultasDos.getSelectedRow(), 1).toString());
                talla.setText(talla.getText() + tablaAlumnosConsultasDos.getValueAt(tablaAlumnosConsultasDos.getSelectedRow(), 3).toString());
                cantidad.setText(cantidad.getText() + tablaAlumnosConsultasDos.getValueAt(tablaAlumnosConsultasDos.getSelectedRow(), 4).toString());
                precio.setText(precio.getText() + tablaAlumnosConsultasDos.getValueAt(tablaAlumnosConsultasDos.getSelectedRow(), 5).toString());
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
                cantidad.setText(cantidad.getText().substring(0, 20));
                precio.setText(precio.getText().substring(0, 19));
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Seleccione una opcion");
                mProductoDAO.limpiarTabla(tablaAlumnosConsultasDos);
                mProductoDAO.cunsultaCompleta(tablaAlumnosConsultasDos);
            }
        });
        vender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mProductoDAO.eliminar(cadena_idProducto);
                mProductoDAO.limpiarTabla(tablaAlumnosConsultasDos);
                mProductoDAO.cunsultaCompleta(tablaAlumnosConsultasDos);

                articulo.setText("Seleccione un articulo");
                caracPrincipal.setText(caracPrincipal.getText().substring(0,26));
                talla.setText(talla.getText().substring(0,7));
                cantidad.setText(cantidad.getText().substring(0, 21));
                precio.setText(precio.getText().substring(0, 19));
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Seleccione una opcion");
            }
        });

        mProductoDAO.cunsultaCompleta(tablaAlumnosConsultasDos);


        return pEliminar;
    }
}
