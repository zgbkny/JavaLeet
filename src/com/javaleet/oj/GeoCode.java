package com.javaleet.oj;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class GeoCode {
	private boolean isALine(Point a, Point b, Point c) {
		if ((a.x - b.x) * (b.y - c.y) == (b.x - c.x) * (a.y - b.y)) return true;
		else return false;
	}
	private boolean pointsNotEquel(ArrayList<Point> tmp, Point point) {
		for (int j = 0; j < tmp.size(); j++) {
			if (tmp.get(j).x == point.x && tmp.get(j).y == point.y) return false;
		}
		return true;
	}
	/* create a new line when get a new line
	 * remove dup point
	 * 
	 * 
	 */
	public int maxPoints(Point[] points) {
		HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
		int max = 0, size = points.length;
		for (int i = 0; i < size; i++) {
			int eCount = 1, tmpMax = 0, j = 0, k = 0,repeat = 0;
			Iterator<Double> it = null;
			Double slope = 0.0;
			hm.clear();
			for (j = 0; j < size; j++)
				if (i != j) 
					if (points[i].x == points[j].x && points[i].y != points[j].y) eCount++;
					else if (points[i].x != points[j].x){
						slope = 1.0 * (points[i].y - points[j].y)/(points[i].x - points[j].x);
						if (hm.get(slope) != null) hm.put(slope, (Integer)hm.get(slope) + 1);
						else hm.put(slope, 2);
					} else repeat++;
			for (tmpMax = eCount, it = hm.keySet().iterator(); it.hasNext(); ) {
				k = hm.get(it.next());
				tmpMax = tmpMax > k ? tmpMax : k;
			}
			tmpMax += repeat;
			max = max > tmpMax ? max : tmpMax;
		}
		return max;
	}
	public int maxPoints1(Point[] points) {
		ArrayList<ArrayList<Point>> hm = new ArrayList< ArrayList<Point>>();
		int i = 0, j = 0, k = 0, count = 0;
		while (i < points.length) {
			j = 0;
			if (hm.size() == 0) {
				ArrayList<Point> tmp = new ArrayList<Point>();
				tmp.add(points[i]);
				hm.add(tmp);
			} else {
				k = 0;
				ArrayList<Point> ttmp = null;
				while (j < hm.size()) {	
					ArrayList<Point> tmp = hm.get(j);
					if (pointsNotEquel(tmp, points[i])) {
						if (tmp.size() == 1) {
							tmp.add(points[i]);	
						} else if (tmp.size() > 1) {
							if (isALine(tmp.get(0), tmp.get(1), points[i])) {
								tmp.add(points[i]);
							} else {
								while (k < tmp.size()) {
									ttmp = new ArrayList<Point>();
									ttmp.add(tmp.get(k));
									//ttmp.add(points[i]);
									System.out.println(ttmp.size());
									hm.add(ttmp);
									k++;
								}
							}
						}
					}
					j++;
				}
				ttmp = new ArrayList<Point>();
				ttmp.add(points[i]);
				hm.add(ttmp);
			}
			i++;
		}
		j = 0;
		while (j < hm.size()) {
			ArrayList<Point> tmp = hm.get(j);
			System.out.println("size:" + tmp.size());
			i = 0;
			while (i < tmp.size()) {
				System.out.println("[" + tmp.get(i).x + "," +tmp.get(i).y+ "]");
				i++;
			}
			if (tmp.size() > count) count = tmp.size();
			j++;
		}
        return count;
    }
}
