import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import crudGson.Product;

//URL
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Identificador único para la serialización
    private Connection connection; // Conexión a la base de datos
    private Gson gson = new Gson(); // Instancia de Gson para convertir objetos a JSON

    @Override
    public void init() throws ServletException {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión a la base de datos    nombre de la base de datos , usuario , contraseña
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjava", "root", "");
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            throw new ServletException("No se pudo conectar a la base de datos", e);
        }
    }

    // Método que maneja las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getPathInfo(); // Obtener el ID del producto de la URL
        response.setContentType("application/json"); // Establecer el tipo de contenido de la respuesta
        PrintWriter out = response.getWriter(); // Crear un PrintWriter para escribir la respuesta

        try {
            // Si no se proporciona un ID, devolver todos los productos
            if (idParam == null) {
                List<Product> products = new ArrayList<>(); // Lista para almacenar los productos
                Statement stmt = connection.createStatement(); // Crear un Statement para ejecutar la consulta
                ResultSet rs = stmt.executeQuery("SELECT * FROM products"); // Ejecutar la consulta

                // Recorrer los resultados y agregar cada producto a la lista
                while (rs.next()) {
                    Product product = new Product(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
                            rs.getDouble("price"));
                    products.add(product);
                }
                out.print(gson.toJson(products)); // Convertir la lista a JSON y enviarla
            } else {
                // Si se proporciona un ID, buscar el producto específico
                int id = Integer.parseInt(idParam.substring(1)); // Extraer el ID del parámetro
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
                pstmt.setInt(1, id); // Establecer el ID en la consulta
                ResultSet rs = pstmt.executeQuery(); // Ejecutar la consulta

                // Si se encuentra el producto, devolverlo como JSON
                if (rs.next()) {
                    Product product = new Product(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
                            rs.getDouble("price"));
                    out.print(gson.toJson(product));
                } else {
                    // Si no se encuentra el producto, devolver un error 404
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\": \"Producto no encontrado\"}");
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error de base de datos
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\": \"Error en la base de datos\"}");
        }
    }

    // Método que maneja las solicitudes POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json"); // Establecer el tipo de contenido de la respuesta
        PrintWriter out = response.getWriter(); // Crear un PrintWriter para escribir la respuesta
        StringBuilder sb = new StringBuilder(); // StringBuilder para construir el cuerpo de la solicitud
        String line;

        // Leer el cuerpo de la solicitud línea por línea
        while ((line = request.getReader().readLine()) != null) {
            sb.append(line);
        }

        // Convertir el cuerpo de la solicitud a un objeto Product
        Product product = gson.fromJson(sb.toString(), Product.class);
        try {
            // Preparar la consulta para insertar un nuevo producto
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO products (title, description, price) VALUES (?, ?, ?)");
            pstmt.setString(1, product.getTitle()); 
            pstmt.setString(2, product.getDescription()); 
            pstmt.setDouble(3, product.getPrice()); 
            pstmt.executeUpdate(); // Ejecutar la consulta
            out.print("{\"success\": \"Producto creado\"}"); 
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\": \"Error al crear el producto\"}");
        }
    }

    // Método que se ejecuta al destruir el servlet
    @Override
    public void destroy() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}