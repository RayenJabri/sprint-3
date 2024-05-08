package com.rayen.boisson;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rayen.boisson.entities.Boisson;
import com.rayen.boisson.service.BoissonService;

@SpringBootApplication
public class BoissonSp2Application {
	@Autowired
	private BoissonService boissonService ;
	public static void main(String[] args) {
		SpringApplication.run(BoissonSp2Application.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {
		boissonService.saveBoisson(new Boisson("caffe au lait", 3.0, new Date()));
		boissonService.saveBoisson(new Boisson("jus kiwi", 7.0, new Date()));
		boissonService.saveBoisson(new Boisson("chaucolat chaut", 8.5, new Date()));
	}*/

}
