class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result(candidates,0,ans,list,target);
        return ans;
    }
    private void result(int[] nums,int j ,List<List<Integer>> ans, List<Integer> list,int target){
        if(target == 0){
            ans.add(new ArrayList<>(list));;
            return ;
        }
        for(int i =j;i<nums.length;i++){
            if(nums[i] <= target){
                list.add(nums[i]);
                result(nums,i,ans,list,target-nums[i]);
                list.remove(list.size()-1);
            }
        }
    }
}