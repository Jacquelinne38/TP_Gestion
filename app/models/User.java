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

	@Required
	public String login;

	public boolean isAdmin;

	public User(String name, String surname, String email, String password, String login) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.login = login;
	}
	
	
    public User() {
	
    }




	public static User connect(String login, String password) {
        return find("byLoginAndPassword", login, password).first();
    }
	
	public User addUser(String name, String surname, String email, String password, String login) {
		return new User(name, surname, email, password, login).save();
		
	}

	public String toString() {
		return this.email;
	}
	
	

}
