class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        for (String word : wordlist) {
            set.add(word);
            caseMap.putIfAbsent(word.toLowerCase(), word);
        }

        for (int i = 0; i < queries.length; i++) {
            String str1 = queries[i];
            if (set.contains(str1)) {
                continue;
            }
            String lower = str1.toLowerCase();
            if (caseMap.containsKey(lower)) {
                queries[i] = caseMap.get(lower);
                continue;
            }
            boolean flag = false;
            for (String str2 : wordlist) {
                if (str1.length() != str2.length()) {
                    continue;
                }

                int k = 0;
                while (k < str1.length() &&
                        ((isV(str1.charAt(k)) && isV(str2.charAt(k))) ||
                                Character.toLowerCase(str1.charAt(k)) == Character.toLowerCase(str2.charAt(k)))) {
                    k++;
                }

                if (k == str1.length()) {
                    flag = true;
                    queries[i] = str2;
                    break;
                }
            }
            if(!flag){
                queries[i] = "";
            }
        }
        return queries;
    }

    private boolean isV(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }

}