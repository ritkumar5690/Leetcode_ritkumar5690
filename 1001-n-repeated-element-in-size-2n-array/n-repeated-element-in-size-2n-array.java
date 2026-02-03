class Solution {
    public int repeatedNTimes(int[] nums) {
        int count[] = new int[10001];
        int n = nums.length;
        for(int i= 0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int temp = n / 2;
        for(int i= 0;i<10001;i++){
            if(count[i] == temp){
                temp = i;
                break;
            }
        }
        return temp;
    }
}