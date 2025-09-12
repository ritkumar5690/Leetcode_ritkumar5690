class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int i =0;
        result(candidates,i,ans,list,target);
        return ans;
    }
    private void result(int[] nums,int i ,List<List<Integer>> ans, List<Integer> list,int target){
        if(target == 0){
            ans.add(new ArrayList<>(list));;
            return ;
        }
        if(target < 0){
            return ;
        }
        if( i >= nums.length){
            return ;
        }
        list.add(nums[i]);
        
        
        result(nums,i,ans,list,target-nums[i]);
        list.remove(list.size()-1);
        result(nums,i+1,ans,list,target);
    }
}