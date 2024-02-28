package tranhuuhoang.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tranhuuhoang.beans.TranHuuHoang_2110900053_Product;
import tranhuuhoang.conn.TranHuuHoangConnection;
import tranhuuhoang.utils.TranHuuHoang_ProductUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class TranHuuHoang_ProductListServlet
 */
@WebServlet("/TranHuuHoang_ProductList")
public class TranHuuHoang_ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranHuuHoang_ProductListServlet() {
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
		List<TranHuuHoang_2110900053_Product> list = null;
		try {
			conn = TranHuuHoangConnection.getMSSQLConnection();
			try {
				list = TranHuuHoang_ProductUtils.queryProduct(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("listProduct", list);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductList.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward (request, response);
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
