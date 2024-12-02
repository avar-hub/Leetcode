class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int len = searchWord.length();
        int count = 1;
        for(String word : words) {
            if(word.length() >= len && word.substring(0,len).equals(searchWord)) {
                return count;
            }
            count++;
        }
        return -1;
    }
}