class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i = 0; i < nums.length; i++)
        {
            int prevSize = ht.size();
            ht.put(nums[i], nums[i]);
            if(ht.size() == prevSize) return true;
        }
        return false;
    }
}