package com.example.library;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        if (bookRepository.count() > 0) {
            return; // don't duplicate data if books already exist
        }

        bookRepository.save(new Book(null, "Atomic Habits", "James Clear", "9780735211292", true));
        bookRepository.save(new Book(null, "Deep Work", "Cal Newport", "9781455586691", true));
        bookRepository.save(new Book(null, "The Pragmatic Programmer", "Andrew Hunt", "9780135957059", true));
        bookRepository.save(new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", false));
        bookRepository.save(new Book(null, "Effective Java", "Joshua Bloch", "9780134685991", true));
        bookRepository.save(new Book(null, "1984", "George Orwell", "9780451524935", true));
        bookRepository.save(new Book(null, "To Kill a Mockingbird", "Harper Lee", "9780061120084", true));
        bookRepository.save(new Book(null, "The Hobbit", "J.R.R. Tolkien", "9780345339683", false));
        bookRepository.save(new Book(null, "Sapiens", "Yuval Noah Harari", "9780062316097", true));
        bookRepository.save(new Book(null, "The Alchemist", "Paulo Coelho", "9780062315007", true));
        bookRepository.save(new Book(null, "Thinking, Fast and Slow", "Daniel Kahneman", "9780374533557", true));
        bookRepository.save(new Book(null, "The Silent Patient", "Alex Michaelides", "9781250301697", true));
        bookRepository.save(new Book(null, "Educated", "Tara Westover", "9780399590504", false));
        bookRepository.save(new Book(null, "The Da Vinci Code", "Dan Brown", "9780307474278", true));
        bookRepository.save(new Book(null, "Man's Search for Meaning", "Viktor E. Frankl", "9780807014295", true));
        bookRepository.save(new Book(null, "The Catcher in the Rye", "J.D. Salinger", "9780316769488", true));
        bookRepository.save(new Book(null, "Pride and Prejudice", "Jane Austen", "9780141439518", true));
        bookRepository.save(new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", true));
        bookRepository.save(new Book(null, "Brave New World", "Aldous Huxley", "9780060850524", false));
        bookRepository.save(new Book(null, "The Power of Now", "Eckhart Tolle", "9781577314806", true));
        bookRepository.save(new Book(null, "Zero to One", "Peter Thiel", "9780804139298", true));
        bookRepository.save(new Book(null, "Rich Dad Poor Dad", "Robert Kiyosaki", "9781612680194", true));
        bookRepository.save(new Book(null, "The Lean Startup", "Eric Ries", "9780307887894", true));
        bookRepository.save(new Book(null, "Crime and Punishment", "Fyodor Dostoevsky", "9780486415871", false));
        bookRepository.save(new Book(null, "The Kite Runner", "Khaled Hosseini", "9781594631931", true));
    }
}