package nespresso.train.Wagon;

import javax.swing.text.html.Option;
import java.util.Optional;

public enum WagonType {
    HEAD("H"),
    PASSENGER("P"),
    RESTAURANT("R"),
    CARGO("C"),
    FILLED("F");

    private final String code;

    WagonType(String code) {
        this.code = code;
    }

    public static Optional<WagonType> fromString(String code) {
        for (WagonType type : WagonType.values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return code;
    }
}
