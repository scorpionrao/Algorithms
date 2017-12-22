import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int leftIndex;
            int rightIndex;

            Node(int key, int leftIndex, int rightIndex) {
                this.leftIndex = leftIndex;
                this.rightIndex = rightIndex;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;
        boolean filesFlag = false;

        void read() throws IOException {
            if(filesFlag) {
                File folder = new File
                        ("/Users/rgonugunta/git/vagrant/projects/Algorithms/src/datastructures/binarysearchtree/tests");
                if(folder.exists() && folder.isDirectory()) {
                    File[] files = folder.listFiles();
                    Arrays.sort(files, new Comparator<File>(){
                        @Override
                        public int compare(File f1, File f2) {return f1.getName().compareTo(f2.getName());}
                    });
                    for(File test : files) {
                        FileReader fileReader = new FileReader(test);
                        BufferedReader reader = new BufferedReader(fileReader);
                        nodes = Integer.parseInt(reader.readLine());
                        tree = new Node[nodes];
                        for (int i = 0; i < nodes; i++) {
                            String[] inputs = reader.readLine().split(" ");
                            tree[i] = new Node(
                                    Integer.parseInt(inputs[0]),
                                    Integer.parseInt(inputs[1]),
                                    Integer.parseInt(inputs[2]));
                        }
                        String expectedOutput = reader.readLine();
                        validate(expectedOutput, test);
                    }
                }
            } else {
                FastScanner in = new FastScanner();
                nodes = in.nextInt();
                tree = new Node[nodes];
                for (int i = 0; i < nodes; i++) {
                    tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
                }
            }
        }

        private void validate(String expectedOutput, File test) {

            String actualOutput = this.isBinarySearchTree() ? "CORRECT" : "INCORRECT";
            System.out.println(expectedOutput.equals(actualOutput) ? "OK" :
                    "Error! File = " + test.getName() + " expected = " + expectedOutput + " Actual = " + actualOutput);
        }

        boolean isBinarySearchTree() {
            if(nodes <= 1) {
                return true;
            }
            return isBSTUtil(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        boolean isBSTUtil(int index, int max, int min) {

            if(index == -1) {
                return true;
            }

            if(tree[index].key <= max && tree[index].key >= min) {

            /*
                for any node of the tree, if its key is 𝑥,
                 any node in its left subtree its key must be strictly less than 𝑥, and
                 for any node in its right subtree its key must be greater than or equal to 𝑥.
            */
                return isBSTUtil(tree[index].leftIndex, tree[index].key - 1, min)
                        && isBSTUtil(tree[index].rightIndex, max, tree[index].key);
            } else {
                return false;
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
