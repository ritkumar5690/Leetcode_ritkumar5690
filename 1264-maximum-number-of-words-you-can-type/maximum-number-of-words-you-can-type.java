class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // int n = text.length();
        int count = 0,j=0,spa = 0;
        int m = brokenLetters.length();
        String[] arr = text.split(" ");
        int size = arr.length;
        if(m == 0) return size;
        while(j < size){
            String str = arr[j];
            for(int i =0;i<m;i++){
                char ch = brokenLetters.charAt(i);
                if(str.contains(String.valueOf(ch))){
                   count++;
                   break;
                }
            }
            j++;
        }
        return size-count;
    }
}