package org.firework.sfs.business.dao;

import org.firework.sfs.business.entity.UserRole;

import java.util.Set;

public interface IUserRoleDao {

	void create(UserRole userRole);

	UserRole update(UserRole userRole);

	void delete(UserRole entity);
	
	boolean exists(Long userId, Long roleId);
	
	Set<String> findRoles(String username);

}
