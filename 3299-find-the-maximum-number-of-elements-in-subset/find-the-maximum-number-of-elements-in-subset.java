class Solution {
    public int maximumLength(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int countOne = 0;
        for(int i=0;i<nums.length;i++){
            countOne += (nums[i]== 1)? 1:0;
        }
        if(countOne %2 ==0)  countOne--;
        countOne = Math.max(countOne, 0);

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                list.add(nums[i]);
                set2.add(nums[i]);
            }
            set.add(nums[i]);
        }
        int res = 1;
        for(int i=0;i<list.size();i++){
            int n = list.get(i);
            if(n==1) continue;
            int count = 0;
            while(set2.contains(n)){
                count += 2;
                n = n*n;
            }
            count += set.contains(n)? 1:-1;
            if(res < count) res = count;
        }
        return countOne > res ? countOne: res;
    }
}