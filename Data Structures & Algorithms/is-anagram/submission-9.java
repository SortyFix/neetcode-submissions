class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; 
        int l = s.length();

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if(hm1.containsKey(c)) {
                int oldValue = hm1.get(c);
                hm1.put(c, oldValue + 1);
                continue;
            }
            hm1.put(c, 1);
        }

        for(int i = 0; i < l; i++) {
            char c = t.charAt(i);
            if(hm2.containsKey(c)) {
                int oldValue = hm2.get(c);
                hm2.put(c, oldValue + 1);
                continue;
            }
            hm2.put(c, 1);
        }

        return Objects.equals(hm1, hm2);
    }
}
