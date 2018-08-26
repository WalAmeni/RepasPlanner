create table recette
(
   id integer not null AUTO_INCREMENT,
   nom varchar(255) not null,
   tempsPreparation varchar(255) ,
   description varchar(2048) ,
   nombrePersonne integer not null,
   primary key(id)
 
);

create table ingredient
(
   nomIngredient varchar(255) not null,
   type varchar(255) not null,
   quantite double not null,
   unite varchar(255) not null,
   idRecette integer not null
);

