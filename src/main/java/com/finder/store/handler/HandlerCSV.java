package com.finder.store.handler;

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
<<<<<<< HEAD:src/main/java/com/finder/store/handler/HandlerCSV.java
	// TEST
	@Autowired
	StoreService StoreService;

	// Read csv from resources

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

<<<<<<< HEAD:src/main/java/com/finder/store/handler/HandlerCSV.java
		String filePath = new File("./src/main/resources/csv/stores.csv").getAbsolutePath();
		ArrayList<Store> stores = storeReader(new File(filePath));
		for (int i = 0; i < stores.size(); i++) {
			StoreService.save(stores.get(i));
		}
		System.out.println("hello" + storeReader(new File(filePath)));
=======
		System.out.println("hello");
>>>>>>> parent of 0bbdbed (testing csv conversion):src/main/java/com/finder/store/component/HandlerCSV.java
	}

	// Reader

	public static ArrayList<Store> storeReader(File source) {
=======

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		String filePath = new File("./src/main/resources/csv/stores.csv").getAbsolutePath();
		csvReader(new File(filePath));
		System.out.println("hello"+ csvReader(new File(filePath)));
	}

	public static ArrayList<Store> csvReader(File source) {
>>>>>>> parent of 19161ae (test finish):src/main/java/com/finder/store/component/HandlerCSV.java

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