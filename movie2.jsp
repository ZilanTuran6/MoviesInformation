<%@page import="com.imdb.model.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Details App</title>
</head>
<body>
	<form action="./" method="post">
		<label>Search movies by name :</label>
		<input type="text" name="title"/>
		
		<input type="submit" value="See movie details">
	</form>
	<% 
		if (request.getAttribute("movie") != null) {
			Movie movie = (Movie)request.getAttribute("movie");
			String source = movie.getPosterURL();
	%>
		<img style="float:left" src = '<%="https://image.tmdb.org/t/p/w300"+source%>' vspace="20" hspace="20"/>
		<h1>  <%=movie.getTitle()%> </h1>
		<p> Released: <%=movie.getYear()%> </p>
		<p> Plot: <%=movie.getPlot()%> </p>
		<p> Vote count: <%=movie.getVote_count()%> </p>
		<p> Average vote: <%=movie.getVote_average()%> </p>	
		
		
		
			
			
	<% } %>
		
</body>
</html>