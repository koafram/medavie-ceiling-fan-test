package enums;

public enum Direction {

    FORWARD("forward"), REVERSE("reverse");

    private final String label;

    Direction(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
