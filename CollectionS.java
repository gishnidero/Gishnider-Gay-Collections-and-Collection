/*
Gishnider Gay
COP3330C-31034
7/9/2026
This program shows the utilization of java collections, collection interface and various methods within the Collections
class. The program has the user enter 8 different words and, later into the program, enter one word to search for
within said program. Note; if the user types the same word more than once, the program will have them try again
to type a unique word and if the word that is not listed, it will notify them that the word in question is not listed
and move on. But if properly entered the program will print the following; the list itself, the size of said list,
the longest and shortest word, shuffled variant of the list, an index location of the word that was searched for, a
rotated variant of the list, a reversed variant, an array output and a list output.
Note: Due to formatting via the for-loop, the array output format will not look that much different from the
list output.
*/

import java.util.*; //Java utility package.
import java.util.Collections; //Gives methods that work with collections.
import java.util.Comparator; //Utilized to help in setting up sorting rules.
import java.util.List; //For creation and utilization of lists.
import java.util.ArrayList; //Utilized for managing lists, at least in this case.
import java.util.Scanner;// Utilized for user input.

public class CollectionS {// This class will showcase the utilization of Java Collections methodologies
    public static void main(String[] args) {
        List<String> word_List = new ArrayList<>(); // Declares list to store user input.
        Scanner scan = new Scanner(System.in); // Creates scanner object to take in user input.
//Prompt the user to  enter 8 different word entries into the program
        System.out.println("Enter 8 words. Each entry must be different: ");

        for (int i = 0; i < 8; i++) {//For loop used to collect up to 8 unique words.
           String vocabulary; //Variable is used to hold each word inputted by th user.
           boolean duplicate; //This is declared to check if the word is unique or a duplicate.

           do {// Will keep prompting user to enter a unique word into the list
               duplicate = false;
               System.out.println("Enter a word " + (i + 1) + ": ");
               vocabulary = scan.nextLine();

            //This checks for any duplicate words that the user may enter and acts accordingly based on the findings.
               for (String listed_Word : word_List) {
                   if (listed_Word.equalsIgnoreCase(vocabulary)) {
              //If true, the number of words on the list will not increase, until a unique one is placed.
                       duplicate = true; //
                       System.out.println("No duplicates allowed! Try again!"); //Displays if duplicat is found.
                   }
               }
           }while (duplicate);
           word_List.add(vocabulary); //Will add the unique word, from the user, to the list.
        }
        //Will print out the word list entered by user.
        System.out.println(" \nWord List: ");
    //Known as a for-each construct. In this case, will be used to read through the original list and display it.
        for (String vocabulary : word_List){
            System.out.println(vocabulary);
        }
        System.out.println("\nNumber of entries: " + word_List.size()); //Will print the number of words in the list. In
        // this case, it will output the number "8".

//Utilizes the Collections.max/Collections.min alongside a Comparator to determine and print out the longest and
//word respectively. Note; this usage of collections, is a personal preference, but should meet the requirements for
//this section.
        String longWord = Collections.max(word_List, Comparator.comparing(String::length));
        String shortWord = Collections.min(word_List, Comparator.comparing(String::length));
        System.out.println("Longest Entry: " + longWord); //Displays the longest word.
        System.out.println("Shortest Entry: " + shortWord);//Displays the shortest word.

//Collections.sort will change the list in to alphabetical order.
        Collections.sort(word_List);
        System.out.println("\nSorted List: ");
        for (String vocabulary : word_List) {//For-each construct to read through the sorted list.
            System.out.println(vocabulary); //Displays the sorted list (alphabetically).
        }
//This section of code custom sorts the list based on the length of each (longest to shortest)
        Collections.sort(word_List, new Comparator<String>() {
            @Override //Compares the length of each word  within the list and sorts them accordingly.
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println("\nSorted List (Longest to shortest): ");
        for (String vocabulary : word_List) {//For-each construct to read through list (longest to shortest).
            System.out.println(vocabulary); //Displays the custom sorted list.
        }
        //Shuffling the list
        Collections.shuffle(word_List, new Random()); //Used to randomly shuffle the list
        System.out.println("\nShuffled List: "); //Displays the header.
        for (String vocabulary : word_List) {// For-each construct to read through the shuffled list.
            System.out.println(vocabulary);// Display the shuffled list
        }
        //Prompt user to type a word for it to search within the list.
        System.out.println("\nType the entry you're looking for: ");
        String entry_Search = scan.nextLine();
        int index = -1;

        for(int i = 0; i < word_List.size(); i++) {//Read through the list to find the word in question. Ignoring case.
            if (word_List.get(i).equalsIgnoreCase(entry_Search)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            //If the word is in the list; Display the word and index location
            System.out.println("Word: " + entry_Search + "\nIndex Location: " + index);
        }else {
            System.out.println(entry_Search + " does not exist."); //Will display if word is not in the list
        }
        Collections.rotate(word_List, 4);//Used to rotate list by 4 positions.
        System.out.println("\nRotated List: "); //Display header for the rotated list.
        for (String vocabulary : word_List) {//For-each loop to read through the rotated list.
            System.out.println(vocabulary); //Displays the rotated list.
        }
        Collections.reverse(word_List); //Used to reverse the order of the
        System.out.println("\nReverse List: ");//Display the header for the reversed list.
        for (String vocabulary : word_List) {//For-each loop to read through the reversed list.
            System.out.println(vocabulary); //Displays the reversed list.
        }
        String[] word_Array = word_List.toArray(new String[0]); // Converts the list into an array.
        System.out.println("\nEntries (List to Array): ");
        for (String vocabulary : word_Array) {//For-each construct that read through the array.
            System.out.println(vocabulary); //Displays the array. Note; its format in the output, is not that much
            //different from the other lists that are displayed in this program.
        }
        List<String> word_Lineup = new ArrayList<>(List.of(word_Array)); //converts array into a list.
        System.out.println("\nEntries (Array to List): "); //Displays header
        for (String vocabulary : word_Lineup) { //For-each construct to read through the list.
            System.out.println(vocabulary);//Displays the list
        }
        scan.close(); //Closes the scanner.
    }
}
/*
https://www.geeksforgeeks.org/java/differences-between-interface-and-class-in-java/
https://www.geeksforgeeks.org/java/collection-vs-collections-in-java-with-example/

Collections vs. Collection

A Collection is the root interface within the java.util package, that wields a number of sub-interfaces like List, Set
and Queue. It represents a group of objects, defining their basic behaviors like adding, removing or checking
for elements, among other things. Note, that as an interface, it can only tell you what methods are available, not how
they operate. Collections on the other hand, is an utility class, the toolkit of the system, that has static methods
that can work with objects, providing a number of useful tools like sorting, searching, reversing, etc... Though due to
all of its methods being static, it lacks the capabilities to create an object.
An interface is essentially a blueprint for a class, telling the class in question what it should be able to,
specifically what methods it should provide in the program. A class, on the other hand, is the blueprint for creating
objects, a.k.a. instantiation, essentially storing data ahd wielding the code that allow methods to operate. All in all,
an interface is able to describe what an object is capable of, while a class can give a description of the object and
how it operates within the program.
*/