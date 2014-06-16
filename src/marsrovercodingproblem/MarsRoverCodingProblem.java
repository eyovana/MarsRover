/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrovercodingproblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Yovana
 */
public class MarsRoverCodingProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String line = "";

        try {
            while (!line.equals("x")) {
                System.out.println("-> Presione x si quiere salir.");
                System.out.println("-> Ingrese la direccion del archivo:");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                line = bufferedReader.readLine();

                if (!line.equals("x")) {
                    Archivo file = new Archivo(line);

                    if (file.existFile()) {

                        file.openFile();

                        if (file.canRead()) {

                            Plateau.loadLimit(file.ReadLine());

                            while (file.canRead()) {

                                Rover r = new Rover();

                                r.loadPosition(file.ReadLine());

                                file.canRead();

                                r.execMovements(file.ReadLine());

                                System.out.println(r.getPosition());

                            }

                            System.out.println("==========");
                        }
                    } else {
                        System.out.println("No es correcta la dirección del archivo.");
                    }
                }
            }

            System.exit(1);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
