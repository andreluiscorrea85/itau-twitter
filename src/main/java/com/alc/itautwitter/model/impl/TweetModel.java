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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity(name = "TWEET")
@Table(name = "TB002_TWEETS")
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
public class TweetModel
	extends AbstractItauTwitterModel<Long> {

	@Transient()
	@JsonIgnore()
	private static final long serialVersionUID = 6811392768972307426L;

	@JsonAlias("id")
	@Column(
		name = "AT002_STATUS_ID",
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
		name = "AT002_CREATED_AT",
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
		name = "AT002_TEXT",
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
		name = "AT002_LANGUAGE_LOCALE",
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
		name="FK002_001_USER_ID",
		nullable=false,
		insertable=true,
		updatable=true
	)
	private UserModel userModel;

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

	public TweetModel() {
		super();

		this.initObject();
	}

	public TweetModel(final Long id) {
		this();

		this.setId(id);
	}

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

	@Override()
	public Long getId() {
		return this.id;
	}

	@Override()
	public void setId(final Long id) {
		this.id = id;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(final Long statusId) {
		this.statusId = statusId;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return this.text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public String getLanguageLocale() {
		return this.languageLocale;
	}

	public void setLanguageLocale(final String languageLocale) {
		this.languageLocale = languageLocale;
	}

	public UserModel getUserModel() {
		return this.userModel;
	}

	public void setUserModel(final UserModel userModel) {
		this.userModel = userModel;
	}

	public Long getVersionOptimisticLock() {
		return this.versionOptimisticLock;
	}

	public void setVersionOptimisticLock(final Long versionOptimisticLock) {
		this.versionOptimisticLock = versionOptimisticLock;
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

	@Override()
	public TweetModel clone() throws CloneNotSupportedException {
		return ((TweetModel) super.clone());
	}

}
