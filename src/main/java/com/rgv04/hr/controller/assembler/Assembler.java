package com.rgv04.hr.controller.assembler;

import java.util.List;

public interface Assembler<Entity, Dto> {

	List<Dto> toListDto(List<Entity> entities);
	
	Dto toDto(Entity entity);

}
