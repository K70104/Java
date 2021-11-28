package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("删除图书！");
        System.out.println("请输入你要删除的图书的书名：");
        // 查找（根据书名找到书的位置）
        int index = 0; // 找到的下标
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        int i = 0;
        for (i = 0; i < currentSize; i++) {
            Book book = bookList.gesPos(i);
            if(book.getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(i >= currentSize) {
            System.out.println("没有你要删除的书！");
            return;
        }
        // 删除
        for (int j = index; j < currentSize - 1; j++) {
            Book book = bookList.gesPos(j+1);
            bookList.setBooks(j, book);
        }
        bookList.setBooks(currentSize, null);
        bookList.setUsedSize(currentSize-1);
        System.out.println("删除成功！");
    }
}
