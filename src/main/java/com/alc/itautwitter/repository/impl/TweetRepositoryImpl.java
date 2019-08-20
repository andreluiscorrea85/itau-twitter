package com.alc.itautwitter.repository.impl;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.repository.base.AbstractItauTwitterRepositoryCustom;
import com.alc.itautwitter.repository.interfaces.TweetRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Tweet repository.
 */
@Repository()
public class TweetRepositoryImpl
	extends AbstractItauTwitterRepositoryCustom<TweetModel, Long>
	implements TweetRepositoryCustom {

	private static final long serialVersionUID = -666943504397076955L;

	/**
	 * Instantiates a new Tweet repository.
	 *
	 * @param entityManager the entity manager
	 */
	public TweetRepositoryImpl(final EntityManager entityManager) {
		super(entityManager);
	}

	/**
	 * Gets total posts group by created at hour.
	 *
	 * @return the total posts group by created at hour
	 */
	@Override()
	public List<CountPostsByCreatedAtHour> getTotalPostsGroupByCreatedAtHour() {
		List<CountPostsByCreatedAtHour> countPostsByCreatedAtHourList;

		final var stringBuilder = new StringBuilder();

		stringBuilder.append(	" SELECT " 								).append(" \n");
		stringBuilder.append(		" t.createdAt AS createdAtHour, " 	).append(" \n");
		stringBuilder.append(		" COUNT(t) AS total " 				).append(" \n");
		stringBuilder.append(	" FROM " 								).append(" \n");
		stringBuilder.append(		" TweetModel AS t " 				).append(" \n");
		stringBuilder.append(	" GROUP BY " 							).append(" \n");
		stringBuilder.append(		" t.createdAt " 				).append(" \n");
		stringBuilder.append(	" ORDER BY " 							).append(" \n");
		stringBuilder.append(		" t.createdAt DESC " 			).append(" \n");

		List<Object[]> results = this.getEntityManager().createQuery(stringBuilder.toString()).getResultList();

		if (ItauTwitterUtils.validateList(results)) {
			countPostsByCreatedAtHourList = new ArrayList<>();

			for (var resultIteration : results) {
				var createdAtHour = (LocalTime) resultIteration[0];
				var count = ((Long) resultIteration[1]).longValue();

				countPostsByCreatedAtHourList.add(new CountPostsByCreatedAtHour(count, createdAtHour));
			}
		}
		else {
			countPostsByCreatedAtHourList = null;
		}

		return countPostsByCreatedAtHourList;
	}

	/**
	 * Gets total posts group by language.
	 *
	 * @return the total posts group by language
	 */
	@Override()
	public List<CountPostsByLanguage> getTotalPostsGroupByLanguage() {
		List<CountPostsByLanguage> countPostsByLanguageList;

		final var stringBuilder = new StringBuilder();

		stringBuilder.append(	" SELECT " 					).append(" \n");
		stringBuilder.append(		" t.lang AS language, " ).append(" \n");
		stringBuilder.append(		" COUNT(t) AS total " 	).append(" \n");
		stringBuilder.append(	" FROM " 					).append(" \n");
		stringBuilder.append(		" TweetModel AS t " 	).append(" \n");
		stringBuilder.append(	" GROUP BY " 				).append(" \n");
		stringBuilder.append(		" t.lang " 				).append(" \n");
		stringBuilder.append(	" ORDER BY " 				).append(" \n");
		stringBuilder.append(		" t.lang DESC " 		).append(" \n");

		List<Object[]> results = this.getEntityManager().createQuery(stringBuilder.toString()).getResultList();

		if (ItauTwitterUtils.validateList(results)) {
			countPostsByLanguageList = new ArrayList<>();

			for (var resultIteration : results) {
				var language = (String) resultIteration[0];
				var count = ((Long) resultIteration[1]).longValue();

				countPostsByLanguageList.add(new CountPostsByLanguage(count, language));
			}
		}
		else {
			countPostsByLanguageList = null;
		}

		return countPostsByLanguageList;
	}
}
