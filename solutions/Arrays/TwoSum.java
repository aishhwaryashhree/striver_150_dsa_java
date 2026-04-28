// Day 1: Striver SDE Sheet - Two Sum (LC1)
// Aishwarya Shree | Jamshedpur | April 2026
// V1 Brute Force O(n²) → V2 HashMap O(n) PATTERN UNLOCKED
import java.util.HashMap;
class Solution {
    // V1: BRUTE FORCE - Nested loops (my original idea)
    public static int[] twoSumV1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {  // j=i+1 fixes self-check
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];  // No solution
    }
    
    // V2: HASHMAP OPTIMAL - O(n) time, O(n) space
    // Pattern: "target sum" → HashMap number→index lookup
    public static int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  // number → index
        
        for(int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            
            if(map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            
            map.put(nums[i], i);  // Store AFTER check (handles dups)
        }
        return new int[0];
    }
    
    // Test driver (run locally)
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.println("V1 Brute: " + 
            java.util.Arrays.toString(twoSumV1(nums, target)));
        System.out.println("V2 HashMap: " + 
            java.util.Arrays.toString(twoSumV2(nums, target)));
    }
}
