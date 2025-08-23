class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ;
        int a = 0;
        for(int n : nums){
            if(count == 0){
                a = n;
            }
            if(n == a){
                count++;
                }
                else{
                    count--;
                }
        }
        return a;
    }
}