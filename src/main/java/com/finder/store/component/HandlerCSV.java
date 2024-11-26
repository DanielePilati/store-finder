package com.finder.store.component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.finder.store.model.Store;
import com.finder.store.service.StoreService;

@Component
public class HandlerCSV {

	@Autowired
	StoreService StoreService;
	
	//Read csv from resources
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
			
		String filePath = new File("./src/main/resources/csv/stores.csv").getAbsolutePath();
		ArrayList<Store> stores = csvReader(new File(filePath));
		for(int i = 0 ; i < stores.size() ; i++) {
			StoreService.save(stores.get(i));
		}
		System.out.println("hello"+ csvReader(new File(filePath)));
	}

	//Reader
	
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
				Store modelStore = new Store();
				modelStore.setName(splitLine[0]);
				modelStore.setAddress(splitLine[1]);
				modelStore.setCity(splitLine[2]);
				modelStore.setProvince(splitLine[3]);
				modelStore.setCap(splitLine[4]);
				modelStore.setLatitude(splitLine[5]);
				modelStore.setLongitude(splitLine[6]);
				modelStore.setPhone(splitLine[7]);
				modelStore.setOpeningHours(splitLine[8]);
				modelStore.setDirector(splitLine[9]);
				modelStore.setActivity(splitLine[10]);
				modelStore.setPlusService(splitLine[11]);
				dataList.add(modelStore);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return dataList;

	}

}