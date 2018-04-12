import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ServiceReceiver extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String characters = request.getParameter("characters");

        Driver driver = new Driver();
        String ret = null;
        try {
            ret = driver.runner(characters);
        } catch (Exception e) {
            log(e.toString());
        }

        response.getWriter().write(ret);
    }
}
