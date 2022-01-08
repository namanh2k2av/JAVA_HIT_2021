package Controller;

import Model.Pet;

import java.util.Comparator;

public class SortPetByNamePet implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getPetName().compareTo(o2.getPetName());
    }
}
