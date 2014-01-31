package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class UserInfo extends Controller {

    public static void index() {
    	render();
    }

    @Before
    public static void getInfoUser() {
        if(Security.isConnected()) {
            User user = User.find("byLogin", Security.connected()).first();
            renderArgs.put("user", user);
        }

    }
    
}