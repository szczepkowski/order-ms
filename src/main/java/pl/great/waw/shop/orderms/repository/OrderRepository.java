package pl.great.waw.shop.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.great.waw.shop.orderms.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository <Order, String> {
}
