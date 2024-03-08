package org.example;
//Clase Contacto que recibe dos parámetros: name y phones
import java.util.ArrayList;
import java.util.List;

class Persona {
    private String name;
    private List<String> phones;

    /**
     * Método que es llamado de la clase {@link Agenda} que pasa los párametros
     * @param name nombre del contacto
     * @param phone teléfono del contacto
     */
    public Persona(String name, String phone) {
        this.name = name;
        this.phones = new ArrayList<>();
        this.phones.add(phone);
    }

    /**
     * Método getName que obtiene un nombre de la lista (ArrayList) contacts de la agenda
     * @return devuelve el nombre del contacto
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método getPhones que obtiene un nombre de la lista (ArrayList) phones de la agenda
     * @return devuelve el teléfono de la lista
     */
    public List<String> getPhones() {
        return this.phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}