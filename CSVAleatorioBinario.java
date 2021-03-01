/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvaleatoriobinario;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;

/**
 *
 * @author Demo
 */
public class CSVAleatorioBinario {

    /**
     * @param args the command line arguments
     */  
    public static void main(String[] args) throws ParseException {
        //Reads file name
        String vendors = "vendors.csv";
        //line for the contents and count for the amount of lines
        String line;
        int count = 0;
        //full improv on this part, will fix order later
        byte[] valuesbytes = null;
        Charset charset = Charset.forName("UTF-8");
        FileOutputStream newfile = null;
        DataOutputStream writer = null;
        String Space = "\n";
        byte[] EnterSim = Space.getBytes(charset);
        //Reads file lines
        try {
            newfile = new FileOutputStream("datos.dat");
            writer = new DataOutputStream(newfile);
            BufferedReader BufferedReader = new BufferedReader(new FileReader(vendors));
            while ((line = BufferedReader.readLine()) != null) {
                    //prints lines, but we want to write on a newfile instead
                    String[] values = line.split(",");
                    byte[] valuesbyte = line.getBytes(charset);
                    System.out.println(line);
                if (count != 0) {
                    //prints to make sure i copy the right thing
                    //System.out.println(values[0] + " / " + values[1] + " / " + (values[2]));
                    writer.write(valuesbyte);
                    writer.write(EnterSim);//the copy in byte                                 
                    //System.out.print("Copying...");
                }
                count++;                
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }finally {
            try {
                if (newfile != null) {
                    newfile.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());                                                               
            }
        }
    }
}
