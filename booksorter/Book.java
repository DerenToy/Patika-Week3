package booksorter;

public class Book implements Comparable<Book> {

    private final String bookName;
    private final int pageNum;
    private final String writerName;
    private final int publishDate;

    public Book(String bookName, int pageNum, String writerName, int publishDate) {
        this.bookName = bookName;
        this.pageNum = pageNum;
        this.writerName = writerName;
        this.publishDate = publishDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNum() {
        return pageNum;
    }

    @Override
    public int compareTo(Book o) {
        return this.getBookName().compareTo(o.getBookName());
    }
}
