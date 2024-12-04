package com.finder.store.rest;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finder.store.handler.HandlerCSV;
import com.finder.store.model.Store;
import com.finder.store.service.StoreService;

@RestController
@RequestMapping("/api")
public class StoreRestController {

	@Autowired
	StoreService storeService;

	@PostMapping("/upload")
	public ResponseEntity<MultipartFile> upload(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			Path tempFile = Paths.get(file.getOriginalFilename());
			try {
				file.transferTo(tempFile);
				List<Store> stores = storeService.getAll();
				ArrayList<Store> storesToUpload = HandlerCSV.storeReader(tempFile.toFile());

				for (int i = 0; i < storesToUpload.size(); i++) {
					if (!stores.contains(storesToUpload.get(i))) {
						storeService.save(storesToUpload.get(i));
					}
				}
				return new ResponseEntity<MultipartFile>(file, HttpStatus.OK);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return new ResponseEntity<MultipartFile>(file, HttpStatus.BAD_REQUEST);
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<MultipartFile>(file, HttpStatus.EXPECTATION_FAILED);
			}

		} else {
			return new ResponseEntity<MultipartFile>(file, HttpStatus.NO_CONTENT);
		}

	}

}
