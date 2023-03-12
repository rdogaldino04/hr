package com.rgv04.hr.domain.dto;

import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class RoleDTO {
	
	private Long id;

    private String name;
    
    public RoleDTO toDTO(Role role) {
    	if (role == null) {
    		return null;
    	}
    	RoleDTO roleDTO = new RoleDTO();
    	roleDTO.setId(role.getId());
    	roleDTO.setName(role.getName());
    	return roleDTO;
    }

	public Role toEntity() {
		Role role = new Role();
		role.setId(id);
		role.setName(name);
		return role;
	}

}
