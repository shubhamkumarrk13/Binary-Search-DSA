// Problem Link : https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {

    public long findTime(int[] piles, long mid) {

        long cnt = 0;

        for(int i=0; i<piles.length; i++) {

            cnt = cnt + (piles[i] / mid);
            
            if((piles[i] % mid) != 0) cnt = cnt + 1;
        }

        return cnt;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;

        int high = Integer.MIN_VALUE;

        for(int ele : piles) high = Math.max(high, ele);

        int result = high;

        while(low <= high) {

            long mid = low + (high - low)/2;

            long time = findTime(piles, mid);

            if(time > h) low = (int) mid + 1;

            else {

                result = Math.min(result, (int) mid);

                high = (int) mid - 1;
            }
        }

        return result;
        
    }
}
