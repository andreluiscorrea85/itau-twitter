package com.alc.itautwitter.model.impl;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.base.AbstractItauTwitterModel;
import com.alc.itautwitter.model.base.ItauTwitterModel;
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
import java.util.Objects;

/**
 * The type User model.
 */
@Entity(name = "USER")
@Table(name = "TB002_USERS")
@Access(value = AccessType.FIELD)
@AttributeOverrides(
	value = {
		@AttributeOverride(
			name = "id",
			column = @Column(
				name = "PK002_ID",
				length = 30,
				nullable = false,
				insertable = false,
				updatable = false
			)
		),
		@AttributeOverride(
			name = "creationDateTime",
			column = @Column(
				name = "AT002_CREATION_DATE_TIME",
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
		name = "AT002_USER_ID",
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
		name = "AT002_SCREEN_NAME",
		length = 250,
		nullable = false,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = false
	)
	private String screenName;

	@JsonAlias("followersCount")
	@Column(
		name = "AT002_FOLLOWERS_COUNT",
		nullable = false,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch = FetchType.EAGER,
		optional = false
	)
	private Integer followersCount;

	@JsonAlias("lang")
	@Column(
		name = "AT002_LANGUAGE_LOCALE",
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
		name = "AT002_VERSION_OPTIMISTIC_LOCK",
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

	/**
	 * Instantiates a new User model.
	 */
	public UserModel() {
		super();

		this.initObject();
	}

	/**
	 * Init object.
	 */
	@Override()
	protected void initObject() {
		this.setTweetModelList(new ArrayList<>());
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param id the id
	 */
	public UserModel(final Long id) {
		this();

		this.setId(id);
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param id             the id
	 * @param userId         the user id
	 * @param screenName     the screen name
	 * @param followersCount the followers count
	 */
	public UserModel(
		final Long id,
		final Long userId,
		final String screenName,
		final Integer followersCount
	) {
		this(id);

		this.setUserId(userId);
		this.setScreenName(screenName);
		this.setFollowersCount(followersCount);
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param id             the id
	 * @param userId         the user id
	 * @param screenName     the screen name
	 * @param followersCount the followers count
	 * @param languageLocale the language locale
	 */
	public UserModel(
		final Long id,
		final Long userId,
		final String screenName,
		final Integer followersCount,
		final String languageLocale
	) {
		this(id, userId, screenName, followersCount);

		this.setLanguageLocale(languageLocale);
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param id             the id
	 * @param userId         the user id
	 * @param screenName     the screen name
	 * @param followersCount the followers count
	 * @param languageLocale the language locale
	 * @param tweetModelList the tweet model list
	 */
	public UserModel(
		final Long id,
		final Long userId,
		final String screenName,
		final Integer followersCount,
		final String languageLocale,
		final List<TweetModel> tweetModelList
	) {
		this(id, userId, screenName, followersCount, languageLocale);

		this.setTweetModelList(tweetModelList);
	}

	/**
	 * Gets user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * Sets user id.
	 *
	 * @param userId the user id
	 */
	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets screen name.
	 *
	 * @return the screen name
	 */
	public String getScreenName() {
		return this.screenName;
	}

	/**
	 * Sets screen name.
	 *
	 * @param screenName the screen name
	 */
	public void setScreenName(final String screenName) {
		this.screenName = screenName;
	}

	/**
	 * Gets followers count.
	 *
	 * @return the followers count
	 */
	public Integer getFollowersCount() {
		return this.followersCount;
	}

	/**
	 * Sets followers count.
	 *
	 * @param followersCount the followers count
	 */
	public void setFollowersCount(final Integer followersCount) {
		this.followersCount = followersCount;
	}

	/**
	 * Gets language locale.
	 *
	 * @return the language locale
	 */
	public String getLanguageLocale() {
		return this.languageLocale;
	}

	/**
	 * Sets language locale.
	 *
	 * @param languageLocale the language locale
	 */
	public void setLanguageLocale(final String languageLocale) {
		this.languageLocale = languageLocale;
	}

	/**
	 * Gets tweet model list.
	 *
	 * @return the tweet model list
	 */
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

	/**
	 * Add tweet model list.
	 *
	 * @param tweetModel the tweet model
	 */
	public final void addTweetModelList(final TweetModel tweetModel) {
		this.tweetModelList.add(tweetModel);
	}

	/**
	 * Remove tweet model list.
	 *
	 * @param tweetModel the tweet model
	 */
	public final void removeTweetModelList(final TweetModel tweetModel) {
		this.tweetModelList.remove(tweetModel);
	}

	/**
	 * Add all tweet model list.
	 *
	 * @param tweetModelList the tweet model list
	 */
	public final void addAllTweetModelList(final List<TweetModel> tweetModelList) {
		this.tweetModelList.addAll(tweetModelList);
	}

	/**
	 * Remove all tweet model list.
	 *
	 * @param tweetModelList the tweet model list
	 */
	public final void removeAllTweetModelList(final List<TweetModel> tweetModelList) {
		this.tweetModelList.removeAll(tweetModelList);
	}

	/**
	 * Gets version optimistic lock.
	 *
	 * @return the version optimistic lock
	 */
	public Long getVersionOptimisticLock() {
		return this.versionOptimisticLock;
	}

	/**
	 * Sets version optimistic lock.
	 *
	 * @param versionOptimisticLock the version optimistic lock
	 */
	public void setVersionOptimisticLock(final Long versionOptimisticLock) {
		this.versionOptimisticLock = versionOptimisticLock;
	}

	/**
	 * Gets formatted user screen name.
	 *
	 * @return the formatted user screen name
	 */
	public String getFormattedUserScreenName() {
		return (
			(ItauTwitterUtils.validateString(this.getScreenName()))
				? "@" + this.getScreenName().trim()
				: null
		);
	}

	/**
	 * Gets locale.
	 *
	 * @return the locale
	 */
	public Locale getLocale() {
		return ItauTwitterUtils.getLocale(this.getLanguageLocale());
	}

	/**
	 * Gets language name.
	 *
	 * @return the language name
	 */
	public String getLanguageName() {
		return ItauTwitterUtils.getLanguageName(this.getLanguageLocale());
	}

	/**
	 * Hash code int.
	 *
	 * @return the int
	 */
	@Override()
	public int hashCode() {
		Integer hashCode;

		final Integer prime = 31;

		hashCode = super.hashCode();

		hashCode = ((prime * hashCode) + (Objects.hash(this.getUserId())));
		hashCode = ((prime * hashCode) + (Objects.hash(this.getScreenName())));

		return hashCode;
	}

	/**
	 * Equals boolean.
	 *
	 * @param object the object
	 *
	 * @return the boolean
	 */
	@Override()
	public boolean equals(final Object object) {
		boolean equals;

		if (this == object) {
			equals = true;
		}
		else if (object == null) {
			equals = false;
		}
		else if (! (object instanceof UserModel) ) {
			equals = false;
		}
		else {
			final var otherObject = (UserModel) object;

			if (! (this.getUserId().equals(otherObject.getUserId()))) {
				equals = false;
			}

			equals = this.getScreenName().equalsIgnoreCase(otherObject.getScreenName());
		}

		return equals;
	}

	/**
	 * To string string.
	 *
	 * @return the string
	 */
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

	/**
	 * Clone user model.
	 *
	 * @return the user model
	 *
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	@Override()
	public UserModel clone() throws CloneNotSupportedException {
		return ((UserModel) super.clone());
	}

	/**
	 * Compare to int.
	 *
	 * @param object the object
	 *
	 * @return the int
	 */
	@Override()
	public int compareTo(final ItauTwitterModel<Long> object) {
		int compare;

		if (
			(Objects.nonNull(object)) &&
			(object instanceof UserModel)
		) {
			final var newObject = (UserModel) object;

			if (Objects.nonNull(this.getId())) {
				compare = (
					(Objects.nonNull(newObject.getId()))
						? (this.getIdAsLong()).compareTo(newObject.getIdAsLong())
						: 1
				);

				if (compare == 0) {
					compare = (
						(Objects.nonNull(newObject.getUserId()))
							? (this.getUserId()).compareTo(newObject.getUserId())
							: 1
					);

					if (compare == 0) {
						compare = (
							(Objects.nonNull(newObject.getScreenName()))
								? (this.getScreenName()).compareToIgnoreCase(newObject.getScreenName())
								: 1
						);
					}
				}
			}
			else if (Objects.nonNull(newObject.getId())) {
				compare = -1;
			}
			else {
				compare = 0;
			}
		}
		else {
			compare = 1;
		}

		return compare;
	}

}
