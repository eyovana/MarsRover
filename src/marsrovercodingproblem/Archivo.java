package marsrovercodingproblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yovana
 */
public class Archivo {

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    String line;

    public Archivo(String url) {
        archivo = new File(url);
    }

    public Archivo() {
    }

    public void openFile() {
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

        } catch (Exception e) {
            e.printStackTrace();
       }
    }

    public boolean existFile() {
        return archivo.exists();
    }

    public boolean canRead() {
        try {
            return ((line = br.readLine()) != null);
        } catch (Exception e) {
            System.out.println("No puede leer la linea" + e.toString());
            return false;
        }
    }

    public String ReadLine() {
        return line;
    }
}
