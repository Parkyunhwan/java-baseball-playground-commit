package baseball.second;

import java.util.Objects;

public class BallNumber {
    int number;
    public BallNumber(int num) {
        if (1 > num || num > 9) {
            throw new IllegalArgumentException("1~9사이의 숫자만 가능합니다.");
        }
        this.number = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
