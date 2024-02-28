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

/**
 * Servlet implementation class TranHuuHoang_ProductCreateServlet
 */
@WebServlet("/TranHuuHoang_ProductCreate")
public class TranHuuHoang_ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranHuuHoang_ProductCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String maSP = (String) request.getParameter("maSP_2110900053");
		String tenSP = (String) request.getParameter("tenSP_2110900053");
		String soLuongStr = (String) request.getParameter("soLuong_2110900053");
		String donGiaStr = (String) request.getParameter("donGia_2110900053");
		String anh = (String) request.getParameter("anh_2110900053");
		
		
		
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(soLuongStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		
		float donGia = 0;
		try {
			donGia = Float.parseFloat(donGiaStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		
		TranHuuHoang_2110900053_Product product = new TranHuuHoang_2110900053_Product(maSP, tenSP, soLuong, donGia, anh);
		String regex = "\\w+";
		

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		Connection conn = null;
		try {
			conn = TranHuuHoangConnection.getMSSQLConnection();
			TranHuuHoang_ProductUtils.insertProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/TranHuuHoang_ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
