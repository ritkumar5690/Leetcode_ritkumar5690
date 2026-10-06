class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int val = 0;
        int temp = 0;
        int j = 0;
        for(int i =0;i<gas.length;i++){
            int diff = gas[i]-cost[i];
            temp += diff;
            val += diff;
            if(val<0){
                val = 0;
                j = i+1;
            }
            
        }
        return (temp < 0)?-1:j;
    }
}
