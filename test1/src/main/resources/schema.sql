create table if not exists Fighter (
  id int not null auto_increment,
  name varchar(255) not null,
  createdAt timestamp not null,
  damagePerHit int not null,
  health int not null,
  resistance decimal not null,
  animeFrom varchar(255) not null,
  primary key (id)
);