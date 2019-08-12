package com.alc.itautwitter.model.auxiliary;

public final class CountPostsByLanguage {

	private Long count;

	private String language;

	public CountPostsByLanguage() {
		super();
	}

	public CountPostsByLanguage(final Long count, final String language) {
		this();

		this.count = count;
		this.language = language;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(final Long count) {
		this.count = count;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}

}
