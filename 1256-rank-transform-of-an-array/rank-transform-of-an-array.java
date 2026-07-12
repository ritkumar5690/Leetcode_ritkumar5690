class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int nums[] = new int[arr.length];
        if (arr.length == 0)
            return new int[] {};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        int ans[] = new int[arr.length];
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[i] = map.get(nums[i]);
                continue;
            }
            int j = binary(list, nums[i]);
            if (nums[i] == list.get(j)) {
                ans[i] = j + 1;
                map.put(nums[i], j + 1);
            }
        }
        return ans;
    }

    private int binary(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target)
                return mid;
            else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}