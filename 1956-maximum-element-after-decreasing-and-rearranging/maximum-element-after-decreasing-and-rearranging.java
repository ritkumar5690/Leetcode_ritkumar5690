class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int count =0;
        int j =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > j){
                count++;
                j++;
            }
           
        }
        return count;
    }
}