package com.cn.linkume.util.chess.client;

import java.awt.Point;

public class Rule {

	/**
	 * 获取默认棋子布局
	 * @return
	 */
	public static int[] getDefaultMap() {
		return new int[] {
				// 1
				0, 0, 0, 0, 0,14, 0, 0, 0, 0, 0,
				// 2
				0, 0, 0, 0,15, 0,13, 0, 0, 0, 0,
				// 3
				0, 0, 0, 0,16, 0,12, 0, 0, 0, 0,
				// 4
				0, 0, 0, 0, 0,11, 0, 0, 0, 0, 0,
				// 5
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 6
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 5
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 4
				0, 0, 0, 0, 0,21, 0, 0, 0, 0, 0,
				// 3
				0, 0, 0, 0,22, 0,26, 0, 0, 0, 0,
				// 2
				0, 0, 0, 0,23, 0,25, 0, 0, 0, 0,
				// 1
				0, 0, 0, 0, 0,24, 0, 0, 0, 0, 0, };
	}

	// 1：士；2：象；3：炮；4：将；5：马；6：卒；7：车
	// 1: 金; 2: 木; 3; 水; 4: 将; 5：火；6：土；
	/**
	 * 如果可以吃（包括终点没有棋子的情况）
	 * @param map 棋子布局
	 * @param start 起点
	 * @param aim 终点
	 * @return 如果棋子可以走过去，返回真
	 */
	public static boolean canEat(int[] map, int start, int aim) {
		Point p1 = intToPoint(start);
		Point p2 = intToPoint(aim);
		//金
		if (map[start] % 10 == 1){
			//横着走
			if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 0){
				return true;
			}
			//竖着走
			if(Math.abs(p1.x - p2.x) == 0 && Math.abs(p1.y - p2.y) == 1){
				return true;
			}
			return false;
		}
		//木
		if (map[start] % 10 == 2){
			//横着走
			if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 0){
				return true;
			}
			//竖着走
			if(Math.abs(p1.x - p2.x) == 0 && Math.abs(p1.y - p2.y) == 1){
				return true;
			}
			return false;
		}
		//水
		if (map[start] % 10 == 3){
			//横着走
			if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 0){
				return true;
			}
			//竖着走
			if(Math.abs(p1.x - p2.x) == 0 && Math.abs(p1.y - p2.y) == 1){
				return true;
			}
			return false;
		}
		//火
		if (map[start] % 10 == 5){
			//横着走
			if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 0){
				return true;
			}
			//竖着走
			if(Math.abs(p1.x - p2.x) == 0 && Math.abs(p1.y - p2.y) == 1){
				return true;
			}
			return false;
		}
		//土
		if (map[start] % 10 == 6){
			//横着走
			if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 0){
				return true;
			}
			//竖着走
			if(Math.abs(p1.x - p2.x) == 0 && Math.abs(p1.y - p2.y) == 1){
				return true;
			}
			return false;
		}
		if (map[start] % 10 == 1) {
			// 如果起点是士
			// 3,0---3,9
			// 4,1---4,8
			// 5,2---5,7
			// 3,2---3,7
			// 5,0---5,9
			int center1 = pointToInt(4, 1);
			int center2 = pointToInt(4, 8);
			if ((start == center1) || (start == center2) || (aim == center1) || (aim == center2)) {
				if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 1){
					return true;
				}
			}
			return false;
		}
		if (map[start] % 10 == 2) {
			// 如果起点是象
			if(aim<45&&start>45){
				return false;
			}
			if(aim>45&&start<45){
				return false;
			}
			//如果是田
			if (Math.abs(p1.x - p2.x) == 2 && Math.abs(p1.y - p2.y) == 2){
				//如果没有被阻塞
				if(map[pointToInt((p1.x+p2.x)/2, (p1.y+p2.y)/2)]%10==0){
					return true;
				};
			}
			return false;
		}
		if (map[start] % 10 == 3) {
			// 如果起点是炮
			if(p1.y==p2.y){
				if(p1.x>p2.x){
					//向左
					//障礙數
					int temp = 0;
					for (int i = 1; i < p1.x-p2.x; i++) {
						if(map[pointToInt(p1.x-i, p1.y)]%10!=0){
							temp++;
						}
					}
					//如果終點有子
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}else{
					//向右
					//障礙數
					int temp = 0;
					for (int i = 1; i < p2.x-p1.x; i++) {
						if(map[pointToInt(p1.x+i, p1.y)]%10!=0){
							temp++;
						}
					}
					//如果終點有子
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}
			}
			if(p1.x==p2.x){
				if(p1.y>p2.y){
					//向上
					//障礙數
					int temp = 0;
					for (int i = 1; i < p1.y-p2.y; i++) {
						if(map[pointToInt(p1.x, p1.y-i)]%10!=0){
							temp++;
						}
					}
					//如果終點有子
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}else{
					//向下
					//障礙數
					int temp = 0;
					for (int i = 1; i < p2.y-p1.y; i++) {
						if(map[pointToInt(p1.x, p1.y+i)]%10!=0){
							temp++;
						}
					}
					//如果終點有子
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}
			}
		}
		if (map[start] % 10 == 4) {
			// 如果起点是将
			if(map[aim] % 10 == 4){
				//如果終點也是將
				if(p1.x==p2.x){
					if(p1.y>p2.y){
						//向上
						for (int i = 1; i < p1.y-p2.y; i++) {
							if(map[pointToInt(p1.x, p1.y-i)]%10!=0){
								return false;
							}
						}
						return true;
					}else{
						//向下
						for (int i = 1; i < p2.y-p1.y; i++) {
							if(map[pointToInt(p1.x, p1.y+i)]%10!=0){
								return false;
							}
						}
						return true;
					}
				}
			}
			if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y)==1){
				if(p2.x>=3&&p2.x<=5){
					if(p2.y>=0&&p2.y<=2){
						return true;
					}
					if(p2.y>=7&&p2.y<=9){
						return true;
					}
				};
			}
			return false;
		}
		if (map[start] % 10 == 5) {
			// 如果起点是马
			if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y)==3){
				if(p1.x - p2.x==2){
					//向左
					if(map[pointToInt(p1.x-1, p1.y)]%10==0){
						return true;
					}
				}
				if(p1.x - p2.x==-2){
					//向右
					if(map[pointToInt(p1.x+1, p1.y)]%10==0){
						return true;
					}
				}
				if(p1.y - p2.y==2){
					//向上
					if(map[pointToInt(p1.x, p1.y-1)]%10==0){
						return true;
					}
				}
				if(p1.y - p2.y==-2){
					//向下
					if(map[pointToInt(p1.x, p1.y+1)]%10==0){
						return true;
					}
				}
			}
		}

		if (map[start] % 10 == 6) {
			// 如果起点是卒
			if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y)==1){
				if(p1.y-p2.y==-1){
					return false;
				}
				if(p1.y==p2.y){
					if(start>=45){
						return false;
					}
				}
				return true;
			}
		}
		if (map[start] % 10 == 7) {
			// 如果起点是车
			if(p1.y==p2.y){
				if(p1.x>p2.x){
					//向左
					for (int i = 1; i < p1.x-p2.x; i++) {
						if(map[pointToInt(p1.x-i, p1.y)]%10!=0){
							return false;
						}
					}
					return true;
				}else{
					//向右
					for (int i = 1; i < p2.x-p1.x; i++) {
						if(map[pointToInt(p1.x+i, p1.y)]%10!=0){
							return false;
						}
					}
					return true;
				}
			}
			if(p1.x==p2.x){
				if(p1.y>p2.y){
					//向上
					for (int i = 1; i < p1.y-p2.y; i++) {
						if(map[pointToInt(p1.x, p1.y-i)]%10!=0){
							return false;
						}
					}
					return true;
				}else{
					//向下
					for (int i = 1; i < p2.y-p1.y; i++) {
						if(map[pointToInt(p1.x, p1.y+i)]%10!=0){
							return false;
						}
					}
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 将点转换为数组指针索引
	 * @param x 横坐标
	 * @param y 总坐标
	 * @return 返回整形
	 */
	public static int pointToInt(int x, int y) {
		return x + y * 11;
	}

	/**
	 * 将数组指针转换为坐标点
	 * @param num 数组指针
	 * @return 返回坐标点
	 */
	public static Point intToPoint(int num) {
		return new Point(num % 11, num / 11);
	}

	/**
	 * 将棋子布局翻转
	 * @param map 棋子布局
	 * @return 返回棋子布局数组
	 */
	public static int[] rotateMap (int map[]) {
		int re[] = new int[map.length];
		for (int i = 0; i < map.length/2 + 1; i++) {
			re[map.length - i -1] = map[i];
			re[i] = map[map.length - i -1];
		}
		return re;
	}
}
