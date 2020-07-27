/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc104project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author username
 */
public class CC104Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedList<Phonebook> ll = new LinkedList<>();
        String name;
        int phone, choice, count;
        boolean valid;
       
        System.out.println("PHONEBOOK");
        
        while(true) {
            System.out.println();
            System.out.println("===============");
            System.out.println("1. New contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Search contact");
            System.out.println("4. Sort contact (A - Z)");
            System.out.println("5. Print contacts list");
            System.out.println("6. Exit");
            System.out.println("===============\n");
            System.out.print("Enter your choice: \n");
            choice = Integer.parseInt(br.readLine());
            System.out.println("\n===============");
            
            switch (choice) {
                
                case 1: //adding contact
                    System.out.println("ADD NEW CONTACT");
                    System.out.println();
                    System.out.print("Name: ");
                    name = br.readLine();
                    System.out.print("Enter 9-digit Phone Number (+639): "); //Enter the last 9-digit phone number instead of the whole 11 digits. The problem lies on the int, It can only store 9 digits.
                    phone = Integer.parseInt(br.readLine());
                    ll.add(new Phonebook(name, phone));
                    System.out.println();
                    System.out.println("Contact added successfully");
                    
                    break;
                    
                case 2: //deleting contact
                    System.out.println("DELETE A CONTACT");
                    System.out.println();
                    System.out.print("Enter 9-digit Phone Number (+639): ");
                    phone = Integer.parseInt(br.readLine());
                    valid = true;
                    for (Phonebook i : ll) {
                        if (i.getPhone() == phone) {
                            ll.remove(i);
                            System.out.println();
                            System.out.println("Contact deleted successfully");
                            valid = false;
                            break;
                        }
                    }
                    if (valid)
                        System.out.println("\nThat phone number isn't present in the contact list");
                    
                    break;
                    
                case 3: //searching contact
                    System.out.println("SEARCH");
                    System.out.println();
                    System.out.print("Enter name: ");
                    name = br.readLine();
                    valid = true;
                    count = 1;
                    System.out.println();
                    for (Phonebook i : ll) {
                        if (name.equalsIgnoreCase(i.getName())) {
                            System.out.println("Contact #" + count);
                            System.out.println(i.toString());
                            valid = false;
                            count++;
                        }
                    }
                    if (valid)
                        System.out.println("The name isn't present in contact list");

                    break;
                    
                case 4: //sorting contacts
                    Collections.sort(ll);
                    System.out.println("\nSorted successfully");
                    break;
                    
                case 5: //showing the list of contacts
                    System.out.println("CONTACT INFORMATION");
                    System.out.println();
                    count = 1;
                    for (Phonebook i : ll) {
                        System.out.println("Contact #" + count);
                        System.out.println(i.toString());
                        count++;
                        System.out.println();
                    }                       
                    break;
                    
                case 6: //exiting
                    System.out.println();
                    System.out.println("Thank you.");
                    System.exit(0);
                    
                default:
                    System.out.println("\nInvalid input! Please Try Again");
                    break;                   
            }
        }
    }   
}
