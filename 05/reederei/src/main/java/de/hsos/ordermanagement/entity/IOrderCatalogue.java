package de.hsos.ordermanagement.entity;

import de.hsos.ordermanagement.utils.dto.*;

import java.util.Collection;

public interface IOrderCatalogue {

    Collection<GetAllOrderDTO> getAllOrders();

    GetOrderDTO getOrder(Integer id);

    boolean createOrder(PostOrderWithIdDTO postOrderWithIdDTO);

    boolean updateOrder(Integer id, UpdateOrderDTO updateOrderDTO);

    boolean deleteOrder(Integer id);

}
