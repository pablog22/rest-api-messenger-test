package ar.com.pg22.test.messenger.database.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.pg22.test.messenger.model.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long>{

}
