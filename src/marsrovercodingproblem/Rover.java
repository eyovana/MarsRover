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
public class Rover {

    private int x;
    private int y;
    private compassPoint direction;

    private enum compassPoint {

        NORTH("N"), SOUTH("S"), EAST("E"), WEST("O");
        String letter;

        compassPoint(String letter) {
            this.letter = letter;
        }
    }

    public Rover() {
        this.x = 0;
        this.y = 0;
    }

    public boolean loadPosition(String line) {
        boolean load = false;

        try {
            StringTokenizer st = new StringTokenizer(line);

            this.x = Integer.valueOf((String) st.nextElement());
            this.y = Integer.valueOf((String) st.nextElement());
            String letter = (String) st.nextElement();

            if (letter.equals("N")) {
                this.direction = compassPoint.NORTH;
            }
            if (letter.equals("E")) {
                this.direction = compassPoint.EAST;
            }
            if (letter.equals("O")) {
                this.direction = compassPoint.WEST;
            }
            if (letter.equals("S")) {
                this.direction = compassPoint.SOUTH;
            }

            this.direction.letter = letter;

        } catch (Exception e) {
            return false;
        }
        return load;
    }

    public boolean execMovements(String line) {
        boolean load = false;

        try {
            //StringTokenizer st = new StringTokenizer(line);

            String command = "";

            //while (st.hasMoreElements()) {
            int i = 0;
            while (i < line.length()) {
                command = "" + line.charAt(i);
                execCommand(command);
                i++;
            }
            load = true;
        } catch (Exception e) {
            return false;
        }
        return load;

    }

    public void execCommand(String command) {
        if (command.equals("L")) {
            spinLeft();
        }
        if (command.equals("R")) {
            spinRight();
        }
        if (command.equals("M")) {
            moveRover();
        }
    }

    private void moveRover() {
        switch (this.direction) {
            case EAST:
                moveEast();
                break;
            case NORTH:
                moveNorth();
                break;
            case SOUTH:
                moveSouth();
                break;
            case WEST:
                moveWest();
                break;
        }
    }

    public String getPosition() {
        return this.x + " " + this.y + " " + this.direction.letter;
    }

    private void moveNorth() {
        if (this.y < Plateau.ny) {
            this.y += 1;
        }
    }

    private void moveSouth() {
        if (this.y > 0) {
            this.y -= 1;
        }
    }

    private void moveEast() {
        if (this.x < Plateau.nx) {
            this.x += 1;
        }
    }

    private void moveWest() {
        if (this.x > 0) {
            this.x -= 1;
        }
    }

    private void spinLeft() {
        switch (direction) {
            case NORTH:
                this.direction = compassPoint.WEST;
                break;
            case EAST:
                this.direction = compassPoint.NORTH;
                break;
            case SOUTH:
                this.direction = compassPoint.EAST;
                break;
            case WEST:
                this.direction = compassPoint.SOUTH;
                break;
        }
    }

    private void spinRight() {
        switch (direction) {
            case NORTH:
                this.direction = compassPoint.EAST;
                break;
            case EAST:
                this.direction = compassPoint.SOUTH;
                break;
            case SOUTH:
                this.direction = compassPoint.WEST;
                break;
            case WEST:
                this.direction = compassPoint.NORTH;
                break;
        }
    }

}
