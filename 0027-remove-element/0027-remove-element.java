class Solution {
    public int removeElement(int[] nums, int val) {
        
        Arrays.sort(nums);
        int i = 0, n = nums.length, valStartInd = -1;

        while(i < n && nums[i] <= val) {
            if(valStartInd == -1 && nums[i] == val) valStartInd = i;
            i += 1;
        }

        if(valStartInd == -1) return n;
        
        int elements = n - (i - valStartInd);
        while(i < n && valStartInd < n) nums[valStartInd++] = nums[i++];
        return elements;
    }
}