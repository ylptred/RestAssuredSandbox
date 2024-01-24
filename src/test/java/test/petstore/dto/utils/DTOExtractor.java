package test.petstore.dto.utils;

import test.petstore.dto.Category;
import test.petstore.dto.Pet;

import java.util.List;

public class DTOExtractor {
    public Pet getPetsAdd(Integer idPet, Integer idCategory, String nameCategory, String namePet, List<String> photoUrls) {
        Pet dog = new Pet();
        Category category = new Category();
        category.setId(idCategory);
        category.setName(nameCategory);
        dog.setId(idPet);
        dog.setName(namePet);

        return dog;
    }
}
