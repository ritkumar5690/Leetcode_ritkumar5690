class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> count = new HashMap<>();

        for(int i:hand){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        for (int card : hand) {

            if (count.get(card) == 0) {
                continue;
            }

            int freq = count.get(card);
            for(int i=0;i<groupSize;i++){
                int curr = i + card;
                if (count.getOrDefault(curr, 0) < freq) {
                    return false;
                }

                count.put(curr,count.get(curr) - freq);
            }
        }
        return true;
    }
}