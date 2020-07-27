/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc104project;

/**
 *
 * @author username
 */
public class Phonebook implements Comparable<Phonebook> {
    private String name;
    private long phone;
    
    public Phonebook(String name, long phone) {
        this.name = name;
        this.phone = phone;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the phone
     */
    public long getPhone() {
        return phone;
    }
    
    public String toString() {
        return "Name: " + getName() + "\nPhone Number (+639): " + getPhone();         
    }
    
    public int compareTo(Phonebook o) {
        return getName().charAt(0) < o.getName().charAt(0) ? -1 : 1;
    }
}
