import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pruebaGson.Buyer;

@WebServlet("/User")
public class User extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public User() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Buyer buyer = new Buyer("Luis", "Oviedo", 18, "luis.oviedo.et26@gmail.com");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String userMapeado = gson.toJson(buyer);
        response.getWriter().append(userMapeado);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
