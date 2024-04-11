import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginGUI extends JFrame implements ActionListener {

    private JTextField correoTextField;
    private JPasswordField contrasenaPasswordField;

    private List<Usuario> usuariosRegistrados;

    public LoginGUI() {
        setTitle("Login - MyHotel");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializamos la lista de usuarios registrados
        usuariosRegistrados = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel correoLabel = new JLabel("Correo electrónico:");
        correoTextField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaPasswordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JButton registrarButton = new JButton("Registrar usuario");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroGUI(usuariosRegistrados);
            }
        });

        panel.add(correoLabel);
        panel.add(correoTextField);
        panel.add(contrasenaLabel);
        panel.add(contrasenaPasswordField);
        panel.add(registrarButton);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String correo = correoTextField.getText();
        String contrasena = new String(contrasenaPasswordField.getPassword());

        boolean loginCorrecto = false;
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                loginCorrecto = true;
                break;
            }
        }

        if (loginCorrecto) {
            JOptionPane.showMessageDialog(this, "Bienvenido a MyHotel");
        } else {
            JOptionPane.showMessageDialog(this, "Error: Credenciales incorrectas");
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}

class RegistroGUI extends JFrame implements ActionListener {

    private JTextField tipoIdentificacionTextField, documentoIdentificacionTextField, nombresTextField, apellidosTextField,
            correoElectronicoTextField, direccionResidenciaTextField, ciudadResidenciaTextField, telefonoContactoTextField;
    private JPasswordField contrasenaPasswordField, confirmarContrasenaPasswordField;

    private List<Usuario> usuariosRegistrados;

    public RegistroGUI(List<Usuario> usuariosRegistrados) {
        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        this.usuariosRegistrados = usuariosRegistrados;

        JPanel panel = new JPanel(new GridLayout(0, 2));
        JLabel tipoIdentificacionLabel = new JLabel("Tipo de identificación:");
        tipoIdentificacionTextField = new JTextField();
        JLabel documentoIdentificacionLabel = new JLabel("Documento de identificación:");
        documentoIdentificacionTextField = new JTextField();
        JLabel nombresLabel = new JLabel("Nombres:");
        nombresTextField = new JTextField();
        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosTextField = new JTextField();
        JLabel correoElectronicoLabel = new JLabel("Correo electrónico:");
        correoElectronicoTextField = new JTextField();
        JLabel direccionResidenciaLabel = new JLabel("Dirección de residencia:");
        direccionResidenciaTextField = new JTextField();
        JLabel ciudadResidenciaLabel = new JLabel("Ciudad de residencia:");
        ciudadResidenciaTextField = new JTextField();
        JLabel telefonoContactoLabel = new JLabel("Teléfono de contacto:");
        telefonoContactoTextField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaPasswordField = new JPasswordField();
        JLabel confirmarContrasenaLabel = new JLabel("Confirmar Contraseña:");
        confirmarContrasenaPasswordField = new JPasswordField();
        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(this);

        panel.add(tipoIdentificacionLabel);
        panel.add(tipoIdentificacionTextField);
        panel.add(documentoIdentificacionLabel);
        panel.add(documentoIdentificacionTextField);
        panel.add(nombresLabel);
        panel.add(nombresTextField);
        panel.add(apellidosLabel);
        panel.add(apellidosTextField);
        panel.add(correoElectronicoLabel);
        panel.add(correoElectronicoTextField);
        panel.add(direccionResidenciaLabel);
        panel.add(direccionResidenciaTextField);
        panel.add(ciudadResidenciaLabel);
        panel.add(ciudadResidenciaTextField);
        panel.add(telefonoContactoLabel);
        panel.add(telefonoContactoTextField);
        panel.add(contrasenaLabel);
        panel.add(contrasenaPasswordField);
        panel.add(confirmarContrasenaLabel);
        panel.add(confirmarContrasenaPasswordField);
        panel.add(new JLabel());
        panel.add(registrarButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Validar los datos ingresados y registrar al usuario en la lista de usuariosRegistrados
        String tipoIdentificacion = tipoIdentificacionTextField.getText();
        String documentoIdentificacion = documentoIdentificacionTextField.getText();
        String nombres = nombresTextField.getText();
        String apellidos = apellidosTextField.getText();
        String correoElectronico = correoElectronicoTextField.getText();
        String direccionResidencia = direccionResidenciaTextField.getText();
        String ciudadResidencia = ciudadResidenciaTextField.getText();
        String telefonoContacto = telefonoContactoTextField.getText();
        String contrasena = new String(contrasenaPasswordField.getPassword());
        String confirmarContrasena = new String(confirmarContrasenaPasswordField.getPassword());

        if (tipoIdentificacion.isEmpty() || documentoIdentificacion.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()
                || correoElectronico.isEmpty() || direccionResidencia.isEmpty() || ciudadResidencia.isEmpty()
                || telefonoContacto.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        } else if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Intente de nuevo.");
        } else {
            // Crear un nuevo usuario y agregarlo a la lista de usuarios registrados
            Usuario nuevoUsuario = new Usuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos,
                    correoElectronico, direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
            usuariosRegistrados.add(nuevoUsuario);
            JOptionPane.showMessageDialog(this, "Usuario registrado satisfactoriamente");
            dispose(); // Cerrar la ventana de registro
        }
    }
}

class Usuario {
    private String tipoIdentificacion;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccionResidencia;
    private String ciudadResidencia;
    private String telefonoContacto;
    private String contrasena;

    public Usuario(String tipoIdentificacion, String documentoIdentificacion, String nombres, String apellidos,
                   String correo, String direccionResidencia, String ciudadResidencia, String telefonoContacto,
                   String contrasena) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.documentoIdentificacion = documentoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccionResidencia = direccionResidencia;
        this.ciudadResidencia = ciudadResidencia;
        this.telefonoContacto = telefonoContacto;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}
