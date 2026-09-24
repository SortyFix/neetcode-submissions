class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; 

        Hashtable<Character, Integer> hm1 = new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> hm2 = new Hashtable<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(hm1.containsKey(c)) {
                int oldValue = hm1.get(c);
                hm1.put(c, oldValue + 1);
                continue;
            }
            hm1.put(c, 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(hm2.containsKey(c)) {
                int oldValue = hm2.get(c);
                hm2.put(c, oldValue + 1);
                continue;
            }
            hm2.put(c, 1);
        }

        System.out.println(hm1.toString());
        System.out.println(hm2.toString());

        return Objects.equals(hm1, hm2);
    }
}
