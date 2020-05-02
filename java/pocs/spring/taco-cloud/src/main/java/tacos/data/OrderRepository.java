package tacos.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tacos.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

  List<Order> findByZip(String deliveryZip);

  List<Order> readOrdersByZipAndPlacedAtBetween(String deliveryZip,
      Date startDate, Date endDate);

  // List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(
  //     String deliveryTo, String deliveryCity);

  //List<Order> findByDeliveryCityOrderByDeliveryTo(String city);

  // @Query("Order o where o.city='Seattle'")
  // List<Order> readOrdersDeliveredInSeattle();

}
