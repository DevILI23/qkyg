package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAO;

@SuppressWarnings("serial")
@WebServlet("/DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
	static String dbid = "group5";
	static String dbpw = "abcd1234";
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		PostDAO poDao = PostDAO.getInstance();
		try {
			poDao.deletePost(post_no);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	}

}
