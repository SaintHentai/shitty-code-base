import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OldSource {

    /*public static void open(String s){
        long []arr;
        int size = -1;
        int record = 0;

        String fileExt = "";
        String path = "";
        String dataTXT;

        File srcFolder = new File(s);
        File[] fileList = srcFolder.listFiles();
        for (File file:fileList) {
            if (file.isFile()){

                path = file.getAbsolutePath();
                fileExt = path.substring(path.lastIndexOf(".")+1);

                if (fileExt.equalsIgnoreCase("txt")){
                    File openFile = new File(path);
                    try {
                        Scanner scan = new Scanner(openFile);
                        while (scan.hasNextLine()){
                            dataTXT = scan.nextLine();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }*/

    /*private static long[] getScan(String s){
        String str;
        long []arr;
        int size = 0;
        int record = 0;


        try {
            Scanner scan = new Scanner(new File(s));
            while (scan.hasNextLine()){
                scan.nextLine();
                size++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        arr = new long[size];
        try {
            Scanner scan = new Scanner(new File(s));
            while (scan.hasNextLine()){
                str = scan.nextLine();
                arr[record] = Integer.parseInt(str);
                record++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(arr);
        return arr;
    }*/

    /*public static void getData(String arg) throws IOException {

        int count = 0;

        String mainPath = System.getProperty("user.dir") + File.separator;
        String[] dataFromPaths, dataInt;

        System.out.println(mainPath);

        String wall = "wall";
        String paths = "";
        String data = "";

        Scanner scan = new Scanner(new File(mainPath  + arg + ".txt"));
        while (scan.hasNextLine()){
            paths = paths.concat(mainPath + scan.nextLine() + ".txt" + wall);
        }

        dataFromPaths = paths.split(wall);
        for (String ect: dataFromPaths) {
            Scanner sc = new Scanner(new File(ect));
            while (sc.hasNextLine()){
                data = data.concat(sc.nextLine() + wall);
                count++;
            }
        }

        theArray = new long[count];
        nElems = 0;

        dataInt = data.split(wall);
        for (String ect: dataInt) {
            theArray[nElems] = Integer.parseInt(ect);
            nElems++;
        }

        display();
        mergeInt();
        display();


        File newFile = new File("newFile.txt");
        if (!newFile.exists())
            newFile.createNewFile();

        PrintWriter pw = new PrintWriter(newFile);
        for (int i = 0; i < nElems; i++){
             pw.println(theArray[i]);
        }
        pw.close();

    }*/

    /*public void outData(String arg) throws IOException {

        System.out.println(mainPath);

        Scanner scan = new Scanner(new File(mainPath  + arg + ".txt"));
        while (scan.hasNextLine()){
            paths = paths.concat(mainPath + scan.nextLine() + ".txt" + wall);
        }

        dataFromPaths = paths.split(wall);
        for (String ect: dataFromPaths) {
            Scanner sc = new Scanner(new File(ect));
            while (sc.hasNextLine()){
                data = data.concat(sc.nextLine() + wall);
                count++;
            }
        }

        array = new Array(count);

        dataInt = data.split(wall);
        for (String ect: dataInt) {
            array.insert(Integer.parseInt(ect));
        }

        array.display();
        array.mergeInt();
        array.display();

        File newFile = new File("newFile.txt");
        if (!newFile.exists())
            newFile.createNewFile();

        PrintWriter pw = new PrintWriter(newFile);
        for (int i = 0; i < array.length(); i++){
             pw.println(array.getTheArray()[i]);
        }
        pw.close();
    }*/

    //!Character.isDigit(charArray[i]) && Character.isDigit(charArray[i]) || Character.isDigit(charArray[i])

    /*Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(str);
        while (m.find()){
            result = result.concat(result + m.group());
        }*/

    /*import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class MergeInt {

        private long[] theArray;
        private int nElems;
        private static final int CUTOFF = 7;

        //передаем массив строк в массив чисел
        public MergeInt(String[] arr){
            theArray = new long[arr.length];
            nElems = 0;
            for (String ect: arr){
                theArray[nElems] = Integer.parseInt(onlyInt(ect));
                nElems++;
            }
        }
        //выбираем из строк только цифры
        private String onlyInt(String str){
            String result = "";
            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(str);
            while (m.find()){
                result = result.concat(result + m.group());
            }
            return result;
        }
        public int length(){
            return nElems;
        }
        public long[] getTheArray(){
            return theArray;
        }
        public void display(){
            for (int i = 0; i < nElems; i++)
                System.out.print(theArray[i]+" ");
            System.out.println();
        }
        public void sort(){
            div(theArray,0,nElems-1);
        }
        // слияние: для 8 < arr.len и вставка: для arr.len <= 7
        // на данный момент тут восходящая сортировка, так что не нужный код закоментен
        private void div(long[] arr, int left, int right){
            if (left == right)
                return;
            else if (right <= left + CUTOFF){
                insertSort(arr);
                return;
            }
            else{
                for (int len = 1; len < nElems; len *= 2){
                    for (int lo = 0; lo < nElems - len; lo +=len+len){
                        int mid = lo + len - 1;
                        int hi = Math.min(lo+len+len-1,nElems-1);
                        merge(arr,lo, mid, hi);
                    }
                }
                int mid = (left + right)/2;
                div(arr,left, mid);
                div(arr, mid+1,right);
                merge(arr,left,mid,right);
            }
        }
        //сортировка слиянием на месте
        private void merge(long[] arr, int start, int mid, int end) {
            int start2 = mid + 1;
            // Если прямое слияние уже отсортировано
            if (arr[mid] <= arr[start2]) {
                return;
            }
            // проходим по двум частям единого массива
            // от начала к середине и от середины до конца
            while (start <= mid && start2 <= end) {
                // Если один элемент находится в нужном месте, то все збс
                if (arr[start] <= arr[start2]) {
                    start++;
                }
                //отныне конец это маленькое, а начало большое
                else {
                    long cur = arr[start2];
                    int index = start2;
                    // сдвиг всех элементов в отношении одного
                    // двигаемся от конца к началу и делаем перезапись
                    while (index != start) {
                        arr[index] = arr[index - 1];
                        index--;
                    }
                    arr[start] = cur;
                    // обновление точек и продвижение вперед
                    start++;
                    mid++;
                    start2++;
                }
            }
        }
        //сортировка вставкой для малых массиов
        private void insertSort(long[] arr){
            int in, out;
            for (out = 1; out < nElems; out++){
                long cur = arr[out];
                in = out;
                // сдвиг в право покуда не найдеться нужный элемент
                while (in > 0 && arr[in - 1] >= cur){
                    arr[in] = arr[in - 1];
                    --in;
                }
                arr[in] = cur;
            }
        }
    }*/


}
