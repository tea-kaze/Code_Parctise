public class Trapping_Rain_Water2 {
    public static void main(String[] args) {
        //1.定义高度数组
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        // 边界检查：数组为 null 或 长度小于 3 时无法盛水
        if (height == null || height.length < 3) {
            System.out.println("Trapped rain water: 0");
            return;
        }

        //2.定义左右最大高度数组
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        //3.计算左最大高度
        int temp = height[0];
        for(int i=0;i<height.length;i++){
            if(height[i]>temp){
                temp = height[i];
            }
            leftMax[i] = temp;
        }

        //4.计算右最大高度
        temp = height[height.length - 1];
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>temp){
                temp = height[i];
            }
            rightMax[i] = temp;
        }

        //5.计算接水量
        int waterTrapped = 0;
        for(int i=0;i<height.length;i++){
            //当前位置能接的水量取决于左右最大高度的较小值(交集)减去当前位置高度
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        System.out.println("Trapped rain water: " + waterTrapped); // Expected output: 6
    }
}