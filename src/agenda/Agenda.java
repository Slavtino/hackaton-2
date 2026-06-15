package agenda;

public class Agenda {

    // Arreglo para almacenar los contactos
    private Contacto[] contactos;



    // Por defecto: 10 contactos
    public Agenda() {
        contactos = new Contacto[10];
    }

    // Personalizado: El tamaño que el usuario decida
    public Agenda(int tamano) {
        contactos = new Contacto[tamano];
    }

    // Verifica si hay algún espacio (null) en el arreglo
    public boolean agendaLlena() {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                return false; // Hay espacio
            }
        }
        return true; // No hay espacio
    }

    // Cuenta cuántos espacios "null" quedan
    public int espaciosLibres() {
        int libres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                libres++;
            }
        }

        return libres;
    }

///...--
