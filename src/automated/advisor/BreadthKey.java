/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated.advisor;

/**
 *
 * @author jackh
 */
public class BreadthKey {
    
    private int breadth;
    private boolean key;
    
    public BreadthKey(boolean key, int breadth) {
        this.breadth = breadth;
        this.key = key;
    }
    
    public void setBool(boolean b) {
        this.key = b;
    }
    
    public int getBreadth() {
        return this.breadth;
    }
    public boolean getKey() {
        return this.key;
    }
}
