insert into roles (roles_name) values('ROLE_USER');
insert into roles (roles_name) values('ROLE_MANAGER');
insert into roles (roles_name) values('ROLE_ADMIN');
insert into roles (roles_name) values('ROLE_SUPER_ADMIN');

insert into users ("name", username, "password") values('John Travolta', 'john', 1234);
insert into users ("name", username, "password") values('Will Smith', 'will', 1234);
insert into users ("name", username, "password") values('Jim Carry', 'jim', 1234);
insert into users ("name", username, "password") values('Arnold Schwarzenegger', 'arnold', 1234);

insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'john'), (select r.roles_id from roles r where r.roles_name = 'ROLE_USER')
); 
insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'john'), (select r.roles_id  from roles r where r.roles_name = 'ROLE_MANAGER')
); 
insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'will'), (select r.roles_id  from roles r where r.roles_name = 'ROLE_MANAGER')
);
insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'jim'), (select r.roles_id  from roles r where r.roles_name = 'ROLE_ADMIN')
);
insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'arnold'), (select r.roles_id  from roles r where r.roles_name = 'ROLE_SUPER_ADMIN')
);
insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'arnold'), (select r.roles_id  from roles r where r.roles_name = 'ROLE_ADMIN')
);
insert into users_roles (user_id, role_id) values(
  (select u.user_id from users u where u.username = 'arnold'), (select r.roles_id  from roles r where r.roles_name = 'ROLE_USER')
);