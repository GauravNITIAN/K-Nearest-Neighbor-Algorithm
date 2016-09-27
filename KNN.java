/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neural_network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author GAURAV KUMAR
 */
public class KNN {
    String data_class;
    
    public double ReadFile(String file1,String file2) throws FileNotFoundException, IOException
    {
        BufferedReader buffer=new BufferedReader(new FileReader(new File(file1)));
        BufferedReader buffer1=new BufferedReader(new FileReader(new File(file2)));
        String findclass=buffer1.readLine();
        String[] dataset=findclass.split(",");
        String line;
        double min=10000000000.0;
        while((line=buffer.readLine())!=null)
        {
           String[] train_dataset=line.split(","); 
           
           min= Euclidiean(dataset,train_dataset,min);
        
        }
        buffer.close();
        buffer1.close();
        return min;
        
    }
    
    public double Euclidiean(String[] dataset, String[] train_dataset,double min)
    {
        Double value=0.0;
        for(int i=0;i<train_dataset.length-1;i++)
        {
            double x1=Double.parseDouble(dataset[i]);
            double x2=Double.parseDouble(train_dataset[i]);
            
            double pow=(x2-x1)*(x2-x1);
            value=value+pow;
            // System.out.println(x1+"   "+x2);
        }
        value=Math.sqrt(value);
        if(min>value)
        {
            min=value;
            data_class=train_dataset[train_dataset.length-1];
            // System.out.println(data_class);
        }
        
        return min;
    }
    
   public static void main(String args[]) throws FileNotFoundException, IOException
   {
       KNN k=new KNN();
       double read=k.ReadFile("Iris.txt", "raw.txt");
       System.out.println(k.data_class);
   }
}
