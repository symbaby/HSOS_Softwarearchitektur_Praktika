package de.hsos.ordermanagement.control;

import de.hsos.ordermanagement.utils.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class OrderManagement implements IOrderCrud {

    @Inject
    OrderService orderService;

    public OrderManagement(){}

    @Override
    public Collection<GetAllOrderDTO> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @Override
    public GetOrderDTO getOrder(Integer id) {
        return this.orderService.getOrder(id);
    }

    @Override
    public boolean createOrder(PostOrderWithIdDTO postOrderWithIdDTO) {
        return this.orderService.createOrder(postOrderWithIdDTO);
    }

    @Override
    public boolean updateOrder(Integer id, UpdateOrderDTO updateOrderDTO) {
        return this.orderService.updateOrder(id, updateOrderDTO);
    }

    @Override
    public boolean deleteOrder(Integer id) {
        return this.orderService.deleteOrder(id);
    }
}
