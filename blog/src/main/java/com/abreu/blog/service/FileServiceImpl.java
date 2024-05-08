package com.abreu.blog.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // Nome ficheiro
        String name = file.getOriginalFilename();

        String randomID = UUID.randomUUID().toString();
        assert name != null;
        String fileExtension = name.substring(name.lastIndexOf("."));
        String fileName = randomID + fileExtension;

        String filePath = path + File.separator + fileName;

        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(filePath));
        } catch (IOException e) {
            throw new IOException("Failed to save file: " + e.getMessage(), e);
        }

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        return new FileInputStream(file);
    }
}
