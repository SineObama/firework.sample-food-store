package org.firework.sfs.business.dao;

import org.firework.sfs.business.entity.UserRole;
import org.springframework.stereotype.Repository;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

@Repository
public class UserRoleDao extends AbstractJpaDAO<UserRole> implements IUserRoleDao {

	public UserRoleDao() {
		super();
		setClazz(UserRole.class);
	}

	public boolean exists(Long userId, Long roleId) {
		String sql = "select count(1) from users_roles where user_id=:userId and role_id=:roleId";
		Query query = entityManager.createNativeQuery(sql, Integer.class);
		query.setParameter("userId", userId);
		query.setParameter("roleId", roleId);
		return query.getFirstResult() != 0;
	}

	@SuppressWarnings("unchecked") // TODO ...
	public Set<String> findRoles(String username) {
		String sql = "select role from users u, roles r,users_roles ur where u.username=:username and u.id=ur.user_id and r.id=ur.role_id";
		Query query = entityManager.createNativeQuery(sql, String.class);
		query.setParameter("username", username);
		return new HashSet<String>(query.getResultList());
	}

}
