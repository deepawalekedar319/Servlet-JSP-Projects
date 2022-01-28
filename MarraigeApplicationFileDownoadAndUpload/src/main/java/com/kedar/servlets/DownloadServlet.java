package com.kedar.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@SuppressWarnings("serial")
@WebServlet("/downloadingFiles")
public class DownloadServlet extends HttpServlet {
	private static final String RESUME_QUERY = "SELECT RESUME FROM MARRIAGE WHERE ID=?";
	private static final String PHOTO_QUERY = "SELECT PHOTO FROM MARRIAGE WHERE ID=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// method stub
		
		// Set content type
		resp.setContentType("text/html");
		
		// Checking which hyperlink is clicked
		int id = 0;
		String query = null;
		if(req.getParameter("resumeID")!=null) {
			query = RESUME_QUERY;
			id = Integer.parseInt(req.getParameter("resumeID"));
		} // if
		else {
			query = PHOTO_QUERY;
			id = Integer.parseInt(req.getParameter("photoID"));			
		} // else
		
		// Load the driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} // try
		catch (ClassNotFoundException e) {
			// catch block
			e.printStackTrace();
		} // catch
		String filePath = null;
		// Establish the Connection
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","advjava","tiger");
				PreparedStatement ps = con.prepareStatement(query);){
			// set the data
			ps.setInt(1, id);
			// Execute the query
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next())
					filePath = rs.getString(1);
			} // try
			catch (Exception e) {
				// handle exception
				e.printStackTrace();
			} // catch
		} // try
		catch (Exception e) {
			// handle exception
			e.printStackTrace();
		} // catch
		
		//get length of the file and make it as a content length
		File file = new File(filePath);
		resp.setContentLengthLong(file.length());
		
		// get file content type and set it as the response content type
		ServletContext sc = getServletContext();
		String mimeType = sc.getMimeType(filePath);
		mimeType = mimeType!=null?mimeType:"application/octet-stream";
		resp.setContentType(mimeType);
		
		// Give instruction to browser to make the file as a download able file
		resp.setHeader("Content-Disposition","attachment;fileName=" + file.getName());
		
		// create input stream pointing to the response object
		InputStream is = new FileInputStream(filePath);
		 
		// create output stream pointing to the response object
		OutputStream os = resp.getOutputStream();
		
		// copy file content to the response object
		IOUtils.copy(is,os);
		
		// close the stream
		is.close();
		os.close();
	} // doGet(-,-)
} // class
