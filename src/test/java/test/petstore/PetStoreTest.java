package test.petstore;

import org.example.utils.rest.client.PetStoreClient;
import org.testng.annotations.Test;
import test.petstore.dto.Category;
import test.petstore.dto.Pet;
import test.petstore.dto.Status;
import test.petstore.dto.Tag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class PetStoreTest {

    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


    @Test(description = "Добавление нового питомца")
    public void shouldAddNewPet() throws IOException {
        Pet dog = new Pet();
        dog.setId(120);
        dog.setName("Бобик");
        Category category = new Category();
        category.setId(1);
        category.setName("dog");
        dog.setCategory(category);
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("photoUrl");
        dog.setPhotoUrls(photoUrls);
        Tag tag = new Tag();
        tag.setId(2);
        tag.setName("tag");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        dog.setTags(tags);
        Status status = Status.AVAILABLE;
        dog.setStatus(status.getValue());
        String petAddRequest = ow.writeValueAsString(dog);

        new PetStoreClient().addPet(petAddRequest);
    }

}
