package hr.fer.oop.lab4.zadLab;

import hr.fer.oop.lab4.zadLab.Artikl;
import hr.fer.oop.lab4.zadLab.MySecondByteReader;

import java.io.*;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.TreeSet;

public class Report {
    private int year;
    private Path path = Paths.get("C:\\Programi\\Java\\ooplabos-master\\src\\hr\\fer\\oop\\lab4\\racuni3");

    private LinkedList<File> period1 = new LinkedList<>();
    private LinkedList<File> period2 = new LinkedList<>();
    private LinkedList<File> period3 = new LinkedList<>();
    private LinkedList<File> period4 = new LinkedList<>();

    public Report(int year) throws FileNotFoundException, UnsupportedEncodingException {
        this.year = year;
        getByYear(this.year);
        getByPeriods();
    }

    private void getByYear(int year) {
        String pathWithYear = path + "\\" + Integer.toString(year);
        System.out.println(pathWithYear);
        File folder = new File(pathWithYear);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                switch (file.getName()) {
                    case "1":
                        period1.add(file);
                        break;
                    case "2":
                        period1.add(file);
                        break;
                    case "3":
                        period1.add(file);
                        break;
                    case "4":
                        period2.add(file);
                        break;
                    case "5":
                        period2.add(file);
                        break;
                    case "6":
                        period2.add(file);
                        break;
                    case "7":
                        period3.add(file);
                        break;
                    case "8":
                        period3.add(file);
                        break;
                    case "9":
                        period3.add(file);
                        break;
                    case "10":
                        period4.add(file);
                        break;
                    case "11":
                        period4.add(file);
                        break;
                    case "12":
                        period4.add(file);
                        break;
                }
            }
        }
    }

    private void getByPeriods() throws FileNotFoundException, UnsupportedEncodingException {
        if (period1 != null) {
            double sumPeriod = 0;
            String fileName = "report" + Integer.toString(year) + "-1.txt";
            System.out.println(fileName);
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(Integer.toString(year));
            writer.println("1. kvartal (1-3)");
            LinkedList<File> files = new LinkedList<>();
            for (File file0 : period1) {
                if (file0.isDirectory()) {
                    File[] files0 = file0.listFiles();
                    for (File fil : files0) files.add(fil);
                }
            }
            writer.println("Ukupno računa: " + files.size());
            for (File proxy : files) {
                FileVisitor<Path> visitor= new MySecondByteReader();
                BufferedReader br = new BufferedReader(new FileReader(proxy));
                try {
                    Files.walkFileTree(proxy.toPath(), visitor);
                    TreeSet<Artikl> articles = ((MySecondByteReader) visitor).getArticles();
                    writer.print(br.readLine() + " UKUPNO ");
                    br.close();
                    double sum = 0;
                    double sumPdv = 0;
                    for (Artikl a : articles) {
                        System.out.println(a.getCijena());
                            sum += Double.parseDouble(a.getCijena());
                            sumPdv += Double.parseDouble(a.getPdv());
                    }
                    sumPeriod += sum;
                    System.out.println(sumPeriod);
                    writer.print(Double.toString(sum));
                    writer.println();
                    writer.println("UKUPNI PDV : " + Double.toString(sumPdv));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            writer.close();
        }
        if (period2 != null) {
            double sumPeriod = 0;
            String fileName = "report" + Integer.toString(year) + "-2.txt";
            System.out.println(fileName);
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(Integer.toString(year));
            writer.println("2. kvartal (4-6)");
            LinkedList<File> files = new LinkedList<>();
            for (File file0 : period2) {
                if (file0.isDirectory()) {
                    File[] files0 = file0.listFiles();
                    for (File fil : files0) files.add(fil);
                }
            }
            writer.println("Ukupno računa: " + files.size());
            for (File proxy : files) {
                FileVisitor<Path> visitor= new MySecondByteReader();
                BufferedReader br = new BufferedReader(new FileReader(proxy));
                try {
                    Files.walkFileTree(proxy.toPath(), visitor);
                    TreeSet<Artikl> articles = ((MySecondByteReader) visitor).getArticles();
                    writer.print(br.readLine() + " UKUPNO ");
                    br.close();
                    double sum = 0;
                    double sumPdv = 0;
                    for (Artikl a : articles) {
                        //System.out.println(a.getCijena());
                        sum += Double.parseDouble(a.getCijena());
                        sumPdv += Double.parseDouble(a.getPdv());
                    }
                    sumPeriod += sum;
                    System.out.println(sumPeriod);
                    writer.print(Double.toString(sum));
                    writer.println();
                    writer.println("UKUPNI PDV : " + Double.toString(sumPdv));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            writer.close();
        }
        if (period3 != null) {
            double sumPeriod = 0;
            String fileName = "report" + Integer.toString(year) + "-3.txt";
            System.out.println(fileName);
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(Integer.toString(year));
            writer.println("3. kvartal (7-9)");
            LinkedList<File> files = new LinkedList<>();
            for (File file0 : period3) {
                if (file0.isDirectory()) {
                    File[] files0 = file0.listFiles();
                    for (File fil : files0) files.add(fil);
                }
            }
            writer.println("Ukupno računa: " + files.size());
            for (File proxy : files) {
                FileVisitor<Path> visitor= new MySecondByteReader();
                BufferedReader br = new BufferedReader(new FileReader(proxy));
                try {
                    Files.walkFileTree(proxy.toPath(), visitor);
                    TreeSet<Artikl> articles = ((MySecondByteReader) visitor).getArticles();
                    writer.print(br.readLine() + " UKUPNO ");
                    br.close();
                    double sum = 0;
                    double sumPdv = 0;
                    for (Artikl a : articles) {
                        //System.out.println(a.getCijena());
                        sum += Double.parseDouble(a.getCijena());
                        sumPdv += Double.parseDouble(a.getPdv());
                    }
                    sumPeriod += sum;
                    System.out.println(sumPeriod);
                    writer.print(Double.toString(sum));
                    writer.println();
                    writer.println("UKUPNI PDV : " + Double.toString(sumPdv));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            writer.close();
        }
        if (period4 != null) {
            double sumPeriod = 0;
            String fileName = "report" + Integer.toString(year) + "-4.txt";
            System.out.println(fileName);
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(Integer.toString(year));
            writer.println("4. kvartal (10-12)");
            LinkedList<File> files = new LinkedList<>();
            for (File file0 : period4) {
                if (file0.isDirectory()) {
                    File[] files0 = file0.listFiles();
                    for (File fil : files0) files.add(fil);
                }
            }
            writer.println("Ukupno računa: " + files.size());
            for (File proxy : files) {
                FileVisitor<Path> visitor= new MySecondByteReader();
                BufferedReader br = new BufferedReader(new FileReader(proxy));
                try {
                    Files.walkFileTree(proxy.toPath(), visitor);
                    TreeSet<Artikl> articles = ((MySecondByteReader) visitor).getArticles();
                    writer.print(br.readLine() + " UKUPNO ");
                    br.close();
                    double sum = 0;
                    double sumPdv = 0;
                    for (Artikl a : articles) {
                        //System.out.println(a.getCijena());
                        sum += Double.parseDouble(a.getCijena());
                        sumPdv += Double.parseDouble(a.getPdv());
                    }
                    sumPeriod += sum;
                    System.out.println(sumPeriod);
                    writer.print(Double.toString(sum));
                    writer.println();
                    writer.println("UKUPNI PDV : " + Double.toString(sumPdv));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.close();
        }
    }
}
