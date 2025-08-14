class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                if (max.isEmpty() || sub.compareTo(max) > 0) {
                    max = sub;
                }
            }
        }
        
        return max;
    }
}