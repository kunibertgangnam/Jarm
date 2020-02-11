package de.jarm.gui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	String execute(HttpServletRequest request,
					  HttpServletResponse response, StringBuffer message) throws Exception;
}

