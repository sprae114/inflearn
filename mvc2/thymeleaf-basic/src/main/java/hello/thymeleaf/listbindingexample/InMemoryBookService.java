package hello.thymeleaf.listbindingexample;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InMemoryBookService implements BookService {

    static Map<Long, Book> booksDB = new HashMap<>();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(booksDB.values());
    }

    @Override
    public void saveAll(List<Book> books) {
        //id가 없는 책에 id를 할당
        long nextId = getNextId();
        for (Book book : books) {
            if (book.getId() == 0) {
                book.setId(nextId++);
            }
        }

        //id를 key로 하는 Map으로 변환
        Map<Long, Book> bookMap = books.stream()
            .collect(Collectors.toMap(Book::getId, Function.identity()));

        //기존 데이터와 합치기
        booksDB.putAll(bookMap);
    }

    @Override
    public Book findById(Long id) {
        return booksDB.get(id);
    }

    private Long getNextId() {
        return booksDB.keySet()
            .stream()
            .mapToLong(value -> value)
            .max()
            .orElse(0) + 1;
    }
}
