package me.pugabyte.justiceweb;

import eden.EdenAPI;
import eden.mongodb.DatabaseConfig;
import eden.utils.Env;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends EdenAPI {

	public static void main(String[] args) {
		new Application();
		SpringApplication.run(Application.class, args);
	}

	public Application() {
		instance = this;
	}

	@Getter
	@Value("${me.pugabyte.justice-web.env}")
	private Env env;

	@Getter
	@Value("${me.pugabyte.justice-web.database.mongo.password}")
	private String mongoPassword;

	@Override
	public DatabaseConfig getDatabaseConfig() {
		return DatabaseConfig.builder()
				.password(mongoPassword)
				.prefix(env == Env.PROD ? null : env.name().toLowerCase())
				.build();
	}

}
