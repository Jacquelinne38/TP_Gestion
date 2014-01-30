package models;

import play.db.jpa.*;
//require
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
/*@Unique({
	@Unique(modelClass = Product.class, fields = {"name"}, message = "Product already exists !")
})*/
public class Product extends Model {
	
	@Required
	public String name;
	

	public String toString() {
		return this.name;
	}
	
	public Product getProductByName(String name) {
		return find("byName", name).first();
	}

}
