package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
    	render();
    }

    public static void index2() {
		List tasks = Task.find("order by id desc").fetch();
    	render(tasks);
	}

    public static void createTask(String title) {
    	Task task = new Task(title).save();
    	renderJSON(task);
    }

    public static void changeStatut(Long id, boolean checked) {
    	Task task = Task.findById(id);
    	task.checked = checked;
    	task.save();
    	renderJSON(task);

    }
    
    private static Double tryParseDouble(String s) {
   	 try {
   		 	return Double.parseDouble(s);
   	 } catch (NumberFormatException ex) {
   		 return null;
   	}
   }
    
    public static void getInfoUser() {
// request.params.allSimple();
    	if(Security.isConnected()) {
            User user = User.find("byLogin", Security.connected()).first();
            List<Annotation> listAnnotation = Annotation.getNotesByUser(user);
            float moyenne = 0;
            int taille = 0;
            for(Annotation anno : listAnnotation) {
            	//Double note = tryParseDouble(anno.note);
            	Double note = tryParseDouble(anno.note);
            	if (note != null) {
            		moyenne += note * anno.product.coeff;
            		taille += anno.product.coeff;
            	}
            }
            moyenne /= taille;
            int moyenneArrondi = Math.round(moyenne);
            renderArgs.put("user", user);
            renderArgs.put("moyenne",moyenne);
            renderArgs.put("moyenneArrondi", moyenneArrondi);
            renderArgs.put("listAnno", listAnnotation);            
        }
        render();

    }
    
  
    
}