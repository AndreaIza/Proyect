package Contenido;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Enviar
 */
@WebServlet("/Enviar")
public class Enviar extends HttpServlet {
	Connection conn = null;
    Statement stmt = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enviar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter(); 
     // JDBC driver name and database URL
        String driver = "com.mysql.jdbc.Driver";  
        String url = "jdbc:mysql://localhost/proyecto";

        //  Database credentials
         String USER = "root";
         String PASS = "admin";

    try{  
      String txtnombre = request.getParameter("nombre");  
      String txtapellidos = request.getParameter("apellidos");  
      String txtemail = request.getParameter("email");  
      String txtasunto = request.getParameter("asunto");  
      String txtestadoList = request.getParameter("estadoList");  
      String txtmensajeText = request.getParameter("mensajeText");  
     
      
     
         //STEP 2: Register JDBC driver
        // Class.forName("com.mysql.jdbc.Driver");

         //STEP 3: Open a connection
         System.out.println("Connecting to database...");
         conn = (Connection) DriverManager.getConnection(url,USER,PASS);
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
        
         String sql="insert into formulario(nombre,apellidos,correo,asunto,estado,mensaje) values(?,?,?,?,?,?)";//try2 is the name of the table  

         //preparedStatement = connection.prepareStatement(sql);
         PreparedStatement pst = conn.prepareStatement(sql);
         pst.setString(1,txtnombre);  
         pst.setString(2,txtapellidos);        
         pst.setString(3,txtemail);
         pst.setString(4,txtasunto);
         pst.setString(5,txtestadoList);
         pst.setString(6,txtmensajeText);


      int i=pst.executeUpdate();
     
 
      if(i!=0){           
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Enviado-> Menu</title>");
        out.println("</head>");
        out.println("<body style=\"background-color: #f2f9ff\"");
        out.println("<H1 ALIGN=" + "CENTER" + ">-Solicitud enviada correctamente-</H1>");
        out.println("<form action='http://localhost:2222/ProyectoFormulario/contenidoJsp/BotonesConsultas.jsp' method='post'");
        out.println("<tr><input style=\"background-color: #ffffff\" type='submit' value='Inicio'></tr>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

      }  
      else{  
    	  out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Enviado-> Menu</title>");
          out.println("</head>");
          out.println("<body style=\"background-color: #f2f9ff\"");
          out.println("<H1 ALIGN=" + "CENTER" + ">-Fallo al enviar los datos intente nuevamete-</H1>");
          out.println("<form action='http://localhost:2222/ProyectoFormulario/contenidoJsp/BotonesConsultas.jsp' method='post'");
          out.println("<tr><input style=\"background-color: #ffffff\" type='submit' value='Inicio'></tr>");
          out.println("</form>");
          out.println("</body>");
          out.println("</html>");

       }  
      pst.close();
    }  
    catch (Exception e){  
      out.println(e);  
    }  
		
	}

}
