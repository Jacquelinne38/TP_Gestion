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

    public static void getInfoUser() {
        if(Security.isConnected()) {
            User user = User.find("byLogin", Security.connected()).first();
            renderArgs.put("user", user);
        }

    }
    
}