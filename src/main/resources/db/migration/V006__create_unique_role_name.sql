ALTER TABLE roles 
  ADD CONSTRAINT uq_role_name UNIQUE (roles_name);