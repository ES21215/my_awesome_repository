//Etti Sherman

package hw6;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstWebsite")
public class FirstWebsite extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public FirstWebsite() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>"+
				"<html lang = \"en\">" +
				"<head>" +
				"<title> First Website! </title>" +
				"</head>" + 
				"<h1> This is the First Website! </h1>" +
				"<p> Please click the link below to be redirected to the next website. </p>" + 
				"<a href = http://localhost/Homework6/SecondWebsite> http://localhost/Homework6/SecondWebsite </a>" +
				"<p> You may not access the second website without first accessing the first website. </p>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
