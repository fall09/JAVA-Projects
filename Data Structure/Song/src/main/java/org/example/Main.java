package org.example;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        manageSongs manager = new manageSongs();
        manager.text();
        AVLTree firstTree = new AVLTree<Song>();
        AVLTree secondTree = new AVLTree<Song>();
        AVLTree thirdTree = new AVLTree<Song>();
        AVLTree treeWithAllFields = new AVLTree<Song>();
        for (int i = 0; i < manager.line(); i++) {
            firstTree.root = firstTree.insertion(firstTree.root, manager.songs[i].id, i);
        }
        for (int i = 0; i < manager.line(); i++) {
            secondTree.root = secondTree.insertion(secondTree.root, manager.songs[i].songName, i);
        }
        for (int i = 0; i < manager.line(); i++) {
            thirdTree.root = thirdTree.insertion(thirdTree.root, manager.songs[i].artist, i);
        }
        for (int i = 0; i < manager.line(); i++) {
            treeWithAllFields.root = treeWithAllFields.insertion(treeWithAllFields.root, manager.songs[i], i);
        }
        firstTree.getBalanced(firstTree.root);
        System.out.println(firstTree.isBalanced(firstTree.root));


        System.out.println("Which task you want to do?:");
        int choice = 1;
        while (choice != 4) {
            System.out.println("1-Search");
            System.out.println("2-Delete");
            System.out.println("3-Print");
            System.out.println("4-Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How do you prefer to search:");
                    System.out.println("1-Name");
                    System.out.println("2-Artist");
                    System.out.println("3-ID");
                    System.out.println("4-Interval od ID's");
                    int input = scan.nextInt();
                    if (input == 1) {
                        System.out.println("Enter the name of the song:");
                        String name = scan.nextLine();
                        name = scan.nextLine();
                        int cnt= secondTree.count(name,secondTree.root);
                        if(cnt!=0){
                            AVLNode node = secondTree.findNode(name, secondTree.root);
                            int key = node.key;
                            System.out.println(firstTree.SearchRecursive(firstTree.root, key).data);
                            System.out.println(secondTree.SearchRecursive(secondTree.root, key).data);
                            System.out.println(thirdTree.SearchRecursive(thirdTree.root, key).data);
                        }
                        else {
                            System.out.println("There is no song with the given name "+name);
                        }
                    } else if (input == 2) {
                        System.out.println("Enter the artist of the song:");
                        String artist = scan.nextLine();
                        artist = scan.nextLine();
                        int cnt= thirdTree.count(artist,thirdTree.root);
                        if(cnt!=0){
                        AVLNode node = thirdTree.findNode(artist, thirdTree.root);
                        int key = node.key;
                            System.out.println(firstTree.SearchRecursive(firstTree.root, key).data);
                            System.out.println(secondTree.SearchRecursive(secondTree.root, key).data);
                            System.out.println(thirdTree.SearchRecursive(thirdTree.root, key).data);
                        }
                        else{
                            System.out.println("There is no song with the given artist "+artist);
                        }
                    } else if (input == 3) {
                        System.out.println("Enter the id of the song:");
                        int id = scan.nextInt();
                        int cnt= firstTree.count(id,firstTree.root);
                            if(cnt!=0) {
                            AVLNode node = firstTree.findNode(id, firstTree.root);
                            int key = node.key;
                            System.out.println(firstTree.SearchRecursive(firstTree.root, key).data);
                            System.out.println(secondTree.SearchRecursive(secondTree.root, key).data);
                            System.out.println(thirdTree.SearchRecursive(thirdTree.root, key).data);
                            }

                    else {
                        System.out.println("There is no song with the given id "+id);
                    }
                    }
                    else if (input == 4) {
                        System.out.println("Enter lower bound:");
                        int lower = scan.nextInt();
                        System.out.println("Enter upper bound:");
                        int upper = scan.nextInt();
                        int [] array=new int[count(lower,upper,firstTree)];
                        thirdSearch(lower,upper,firstTree,array);
                        for(int i=0;i< array.length;i++){
                            int key= array[i];
                            System.out.println(firstTree.SearchRecursive(firstTree.root,key).data);
                            System.out.println(secondTree.SearchRecursive(secondTree.root,key).data);
                            System.out.println(thirdTree.SearchRecursive(thirdTree.root,key).data);
                            System.out.println(" ");
                        }


                    } else {
                        System.out.println("Wrong input");
                    }
                    break;
                case 2:
                    System.out.println("Enter the id of the song to be removed: ");
                    treeWithAllFields.traverseInOrder(thirdTree.root);
                    int removalID = scan.nextInt();
                    int cnt= firstTree.count(removalID, firstTree.root);
                    if(cnt!=0){
                    AVLNode removal = firstTree.findNode(removalID, firstTree.root);
                    int index= removal.key;
                        firstTree.root = firstTree.deleteNode(firstTree.root, index);
                        secondTree.root = secondTree.deleteNode(secondTree.root, index);
                        thirdTree.root = thirdTree.deleteNode(thirdTree.root, index);
                        treeWithAllFields.root= treeWithAllFields.deleteNode(treeWithAllFields.root,index);
                        System.out.println("Deleted...");}
                    else{
                        System.out.println("There is no song with given id " + removalID);}

                    break;
                case 3:
                    treeWithAllFields.traverseInOrder(treeWithAllFields.root);
                    break;

                case 4:
                    System.out.println("Ok,bye");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;

            }
        }

    }
    public static void thirdSearch(int low,int up,AVLTree tree,int []array){
        int key=0;
        int cnt=0;
        AVLNode current = tree.root;
        while (current != null) {
            int value= (Integer) current.data;
            if (value<=up && value>= low) {
             System.out.println(current.data);
             array[cnt]=key;
             cnt++;

            }
            if(current.key < key ){
                current=current.right;

            }
            else {
                current= current.left;
            }
            key++;
        }

    }
    public static int count(int low,int up,AVLTree tree){
        int key=0;
        int cnt=0;
        AVLNode current = tree.root;
        while (current != null) {
            int value= (Integer) current.data;
            if (value<=up && value>= low) {
                System.out.println(current.data);
                cnt++;

            }
            if(current.key < key ){
                current=current.right;

            }
            else {
                current= current.left;
            }
            key++;
        }
        return cnt;
    }








}