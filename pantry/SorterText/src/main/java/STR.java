public class STR {

    private static final int CUTOFF =  15;   // диапазон для малых подмассивов
    private String[] theArray;
    private int nElems;

    public STR(){}
    public STR(String[] str){
        nElems = str.length;
        theArray = new String[nElems];
        for (int i = 0; i < nElems; i++) {
            theArray[i] = delWorkSpace(str[i]);
        }
    }
    public void sort() {
        sort(theArray, 0, nElems-1, 0);
    }
    public void display(){
        for (int i = 0; i < nElems; i++)
            System.out.print(theArray[i]+" ");
        System.out.println();
    }
    public int length(){
        return nElems;
    }
    public String[] getTheArray(){
        return theArray;
    }
    public String delWorkSpace(String s){
        String result = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] !=' ')
                result = result.concat(String.valueOf(arr[i]));
        }
        return result;
    }
    private int charAt(String s, int position) {
        assert position >= 0 && position <= s.length();
        if (position == s.length()) return -1;
        return s.charAt(position);
    }
    private void sort(String[] arr, int low, int high, int key) {
        // сортировка для маллых массиов
        if (high <= low + CUTOFF) {
            insertion(arr, low, high, key);
            return;
        }
        int left = low, hi = high;
        int charValues = charAt(arr[low], key);
        int i = low + 1;
        while (i <= hi) {
            int temp = charAt(arr[i], key);
            if (temp < charValues) swap(arr, left++, i++);
            else if (temp > charValues) swap(arr, i, hi--);
            else i++;
        }
        sort(arr, low, left - 1, key);
        if (charValues >= 0)
            sort(arr, left, hi, key+1);
        sort(arr, hi + 1, high, key);
    }
    private void insertion(String[] arr, int low, int high, int pos) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && less(arr[j], arr[j - 1], pos); j--)
                swap(arr, j, j - 1);
    }
    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private boolean less(String v, String w, int pos) {
        assert v.substring(0, pos).equals(w.substring(0, pos));
        for (int i = pos; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

}