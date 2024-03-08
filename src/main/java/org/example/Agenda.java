package org.example;

import java.util.*;

public class Agenda implements IntAgenda {
    /**
     * List es una estructura de datos que permite guardar o eliminar elementos en un orden
     * especifico, sin definir un espacio fijo (tiene un tamaño dinámico). Necesitamos importar
     * la clase "java.util.List y otras por ejemplo para "ArrayList" por eso el import java.util.*
     */
    private List<Contacto> contacts; // Lista de los Contactos

    public Agenda() {
        // Instanciamos un objeto de tipo ArrayList (una lista) que va a contener los contactos.
        // "this" es una palabra reservada, es un puntero hacia la instancia del objeto que nos
        //    va a permitir diferenciar cuando nos referimos a los parámetros del constructor y
        //    cuando a los miembros de una clase (cuando se llaman igual). Cuando hacemos
        //    referencia a los miembros de la clase usamos "this" y no a los parámetros del
        //    constructor, por eso, en el constructor se usa "this"
        this.contacts = new ArrayList<>();
    }

    /**
     * Método "addContact" que crea un contacto nuevo si no existe,
      * @param name en la llamada a este método se le pasa el nombre del {@link Contacto} a crear
     * @param phone y el teléfono del contacto
     */
    @Override
    public void addContact(String name, String phone) {
        boolean exists = false; // Inicialmente decimos que el contacto no existe
        for (Contacto c : contacts) {  //"c" es un objeto de la clase Contacto, con ella luego
            //    accedemos a los métodos de esa clase, ejemplo: "c.getName()"
            //"get" nos permite obtener un nuevo valor del parámetro Name (un nuevo nombre de
            //    contacto para la agenda)
            // "equalsIgnoreCase" nos permite comparar un nombre de la lista ignorando la
            //    diferencia entre mayúsculas y minúsculas. Si el contenido es el mismo devuelve
            //    verdadero en caso contrario falso
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                //el método add "add(phone)" permite agregar un nuevo teléfono al contacto
                // al final de su lista de teléfonos
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {   //Si no existe el Contacto en la agenda se crea uno nuevo con sus parámetros
            Contacto newContact = new Contacto(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     * Método para eliminar elementos (contactos) de la agenda
     * @param name recive el nombre del contacto a eliminar
     */
    @Override
    public void removeContact(String name) {
        Iterator<Contacto> it = contacts.iterator(); //"it" va a ser un "iterator" que lo que hace es
                                                    // permitirnos recorrer la lista "Contacto"

        while (it.hasNext()) {  //"hastNext" te permite comprobar si hay más elementos
            Contacto c = it.next(); //"next" pasa al siguiente elemento si lo hay, así que "c"
                                    //irá conteniendo los diferentes contactos

            if (c.getName().equalsIgnoreCase(name)) {  //Compara si son iguales los contactos
                it.remove(); //Elimina el elemento (contacto) apuntado por el iterador "it" si TRUE
            }
        }
    }

    /**
     * Método para cambiar el número de teléfono de un contacto de la agenda
     * @param name es el nombre del {@link Contacto} al le cambiaremos su número de teléfono
     * @param oldPhone  parámetro que debe contener el número antiguo del contacto
     * @param newPhone aquí se indica el nuevo número de teléfono que le vamos a poner
     */
    @Override
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Contacto c : contacts) {   //"c" e
            if (c.getName().equalsIgnoreCase(name)) {
                //"c.getPhones" llama al método getPhones de la clase "Contacto"
                List<String> phones = c.getPhones();
                //"indexOf" devuelve la posición (nº entero) del teléfono en la lista. En caso
                //   que no exista, devuelve -1
                int index = phones.indexOf(oldPhone);

                // si no existe, el método "set" se encarga de añadir el nuevo nº de teléfono
                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * getContacts devuelve un contacto de la lista "Contacto"
     * {@link Contacto} referencia o hipervínculo a la clase Contacto
     * @return el método devuelve un contacto
     */
    @Override
    public List<Contacto> getContacts() {
        return this.contacts;
    }
}