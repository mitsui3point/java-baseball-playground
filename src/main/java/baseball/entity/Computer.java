package baseball.entity;

import java.util.Objects;

public class Computer {
    private final String number;

    public Computer(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(number, computer.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "number='" + number + '\'' +
                '}';
    }
}
