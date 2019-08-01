package com.andrew;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuccessServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Products> cartedProducts = (ArrayList<Products>) session.getAttribute("cartedProducts");
		PrintWriter resp = response.getWriter();

		resp.print("<html><head><title>Success</title></head>");
		resp.print("<body>");
		resp.print("<h1> NetBazaar </h1>");
		resp.print("<a href='HomePage.html'>Home</a>");
		resp.print("<p> You have successfully purchased the following products: </p>");
		resp.print("<ul>");
		for (int i = 0; i < cartedProducts.size(); i++) {
			resp.print("<li>" + cartedProducts.get(i).getProductName() + "</li>");
		}
		resp.print("</ul>");
		resp.print("</body></html>");

		cartedProducts.clear();

		session.setAttribute("cartedProducts", cartedProducts);
	}

}
