//Etti Sherman
package hw5;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework5")
public class Homework5 extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public Homework5() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle("Homework #5") + "<table> <tr>");
		for (int heading = 1; heading <= 10; heading++)
		{
			out.println("<th>Column " + heading + " </th>");
		}
		out.println("</tr>");
		for(int row = 1; row <= 25; row++)
		{
			out.print("<tr>");
			for(int col = 1; col <= 10; col++)
			{
				out.print("<td>Row " + row + " Col " + col + "</td>");
			}	
			out.println("</tr>");
		}
		out.print("</table></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

