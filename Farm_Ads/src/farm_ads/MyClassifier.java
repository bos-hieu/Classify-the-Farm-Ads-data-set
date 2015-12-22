/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_ads;

import java.util.Hashtable;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Cau be mua he
 */
public class MyClassifier {

    double TP = 0.0, FP = 0.0, FN = 0.0, TN = 0.0;

    // đọc một tập mẫu
    public Instances readIntances(String URL) throws Exception {
        FarmAds fa = new FarmAds(URL);
        FarmAdsVector fav = new FarmAdsVector();
        fav.writeFile("data\\dataVecto.dat", fa);
        DataSource source = new DataSource("data\\dataVecto.dat");
        Instances instances = source.getDataSet();
        if (instances.classIndex() == -1) {
            instances.setClassIndex(instances.numAttributes() - 1);
        }
        return instances;
    }

    // đọc tập mẫu khi đã biết trước tập thuộc tính, số thuộc tính
    public Instances readIntances(String URL, Hashtable att, Hashtable numAtt, String iv) throws Exception {
        FarmAds fa = new FarmAds(att, numAtt, iv, URL);
        FarmAdsVector fav = new FarmAdsVector();
        fav.writeFile("data\\dataVecto.dat", fa);
        DataSource source = new DataSource("data\\dataVecto.dat");
        Instances instances = source.getDataSet();
        if (instances.classIndex() == -1) {
            instances.setClassIndex(instances.numAttributes() - 1);
        }
        return instances;
    }

    // đọc tập mẫu dưới dạng file .dat
    public Instances readIntancesVecto(String URL) throws Exception {
        DataSource source = new DataSource(URL);
        Instances instances = source.getDataSet();
        if (instances.classIndex() == -1) {
            instances.setClassIndex(instances.numAttributes() - 1);
        }
        return instances;
    }

    
    public void preprocessingData(FarmAds fa, FarmAdsVector fav) {
        fav.writeFile(" ", fa);
    }

    //huấn luyện mô hình phân lớp theo thuật toán SMO 
    public Classifier classifierSMO(Instances instances) throws Exception {
        SMO classifier = new SMO();
        classifier.setOptions(weka.core.Utils.splitOptions("-C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0\""));
        classifier.buildClassifier(instances);
        return classifier;
    }

    // huấn luyện mô hình theo thuật toán Naive Bayes
    public Classifier classifierNB(Instances instances) throws Exception {
        Classifier classifier = new NaiveBayes();
        classifier.buildClassifier(instances);
        return classifier;
    }

    // lưu mô hình ra file .model
    public void saveMoDel(String url, Classifier classifier) throws Exception {
        weka.core.SerializationHelper.write(url + ".model", classifier);
    }

    //đọc mô hình từ file
    public Classifier loadModel(String url) throws Exception {
        Classifier temp = (Classifier) weka.core.SerializationHelper.read(url);
        return temp;
    }

    //đánh giá mô hình
    public Evaluation evaluationModel(Instances train, Instances test, Classifier classifier) throws Exception {
        Evaluation eval = new Evaluation(train);
        eval.evaluateModel(classifier, test);
        return eval;
    }

    // in kết quả đánh giá mô hình
    public String printEvaluation(Evaluation e) throws Exception {
        String s = new String();
        s += e.toSummaryString("\nResults\n======\n", false);
        s += "\n" + e.toMatrixString("Matrix String");
        s += "\n" + e.toClassDetailsString();
        return s;
    }

    // đếm kết quả dự đoán
    public void countPredicted(double actValue, double pred) {
        if (actValue == 0.0 && pred == 0.0) {
            TP++;
        }

        if (actValue == 0.0 && pred == 1.0) {
            FN++;
        }

        if (actValue == 1.0 && pred == 0.0) {
            FP++;
        }

        if (actValue == 1.0 && pred == 1.0) {
            TN++;
        }

    }

    // a: TP, b: FN, c: FP, d: TN
    public double getPrecision() {
        return round2((TP / (TP + FP) + TN / (TN + FN)) / 2);
    }

    public double getRecall() {
        return round2((TP / (TP + FN) + TN / (TN + FP)) / 2);
    }

    public double getFMeasure() {
        return round2(((2 * TP) / (2 * TP + FN + FP) + (2 * TN) / (2 * TN + FN + FP)) / 2);
    }

    public int getCorrect() {
        return (int) (TN + TP);
    }

    public int getInCorrect() {
        return (int) (FN + FP);
    }

    
    // phân lớp cho nhiều mẫu
    public String ClassifyMultiInstances(Classifier c, Instances t) throws Exception {
        String format = "%4s %15s %15s\n";
        String format1 = "%15s %15s %15s\n";
        String s = new String();
        TP = FP = FN = TN = 0.0;

        s += "Số lượng mẫu: " + Integer.toString(t.numInstances()) + "\n\n";
        s += "======= Kết quả dự đoán quảng cáo========\n";
        s += String.format(format, "STT", "Trước dự đoán", "Sau dự đoán");

        for (int i = 0; i < t.numInstances(); i++) {
            String[] classAds = {"Phù hợp", "Không phù hợp"};
            double actValue = t.instance(i).classValue();

            Instance newInst = t.instance(i);

            double pred = c.classifyInstance(newInst);

            countPredicted(actValue, pred);

            s += String.format(format, Integer.toString(i + 1),
                    classAds[(int) actValue], classAds[(int) pred]);
        }

        s += "\nChú thích -->  Phù hợp: (+1) ,  Không phù hợp: (-1)\n";
        s += "\nSố mẫu được phân lớp đúng: " + Integer.toString(getCorrect());
        s += "\nSố mẫu được phân lớp sai: " + Integer.toString(getInCorrect());

        s += "\n\n======= Đánh giá kết quả dự đoán  ========\n";
        s += String.format(format1, "Prediction", "Recall", "F-measure");
        s += String.format(format1,
                getPrecision(),
                getRecall(),
                getFMeasure());

        return s;
    }

    //phân lớp cho một mẫu
    public String ClassifyInstance(Classifier c, String instance) throws Exception {

        String format = "%4s %15s %15s\n";
        FarmAds fa = new FarmAds(instance, 1);
        FarmAdsVector fav = new FarmAdsVector();
        fav.writeFile("data\\dataVecto.dat", fa);
        DataSource source = new DataSource("data\\dataVecto.dat");
        Instances instances = source.getDataSet();
        if (instances.classIndex() == -1) {
            instances.setClassIndex(instances.numAttributes() - 1);
        }

        String s = new String();

        s += "======= Kết quả dự đoán quảng cáo========\n";
        s += String.format(format, "STT", "Trước dự đoán", "Sau dự đoán");

        String[] classAds = {"Phù hợp", "Không Phù Hợp"};
        double actValue = instances.firstInstance().classValue();

        Instance newInst = instances.firstInstance();

        double pred = c.classifyInstance(newInst);

        s += String.format(format, Integer.toString(1),
                classAds[(int) actValue], classAds[(int) pred]);
        
        if(actValue == pred)
        {
            s+="\n\n ==> Dự đoán đúng";
        }
        else{
            s+="\n\n ==> Dự đoán sai";
        }

        return s;
    }

    // làm tròn số thực sau dấu phẩy 2 chữ số
    public double round2(double d) {
        return (double) Math.round(d * 100) / 100;
    }
}
