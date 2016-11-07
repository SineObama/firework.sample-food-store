//package org.firework.sfs.business.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//public class UserRole2 implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;
//	@ManyToOne
//	@JoinColumn(name = "role_id")
//	private Role role;
//
//	public UserRole2(Long userId, Long roleId) {
//		this.user_id = userId;
//		this.role_id = roleId;
//	}
//
//	public Long getUserId() {
//		return user_id;
//	}
//
//	public void setUserId(Long userId) {
//		this.user_id = userId;
//	}
//
//	public Long getRoleId() {
//		return role_id;
//	}
//
//	public void setRoleId(Long roleId) {
//		this.role_id = roleId;
//	}
//
//}
