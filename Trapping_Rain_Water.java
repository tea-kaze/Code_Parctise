public class Trapping_Rain_Water {
    /*
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

     解题思路（双指针）：
     - 使用两个指针 `left` 和 `right` 分别从数组两端向中间移动。
     - 同时维护 `leftMax` 和 `rightMax`，分别表示到当前为止左边和右边见过的最高柱子高度。
     - 在任意时刻，较小一侧的 `max` 决定该侧当前位置的可接水量。例如当 `leftMax < rightMax` 时，左侧位置的水位不会超过 `leftMax`，因此可以根据 `leftMax - height[left]` 累加能接的水。
     - 每次移动较小一侧的指针，更新对应的 `max`，并累加 `max - height[pos]`（实现中通过先移动指针再更新 max 保证累加值非负）。

     复杂度：时间 O(n)，空间 O(1)
    */
    public int trap(int[] height) {
        int n = height.length;
        // 边界：空数组无水
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        // 初始化左右指针与左右最大高度
        int leftMax = height[left], rightMax = height[right];
        // 累计接到的水量
        int waterTrapped = 0;

        while (left < right) {
            // 每次移动较小一侧的指针，这样可以确定当前侧的水位由该侧的 max 决定
            if (leftMax < rightMax) {
                // 处理左侧：移动左指针，更新左边最大高度，并累加该位置能接的水
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
            } else {
                // 处理右侧：移动右指针，更新右边最大高度，并累加该位置能接的水
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
            }
        }

        return waterTrapped;
    }
    public static void main(String[] args) {
        Trapping_Rain_Water solution = new Trapping_Rain_Water();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = solution.trap(height);
        System.out.println("Trapped rain water: " + result); // Expected output: 6
    }
}
