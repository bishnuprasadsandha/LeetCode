class Solution {
    public int maximumCount(int[] nums) {
    
        int count_positive = 0;
        int count_negative = 0;
        for(int n : nums){
            if(n > 0){
                count_positive ++;
            }
            else if(n < 0){
                count_negative ++;
            }
        }
        if(count_positive > count_negative){
            return count_positive;
        }
        else if(count_positive < count_negative){
             return count_negative;
        }
        else if(count_positive == count_negative){
             return count_positive;
        }
        return 0;
    }
}