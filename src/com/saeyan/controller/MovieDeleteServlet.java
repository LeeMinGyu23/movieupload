package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

/**
 * Servlet implementation class MovieDeleteServlet
 */
@WebServlet("/movieDelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code=request.getParameter("code");
		
		MovieDAO mDao = MovieDAO.getInstance();
		MovieVO mVO = mDao.selectMovieByCode(code);
		
		request.setAttribute("movie", mVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("movieDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code= request.getParameter("code");
		
		MovieDAO mDao = MovieDAO.getInstance();
		mDao.deleteMovie(code);
		
		response.sendRedirect("movieList.do");
		
	}

}
