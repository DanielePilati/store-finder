package com.finder.store.component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.finder.store.model.Store;

@Component
public class HandlerCSV {

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		String filePath = new File("./src/main/resources/csv/stores.csv").getAbsolutePath();
		csvReader(new File(filePath));
		System.out.println("hello"+ csvReader(new File(filePath)));
	}

	public static ArrayList<Store> csvReader(File source) {

		ArrayList<Store> dataList = new ArrayList<Store>();
		ArrayList<String> lines = new ArrayList<String>();

		try (Scanner scanner = new Scanner(source)) {
			while (scanner.hasNext()) {
				lines.add(scanner.nextLine());
			}
			for (int i = 1; i < lines.size(); i++) {
				String line = lines.get(i);
				String[] splitLine = line.split(",");
				Store modelStore = new Store(splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5],
						splitLine[6], splitLine[7], splitLine[8], splitLine[9], splitLine[10], splitLine[11], splitLine[12]);
				dataList.add(modelStore);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return dataList;

	}

}