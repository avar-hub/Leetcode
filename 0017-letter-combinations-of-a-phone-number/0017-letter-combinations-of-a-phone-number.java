class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return solve(map, digits, 0, "", ans);
    }

    private List<String> solve(Map<Character,String> map, String digits, int ind,  String temp, List<String> ans) {

        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        if(ind >= digits.length()) {
            ans.add(temp);
            return ans;
        }
        String str = map.get(digits.charAt(ind));
        for(int i = 0 ; i < str.length(); i++) {
            temp += str.charAt(i); 
            solve(map, digits, ind+1, temp, ans);
            temp = temp.substring(0, temp.length() - 1);
        }
        return ans;
    }
}