package me.pugabyte.justiceweb;

import lombok.Getter;
import me.pugabyte.edenapi.persistence.DatabaseConfig;
import me.pugabyte.edenapi.persistence.DatabaseType;
import me.pugabyte.edenapi.utils.Env;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import me.pugabyte.edenapi.EdenAPI;

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
	public DatabaseConfig getDatabaseConfig(DatabaseType type) {
		return DatabaseConfig.builder()
				.type(type)
				.password(mongoPassword)
				.build();
	}

}
