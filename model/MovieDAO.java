package com.imdb.model;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MovieDAO {

	public Movie getMovieByTitle(String title) throws MovieException {
		HttpURLConnection connection = null;
		// id = id.replace(' ', '+');
		title = title.replace(' ', '+');
		try {
			// connection = (HttpURLConnection) new
			// URL("https://api.themoviedb.org/3/movie/"+id+"?api_key=e05bb759732e132c3b80e97ce46ea76f")
			// .openConnection();

			connection = (HttpURLConnection) new URL(
					"https://api.themoviedb.org/3/search/movie?api_key=e05bb759732e132c3b80e97ce46ea76f&language=en-US&query="
							+ title).openConnection();

			connection.connect();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

				try (BufferedInputStream bis = new BufferedInputStream(connection.getInputStream())) {
					byte[] bytes = new byte[connection.getContentLength()];

					bis.read(bytes);

					String json = new String(bytes, "UTF-8");

					 //JsonObject object = (JsonObject) new JsonParser().parse(json);
					 //JsonArray results = object.getAsJsonArray("results");
					
					JSONObject object = new JSONObject(json);
					JSONArray results = object.getJSONArray("results");

					//System.out.println(object);
					//System.out.println(results);

					for (int index = 0; index < results.length(); index++)

					{

						JSONObject objects = results.getJSONObject(index);

						String movieName = objects.getString("title");
						String year =  objects.getString("release_date");
						String plot =  objects.getString("overview");
						String poster_url = objects.getString("poster_path");
						int vote_count = objects.getInt("vote_count");
						int vote_average = objects.getInt("vote_average");

						return new Movie(movieName, year, plot, poster_url, vote_count, vote_average);
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieException(e.getMessage());
		} finally {
			connection.disconnect();
		}
		return null;
	}
}
