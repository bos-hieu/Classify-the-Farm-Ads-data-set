/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_ads;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cau be mua he
 */
public final class FarmAds {

    public int numAttributes;
    public int numInstances;
    public Hashtable attributes = new Hashtable();
    Hashtable num_att = new Hashtable();
    String ins_vecto = new String();
    ArrayList<String> instances = new ArrayList<>();
    

    
    public FarmAds(){
        numAttributes =0;
        numInstances =0;
        ins_vecto = null;
    }
    
    public FarmAds(String instance, int num)
    {
        instances.add(instance);
        readAttFromFile("data\\attributes.txt");
        numInstances = 1;       
    }
    
    public FarmAds(String url)
    {
        readDataset(url);
        readAttFromFile("data\\attributes.txt");
    }
    
    public FarmAds(Hashtable att, Hashtable numAtt, String iv, String url)
    {
        readDataset(url);
        attributes = att;
        num_att = numAtt;
        numAttributes = attributes.size();
        ins_vecto = iv;
    }
   
    //đọc tập dữ liệu
    private void readDataset(String url) {

        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                instances.add(line);
            }
            numInstances = instances.size();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
    }

    
    // đọc tập thuộc tính
    @SuppressWarnings({"unchecked", "unchecked"})
    private void readAttributes() {
        int stt = 1;
        for (String instance : this.instances) {
            String temp[] = instance.split(" ");
            for (int i = 1; i < temp.length; i++) {
                if (!attributes.containsKey(temp[i])) {
                    attributes.put(temp[i], stt);
                    num_att.put(stt, temp[i]);
                    stt++;
                }
            }
        }
        numAttributes = attributes.size();
    }
    
    //đọc tập thuộc tính từ file
    @SuppressWarnings("unchecked")
    public void readAttFromFile(String url)
    {
        BufferedReader br = null;
        String line;
        int i = 1;
        
        try {
            br = new BufferedReader(new FileReader(url));
            line = br.readLine();
            ins_vecto = line;
            
            while ((line = br.readLine()) != null) {
                attributes.put(line.trim(), i);
                num_att.put(i, line.trim());
                i++;
            }
            numAttributes = attributes.size();
            
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
    
    }
    
    //viết thuộc tính ra file
    public void writeAttribute(String name) {
        FileWriter fileWriter = null;

        
        try {
            fileWriter = new FileWriter(name);
            for (int i = 1; i <= numAttributes; i++) {
                System.out.println(num_att.get(i));
                fileWriter.append(num_att.get(i).toString() + "\n");
            }
            fileWriter.flush();

        } catch (Exception e) {
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
            }
        }
    }
}
