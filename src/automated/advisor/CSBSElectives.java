/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated.advisor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jackh
 */
public class CSBSElectives {

    Map<String, BreadthKey> map = new HashMap<>();
    protected int systems, app, theory, count;

    public CSBSElectives() {
        systems = 0;
        app = 0;
        theory = 0;
        map.put("CS355", new BreadthKey(false, 0));
        map.put("CS362", new BreadthKey(false, 0));
        map.put("CS451", new BreadthKey(false, 0));
        map.put("ECE231 & ECE232", new BreadthKey(false, 0));
        map.put("CS275", new BreadthKey(false, 1));
        map.put("CS351", new BreadthKey(false, 1));
        map.put("CS365", new BreadthKey(false, 1));
        map.put("CS371", new BreadthKey(false, 1));
        map.put("CS375", new BreadthKey(false, 1));
        map.put("CS340", new BreadthKey(false, 2));
        map.put("M220", new BreadthKey(false, 2));
        map.put("M222W", new BreadthKey(false, 2));
    }

    /*
    SET METHODS
     */
    /**
     * Checks map for key, if key is there, changes value to given param.
     *
     * @param c Course code with spaces EX "CS 114", "M 221W"
     * @param t
     */
    public void setClass(String c, boolean b) {
        if (map.containsKey(c)) {
            map.get(c).setBool(b);
            int breadth = map.get(c).getBreadth();
            if (b == true) {
                switch (breadth) {
                    case 0:
                        systems++;
                        count++;
                        break;
                    case 1:
                        app++;
                        count++;
                        break;
                    case 2:
                        theory++;
                        count++;
                        break;
                }
            } else {
                switch (breadth) {
                    case 0:
                        systems--;
                        count--;
                        break;
                    case 1:
                        app--;
                        count--;
                        break;
                    case 2:
                        theory--;
                        count--;
                        break;
                }
            }

        }

    }

    public String breadthResults() {
        String result = "";
        if (systems > 0 && app > 0 && theory > 0) {
            result += "You have satisfied all breadth requirements";
        } else {
            if (systems == 0) {
                result += "You are missing a systems requirement\n";
            }
            if(app == 0) {
                result += "You are missing an applications requirement\n";
            }
            if(theory == 0) {
                result += "You are missing a theory requirement.\n";
            }
        }
        return result;
    }

    public boolean checkBreadth() {
        boolean res = false;
        boolean multi = false;
        if (systems > 0 && app > 0 && theory > 0) {
            multi = true;
        }

        if (count >= 5 && multi == true) {
            res = true;
        }
        return res;
    }

    /**
     * Checks a given course code with the Hash map to return a boolean value
     *
     * @param c Course code with spaces EX "CS 114", "M 221W"
     * @return
     */
    public boolean checkClass(String c) {
        boolean res = false;
        if (map.containsKey(c)) {
            if (map.get(c).getKey() == true) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }

}
