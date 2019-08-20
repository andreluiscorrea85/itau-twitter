package com.alc.itautwitter.model.base;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Abstract itau twitter model.
 *
 * @param <I> the type parameter
 */
@MappedSuperclass()
@Access(value = AccessType.FIELD)
public abstract class AbstractItauTwitterModel<I extends Serializable>
	extends Object
	implements ItauTwitterModel<I> {

	@Transient()
	@JsonIgnore()
	private static final long serialVersionUID = 8905497437209117978L;

	/**
	 * The Id class.
	 */
	@Transient()
	@JsonIgnore()
	protected Class<I> idClass;

	/**
	 * The Id.
	 */
	@JsonIgnore()
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected I id;

	/**
	 * The Creation date time.
	 */
	@JsonIgnore()
	protected LocalDateTime creationDateTime;

	/**
	 * Instantiates a new Abstract itau twitter model.
	 */
	public AbstractItauTwitterModel() {
		super();

		this.initObject();
	}

	/**
	 * Instantiates a new Abstract itau twitter model.
	 *
	 * @param id the id
	 */
	public AbstractItauTwitterModel(final I id) {
		this();

		this.setId(id);
	}

	/**
	 * Init object.
	 */
	protected void initObject() {
		this.createIdClass();

		this.setId(null);
		this.setCreationDateTime(LocalDateTime.now());
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	@Override()
	public I getId() {
		return this.id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	@Override()
	public void setId(final I id) {
		this.id = id;
	}

	/**
	 * Gets creation date time.
	 *
	 * @return the creation date time
	 */
	@Override()
	public LocalDateTime getCreationDateTime() {
		return this.creationDateTime;
	}

	/**
	 * Sets creation date time.
	 *
	 * @param creationDateTime the creation date time
	 */
	@Override()
	public void setCreationDateTime(final LocalDateTime creationDateTime) {
		if (this.creationDateTime == null) {
			this.creationDateTime = (
				(creationDateTime != null)
					? creationDateTime
					: LocalDateTime.now()
			);
		}
	}

	/**
	 * Create id class.
	 */
	@JsonIgnore()
	protected void createIdClass() {
		try {
			if (! (Objects.nonNull(this.idClass)) ) {
				this.setIdClass(
					(Class<I>) (
						(ParameterizedType) this.getClass().getGenericSuperclass()
					).getActualTypeArguments()[0]
				);
			}

			if (! (Objects.nonNull(this.idClass)) ) {
				this.setIdClass(ItauTwitterUtils.createDefaultIdClass());
			}
		}
		catch (final Exception exception) {
			if (! (Objects.nonNull(this.idClass)) ) {
				this.setIdClass(ItauTwitterUtils.createDefaultIdClass());
			}
		}
	}

	/**
	 * Gets id class.
	 *
	 * @return the id class
	 */
	@Override()
	public Class<I> getIdClass() {
		if (! (Objects.nonNull(this.idClass)) ) {
			this.createIdClass();
		}

		return this.idClass;
	}

	/**
	 * Sets id class.
	 *
	 * @param idClass the id class
	 */
	protected void setIdClass(final Class<I> idClass) {
		this.idClass = idClass;
	}

	/**
	 * Gets id as long.
	 *
	 * @return the id as long
	 */
	@Override()
	@JsonIgnore()
	public Long getIdAsLong() {
		return ItauTwitterUtils.getIdAsLong(this.getId());
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

		hashCode = (
			(prime * hashCode) +
			(Objects.hash(this.getId()))
		);

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
		final boolean equals;

		if (this == object) {
			equals = true;
		}
		else if (object == null) {
			equals = false;
		}
		else if (! (object instanceof AbstractItauTwitterModel<?>) ) {
			equals = false;
		}
		else {
			final var otherObject = (AbstractItauTwitterModel<?>) object;

			equals = Objects.equals(this.getId(), otherObject.getId());
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
		stringBuilder.append(		"]"							);

		return stringBuilder.toString();
	}

	/**
	 * Clone abstract itau twitter model.
	 *
	 * @return the abstract itau twitter model
	 *
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	@Override()
	public AbstractItauTwitterModel<?> clone() throws CloneNotSupportedException {
		return (AbstractItauTwitterModel<?>) super.clone();
	}

	/**
	 * Compare to int.
	 *
	 * @param object the object
	 *
	 * @return the int
	 */
	@Override()
	public int compareTo(final ItauTwitterModel<I> object) {
		final int compare;

		if (
			(Objects.nonNull(object)) &&
			(object instanceof AbstractItauTwitterModel<?>)
		) {
			final var newObject = (AbstractItauTwitterModel<?>) object;

			if (Objects.nonNull(this.getId())) {
				compare = (
					(Objects.nonNull(newObject.getId()))
						? (this.getIdAsLong()).compareTo(newObject.getIdAsLong())
						: 1
				);
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
