//TC : O(mlogn)
//sc : O(1)
class Solution {
    public int shortestWay(String source, String target) {
        if(source.equals(target)) return 0;

        HashMap<Character,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<source.length();i++)
        {
            char c = source.charAt(i);
            if(!hm.containsKey(c))
                hm.put(c,new ArrayList<Integer>());
            hm.get(c).add(i);
        }

        int sIdx = 0;
        int tIdx = 0;
        int result = 1;
        int sl = source.length();
        int tl = target.length();

        while(tIdx!=tl){
            char c = target.charAt(tIdx);
            if(!hm.containsKey(c))
                return -1;

            List<Integer> list = hm.get(c);

            int k = Collections.binarySearch(list, sIdx);

            if(k < 0) {
                k = -k - 1;
            }

            if(k == list.size()) {
                sIdx = 0;
                result++;
            } else {
                sIdx = list.get(k) + 1;
                tIdx++;
            }

        }
        return result;
    }
}