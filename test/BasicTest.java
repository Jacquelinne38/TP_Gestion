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
    
    @Test
	public void testNotes() {
	    Fixtures.loadModels("data.yml");
	    User u = User.connect("Julia", "julia");
	    if (u == null) {
	    	fail();
	    }
	    List<Note> list = Note.getNotesByUser(u);
	    assertEquals(2, list.size());
	    for (Note note: list) {
	    	System.out.println("TP : " + note.product.title + " de : " + note.user.login + " note : " + note.note);
	    }
    }
}
