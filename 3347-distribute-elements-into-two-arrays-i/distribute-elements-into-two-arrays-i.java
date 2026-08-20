class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int j1= 0, j2 = 0;
        for(int i = 2;i<nums.length;i++){
            if(list1.get(j1)>list2.get(j2)){
                list1.add(nums[i]);
                j1++;
            }
            else{
                list2.add(nums[i]);
                j2++;
            }
        }
        int res[] = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(i<list1.size()){
                res[i] = list1.get(i);
            }
            else{
                res[i] = list2.get(i-list1.size());
            }
        }
        return res;
    }
}