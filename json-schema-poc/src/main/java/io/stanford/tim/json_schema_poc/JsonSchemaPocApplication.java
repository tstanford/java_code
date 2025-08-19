package io.stanford.tim.json_schema_poc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.Objects;
import java.util.Set;

@SpringBootApplication
public class JsonSchemaPocApplication implements CommandLineRunner {

	private final ObjectMapper mapper;

	public JsonSchemaPocApplication(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(JsonSchemaPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("personSchema.json");
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
		JsonSchema schema = factory.getSchema(inputStream);

		String json = new String(Objects.requireNonNull(classloader.getResourceAsStream("sampleJson.json")).readAllBytes());

		Set<ValidationMessage> errors = schema.validate(json, InputFormat.JSON);
		if(errors.isEmpty()) {
			System.out.println("Json ok");
		} else {
			System.out.println("Json validation failed");
			errors.forEach(System.out::println);
		}

		PersonnelRecord personnelRecord = mapper.readValue(json, PersonnelRecord.class);

	}

}
