package Contenido;

import java.awt.Insets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;
/**
 * Servlet implementation class Consultar
 */
@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	Connection con = null;
    Statement stmt = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultar() {
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
		ResultSet tabla = null;
		response.setContentType("text/html");
        PrintWriter pagina = response.getWriter();
        try {
          String url = "jdbc:mysql://localhost:3306/proyecto";
          String usuario = "root";
          String contraseña = "admin";
          try {
              try {
                  Class.forName("com.mysql.jdbc.Driver").newInstance();
              } catch (InstantiationException | IllegalAccessException ex) {
                  
              }
          } catch (ClassNotFoundException ex) {
              
          }
          con = (Connection) DriverManager.getConnection(url, usuario, contraseña);
          if (con != null) {
              System.out.println("Se ha establecido una conexión a la base de datos "
                      + "\n " + url);
          }

          stmt = con.createStatement();
          
          try {
        	  String txtemail;
              txtemail=request.getParameter("correoConsultar");
              tabla = stmt.executeQuery("select * from formulario where correo='"+txtemail+"';");
              
              pagina.println("<!DOCTYPE html>");
              pagina.println("<html>");
              pagina.println("<head>");
              pagina.println("<title>Consulta</title>");            
              pagina.println("</head>");
              pagina.println("<body style=\"background-color: #f2f9ff\">");
              pagina.println("<H1 ALIGN=" + "CENTER" + ">-Consulta de datos-</H1>");
              pagina.println("<p ALIGN=" + "CENTER" + ">Correo a consultar: "+txtemail+"  </p>");

              pagina.println("<DIV ALIGN=" + "CENTER" + "><CENTER>");
              pagina.println("<TABLE BORDER=" + "1" + ">");
              pagina.println("<TR><TD><H3>Id</H3></TD><TD><H3>Nombre</H3></TD><TD><H3>Apellidos</H3> </TD><TD><H3>Email</H3></TD><TD><H3>Asunto</H3></TD><TD><H3>Estado</H3></TD><TD><H3>Mensaje</H3></TD></TR>");
              while (tabla.next()) {
                  pagina.println("<TR>");
                  
                  pagina.println("<TD>" + tabla.getString(1) + "</TD>");
                  pagina.println("<TD>" + tabla.getString(2) + "</TD>");
                  pagina.println("<TD>" + tabla.getString(3) + "</TD>");
                  pagina.println("<TD>" + tabla.getString(4) + "</TD>");
                  pagina.println("<TD>" + tabla.getString(5) + "</TD>");
                  pagina.println("<TD>" + tabla.getString(6) + "</TD>");
                  pagina.println("<TD>" + tabla.getString(7) + "</TD>");
                  pagina.println("</TR>");
              }; // fin while
              pagina.println("</TABLE></CENTER></DIV>");
              pagina.println("<form action='http://localhost:2222/ProyectoFormulario/contenidoJsp/BotonesConsultas.jsp' method='post'>");
              pagina.println("<tr><input style=\"background-color:  #ffffff\"  type='submit' value='Inicio'></tr>");
              pagina.println("</form></BODY></HTML>");
              
              
          } catch (SQLException e) {
          } finally {
              if (con != null) {
                  try {
                      con.close();
                      stmt.close();
                  } catch (SQLException e) {
                      System.out.println(e.getMessage());
                  }

              }
          }
      } catch (SQLException ex) {
         
      }  
		
		
		
	}//final
	
}
