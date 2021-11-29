package operation;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("归还图书！");
        System.out.println("请输入你要归还的图书的名字：");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.gesPos(i);
            if(name.equals(book.getName())) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有你要归还的书！");
    }
}
