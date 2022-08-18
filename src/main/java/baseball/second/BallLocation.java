package baseball.second;

import java.util.Objects;

public class BallLocation {
    int number;
    public BallLocation(int num) {
        if (1 > num || num > 3) {
            throw new IllegalArgumentException("볼의위치는 1~3사이의만 가능합니다.");
        }
        this.number = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallLocation that = (BallLocation) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
