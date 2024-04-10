import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parcial_1 {
    public static final byte TIPO_DOCUMENTO_IDENTIFICACION = 0;
    public static final byte DOCUMENTO_IDENTIFICACION = 1;
    public static final byte NOMBRES = 2;
    public static final byte APELLIDOS = 3;
    public static final byte CORREO_ELECTRONICO = 4;
    public static final byte DIRECCION_RESIDENCIA = 5;
    public static final byte CIUDAD_RESIDENCIA = 6;
    public static final byte TELEFONO_CONTACTO = 7;
    public static final byte CONTRASENA = 8;

    public static List<String[]> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }

    public static void mostrarMenuLoginRegistro() {
        System.out.println("Bienvenido a MyHotel ...");
        System.out.println("Mas que un lugar para descansar.");
        System.out.println("----------------------------------------------");
        System.out.println("Ingrese la opcion deseada.");
        System.out.println("1. Registrarse como cliente.");
        System.out.println("2. Iniciar Sesion.");
        System.out.println("3. Salir");

        Scanner leerDatoTeclado = new Scanner(System.in);
        int opcion = leerDatoTeclado.nextInt();
        leerDatoTeclado.nextLine();
        switch (opcion) {
            case 1:
                solicitarDatosDeRegistro();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                salir();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void registrarUsuario(String tipoDocumentoIdentificacion, String documentoIdentificacion, String nombres,
                                         String apellidos, String correoElectronico, String direccionResidencia,
                                         String ciudadResidencia, String telefonoContacto, String contrasena) {

        String[] usuario = new String[9];
        usuario[TIPO_DOCUMENTO_IDENTIFICACION] = tipoDocumentoIdentificacion;
        usuario[DOCUMENTO_IDENTIFICACION] = documentoIdentificacion;
        usuario[NOMBRES] = nombres;
        usuario[APELLIDOS] = apellidos;
        usuario[CORREO_ELECTRONICO] = correoElectronico;
        usuario[DIRECCION_RESIDENCIA] = direccionResidencia;
        usuario[CIUDAD_RESIDENCIA] = ciudadResidencia;
        usuario[TELEFONO_CONTACTO] = telefonoContacto;
        usuario[CONTRASENA] = contrasena;

        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
    }

    public static boolean iniciarSesion(String correoElectronico, String contrasena) {
        for (String[] usuario : usuarios) {
            if (usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
                System.out.println("Usuario logueado correctamente.");
                return true;
            }
        }
        System.out.println("Usuario incorrecto, intente una vez más.");
        return false;
    }

    public static void solicitarDatosDeRegistro() {
        String tipoIdentificacion = JOptionPane.showInputDialog("Ingrese tipo de identificación:");
        String documentoIdentificacion = JOptionPane.showInputDialog("Ingrese documento de identificación:");
        String nombres = JOptionPane.showInputDialog("Ingrese nombres:");
        String apellidos = JOptionPane.showInputDialog("Ingrese apellidos:");
        String correoElectronico = JOptionPane.showInputDialog("Ingrese correo electrónico:");
        String direccionResidencia = JOptionPane.showInputDialog("Ingrese dirección de residencia:");
        String ciudadResidencia = JOptionPane.showInputDialog("Ingrese ciudad de residencia:");
        String telefonoContacto = JOptionPane.showInputDialog("Ingrese teléfono de contacto:");
        String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

        registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico,
                direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
    }

    public static void salir() {
        System.exit(0);
    }
}

class RegistroUsuarioFrame extends JFrame implements ActionListener {
    private JTextField tipoIdentificacionField;
    private JTextField documentoIdentificacionField;
    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField correoElectronicoField;
    private JTextField direccionResidenciaField;
    private JTextField ciudadResidenciaField;
    private JTextField telefonoContactoField;
    private JPasswordField contrasenaField;
    private JPasswordField confirmarContrasenaField;

    public RegistroUsuarioFrame() {
        super("Registrar Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(11, 2));
        JLabel tipoIdentificacionLabel = new JLabel("Tipo de identificación:");
        tipoIdentificacionField = new JTextField();
        JLabel documentoIdentificacionLabel = new JLabel("Documento de identificación:");
        documentoIdentificacionField = new JTextField();
        JLabel nombresLabel = new JLabel("Nombres:");
        nombresField = new JTextField();
        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosField = new JTextField();
        JLabel correoElectronicoLabel = new JLabel("Correo electrónico:");
        correoElectronicoField = new JTextField();
        JLabel direccionResidenciaLabel = new JLabel("Dirección de residencia:");
        direccionResidenciaField = new JTextField();
        JLabel ciudadResidenciaLabel = new JLabel("Ciudad de residencia:");
        ciudadResidenciaField = new JTextField();
        JLabel telefonoContactoLabel = new JLabel("Teléfono de contacto:");
        telefonoContactoField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField();
        JLabel confirmarContrasenaLabel = new JLabel("Confirmar Contraseña:");
        confirmarContrasenaField = new JPasswordField();
        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(this);

        panel.add(tipoIdentificacionLabel);
        panel.add(tipoIdentificacionField);
        panel.add(documentoIdentificacionLabel);
        panel.add(documentoIdentificacionField);
        panel.add(nombresLabel);
        panel.add(nombresField);
        panel.add(apellidosLabel);
        panel.add(apellidosField);
        panel.add(correoElectronicoLabel);
        panel.add(correoElectronicoField);
        panel.add(direccionResidenciaLabel);
        panel.add(direccionResidenciaField);
        panel.add(ciudadResidenciaLabel);
        panel.add(ciudadResidenciaField);
        panel.add(telefonoContactoLabel);
        panel.add(telefonoContactoField);
        panel.add(contrasenaLabel);
        panel.add(contrasenaField);
        panel.add(confirmarContrasenaLabel);
        panel.add(confirmarContrasenaField);
        panel.add(new JLabel());
        panel.add(registrarButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoIdentificacion = tipoIdentificacionField.getText();
        String documentoIdentificacion = documentoIdentificacionField.getText();
        String nombres = nombresField.getText();
        String apellidos = apellidosField.getText();
        String correoElectronico = correoElectronicoField.getText();
        String direccionResidencia = direccionResidenciaField.getText();
        String ciudadResidencia = ciudadResidenciaField.getText();
        String telefonoContacto = telefonoContactoField.getText();
        String contrasena = new String(contrasenaField.getPassword());
        String confirmarContrasena = new String(confirmarContrasenaField.getPassword());

        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Intente de nuevo.");
            return;
        }

        Parcial_1.registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico,
                direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
        dispose(); // Cerrar la ventana de registro
    }
}

class LoginFrame extends JFrame implements ActionListener {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(this);
        JButton registerButton = new JButton("Registrarse");
        registerButton.addActionListener(e -> new RegistroUsuarioFrame());

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    String tipoIdentificacion = tipoIdentificacionField.getText();
    String documentoIdentificacion = documentoIdentificacionField.getText();
    String nombres = nombresField.getText();
    String apellidos = apellidosField.getText();
    String correoElectronico = correoElectronicoField.getText();
    String direccionResidencia = direccionResidenciaField.getText();
    String ciudadResidencia = ciudadResidenciaField.getText();
    String telefonoContacto = telefonoContactoField.getText();
    String contrasena = new String(contrasenaField.getPassword());
    String confirmarContrasena = new String(confirmarContrasenaField.getPassword());

    // Verificar que todos los campos obligatorios estén llenos
    if (tipoIdentificacion.isEmpty() || documentoIdentificacion.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()
            || correoElectronico.isEmpty() || direccionResidencia.isEmpty() || ciudadResidencia.isEmpty()
            || telefonoContacto.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        return;
    }

    // Verificar que las contraseñas coincidan
    if (!contrasena.equals(confirmarContrasena)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Intente de nuevo.");
        return;
    }

    Parcial_1.registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico,
            direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
    dispose(); // Cerrar la ventana de registro
}

}
