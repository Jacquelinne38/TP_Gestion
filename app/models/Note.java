package models;

import play.db.jpa.*;
//require
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(uniqueConstraints=
           @UniqueConstraint(columnNames = {"Users", "Products"}))
public class Note extends Model{
	
	@Required
	@ManyToOne
	@JoinColumn(name="Users")
	public User user;
	
	@Required
	@OneToOne 
	@JoinColumn(name="Products")
	public Product product;
//	
	@Required
	public int note;

	public Note(User user, Product product, int note) {
		this.user = user;
		this.product = product;
		this.note = note;
	}

	public Note() {

	}
	
	public static List<Note> getNotesByUser(User user) {
		return find("byUser", user).fetch();
	}
	
	public static Note getNoteByUserAndProduct(User user, Product product) {
		return find ("byUserAndProduct", user, product).first();
	}

}
