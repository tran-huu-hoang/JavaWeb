package hoang.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class SearchAccount
 */
public class SearchAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccount() {
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
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 
		//lấy dữ liệu khi submit form từ UserAccount
		String phone = request.getParameter("phone");
		out.println("<html><head> <meta charset='UTF-8'><title>InputForm</title> </head>");
		out.println("<body style='text-align:center'>");
		out.println("<h1> KẾT QUẢ TÌM KIẾM </h1>");
		out.println("<form action='SearchAccount' method='post'>");
		out.println("<p> Input phone: ");
		out.println("<input type=text name='phone' value='" + phone + "'/>");
		out.println("<p> <input type='submit' value='Search' />");
		out.println("</form>");

		try {
		String sql = "Select * from USER_ACCOUNT ";
		if (phone!=null && phone.length() !=0)
			sql +=" WHERE CusPhone like '%" + phone + "%'";
			Connection conn = ConnectionUtils.getMSSQLConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<h2> Danh sách</h2>");
			out.println("<table border=1 align='center' style='width:100%'>");
		
			out.println("<tr><th>User</th><th>Name</th><th>Phone</th><tr>");
			if (rs != null) {
			while (rs.next()) {
				//Đọc dữ liệu và hiển
				out.println("<tr>");
				out.println("<td>" + rs.getString("CusUser") + "</td>");
				out.println("<td>" + rs.getString("CusName") + "</td>");
				out.println("<td>" + rs.getString("CusPhone") + "</td>");
				out.println("</tr>");
				}
			}
			rs.close();
			out.println("</table>");
		}catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() + "</h1>");
			out.println("<p>" + ex.toString() + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
