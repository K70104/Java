package book;

// 顺序表
public class BookList {
    private Book[] books = new Book[10];
    private int usedSize;

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 100, "小说");
        books[1] = new Book("水浒传", "施耐庵", 100, "小说");
        books[2] = new Book("西游记", "吴承恩", 100, "小说");
        this.usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    // 获取pos位置的一本书
    public Book gesPos(int pos) {
        return this.books[pos];
    }

    // 设置pos下标为一本书
    public void setBooks(int pos, Book book) {
        this.books[pos] = book;
    }
}
