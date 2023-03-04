package ArecWinaToy;

public class Toy {
    Integer toyId;
    String toyName;
    Integer toyCount;
    Integer toyValue;

    public Toy(Integer toyId, String toyName, Integer toyCount, Integer toyValue) {
        this.toyId = toyId;
        this.toyName = toyName;
        this.toyCount = toyCount;
        this.toyValue = toyValue;
    }

    @Override
    public String toString() {
        return "Название: " + toyName + "   Количество: " + toyCount + "   Шанс выигрыша: " + toyValue + "%";
    }

    public Integer setToyId(Integer toyId) {
        return this.toyId = toyId;
    }

    public String setToyName(String toyName) {
        return this.toyName = toyName;
    }

    public Integer setToyCount(Integer toyCount) {
        return this.toyCount = toyCount;
    }

    public Integer setToyValue(Integer toyValue) {
        return this.toyValue = toyValue;
    }

    public Integer getToyId() {
        return this.toyId;
    }

    public String getToyName() {
        return this.toyName;
    }

    public Integer getToyCount() {
        return this.toyCount;
    }

    public Integer getToyValue() {
        return this.toyValue;
    }
}
