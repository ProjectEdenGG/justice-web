package gg.projecteden.justiceweb;

import gg.projecteden.api.common.utils.Env;
import gg.projecteden.api.mongodb.DatabaseConfig;
import gg.projecteden.api.mongodb.EdenDatabaseAPI;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends EdenDatabaseAPI {

	public static void main(String[] args) {
		new Application();
		SpringApplication.run(Application.class, args);
	}

	public Application() {
		instance = this;
	}

	@Getter
	@Value("${gg.projecteden.justice-web.env}")
	private Env env;

	@Getter
	@Value("${gg.projecteden.justice-web.databases.mongodb.password}")
	private String mongodb_password;

	@Override
	public DatabaseConfig getDatabaseConfig() {
		return DatabaseConfig.builder()
				.password(mongodb_password)
				.env(env)
				.caching(false)
				.build();
	}

}
