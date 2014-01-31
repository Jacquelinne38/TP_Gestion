package models;

import play.db.jpa.*;
//require
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
/*@Unique.List({
	@Unique(modelClass = User.class, fields = {"login"}, message = "Login already exists !"),
	@Unique(modelClass = User.class, fields = {"password"}, message = "Password already exists !")
})*/
public class User extends Model {
	
	@Required
	public String email;

	@Required
	public String name;

	@Required
	public String surname;

	@Required
	public String password;

	public boolean isAdmin;

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	
    public User() {
	
    }




	public static User connect(String login, String password) {
        return find("byEmailAndPassword", login, password).first();
    }
	
	public User addUser(String name, String surname, String email, String password) {
		return new User(name, surname, email, password).save();
		
	}

	public String toString() {
		return this.email;
	}
	
	

}
