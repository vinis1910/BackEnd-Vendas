package br.com.slloww.sa.enums;

public enum Profiles {
	SELLER(1, "ROLE_SELLER"), CUSTOMER(2, "ROLE_CUSTOMER");

	private Integer code;
	private String desc;

	private Profiles() {

	}

	private Profiles(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static Profiles valueOf(int codigo) {
		for (Profiles value : Profiles.values()) {
			if (value.getCode() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid perfil code");
	}
	
	public static Profiles toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Profiles x : Profiles.values()) {
			if(cod.equals(x.getCode())){
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}

}
