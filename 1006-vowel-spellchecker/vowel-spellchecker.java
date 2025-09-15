class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            exact.add(w);
            caseMap.putIfAbsent(w.toLowerCase(), w);
            vowelMap.putIfAbsent(devowel(w.toLowerCase()), w);
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q))
                continue;
            String lower = q.toLowerCase();
            if (caseMap.containsKey(lower)) {
                queries[i] = caseMap.get(lower);
                continue;
            }
            String vkey = devowel(lower);
            if (vowelMap.containsKey(vkey)) {
                queries[i] = vowelMap.get(vkey);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }

    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0)
                sb.append('*');
            else
                sb.append(c);
        }
        return sb.toString();
    }

}