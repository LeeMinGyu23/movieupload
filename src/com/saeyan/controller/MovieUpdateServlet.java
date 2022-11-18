package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

/**
 * Servlet implementation class MovieUpdateServlet
 */
@WebServlet("/movieUpdate.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code=request.getParameter("code");
		
		MovieDAO mDao = MovieDAO.getInstance();
		MovieVO mVO = mDao.selectMovieByCode(code);
		
		request.setAttribute("movie", mVO); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("movieUpdate.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		ServletContext context=getServletContext();
		String path=context.getRealPath("upload");
		
		int sizeLimit = 10*1024*1024;
		String encType="utf-8";
		
		MultipartRequest multi= new MultipartRequest(
				request,
				path,
				sizeLimit,
				encType,
				new DefaultFileRenamePolicy()
				);
				
		String code=multi.getParameter("code");
		String title=multi.getParameter("title");
		int price=Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis=multi.getParameter("synopsis");
		
		String poster = multi.getFilesystemName("poster");
		if(poster==null) {
			poster=multi.getParameter("nomakeImg");
		}
		
		MovieVO mVO = new MovieVO();
		mVO.setCode(Integer.parseInt(code));
		mVO.setTitle(title);
		mVO.setPrice(price);
		mVO.setDirector(director);
		mVO.setActor(actor);
		mVO.setPoster(poster);
		mVO.setSynopsis(synopsis);
		
		MovieDAO mDao= MovieDAO.getInstance();
		mDao.updateMovie(mVO);
		
		response.sendRedirect("movieList.do");
		
	}

}

