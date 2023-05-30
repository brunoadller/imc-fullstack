create table imc_user(
  id bigint not null auto_increment,
  name varchar(60) not null,
  height double not null,
  weight double not null,
  result_imc double not null,
  description text not null,

  primary key(id)

);
