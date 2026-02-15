package PYQ.Zoho.Advance;
// InMemoryFileSystem
import java.util.*;

// Problem Statement (Zoho Style)

// Design and implement a console-based in-memory File System similar to a simplified operating system.

// The system must support:

// Create Directory

// Create File

// Write to File

// Read File

// Delete File/Directory

// List Directory Contents

// Navigate Between Directories

// Print Current Path

// 📦 Assumptions

// All data stored in memory

// No actual disk storage

// Single user system

// Hierarchical structure (Tree)

// Root directory = "/"

// Directory can contain:

// Subdirectories

// Files

// 📋 Functional Requirements
// 1️⃣ Create Directory
// mkdir docs

// 2️⃣ Create File
// touch notes.txt

// 3️⃣ Write Content
// write notes.txt "Hello Zoho"

// 4️⃣ Read Content
// read notes.txt

// 5️⃣ Delete
// delete notes.txt
// delete docs

// 6️⃣ List Files
// ls

// 7️⃣ Change Directory
// cd docs
// cd ..


public class InMemoryFileSystem {

    // -------- ABSTRACT NODE --------
    static abstract class Node {
        String name;
        Directory parent;

        Node(String name) {
            this.name = name;
        }

        abstract void print();
    }

    // -------- FILE --------
    static class FileNode extends Node {
        String content = "";

        FileNode(String name) {
            super(name);
        }

        void write(String data) {
            content = data;
        }

        void read() {
            System.out.println(content);
        }

        @Override
        void print() {
            System.out.println("[FILE] " + name);
        }
    }

    // -------- DIRECTORY --------
    static class Directory extends Node {

        Map<String, Node> children = new HashMap<>();

        Directory(String name) {
            super(name);
        }

        void add(Node node) {
            children.put(node.name, node);
            node.parent = this;
        }

        void remove(String name) {
            children.remove(name);
        }

        Node get(String name) {
            return children.get(name);
        }

        @Override
        void print() {
            System.out.println("[DIR] " + name);
        }

        void list() {
            for (Node node : children.values()) {
                node.print();
            }
        }
    }

    // -------- FILE SYSTEM --------
    static class FileSystem {

        Directory root;
        Directory current;

        FileSystem() {
            root = new Directory("/");
            current = root;
        }

        // Create Directory
        void mkdir(String name) {
            if (current.get(name) != null) {
                System.out.println("Already exists.");
                return;
            }
            current.add(new Directory(name));
            System.out.println("Directory created.");
        }

        // Create File
        void touch(String name) {
            if (current.get(name) != null) {
                System.out.println("Already exists.");
                return;
            }
            current.add(new FileNode(name));
            System.out.println("File created.");
        }

        // Write File
        void write(String name, String content) {
            Node node = current.get(name);

            if (node == null || !(node instanceof FileNode)) {
                System.out.println("File not found.");
                return;
            }

            ((FileNode) node).write(content);
            System.out.println("Written successfully.");
        }

        // Read File
        void read(String name) {
            Node node = current.get(name);

            if (node == null || !(node instanceof FileNode)) {
                System.out.println("File not found.");
                return;
            }

            ((FileNode) node).read();
        }

        // Delete
        void delete(String name) {
            Node node = current.get(name);

            if (node == null) {
                System.out.println("Not found.");
                return;
            }

            current.remove(name);
            System.out.println("Deleted successfully.");
        }

        // List
        void ls() {
            current.list();
        }

        // Change Directory
        void cd(String name) {
            if (name.equals("..")) {
                if (current.parent != null) {
                    current = current.parent;
                }
                return;
            }

            Node node = current.get(name);

            if (node == null || !(node instanceof Directory)) {
                System.out.println("Directory not found.");
                return;
            }

            current = (Directory) node;
        }

        // Print Current Path
        void pwd() {
            List<String> path = new ArrayList<>();
            Directory temp = current;

            while (temp != null) {
                path.add(temp.name);
                temp = temp.parent;
            }

            Collections.reverse(path);

            for (String p : path) {
                if (!p.equals("/"))
                    System.out.print("/" + p);
                else
                    System.out.print("/");
            }
            System.out.println();
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        FileSystem fs = new FileSystem();

        fs.mkdir("docs");
        fs.cd("docs");
        fs.touch("notes.txt");
        fs.write("notes.txt", "Hello Zoho Round 3");
        fs.read("notes.txt");

        fs.cd("..");
        fs.ls();
        fs.pwd();
    }
}

