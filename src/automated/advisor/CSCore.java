/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated.advisor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jackh
 */
public class CSCore {

    Map<String, Boolean> map = new HashMap<>();

    public CSCore() {
        map.put("CS114", false);
        map.put("CS115", false);
        map.put("CS220", false);
        map.put("CS211", false);
        map.put("CS320", false);
        map.put("CS460", false);
        map.put("M144", false);
        map.put("M221W", false);

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
            map.replace(c, b);
        }
    }

    public String coreResults() {
        String result = "";
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            String key = entry.getKey();
            Boolean value = map.get(key);
            if (!value) {
                result += key + "\n";
            }
        }
        return result;

    }

    public boolean checkCore() {
        boolean res = true;
        Collection<Boolean> b = new ArrayList<>();
        b = map.values();
        for (Boolean bool : b) {
            if (bool == false) {
                res = false;
            }
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
