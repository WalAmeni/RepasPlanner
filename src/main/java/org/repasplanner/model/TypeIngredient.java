package org.repasplanner.model;

import java.util.Arrays;

public enum TypeIngredient {
	FRUIT,
	LEGUME,
	PROTEINE,
	PRODUIT_LAITIER,
	EPICERIE_SALEE,
	EPICERIE_SUCREE,
	BOULANGERIE,
	AUTRES;

	public static TypeIngredient getByName(String s){
//		for (TypeIngredient type :TypeIngredient.values()){
//			if (type.toString().equalsIgnoreCase(s)){
//				return type;
//			}
//		}
		// return TypeIngredient.AUTRES;
		return Arrays.asList(TypeIngredient.values()).stream()
		.filter(type -> type.toString().equalsIgnoreCase(s))
		.findFirst().orElse(AUTRES);
	}
}
