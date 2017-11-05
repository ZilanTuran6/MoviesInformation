package com.imdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imdb.model.Movie;
import com.imdb.model.MovieDAO;
import com.imdb.model.MovieException;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("movie2.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		Movie movie = null;
		try {
			movie = new MovieDAO().getMovieByTitle(title);
		} catch (MovieException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("movie", movie);
		doGet(request, response);
	}

}
