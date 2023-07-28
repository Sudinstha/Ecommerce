package com.bway.ecommerce.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {
	
public void fileUploadBrand(MultipartFile image) {
		
		try {
			Files.copy(image.getInputStream(),Path.of("src/main/resources/static/images/brand/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
public void fileUploadBanner(MultipartFile image) {
	
	try {
		Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/banner/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}

public void fileUploadProduct(MultipartFile image) {
	
	try {
		Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/product/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
