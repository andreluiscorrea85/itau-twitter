package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repository.
 */
@Repository()
public abstract interface UserRepository
	extends ItauTwitterRepository<UserModel, Long>, UserRepositoryCustom {

	/**
	 * Find top 5 order by followers count desc list.
	 *
	 * @return the list
	 */
	@Query(
		nativeQuery = true,
		value = "SELECT * FROM TB002_USERS ORDER BY AT002_FOLLOWERS_COUNT DESC LIMIT 5"
	)
	public abstract List<UserModel> findTop5OrderByFollowersCountDesc();

}
