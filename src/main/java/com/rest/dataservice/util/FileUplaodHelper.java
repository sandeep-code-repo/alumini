package com.rest.dataservice.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.exception.FileStorageException;


/*
 * @Service
 * 
 * public class FileUplaodHelper { private final Path fileStorageLocation;
 * 
 * @Autowired public FileUplaodHelper(FileStorageProperties
 * fileStorageProperties) { this.fileStorageLocation =
 * Paths.get(fileStorageProperties.getUploadDir())
 * .toAbsolutePath().normalize();
 * 
 * try { Files.createDirectories(this.fileStorageLocation); } catch (Exception
 * ex) { System.out.
 * println("Could not create the directory where the uploaded files will be stored."
 * + ex); } }
 * 
 * 
 * public String saveUploadedFile(MultipartFile file) throws IOException {
 * String sufix = UUID.randomUUID().toString(); // Normalize file name String
 * fileName = StringUtils.cleanPath(sufix+".xlsx");
 * 
 * try { // Check if the file's name contains invalid characters
 * if(fileName.contains("..")) { throw new
 * FileStorageException("Sorry! Filename contains invalid path sequence " +
 * fileName); }
 * 
 * // Copy file to the target location (Replacing existing file with the same
 * name) Path targetLocation = this.fileStorageLocation.resolve(fileName);
 * Files.copy(file.getInputStream(), targetLocation,
 * StandardCopyOption.REPLACE_EXISTING); System.out.println(targetLocation);
 * return targetLocation.toString(); } catch (IOException ex) { throw new
 * FileStorageException("Could not store file " + fileName +
 * ". Please try again!", ex); }
 * 
 * 
 * } }
 */