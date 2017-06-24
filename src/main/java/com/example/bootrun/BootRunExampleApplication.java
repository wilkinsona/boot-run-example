package com.example.bootrun;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BootRunExampleApplication {

	@RestController
	static class ExampleController {

		private final Supplier<Integer> intSupplier;

		ExampleController(Supplier<Integer> intSupplier) {
			this.intSupplier = intSupplier;
		}

		@GetMapping("/")
		public int getInt() {
			return intSupplier.get();
		}

	}

	@Profile("default")
	@Component
	static class ConstantIntSupplier implements Supplier<Integer> {

		@Override
		public Integer get() {
			return 42;
		}

	}

	@Profile("random")
	@Component
	static class RandomIntSupplier implements Supplier<Integer> {

		private final Random random = new Random();

		@Override
		public Integer get() {
			return random.nextInt();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(BootRunExampleApplication.class, args);
	}

}
