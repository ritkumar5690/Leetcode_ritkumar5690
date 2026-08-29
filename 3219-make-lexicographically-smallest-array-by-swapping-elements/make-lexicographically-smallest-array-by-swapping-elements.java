class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int arr[] = nums.clone();
        Arrays.sort(arr);
        int groupNum = 0;
        Map<Integer, Integer> mapGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> mapList = new HashMap<>();

        mapGroup.put(arr[0],groupNum);
        mapList.putIfAbsent(groupNum, new LinkedList<>());
        mapList.get(groupNum).add(arr[0]);


        for(int i = 1;i<n;i++){
            if(Math.abs(arr[i] - arr[i-1])> limit){
                groupNum++;
            }
            mapGroup.put(arr[i],groupNum);
             mapList.putIfAbsent(groupNum, new LinkedList<>());
            mapList.get(groupNum).add(arr[i]);
        }

        int res[] = new int[n];
        for(int i = 0;i<n;i++){
            int group = mapGroup.get(nums[i]);
            res[i] = mapList.get(group).pollFirst();
        }
        return res;
    }
}