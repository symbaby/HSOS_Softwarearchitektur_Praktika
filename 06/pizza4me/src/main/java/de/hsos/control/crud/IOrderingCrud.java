package de.hsos.control.crud;

import de.hsos.shared.dto.DeleteOrderPositionDTO;
import de.hsos.shared.dto.OrderPositionDTO;
import de.hsos.shared.dto.OrderingGetDTO;

public interface IOrderingCrud {

    OrderingGetDTO getOrder(Long id);

    OrderingGetDTO getCurrentOrder(Long customerId);

    boolean createOrderPosition(Long id, OrderPositionDTO orderPositionDTO);

    boolean updateOrderPosition(Long id, OrderPositionDTO orderPositionDTO);

    boolean deleteOrderPosition(Long id, DeleteOrderPositionDTO deleteOrderPositionDTO);

    boolean submitOrder(Long id);
}
