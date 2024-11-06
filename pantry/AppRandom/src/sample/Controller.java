package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextField countGLN;

    @FXML
    public Button generateGLN;

    @FXML
    public TextArea outGLN;

    public void getGLN(){
        outGLN.clear();
        int len = Integer.parseInt(countGLN.getText());
        String wall = "90109";
        if (len<21){
            LogicGLN log = new LogicGLN(len,wall);
            String gln = log.getArrStr();
            String theEndResult = "";
            String[] lineGln = gln.split(wall);
            for (String ect: lineGln) {
                theEndResult = theEndResult + ect +"\n";
            }
            outGLN.setText(theEndResult);
        }else {
            outGLN.setText("The maximum number of generations is 20 barcodes.\n");
            outGLN.setText("Максимальное количество 20 штрих кодов.\n");
            outGLN.setText("Максимальна кількість генерацій 20 штрих кодів.\n");
            outGLN.setText("\n");
        }
    }
}
