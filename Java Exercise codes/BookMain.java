abstract class Book{
    String title;
    abstract void setTitle(String s);
    String getTitle(){
        return title;
    }
}

class MyBook extends Book {
    @Override
    void setTitle(String s) {
        title = s;
    }
}

public class BookMain{
    public static void main(String[] args) {
        MyBook myBook = new MyBook();
        myBook.setTitle("Java Programming");
        String title = myBook.getTitle();
        System.out.println(title);
    }
}
