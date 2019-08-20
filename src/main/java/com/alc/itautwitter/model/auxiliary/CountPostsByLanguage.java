package com.alc.itautwitter.model.auxiliary;

/**
 * The type Count posts by language.
 */
public final class CountPostsByLanguage {

	private Long count;

	private String language;

	/**
	 * Instantiates a new Count posts by language.
	 */
	public CountPostsByLanguage() {
		super();
	}

	/**
	 * Instantiates a new Count posts by language.
	 *
	 * @param count    the count
	 * @param language the language
	 */
	public CountPostsByLanguage(final Long count, final String language) {
		this();

		this.count = count;
		this.language = language;
	}

	/**
	 * Gets count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return this.count;
	}

	/**
	 * Sets count.
	 *
	 * @param count the count
	 */
	public void setCount(final Long count) {
		this.count = count;
	}

	/**
	 * Gets language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Sets language.
	 *
	 * @param language the language
	 */
	public void setLanguage(final String language) {
		this.language = language;
	}

}
