package by.lamaka.springmvc.repository;

import by.lamaka.springmvc.entity.Book;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookRepositoryImpl implements BookRepository {
    SessionFactory sessionFactory;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Book book) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    @Override
    public List<Book> findAllByTitleOrAuthor(String filter) {
        List<Book> books = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Book> query = session.createQuery(
                    "from Book where author like '%" + filter + "%' or title like '%" + filter + "%'", Book.class);

            books = new ArrayList<>(new HashSet<>(query.getResultList()));
            transaction.commit();
        }
        return books;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            books = session.createQuery("from Book", Book.class).getResultList();
            transaction.commit();
        }
        return books;
    }
}
