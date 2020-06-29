package hw7;
//Etti Sherman
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public SetCookies() 
    {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>"+
				"<html lang = \"en\">" +
				"<head>" +
				"<title> Fun With Cookies! </title>" +
				"</head>" + 
				"<h1> Let's Have Some Fun With Cookies! </h1>" +
				"<p> Please fill out the form below to select preferences for the the other Web page. </p>" + 
				"<form onsubmit = \"alert('Thank you for submitting.')\"> <label for=\"fcolor\">Foreground Color:</label>" +
				"<input type=\"text\" id=\"fcolor\" name=\"fcolor\"><br><br> <label for=\"bcolor\">Background Color:</label>" +
				"<input type=\"text\" id=\"bcolor\" name=\"bcolor\"><br><br>" +
				"<input type=\"submit\" value=\"Submit\"> </form>"
				+ "<p> Click on the link below to see your color choices in effect. </p>"
				+ "<a href = \"Homework7\"> http://localhost/Homework7/Homework7</a>" +"</html>");
		
		String forecolor = request.getParameter("fcolor");
		String backcolor = request.getParameter("bcolor");
		Cookie fcolor = new Cookie("fcolor", forecolor);
		fcolor.setMaxAge(60*60*24*7);
		response.addCookie(fcolor);
		Cookie bcolor = new Cookie("bcolor", backcolor);
		bcolor.setMaxAge(60*60*24*7);
		response.addCookie(bcolor);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
