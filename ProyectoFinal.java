import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoFinal {

    public static final byte TIPO_DOCUMENTO_IDENTIFICACION = 0;
    public static final byte DOCUMENTO_IDENTIFICACION = 1;
    public static final byte NOMBRES = 2;
    public static final byte APELLIDOS = 3;
    public static final byte CORREO_ELECTRONICO = 4;
    public static final byte DIRECCION_RESIDENCIA = 5;
    public static final byte CIUDAD_RESIDENCIA = 6;
    public static final byte TELEFONO_CONTACTO = 7;
    public static final byte CONTRASENA = 8;
    public static final byte CONFIRMAR_CONTRASENA = 9;

    public static List<String[]> usuarios = new ArrayList<>();

    public static Scanner leerDatoTeclado = new Scanner(System.in);

    public static void mostrarMenuLoginRegistro() {
        System.out.println("Bienvenido a MyHotel ...");
        System.out.println("Mas que un lugar para descansar.");
        System.out.println("----------------------------------------------");
        System.out.println("Ingrese la opcion deseada.");
        System.out.println("1. Registrarse como cliente.");
        System.out.println("2. Iniciar Sesion.");
        System.out.println("3. Salir");

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

        String[] usuario = new String[10];
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
        System.out.println("Usuario registrado exitosamente.");
    }

    public static void solicitarDatosDeRegistro() {
        System.out.println("Tipo de identificación:");
        String tipoIdentificacion = leerDatoTeclado.nextLine();
    
        System.out.println("Documento de identificación:");
        String documentoIdentificacion = leerDatoTeclado.nextLine();
    
        System.out.println("Nombres:");
        String nombres = leerDatoTeclado.nextLine();
    
        System.out.println("Apellidos:");
        String apellidos = leerDatoTeclado.nextLine();
    
        System.out.println("Correo electrónico:");
        String correoElectronico = leerDatoTeclado.nextLine();
    
        System.out.println("Dirección de residencia:");
        String direccionResidencia = leerDatoTeclado.nextLine();
    
        System.out.println("Ciudad de residencia:");
        String ciudadResidencia = leerDatoTeclado.nextLine();
    
        System.out.println("Teléfono de contacto:");
        String telefonoContacto = leerDatoTeclado.nextLine();
    
        String contrasena;
        String confirmarContrasena;
        do {
            System.out.println("Contraseña:");
            contrasena = leerDatoTeclado.nextLine();
    
            System.out.println("Confirmar Contraseña:");
            confirmarContrasena = leerDatoTeclado.nextLine();
    
            if (!contrasena.equals(confirmarContrasena)) {
                System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
            }
        } while (!contrasena.equals(confirmarContrasena));
    
        registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico,
                direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
    }
    
    public static boolean iniciarSesion() {
        System.out.println("Ingrese su correo electrónico:");
        String correoElectronico = leerDatoTeclado.next();

        System.out.println("Ingrese su contraseña:");
        String contrasena = leerDatoTeclado.next();

        int intentos = 0;
        while (intentos < 3) {
            for (String[] usuario : usuarios) {
                if (usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
                    System.out.println("Usuario logueado correctamente.");
                    return true;
                }
            }
            System.out.println("Usuario incorrecto, intente una vez más.");
            intentos++;
            if (intentos < 3) {
                System.out.println("Ingrese su correo electrónico:");
                correoElectronico = leerDatoTeclado.next();

                System.out.println("Ingrese su contraseña:");
                contrasena = leerDatoTeclado.next();
            }
        }

        if (intentos == 3) {
            System.out.println("Número máximo de intentos alcanzado. Saliendo...");
            salir();
        }

        return false;
    }

    public static void salir() {
        System.out.println("¡Hasta pronto!");
        System.exit(0); // Sale del programa
    }

    public static void main(String[] args) {
        while (true) {
            mostrarMenuLoginRegistro();
        }
    }
}
