package co.com.gaslissa.common.dto;

public class Usuario {
	
	private String usuario;
	
	private String pwd;
	
	private boolean admin;

	public Usuario() {
	}

	/**
	 * @param usuario
	 * @param pwd
	 * @param admin
	 */
	public Usuario(String usuario, String pwd, boolean admin) {
		super();
		this.usuario = usuario;
		this.pwd = pwd;
		this.admin = admin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
