package com.javaleet.oj;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


public class GeoCode {
	private boolean isALine(Point a, Point b, Point c) {
		int x1, y1, x2, y2;
		boolean ret = false;
		x1 = a.x - b.x;
		x2 = b.x - c.x;
		y1 = a.y - b.y;
		y2 = b.y - c.y;
		if (x1 * y2 == x2 * y1) ret = true;
		return ret;
	}
	/* create a new line when get a new line
	 * 
	 * 
	 * 
	 */
	public int maxPoints(Point[] points) {
		HashMap<Integer, ArrayList<Point>> hm = new HashMap<Integer, ArrayList<Point>>();
		int i = 0, j = 0, count = 0;
		while (i < points.length) {
			j = 0;
			if (hm.size() == 0) {
				ArrayList<Point> tmp = new ArrayList<Point>();
				tmp.add(points[i]);
				hm.put(0, tmp);
			} else {
				while (j < hm.size()) {
					ArrayList<Point> tmp = hm.get(j);
					if (tmp.size() == 1) {
						tmp.add(points[i]);
					} else if (tmp.size() > 1) {
						if (isALine(tmp.get(0), tmp.get(1), points[i])) {
							tmp.add(points[i]);
						}
					}
					j++;
				}
			}
			i++;
		}
		i = 0;
		while (j < hm.size()) {
			ArrayList<Point> tmp = hm.get(j);
			if (tmp.size() > count) count = tmp.size();
		}
        return count;
    }
}
