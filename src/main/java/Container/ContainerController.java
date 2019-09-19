package Container;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContainerController {
    Scanner sc = new Scanner(System.in);
    ArrayList<Container> lst = new ArrayList<>();

    ArrayList<Container> lstFull = new ArrayList<>();
    ArrayList<Container> lstEmpty = new ArrayList<>();

    // Câu a
    public void nhapDS(){
        boolean f = true;
        while(f){
        System.out.println("1-De them Container.");
        System.out.println("2-Ghi File.");
        int i =sc.nextInt();
        sc.nextLine();
        switch (i){
            case 1:{
                Container c = new Container();
                System.out.println("Vui long nhap so Container: ");
                c.setNumber(sc.nextLine());
                System.out.println("Vui long nhap chieu cao Container: ");
                c.setHeight(sc.nextInt());
                System.out.println("Vui long nhap chieu rong Container: ");
                c.setWidth(sc.nextInt());
                sc.nextLine();
                System.out.println("Vui long nhap trang thai cua Container: ");
                c.setStatus(sc.nextLine());
                lst.add(c);
                break;
            }
            case 2:{
                f = false;
                break;
            }
        }
        }
    }

    public void ghiFile(){
        try{
        FileOutputStream out = new FileOutputStream("Container.txt");
        StringBuffer sb = new StringBuffer();
        for (Container c1:lst){
        String s ="Number:"+c1.getNumber()+"\n"
                +"Height:"+c1.getHeight()+"\n"
                +"Width:"+c1.getWidth()+"\n"
                +"Status:"+c1.getStatus()+"\n";

        sb.append(s);

        }
            out.write(sb.toString().getBytes());
            out.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // Câu b
    public void Docfile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Container.txt"));
            String line = reader.readLine(); // Doc tung dong du lieu
            Container c1 = new Container();// Tao doi tuong container de luu lai du lieu
            while (line != null){
                String[] arrayLine = new String[2]; // Tao mang de chua cac chuoi con sau khi cat 1 dong thanh 2 chuoi con
                arrayLine = line.split(":");

                // Lap tung chuoi con de kiem tra ID va set gia tri cho tung thuoc tinh cua Container
                for (int i=0; i<arrayLine.length; i++){
                    if (arrayLine[0].equals("Number")){
                        c1.setNumber(arrayLine[1]);
                    }else if (arrayLine.equals("Height")){
                        c1.setHeight(arrayLine[1]);
                    }else if (arrayLine.equals("Width")){
                        c1.setWidth(arrayLine[1]);
                    }else {
                        c1.setStatus(arrayLine[1]);

                        // Sau khi set xong status thi add doi tuong c1 vao listFull hoac listEmpty
                        if (c1.getStatus().equals("Full")){
                            lstFull.add(c1);
                            c1 = new Container();
                            FileInputStream fis = new FileInputStream("ContainerFull.txt");
                            int f;
                            while ((f =fis.read()) != -1){
                                System.out.println((char)f);
                            }
                            fis.close();
                        }else {
                            lstEmpty.add(c1);
                            c1 = new Container();
                            FileInputStream fis1 = new FileInputStream("ContainerEmpty");
                            int g;
                            while ((g = fis1.read()) !=-1){
                                System.out.println((char)g);
                            }
                            fis1.close();
                        }
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Câu c
    public void TimkiemsoContainerTheoID(){
        File file = new File("Container.txt");
        Scanner sc = new Scanner(System.in);

        try {
            Scanner input = new Scanner(file);
            System.out.println("Vui lòng nhập ID Container Cần tìm: ");
            String timkiem = sc.nextLine();
            while (input.hasNext()){
                String line = input.nextLine().toLowerCase().toString();
                if (line.contains(timkiem)){
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}



