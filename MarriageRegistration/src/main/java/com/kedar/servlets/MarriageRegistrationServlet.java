package com.kedar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;

@SuppressWarnings("serial")
@WebServlet("/register")
public class MarriageRegistrationServlet extends HttpServlet {
	private static final String QUERY = "INSERT INTO MARRIAGE VALUES(?,?,?,?,?,?,?,?,?,?,ID_NUMBER.NEXTVAL)";
	private Connection con = null;
	private PreparedStatement ps = null;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  Marriage Registration logic...
		// set the response content type
		resp.setContentType("text/html");
		// get the PrintWriter Object
		PrintWriter pw = resp.getWriter();
		
		// Uploading the resume and photo
		MultipartFormDataRequest nreq;
		try {
			nreq = new MultipartFormDataRequest(req);
		
			// Get the Form data and store into the variables
			String firstName = nreq.getParameter("fName");
			String lastName = nreq.getParameter("lName");
			String email = nreq.getParameter("email");
			String phone = nreq.getParameter("pno");
			int age = Integer.parseInt(nreq.getParameter("age"));
			String gender = nreq.getParameter("gender");
			String occupation = nreq.getParameter("oup");
			long salary = Long.parseLong(nreq.getParameter("sal"));
			
			// create UploadBean class
			UploadBean ub = new UploadBean();
			ub.setOverwrite(false);
			ub.setFolderstore("E:/ProjectFilesUploaded");
			
			// Complete the upload process
			ub.store(nreq);
			
			// get the names of the uploaded file
			Vector<UploadParameters> vector = ub.getHistory();
			ArrayList<String> fileList = new ArrayList();
			vector.forEach(up->{
				fileList.add("E:/ProjectFilesUploaded/" + up.getFilename());
			});
			
			// Storing the data into the drive
			// Load the Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","advjava","tiger");
			// create the statement
			ps = con.prepareStatement(QUERY);
			// set the values
			if(ps!=null) {
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, email);
				ps.setString(4, phone);
				ps.setInt(5, age);
				ps.setString(6, gender);
				ps.setString(7, occupation);
				ps.setLong(8, salary);
				ps.setString(9,fileList.get(0));
				ps.setString(10,fileList.get(1));
			} // if
			// Execute the query
			int result = ps.executeUpdate();
			if(result!=0) {
				pw.println("<h1 style='text-align:center; color:red'> Marriage Registration Completed...</h1>");
				pw.println("<h2 style='text-align:center; color:red'> Wait for the response...</h2>");
			} // if
			else
				pw.println("<h1 style='text-align:center; color:red'>Problem in registration...</h1>");
			pw.println("<h2 style='text-align:center; color:red'><a href='home.html'>Home</a></h2>");
			// close the Stream
			pw.close();
		} //  try
		catch (Exception e) {
			// : handle exception
			e.printStackTrace();
		} // catch
		// close all the connections
		finally {
			try {
				if(con!=null) {
					con.close();
				} // if
			} // try
			catch (Exception e2) {
				// handle exception
				e2.printStackTrace();
			} // catch
			try {
				if(ps!=null) {
					ps.close();
				} // if
			} // try
			catch (Exception e2) {
				// handle exception
				e2.printStackTrace();
			} // catch
		} // finally
 	} // doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	} // doPost(-,-)
} // class
