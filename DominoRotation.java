//TC : O(N)
//SC : O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops==null || tops.length==0) return 0;

        int top = helper(tops,bottoms,tops[0]);

        if(top == -1)
            return helper(tops,bottoms,bottoms[0]);
        else
            return top;
    }

    private int helper(int[] tops,int[] bottoms,int target){

        int topTurns = 0;
        int bottomTurns = 0;
        int i= 0;

        while(i!=tops.length){
            if(tops[i] != target && bottoms[i]!=target) return -1;

            if(tops[i]!=target)
                topTurns++;

            if(bottoms[i]!=target)
                bottomTurns++;

            i++;
        }
        return Math.min(topTurns,bottomTurns);
    }
}