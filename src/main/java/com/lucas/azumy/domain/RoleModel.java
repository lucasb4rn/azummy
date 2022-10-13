//package com.lucas.azumy.domain;
//
//import java.io.Serializable;
//import java.util.UUID;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import com.lucas.azumy.enums.RoleName;
//
//@Entity
//@Table(name = "seg_role")
//public class RoleModel implements GrantedAuthority, Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private UUID roleId;
//
//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false, unique = true)
//	private RoleName roleName;
//
//	public RoleModel(RoleName roleName) {
//		this.roleName = roleName;
//	}
//
//	public RoleModel() {
//		super();
//	}
//
//	@Override
//	public String getAuthority() {
//		return this.roleName.toString();
//	}
//
//	public UUID getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(UUID roleId) {
//		this.roleId = roleId;
//	}
//
//	public RoleName getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(RoleName roleName) {
//		this.roleName = roleName;
//	}
//
//}
