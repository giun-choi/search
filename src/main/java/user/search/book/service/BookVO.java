package user.search.book.service;

import java.lang.reflect.Field;
import java.util.HashMap;

import base.utils.customVO;

public class BookVO implements customVO {

	private String query;
	private String display;
	private String start;
	private String sort;
	private String d_titl;
	private String d_auth;
	private String d_cont;
	private String d_isbn;
	private String d_publ;
	private String d_dafr;
	private String d_dato;
	private String d_catg;
	
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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getD_titl() {
		return d_titl;
	}
	public void setD_titl(String d_titl) {
		this.d_titl = d_titl;
	}
	public String getD_auth() {
		return d_auth;
	}
	public void setD_auth(String d_auth) {
		this.d_auth = d_auth;
	}
	public String getD_cont() {
		return d_cont;
	}
	public void setD_cont(String d_cont) {
		this.d_cont = d_cont;
	}
	public String getD_isbn() {
		return d_isbn;
	}
	public void setD_isbn(String d_isbn) {
		this.d_isbn = d_isbn;
	}
	public String getD_publ() {
		return d_publ;
	}
	public void setD_publ(String d_publ) {
		this.d_publ = d_publ;
	}
	public String getD_dafr() {
		return d_dafr;
	}
	public void setD_dafr(String d_dafr) {
		this.d_dafr = d_dafr;
	}
	public String getD_dato() {
		return d_dato;
	}
	public void setD_dato(String d_dato) {
		this.d_dato = d_dato;
	}
	public String getD_catg() {
		return d_catg;
	}
	public void setD_catg(String d_catg) {
		this.d_catg = d_catg;
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
