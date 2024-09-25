package Hw1.Exe6.EBookReader;

class Book {
    String title;
    boolean purchased;

    Book(String title) {
        this.title = title;
        this.purchased = false;
    }

    public void purchase() {
        purchased = true;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void read() {
        if (purchased) {
            System.out.println("Reading " + title);
        } else {
            System.out.println("You need to purchase " + title + " first.");
        }
    }
}

