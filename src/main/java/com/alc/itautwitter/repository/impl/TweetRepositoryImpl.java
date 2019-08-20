package com.alc.itautwitter.repository.impl;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.repository.base.AbstractItauTwitterRepositoryCustom;
import com.alc.itautwitter.repository.interfaces.TweetRepositoryCustom;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
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

	public TweetRepositoryImpl() {
		super();
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

		stringBuilder.append(	" SELECT " 												).append(" \n");
		stringBuilder.append(		" HOUR(T.AT003_CREATED_AT) AS CREATED_AT_HOUR, " 	).append(" \n");
		stringBuilder.append(		" COUNT(T.PK003_ID) AS TOTAL " 						).append(" \n");
		stringBuilder.append(	" FROM " 												).append(" \n");
		stringBuilder.append(		" TB003_TWEETS AS T " 								).append(" \n");
		stringBuilder.append(	" GROUP BY " 											).append(" \n");
		stringBuilder.append(		" HOUR(T.AT003_CREATED_AT) "						).append(" \n");
		stringBuilder.append(	" ORDER BY " 											).append(" \n");
		stringBuilder.append(		" CREATED_AT_HOUR DESC " 							).append(" \n");

		var query = this.getEntityManager().createNativeQuery(stringBuilder.toString());

		List<Object[]> results = query.getResultList();

		if (ItauTwitterUtils.validateList(results)) {
			countPostsByCreatedAtHourList = new ArrayList<>();

			for (var resultIteration : results) {
				var createdAtHour = ItauTwitterUtils.convertToLocalTime((Integer) resultIteration[0]);
				var count = ItauTwitterUtils.convertToLong((BigInteger) resultIteration[1]);

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

		stringBuilder.append(	" SELECT " 										).append(" \n");
		stringBuilder.append(		" T.AT003_LANGUAGE_LOCALE AS LANGUAGE, " 	).append(" \n");
		stringBuilder.append(		" COUNT(T.PK003_ID) AS TOTAL " 				).append(" \n");
		stringBuilder.append(	" FROM " 										).append(" \n");
		stringBuilder.append(		" TB003_TWEETS AS T " 						).append(" \n");
		stringBuilder.append(	" GROUP BY " 									).append(" \n");
		stringBuilder.append(		" T.AT003_LANGUAGE_LOCALE " 				).append(" \n");
		stringBuilder.append(	" ORDER BY " 									).append(" \n");
		stringBuilder.append(		" LANGUAGE DESC " 							).append(" \n");

		var query = this.getEntityManager().createNativeQuery(stringBuilder.toString());

		List<Object[]> results = query.getResultList();

		if (ItauTwitterUtils.validateList(results)) {
			countPostsByLanguageList = new ArrayList<>();

			for (var resultIteration : results) {
				var language = ((String) resultIteration[0]);
				var count = ItauTwitterUtils.convertToLong((BigInteger) resultIteration[1]);

				countPostsByLanguageList.add(new CountPostsByLanguage(count, language));
			}
		}
		else {
			countPostsByLanguageList = null;
		}

		return countPostsByLanguageList;
	}
}
