-- Recette 1
insert into recette (nom, tempsPreparation, description, nombrePersonne)
values('Pates bolognaise', '40 min','To do', 4);
--- Ingrédient Recette 1	
insert into ingredient ( nomIngredient ,type , quantite, unite,idRecette)
values ('pates', 'epicerie_salee', 500, 'g', 1);

insert into ingredient ( nomIngredient ,type , quantite, unite,idRecette)
values ('viande_hachee', 'proteine', 500, 'g', 1);

insert into ingredient ( nomIngredient ,type , quantite, unite,idRecette)
values ('sauce_tomate', 'epicerie_salee', 1, 'boite', 1);

insert into ingredient ( nomIngredient,type , quantite, unite,idRecette)
values ('oignon', 'legume', 2, 'piece', 1);

insert into ingredient ( nomIngredient ,type , quantite, unite,idRecette)
values ('ail', 'legume', 1, 'piece', 1);

insert into ingredient ( nomIngredient ,type , quantite, unite,idRecette)
values ('huile_olive', 'epicerie_salee', 4, 'cas', 1);