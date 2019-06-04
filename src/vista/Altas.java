package vista;

import controlador.ProductoDAO;
import modelo.ProductoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.MessageDigest;

public class Altas {

    ProductoDAO mProductoDAO = new ProductoDAO();

    public JPanel alta(){

        JPanel alta = new JPanel(null);

        Color fondo = new Color(0x214E7F);
        Color letrasClaras = new Color(250,250,250);
        Color fondoComponentes = new Color(0x71CEFA);

        alta.setBackground(fondo);
        alta.setBounds(0, 0, 540, 800);

        //Componentes ==================================================================================================
        JLabel carcPrincipal = new JLabel("Caracteristica Principal.-");
        JLabel nomProducto = new JLabel("Nombre Producto.-");
        JLabel talla = new JLabel("Talla");
        JLabel cantidad = new JLabel("Cantidad del Producto");
        JLabel precio = new JLabel("Precio por unidad");
        JTextField nombreProducto = new JTextField();
        JTextField precioXUnidad = new JTextField();
        JComboBox<String> comboCaracteristica = new JComboBox<String>();
        JComboBox<String> comboTalla = new JComboBox<String>();
        JComboBox<Integer> comboCantidadArticulo = new JComboBox<Integer>();
        JButton agregar = new JButton("Agregar");

        JButton restablecer = new JButton("Restablecer");

        //Configuracion ================================================================================================
        Font grande = new Font("ARIAL", Font.BOLD, 50);
        Font mediana = new Font("ARIAL", Font.BOLD, 40);
        Font texto = new Font("ARIAL", Font.BOLD, 20);
        carcPrincipal.setFont(mediana);
        carcPrincipal.setForeground(letrasClaras);
        carcPrincipal.setBackground(fondoComponentes);
        nomProducto.setFont(mediana);
        nomProducto.setForeground(letrasClaras);
        nomProducto.setBackground(fondoComponentes);
        talla.setFont(mediana);
        talla.setForeground(letrasClaras);
        talla.setBackground(fondoComponentes);
        cantidad.setFont(mediana);
        cantidad.setForeground(letrasClaras);
        cantidad.setBackground(fondoComponentes);
        precio.setFont(mediana);
        precio.setForeground(letrasClaras);
        precio.setBackground(fondoComponentes);
        nombreProducto.setFont(texto);
        nombreProducto.setForeground(letrasClaras);
        nombreProducto.setBackground(fondoComponentes);
        comboCantidadArticulo.setFont(texto);
        comboCantidadArticulo.setForeground(letrasClaras);
        comboCantidadArticulo.setBackground(fondoComponentes);
        precioXUnidad.setFont(texto);
        precioXUnidad.setForeground(letrasClaras);
        precioXUnidad.setBackground(fondoComponentes);
        comboCaracteristica.setFont(texto);
        comboCaracteristica.setForeground(letrasClaras);
        comboCaracteristica.setBackground(fondoComponentes);
        comboTalla.setFont(texto);
        comboTalla.setForeground(letrasClaras);
        comboTalla.setBackground(fondoComponentes);
        agregar.setFont(grande);
        agregar.setForeground(letrasClaras);
        agregar.setBackground(fondoComponentes);
        restablecer.setFont(grande);
        restablecer.setForeground(letrasClaras);
        restablecer.setBackground(fondoComponentes);

        //Tipos de datos ===============================================================================================
        comboCaracteristica.addItem("CAMISA");
        comboCaracteristica.addItem("MOÑO");
        comboCaracteristica.addItem("VESTIDO");

        comboTalla.addItem("INTANTIL");
        comboTalla.addItem("CHICA");
        comboTalla.addItem("MEDIANA");
        comboTalla.addItem("GRANDE");
        comboTalla.addItem("EXTRA GRANDE");

        for (int i = 1; i <= 100; i++){
            comboCantidadArticulo.addItem(i);
        }



        //ubicacion ====================================================================================================
        carcPrincipal.setBounds(30,30,700, 50);
        comboCaracteristica.setBounds(30,90,470, 30);
        nomProducto.setBounds(30,130,700, 50);
        nombreProducto.setBounds(30,180,470, 30);
        talla.setBounds(30,220,700, 50);
        comboTalla.setBounds(30,280,470, 30);
        cantidad.setBounds(30,320,500, 50);
        comboCantidadArticulo.setBounds(30,380,200, 30);
        precio.setBounds(30,420,400, 50);
        precioXUnidad.setBounds(30,480,470, 30);
        agregar.setBounds(30,570,470, 80);
        restablecer.setBounds(30,680,470, 70);

        //agregar ======================================================================================================
        alta.add(carcPrincipal);
        alta.add(nomProducto);
        alta.add(talla);
        alta.add(cantidad);
        alta.add(precio);
        alta.add(nombreProducto);
        alta.add(comboCantidadArticulo);
        alta.add(precioXUnidad);
        alta.add(comboCaracteristica);
        alta.add(comboTalla);
        alta.add(agregar);
        alta.add(restablecer);

        alta.setVisible(true);

        //ACCIONES =====================================================================================================
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProductoFinal mProductoFinal;

                if (validar(comboCaracteristica, nombreProducto, comboTalla, comboCantidadArticulo, precioXUnidad) == true){

                    String caracteristica = (String) comboCaracteristica.getSelectedItem(), nombre = nombreProducto.getText().toUpperCase(),
                    talla = (String) comboTalla.getSelectedItem();
                    int cantidad = (int) comboCantidadArticulo.getSelectedItem();
                    double precio = Double.parseDouble(precioXUnidad.getText());
                    //Calculo de ID
                    String idProducto = caracteristica.substring(0, 2)+talla.substring(0, 2)+nombre.substring(0, 2);

                    mProductoFinal = new ProductoFinal(idProducto, caracteristica, nombre, talla, cantidad, precio);

                    if (mProductoDAO.incertar(mProductoFinal) == true){
                        limpiar(comboCaracteristica, nombreProducto, comboTalla, comboCantidadArticulo, precioXUnidad);
                        JOptionPane.showMessageDialog(alta, "Se agrego el prodcto al inventario.");
                    }else {
                        JOptionPane.showMessageDialog(null, "Ups... Hubo un error");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Complete los datos faltantes, marcados en rojo.");
                }

            }
        });
        restablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar(comboCaracteristica, nombreProducto, comboTalla, comboCantidadArticulo, precioXUnidad);
            }
        });
        nombreProducto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Character s = e.getKeyChar();
                if (!Character.isLetter(s) && s != KeyEvent.VK_SPACE){
                    //e.consume();
                    nombreProducto.setText(nombreProducto.getText().substring(0, (nombreProducto.getText().length()-1)));
                }
            }
        });
        precioXUnidad.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Double.parseDouble(precioXUnidad.getText());
                } catch (NumberFormatException ex) {
                    precioXUnidad.setText(""+precioXUnidad.getText().substring(0,(precioXUnidad.getText().length()-1)));
                }
            }
        });


        return alta;
    }

    public boolean validar(JComboBox<String> comboCaracteristica, JTextField nombreProducto, JComboBox<String> comboTalla, JComboBox<Integer> cantidad, JTextField precioXUnidad){
            boolean valido = true;

            Color fondoComponentes = new Color(0x71CEFA);
            comboCaracteristica.setBackground(fondoComponentes);
            nombreProducto.setBackground(fondoComponentes);
            comboTalla.setBackground(fondoComponentes);
            cantidad.setBackground(fondoComponentes);
            precioXUnidad.setBackground(fondoComponentes);

            if (comboCaracteristica.getSelectedItem().toString().equalsIgnoreCase("")){
                valido = false;
                comboCaracteristica.setBackground(Color.RED);
            }
            if (nombreProducto.getText().equalsIgnoreCase("")){
                valido = false;
                nombreProducto.setBackground(Color.RED);
            }
            if (comboTalla.getSelectedItem().toString().equalsIgnoreCase("")){
                valido = false;
                comboTalla.setBackground(Color.RED);
            }
            if ( (int) cantidad.getSelectedItem() <= 0){
                valido = false;
                cantidad.setBackground(Color.RED);
            }
            if (precioXUnidad.getText().equalsIgnoreCase("")){
                valido = false;
                precioXUnidad.setBackground(Color.RED);
            }
            return valido;
        }
        public void limpiar(JComboBox<String> comboCaracteristica, JTextField nombreProducto, JComboBox<String> comboTalla, JComboBox<Integer> cantidad, JTextField precioXUnidad){

            Color fondoComponentes = new Color(0x71CEFA);
            comboCaracteristica.setBackground(fondoComponentes);
            nombreProducto.setBackground(fondoComponentes);
            comboTalla.setBackground(fondoComponentes);
            cantidad.setBackground(fondoComponentes);
            precioXUnidad.setBackground(fondoComponentes);

            comboCaracteristica.setSelectedIndex(0);
            nombreProducto.setText("");
            comboTalla.setSelectedIndex(0);
            cantidad.setSelectedIndex(0);
            precioXUnidad.setText("");

        }
}
