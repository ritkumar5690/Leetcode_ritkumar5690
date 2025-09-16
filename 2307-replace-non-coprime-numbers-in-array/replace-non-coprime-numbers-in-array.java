class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        for (int num : nums) {
            stk.push(num);

            while (stk.size() > 1) {
                int a = stk.pop();
                int b = stk.pop();
                int gcd = Gcd(a, b);

                if (gcd > 1) { 
                    long lcm = (long) a * b / gcd;
                    stk.push((int) lcm);
                } else {
                    stk.push(b);
                    stk.push(a);
                    break;
                }
            }
        }
        return new ArrayList<>(stk);
    }

    private int Gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Gcd(b, a % b);
    }
}