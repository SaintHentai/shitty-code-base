import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class GeneratorGLN extends javax.swing.JFrame implements WindowListener { //господи я такой говнокодер

    protected String cmdRestart = "100"; // защита от дурака -> 95 строка
    protected boolean closeApp = false;  // юзер не сможет в ручную перезапустить программу, так как ограниченния ввода в два числа

    private final int base = 10; // модуль
    private int jokeRemove = 0;

    List<String> hashFromDatabase = new ArrayList<>();
    List<String> hash = new ArrayList<>();

    /**
     * Creates new form GeneratorGLN
     */

    public GeneratorGLN() { //здесь я ввожу изменения в своей программе, так что не удивляйтесь что тут дохера всего...
        initComponents();
        this.setTitle("Генератор штрих-кодов");
        this.setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\st.jpg").getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(this);
        Thread watchMemory = new WatchMemory();
        watchMemory.start();
        Thread updatePackage = new UpdatePackage();
        updatePackage.start();
        outGLN.setText(" Инфо : \n"
                +"1. Программа делает перезагрузку, через 10 мин.\n"
                +"2. Запросы в БД каждые 60 сек растянутые на 10 мин.\n"
                +"3. Введите 0 или 00 и для отчистки поля вывода.\n"
                +"4. Введите любое положительное число от 1 до 99,\n"
                +"    создадите нужное количетсво штрих-кодов.\n"
                +"5. Подождите 1-3 секунды, после запуска программы.\n");
    }

    class UpdatePackage extends Thread {
        public void run() {
            for (int i = 0; i < 60; i++) {
                try {
                    requestLeradataSite();
                    Thread.sleep(60 * 1000); //1000 <- 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class WatchMemory extends Thread{ //Логика перезагрузки
        int globalTime;
        int cutTime;
        int end;
        public void run(){
            end = 0;
            globalTime = 600;
            cutTime = 1;
            do {
                try {
                    globalTime = globalTime - cutTime;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runtime.getRuntime().gc();
                if (globalTime == end || closeApp){
                    outGLN.removeAll();
                    int time = 10;
                    while(time --> end){
                        outGLN.setText("Перезагрузка программы через: " + time + " секунд." + "\n");
                        try{
                            TimeUnit.SECONDS.sleep(1);
                        }catch(InterruptedException e){}
                    }
                    //close the frame
                    GeneratorGLN.this.processWindowEvent(
                            new WindowEvent(
                                    GeneratorGLN.this, WindowEvent.WINDOW_CLOSED));
                }
            }while (globalTime != end);
        }
    }

    private void requestLeradataSite(){
        System.out.println("request");
        hashFromDatabase.clear();
        String resUrl = "";
        try {
            URL url = new URL("https://leradata.pro/supp/artyomus/dbreqsql.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            StringBuilder postData = new StringBuilder("inmul=select varGln from leradata_glns where varGln LIKE '98798700%'");
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
            osw.write(String.valueOf(postData));
            osw.flush();
            osw.close();
            connection.getResponseCode();
            resUrl = connection.getURL().toString();
            connection.disconnect();

            Document doc = Jsoup.parse(new URL(resUrl),3000);
            Element table = doc.select("table").first();
            Elements rows = table.select("tr");
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                hashFromDatabase.add(cols.get(0).text());
            }
        } catch (Exception e) {
            outGLN.setText("Внимание сотрудник!\n"
                    + "Включите VPN и пройдите авторизацию по ссылке:\n"
                    + "https://leradata.pro/admin/monitor.php\n"
                    + "https://leradata.pro/supp/supp1/bld/EDI/EDI.php\n"
                    + "Подождите 10 секунд, снова создавайте глны");
        }
        Collections.sort(hashFromDatabase);
    }

    private int findLastNumber(List<Integer> arr){ //создание 13-ого числа для глна
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

    private String createdGln() {
        Random random = new Random();
        List<Integer> gln = new ArrayList<>(List.of(9, 8, 7, 9, 8, 7, 0, 0,
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10)));
        gln.add(findLastNumber(gln));
        return gln.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //метод запроса
    private void generateGLns(){
        String gln = createdGln();
        if (!hashFromDatabase.contains(gln)) hash.add(gln);
        else generateGLns();
    }

    public void getGlns(int in){
        hash.clear();              //отчистка стэка от старых запросов, для новых
        while (hash.size() < in){  //запросы
            generateGLns();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        getGLN = new javax.swing.JTextField();
        generateGLN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outGLN = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getGLN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getGLN.setToolTipText("Введите количество штрих-кодов.");
        getGLN.setDocument(new JTextFieldLimit(2)); //n-ое значность ввода чисел (1->9) (2->99) (3->999) ect...
        getGLN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c < '0') && (c !=KeyEvent.VK_BACK_SPACE) || (!Character.isDigit(c))){
                    e.consume();
                }
            }
        });

        generateGLN.setText("Создать штрих-код");
        generateGLN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateGLNActionPerformed(evt);
            }
        });

        jLabel1.setText("Поле для ввода");

        jLabel2.setText("Поле для вывода");

        outGLN.setColumns(20);
        outGLN.setRows(5);
        outGLN.setEditable(false);
        outGLN.setToolTipText("Здесь вы можите копировать созданные штрих-кода.");
        jScrollPane1.setViewportView(outGLN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(getGLN)
                        .addComponent(generateGLN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getGLN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(generateGLN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void generateGLNActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        outGLN.removeAll();
        try {
            int len = Integer.parseInt(getGLN.getText());
            if (len==0) outGLN.setText("Внимание сотрудник!\n" + "Удалено: " + jokeRemove + " штрих кодов.");
            else {
                getGlns(len);
                jokeRemove = hash.size();
                String theEndResult = "";
                for (String ect : hash)
                    theEndResult = theEndResult + ect +"\n";
                outGLN.setText(theEndResult);
            }
        } catch (NumberFormatException e) {
            outGLN.setText("Please enter the number of barcodes.\n"
                    +"Пожалуйста введите количество штрих кодов.\n"
                    +"Будь ласка введіть кількість штрих кодів.\n");
        }

    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) { //перезагрузка программы, перепишите если заните как улучшить.
        File openFile = new File(System.getProperty("user.dir")+"\\restart.bat");
        try {
            Desktop.getDesktop().open(openFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneratorGLN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratorGLN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratorGLN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratorGLN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratorGLN();
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton generateGLN;
    private javax.swing.JTextField getGLN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outGLN;

    // End of variables declaration
}

