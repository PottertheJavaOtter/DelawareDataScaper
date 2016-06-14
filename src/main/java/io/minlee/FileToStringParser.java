package io.minlee;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minlee on 6/14/16.
 */
public class FileToStringParser {

    private String inputData;

    public FileToStringParser() throws IOException, BadLocationException {
        inputData = loadFile();
        try {
            inputData = convertRTFToPlainText(inputData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("SpecialElection2016.rtf").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    private String convertRTFToPlainText(String inputData) throws IOException, BadLocationException {
        RTFEditorKit rtfEditorKit = new RTFEditorKit();
        Document document = rtfEditorKit.createDefaultDocument();
        try {
            rtfEditorKit.read(new ByteArrayInputStream(inputData.getBytes()), document, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return document.getText(0, document.getLength());
    }

    public String getInputData(){
        return inputData;
    }
}
