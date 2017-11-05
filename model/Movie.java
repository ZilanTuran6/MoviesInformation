package com.imdb.model;

public class Movie {
	private String title;
	private String year;
	private String plot;
	private String poster_url;
	private int vote_count;
	private int vote_average;
	 
	

	public String getTitle() {
		return title;
	}

	public void getTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getPosterURL() {
		return poster_url;
	}

	public void setPosterURL(String poster_url) {
		this.poster_url = poster_url;
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public int getVote_average() {
		return vote_average;
	}

	public void setVote_average(int vote_average) {
		this.vote_average = vote_average;
	}

	public Movie(String title, String year, String plot, String poster_url, int vote_count, int vote_avarage) {
		super();
		this.title = title;
		this.year = year;
		this.plot = plot;
		this.poster_url = poster_url;
		this.vote_count = vote_count;
		this.vote_average = vote_avarage;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", plot=" + plot + ", poster_url=" + poster_url
				+ ", vote_count=" + vote_count + ", vote_avarage=" + vote_average + "]";
	}



	

	
}
