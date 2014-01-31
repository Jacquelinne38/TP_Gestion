package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;


@Check("admin")
@With(Secure.class)
public class Products extends CRUD {
	

}