class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int nums[] = new int[arr.length]; 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums);
        int i = 1;
        for(int ele : nums){
            if(!map.containsKey(ele)){
                map.put(ele,i++);
            }
        }
        for(int j =0;j<arr.length;j++){
            arr[j] = map.get(arr[j]);
        }
        return arr;
    }
}