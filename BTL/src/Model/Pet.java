package Model;

public class Pet {
    private long petId;
    private String petName;
    private String species;
    private String petGender;
    private String petAge;
    private String featherColor;
    private long petPrice;

    public Pet() {
    }

    public Pet(long petId, String petName, String species, String petGender, String petAge, String featherColor, long petPrice) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.petGender = petGender;
        this.petAge = petAge;
        this.featherColor = featherColor;
        this.petPrice = petPrice;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    public long getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(long petPrice) {
        this.petPrice = petPrice;
    }

    public void outputPet() {
        System.out.printf("%-10d %-30s %-10s %-10s %-20s %-20s %-20d \n", petId, petName, species, petGender, petAge, featherColor, petPrice);
    }
}
