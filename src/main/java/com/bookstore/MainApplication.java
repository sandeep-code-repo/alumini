package com.bookstore;

import com.bookstore.service.BookstoreService;
import com.bookstore.service.RealPollutantLevelService;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	/*
	 * private final BookstoreService bookstoreService;
	 * 
	 * public MainApplication(BookstoreService bookstoreService) {
	 * this.bookstoreService = bookstoreService; }
	 */
    
    private final RealPollutantLevelService realPollutantLevelService;

    public MainApplication(RealPollutantLevelService realPollutantLevelService) {
        this.realPollutantLevelService = realPollutantLevelService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

	/*
	 * @Bean public ApplicationRunner init() { return args -> {
	 * bookstoreService.batchAuthors(); }; }
	 */
    
    @Bean public ApplicationRunner init() {
    	return args -> {
    		realPollutantLevelService.batchAuthors();
   	 }; 
   	 
    }
    
}
