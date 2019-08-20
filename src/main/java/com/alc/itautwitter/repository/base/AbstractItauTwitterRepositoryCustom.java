package com.alc.itautwitter.repository.base;

import com.alc.itautwitter.exceptions.impl.ModelDuplicateException;
import com.alc.itautwitter.exceptions.impl.NullArgumentException;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The type Abstract itau twitter repository custom.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
@NoRepositoryBean()
public class AbstractItauTwitterRepositoryCustom<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Object
	implements ItauTwitterRepository<T, I> {

	private static final long serialVersionUID = 7468744982200993479L;

	/**
	 * The Entity manager.
	 */
	@PersistenceContext()
	protected EntityManager entityManager;

	protected Class<T> entityClass;

	protected Class<I> idClass;

	public AbstractItauTwitterRepositoryCustom() {
		super();

		this.getEntityClass();
		this.getIdClass();
	}

	protected Class<T> getEntityClass() {
		if (this.entityClass == null) {
			// Only works if one extends AbstractService, we will take care of it with CDI.
			this.entityClass = ((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		}

		return this.entityClass;
	}

	protected Class<I> getIdClass() {
		if (this.idClass == null) {
			// Only works if one extends AbstractService, we will take care of it with CDI.
			this.idClass = ((Class<I>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
		}

		return this.idClass;
	}

	protected Class<Long> getUidClassAsLong() {
		return ((Class<Long>) this.getIdClass());
	}

	/**
	 * Gets entity manager.
	 *
	 * @return the entity manager
	 */
	@Override()
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override()
	public List<T> findAll() {
		List<T> entityList;

		try {
			final var criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
			final var criteriaQuery = criteriaBuilder.createQuery(this.getEntityClass());
			final var root = criteriaQuery.from(this.getEntityClass());
			final var criteriaQuerySelect = criteriaQuery.select(root);

			final var typedQuery = this.getEntityManager().createQuery(criteriaQuerySelect);

			entityList = typedQuery.getResultList();
		}
		catch (final NoResultException exception) {
			exception.printStackTrace();

			entityList = null;
		}
		catch (final Exception exception) {
			exception.printStackTrace();

			entityList = null;
		}

		return entityList;
	}

	@Override()
	public Optional<T> findById(final I id) {
		if (! (ItauTwitterUtils.validateIdOfModel(id)) ) {
			throw new NullArgumentException("id");
		}

		T entity;

		try {
			entity = this.getEntityManager().find(this.getEntityClass(), id);
		}
		catch (final NoResultException exception1) {
			entity = null;
		}
		catch (final Exception exception2) {
			exception2.printStackTrace();

			entity = null;
		}

		return Optional.ofNullable(entity);
	}

	@Override()
	public T getOne(final I id) {
		return this.findById(id).orElse(null);
	}

	protected <S extends T> S persist(final S entity) {
		if (! (ItauTwitterUtils.validateModel(entity, false, false)) ) {
			throw new NullArgumentException("entity");
		}

		this.getEntityManager().persist(entity);

		return ((S) this.getOne(entity.getId()));
	}

	protected <S extends T> S merge(final S entity) {
		if (! (ItauTwitterUtils.validateModelWithId(entity)) ) {
			throw new NullArgumentException("entity");
		}

		return this.getEntityManager().merge(entity);
	}

	@Override()
	public <S extends T> S save(final S entity) {
		if (! (ItauTwitterUtils.validateModel(entity, false, false)) ) {
			throw new NullArgumentException("entity");
		}

		S newEntity;

		if (
			(ItauTwitterUtils.validateIdOfModel(entity.getId()))
		) {
			if (! (this.exists(entity)) ) {
				newEntity = this.merge(entity);
			}
			else {
				throw new ModelDuplicateException(this.getEntityClass());
			}
		}
		else {
			newEntity = this.persist(entity);
		}

		return newEntity;
	}

	@Override()
	public void delete(final T entity) {
		if (! (ItauTwitterUtils.validateModelWithId(entity)) ) {
			throw new NullArgumentException("entity");
		}

		this.getEntityManager().remove(entity);
	}

	@Override()
	public void deleteById(final I id) {
		if (! (ItauTwitterUtils.validateIdOfModel(id)) ) {
			throw new NullArgumentException("id");
		}

		var entity = this.getOne(id);

		if (ItauTwitterUtils.validateModelWithId(entity)) {
			this.delete(entity);
		}
	}

	protected <S extends T> boolean exists(final S entity) {
		if (! (ItauTwitterUtils.validateModelWithId(entity)) ) {
			throw new NullArgumentException("entity");
		}

		return this.existsById(entity.getId());
	}

	@Override()
	public boolean existsById(final I id) {
		var exists = false;

		if (! (ItauTwitterUtils.validateIdOfModel(id)) ) {
			throw new NullArgumentException("id");
		}

		final var entity = this.getOne(id);

		if (ItauTwitterUtils.validateModelWithId(entity)) {
			exists = true;
		}

		return exists;
	}

	@Override()
	public long count() {
		Long count;

		try {
			final var criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
			final var criteriaQuery = criteriaBuilder.createQuery(this.getUidClassAsLong());
			criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(this.getEntityClass())));

			final var typedQuery = this.getEntityManager().createQuery(criteriaQuery);

			count = typedQuery.getSingleResult();
		}
		catch (final Exception exception) {
			exception.printStackTrace();

			count = null;
		}

		return count;
	}

	@Override()
	public void flush() {
		this.getEntityManager().flush();
	}

	@Override()
	public <S extends T> S saveAndFlush(final S entity) {
		var newEntity =  this.save(entity);

		this.flush();

		return newEntity;
	}

	@Override()
	public List<T> findAllById(final Iterable<I> ids) {
		if (! (ItauTwitterUtils.validateIterable(ids)) ) {
			throw new NullArgumentException("ids");
		}

		List<T> entities = new ArrayList<>();

		for (var idItem : ids) {
			entities.add(this.getOne(idItem));
		}

		return entities;
	}

	@Override()
	public <S extends T> List<S> saveAll(final Iterable<S> entities) {
		if (! (ItauTwitterUtils.validateIterable(entities)) ) {
			throw new NullArgumentException("entities");
		}

		Set<I> ids = new HashSet<>();

		for (var entityItem : entities) {
			this.save(entityItem);

			ids.add(entityItem.getId());
		}

		return ((List<S>) this.findAllById(ids));
	}

	@Override()
	public void deleteAll() {
		var entities = this.findAll();

		if (ItauTwitterUtils.validateIterable(entities)) {
			for (var entityItem : entities) {
				this.delete(entityItem);
			}
		}
	}

	//----------------------



	@Override()
	public void deleteAll(final Iterable<? extends T> entities) {
		throw  new RuntimeException();
	}

	@Override()
	public void deleteInBatch(final Iterable<T> entities) {
		throw  new RuntimeException();
	}

	@Override()
	public void deleteAllInBatch() {
		throw  new RuntimeException();
	}

	//----------------------

	@Override()
	public List<T> findAll(final Sort sort) {
		throw  new RuntimeException();
	}

	@Override()
	public Page<T> findAll(final Pageable pageable) {
		throw  new RuntimeException();
	}

	@Override()
	public <S extends T> List<S> findAll(final Example<S> example) {
		throw  new RuntimeException();
	}

	@Override()
	public <S extends T> List<S> findAll(final Example<S> example, final Sort sort) {
		throw  new RuntimeException();
	}

	@Override()
	public <S extends T> Page<S> findAll(final Example<S> example, final Pageable pageable) {
		throw  new RuntimeException();
	}

	@Override()
	public <S extends T> Optional<S> findOne(final Example<S> example) {
		return Optional.empty();
	}

	@Override()
	public <S extends T> boolean exists(final Example<S> example) {
		throw  new RuntimeException();
	}

	@Override()
	public <S extends T> long count(final Example<S> example) {
		throw  new RuntimeException();
	}

}