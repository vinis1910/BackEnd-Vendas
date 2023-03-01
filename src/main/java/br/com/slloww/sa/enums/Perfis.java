package br.com.slloww.sa.enums;

public enum Perfis {
	ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE");

	private Integer code;
	private String desc;

	private Perfis() {

	}

	private Perfis(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static Perfis valueOf(int codigo) {
		for (Perfis value : Perfis.values()) {
			if (value.getCode() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid perfil code");
	}
}
