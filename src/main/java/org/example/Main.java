package org.example;

/**
 *Clase principal del programa Agenda
 * @author 474337 Jorge David Méndez Peñalver
 * @version 1.0 a fecha 07/03/2024
 * @since 2024
 */

public class Main {
    /**
     * Clase principal que crea un objeto de la clase agenda
     * @param args es un array que recibe datos de la command line (línea de comando)
     *             pero no lo estamos utilizando
     * En la clase main se llama a la clase Agenda, a sus métodos:
     *    agenda.addContact, le pasa como parámetros el nombre del contacto y su teléfono,
     *                 para crear ese contacto
     *    agenda.removeContact, que elimina uno de los contactos que tiene la agenda,
     *                 le pasamos como parámetro el nombre de la persona a eliminar
     *    agenda.modifyPhoneNumber, que le pasamos como parámetros el nombre de la persona
     *                 de la agenda, el número de teléfono que hay en la agenda y el número
     *                 que va a sustituir al actual
     */
    public static void main(String[] args) {
        // Crear una nueva agenda.
        // Constructor que crea un objeto Agenda llamado agenda
        Agenda agenda = new Agenda();

        // Añadir contactos a la agenda.
        agenda.addContact("John Doe", "1234567890");
        agenda.addContact("Jane Doe", "9876543210");
        agenda.addContact("Mary Jane", "1122334455");

        // Imprimir todos los contactos de la agenda.
        System.out.println("Todos los contactos: ");
        for (Contacto c : agenda.getContacts()) {
            System.out.println(c.getName() + " -> " + c.getPhones());
        }

        // Añadir un nuevo teléfono a un contacto existente.
        //Llama al método addContact de la clase Agenda para crear el nuevo contacto
        agenda.addContact("John Doe", "6543219876");


        // Eliminar un contacto de la agenda.
        agenda.removeContact("Jane Doe");

        // Modificar el teléfono de un contacto existente en la agenda.
        agenda.modifyPhoneNumber("John Doe", "1234567890", "6666666666");

        System.out.println("\nDespués de añadir, eliminar y modificar contactos: ");
        // Imprimimos todos los contactos de la agenda, con sus números de teléfono

        for (Contacto c : agenda.getContacts()) {
            System.out.println(c.getName() + " -> " + c.getPhones());
        }
    }
}