class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            while (!list.isEmpty()) {
                int top = list.get(list.size() - 1);
                int g = Gcd(top, num);
                if (g == 1) {
                    break;
                }
                list.remove(list.size() - 1);
                num = (top / g) * num; 
            }
            list.add(num);
        }

        return list;

    }

    private int Gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Gcd(b, a % b);
    }
}