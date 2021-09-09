package user.search.client.service;

public class ClientVO {

	private String client_ip;
	private String menu;
	private String search_word;
	private String click_link;
	private String reg_date;
	
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getSearch_word() {
		return search_word;
	}
	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getClick_link() {
		return click_link;
	}
	public void setClick_link(String click_link) {
		this.click_link = click_link;
	}
	
}
