package com.javaleet.oj;

public class MatrixCode {
	private int getStartVal(int n, int i, int j) {
		int tmp = i < j ? i : j;
		tmp = tmp < (n - 1 - i) ? tmp : (n - 1 - i);
		tmp = tmp < (n - 1 - j) ? tmp : (n - 1 - j);
		int sum = 0;
		i = 0;
		while (i < tmp) {
			sum += (n - 1 - 2 * i) * 4;
			i++;
		}
		return sum;
	}
	private int getOffset(int n, int i, int j) {
		int offset = 0;
		int tmp = i < j ? i : j;
		tmp = tmp < (n - 1 - i) ? tmp : (n - 1 - i);
		tmp = tmp < (n - 1 - j) ? tmp : (n - 1 - j);
		if (tmp == i && j != (n - tmp - 1)) {
			offset = (j - tmp + 1);
		} else if (j == (n - tmp - 1) && i != (n - tmp - 1)) {
			offset = (n - 1 - 2 * tmp) + (i - tmp + 1);
		} else if (i == (n - tmp -1) && j != tmp) {
			offset = (n - 1 - 2 * tmp) * 2 + (n - j - tmp);
		} else {
			offset = (n - 1 - 2 * tmp) * 3 + (n - i - tmp);
		}
		return offset;
	}
	public int[][] generateMatrix(int n) {
		int i = 0, j = 0;
		int [][] ret = new int[n][n];
		while (i < n) {
			while (j < n) {
				ret[i][j] = getStartVal(n, i, j) + getOffset(n, i, j);
				j++;
			}
			i++;
			j = 0;
		}
        return ret;
    }
}
