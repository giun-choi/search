package user.search.webkr.service;

import java.lang.reflect.Field;
import java.util.HashMap;

import base.utils.customVO;

public class WebkrVO implements customVO {

	private String query;
	private String display;
	private String start;
	
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
