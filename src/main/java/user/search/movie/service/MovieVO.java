package user.search.movie.service;

import java.lang.reflect.Field;
import java.util.HashMap;

import base.utils.customVO;

public class MovieVO implements customVO {

	private String query;
	private String display;
	private String start;
	private String genre;
	private String country;
	private String yearfrom;
	private String yearto;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getYearfrom() {
		return yearfrom;
	}
	public void setYearfrom(String yearfrom) {
		this.yearfrom = yearfrom;
	}
	public String getYearto() {
		return yearto;
	}
	public void setYearto(String yearto) {
		this.yearto = yearto;
	}

	@Override
	public HashMap<String, String> getSearchKeywords() {
		
		Field[] fields = this.getClass().getDeclaredFields();
		HashMap<String, String> query_string = new HashMap<String, String>();
		
		for(int i=0; i<fields.length; i++) {
			
			try {
				if((String)fields[i].get(this) != null) {
					query_string.put(fields[i].getName(), (String)fields[i].get(this));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return query_string;
	}
	
}
