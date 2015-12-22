/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_ads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Cau be mua he
 */
public class FarmAdsVector {

    ArrayList<String> insVector = new ArrayList<>();

    //đọc tập dữ liệu file .dat
    public void readDat(String url) {

        BufferedReader br = null;
        String line;
        int i = 0;

        try {
            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                insVector.add(line);
            }
            System.out.println("Số mẫu: " + insVector.size());
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

    //chuyển một mẫu từ dạng text sang dạng vector
    public String textToVector(FarmAds fa, int index) {

        String a[] = fa.instances.get(index).split(" ");
        TreeSet<Integer> ins = new TreeSet<>();
        String temp = new String();

        temp += a[0];

        for (int i = 1; i < a.length; i++) {
            ins.add(Integer.parseInt(fa.attributes.get(a[i]).toString()));
        }

        for (Integer in : ins) {
            temp += " " + in.toString() + ":1";
        }

        return temp;
    }

    // chuyển một mẫu từ dạng text sang dạng vector
    public String textToFullVector(FarmAds fa, int index) {

        String a[] = fa.instances.get(index).split(" ");
        TreeSet<Integer> ins = new TreeSet<>();
        String temp = new String();

        temp = a[0];
        temp += fa.ins_vecto;

        for (int i = 1; i < a.length; i++) {
            ins.add(Integer.parseInt(fa.attributes.get(a[i]).toString()));
        }

        for (Integer in : ins) {
            String temp1 = " " + Integer.toString(in);
            temp = temp.replace(temp1 + ":0", temp1 + ":1");
        }
        return temp;
    }

    // chuyển các thuộc tính trong mẫu sang dạng số
    public String textToNumber(FarmAds fa, int index) {

        String a[] = fa.instances.get(index).split(" ");
        TreeSet<Integer> ins = new TreeSet<>();
        String temp = new String();

        temp += a[0];

        for (int i = 1; i < a.length; i++) {
            ins.add(Integer.parseInt(fa.attributes.get(a[i]).toString()));
        }

        for (Integer in : ins) {
            temp += " " + in.toString();
        }

        return temp;
    }

    //so trùng hai tập vector
    public boolean Matching(FarmAds fa) {
        if (fa.numInstances != insVector.size()) {
            return false;
        } else {
            for (int i = 0; i < fa.numInstances; i++) {
                if (!(textToVector(fa, i).equals(insVector.get(i)))) {
                    return false;
                }
            }
        }
        return true;
    }

    
    //ghi tập dữ liệu vector ra file
    public void writeFile(String name, FarmAds fa) {

        FileWriter fileWriter = null;
        //BufferedWriter bw = null;

        try {
            fileWriter = new FileWriter(name);
            fileWriter.append(textToFullVector(fa, 0) + "\n");
            for (int i = 1; i < fa.numInstances; i++) {
                fileWriter.append(textToVector(fa, i) + "\n");
            }
        } catch (Exception e) {
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            }
        }
    }

}
