package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

/**
 * Servlet implementation class MovieWriteServlet
 */
@WebServlet("/movieWrite.do")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("movieWrite.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		ServletContext context=getServletContext();
		String path=context.getRealPath("upload");
		
		int sizeLimit=10*1024*1024;
		String encType="utf-8";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				sizeLimit,
				encType,
				new DefaultFileRenamePolicy()
				);
		
		String title=multi.getParameter("title");
		int price=Integer.parseInt(multi.getParameter("price"));
		String director=multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis=multi.getParameter("synopsis");
		String poster=multi.getFilesystemName("poster");
		
		MovieVO mVO = new MovieVO();
		mVO.setTitle(title);
		mVO.setPrice(price);
		mVO.setDirector(director);
		mVO.setActor(actor);
		mVO.setSynopsis(synopsis);
		mVO.setPoster(poster);
		
		MovieDAO mDao = MovieDAO.getInstance();
		mDao.insertMovie(mVO);
		
		response.sendRedirect("movieList.do");
	}

}




