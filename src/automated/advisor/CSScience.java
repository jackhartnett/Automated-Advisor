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
public class CSScience {

    Map<String, Boolean> map = new HashMap<>();

    public CSScience() {
        map.put("B110", false);
        map.put("B111", false);
        map.put("C110", false);
        map.put("C111", false);
        map.put("P112", false);
        map.put("P113", false);
        map.put("P120", false);
        map.put("P121", false);
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
            map.replace(c,b);
        }

    }

    
    public String scienceResults() {
        String result = "";
        if(map.get("B110")) {
            if(map.get("B111")) {
                result += "You have satisfied all of your science requirements";
            } else {
                result += "B111\n";
            }
        } else if(map.get("C110")) {
            if(map.get("C111")) {
                result += "You have satisfied all of your science requirements";
            } else {
                result += "C111\n";
            }
        } else if(map.get("P112")) {
            if(map.get("P113")) {
                result += "You have satisfied all of your science requirements";
            } else {
                result += "P113\n";
            }
        } else if(map.get("P120")) {
            if(map.get("P121")) {
                result += "You have satisfied all of your science requirements";
            } else {
                result += "P121\n";
            }
        } else {
            result += "You must take two concurrent science courses";
        }
        return result;
    }


    public boolean checkScience() {
        boolean res = false;
        if(map.get("B110") == true && map.get("B111") == true) {
            res = true;            
        }
        if(map.get("C110") && map.get("C111")) {
            res = true;
        }
        if(map.get("P112") && map.get("P113")) {
            res = true;
        }
        if(map.get("P120") && map.get("P121")) {
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
            if (map.get(c) == true) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }

}
