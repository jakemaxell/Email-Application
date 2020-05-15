package EmailApplication;

import java.util.Scanner;

public class Email {

	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "thisCompany.com";
	
	// Constructor for names
	public Email(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;	
		
		System.out.println("Email Created: " + this.firstname + " " + this.lastname);
		
		// Call a method for asking for department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: " + this.password);
		
		// Combine elements to create the email
		email = (firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "."+ companySuffix);
		System.out.println("Your email is: " + email);
		
	}
	
	// Ask for department
	private String setDepartment() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("DEPARTMENT CODES\n1. Sales\n2. Development\n3. Accounting\n0. None\nEnter department code: ");
		int depChoice = in.nextInt();
		
		if (depChoice == 1) {return "Sales";}
		else if (depChoice == 2) {return "Development";}
		else if (depChoice == 3) {return "Accounting";}
		else {return "";}
		}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	// Set capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change password 
	public void changePassword(String newpassword) {
		this.password = newpassword;
	}
	
}
