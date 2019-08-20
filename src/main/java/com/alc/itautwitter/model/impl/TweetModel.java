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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

/**
 * The type Tweet model.
 */
@Entity(name = "TWEET")
@Table(name = "TB003_TWEETS")
@Access(value = AccessType.FIELD)
@AttributeOverrides(
	value = {
		@AttributeOverride(
			name = "id",
			column = @Column(
				name = "PK003_ID",
				length = 30,
				nullable = false,
				insertable = false,
				updatable = false
			)
		),
		@AttributeOverride(
			name = "creationDateTime",
			column = @Column(
				name = "AT003_CREATION_DATE_TIME",
				nullable = false,
				insertable = true,
				updatable = false
			)
		)
	}
)
public class TweetModel
	extends AbstractItauTwitterModel<Long> {

	@Transient()
	@JsonIgnore()
	private static final long serialVersionUID = 6811392768972307426L;

	@JsonAlias("id")
	@Column(
		name = "AT003_STATUS_ID",
		nullable = false,
		insertable = true,
		updatable = true,
		unique = true
	)
	@Basic(
		fetch= FetchType.EAGER,
		optional=false
	)
	private Long statusId;

	@JsonAlias("createdAt")
	@Column(
		name = "AT003_CREATED_AT",
		nullable = false,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch= FetchType.EAGER,
		optional=false
	)
	private LocalDateTime createdAt;

	@JsonAlias("text")
	@Column(
		name = "AT003_TEXT",
		length = 500,
		nullable = false,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch= FetchType.EAGER,
		optional=false
	)
	private String text;

	@JsonAlias("lang")
	@Column(
		name = "AT003_LANGUAGE_LOCALE",
		length = 5,
		nullable = true,
		insertable = true,
		updatable = true,
		unique = false
	)
	@Basic(
		fetch= FetchType.EAGER,
		optional=true
	)
	private String languageLocale;

	@ManyToOne(
		cascade= {
			CascadeType.REFRESH,
			CascadeType.DETACH
		},
		fetch = FetchType.EAGER,
		optional = false
	)
	@JoinColumn(
		name="FK003_002_USER_ID",
		nullable=false,
		insertable=true,
		updatable=true
	)
	private UserModel userModel;

	@Version()
	@Column(
		name = "AT003_VERSION_OPTIMISTIC_LOCK",
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
	 * Instantiates a new Tweet model.
	 */
	public TweetModel() {
		super();

		this.initObject();
	}

	/**
	 * Instantiates a new Tweet model.
	 *
	 * @param id the id
	 */
	public TweetModel(final Long id) {
		this();

		this.setId(id);
	}

	/**
	 * Instantiates a new Tweet model.
	 *
	 * @param id        the id
	 * @param statusId  the status id
	 * @param createdAt the created at
	 * @param text      the text
	 */
	public TweetModel(
		final Long id,
		final Long statusId,
		final LocalDateTime createdAt,
		final String text
	) {
		this(id);

		this.setStatusId(statusId);
		this.setCreatedAt(createdAt);
		this.setText(text);
	}

	/**
	 * Instantiates a new Tweet model.
	 *
	 * @param id             the id
	 * @param statusId       the status id
	 * @param createdAt      the created at
	 * @param text           the text
	 * @param languageLocale the language locale
	 */
	public TweetModel(
		final Long id,
		final Long statusId,
		final LocalDateTime createdAt,
		final String text,
		final String languageLocale
	) {
		this(id, statusId, createdAt, text);

		this.setLanguageLocale(languageLocale);
	}

	/**
	 * Instantiates a new Tweet model.
	 *
	 * @param id             the id
	 * @param statusId       the status id
	 * @param createdAt      the created at
	 * @param text           the text
	 * @param languageLocale the language locale
	 * @param userModel      the user model
	 */
	public TweetModel(
		final Long id,
		final Long statusId,
		final LocalDateTime createdAt,
		final String text,
		final String languageLocale,
		final UserModel userModel
	) {
		this(id, statusId, createdAt, text, languageLocale);

		this.setUserModel(userModel);
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	@Override()
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	@Override()
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return this.statusId;
	}

	/**
	 * Sets status id.
	 *
	 * @param statusId the status id
	 */
	public void setStatusId(final Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets created at.
	 *
	 * @return the created at
	 */
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	/**
	 * Sets created at.
	 *
	 * @param createdAt the created at
	 */
	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets text.
	 *
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Sets text.
	 *
	 * @param text the text
	 */
	public void setText(final String text) {
		this.text = text;
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
	 * Gets user model.
	 *
	 * @return the user model
	 */
	public UserModel getUserModel() {
		return this.userModel;
	}

	/**
	 * Sets user model.
	 *
	 * @param userModel the user model
	 */
	public void setUserModel(final UserModel userModel) {
		this.userModel = userModel;
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

		hashCode = ((prime * hashCode) + (Objects.hash(this.getStatusId())));

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
		else if (! (object instanceof TweetModel) ) {
			equals = false;
		}
		else {
			final var otherObject = (TweetModel) object;

			equals = this.getStatusId().equals(otherObject.getStatusId());
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

		stringBuilder.append(	this.getClass().getSimpleName()		);
		stringBuilder.append(		"["								);
		stringBuilder.append(			"id="						);
		stringBuilder.append(			this.getId()				);
		stringBuilder.append(			", "						);
		stringBuilder.append(			"statuId="					);
		stringBuilder.append(			this.getStatusId()			);
		stringBuilder.append(			", "						);
		stringBuilder.append(			"createdAt="				);
		stringBuilder.append(			this.getCreatedAt()			);
		stringBuilder.append(			", "						);
		stringBuilder.append(			"text="						);
		stringBuilder.append(			this.getText()				);
		stringBuilder.append(		"]"								);

		return stringBuilder.toString();
	}

	/**
	 * Clone tweet model.
	 *
	 * @return the tweet model
	 *
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	@Override()
	public TweetModel clone() throws CloneNotSupportedException {
		return ((TweetModel) super.clone());
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
			(object instanceof TweetModel)
		) {
			final var newObject = (TweetModel) object;

			if (Objects.nonNull(this.getId())) {
				compare = (
					(Objects.nonNull(newObject.getId()))
						? (this.getIdAsLong()).compareTo(newObject.getIdAsLong())
						: 1
				);

				if (compare == 0) {
					compare = (
						(Objects.nonNull(newObject.getStatusId()))
							? (this.getStatusId()).compareTo(newObject.getStatusId())
							: 1
					);
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
