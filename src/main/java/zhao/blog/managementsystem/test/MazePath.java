package zhao.blog.managementsystem.test;

import java.util.ArrayList;
import java.util.List;

	public class MazePath{
		public static List<Point> path = new ArrayList<Point>();
		public static List<List<Point>> pathes = new ArrayList<List<Point>>();
		public static int block = 0;//不可通过
		public static int access = 1;//可以通过
		public static int target = 9;//目标
		public static void main(String[] args) {
			int[][] grid = {{1,1,0,0,1,1,1,1,1,0,1,1,1,0,1,1,1},
							{0,1,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1},
							{1,0,1,1,0,0,0,1,1,0,1,0,1,0,0,1,1},
							{1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0},
							{1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,0,0},
							{1,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1},
							{1,0,1,1,0,0,0,1,9,0,0,1,1,1,0,0,1},
							{1,0,1,0,0,1,0,1,1,0,0,0,1,1,1,0,1},
							{1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,0,0},
							{1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1,0},
							{1,0,1,0,1,0,1,1,0,0,0,0,0,1,0,1,0},
							{1,1,1,0,1,0,1,1,0,0,1,0,1,1,0,1,1},
							{0,1,0,1,1,0,1,1,0,0,1,1,1,0,1,0,1},
							{1,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1}};
			
			dfs(grid, new Point(0, 0), path);
			if(pathes.size() > 0){
				for(List<Point> posibility : pathes){
					System.out.println("============");
					System.out.println(posibility);
				}
			}
		}
		/**
		 * 
		 * 		S * * * * <br/>
		 * 		* - * - - <br/>
		 * 		- - * - - <br/>
		 * 		* * * - - <br/>
		 * 		- * - * - <br/>
		 * 		* E * * - <br/>
		 * 计算从S开始，沿着星号（*）前进，横线（-）表示不可通过，到达E点的所有可行路径。 <br/>
		 * 这里使用了深度优先算法进行遍历，从起点(0,0)开始，由于目标点所在的坐标在起点的右下方，所有优先遍历右边和下边的点。 <br/>
		 * 但是，这里也有例外，虽然目标点在起点右下方，但是在前进过程中仍然需要向左/上移动，比如： <br/>
		 * 		S - - - - <br/>
		 * 		* - * * * <br/>
		 * 		* - * - * <br/>
		 * 		* - E - * <br/>
		 * 		* - - - * <br/>
		 * 		* * * * * <br/>
		 * 每个点出发有四个方向可以移动，如果超出边界则不移动，移动到下一个点之后如果这个点表示不可通过（-）则返回false。<br/>
		 * 每经过一个点，会先将其放入path列表中，表示该点已经走过，避免下一个点返回后重复造成死循环。比如A点向右移动到B点，B点可以向左移动到A点，
		 * 重复此步骤会造成死循环。因此需要一个列表记录所走过的点，同时，在遍历完该点四个方向的点之后表示递归这个点及该点之后所有可行路径结束，从
		 * 列表中移除改点，从其他方向来的点可以继续通过该点。
		 * 		* * -
		 * 		- A B
		 * 		- E F
		 * 比如经过A点时，此时列表的变化依次是
		 * [*,*,A]→[*,*,A,E]→[*,*,A,E,F]→[*,*,A,E,F,B]→[*,*,A,E,F]→[*,*,A,E]→
		 * [*,*,A]→[*,*,A,B]→[*,*,A,B,F]→[*,*,A,B,F,E]→[*,*,A,B,F]→[*,*,A,B]→[*,*,A]→[*,*]
		 * 
		 * path列表用来防止重复走过的点造成死循环，参数path0用来记录从起点开始到达每一个点之前的完整路径。
		 * 
		 * @param grid 阵图，一个二维数组，用不同的符号表示哪些点可以通过，哪些点不能通过，哪些点是目标所在的位置
		 * @param point 当前坐标，这里将坐标包装成Point对象，对象有x,y两个属性，分别表示在二维数组中的位置
		 * @param path0 路径，表示从起点开始，到达这个点之前所经过的点的集合
		 * @return 表示这个点是否可以继续往下走，这里获取可行的路径{@link pathes}是主要目的，返回值没有太大作用
		 */
		public static boolean dfs(int[][] grid, Point point, List<Point> path0){
			
			List<Point> p = new ArrayList<Point>();
			p.addAll(path0);
			p.add(point);//拷贝上一个点经过的路径，并接着上一个点的路径继续
			
			if(grid[point.x][point.y] == 9){//到达
				pathes.add(p);
				return true;
			}
			
			if(grid[point.x][point.y] != 0 && !path.contains(point)){//这个点可以走(1和9) 并且 未走过
				path.add(point);//现在走point
				if(point.x + 1 <= grid.length-1){
					dfs(grid, point.down(), p);						//往下
				}
				if(point.y + 1 <= grid[point.x].length-1){
					dfs(grid, point.right(), p);					//往右
				}
				if(point.x - 1 >= 0){
					dfs(grid, point.up(), p);						//往上
				}
				if(point.y - 1 >= 0){
					dfs(grid, point.left(), p);						//往左
				}
				path.remove(point);//走过point，之后从其他点过来的也能继续走
			}
			//如果不可走(0) 或者 已走过
			return false;
		}
		
		
		static class Point{
			int x;
			int y;
			Point(int x, int y){
				this.x = x;
				this.y = y;
			}
			Point left(){
				return new Point(x, y-1);
			}
			Point right(){
				return new Point(x, y+1);
			}
			Point up(){
				return new Point(x-1, y);
			}
			Point down(){
				return new Point(x+1, y);
			}
			
			public String printDirection(Point nextPoint){
				String direction = null;
				if(nextPoint == null){
					direction = "●";
				}else{
					if(this.x == nextPoint.x){
						direction = (this.y < nextPoint.y) ? "→" : "←";
					}
					if(this.y == nextPoint.y){
						direction = (this.x < nextPoint.x) ? "↓" : "↑";
					}
				}
				return direction;
			}
			
			@Override
			public int hashCode() {
				return super.hashCode();
			};
			@Override
			public boolean equals(Object obj){
				Point p = (Point) obj;
				if(p.x == this.x && p.y == this.y){
					return true;
				}else{
					return false;
				}
			}
			@Override
			public String toString() {
				return "(" + this.x + "," + this.y +")";
			}
		}
}
