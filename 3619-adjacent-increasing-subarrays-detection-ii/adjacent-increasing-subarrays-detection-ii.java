class Solution {
    public int maxIncreasingSubarrays(List<Integer> list) {
        int n = list.size();
        
        int maxlen = 0,count = 1;;
        for(int i =0;i<n-1;i++){
            int cnt = 1;
            if(list.get(i) < list.get(i+1)){
                count++;
            }
            else{
                if(count > maxlen) maxlen = count;
                count = 1;
            }   
        }
        if(count > maxlen) maxlen = count;
        System.out.print(maxlen);
        maxlen = maxlen/ 2;
        int i=0;
        int min = 1,max=1;
        while(i<n-1){   
            int cnt1 = 1, cnt2 = 1;
            while(i < n - 1 && list.get(i) < list.get(i+1)){
                i++;
                cnt1++;
            }
            int j = i + 1;
            while(j<n-1 && list.get(j) < list.get(j+1)){
                j++;
                cnt2++;
            }
            min = Math.min(cnt1,cnt2); 
            max = Math.max(min,max);
            i++;
        }
        return (max < maxlen) ? maxlen : max;
    }
}