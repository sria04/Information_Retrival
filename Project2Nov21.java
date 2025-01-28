/**
  Project Requirement: Refer to the project document provided with the assignment 
  Project Description:
  Information retrieval systems allow users to enter keywords and retrieve articles that have those keywords associated with them.
  For example, once a student named Yi Li wrote a paper called, “Object Class Recognition using Images of Abstract Regions,"
  and included the following keywords: `object recognition', `abstract regions', `mixture models', and `EM algorithm'.
  If someone does a search for all articles about the EM algorithm, this paper (and many others) will be retrieved.

  Implement a binary search tree and use it to store and retrieve articles. The tree will be sorted by keyword, and each node will
  contain an unordered linked list of Record objects which contain information about each article that corresponds to that
  keyword

  datafile contains the following per Article record
  Title Id
  Title
  Author
  Number of keys identifier
  List of keys in each corresponding article

  Keys are inserted into the Binary Search tree using the insert method in the BST class
  Each key will reference an unordered linked list of article objects (articleid, titleid, and author)

  Algorithm:
    - Create a BufferedReader Object to read the text from an Input stream (datafile.txt) by buffering characters that seamlessly
    reads lines (characters, arrays or lines).
    Note: Each read request made of a Reader causes a corresponding read request to be made of the underlying character or byte stream.
    It wraps BufferedReader in Java around a java FileReaders (whose read() operations may be costly)
    - Loop:
      - read titleid, title, author
        - create an article object
      - read the number of keys identifier
        - Loop read number of keys
          - insert each key into a BST data structure (BST class will insert the key if not exist)
          - add the article object to each of the respective keyword node in the BST data structure

      - ouput the resultant BST along with the list of articles per keyword
  */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
  
  public class Project2Nov21 {
      
      public static void main(String args[]) {    
          BinarySearchTree bst = new BinarySearchTree();
          readFileRecords(bst, "datafile.txt");
          
          System.out.println("\t\tWelcome to Information Retrieval System");
          
          Scanner input = new Scanner(System.in);
          int choice;
          do {
              System.out.println("1. InOrder Traversal with Details <Output keywords along with their associated referenced articles.>");
              System.out.println("2. InOrder Traversal (Keywords Only) <Output only the keywords, excluding the referenced articles.>");
              System.out.println("3. PreOrder Traversal (Keywords Only) <Output only the keywords in pre-order traversal, without the referenced articles.> ");
              System.out.println("4. Search for a specific Keyword <If found, display the keyword with referenced articles; otherwise, output the keyword not found message.>");
              System.out.println("5. Exit <Terminates the program.>");
              System.out.print("\nEnter a choice? ");
              choice = input.nextInt();
      
          switch (choice) {
                  case 1:
                      bst.inOrder(); // Using original visual inOrder
                      break;
                  case 2:
                      bst.inOrderKeywordsOnly();
                      break;
                  case 3:
                      bst.preOrderKeywordsOnly();
                      break;
                  case 4:
                      input.nextLine(); // Clear buffer
                      System.out.print("Enter keyword to search: ");
                      String keyword = input.nextLine();
                      bst.searchKeyword(keyword);
                      break;
                  case 5:
                      System.out.println("Exiting program...");
                      break;
                  default:
                      System.out.println("Invalid choice! Please try again.");
              }
              System.out.println("\n");
          } while (choice != 5);
          
          input.close();
      }
      public static void readFileRecords(BinarySearchTree bst, String filename) {
          BufferedReader fileReader = null;
          try {
              fileReader = new BufferedReader(new FileReader(filename));
          }
          catch (IOException e) {
              e.printStackTrace();
          }
          
          while(true) {
              if (fileReader == null) {
                  System.out.println("Error: file must be opened first!");
                  break;
              }
              else {
                  try {
                      String strId = fileReader.readLine();
                      if (strId == null) break;
                      int id = Integer.parseInt(strId);
                      String title = fileReader.readLine();
                      String author = fileReader.readLine();
                      int numKeys = Integer.parseInt(fileReader.readLine());
                      
                      String keyword;
                      Article art;
                      for (int i=0; i<numKeys; i++) {
                          keyword = fileReader.readLine();
                          art = new Article(id, title, author);
                          bst.insert(keyword, art);
                      }
                      
                      fileReader.readLine();
                  }
                  
                  catch (NumberFormatException e) {
                      e.printStackTrace();
                      break;
                  }
                  catch (Exception e) {
                      e.printStackTrace();
                      break;
                  }
              }
              
          }
          
          // free up resources
          if (fileReader != null) {
              try {
                  fileReader.close();
              }
              catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  
  class BinarySearchTree <E extends Comparable<E>> {
      protected TreeNode<E> root;
      protected int size;
      
      public TreeNode<E> search(E element) {
          
          TreeNode<E> parent = null;
          TreeNode<E> current = root;
          while (current != null) {
              if (element.compareTo(current.element) < 0) {
                  parent = current;
                  current = current.leftC;
              }
              else if (element.compareTo(current.element) > 0) {
                  parent = current;
                  current = current.rightC;
                  
              }
              else if (element.compareTo(current.element) == 0) {
                  return current;
              }
          }
          
          return parent;
      }
      public void insert(E element, Article art) {
          if (root == null) {
              root = new TreeNode<>(element);
              root.head.addFirst(art);
              //System.out.printf("Inserting root %s %s\n", element, art);
          }
          else {
              TreeNode<E> parent = search(element);
              if (parent != null) {
                  if (element.compareTo(parent.element) < 0) {
                      //System.out.printf("Inserting Left Child of %s:\n %s %s\n", parent.element, element, art);
                      parent.leftC = new TreeNode<>(element);
                      parent.leftC.head.addFirst(art);
                  }
                  else if (element.compareTo(parent.element) > 0) {
                      //System.out.printf("Inserting Right Child of %s:\n %s %s\n", parent.element, element, art);
                      parent.rightC = new TreeNode<>(element);
                      parent.rightC.head.addFirst(art);
                  }
                  else {
                      parent.head.addFirst(art);
                      //System.out.printf("Adding LinkedList node at %s:\n %s %s\n", parent.element, element, art);
                  }
              }
          }
          size++;
      }
      
      public void inOrder() {
          System.out.println("\n====================================================");
          System.out.println("Running InOrder Traversal of the Binary Search tree:");
          inOrder(root, "", true);
      }
      
      protected void inOrder(TreeNode<E> root, String prefix, boolean isLeft) {
          if (root == null) return;
          inOrder(root.leftC, prefix + (isLeft ? "   " : "    "), true);
          if (root != null) {
              System.out.printf("%s %s %s\n", prefix, (isLeft ? "L── " : "R── "), root.element);
              for (Article node : root.head) 
                  System.out.print(node); 
              System.out.println();
          }
          inOrder(root.rightC, prefix + (isLeft ? "   " : "    "), false);
      }
  public void inOrderKeywordsOnly() {
          System.out.println("\n====================================================");
          System.out.println("InOrder Traversal (Keywords Only):");
          inOrderKeywordsOnlyVisual(root, "", true);
      }
  
      // NEW CODE: Helper method for Option 2
      private void inOrderKeywordsOnlyVisual(TreeNode<E> root, String prefix, boolean isLeft) {
          if (root == null) return;
          inOrderKeywordsOnlyVisual(root.leftC, prefix + (isLeft ? "   " : "    "), true);
          if (root != null) {
              System.out.printf("%s %s %s\n", prefix, (isLeft ? "L── " : "R── "), root.element);
          }
          inOrderKeywordsOnlyVisual(root.rightC, prefix + (isLeft ? "   " : "    "), false);
      }
  
      // NEW CODE: Option 3 - PreOrder Keywords Only traversal
      public void preOrderKeywordsOnly() {
          System.out.println("\n====================================================");
          System.out.println("PreOrder Traversal (Keywords Only):");
          preOrderKeywordsOnlyVisual(root, "", true);
      }
  
      // NEW CODE: Helper method for Option 3
      private void preOrderKeywordsOnlyVisual(TreeNode<E> root, String prefix, boolean isLeft) {
          if (root == null) return;
          System.out.printf("%s %s %s\n", prefix, (isLeft ? "L── " : "R── "), root.element);
          preOrderKeywordsOnlyVisual(root.leftC, prefix + (isLeft ? "   " : "    "), true);
          preOrderKeywordsOnlyVisual(root.rightC, prefix + (isLeft ? "   " : "    "), false);
      }
  
      // NEW CODE: Option 4 - Keyword search functionality
      public void searchKeyword(E keyword) {
          TreeNode<E> node = searchAndReturn(keyword);
          if (node != null && node.element.equals(keyword)) {
              System.out.println("\n====================================================");
              System.out.println("Keyword '" + keyword + "' found!");
              System.out.println("Referenced Articles:");
              for (Article article : node.head) {
                  System.out.print(article);
              }
          } else {
              System.out.println("\n====================================================");
              System.out.println("Keyword '" + keyword + "' not found.");
          }
      }
  
      // NEW CODE: Helper method for Option 4
      private TreeNode<E> searchAndReturn(E element) {
          TreeNode<E> current = root;
          while (current != null) {
              if (element.compareTo(current.element) < 0) {
                  current = current.leftC;
              }
              else if (element.compareTo(current.element) > 0) {
                  current = current.rightC;
              }
              else {
                  return current;
              }
          }
          return null;
      }
  }
  
  
  class TreeNode<E> {
      protected E element;
      protected TreeNode<E> leftC;
      protected TreeNode<E> rightC;
      protected LinkedList<Article> head;
      
      public TreeNode(E e) {
          element = e;
          head = new LinkedList<Article>();
      }
      
  }
  
  class Article {
      private int id;
      private String title;
      private String author;
      
      public Article() { }
      public Article(int i, String t, String a) {
          id =i;
          title = t;
          author = a;
      }
      
      @Override
      public String toString() {
          return String.format("\t %d | %s | %s-->\n", id, title, author);
      }
  }