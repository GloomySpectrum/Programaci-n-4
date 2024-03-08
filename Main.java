import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido a MyHotel...");
        System.out.println("Mas que un lugar para descansar");
        System.out.println("-----------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Ingrese una opcion:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Mostrar usuarios registrados");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Iniciando sesión...");
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    mostrarUsuarios();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("Registrándose...");
        System.out.print("Tipo de identificación: ");
        String tipoIdentificacion = scanner.next();
        System.out.print("Documento de identificación: ");
        String documentoIdentificacion = scanner.next();
        System.out.print("Nombres: ");
        String nombres = scanner.next();
        System.out.print("Apellidos: ");
        String apellidos = scanner.next();
        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.next();
        System.out.print("Dirección de residencia: ");
        String direccionResidencia = scanner.next();
        System.out.print("Ciudad de residencia: ");
        String ciudadResidencia = scanner.next();
        System.out.print("Teléfono de contacto: ");
        String telefonoContacto = scanner.next();
        System.out.print("Contraseña: ");
        String contraseña = scanner.next();
        System.out.print("Confirmar contraseña: ");
        Usuario nuevoUsuario = new Usuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos,
                correoElectronico, direccionResidencia, ciudadResidencia, telefonoContacto, contraseña);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void mostrarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("Tipo de identificación: " + usuario.getTipoIdentificacion() + ", Documento de identificación: " + usuario.getDocumentoIdentificacion() +
                    ", Nombres: " + usuario.getNombres() + ", Apellidos: " + usuario.getApellidos() + ", Correo electrónico: " + usuario.getCorreoElectronico() +
                    ", Dirección de residencia: " + usuario.getDireccionResidencia() + ", Ciudad de residencia: " + usuario.getCiudadResidencia() +
                    ", Teléfono de contacto: " + usuario.getTelefonoContacto());
        }
    }

    private static class Usuario {
        private String tipoIdentificacion;
        private String documentoIdentificacion;
        private String nombres;
        private String apellidos;
        private String correoElectronico;
        private String direccionResidencia;
        private String ciudadResidencia;
        private String telefonoContacto;
        private String contraseña;

        public Usuario(String tipoIdentificacion, String documentoIdentificacion, String nombres, String apellidos,
                String correoElectronico, String direccionResidencia, String ciudadResidencia, String telefonoContacto,
                String contraseña) {
            this.tipoIdentificacion = tipoIdentificacion;
            this.documentoIdentificacion = documentoIdentificacion;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.correoElectronico = correoElectronico;
            this.direccionResidencia = direccionResidencia;
            this.ciudadResidencia = ciudadResidencia;
            this.telefonoContacto = telefonoContacto;
            this.contraseña = contraseña;
        }

        public String getTipoIdentificacion() {
            return tipoIdentificacion;
        }

        public String getDocumentoIdentificacion() {
            return documentoIdentificacion;
        }

        public String getNombres() {
            return nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public String getDireccionResidencia() {
            return direccionResidencia;
        }

        public String getCiudadResidencia() {
            return ciudadResidencia;
        }

        public String getTelefonoContacto() {
            return telefonoContacto;
        }

        @SuppressWarnings("unused")
        public String getContraseña() {
            return contraseña;
        }
    }
}
