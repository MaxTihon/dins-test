package dins.test;

import dins.test.controller.KafkaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@EnableKafka
@SpringBootApplication
@EnableJpaRepositories
public class ExampleApplication implements CommandLineRunner {
	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private final static String instructions =
			" - To read data from DB and write to topic, enter 1 \n" +
			" - To read messages from topic and save data to DB, enter 2 \n" +
			" - Enter stop to complete the application";

	@Autowired
	private KafkaController kafkaController;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ExampleApplication.class);
		application.run(args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ignore) {

		}

		kafkaController.preparePersonTable();

		System.out.println(instructions);

		while (true) {
			String enteredWord = reader.readLine();

			if (enteredWord.equals("stop")) {
				break;
			}

			switch (enteredWord) {
				case ("1"):
					kafkaController.readAndWrite();
					System.out.println(instructions);
					break;
				case ("2"):
					kafkaController.writeToTable();
					System.out.println(instructions);
					break;
				default:
					System.out.println(" - Enter correct value!");
			}
		}

		System.out.println(" - All data has been processed, the application is closed");
	}
}
