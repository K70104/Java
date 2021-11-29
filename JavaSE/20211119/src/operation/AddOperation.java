package operation;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("新增图书！");
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者：");
        String author = scanner.nextLine();
        System.out.println("请输入图书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型：");
        String type = scanner.nextLine();

        Book book = new Book(name, author, price, type);
        int size = bookList.getUsedSize();
        bookList.setBooks(size, book); // 放到最后一个位置
        bookList.setUsedSize((size+1));
        System.out.println("新增成功！");
    }
}
