package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import fr.grenobleinp.ensimag.vmmcaw.*;
import models.*;
 
public class Security extends Secure.Security {
	
    static boolean authenticate(String login, String password) {
    	Oracle auth = new Oracle();
        return auth.verifieIdentite(login, password);
    }

    static boolean check(String profile) {
    if("admin".equals(profile)) {
        return User.find("byLogin", connected()).<User>first().isAdmin;
    }
    return false;
}

    static void onDisconnected() {
    	Application.index();
	}
/*
	static void onAuthenticated() {
	    Admin.index();
	}

    */
}