package vista;

//import com.sun.deploy.panel.JreTableModel;
import conexionBD.ConexionMyAQL;
import controlador.ProductoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.AbstractTableModel;

public class pantallaABCC extends JFrame {

    public Image imagenFondo;
    public URL fondo;
    JTable tablaAlumnosConsultas;
    String usuarioEntrada;
    int selecionado;

    //Instancias de clases == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
    Ventas mVentas = new Ventas();
    Altas mAltas = new Altas();
    Modificaciones mModificaciones= new Modificaciones();
    ProductoDAO mProductoDAO = new ProductoDAO();

    //Internal Frame
    JInternalFrame ventaUnica;//Ventas
    JInternalFrame altaUnica;//altas
    JInternalFrame modificaciones;//Modificacion Inventario
    JInternalFrame eliminar;//Modificacion Eliminacion

    String[] valoresTabla = {"ID Producto", "Tipo", "Nombre", "Talla", "Cantidad", "Precio"};


    public pantallaABCC(String usuarioEntrada){
        this.usuarioEntrada = usuarioEntrada;


        this.setTitle("Iniciar Secion");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        fondo = this.getClass().getResource("/vista/ABCC_1.jpg");
        imagenFondo = new ImageIcon(fondo).getImage();
        this.setBounds(0, 0, imagenFondo.getWidth(null), imagenFondo.getHeight(null));
        this.setResizable(false);

        Container contenedor = getContentPane();
        contenedor.add(panel);

        //Internal Frams
        //============================================================================================================== Inicio ===================
        //============================================================================================================== Venta =========== Unica
        ventaUnica = new JInternalFrame();
        ventaUnica.setTitle("VENTA");
        ventaUnica.setLayout(null);
        ventaUnica.setDefaultCloseOperation(HIDE_ON_CLOSE);
        ventaUnica.setSize(1100, 800);
        ventaUnica.setResizable(false);
        ventaUnica.setVisible(false);
        ventaUnica.setClosable(true);
        ventaUnica.setIconifiable(false);
        ventaUnica.setMaximizable(false);
        ventaUnica.setBackground(Color.black);

        ventaUnica.add(mVentas.ventaUnica());//recive el panel
        panel.add(ventaUnica);

        //============================================================================================================== Altas =========== Unica
        altaUnica = new JInternalFrame();
        altaUnica.setTitle("ALTA");
        altaUnica.setLayout(null);
        altaUnica.setDefaultCloseOperation(HIDE_ON_CLOSE);
        altaUnica.setSize(540, 800);
        altaUnica.setResizable(false);
        altaUnica.setVisible(false);
        altaUnica.setClosable(true);
        altaUnica.setIconifiable(false);
        altaUnica.setMaximizable(false);
        altaUnica.setBackground(Color.black);

        altaUnica.add(mAltas.alta());//recive el panel
        panel.add(altaUnica);

        //============================================================================================================== Modificaciones ==========
        //============================================================================================================== Modificar Productos
        modificaciones = new JInternalFrame();
        modificaciones.setTitle("MODIFICACION");
        modificaciones.setLayout(null);
        modificaciones.setDefaultCloseOperation(HIDE_ON_CLOSE);
        modificaciones.setSize(1100, 800);
        modificaciones.setResizable(false);
        modificaciones.setVisible(false);
        modificaciones.setClosable(true);
        modificaciones.setIconifiable(false);
        modificaciones.setMaximizable(false);
        modificaciones.setBackground(Color.black);

        modificaciones.add(mModificaciones.modifiacciones());//recive el panel
        panel.add(modificaciones);

        //============================================================================================================== Modificacion Eliminacion
        eliminar = new JInternalFrame();
        eliminar.setTitle("Eliminar Producto");
        eliminar.setLayout(null);
        eliminar.setDefaultCloseOperation(HIDE_ON_CLOSE);
        eliminar.setSize(1100, 800);
        eliminar.setResizable(false);
        eliminar.setVisible(false);
        eliminar.setClosable(true);
        eliminar.setIconifiable(false);
        eliminar.setMaximizable(false);
        eliminar.setBackground(Color.black);

        eliminar.add(mModificaciones.eliminaciones());
        panel.add(eliminar);

        //============================================================================================================== Fin =====================

        // ====================================== Componentes...
        //Componentes INICIO ===========================================================================================

        JMenuBar menu1 = new JMenuBar();
            //=================================== ALTAS ===================================
            JMenu menuAltas = new JMenu("Altas");

                JMenuItem porIndividual = new JMenuItem("Alta");
                porIndividual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));

                menuAltas.add(porIndividual);

                porIndividual.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        altaUnica.setVisible(true);
                    }
                });

            menu1.add(menuAltas);
            //=================================== BAJAS ===================================
            JMenu menuBajas = new JMenu("Ventas");

                JMenuItem ventaProducto = new JMenuItem("Venta");
                ventaProducto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.ALT_MASK));

                menuBajas.add(ventaProducto);

                ventaProducto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventaUnica.setVisible(true);
                    }
                });

            menu1.add(menuBajas);
            //=================================== MODIFICACIONES ===================================
            JMenu menuModificaciones = new JMenu("Modificaciones");

                JMenuItem modificacionCamisa = new JMenuItem("Modificar Inventario");
                JMenuItem modificacionEliminacion = new JMenuItem("EliminarProducto");

                modificacionCamisa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
                modificacionEliminacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

                menuModificaciones.add(modificacionCamisa);
                menuModificaciones.add(modificacionEliminacion);

                modificacionCamisa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        modificaciones.setVisible(true);
                    }
                });
                modificacionEliminacion.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eliminar.setVisible(true);
                    }
                });

            menu1.add(menuModificaciones);
            //======================================================================================
        setJMenuBar(menu1);

        //Tabla ==============================================================================================================================================================
        JPanel tabla = new JPanel();
        tabla.setVisible(true);
        tabla.setLayout(null);
        tabla.setSize(1000, 800);
        tabla.setBounds(30, 130, 1000, 800);
        tablaAlumnosConsultas = new JTable();
        tablaAlumnosConsultas.setBounds(0, 0, 1000, 800);
        tablaAlumnosConsultas.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String []{"ID Producto", "Tipo", "Nombre", "Talla", "Cantidad", "Precio"}));
        //tablaAlumnosConsultas.setSelectionForeground(Color.white);
        //tablaAlumnosConsultas.setGridColor(new Color(0x214E7F));
        //tablaAlumnosConsultas.setBackground(new Color(0x214E7F));
        //tablaAlumnosConsultas.setSelectionBackground(new Color(0x3888D9));
        //tabla.setBackground(new Color(0x214E7F));
        JScrollPane scrolltable = new JScrollPane();
        scrolltable.setViewportView(tablaAlumnosConsultas);
        scrolltable.setSize(1000, 800);
        tabla.add(scrolltable);

        JButton refrescar = new JButton("Refrescar");
        refrescar.setFont(new Font("arial", Font.ITALIC, 20));
        refrescar.setForeground(new Color(250,250,250));
        refrescar.setBackground(new Color(0x214E7F));
        refrescar.setBounds(1050, 500 , 600, 50);
        panel.add(refrescar);

        panel.add(panelFiltro());
        panel.add(tabla);
        //Componentes FIN ==============================================================================================

        JLabel usuario = new JLabel("USUARIO: "+ usuarioEntrada.toUpperCase());
        usuario.setFont(new Font("arial", Font.ITALIC, 30));
        usuario.setBounds(1250, 30, 700, 70);
        usuario.setForeground(Color.white);
        panel.add(usuario);

        JLabel empresa = new JLabel("Punto De Venta");
        empresa.setFont(new Font("arial", Font.ITALIC, 30));
        empresa.setBounds(30, 30, 700, 70);
        empresa.setForeground(Color.white);
        panel.add(empresa);

        mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);

        this.setVisible(true);

        //Acciones
        tablaAlumnosConsultas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
        refrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mProductoDAO.limpiarTabla(tablaAlumnosConsultas);
                mProductoDAO.cunsultaCompleta(tablaAlumnosConsultas);
            }
        });


    }

    public JPanel panel = new JPanel(null){
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    };


    public JPanel panelFiltro(){
        JPanel filtro = new JPanel(null);

        filtro.setSize(600, 330);
        filtro.setBounds(1050, 130 , 600, 330);
        filtro.setBackground(new Color(0x214E7F));

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


        //Ubicacion
        titulo.setBounds(30, 30, 300, 50);
        xTipo.setBounds(40, 100, 130, 30);
        xCantidad.setBounds(220, 100, 130, 30);
        xTalla.setBounds(400, 100, 130, 30);
        tipoProducto.setBounds(30, 150, 400, 60);
        productoSeleccionado.setBounds(30, 220, 530, 30);
        filtrar.setBounds(30, 260, 530, 30);

        //Agregar
        filtro.add(titulo);
        filtro.add(xTipo);
        filtro.add(xCantidad);
        filtro.add(xTalla);
        filtro.add(tipoProducto);
        filtro.add(productoSeleccionado);
        filtro.add(filtrar);



        //Acciones
        xTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Camisa");
                productoSeleccionado.addItem("Moño");
                productoSeleccionado.addItem("Vestido");
                selecionado = 1;
            }
        });
        xCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("2 o más");
                productoSeleccionado.addItem("4 o más");
                productoSeleccionado.addItem("6 o más");
                selecionado = 2;
            }
        });
        xTalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoSeleccionado.removeAllItems();
                productoSeleccionado.addItem("Infantil".toUpperCase());
                productoSeleccionado.addItem("Chica".toUpperCase());
                productoSeleccionado.addItem("mediana".toUpperCase());
                productoSeleccionado.addItem("Grande".toUpperCase());
                productoSeleccionado.addItem("Extra Grande".toUpperCase());
                selecionado = 3;
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


        return filtro;
    }

}


