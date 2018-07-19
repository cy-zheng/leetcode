class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int v = V; v > 0; v--) {
            int leftIndex = K;
            int leftMin = heights[K];
            for (int i = K; i >= 0; i--) {
                if (heights[i] < leftMin) {
                    leftIndex = i;
                    leftMin = heights[i];
                } 
                else if (heights[i] > leftMin)
                    break;
            }
            
            if (leftIndex != K) {
                heights[leftIndex] += 1;
                continue;
            }
            
            int rightIndex = K;
            int rightMin = heights[K];
            for (int i = K; i < heights.length; i++) {
                if (heights[i] < rightMin) {
                    rightMin = heights[i];
                    rightIndex = i;
                }
                else if (heights[i] > rightMin)
                    break;
            }
            
            if (rightIndex != K) {
                heights[rightIndex] += 1;
                continue;
            }
            
            heights[K] += 1;
        }
        return heights;
    }
}
