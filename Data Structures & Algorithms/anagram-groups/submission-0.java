class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> outerMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> innerMap = new HashMap<>();
            List<String> list = new ArrayList<>();
            for (int j = 0; j < strs[i].length(); j++) {
                innerMap.put(strs[i].charAt(j), innerMap.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            if (outerMap.containsKey(innerMap)) {
                List<String> temp = outerMap.get(innerMap);
                temp.add(strs[i]);
                outerMap.put(innerMap, temp);
            } else {
                list.add(strs[i]);
                outerMap.put(innerMap, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : outerMap.entrySet()) {
            List<String> temp = entry.getValue();
            ans.add(temp);
        }

        return ans;
    }
}
