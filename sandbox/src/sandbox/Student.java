package sandbox;

import java.util.ArrayList;

public class Student extends User 
{
	ArrayList courses = new ArrayList<Course>();
	public Student(String name, String email, String password, String type) {
		this.name = name;
        this.email = email;
        this.pw = password;
        this.type = type;
        this.id = this.generateRandomID();
        writeUserCsv(this.name, this.email, this.pw, this.id);
	}

//	this.vertification = LibraryManager.verify(this);
//    if (this.vertification) {
//        writeUserCsv(this.name, this.email, this.pw, this.id);
//    } else {
//        System.out.println("Student verification failed. User not added to CSV.");
//    }

}
