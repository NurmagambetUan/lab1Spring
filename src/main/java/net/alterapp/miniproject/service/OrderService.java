package net.alterapp.miniproject.service;




import net.alterapp.miniproject.domain.Book;
import net.alterapp.miniproject.domain.Customer;
import net.alterapp.miniproject.domain.Library;
import net.alterapp.miniproject.domain.Order;
import net.alterapp.miniproject.exception.ErrorCode;
import net.alterapp.miniproject.exception.ServiceException;
import net.alterapp.miniproject.repository.OrderRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final LibraryService libraryService;
    private final BookService bookService;
    private final CustomerService customerService;

    public OrderService(OrderRepo orderRepo, LibraryService libraryService, BookService bookService, CustomerService customerService) {
        this.orderRepo = orderRepo;
        this.libraryService = libraryService;
        this.bookService = bookService;
        this.customerService = customerService;
    }

    public List<Order> findAll() {
        return orderRepo.findAllByDeletedAtIsNull();
    }

    public Order add(Order order) {
        if (order.getLibrary().getId() == null) {
            System.out.println("no id");
            return order;
        } else {
            Library library = libraryService.findId(order.getLibrary().getId());
            order.setLibrary(library);
        }
        if (order.getBook().getId() == null) {
            System.out.println("no id");
            return order;
        } else {
            Book book = bookService.findId(order.getBook().getId());
            order.setBook(book);
        }
        if (order.getCustomer().getId() == null) {
            System.out.println("no id");
            return order;
        } else {
            Customer customer = customerService.findId(order.getCustomer().getId());
            order.setCustomer(customer);
        }
        orderRepo.save(order);
        return order;
    }

    public Order findId(Long id) {
        return orderRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Order update(Order order) {
        Order orderBase = findId(order.getId());
        if (order.getLibrary().getId() == null) {
            System.out.println("not updated");
            return order;
        } else {
            Library library = libraryService.findId(order.getLibrary().getId());
            orderBase.setLibrary(library);
        }
        if (order.getBook().getId() == null) {
            System.out.println("not updated");
            return order;
        } else {
            Book book = bookService.findId(order.getBook().getId());
            orderBase.setBook(book);
        }
        if (order.getCustomer().getId() == null) {
            System.out.println("not updated");
            return order;
        } else {
            Customer customer = customerService.findId(order.getCustomer().getId());
            orderBase.setCustomer(customer);
        }
        orderRepo.save(orderBase);
        return orderBase;
    }

    public void delete(Long id) {
        Order order = orderRepo.findByIdAndDeletedAtIsNull(id);
        Date date = new Date();
        order.setDeletedAt(date);
        orderRepo.save(order);
    }

    public Order add_v2(Order order) throws ServiceException {
        if (order.getLibrary().getId() == null) {
            throw ServiceException
                    .builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("no such book id")
                    .build();
        } else {
            Library library = libraryService.findId(order.getLibrary().getId());
            order.setLibrary(library);
        }
        if (order.getBook().getId() == null) {
            throw ServiceException
                    .builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("no such book id")
                    .build();
        } else {
            Book book = bookService.findId(order.getBook().getId());
            order.setBook(book);
        }
        if (order.getCustomer().getId() == null) {
            throw ServiceException
                    .builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("no such book id")
                    .build();
        } else {
            Customer customer = customerService.findId(order.getCustomer().getId());
            order.setCustomer(customer);
        }
        Date date = new Date();
        order.setDate(date);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_YEAR, 30);
        Date passingDate = c1.getTime();
        order.setPassingDate(passingDate);
        orderRepo.save(order);
        return order;
    }

    public Order update_v2(Long id) {
        Order order = orderRepo.findByIdAndDeletedAtIsNull(id);
        Date passedDate = new Date();
        order.setPassedDate(passedDate);
        orderRepo.save(order);
        return order;
    }

    public Order add_v3(Order order) throws ServiceException {
//        if (order.getLibrary().getId() == null) {
//            throw ServiceException
//                    .builder()
//                    .errorCode(ErrorCode.SYSTEM_ERROR)
//                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .message("no such library id")
//                    .build();
//        } else {
//            Library library = libraryService.findId(order.getLibrary().getId());
//            order.setLibrary(library);
//        }
        if (order.getBook().getId() == null) {
            throw ServiceException
                    .builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("no such book id")
                    .build();
        } else {
            Book book = bookService.findId(order.getBook().getId());
            order.setBook(book);
            order.setLibrary(book.getLibrary());
        }
        if (order.getCustomer().getId() == null) {
            throw ServiceException
                    .builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("no such customer id")
                    .build();
        } else {
            Customer customer = customerService.findId(order.getCustomer().getId());
            order.setCustomer(customer);
        }

        List<Order> orders = orderRepo.findByBookIdAndDeletedAtIsNull(order.getBook().getId());
        boolean isPassed = true;
        for(Order order1: orders){
            if(order1.getPassedDate() == null){
                isPassed = false;
            }
        }

        if(isPassed){
            Date date = new Date();
            order.setDate(date);
            Calendar c1 = Calendar.getInstance();
            c1.add(Calendar.DAY_OF_YEAR, 30);
            Date passingDate = c1.getTime();
            order.setPassingDate(passingDate);
            orderRepo.save(order);
        }else {
            throw ServiceException
                    .builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("this book is not available")
                    .build();
        }
        return order;
    }
}


