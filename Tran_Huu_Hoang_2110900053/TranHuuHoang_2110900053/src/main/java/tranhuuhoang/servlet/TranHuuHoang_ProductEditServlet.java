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
 * Servlet implementation class TranHuuHoang_ProductEditServlet
 */
@WebServlet("/TranHuuHoang_ProductEdit")
public class TranHuuHoang_ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TranHuuHoang_ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductEdit.jsp");
		String code = (String) request.getParameter("code");
		if(code == "") {
			errorString="Bạn chưa chọn product cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		TranHuuHoang_2110900053_Product product = null;
		errorString = null;
		try {
			conn = TranHuuHoangConnection.getMSSQLConnection();
			product = TranHuuHoang_ProductUtils.findProduct(conn, code);
			if(product==null) {
				errorString="Không tìm thấy product có mã" + code;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || product == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
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
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = TranHuuHoangConnection.getMSSQLConnection();
			TranHuuHoang_ProductUtils.updateProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/TranHuuHoang_ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/TranHuuHoang_ProductEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
