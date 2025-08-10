import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n == 0){
            return false;
        }
        int[] targetFreq = digitCount(n);

        for (int i = 0; i < 31; i++) {
            int[] powerFreq = digitCount(1 << i);
            if (Arrays.equals(targetFreq, powerFreq)) {
                return true;
            }
        }
        return false;
    }
    
    private int[] digitCount(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }
}