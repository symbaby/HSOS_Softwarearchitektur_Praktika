package de.hsos.ordermanagement.control;

import de.hsos.ordermanagement.gateway.OrderRepository;
import de.hsos.ordermanagement.utils.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;

@ApplicationScoped
public class OrderService implements IOrderCrud{


    @Inject
    EntityManager entityManager;

    @Inject
    OrderRepository orderRepository;

    @Inject
    public OrderService(){
        this.orderRepository = new OrderRepository(entityManager);
    }

    @Override
    public Collection<GetAllOrderDTO> getAllOrders() {
        return this.orderRepository.getAllOrders();
    }

    @Override
    public GetOrderDTO getOrder(Integer id) {
        return this.orderRepository.getOrder(id);
    }

    @Override
    public boolean createOrder(PostOrderWithIdDTO postOrderWithIdDTO) {
        return this.orderRepository.createOrder(postOrderWithIdDTO);
    }

    @Override
    public boolean updateOrder(Integer id, UpdateOrderDTO updateOrderDTO) {
        return this.orderRepository.updateOrder(id, updateOrderDTO);
    }

    @Override
    public boolean deleteOrder(Integer id) {
        return this.orderRepository.deleteOrder(id);
    }
}
