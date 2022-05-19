package com.backendspringboot.clockstore;

import com.backendspringboot.clockstore.model.Clock;
import com.backendspringboot.clockstore.repository.ClockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ClockStoreApplication implements CommandLineRunner {

		private final ClockRepository clockRepository;

	public ClockStoreApplication(ClockRepository clockRepository) {
		this.clockRepository = clockRepository;
	}

	public static void main(String[] args) {
			SpringApplication.run(ClockStoreApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		Clock clock1 = Clock.builder().name("Casio")
				.model("G-shock")
				.price(10.0)
				.stock(10).build();
		Clock clock2 = Clock.builder().name("Seiko")
				.model("SeikoSsb")
				.price(11.1)
				.stock(10).build();
		Clock clock3 = Clock.builder().name("Fossil")
				.model("FossilFfb")
				.price(15.0)
				.stock(10).build();
		clockRepository.saveAll(Arrays.asList(clock1, clock2, clock3));
	}

}
