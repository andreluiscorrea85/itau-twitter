package com.alc.itautwitter.repository.impl;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.auxiliary.ResumedUser;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.AbstractItauTwitterRepositoryCustom;
import com.alc.itautwitter.repository.interfaces.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User repository.
 */
@Repository()
public class UserRepositoryImpl
	extends AbstractItauTwitterRepositoryCustom<UserModel, Long>
	implements UserRepositoryCustom {

	private static final long serialVersionUID = -2045885963850124986L;

	public UserRepositoryImpl() {
		super();
	}

	@Override()
	public List<ResumedUser> findTop5OrderByFollowersCountDesc() {
		List<ResumedUser> resumedUserList;

		final var stringBuilder = new StringBuilder();

		stringBuilder.append(	" SELECT " 												).append(" \n");
		stringBuilder.append(		" U.AT002_USER_ID AS USER_ID, " 					).append(" \n");
		stringBuilder.append(		" U.AT002_SCREEN_NAME AS SCREEN_NAME, " 			).append(" \n");
		stringBuilder.append(		" U.AT002_FOLLOWERS_COUNT AS FOLLOWERS_COUNT, " 	).append(" \n");
		stringBuilder.append(		" U.AT002_LANGUAGE_LOCALE AS LANGUAGE_LOCALE " 		).append(" \n");
		stringBuilder.append(	" FROM " 												).append(" \n");
		stringBuilder.append(		" TB002_USERS AS U " 								).append(" \n");
		stringBuilder.append(	" ORDER BY " 											).append(" \n");
		stringBuilder.append(		" FOLLOWERS_COUNT DESC LIMIT 5 " 					).append(" \n");

		var query = this.getEntityManager().createNativeQuery(stringBuilder.toString());

		List<Object[]> results = query.getResultList();

		if (ItauTwitterUtils.validateList(results)) {
			resumedUserList = new ArrayList<>();

			for (var resultIteration : results) {
				var userId = ItauTwitterUtils.convertToLong((BigInteger) resultIteration[0]);
				var screenName = ((String) resultIteration[1]);
				var followersCount = ((Integer) resultIteration[2]);
				var languageLocale = ((String) resultIteration[3]);

				resumedUserList.add(new ResumedUser(userId, screenName, followersCount, languageLocale));
			}
		}
		else {
			resumedUserList = null;
		}

		return resumedUserList;
	}

}
