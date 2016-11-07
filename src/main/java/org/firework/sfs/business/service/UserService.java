package org.firework.sfs.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.firework.sfs.business.dao.IUserDao;
import org.firework.sfs.business.dao.IUserRoleDao;
import org.firework.sfs.business.entity.Role;
import org.firework.sfs.business.entity.User;
import org.firework.sfs.business.entity.UserRole;

import java.util.Set;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	public void create(User user) {
		userDao.create(user);
	}

	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		userDao.update(user);
	}

	public void correlationRoles(User user, Role role) {
		userRoleDao.create(new UserRole(user, role));
	}

	public void uncorrelationRoles(User user, Role role) {
		userRoleDao.delete(new UserRole(user, role));
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public Set<String> findRoles(String username) {
		return userRoleDao.findRoles(username);
	}

}
