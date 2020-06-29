//Etti Sherman

package hw6;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondWebsite")
public class SecondWebsite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SecondWebsite() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		if ((referer == null) || (!(referer.equals("http://localhost/Homework6/FirstWebsite"))))
		{
			response.sendRedirect("http://localhost/Homework6/FirstWebsite");
		}
		else
		{
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>"+ "\n" +
				"<html lang = \"en\">" +
				"<head>" +
				"<title> Second Website! </title>" +
				"</head>" + 
				"<h1> This is the Second Website! </h1>" +
				"<p> Thank you for participating in this activity. </p>" + 
				"<p> You have successfully reached the second website! </p>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
