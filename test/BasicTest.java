import org.junit.*;

import java.util.*;

import play.mvc.After;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }
    
//    @Test
//	public void testNotes() {
//	    Fixtures.loadModels("data.yml");
//	    User u = User.connect("Julia", "julia");
//	    if (u == null) {
//	    	fail();
//	    }
//	    List<Annotation> list = Annotation.getNotesByUser(u);
//	    assertEquals(2, list.size());
//	    for (Annotation annotation: list) {
//	    	System.out.println("TP : " + annotation.product.title + " de : " + annotation.user.login + " note : " + annotation.note);
//	    }
    //}
}
