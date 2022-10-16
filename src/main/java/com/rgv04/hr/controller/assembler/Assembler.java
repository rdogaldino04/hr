package com.rgv04.hr.controller.assembler;

import java.util.List;

public interface Assembler<Entity, Model> {

	List<Model> toListModel(List<Entity> entities);
	
	Model toModel(Entity entity);

}
