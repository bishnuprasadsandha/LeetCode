class Solution {
    public String reverseWords(String s) {
        String words[] = s.trim().split("\\s+");
        String revStr = "";

        for (int i = words.length - 1; i >= 0; i--) {
            revStr = revStr + words[i] + " ";
        }

        return revStr.trim();
    }
}
