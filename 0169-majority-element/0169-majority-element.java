class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int n = 0;
        for(int num : nums){
            if(count == 0){
                n = num;
            }
            count +=(num == n) ? 1 : - 1;
        }
        return n;
        
    }
}