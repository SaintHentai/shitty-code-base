import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GeneratorGLN extends javax.swing.JFrame implements WindowListener { //господи я такой говнокодер

    protected String cmdRestart = "r";
    protected boolean closeApp = false;

    /**
     * Creates new form GeneratorGLN
     */
    public GeneratorGLN() {
        initComponents();
        this.setTitle("App Generator GLN");
        this.setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\st.jpg").getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(this);
        Thread t = new WatchMemory();
        t.start();

        outGLN.setText(" Info : \n"
                +"1. Max size generated of barcodes is 20.\n"
                +"2. Program make restart if worked so long time.\n"
                +"3. Input <-- [0] ;  Generate GLN ;  Output --> Clear...\n"
                +"4. Input <-- [1] ;  Generate GLN ;  Output --> 98798700*****  : 1\n"
                +"5. Input <-- [221297] ;  Generate GLN ;  Output --> message from Author.\n"
                +"6. Input <-- [r] ;  Generate GLN ; Initializing program restart.\n"
                +"7. Input <-- [  ] ;  Generate GLN ;  Output --> Please enter the number of barcodes.\n");
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
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runtime.getRuntime().gc();
                globalTime = globalTime - cutTime;
                System.out.println(globalTime);
                if (globalTime == end || closeApp){
                    outGLN.removeAll();
                    int time = 10;
                    while(time --> end){
                        outGLN.setText("Restart program from: " + time + " second." + "\n");
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
        getGLN.setToolTipText("Give a number of barcodes");

        generateGLN.setText("Generate GLN");
        generateGLN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateGLNActionPerformed(evt);
            }
        });

        jLabel1.setText("Input of barcodes");

        jLabel2.setText("Output of barcodes");

        outGLN.setColumns(20);
        outGLN.setRows(5);
        outGLN.setToolTipText("Here you can copy generated barcode");
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
            if (getGLN.getText().intern() == cmdRestart){
                closeApp = true;
            }else{
                int len = Integer.parseInt(getGLN.getText());
                if (len == 0){
                    outGLN.setText("Clear...");
                }else if(len == 221297){
                    outGLN.setText(" Привет я Константин.\n"
                            +" Я парень который создал это десктоп приложение.\n"
                            +" Надеюсь оно тебе понравиться, не важно кто ты.\n"
                            +" В жизни бывает много плохого, главное не падать духом.\n"
                            +" Если вам очень плохо, подумайте о чем нибудь приятном.\n"
                            +" Или сделайте что нибудь приятное себе или ближнему своему.\n"
                            +" No war! Make Love!.\n"
                    );
                } else if (len < 21) {
                    LogicGLN log = new LogicGLN();
                    StringBuilder theEndResult = new StringBuilder();
                    for (int i = 0; i < len; i++) {
                        theEndResult.append(log.getGLN()+"\n");
                    }
                    outGLN.setText(String.valueOf(theEndResult));
                } else {
                    outGLN.setText("The maximum number of generations is 20 barcodes.\n"
                            +"Максимальное количество 20 штрих кодов.\n"
                            +"Максимальна кількість генерацій 20 штрих кодів.\n");
                }
            }
        } catch (NumberFormatException e){
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
    public void windowClosed(WindowEvent windowEvent) { //перезагрузка программы
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