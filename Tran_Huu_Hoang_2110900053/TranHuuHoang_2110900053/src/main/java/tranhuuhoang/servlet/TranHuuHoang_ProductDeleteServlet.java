package tranhuuhoang.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tranhuuhoang.conn.TranHuuHoangConnection;
import tranhuuhoang.utils.TranHuuHoang_ProductUtils;

import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class TranHuuHoang_ProductDeleteServlet
 */
@WebServlet("/TranHuuHoang_ProductDelete")
public class TranHuuHoang_ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranHuuHoang_ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		String errorString = null;
		String code = (String) request.getParameter("code");
		try {
			conn = TranHuuHoangConnection.getMSSQLConnection();
			TranHuuHoang_ProductUtils.deleteProduct(conn, code);
		}catch(Exception e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductDelete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/TranHuuHoang_ProductList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
