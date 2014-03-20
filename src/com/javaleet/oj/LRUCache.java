package com.javaleet.oj;

import java.util.Vector;

public class LRUCache {
	int [][]mem;
	int capacity;
	int max = 0, count = 0;
	public LRUCache(int capacity) {
        mem = new int[capacity][3];
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
        	mem[i][0] = 0;
        	mem[i][1] = 0;
        	mem[i][2] = -1;
        }
    }
	public void test() {
		for (int i = 0; i < capacity; i++) {
			System.out.println(mem[i][0] + " " + mem[i][1] + " " + mem[i][2]);
		}
		System.out.println("----");
	}
    
    public int get(int key) {
    	max++;
    	int i = 0;
    	for ( i = 0; i < capacity; i++) {
    		if (mem[i][2] == key) {
    			mem[i][1] = max;
    			return mem[i][0];
    		}
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
        max++; 
        int i = 0, index = 0, min = max;
        for ( i = 0; i < capacity; i++) {
    		if (mem[i][2] == key) {
    			mem[i][0] = value;
    			mem[i][1] = max;
    			return;
    		}
    	}
        if (count < capacity) {
        	for (i = 0; i < capacity; i++) {
        		if (mem[i][2] == -1) {
        			index = i;
        			break;
        		}
        	}
        } else {
    		for (i = 0; i < capacity; i++) {
    			if (mem[i][1] < min) {
    				min = mem[i][1];
    				index = i;
    			}
    		}
        }
        mem[index][0] = value;
    	mem[index][1] = max;
    	mem[index][2] = key;
        count++;
    }
}
