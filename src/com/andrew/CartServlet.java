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
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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

		resp.print("<html><head><title>Cart</title></head>");
		resp.print("<body>");
		resp.print("<h1> NetBazaar </h1>");
		resp.print("<h2> Products in cart </h2>");
		resp.print("<a href='HomePage.html'>Home</a>");
		resp.print("<form method ='post' action='CartAction'>");
		resp.print("<table>");
		for (int i = 0; i < cartedProducts.size(); i++) {
			resp.print("<tr>");
			resp.print("<td><input type='checkbox' name='products' value='" + cartedProducts.get(i).getProductName()
					+ "'> " + cartedProducts.get(i).getProductName() + "</td>");
			resp.print("<td>" + cartedProducts.get(i).getProductPrice() + "</td>");
			resp.print("</tr>");
		}

		resp.print("<tr>");
		resp.print("<td><input type='submit' name='action' id='Remove' value='Remove From Cart'/></td>");
		resp.print("<td><input type='submit' name='action' id='Purchase' value='Purchase'/></td>");
		resp.print("</tr>");

		resp.print("</table>");
		resp.print("</form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
