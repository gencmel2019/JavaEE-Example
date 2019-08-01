package com.andrew;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartAction
 */
@WebServlet("/CartAction")
public class CartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartAction() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String[] products = request.getParameterValues("products");
		ArrayList<Products> cartedProducts = (ArrayList<Products>) session.getAttribute("cartedProducts");

		if (action.equals("Purchase")) {
			response.sendRedirect("SuccessServlet");
		} else {
			for (int i = 0; i < cartedProducts.size(); i++) {
				for (int j = 0; j < products.length; j++) {
					if (cartedProducts.get(i).getProductName().equals(products[j])) {
						cartedProducts.remove(i);
					}
				}
			}

			session.setAttribute("cartedProducts", cartedProducts);
			response.sendRedirect("CartServlet");

		}

	}

}
