package br.com.slloww.sa.enums;

public enum Categories {

	ELETRONIC(1, "ELETRONIC_CAT"), BOOK(2, "BOOK_CAT"), COMPUTER(3, "COMPUTER_CAT");

	private Integer code;
	private String desc;

	private Categories() {

	}

	private Categories(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static Categories valueOf(int code) {
		for (Categories value : Categories.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid perfil code");
	}
}
