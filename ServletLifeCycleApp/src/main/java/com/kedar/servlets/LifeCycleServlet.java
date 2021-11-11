package com.kedar.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
@WebServlet("/cycle")
public class LifeCycleServlet extends HttpServlet {
	static {
		System.out.println("LifeCycleServlet static method executes");
		System.out.println("Loading of servlet class...");
	} // static
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet.LifeCycleServlet() constructor exceutes");
		System.out.println("Instantiation event raised...");
	} // constructor
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeCycleServlet.init(ServletConfig config)");
		System.out.println("Initailzation event is raised");
	} // init(-)
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("LifeCycleServlet.service() executes");
		System.out.println("Response event rasied..");
	} // service(-,-)
	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet.destroy() executes");
		System.out.println("De-instantiation event raised");
	} // destroy()
} // class
