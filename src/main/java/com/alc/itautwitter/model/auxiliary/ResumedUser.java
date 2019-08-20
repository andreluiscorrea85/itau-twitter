package com.alc.itautwitter.model.auxiliary;

/**
 * The type Count posts by created at hour.
 */
public final class ResumedUser {

	private Long userId;

	private String screenName;

	private Integer followersCount;

	private String languageLocale;

	/**
	 * Instantiates a new Count posts by created at hour.
	 */
	public ResumedUser() {
		super();
	}

	public ResumedUser(
		final Long userId,
		final String screenName,
		final Integer followersCount,
		final String languageLocale
	) {
		this();

		this.userId = userId;
		this.screenName = screenName;
		this.followersCount = followersCount;
		this.languageLocale = languageLocale;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(final String screenName) {
		this.screenName = screenName;
	}

	public Integer getFollowersCount() {
		return this.followersCount;
	}

	public void setFollowersCount(final Integer followersCount) {
		this.followersCount = followersCount;
	}

	public String getLanguageLocale() {
		return this.languageLocale;
	}

	public void setLanguageLocale(final String languageLocale) {
		this.languageLocale = languageLocale;
	}

}
