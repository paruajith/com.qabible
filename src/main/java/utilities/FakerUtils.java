package utilities;

import com.github.javafaker.Faker;

public class FakerUtils {

	public String getFakefirstName() {
		Faker faker = new Faker();

		String firstName=faker.name().firstName();
		return firstName;
	}
	public String getFakelastName() {
		Faker faker = new Faker();

		String lastName=faker.name().lastName();
		return lastName;
	}
}
