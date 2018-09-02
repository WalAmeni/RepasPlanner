package org.repasplanner.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.repasplanner.model.Ingredient;
import org.repasplanner.model.TypeIngredient;
public class ListeFileWriter {

	public ListeFileWriter() {
		// TODO Auto-generated constructor stub
	}

	public static void writeListeDeCourse(List<Ingredient> ingredients){
		LocalDate localDate = LocalDate.now();
		String stringToWrite = "Liste de course du "+ localDate+"\r\n";
		Map<TypeIngredient,List<Ingredient>> mapTypeIngredient = new HashMap<TypeIngredient,List<Ingredient>>();

		for(Ingredient i : ingredients){
			if (!mapTypeIngredient.containsKey(i.getType())){
				mapTypeIngredient.put(i.getType(), new ArrayList<Ingredient>());
				mapTypeIngredient.get(i.getType()).add(i);
			}else{
				mapTypeIngredient.get(i.getType()).add(i);
			}
		}
		// creation du String
		for (Map.Entry<TypeIngredient,List<Ingredient>> entry : mapTypeIngredient.entrySet()){
			stringToWrite+= "---------- "+entry.getKey().toString()+" ----------\r\n";
			stringToWrite+="----------------------------------------------------\r\n";
			for(Ingredient i : entry.getValue()){
				stringToWrite+=i.getNom() + "\t | \t"+ i.getQuantite() +"\t | \t"+ i.getUnite()+"\r\n";
			}
			stringToWrite+="----------------------------------------------------\r\n";
		}
		System.out.println(stringToWrite);
		//write the file 
		Path path = Paths.get("D:\\JAVA\\listeDeCourse"+localDate+".txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
			writer.write(stringToWrite);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}


