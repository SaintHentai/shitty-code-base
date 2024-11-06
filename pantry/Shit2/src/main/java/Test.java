import org.math.plot.*;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {

        double[] x = {1.0, 2.0, 3.0};
        double[] y = {1.0, 2.0, 3.0};

        Plot2DPanel plot = new Plot2DPanel();
        plot.addLinePlot("my plot", x, y);

        JFrame frame = new JFrame("a plot panel");
        frame.setContentPane(plot);
        frame.setVisible(true);

    }

}
