package com.andrew;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartProcessing
 */
@WebServlet("/CartProcessing")
public class CartProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Products> cartedProducts = new ArrayList<Products>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartProcessing() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String[] products = request.getParameterValues("products");
		StringTokenizer st;

		if (products == null) {
			response.sendRedirect(request.getHeader("Referer"));
		} else {

			for (String product : products) {
				System.out.println(product);
				st = new StringTokenizer(product, ",");

				String productName = st.nextToken();
				int productPrice = Integer.parseInt(st.nextToken());

				Products p = new Products(productName, productPrice);

				cartedProducts.add(p);

			}

			session.setAttribute("cartedProducts", cartedProducts);
			response.sendRedirect("CartServlet");

		}

	}

}
