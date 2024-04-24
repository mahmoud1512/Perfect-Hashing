package org.example.Methods;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\10random_words.txt";


        ArrayList<String> lines = new ArrayList<>();


        Path filePath = Paths.get(fileName);

        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\t-:start test with 10 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

 //***********************************************************************************************
        //100 elements

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\100random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 100 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
//------------------------------------------------------------------------------------------
        //200 elements analysis

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\200random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 200 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
//-----------------------------------------------------------------------------------------------
        //300 elements

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\300random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 300 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
//---------------------------------------------------------------------------------------------
//400 elements

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\400random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 400 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

//---------------------------------------------------------------------------------------------
//500

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\500random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 500 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
//**************************************************************************************************
//600
        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\600random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 600 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


//******************************************************************************************
      //700
        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\700random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 700 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,12);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
 //********************************************************************************************
                //800
        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\800random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 800 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
 //*********************************************************************************
              ///900
        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\900random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 900 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
 //**********************************************************************************************
 ///1000

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\1000random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 1000 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
            long startTimeN2 = System.nanoTime();
            x.batchInsert(lines);
            long endTimeN2=System.nanoTime();
            long timeN2=endTimeN2-startTimeN2;
            int rehashes_in_N2= x.getNumberOfRehash();
            int space= x.getSize();
            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            long startTimeN = System.nanoTime();
            y.batchInsert(lines);
            long endTimeN=System.nanoTime();
            long timeN=endTimeN-startTimeN;
            int rehashes_in_N= y.getNumberOfRehash();
            int spaceN= y.getSize();

            Message="\n"+"Time OF N is "+timeN+"\n"+"Number of rehashes in N is "+rehashes_in_N+"\n"+"Space of N is "+spaceN+"\n"+"\n";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            Message="-----------------------------------------------------------------------------------------------------";

            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


    }
}