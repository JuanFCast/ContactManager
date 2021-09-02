package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
	private List<Contact> contacts;
	private String FILE_IMPORT_TXT_PATH = "data/contactData.txt";
	private String FILE_EXPORT_TXT_PATH = "data/exportedData.txt";
	
	public ContactManager() {
		contacts = new ArrayList <Contact>();
		contacts.add(new Contact ("1","Castillo","ef"));
	}
	
	public boolean add(Contact newContact) {
		if(contacts.add(newContact)) {
			return true;
		}else {
			return false;
		}
	}
	
	//TODO
	public boolean remove(int index) {
		return true;
		
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
	
	public boolean addNewContact(Contact newContact) {

        if(contacts.add(newContact)) {
            return true;
        } else {
            return false;
        }

    }
	
	public void importData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_IMPORT_TXT_PATH));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(";");
			Contact register = new Contact(parts[0], parts[1], parts[2]);
			add(register);
			line = br.readLine();
		}
		br.close();
	}
	
	public void exportData() throws IOException {
		FileWriter fw = new FileWriter(FILE_EXPORT_TXT_PATH,false);
		for(int i = 0; i < contacts.size(); i++) {
			Contact myContact = contacts.get(i);
			fw.write(myContact.getId()+";"+myContact.getName()+";"+myContact.getEmail()+"\n");
		}
		fw.close();
	}
	
	
	
	
	
}
