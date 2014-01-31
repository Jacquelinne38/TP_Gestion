package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import play.Logger;
import play.Play;
import play.data.binding.Binder;
import play.data.validation.MaxSize;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.Model;
import play.db.Model.Factory;
import play.exceptions.TemplateNotFoundException;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Router;
import play.utils.Java;


@Check("admin")
@With(Secure.class)
public class Annotations extends CRUD {
	
	public static void save(Long id, String comment) throws Exception {
        String note = request.params.allSimple().get("object.note");
        String[] users = request.params.all().get("object.users.id");
        String[] products = request.params.all().get("object.product.id");
        Annotation a;
        if(id != null) {
			a = Annotation.findById(id);
			notFoundIfNull(a);
        } else {
			a = new Annotation();
			//a.users = users;
			//a.product = products;
			a.comment = comment;
   		}
   		if(Double.valueOf(note) < 0 || Double.valueOf(note) > 20) a.note = "Non évalué";
   		else a.note = note;

	    if (validation.hasErrors()) {
		    renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
		    try {
		        render(request.controller.replace(".", "/") + "/show.html");
		    } catch (TemplateNotFoundException e) {
		        render("CRUD/show.html");
		    }
    	}
      	a.save();
    	flash.success(play.i18n.Messages.get("crud.saved", "Annotation"));
	    if (params.get("_save") != null) {
	        redirect(request.controller + ".list");
	    }
	        redirect(request.controller + ".show", a.id);
    }

  /* 	public static void list(int page, String search, String searchFields, String orderBy, String order) {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        if (page < 1) {
            page = 1;
        }
        List objects = type.findPage(page, search, searchFields, orderBy, order, (String) request.args.get("where"));
        for(Annotation object : (List<Annotation>)objects) {
        	if(object.note == null)
        		object.note = "Non évalué";
        }
        Long count = type.count(search, searchFields, (String) request.args.get("where"));
        Long totalCount = type.count(null, null, (String) request.args.get("where"));
        try {
            render(type, objects, count, totalCount, page, orderBy, order);
        } catch (TemplateNotFoundException e) {
            render("CRUD/list.html", type, objects, count, totalCount, page, orderBy, order);
        }
    }*/
}