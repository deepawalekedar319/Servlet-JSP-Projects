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
import javazoom.upload.UploadParameters;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final String QUERY = "INSERT INTO MARRIAGE VALUES(?,?,?,?,?,?,?,?,?,?,ID.NEXTVAL)";
	@SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Logic
		Connection con = null;
		PreparedStatement ps = null;
		// get PrintWriter object
		PrintWriter pw = resp.getWriter();
		// set response content type
		resp.setContentType("text/html");
		// Uploading the files
		try {
			// read the special request object
			MultipartFormDataRequest mreq = new MultipartFormDataRequest(req);
			
			// read the form data
			String firstName = mreq.getParameter("fName");
			String lastName = mreq.getParameter("lName");
			String email = mreq.getParameter("email");
			String phone = mreq.getParameter("pno");
			int age = Integer.parseInt(mreq.getParameter("age"));
			String gender = mreq.getParameter("gender");
			String occup = mreq.getParameter("oup");
			double salary = Double.parseDouble(mreq.getParameter("sal"));
			
			// create the UploadBean class object
			UploadBean ub = new UploadBean();
			ub.setFolderstore("E:\\ProjectFilesUploaded");
			ub.setOverwrite(false);
			
			// Complete the file uploading process
			ub.store(mreq);
			
			pw.println("<h1 style='color:red;' align=center>Files uploaded into the Server Folder...</h1>");
			
			// get the names of the uploaded files
			Vector<UploadParameters> vector = ub.getHistory();
			@SuppressWarnings("rawtypes")
			ArrayList<String> filesList = new ArrayList();
			vector.forEach(up->{
				filesList.add("E:/ProjectFilesUploaded/" + up.getFilename());
			});
			
			// JDBC Connections and Statements
			// Load the JDBC Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Establish the connection 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","advjava","tiger");
			if(con!=null)
				ps = con.prepareStatement(QUERY);
			if(ps!=null) {
				// set the values
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, email);
				ps.setString(4, phone);
				ps.setInt(5, age);
				ps.setString(6, gender);
				ps.setString(7, occup);
				ps.setDouble(8, salary);
				ps.setString(9, filesList.get(0));
				ps.setString(10, filesList.get(1));
			} // if
			int result = 0;
			if(ps!=null)
				result = ps.executeUpdate();
			if(result!=0)
				pw.println("<br><h1 style='color:blue;' align=center>Files uploaded into the Server Database...</h1>");
			else
				pw.println("<h1 style='color:red;' align=center>Problem in uploading please try again...</h1>");
		} // try
		catch (Exception e) {
			// handle exception
			e.printStackTrace();
		} // catch
		// Close the connections
		finally {
			if(con!=null) {
				try {
					con.close();					
				} // try
				catch (Exception e2) {
					//  handle exception
					e2.printStackTrace();
				} // catch
			} // if
				if(ps!=null) {
					try {
						ps.close();					
					} // try
					catch (Exception e2) {
						//  handle exception
						e2.printStackTrace();
					} // catch
			} //if
		} // finally
		pw.println("<h1 align='center'><a href='home.html'>Home</a></h1>");
		// close the stream
		pw.close();
	} // doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	} // doPost(-,-)
} // class