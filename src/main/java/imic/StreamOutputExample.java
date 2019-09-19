package imic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StreamOutputExample {
    public static void main(String[] args) {
        // Nhap chuoi tu man hinh su sung Streams Input
        System.out.print("Vui long nhap ky tu can ghi vao flie: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // path cua flie can ghi
        String path = "D:\\JavacoreWorking\\Buoi14\\Data\\Output.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(s.getBytes());//Chuyen String sang byte va ghi vao flie

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

