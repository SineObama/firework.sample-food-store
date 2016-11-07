package org.firework.sfs.application;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.firework.sfs.business.entity.Role;
import org.firework.sfs.business.entity.User;
import org.firework.sfs.business.service.IRoleService;
import org.firework.sfs.business.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Init {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	public void doInit() {
		Role role = new Role();
		role.setRole("vip");
		role.setDescription("额外享受95折");

		User user = createUser("a", "a");
		userService.create(user);
		roleService.create(role);
		userService.correlationRoles(user, role);
	}

	private User createUser(String username, String password) {
		String salt = username;
		Md5Hash hash = new Md5Hash(password, salt);
		password = hash.toString();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSalt(salt);

		return user;
	}
}
