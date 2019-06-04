package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.security.Key;

public class Login extends JFrame {

    public Image imagenFondo;
    public URL fondo;

    final String usuarioTXT = "vendedor";
    final String contrasenaTXT = "vendedor";

    public String getUsuarioTXT() {
        return usuarioTXT;
    }

    public Login (){


        this.setTitle("Iniciar Sesion");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        fondo = this.getClass().getResource("/vista/login_V2.jpg");
        imagenFondo = new ImageIcon(fondo).getImage();
        this.setBounds(0, 0, imagenFondo.getWidth(null), imagenFondo.getHeight(null));
        this.setResizable(false);

        Container contenedor = getContentPane();
        contenedor.add(panel);

        JTextField usuario = new JTextField(10);
        usuario.setToolTipText("identifacadir de trabajador.");
        usuario.setBounds(32, 338+6, 360+10, 43);
        usuario.setFont(new Font("arial", Font.ITALIC, 25));
        usuario.setBackground(new Color(143, 197, 255));
        panel.add(usuario);

        JPasswordField contrasena = new JPasswordField();
        contrasena.setBounds(32, 408+8, 360+10, 43);
        contrasena.setFont(new Font("arial", Font.ITALIC, 25));
        contrasena.setBackground(new Color(143, 197, 255));

        panel.add(contrasena);

        JButton iniciarSecion = new JButton("Iniciar Secion");
        iniciarSecion.setBounds(39, 488+8, 345+10, 40);
        iniciarSecion.setBackground(new Color(241, 54, 7));
        iniciarSecion.setBorderPainted(false);
        panel.add(iniciarSecion);

        this.setVisible(true);


        //================================ Acciones ===============================================
        iniciarSecion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrir(usuario, contrasena);
            }
        });
        usuario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //sin accion
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER){
                        abrir(usuario, contrasena);
                    }else {
                        //sin accion
                    }
                }catch (Exception ex){

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //sin accion
            }
        });
        contrasena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //sin accion
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER){
                        abrir(usuario, contrasena);
                    }else {
                        //sin accion
                    }
                }catch (Exception ex){
                    //sin accion
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void abrir(JTextField usuario, JPasswordField contrasena){
        if (usuario.getText().equals("") || new String(contrasena.getPassword()).equals("")){
            if (usuario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Introdusca el usuario", "Incompleto", JOptionPane.INFORMATION_MESSAGE);
            }
            if (new String(contrasena.getPassword()).equals("")){
                JOptionPane.showMessageDialog(null, "Introdusca la contrasena", "Incompleto", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            String user = usuario.getText();
            String pasword = new String(contrasena.getPassword());
            if (user.equals(usuarioTXT) && pasword.equals(contrasenaTXT)){
                //LLamar el otro panel...
                pantallaABCC siguientePantalla = new pantallaABCC(usuarioTXT);
                siguientePantalla.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o contrasena Incorrectos", "Fallo",JOptionPane.ERROR_MESSAGE);
                contrasena.setText("");
            }
        }
    }



    public JPanel panel = new JPanel(null){
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    };
}
