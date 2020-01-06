package Contenido;

import java.awt.Insets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	Connection conn = null;
    Statement stmt = null;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		  try (PrintWriter out = response.getWriter()) {
		try { 
            String url = "jdbc:mysql://localhost:3306/proyecto"; 
            String usuario = "root"; 
            String contraseña = "admin"; 
            
            try { 

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = (Connection) DriverManager.getConnection(url,usuario,contraseña); 
            if ( conn != null ) 
              System.out.println("Se ha establecido una conexión a la base de datos " + url ); 

            stmt = conn.createStatement(); 
            String txtemail;
            txtemail=request.getParameter("correoEliminar");
            System.out.println("Dato a eliminar .... "+txtemail);                          
            PreparedStatement stmt = conn.prepareStatement("delete from formulario where correo='"+txtemail+"';");
            //stmt.executeUpdate();
            
            System.out.println("La solicitud se elimino.... "+txtemail); 
            int i=stmt.executeUpdate();
            
            if(i!=0){
            	out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Eliminado<> Menú</title>");            
                out.println("</head>");
                out.println("<body style=\"background-color: #f2f9ff\">");
                out.println("<h1>-Eliminado correctamente-</h1><br><br>");
                out.println("<form action='http://localhost:2222/ProyectoFormulario/contenidoJsp/BotonesConsultas.jsp' method='post'");
                out.println("<tr><input style=\"background-color: #ffffff\" type='submit' value='Inicio'></tr>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
            else {
            	out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Eliminado -> Menú</title>");            
                out.println("</head>");
                out.println("<body style=\"background-color: #f2f9ff\">");
                out.println("<h1>-No se puede eliminar, verifique el correo-</h1><br><br>");
                out.println("<form action='http://localhost:2222/ProyectoFormulario/contenidoJsp/BotonesConsultas.jsp' method='post'");
                out.println("<tr><input style=\"background-color: #ffffff\" type='submit' value='Inicio'></tr>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
            
            } 
            catch( SQLException e ) { 
            } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

    }finally { 
            if ( conn != null ) { 
                
                    try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
                    try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
                    System.out.println("Cerrando la BD");
            }//if
           }//finally
          }//try 
	}//dopost
}//clase
