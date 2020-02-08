package com.qimo.servlet.client;
import java.io.IOException;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qimo.domain.User;
import com.qimo.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService service = new UserService();
		try {
			User user = service.login(username, password);
			request.getSession().setAttribute("user", user);

			String role = user.getRole();
			
			if ("1".equals(role)) {
				response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return;
			}
		} catch (LoginException e) {

			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}
}
