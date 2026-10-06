class BookNode {
    int id; 
    String title; 
    BookNode left, right;
    
    BookNode(int id, String title) { 
        this.id = id; 
        this.title = title; 
    }
}

public class Catalogue {
    private BookNode root;

    public void insert(int id, String title) {
        root = insert(root, id, title);
    }

    private BookNode insert(BookNode node, int id, String title) {
        if (node == null) return new BookNode(id, title);
        if (id < node.id) node.left = insert(node.left, id, title);
        else if (id > node.id) node.right = insert(node.right, id, title);
        return node;
    }

    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();
        catalogue.insert(101, "Java Programming");
        catalogue.insert(50, "Data Structures");
        System.out.println("Books inserted into the library catalogue successfully.");
    }
}