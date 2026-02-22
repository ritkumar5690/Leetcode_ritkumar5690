class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        while(num >= 10){
            int temp1 = num;
            int sum =0;
            while(temp1 !=0){
                int temp = temp1 %10;
                sum += temp;
                temp1=temp1/10;
            }
            num = sum;
        }
        return num;
    }
}