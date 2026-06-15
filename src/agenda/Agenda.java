package agenda;

/**
 * Clase que representa una Agenda telefónica.
 * Gestiona una lista de contactos mediante un arreglo de tamaño fijo.
 */
public class Agenda {

    // Arreglo principal para almacenar los objetos de tipo Contacto
    private Contacto[] contactos;

    /**
     * Constructor por defecto.
     * Inicializa la agenda con un tamaño estándar de 10 espacios.
     */
    public Agenda() {
        contactos = new Contacto[10];
    }

    /**
     * Constructor personalizado.
     */
    public Agenda(int tamano) {
        contactos = new Contacto[tamano];
    }

    /**
     * Verifica si la agenda está completamente llena.
      */
    public boolean agendaLlena() {
        for (int i = 0; i < contactos.length; i++) {
            // Si encuentra al menos un espacio vacío (null), significa que no está llena
            if (contactos[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula cuántos espacios disponibles quedan en el arreglo.
     */
    public int espaciosLibres() {
        int libres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                libres++;
            }
        }
        return libres;
    }

    /**
     * Comprueba si un contacto ya existe previamente en la agenda.
    */
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < contactos.length; i++) {

            if (contactos[i] != null && contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Registra un nuevo contacto en el primer espacio disponible.
     * Valida previamente que haya espacio y que el contacto no sea un duplicado.

     */
    public void anadirContacto(Contacto c) {
        // Primera barrera: Validar capacidad
        if (agendaLlena()) {
            System.out.println("La agenda esta llena.");
            return;
        }

        // Segunda barrera: Evitar duplicados
        if (existeContacto(c)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        // Si pasa las validaciones, busca el primer hueco para guardarlo
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contactos[i] = c;
                System.out.println("Contacto agregado correctamente.");
                return; // Corta la ejecución para no agregarlo repetidas veces
            }
        }
    }

    /**
     * Muestra en la consola la lista de todos los contactos registrados.
     * Omite los espacios vacíos y notifica si la agenda no tiene registros.
     */
    public void listarContactos() {
        boolean vacia = true;

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                System.out.println(contactos[i]);
                vacia = false; // Al imprimir al menos un contacto, marcamos que no está vacía
            }
        }

        if (vacia) {
            System.out.println("La agenda esta vacia.");
        }
    }

    /**
     * Busca un contacto específico por nombre y apellido e imprime su teléfono.

     */
    public void buscaContacto(String nombre, String apellido) {
        for (int i = 0; i < contactos.length; i++) {
            // Se utiliza equalsIgnoreCase para que la búsqueda no falle
            // si el usuario mezcla mayúsculas y minúsculas
            if (contactos[i] != null &&
                    contactos[i].getNombre().equalsIgnoreCase(nombre) &&
                    contactos[i].getApellido().equalsIgnoreCase(apellido)) {

                System.out.println("Telefono: " + contactos[i].getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    /**
     * Elimina un contacto de la agenda vaciando su lugar en el arreglo. */

    public void eliminarContacto(Contacto c) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                // Para eliminarlo, simplemente regresamos el espacio a null
                contactos[i] = null;
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }
}