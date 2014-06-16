/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrovercodingproblem;

import java.util.StringTokenizer;

/**
 *
 * @author Yovana
 */
public class Plateau {

    public static int nx = 0;
    public static int ny = 0;

    public static void loadLimit(String line) {
        try {
            StringTokenizer st = new StringTokenizer(line);
            nx = Integer.valueOf((String) st.nextElement());
            ny = Integer.valueOf((String) st.nextElement());
        } catch (Exception e) {         
        }
    }

}
