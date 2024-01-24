package test.petstore;

import org.testng.annotations.Test;
import test.petstore.dto.Category;
import test.petstore.dto.Pet;

public class PetStoreTest {

    @Test(description = "Добавление нового питомца")
    public void shouldAddNewPet() {
        Pet dog = new Pet();
    }

}
