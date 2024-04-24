package org.example.Methods;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Analysis2 {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\1500random_words.txt";


        ArrayList<String> lines = new ArrayList<>();


        Path filePath = Paths.get(fileName);

        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 1500 elements :-\t";
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
        //2000 elements

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\2000random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 2000 elements :-\t";
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
        //10000 elements analysis

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\10000random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 10000 elements :-\t";
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
        //15000 elements

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\15000random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 15000 elements :-\t";
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
//25000 elements

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\25000random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 25000 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
//            NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
//            long startTimeN2 = System.nanoTime();
//            x.batchInsert(lines);
//            long endTimeN2=System.nanoTime();
//            long timeN2=endTimeN2-startTimeN2;
//            int rehashes_in_N2= x.getNumberOfRehash();
//            int space= x.getSize();
//            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
//            Files.write(
//                    verificationFilePath,
//                    Message.getBytes(),
//                    StandardOpenOption.CREATE,
//                    StandardOpenOption.APPEND
//            );

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
//50000

        fileName="C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\50000random_words.txt";
        lines=new ArrayList<>();
        filePath = Paths.get(fileName);




        try {
            Path verificationFilePath = Paths.get("C:\\Users\\20100\\Documents\\GitHub\\Perfect-Hashing\\tests\\verification_message.txt"); // Adjust the path as needed

            String Message="\n\t-:start test with 50000 elements :-\t";
            Files.write(
                    verificationFilePath,
                    Message.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            lines = (ArrayList<String>) Files.readAllLines(filePath);
          //  NSquareSpace<String>x=new NSquareSpace<>(80);
            NSpace<String>y=new NSpace<>(80,10);
//            long startTimeN2 = System.nanoTime();
//            x.batchInsert(lines);
//            long endTimeN2=System.nanoTime();
//            long timeN2=endTimeN2-startTimeN2;
//            int rehashes_in_N2= x.getNumberOfRehash();
//            int space= x.getSize();
//            Message="\n"+"Time OF N^2 is "+timeN2+"\n"+"Number of rehashes in N^2 is "+rehashes_in_N2+"\n"+"Space of N^2 is "+space+"\n";
//            Files.write(
//                    verificationFilePath,
//                    Message.getBytes(),
//                    StandardOpenOption.CREATE,
//                    StandardOpenOption.APPEND
//            );

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


    }
}