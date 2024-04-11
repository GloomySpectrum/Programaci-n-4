import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginGUI extends JFrame implements ActionListener {

    private JTextField correoTextField;
    private JPasswordField contrasenaPasswordField;

    private List<String[]> usuarios = new ArrayList<>();

    public LoginGUI() {
        setTitle("Login - MyHotel");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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
                new RegistroGUI();
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

        // Simulación de datos de usuario
        usuarios.add(new String[]{"correo1@example.com", "contrasena1"});
        usuarios.add(new String[]{"correo2@example.com", "contrasena2"});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String correo = correoTextField.getText();
        String contrasena = new String(contrasenaPasswordField.getPassword());

        boolean loginCorrecto = false;
        for (String[] usuario : usuarios) {
            if (usuario[0].equals(correo) && usuario[1].equals(contrasena)) {
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

    public RegistroGUI() {
        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

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
        } else {
            // Realizar el registro del usuario aquí
            JOptionPane.showMessageDialog(this, "Usuario registrado satisfactoriamente");
            dispose(); // Cerrar la ventana de registro
        }
    }
}
