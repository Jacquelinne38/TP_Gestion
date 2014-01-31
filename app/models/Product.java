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
	public String title;
	
	@Required
	public Date date;
	
	@Required
	public double coeff;
	
	

	public String toString() {
		return this.title;
	}
	
	public Product getProductByName(String title) {
		return find("byTitle", title).first();
	}

}
