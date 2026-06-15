package agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Declaramos el scanner
        Scanner sc = new Scanner(System.in);
        //Pedimos al usuario el tamaño de la agenda
        System.out.print("Ingrese el tamaño de la agenda (0 = por defecto): ");
        int tamano = sc.nextInt();
        sc.nextLine();
        Agenda agenda;
        if (tamano > 0) {
            agenda = new Agenda(tamano);
        } else {
            agenda = new Agenda();
        }

        int opcion;

 //Se creo el menú de inicio
        do {
            System.out.println("\n--- AGENDA ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Espacios libres");
            System.out.println("6. Verificar agenda llena");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
//Pedir datos de contacto
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    agenda.anadirContacto(
                            new Contacto(
                                    nombre,
                                    apellido,
                                    telefono
                            )
                    );
                    break;
                case 2: //Buscar usuario
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    agenda.buscaContacto(
                            nombre,
                            apellido
                    );
                    break;
                case 3: //Borrar usuario
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    agenda.eliminarContacto(
                            new Contacto(
                                    nombre,
                                    apellido,
                                    ""
                            )
                    );
                    break;

