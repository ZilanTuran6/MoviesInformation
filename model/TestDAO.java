package com.imdb.model;

import org.junit.Test;

public class TestDAO {

	@Test
	public void test() throws MovieException {
		System.out.println(new MovieDAO().getMovieByTitle("hobbit"));
	}

}
