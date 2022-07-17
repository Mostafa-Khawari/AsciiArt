/*                  >>>>>   In the name of Allah   <<<<<                      
* Master Name : Ali Rezaei
* Student Name: Mostafa Khawari
*/

import java.util.Scanner; // keyboard
import java.awt.Color; // work with color like:RGB
import java.awt.image.BufferedImage; // save an image in itself
import java.io.BufferedWriter; // input and output of creating a file
import java.io.File; // show path of a file
import javax.imageio.ImageIO; //  a class with methods for locating ImageReaders or ImageWriter
import java.io.FileWriter; // a class for writing file
import java.io.IOException; // exception message for try catch

public class AsciiArt {

    Scanner input = new Scanner(System.in);
    private Color pixelRGB;
    private BufferedImage image; 
    private BufferedWriter writeFile; 
    private File file;
    
    private double pixel;
    private int width;
    private int height;

    char[][] arrayChar; // to save ascii art
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AsciiArt object = new AsciiArt();
        
        System.out.println("                In The Name Of Allah\n\n");
        // a loop for print Menu and selection
        boolean runLoop = true;
        do {
            printMenu();
            int select = input.nextInt();
            System.out.println();
            switch (select) {
                case 1:
                    System.out.println("We need to an image to convert to ascii art");
                    System.out.println("So Please Enter the path of an image like below:");
                    System.out.println("C:\\\\image folder\\image x.png");
                    System.out.println();
                    
                    // conver image to ascii art
                    object.convertToAscii();
                    break;
                case 2:
                    System.out.println("This project created by 2 people\n"
                            + "Names >>>\n"
                            + "          1) Mostafa Khawari     2) Sara Bigdeli\n"
                            + "ID >>>\n"
                            + "          1) 9715429079          2) 9715429055\n");
                    break;
                case 3:
                    System.out.println("                  *************");
                    System.out.println("                  * Good Bye! *");
                    System.out.println("                  *************");
                    runLoop = false;
                    break;
            }
        } while (runLoop);
    } // end main method
    
    public static void printMenu() {
        System.out.println();
        System.out.println(" _______________________________________");
        System.out.println("| 1) Run App                            |");
        System.out.println("| 2) Show Information                   |");
        System.out.println("| 3) Exit                               |");
        System.out.println(" _______________________________________");
        System.out.print(">>> Please enter a number between 1-3: ");
    } // end printMenu methode
    
    // conver pixel of an image to charactor
    public void convertToAscii() {
        
        AsciiArt object = new AsciiArt(); // make an object
        
        // a loop for getting the path of image 
        boolean runLoop = true;
        do {
            try {
                System.out.print("Please Enter the path of an image: ");
                String path = input.nextLine();
                // get image
                image = ImageIO.read(new File(path));
                runLoop = false;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter correct path!\n");
            }
        } while (runLoop);

        width = image.getWidth();
        height = image.getHeight();
        arrayChar = new char[height][width];

        try {
            // create a file 
            file = new File("C:\\Ascii Art.txt");
            if (!file.exists()) {
                file.createNewFile();
            } 
            // make an object to write a file
            writeFile = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    pixelRGB = new Color(image.getRGB(j, i));
                    // ravesh Luminosity(yek miangin vazndar az maghadir )
                    pixel = (((pixelRGB.getRed() * 0.21) + (pixelRGB.getGreen() * 0.72) + (pixelRGB.getBlue() * 0.07)));
                    // send the pixel to a method for determine charactor and save in arrayChar
                    arrayChar[i][j] = object.setLight(pixel);
                    writeFile.write(arrayChar[i][j]);
                }
                writeFile.newLine();
            }
            System.out.println("  We Created A File In Drive C:\\\\\\\\Ascii Art.txt"
                    + "  You can see ascii art in created file\n"
                    + "  if do you want see in terminal\n"
                    + "  probebly you must  wait a minute"
                    + "  So do you want see in terminal? (Yes , No) : ");
            
            // ask to continue?
            // if yes: show in terminal
            // if no: you must see in file
            String showInTerminal = input.nextLine().toLowerCase();
            switch (showInTerminal) {
                case "yes":
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print(arrayChar[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case "no":
                    System.out.println("Thanks for your selection :) ");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end convertToAscii method
    
    // cv : color value.
    // ac : ascii charactor.
    public char setLight(double cv) {
        char ac = ' ';
        if (cv >= 255) {
            ac = '$';
        } else if (cv >= 250) {
            ac = '@';
        } else if (cv >= 245) {
            ac = 'B';
        } else if (cv >= 240) {
            ac = '8';
        } else if (cv >= 235) {
            ac = '&';
        } else if (cv >= 230) {
            ac = 'W';
        } else if (cv >= 225) {
            ac = 'M';
        } else if (cv >= 220) {
            ac = '#';
        } else if (cv >= 215) {
            ac = 'X';
        } else if (cv >= 210) {
            ac = 'U';
        } else if (cv >= 205) {
            ac = 'V';
        } else if (cv >= 200) {
            ac = 'C';
        } else if (cv >= 195) {
            ac = 'L';
        } else if (cv >= 190) {
            ac = 'Q';
        } else if (cv >= 185) {
            ac = 'O';
        } else if (cv >= 180) {
            ac = 'Z';
        } else if (cv >= 175) {
            ac = '7';
        } else if (cv >= 170) {
            ac = '?';
        } else if (cv >= 165) {
            ac = '\\';
        } else if (cv >= 160) {
            ac = 'I';
        } else if (cv >= 155) {
            ac = ']';
        } else if (cv >= 150) {
            ac = '[';
        } else if (cv >= 145) {
            ac = '|';
        } else if (cv >= 140) {
            ac = '}';
        } else if (cv >= 135) {
            ac = '{';
        } else if (cv >= 130) {
            ac = '/';
        } else if (cv >= 125) {
            ac = 'l';
        } else if (cv >= 120) {
            ac = 'i';
        } else if (cv >= 115) {
            ac = '!';
        } else if (cv >= 110) {
            ac = 'm';
        } else if (cv >= 105) {
            ac = 'w';
        } else if (cv >= 100) {
            ac = 'q';
        } else if (cv >= 95) {
            ac = 'p';
        } else if (cv >= 90) {
            ac = 'd';
        } else if (cv >= 85) {
            ac = 'b';
        } else if (cv >= 80) {
            ac = 'k';
        } else if (cv >= 75) {
            ac = 'h';
        } else if (cv >= 70) {
            ac = 'a';
        } else if (cv >= 65) {
            ac = 'o';
        } else if (cv >= 60) {
            ac = '*';
        } else if (cv >= 55) {
            ac = '+';
        } else if (cv >= 50) {
            ac = '~';
        } else if (cv >= 45) {
            ac = '_';
        } else if (cv >= 40) {
            ac = '-';
        } else if (cv >= 35) {
            ac = ';';
        } else if (cv >= 30) {
            ac = ':';
        } else if (cv >= 25) {
            ac = '"';
        } else if (cv >= 20) {
            ac = '^';
        } else if (cv >= 15) {
            ac = ',';
        } else if (cv >= 10) {
            ac = '.';
        } else if (cv >= 5) {
            ac = '`';
        } else if (cv >= 0) {
            ac = ' ';
        }

        return ac;
    } // end setLight method 
} // end Asciiart class