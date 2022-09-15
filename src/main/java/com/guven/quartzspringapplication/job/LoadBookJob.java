package com.guven.quartzspringapplication.job;

import com.guven.quartzspringapplication.model.Book;
import com.guven.quartzspringapplication.repo.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@Slf4j
public class LoadBookJob implements Job {
     final BookRepository bookRepository;

     public LoadBookJob(BookRepository bookRepository){
         this.bookRepository = bookRepository;
     }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

         int booksCounter = bookRepository.getBookCount() +1 ;

         log.info("Add book number {} ", booksCounter);

         bookRepository.addBook(new Book(UUID.randomUUID(),
                 "name" + booksCounter,
                 "description" +booksCounter,
                 "author" +booksCounter,
                 BigDecimal.valueOf(booksCounter +100))
                 );
    }
}
