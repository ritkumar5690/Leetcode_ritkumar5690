class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int step = 1;
        for(String node : arr){
            if(step == 0) return false;
            step--;
            if(!node.equals("#")){
                step = step+2;
            }

        }
        return step == 0;
    }
}