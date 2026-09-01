class Solution {

    public String encode(List<String> strs) {
        String ans = "";

        for (int i = 0; i < strs.size(); i++) {
            int m = strs.get(i).length();
            ans += (m + "#" + strs.get(i));
        }

        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            // Get length of string
            String tempLen = "";
            while (str.charAt(i) != '#') {
                tempLen += str.charAt(i);
                i++;
            }
            int len = Integer.parseInt(tempLen);

            // Move i to next of '#'
            i++;

            String temp = "";
            for (int j = 0; j < len; j++) {
                temp += str.charAt(i);
                i++;
            }
            ans.add(temp);
        }

        return ans;
    }
}
