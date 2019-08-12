package com.alc.itautwitter.model.impl;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.base.AbstractItauTwitterModel;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Entity(name = "USER")
@Table(name = "TB001_USERS")
@Access(value = AccessType.FIELD)
@AttributeOverrides(
	value = {
		@AttributeOverride(
			name = "id",
			column = @Column(
				name = "PK001_ID",
				length = 30,
				nullable = false,
				insertable = false,
				updatable = false
			)
		),
		@AttributeOverride(
			name = "creationDateTime",
			column = @Column(
				name = "AT001_CREATION_DATE_TIME",
				nullable = false,
				insertable = true,
				updatable = false
			)
		)
	}
)
public class UserModel
	extends AbstractItauTwitterModel<Long> {

	@Transient()
	@JsonIgnore()
	private static final long serialVersionUID = -5626604775312152242L;

	@JsonAlias("id")
	@Column(
		name = "AT001_USER_ID",
		nullable = false,
		insertable = true,
		updatable = true,
		unique = true
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = false
	)
	private Long userId;

	@JsonAlias("screenName")
	@Column(
		name = "AT001_SCREEN_NAME",
		length = 250,
		nullable = false,
		insertable = true,
		updatable = true,
		unique = true
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = false
	)
	private String screenName;

	@JsonAlias("followersCount")
	@Column(
		name = "AT001_FOLLOWERS_COUNT",
		length = 30,
		nullable = false,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = false
	)
	private long followersCount;

	@JsonAlias("lang")
	@Column(
		name = "AT001_LANGUAGE_LOCALE",
		length = 5,
		nullable = true,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = true
	)
	private String languageLocale;

	@OneToMany(
		cascade = {
			CascadeType.REFRESH,
			CascadeType.DETACH
		},
		fetch=FetchType.EAGER,
		mappedBy = "userModel"
	)
	private List<TweetModel> tweetModelList;

	@Version()
	@Column(
		name = "AT001_VERSION_OPTIMISTIC_LOCK",
		length = 30,
		nullable = false,
		insertable = true,
		updatable = true
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = false
	)
	private Long versionOptimisticLock;

	public UserModel() {
		super();

		this.initObject();
	}

	@Override()
	protected void initObject() {
		this.setTweetModelList(new ArrayList<>());
	}

	public UserModel(final Long id) {
		this();

		this.setId(id);
	}

	public UserModel(
		final Long id,
		final Long userId,
		final String screenName,
		final long followersCount
	) {
		this(id);

		this.setUserId(userId);
		this.setScreenName(screenName);
		this.setFollowersCount(followersCount);
	}

	public UserModel(
		final Long id,
		final Long userId,
		final String screenName,
		final long followersCount,
		final String languageLocale
	) {
		this(id, userId, screenName, followersCount);

		this.setLanguageLocale(languageLocale);
	}

	public UserModel(
		final Long id,
		final Long userId,
		final String screenName,
		final long followersCount,
		final String languageLocale,
		final List<TweetModel> tweetModelList
	) {
		this(id, userId, screenName, followersCount, languageLocale);

		this.setTweetModelList(tweetModelList);
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

	public long getFollowersCount() {
		return this.followersCount;
	}

	public void setFollowersCount(final long followersCount) {
		this.followersCount = followersCount;
	}

	public String getLanguageLocale() {
		return this.languageLocale;
	}

	public void setLanguageLocale(final String languageLocale) {
		this.languageLocale = languageLocale;
	}

	public List<TweetModel> getTweetModelList() {
		return Collections.unmodifiableList(this.tweetModelList);
	}

	private void setTweetModelList(final List<TweetModel> tweetModelList) {
		this.tweetModelList = (
			(tweetModelList != null)
				? tweetModelList
				: new ArrayList<>()
		);
	}

	public final void addTweetModelList(final TweetModel tweetModel) {
		this.tweetModelList.add(tweetModel);
	}

	public final void removeTweetModelList(final TweetModel tweetModel) {
		this.tweetModelList.remove(tweetModel);
	}

	public final void addAllTweetModelList(final List<TweetModel> tweetModelList) {
		this.tweetModelList.addAll(tweetModelList);
	}

	public final void removeAllTweetModelList(final List<TweetModel> tweetModelList) {
		this.tweetModelList.removeAll(tweetModelList);
	}

	public Long getVersionOptimisticLock() {
		return this.versionOptimisticLock;
	}

	public void setVersionOptimisticLock(final Long versionOptimisticLock) {
		this.versionOptimisticLock = versionOptimisticLock;
	}

	public String getFormattedUserScreenName() {
		return (
			(ItauTwitterUtils.validateString(this.getScreenName()))
				? "@" + this.getScreenName().trim()
				: null
		);
	}

	public Locale getLocale() {
		return ItauTwitterUtils.getLocale(this.getLanguageLocale());
	}

	public String getLanguageName() {
		return ItauTwitterUtils.getLanguageName(this.getLanguageLocale());
	}

	@Override()
	public String toString() {
		final var stringBuilder = new StringBuilder();

		stringBuilder.append(	this.getClass().getSimpleName()	);
		stringBuilder.append(		"["							);
		stringBuilder.append(			"id="					);
		stringBuilder.append(			this.getId()			);
		stringBuilder.append(			", "					);
		stringBuilder.append(			"screenName="			);
		stringBuilder.append(			this.getScreenName()	);
		stringBuilder.append(		"]"							);

		return stringBuilder.toString();
	}

	@Override()
	public UserModel clone() throws CloneNotSupportedException {
		return ((UserModel) super.clone());
	}

}
