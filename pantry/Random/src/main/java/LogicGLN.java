
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LogicGLN {

    private final int base = 10; // модуль

    public LogicGLN() {

    }

    private int calculateGLN(List<Integer> arr){ //создание 13-ого числа для глна
        int evenSixNum = 0 , oddSixNum = 0;
        int x13;
        for (int i = 1; i <= 6; i++) {
            oddSixNum = oddSixNum + arr.get(2*i - 2);
            evenSixNum = evenSixNum + arr.get(2*i - 1);
        }
        x13 = (oddSixNum + evenSixNum * 3) % base;
        x13 = base - x13;
        return x13 == base ? 0 : x13;
    }

    public String getGLN() {
        Random random = new Random();
        List<Integer> gln = new ArrayList<>(List.of(9, 8, 7, 9, 8, 7, 0, 0,
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10)));
        gln.add(calculateGLN(gln));
        return gln.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}

