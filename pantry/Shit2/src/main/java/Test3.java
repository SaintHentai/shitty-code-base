import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import com.github.sh0nk.matplotlib4j.builder.HistBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test3 {

    public static void main(String[] args) throws IOException, PythonExecutionException {
        Random rand = new Random();
        List<Double> x1 = IntStream.range(0, 1000).mapToObj(i -> rand.nextGaussian())
                .collect(Collectors.toList());
        List<Double> x2 = IntStream.range(0, 1000).mapToObj(i -> 4.0 + rand.nextGaussian())
                .collect(Collectors.toList());

        Plot plt = Plot.create();
        plt.hist()
                .add(x1).add(x2)
                .bins(20)
                .stacked(true)
                .color("#66DD66", "#6688FF");
        plt.xlim(-6, 10);
        plt.title("histogram");
        plt.show();
    }

}
